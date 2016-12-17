package com.eduven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelOperation {

	
	/* Global Variable Declaration */
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static int rowCount = 0;
	static int cellCount = 0;

	static String fileLocation = "/Users/hiteshbhardwaj/Desktop/automation/workspace/DictionaryFrameworkForIOS/Testexcel.xlsx";


	public static ArrayList<Object> getSheetDataValues(){
		ArrayList<Object> listData = new ArrayList<Object>();
		
		try {
			FileInputStream file = new FileInputStream(new File(fileLocation));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			rowCount = sheet.getLastRowNum();
	
			for (int i = 1; i <= rowCount; i++){
				ArrayList<Object> sheetValues = new ArrayList<Object>();
				 row = sheet.getRow(i);
				 cellCount = row.getLastCellNum();
				for (int j = 0; j < cellCount; j++){
					sheetValues.add(sheet.getRow(i).getCell(j).getStringCellValue());
					}
				listData.add(sheetValues);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			}
		return listData;
	}
	
	public static void main(String args[]) {
		for ( int i = 0; i < getSheetDataValues().size(); i++){
			System.out.println("Sheet Value..."+getSheetDataValues().get(i));
		}
	}

}
