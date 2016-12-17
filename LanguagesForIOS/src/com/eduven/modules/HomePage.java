package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class HomePage {
	
	
	/* Object Identification */
	public static By appNameTxt = By.id("AppName");
	public static By searchBtn = By.id("search");
	public static By evMenuBtn = By.id("neweduventurelogo");

	/**
	 * This method is used to get the app name.
	 * @return : String as app name.
	 */
	public static String getAppName(){
		String app_name = "";
		try{
			app_name = Reusables.getText(Reusables.getElement(appNameTxt));
			System.out.println("App Name.."+app_name);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the app name. "+e.getClass().getName());
		}
		
		return app_name;
	}
	
	/**
	 * This method is used to verify App Name.
	 * @param expectedAppName : String type, for matching.
	 */
	public static void verifyAppName(String expectedAppName){
		try{
			Reusables.verifyEqualMessage(getAppName(), expectedAppName, "Error Message!! Actual App Name not matched with Expected app name.");
		}catch(NoSuchElementException e){
			Logs.error("App Name Not Matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Search.
	 */
	public static void verifySearchBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(searchBtn), "Error Message!! Search Button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Search Button Not Found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EvMenu Button.
	 */
	public static void verifyEvMenuBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found.");
		}catch(NoSuchElementException e){
			Logs.error("EvMenu Button Not Found. "+e.getClass().getName());
		}
	}
}
