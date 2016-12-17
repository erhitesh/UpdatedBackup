package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class HomePage {
	
	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator identification */
	public static By homeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/homeButton");
	public static By app_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_Title");
	public static By home_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By ev_menu_btn = By.className("android.widget.ImageView");
	public static By categories = By.id(DeviceRelatedInformation.getPackageName()+":id/catView");
	public static By eduBank = By.id(DeviceRelatedInformation.getPackageName()+":id/favView");
	public static By cities = By.id(DeviceRelatedInformation.getPackageName()+":id/cityView");
	
	/**
	 * This method is used to get the app name.
	 * @return : String type as app name.
	 */
	public static String appName(){
		String app_name = "";
		try{
			app_name = Reusables.getText(app_header_txt);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> App Name not found. "+e.getClass().getName());
		}
		
		return app_name;
	}
	
	/**
	 * This method is used to verify app name.
	 */
	public static void verifyAppHeaderTxt(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(app_header_txt), DataConstants.app_header_txt, "App Header Message Does not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(" App Header Text message not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify the Home Page text.
	 */
	public static void verifyHomePageHeaderTxt(){
		try{
		Reusables.verifyEqualMessage(Reusables.getText(home_page_header_txt), DataConstants.home_page_header_txt, "Error Message! text value does not match.");
		}
		catch(NoSuchElementException e){
			Logs.error("Home page header txt not found... "+Reusables.getText(home_page_header_txt));
		}
	}
	
	
	/**
	 * This method is used to verify EduBank Logo present or not.
	 */
	public static void verfiyEduBankIconPresent(){
		try{
			Reusables.waitForElement(eduBank);
			AndroidElement element = driver.findElement(eduBank);
			Reusables.verifyElementPresent(element, "Error Message! Edu Bank icon not present.");
		}
		catch(NoSuchElementException e){
			Logs.error(" EduBank Logo not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify EV menu present or not.
	 */
	public static void verfiyEvMenuLogoPresent(){
		try{
			Reusables.waitForElement(ev_menu_btn);
			AndroidElement element = driver.findElement(ev_menu_btn);
			Reusables.verifyElementPresent(element, "Error Message ev menu logo not present.");
		}
		catch(NoSuchElementException e){
			Logs.error("EV Menu not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EvMenu button.
	 */
	public static void clickOnEvMenu(){
		try{
			Reusables.clickCommand(ev_menu_btn);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>> Click operation not perform. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify either category element present or not. 
	 */
	public static void verfiyCategoryIconPresent(){
		try{
			Reusables.waitForElement(categories);
			AndroidElement category_element = driver.findElement(categories);
			Reusables.verifyElementPresent(category_element, "Error Message! category icon not displayed.");	
		}
		catch(NoSuchElementException e){
			Logs.error("categories icon not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either cities element present or not. 
	 */
	public static void verifyCitiesIconPresent(){
		AndroidElement element = null;
		try{
			Reusables.waitThread(3);
			element = driver.findElement(cities);
			Reusables.verifyElementPresent(element, "Error Message! cities icon not displayed.");
		}
		catch(NoSuchElementException e){
			Logs.error("cities name "+element.toString()+" not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to home page.
	 */
	public static void navigateToHomePage(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(homeBtn));
			Reusables.clickUsingElement(Reusables.getElement(homeBtn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Home Button not found. "+e.getClass().getName());
		}
	}
}
