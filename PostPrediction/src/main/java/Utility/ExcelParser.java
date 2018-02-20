package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import Model.ExcelData;
import Model.Post;
import Model.TreeNode;

public class ExcelParser {
	private static Workbook workbook = null;
	private static HashMap<Integer, String> col2nameMap;
	
	public static ExcelData parseXlsx(String path){
		if(path == null){
			System.err.println("Xlsx file path is null");
			return null;
		}
		System.out.println("Xlsx file path:" + path);
		
		InputStream is = null;

		try {
			is = new FileInputStream(path);
			workbook = new XSSFWorkbook(is);
		} catch (FileNotFoundException e) {
			System.err.println("Xlsx file path not found!, path: " + path);
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		ExcelData excelData = new ExcelData();
		parseContent(excelData);
		parseTree(excelData);
		
		
		return excelData;
		
	}
	
	private static void parseContent(ExcelData excelData){
		if(excelData == null){
			return;
		}
		
		ArrayList<Post> postList = excelData.getPostList();
		if(postList == null){
			return;
		}

		if(getFieldNameMapping() == false){
			return;
		}
		
		Sheet content = workbook.getSheetAt(0);
		int firstRowNumber = content.getFirstRowNum();
		int lastRowNumber = content.getLastRowNum();
		for(int i = firstRowNumber + 1; i < lastRowNumber + 1; i++){
			Row row = content.getRow(i);
			Post post = new Post();
			if(mapRow2Model(row, post) == false){
				System.err.println("Error in index:" + (i + 1));
			}
			if(post.addPrefixZero() == false){
				continue;
			}
			postList.add(post);
		}
	}
	
	private static void parseTree(ExcelData excelData){
		if(excelData == null){
			return;
		}
		
		ArrayList<TreeNode> costCenterRootList = excelData.getCostCenterRootList();
		ArrayList<TreeNode> profitCenterRootList = excelData.getProfitCenterRootList();
		if(costCenterRootList == null || profitCenterRootList == null){
			return;
		}
		
		for(int pageNum = 1; pageNum <= 2; pageNum++){
			Sheet content = workbook.getSheetAt(pageNum);
			int firstRowNumber = content.getFirstRowNum();
			int lastRowNumber = content.getLastRowNum();
			ArrayList<CellInfo> prevRowInfo = new ArrayList<CellInfo>();
			ArrayList<CellInfo> currRowInfo = new ArrayList<CellInfo>();
			int rootNodeRowNum = 0;
			for(int i = firstRowNumber ; i < lastRowNumber + 1; i++){
				Row row = content.getRow(i);
				if(row == null){
					continue;
				}
				
				if(prevRowInfo.size() != 0){
					if(row.getRowNum() - prevRowInfo.get(0).rowIndex > 1){
						prevRowInfo.clear();
						rootNodeRowNum = row.getRowNum();
					}
				}else{
					rootNodeRowNum = row.getRowNum();
				}
				currRowInfo.clear();
				
				
				short firstCellNum = row.getFirstCellNum();
				short lastCellNum = row.getLastCellNum();
				for(short j = firstCellNum; j < lastCellNum; j++){
					Cell cell = row.getCell(j);
					if(cell == null){
						continue;
					}
					
					// create tree node
					TreeNode node = new TreeNode();
					String cellvalue = getCellValue(cell);
					if(cellvalue == null || cellvalue.isEmpty()){
						continue;
					}
					node.setName(cellvalue);
					node.setLevel(row.getRowNum() - rootNodeRowNum);
					if(prevRowInfo.size() == 0){
						switch (pageNum) {
						case 1:
							costCenterRootList.add(node);
							break;
						case 2:
							profitCenterRootList.add(node);
							break;
						default:
							break;
						}
					}else{
						for(int x = 0; x < prevRowInfo.size(); x++){
							CellInfo prevRowCellInfo = prevRowInfo.get(x);
							if(cell.getColumnIndex() >= prevRowCellInfo.colIndex && cell.getColumnIndex() < prevRowCellInfo.nextCellColIndex){
								prevRowCellInfo.node.getChildren().add(node);
								node.setParent(prevRowCellInfo.node);
								break;
							}
						}
					}
					
					//store cell info
					CellInfo cellInfo = new CellInfo(cell.getRowIndex(), cell.getColumnIndex(), Integer.MAX_VALUE);
					for(int k = 1; j + k < lastCellNum; k++){
						Cell nextCellInRow = row.getCell(j + k);
						if(nextCellInRow == null ){
							continue;
						}
						String val = getCellValue(nextCellInRow);
						if(val == null || val.isEmpty()){
							continue;
						}
						cellInfo.nextCellColIndex = nextCellInRow.getColumnIndex();
					}
					cellInfo.node = node;
					currRowInfo.add(cellInfo);
				}
				
				//prepare next line
				prevRowInfo.clear();
				prevRowInfo.addAll(currRowInfo);
				currRowInfo.clear();
			}
			
			
		}
		
	}
	
	private static String getCellValue(Cell cell){
		if(cell == null){
			return null;
		}
		String cellVal = null;
		CellType cellType = cell.getCellTypeEnum();
		switch (cellType) {
		case NUMERIC:
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				cellVal = String.valueOf(sdf.format(cell.getDateCellValue()));
			}else{
				DecimalFormat df = new DecimalFormat("0");
				cellVal = String.valueOf(df.format(cell.getNumericCellValue()));
			}
			
			break;
		case STRING:
			cellVal = cell.getStringCellValue().trim();
			break;
		case FORMULA:
			cellVal = cell.getCellFormula();
			break;
		case BOOLEAN:
			cellVal = String.valueOf(cell.getBooleanCellValue());
			break;

		default:
			break;
		}
		return cellVal.trim();
	}
	
	private static boolean mapRow2Model(Row row, Post post){
		if(row == null || post == null){
			return false;
		}
		
		short firstCellNum = row.getFirstCellNum();
		short lastCellNum = row.getLastCellNum();
		short cellNum = (short) (lastCellNum - firstCellNum);
		if(firstCellNum == -1 || lastCellNum == -1 || cellNum == 0){
			return false;
		}
		
		if(col2nameMap == null){
			return false;
		}
		
		BeanWrapper postWrapper = new BeanWrapperImpl(post);
		
		short counter = 0;
		for(short i = firstCellNum; i < lastCellNum; i++){
			Cell cell = row.getCell(i);
			if(cell == null){
				continue;
			}
			String cellVal = getCellValue(cell);
			if(cellVal == null){
				continue;
			}
			
			
			int cellIndex = cell.getColumnIndex();
			String fieldName = col2nameMap.get(cellIndex);
			if(fieldName == null || fieldName.isEmpty()){
				continue;
			}
			postWrapper.setPropertyValue(fieldName, cellVal);
			counter++;
		}
		if(counter != cellNum){
			System.err.println("Not all fields in post is correctly filled");
			return false;
		}
		
		return true;
	}
	
	private static boolean getFieldNameMapping(){
		if(workbook == null){
			System.err.println("workbook is null");
			return false;
		}
		
		col2nameMap = new HashMap<Integer, String>();
		
		Sheet content = workbook.getSheetAt(0);
		int firstRowNumber = content.getFirstRowNum();
		Row firstRow = content.getRow(firstRowNumber);
		
		short firstCellNum = firstRow.getFirstCellNum();
		short lastCellNum = firstRow.getLastCellNum();
		short cellNum = (short) (lastCellNum - firstCellNum);
		if(firstCellNum != -1 && lastCellNum != -1){
			for(short i = firstCellNum; i < lastCellNum; i++){
				Cell cell = firstRow.getCell(i);
				if(cell == null){
					continue;
				}
				col2nameMap.put(cell.getColumnIndex(), cell.getStringCellValue().trim());
				
			}
		}
		
		if(col2nameMap.size() != cellNum){
			System.err.println("Not all cell parsed!");
			return false;
		}
		
		return true;
	}
	
	private static class CellInfo{
		public int rowIndex;
		public int colIndex;
		public int nextCellColIndex;
		public TreeNode node;
		public CellInfo() {
			super();
		}
		public CellInfo(int rowIndex, int colIndex, int nextCellColIndex) {
			super();
			this.rowIndex = rowIndex;
			this.colIndex = colIndex;
			this.nextCellColIndex = nextCellColIndex;
		}
		
	}
	
	public static void main(String[] args){
		ExcelData excelData = parseXlsx("G:\\PostPrediction.xlsx");
		ArrayList<Post> postList = excelData.getPostList();
		if(postList == null){
			System.err.println("Null!");
		}
		for(Iterator iter = postList.iterator();iter.hasNext();){
			System.out.println(iter.next().toString());
		}
		
		ArrayList<TreeNode> costCenterRootList = excelData.getCostCenterRootList();
		System.out.println(TreeHelper.findByLevel(costCenterRootList.get(1), 0));
		System.out.println(TreeHelper.findByLevel(costCenterRootList.get(1), 1));
		System.out.println(TreeHelper.findByLevel(costCenterRootList.get(1), 2));
	}
}
