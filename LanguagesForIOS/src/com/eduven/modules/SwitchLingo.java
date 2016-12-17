package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class SwitchLingo {
	
	
	/* Object Identification */
	public static By switchLingoBtn = By.xpath("//UIAButton[@name='switch lingo'][1]");
	public static By switchLingoHeaderTxt = By.name("SwitchLingoHeader");
	public static By cancelBtn = By.name("Cancel");
	

	/**
	 * This method is used to navigate to the Switch Language page.
	 */
	public static void navigateToSwitchLanguagePage(){
		try{
			Reusables.waitThread(5);
			Reusables.waitForElement(switchLingoBtn);
			if (Reusables.isElementPresent(switchLingoBtn) == true){
				Reusables.tapOnElementUsingLocator(switchLingoBtn);
				}
			Reusables.waitThread(5);
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Switch Language Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Switch Lingo header text.
	 */
	public static void verifySwitchLingoHeaderTxt(){
		try{
			Reusables.waitForElement(switchLingoHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(switchLingoHeaderTxt), "Error Message!! Switch Lingo Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Switch Lingo Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to dismiss Switch Lingo Page.
	 */
	public static void dismissSwitchLingoPage(){
		try{
			Reusables.waitAndClick(cancelBtn);
		}catch(NoSuchElementException e){
			Logs.error("Cancel Button not found. "+e.getClass().getName());
		}
	}
	
}
