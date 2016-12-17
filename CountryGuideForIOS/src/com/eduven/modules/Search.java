package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Search {
	
	/* IOSDriver Instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Object Identification */
	public static By searchTxtBox = By.xpath("//UIASearchBar");
	public static By elementCount = By.name("TermName");
	public static By clearSearchBox = By.name("Clear text");
	public static By subcat = By.name("SubCategoryHeader");
	
	
	/**
	 * This method is used to search the word and verify either search word visible or not.
	 */
	public static void searchWord(String searchWord){
		try{
			Reusables.enterMessageInTextBox(searchTxtBox, searchWord);
			Reusables.hideKeyboard("done");
		}catch(NoSuchElementException e){
			Logs.error("Search Text Box not found. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to search the word and verify either search word visible or not.
	 */
	public static void verifySearchWord(String searchWord){
		try{
			Reusables.verifyEqualMessage(Reusables.getElementsList(elementCount).get(0).getText().toString(), searchWord, "Error Message!!Search Term not matched with search one.");
		}catch(NoSuchElementException e){
			Logs.error("Search Term not found and match. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify either search element present or not.
	 * @param elenemtName
	 */
	public static void verifyElementPresent(String elenemtName){
		String txt = Reusables.getElement(subcat).getText().toString();
		//System.out.println("Header text"+txt);
		if (txt.contains(elenemtName)){
			Reusables.verifyElementPresent(Reusables.getElement(subcat), "Error Message!! SubCategory Name not found.");
		}
	}
	
	/**
	 * This method is used to clear search text box.
	 */
	public static void clearTextBox(){
		Reusables.clickCommand(clearSearchBox);
		Reusables.waitThread(1);
	}
}
