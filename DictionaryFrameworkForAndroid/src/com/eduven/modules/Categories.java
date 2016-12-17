package com.eduven.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Categories {
	
	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By categoryIcon = By.id(DeviceRelatedInformation.getPackageName()+":id/cat_box");
	public static By categoryPageHeaderTxt = By.name(DataConstants.categoryHeaderTxt);
	public static By categoriesList = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By premiumTermPopup = By.id("android:id/button1");
	public static By firstCategory = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Category instance.
	 */
	public static AndroidElement categoryInstance(){
		AndroidElement cat_element = null;
		try{
			cat_element = Reusables.getElement(categoryIcon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>Category Icon not found. "+e.getClass().getName());
		}
		
		return cat_element;
	}
	
	/**
	 * This method is used to click on the Category Icon .
	 */
	public static void navigateToCategoryPage(){
		try{
			Reusables.waitForElement(categoryIcon);
			Reusables.clickUsingElement(categoryInstance());
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>Click Operation not perform on Category Icon. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyCategoryPageLoaded(){
		try{
			Reusables.waitForElement(categoryPageHeaderTxt);
			Reusables.verifyEqualMessage(Reusables.getText(categoryPageHeaderTxt), DataConstants.categoryHeaderTxt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page..Category Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to handle the Unlock Premium Entities Pop Up. 
	 */
	public static void handlePremiumEntityPopUp(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(premiumTermPopup) == true){
				Reusables.clickUsingElement(Reusables.getElement(premiumTermPopup));
			}
			else if (Reusables.isElementPresent(By.name(DataConstants.appName)) == true) {
				Reusables.verifyElementPresent(Reusables.getElement(By.name(DataConstants.appName)), "Error Message!! App name not found...");
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> Premium Entity PopUp not found...."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify category header txt.
	 */
	public static void verifyCategoryTermHeaderText(){
			AndroidElement element = null;
			String categoryName = "";
			List<String> categoryList;
			try{
				Reusables.waitThread(4);
				categoryList = DatabaseConnection.getMainCategories();
				for (int i = 0; i < categoryList.size(); i++){
					categoryName = categoryList.get(i);
					if (Reusables.isElementPresent(By.name(categoryName)) == false){
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}
					element = Reusables.getElement(By.name(categoryName));
					System.out.println("Term name.."+element.getAttribute("name").trim().toString());
					Reusables.waitForAndroidElement(element);
					element.click();
					Reusables.waitThread(1);
	                handlePremiumEntityPopUp();
	                Reusables.hideInterstetial();
	                Reusables.waitForAndroidElement(element);
	                Reusables.stepBack();
	                Reusables.hideInterstetial();
	                Reusables.waitThread(1);
	                Logs.info("Category Name. "+element.getAttribute("name").toString()+" Found.");
	                }
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Category Term Header Text not found. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to click on the random category on category page.
	 * @return : Return random category name, Type String.
	 */
	public static String clickOnRandomCategory(){
		String randomCategoryName = "";
		List<String> categoryList;
		try {
			categoryList = DatabaseConnection.getMainCategories();
			randomCategoryName = categoryList.get(Reusables.randomNumber(categoryList.size()));
			while (Reusables.isElementPresent(By.name(randomCategoryName)) == false){
				Reusables.swipeUp();
				Reusables.waitThread(1);
			}
			Reusables.waitForElement(By.name(randomCategoryName));
			Reusables.clickCommand(By.name(randomCategoryName));
			Reusables.waitThread(1);
			handlePremiumEntityPopUp();
			Reusables.waitThread(1);
			Reusables.hideInterstetial();
			Reusables.waitThread(1);
			} 
		catch (NoSuchElementException e) {
			Logs.error(">>>>>>>>>>>>>>> Random Categories name "+randomCategoryName+" not Found.."+e.getClass().getName());
			}
		System.out.println("Main Category Name.."+randomCategoryName);
		return randomCategoryName;
	}
	
	/**
	 * This method is used to click on the First category.
	 */
	public static String clickOnFirstCategory(){
		String first_category_name = "";
		try{
			List<AndroidElement> list_element = Reusables.getElementsList(firstCategory);
			first_category_name = list_element.get(0).getText();
			System.out.println("first_category_name"+first_category_name);
			Reusables.clickUsingElement(list_element.get(0));
			handlePremiumEntityPopUp();
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>> Click operation not perform on First category from given list "+e.getClass().getName());
		}
		
		return first_category_name;
	}
	
	/**
	 * This method is used to verify First Select category page loaded.
	 */
	public static void verifyFirstSelectedCategoryPageLoaded(String firstCategoryName){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(By.name(firstCategoryName)), "Error Message!! First Selected category page header text not Found");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> First Selected category page not loaded.."+e.getClass().getName());
		}
	}
}
