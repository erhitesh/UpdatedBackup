package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class HomePage {
	
	/* IOSDriver Instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	//Locator identity
	public static By appNametxt = By.xpath("//UIANavigationBar[1]/UIAStaticText[1]");
	public static By home_page_txt = By.name("Travel SMART India");
	public static By ev_menu_btn = By.name("EV icon");
	public static By categories = By.name("categories_menu.png");
	public static By eduBank = By.name("favorites_menu.png");
	public static By cities = By.name("cities_menu.png");
	public static By nearBy = By.name("NearByBtn");
	public static By homeBtn = By.name("HomeBtn");
	
	
	
	/**
	 * This method is used to get the App Name.
	 * @return : String.
	 */
	public static String getAppName(){
		String appName = "";
		try{
			appName = Reusables.getText(appNametxt);
		}
		catch(NoSuchElementException e){
			Logs.error("App Name Not found. "+e.getClass().getName());
		}
		
		return appName.toString();
	}
	
	
	
	/**
	 * This method is used to verify the Home Page text.
	 */
	public static void verifyHomePageHeaderTxt(){
		try{
		Reusables.verifyEqualMessage(getAppName(), Reusables.getText(home_page_txt), "Error Message! text value does not match.");
		}
		catch(NoSuchElementException e){
			Logs.error("Home page header txt not found... "+Reusables.getText(home_page_txt) +e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify EduBank Logo present or not.
	 */
	public static void verfiyEduBankIconPresent(){
		try{
			Reusables.waitForElement(eduBank);
			IOSElement element = driver.findElement(eduBank);
			Reusables.verifyElementPresent(element, "Error Message! Edu Bank icon not present.");
		}
		catch(NoSuchElementException e){
			Logs.error(" EduBank Logo not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * this method is used to verify EV menu present or not.
	 */
	public static void verfiyEvMenuLogoPresent(){
		try{
			Reusables.waitForElement(ev_menu_btn);
			IOSElement element = driver.findElement(ev_menu_btn);
			Reusables.verifyElementPresent(element, "Error Message ev menu logo not present.");
		}
		catch(NoSuchElementException e){
			Logs.error("EV Menu not visible. "+e.getClass().getName());
		}
	}
	
	public static void clickOnEvMenu(){
		try{
			Reusables.clickCommand(ev_menu_btn);
		}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify either category element present or not. 
	 */
	public static void verfiyCategoryIconPresent(){
		try{
			Reusables.waitForElement(categories);
			IOSElement category_element = driver.findElement(categories);
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
		try{
			Reusables.waitForElement(cities);
			IOSElement element = driver.findElement(cities);
			Reusables.verifyElementPresent(element, "Error Message! cities icon not displayed.");
		}
		catch(NoSuchElementException e){
			Logs.error("cities icon not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Home button.
	 */
	public static void navigateToHomePage(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(homeBtn));
			Reusables.click_using_element(Reusables.getElement(homeBtn));
			}
		catch(NoSuchElementException e){
			Logs.error("Home button not found. "+e.getClass().getName());
			}
		}
	}
