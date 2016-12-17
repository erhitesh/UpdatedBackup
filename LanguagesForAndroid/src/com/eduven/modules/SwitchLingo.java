package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class SwitchLingo {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By switchLingoBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_base_language");
	public static By switchLingoHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_title1");
	
	
	/**
	 * This method is used to get Switch Language button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getSwitchLanguageBtnInstance(){
		
		return Reusables.getElement(switchLingoBtn);
	}
	
	
	/**
	 * This method is used to navigate to the Switch Language page.
	 */
	public static void navigateToSwitchLanguagePage(){
		try{
			Reusables.waitThread(10);
			if (Reusables.isElementPresent(switchLingoBtn) == true){
				getSwitchLanguageBtnInstance().click();
			}
			else if (Reusables.isElementPresent(switchLingoBtn) == false) {
				
			}
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Switch Language Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Switch Lingo header text.
	 */
	public static void verifySwitchLingoHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(switchLingoHeaderTxt), "Error Message!! Switch Lingo Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Switch Lingo Header text not found. "+e.getClass().getName());
		}
	}
	
}
