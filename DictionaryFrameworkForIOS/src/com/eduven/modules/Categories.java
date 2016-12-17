package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Categories {
	

	/* Object Identification */
	public static By categoryPageHeaderTxt = By.id("Category_Header");
	public static By categoryList = By.id("category_name");
	public static By selectFirstCategory = By.id("category_name");
	public static By subCategoryHeaderTxt = By.id("Terms_Header");
	
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, Category instance.
	 */
	public static IOSElement categoryInstance(){
		IOSElement cat_element = null;
		try{
			cat_element = Reusables.getIOSElement(HomePage.categoryBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Category Icon not found. "+e.getClass().getName());
		}
		
		return cat_element;
	}
	
	/**
	 * This method is used to click on the Category Icon .
	 */
	public static void navigateToCategoryPage(){
		try{
			Reusables.clickUsingIOSElement(categoryInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on Category Icon. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyCategoryPageLoaded(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(categoryPageHeaderTxt).trim(), DataConstants.categoryHeaderTxt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..Category Page "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Category header Text.
	 */
	public static void verifyCategoryList(){
		List<IOSElement> categorylist;
		List<String> dbList;
		String categoryName = "";
		try{
			dbList = DatabaseConnection.getMainCategories();
			categorylist = Reusables.getIOSElementsList(categoryList);
			for (int i = 0; i < dbList.size(); i++){
				categoryName = categorylist.get(i).getText().trim();
				Reusables.verifyEqualMessage(dbList.get(i), categoryName, "Error Message!Actual & Expected term not matched.");
				Logs.info("Category Name "+categoryName+" Found.");
				categorylist.get(i).click();
				Reusables.waitThread(1);
				Reusables.verifyElementTextPresent(subCategoryHeaderTxt, dbList.get(i));
				Reusables.oneStepBack();
				Reusables.waitThread(1);
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Category Name not found."+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to click on the random category on category page.
	 * @return : Return random category name, Type String.
	 */
	public static String clickOnRandomCategory(){
		String categoryName = "";
		List<IOSElement> categorylist;
		try {
			Reusables.waitThread(1);
			categoryName = DatabaseConnection.randomCategoryName();
			System.out.println("Category Name.. "+categoryName);
			categorylist = Reusables.getIOSElementsList(categoryList);
			for (int i = 0; i < categorylist.size(); i++){
				if (categorylist.get(i).getText().trim().equalsIgnoreCase(categoryName)){
					categorylist.get(i).click();
					Reusables.waitThread(2);
					break;
				}
			}
			Reusables.hideInterstitial();
			Reusables.verifyEqualMessage(Reusables.getText(subCategoryHeaderTxt), categoryName, "Error Message!!Sub Category Page not load. ");
		} catch (Exception e) {
			Logs.error("Categories name "+categoryName+" not Found. "+e.getClass().getName());
		}
		
		return categoryName;
	}
	
	/**
	 * This method is used to click on the First category.
	 */
	public static String clickOnFirstCategory(){
		String categoryName = "";
		List<IOSElement> categorylist;
		try{
			categorylist = Reusables.getIOSElementsList(selectFirstCategory);
			categoryName = categorylist.get(0).getText();
			Reusables.clickUsingIOSElement(categorylist.get(0));
		}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on First category from given list "+e.getClass().getName());
		}
		
		return categoryName;
	}
	
	/**
	 * This method is used to verify First Select category page loaded.
	 */
	public static void verifyFirstSelectedCategoryPageLoaded(String firstCategoryName){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(subCategoryHeaderTxt), firstCategoryName, "Error Message!! Selected category page header text not Found");
		}
		catch(NoSuchElementException e){
			Logs.error("Selected category page not loaded.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to back to the category page.
	 */
	public static void backToCategoryPage(){
		try{
			while (Reusables.isElementPresent(categoryPageHeaderTxt) == false){
				Reusables.oneStepBack();
				Reusables.hideInterstitial();
			}
		}catch(NoSuchElementException e){
			Logs.error("Category page not found. "+e.getClass().getName());
		}
	}
}
