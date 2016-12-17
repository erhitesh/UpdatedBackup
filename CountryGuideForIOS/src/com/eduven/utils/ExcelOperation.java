package com.eduven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelOperation {

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static int row_count = 0;
	static int cell_count = 0;

	static String file_location = "/Users/hiteshbhardwaj/Desktop/automation/workspace/CountryGuideForIOS/Testexcel.xlsx";


	public static ArrayList<Object> getSheetDataValues(){
		ArrayList<Object> list_data = new ArrayList<Object>();
		
		try {
			FileInputStream file = new FileInputStream(new File(file_location));
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheetAt(0);
			row_count = sheet.getLastRowNum();
	
			for (int i = 1; i <= row_count; i++){
				ArrayList<Object> sheet_values = new ArrayList<Object>();
				 row = sheet.getRow(i);
				 cell_count = row.getLastCellNum();
				for (int j = 0; j < cell_count; j++){
					sheet_values.add(sheet.getRow(i).getCell(j).getStringCellValue());
					}
				list_data.add(sheet_values);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			}
		return list_data;
	}
	
	public static void main(String args[]) {
		
		for ( int i = 0; i < getSheetDataValues().size(); i++){
			System.out.println("Sheet Value..."+getSheetDataValues().get(i));
		}
		
		/*ArrayList<Object> alldata = getSheetDataValues();
	
		for (int i = 0; i < alldata.size(); i++){
			@SuppressWarnings("unchecked")
			ArrayList<Object> colsdata=(ArrayList<Object>) alldata.get(i);
			for(int k=0;k<colsdata.size();k++)
			{
				System.out.println("cols daa"+colsdata.get(k).toString());
				//System.out.println("============================"); 
			}*/
		
	}

}
