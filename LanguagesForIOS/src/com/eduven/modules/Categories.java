package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Categories {
	
	
	/* Object Identification */
	public static By categoryHeaderTxt = By.id("CategoryHeader");
	public static By categoryList = By.id("CategoryList");
	public static By categoryTermCount = By.id("CategoryWordCount");
	
	/**
	 * This method is used to verify category header text.
	 */
	public static void verifyCategoryHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(categoryHeaderTxt), "Error Message!! Category Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Category Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get category values and hold it in a list.
	 * @param languageName : String type, 
	 * @return : List as categories values.
	 */
	public static List<String> getCategoryList(String languageName){
		List<String> category_list = new ArrayList<String>();
		try{
			category_list = DatabaseConnection.getMainCategories(languageName);
		}catch(NoSuchElementException e){
			Logs.error("Category List not found. "+e.getClass().getName());
		}

		return category_list;
	}
	
	
	/**
	 * This method is used to get get term count value.
	 * @param mainCategoryName : category name for get count value. 
	 * @return : integer.
	 */
	public static int dataTermCount(String mainCategoryName){
		int term_count = 0;
		try{
			term_count = DatabaseConnection.getTermList(mainCategoryName, LanguageCategoryPage.languageSelectionValue).size();
		}catch(NoSuchElementException e){
			Logs.error("Term count not found. "+e.getClass().getName());
		}
		
		return term_count;
	}
	
	
	/**
	 * This method is used to get get term count value as ArrayList.
	 * @param categorylist : ArrayList value for 
	 * @return : ArrayList of int type.
	 */
	public static ArrayList<Integer> dataTermCountList(List<String> categorylist){
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			for (int i = 0; i < categorylist.size(); i++){
				list.add(DatabaseConnection.getTermList(categorylist.get(i), "english"/*LanguageCategoryPage.languageSelectionValue*/).size());
			}
		}catch(NoSuchElementException e){
			Logs.error("Term count not found. "+e.getClass().getName());
		}
		System.out.println("Added Term count Array.."+list);
		return list;
	}
	
	/**
	 * This method is used to verify categories name and term count inside category name.
	 * @param key_type_id_for_language : for language.
	 */
	public static void verifyCategoryListAndTermCount(List<String> dataCategoryListValues){
		String dataCategoryName = "";
		int dataTermCount = 0;
		List<IOSElement> category_name_list;
		List<IOSElement> category_term_count;
		//List<IOSElement> listData;
		try{
			Reusables.waitThread(5);
			List<String> dataCatList = dataCategoryListValues;
			for (int i = 0; i < dataCatList.size(); i++){
				/* Data From DataBase */
				dataCategoryName = dataCatList.get(i);
				dataTermCount = dataTermCount(dataCategoryName);
				/* Category name list */
				category_name_list = Reusables.getElementsList(categoryList); 
				/* Category term count */
				category_term_count = Reusables.getElementsList(categoryTermCount);
				//listData = Reusables.getElementsList(categoryList);
				/* Verify category name */
				//System.out.println(category_name_list.get(i).getText()+"<<<<<------ category name ------>>>>>>>"+dataCategoryName);
				Reusables.verifyEqualMessage(category_name_list.get(i).getText(), dataCategoryName, "Error Message!! Actual and expected category name not matched.");
				Reusables.waitThread(1);
				/* Verify term count */
				//System.out.println(category_term_count.get(i).getText().toString()+"<<<------ category term count ------>>"+Integer.toString(dataTermCount));
				Reusables.verifyEqualMessage(category_term_count.get(i).getText().toString(), Integer.toString(dataTermCount), "Error Message!! Actual and Expected category term count not matched.");
				/* Click on category  */
				//Reusables.clickUsingElement(listData.get(i));
				/*Verify category name and term header name */ 
				//TermList.verifyTermListHeaderTxt(dataCategoryName);
				//Reusables.stepBack();
			}
		}catch(NoSuchElementException e){
			Logs.error("Category name and count not matched with actual one. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the random number 
	 * @return : String, as random name.
	 */
	public static String clickOnRandomCategory(){
		String randomName = "";
		int randomNumber = 0;
		try{
			Reusables.waitThread(5);
			List<String> dbList = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue);
		    randomNumber = Reusables.randomNumber(dbList.size());
		    randomName = dbList.get(randomNumber);
		    //System.out.println("Main Category Name..>"+randomName);
			List<IOSElement> mainCatList = Reusables.getElementsList(categoryList);
			for (int i = 0; i < mainCatList.size(); i++){
				if (mainCatList.get(i).getText().equalsIgnoreCase(randomName) == true){
					Reusables.waitThread(1);
					mainCatList.get(i).click();
					Reusables.waitThread(2);
					break;
				}
			}
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on random name. "+e.getClass().getName());
		}
		
		return randomName;
	}
	
	
	/**
	 * This method is used to verify particular category on category page.
	 * @param categoryName : String type categoryName for comparison.
	 */
	public static void verifySpecificCategory(String categoryName){
		try{
			List<IOSElement> category_list = Reusables.getElementsList(categoryList);
			for (int i = 0; i < category_list.size(); i++){
				if (category_list.get(i).equals(categoryName)){
					Reusables.verifyElementPresent(category_list.get(i), "Error Message!! Category name found.");
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Category Name found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify category list after change the base language.
	 */
	public static void verifyCategoryListAfterChangeBaseLangugae(String languageName){
		try{
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getElement(categoryHeaderTxt), "Error Message!!Category header not found.");
			String expectedFirstCategoryName = getCategoryList(languageName).get(0);
			System.out.println("Expected category..>"+expectedFirstCategoryName);
			String actualFirstCategoryName = Reusables.getElementsList(categoryList).get(0).getText();
			System.out.println("Actual category..>"+actualFirstCategoryName);
			Reusables.verifyEqualMessage(actualFirstCategoryName, expectedFirstCategoryName, "Error Message!! Actual and expected category not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected category not matched. "+e.getClass().getName());
		}
	}
}
