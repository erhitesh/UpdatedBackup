package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class HomePage {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By appNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/title_text");
	public static By searchBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/action_search");
	public static By evMenuBtn = By.xpath("//*[@content-desc='More options']");

	/**
	 * This method is used to get the app name.
	 * @return : String as app name.
	 */
	public static String getAppName(){
		String app_name = "";
		try{
			app_name = Reusables.getText(Reusables.getElement(appNameTxt));
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
			Logs.error("Search Button Not Matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EvMenu Button.
	 */
	public static void verifyEvMenuBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found.");
		}catch(NoSuchElementException e){
			Logs.error("EvMenu Button Not Matched. "+e.getClass().getName());
		}
	}
}
