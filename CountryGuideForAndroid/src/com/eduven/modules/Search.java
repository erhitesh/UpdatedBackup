package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Search {
	
	/* IOSDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By searchTxtBox = By.id(DeviceRelatedInformation.getPackageName()+":id/searchView");
	public static By findTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	public static By subcatNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	
	/**
	 * This method is used to search the word and verify either search word visible or not.
	 */
	public static void searchWord(String searchWord){
		try{
			Reusables.enterMessageInTextBox(searchTxtBox, searchWord);
			}
		catch(NoSuchElementException e){
			Logs.error("Search Text Box not found. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to search the word and verify either search word visible or not.
	 */
	public static void verifySearchWord(String searchWord){
		try{
			Reusables.verifyEqualMessage(Reusables.getElementsList(findTxt).get(0).getText(), searchWord, "Error Message!!Search Term not matched with search one.");
			}
		catch(NoSuchElementException e){
			Logs.error("Search Term not found and match. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Category element present or not.
	 * @param elenemtName : String.
	 */
	public static void verifyElementPresent(String elenemtName){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(subcatNameTxt), "Error Message!! SubCategory Name not found found.");
			}
		catch(NoSuchElementException e){
			Logs.error("Sub Category name not found. "+e.getClass().getName());
			}
		}
	}
