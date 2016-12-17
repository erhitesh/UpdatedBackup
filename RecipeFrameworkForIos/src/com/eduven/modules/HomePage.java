package com.eduven.modules;

import java.util.List;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class HomePage {

	
	/* Locator Identification */
	public static By appNameTxt = By.id("Header");
		
	public static By searchBtn = By.id("Search");
	public static By searchPageHeader = By.id("Header");
	
	public static By evMenuBtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");  
	public static By evMenuElementBtn = By.xpath("//UIACollectionCell");
	
	public static By homePageBtn = By.id("Home_Button");
	
	public static By courseBtn = By.id("course");
	public static By courseHeaderTxt = By.id("Header");
	
	public static By tasteBudImageView = By.id("Taste Buds");
	public static By tasteBudHeaderTxt = By.id("Header");
	
	public static By allrecipesImageView = By.id("All Recipes");
	public static By allRecipesHeaderTxt = By.id("Header");
	
	public static By cookWithImageView = By.id("Cook With");
	public static By cookWithHeaderTxt = By.id("Header");
	
	public static By tipsImageView = By.id("Tips");
	public static By tipsHeaderTxt = By.id("Header");
	
	public static By eduBankImageView = By.id("EduBank");
	public static By eduBankHeaderTxt = By.id("Header");
	
	
	/**
	 * This method is used to navigate to the home page.
	 */
	public static void navigateToHomePage(){
		try{
			Reusables.stepBackTillElementNotFound(appNameTxt, DataConstants.appName);
			SplashScreen.hideAppRatePopUp();
		}catch(NoSuchElementException e){
			Logs.error("Home Page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify App name on home page
	 */
	public static void verifyAppName(){
		try{
			Reusables.waitForIOSElement(appNameTxt);
			Reusables.verifyEqualMessage(Reusables.getText(appNameTxt), DataConstants.appName, "Error Message!! Actual and Expected text not matched.");
		}catch(NoSuchElementException r){
			Logs.error("App Name not found.  "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify App name on home page
	 */
	public static void verifyHomePageHeaderTxt(){
		try{
			Reusables.waitForIOSElement(appNameTxt);
			Reusables.verifyEqualMessage(Reusables.getText(appNameTxt), DataConstants.appName, "Error Message!!App name not matched.");
		}catch(NoSuchElementException r){
			Logs.error("App Header text not found "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Search button on home page.
	 */
	public static void verifySearchButton(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(searchBtn), "Error Message!! Search Button not found.. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Click on Search button on home page.
	 */
	public static void clickOnSearchButton(){
		try{
			Reusables.waitForIOSElement(searchBtn);
			Reusables.clickCommand(searchBtn);
		}catch(NoSuchElementException e){
			Logs.error("click operation not perform on the search button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Search page header text on Search page.
	 */
	public static void verifySearchPageHeaderText(){
		try{
			Reusables.waitForIOSElement(searchPageHeader);
			Reusables.verifyPageLoaded(DataConstants.searchHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Search Page Header not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EvMenu button on home page.
	 */
	public static void verifyEvMenuButton(){
		try{
			Reusables.waitForIOSElement(evMenuBtn);
			Reusables.verifyElementPresent(Reusables.getIOSElement(evMenuBtn), "Error Message!! EvMenu button not found.. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on EvMenu button on home page.
	 */
	public static void clickOnEvMenuButton(){
		try{
			Reusables.waitForIOSElement(evMenuBtn);
			Reusables.clickCommand(evMenuBtn);
		}catch(NoSuchElementException e){
			Logs.error("EvMenu button not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify EvMenu page element.
	 */
	public static void verifyEvMenuElement(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(evMenuElementBtn), "Error Message!! EvMenu element not found.. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu element not found.. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Recipes Terms >>>>>>>>>>>>>>>>>>>>>>>>
	public static void clickOnHomePageButton(String buttonName){
		List<IOSElement> homePageBtnList;
		try{
			homePageBtnList = Reusables.getIOSElementsList(homePageBtn);
			for (IOSElement element : homePageBtnList){
				if (element.getText().trim().equalsIgnoreCase(buttonName)){
					element.click();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Unable to perform click operation. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the course button.
	 */
	public static void clickOnCourese(){
		try{
			Reusables.waitForIOSElement(HomePage.appNameTxt);
			clickOnHomePageButton(DataConstants.coursesBtn);
			Reusables.waitForIOSElement(courseHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Courese Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the TasteBud button.
	 */
	public static void clickOnTasteBud(){
		try{
			Reusables.waitForIOSElement(HomePage.appNameTxt);
			clickOnHomePageButton(DataConstants.tasteBudsBtn);
			Reusables.waitForIOSElement(tasteBudHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("TasteBud button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the AllRecipes button.
	 */
	public static void clickOnAllRecipes(){
		try{
			Reusables.waitForIOSElement(HomePage.appNameTxt);
			clickOnHomePageButton(DataConstants.allRecipesBtn);
			Reusables.waitForIOSElement(allRecipesHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("AllRecipes button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the CookWith button.
	 */
	public static void clickOnCookWith(){
		try{
			Reusables.waitForIOSElement(HomePage.appNameTxt);
			clickOnHomePageButton(DataConstants.cookWithBtn);
			Reusables.waitThread(2);
			if (Reusables.alertInstance() != null){
				Reusables.acceptAlert();
			}
			Reusables.waitForIOSElement(cookWithHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("CookWith button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Tips button.
	 */
	public static void clickOnTips(){
		try{
			clickOnHomePageButton(DataConstants.tipsBtn);
			Reusables.waitForIOSElement(tipsHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Tips button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static void clickOnEduBank(){
		try{
			Reusables.waitForIOSElement(HomePage.appNameTxt);
			clickOnHomePageButton(DataConstants.edubankBtn);
			Reusables.waitForIOSElement(eduBankHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("EduBank button not found.. "+e.getClass().getName());
		}
	}
}
