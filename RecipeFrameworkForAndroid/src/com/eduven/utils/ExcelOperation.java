package com.eduven.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.eduven.constants.DataConstants;


public class ExcelOperation {

	
	/* Global Variable Declaration */
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static int row_count = 0;
	static int cell_count = 0;
	static String file_location = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/RecipeFrameworkForAndroid/Testexcel.xlsx";

	
	/**
	 * This method is used to get excel sheet data.
	 * @return ArrayList as excel sheet data.
	 */
	public static ArrayList<Object> getSheetDataValues(){
		ArrayList<Object> list_data = new ArrayList<Object>();
		try {
			FileInputStream file = new FileInputStream(new File(file_location));
			workbook = new XSSFWorkbook(file);
			if (DataConstants.appName.equalsIgnoreCase("healthy soups")){
				sheet = workbook.getSheetAt(0);
			}
			else if (DataConstants.appName.contains("recipes")){
				sheet = workbook.getSheetAt(1);
			}
			else if (DataConstants.appName.equalsIgnoreCase("meat lovers")){
				sheet = workbook.getSheetAt(2);
			}
			else if (DataConstants.appName.equalsIgnoreCase("seafood recipes")){
				sheet = workbook.getSheetAt(3);
			}
			else if (DataConstants.appName.equalsIgnoreCase("vegetarian")){
				sheet = workbook.getSheetAt(4);
			}
			else if (DataConstants.appName.equalsIgnoreCase("vegan")){
				sheet = workbook.getSheetAt(5);
			}
			else if (DataConstants.appName.equalsIgnoreCase("poultry")){
				sheet = workbook.getSheetAt(6);
			}
			else if (DataConstants.appName.equalsIgnoreCase("vegetarian")){
				sheet = workbook.getSheetAt(7);
			}
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
	}

}
