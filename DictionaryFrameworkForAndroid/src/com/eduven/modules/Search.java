package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Search {

	
	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By searchTxtBoxImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/action_search");
	public static By searchPageHeaderTxt = By.xpath("//android.widget.TextView[@text='Search']");
	public static By searchTxtBox = By.id(DeviceRelatedInformation.getPackageName()+":id/searching");
	public static By searchList = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By searchResultHeaderTxt = By.xpath("//android.widget.TextView[@text='Search Result']");
	
	/**
	 * This method is used to click on the Search Box Icon .
	 */
	public static void navigateToSearchBoxPage(){
		try{
			Reusables.waitForElement(searchTxtBox);
			Reusables.clickCommand(searchTxtBox);
			Reusables.waitForElement(searchPageHeaderTxt);
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on Search Box>> "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify search page not found. 
	 */
	public static void verifySearchPageHeaderTxt(){
		try{
			Reusables.waitForElement(searchPageHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Search Page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to seach term.
	 */
	public static String searchTerm(){
		String randomCategoryName = "";
		String termName = "";
		List<AndroidElement> searchTermList;
		try{
			randomCategoryName = DatabaseConnection.randomCategoryName();
			termName = DatabaseConnection.getUnLockTerm(randomCategoryName);
			Reusables.enterMessageInTextBox(searchTxtBox, termName);
			searchTermList = Reusables.getElementsList(searchList);
			for (int i = 0; i < searchTermList.size(); i++){
				if (searchTermList.get(i).getText().trim().toString().equalsIgnoreCase(termName)){
					searchTermList.get(i).click();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name not found. "+e.getClass().getName());
		}
		
		return termName;
	}
	
	/**
	 * This method is used to verify term name on term detail page.
	 */
	public static void verifySearchResultHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(searchResultHeaderTxt), "Error Message!!Element not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Element not found. "+e.getClass().getName());
		}
	}
}
