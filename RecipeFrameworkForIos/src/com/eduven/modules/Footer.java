package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class Footer {
	
	
	/* Locator Identification */
	public static By homeBtn = By.id("Home");
	public static By cookWithBtn = By.id("Cook With");
	public static By tipsBtn = By.id("Tips");
	public static By edubankBtn = By.id("EduBank");
	public static By shopBtn = By.id("Shop");
	
	
	/**
	 * This method is used to click on the  button.
	 */
	public static IOSElement homeButtonInstance(){
		
		return Reusables.getIOSElement(homeBtn);
	}
	
	/**
	 * This method is used to click on the CookWith button.
	 */
	public static IOSElement cookWithButtonInstance(){
		
		return Reusables.getIOSElement(cookWithBtn);
	}
	
	/**
	 * This method is used to click on the Tips button.
	 */
	public static IOSElement tipsButtonInstance(){
		
		return Reusables.getIOSElement(tipsBtn);
	}
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static IOSElement edubankButtonInstance(){
		
		return Reusables.getIOSElement(edubankBtn);
	}
	
	/**
	 * This method is used to click on the Shop button.
	 */
	public static IOSElement shopButtonInstance(){
		
		return Reusables.getIOSElement(shopBtn);
	}
	
	/**
	 * This method is verify Home button
	 */
	public static void verifyHomeButton(){
		try{
			Reusables.verifyElementPresent(homeButtonInstance(), "Error Message!!Home Button not Found.");
		}catch(NoSuchElementException e){
			Logs.error("Home Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is verify CookWith button
	 */
	public static void verifyCookWithButton(){
		try{
			Reusables.verifyElementPresent(cookWithButtonInstance(), "Error Message!!CookWith Button not Found.");
		}catch(NoSuchElementException e){
			Logs.error("CookWith Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is verify Tips button
	 */
	public static void verifyTipsButton(){
		try{
			Reusables.verifyElementPresent(tipsButtonInstance(), "Error Message!!Tips Button not Found.");
		}catch(NoSuchElementException e){
			Logs.error("Tips Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is verify EduBank button
	 */
	public static void verifyEduBankButton(){
		try{
			Reusables.verifyElementPresent(edubankButtonInstance(), "Error Message!!EduBank Button not Found.");
		}catch(NoSuchElementException e){
			Logs.error("Home Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is verify Shop button
	 */
	public static void verifyShopButton(){
		try{
			Reusables.verifyElementPresent(shopButtonInstance(), "Error Message!!Shop Button not Found.");
		}catch(NoSuchElementException e){
			Logs.error("Shop Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Home button
	 */
	public static void clickOnHomeButton(){
		try{
			homeButtonInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the home button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Cook With button
	 */
	public static void clickOnCookWithButton(){
		try{
			cookWithButtonInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Cook with button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Tips button
	 */
	public static void clickOnTipsButton(){
		try{
			tipsButtonInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Tips button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EduBank button
	 */
	public static void clickOnEduBankButton(){
		try{
			edubankButtonInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Edubank button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Shop button
	 */
	public static void clickOnShopButton(){
		try{
			shopButtonInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Shop button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the home page.
	 */
	public static void navigateToHomePage(){
		while (Reusables.getText(HomePage.appNameTxt).equalsIgnoreCase(DataConstants.appName)==false){
			clickOnHomeButton();
			Reusables.waitThread(1);
		}
	}
	
	
	/**
	 * This method is used to navigate to the edubank page.
	 */
	public static void navigateToEdubank(){
		clickOnEduBankButton();
	}
}
