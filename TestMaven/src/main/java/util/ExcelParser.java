package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import nlp.TestParser;


public class ExcelParser {

	private static Workbook workbook = null;
	private HashMap<String, List<String>> stdWordMap = new HashMap<String, List<String>>();
	
	public void analyzeExcel(String path){
		if(path == null){
			System.err.println("Xlsx file path is null");
			return;
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
		
		Sheet content = workbook.getSheetAt(0);
		int firstRowNumber = content.getFirstRowNum();
		int lastRowNumber = content.getLastRowNum();
		for(int i = firstRowNumber; i < lastRowNumber + 1; i++){
			Row row = content.getRow(i);
			short firstCellNum = row.getFirstCellNum();
			short lastCellNum = row.getLastCellNum();
			List<String> list = null;
			for(short j = firstCellNum; j < lastCellNum; j++){
				Cell cell = row.getCell(j);
				if(cell == null){
					continue;
				}
				String cellVal = getCellValue(cell);
				if(cellVal == null || cellVal.isEmpty()){
					continue;
				}
				
				
				// first col
				if(j == firstCellNum){
					list = new LinkedList<String>();
					stdWordMap.put(cellVal, list);
				}else{
					list.add(cellVal);
				}
				
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
		
		if(cellVal == null){
			return null;
		}
		
		return cellVal.trim();
	}
	
	public HashMap<String, List<String>> getStdWordMap() {
		return stdWordMap;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		URL url = TestParser.class.getClassLoader().getResource("stdword.xlsx");
		ExcelParser ep = new ExcelParser();
		ep.analyzeExcel(url.getFile());
		HashMap<String, List<String>> map = ep.getStdWordMap();
		for(Map.Entry<String, List<String>> mapEntry: map.entrySet()){
			System.out.println(mapEntry);
		}
	}

}
