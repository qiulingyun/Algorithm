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

import Model.Post;

public class ExcelParser {
	private static Workbook workbook = null;
	private static HashMap<Integer, String> col2nameMap;
	
	public static ArrayList<Post> parseXlsx(String path){
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
		
		ArrayList<Post> postList = new ArrayList<Post>();

		if(getFieldNameMapping() == false){
			return null;
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
		
		return postList;
		
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
	
	public static void main(String[] args){
		ArrayList<Post> postList = parseXlsx("G:\\PostPrediction.xlsx");
		if(postList == null){
			System.err.println("Null!");
		}
		for(Iterator iter = postList.iterator();iter.hasNext();){
			System.out.println(iter.next().toString());
		}
	}
}
