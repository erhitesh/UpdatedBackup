package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;

public class SplashScreen {

	
	/* Locator identity */ 
	public static By allowNotificationBtn = By.name("OK");
	public static By hideRateAppAlert = By.xpath("//UIAButton[@name='No, thanks']");
	public static By hideKeyboardBtn = By.id("Hide keyboard");
	public static By interstetial = By.xpath("//UIAButton[@name='Close Advertisement']");
	public static By cancelBtn = By.name("cancel button");
	public static By elementCount = By.xpath("//UIACollectionCell");
	public static By hideUIAWindowForWifi = By.xpath("//UIAWindow[7]/UIAStaticText[1]");
	public static By hideiTuneStorePage = By.xpath("//UIAButton[contains(@name,'Back to')]");
	public static By spaceKey = By.id("space");
	public static By shiftKey = By.id("shift");
	public static By deleteKey = By.id("delete");
	
	
	/**
	 * This method is used to return the instance of hide rate popup message.
	 * @return : IOSElement
	 */
	public static IOSElement rateAppInstance(){
		return Reusables.getElement(hideRateAppAlert);
	}
	
	/**
	 * This method is used to hide the pop up message for rating the app.
	 */
	public static void hideAppRatePopup(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(hideRateAppAlert) == true){
				rateAppInstance().click();
				}
			else if (Reusables.isElementPresent(hideRateAppAlert) == false){
			}
			}
		catch(NoSuchElementException e){
			Logs.warn(" Rate the App popup does not close. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to allow notification.
	 */
	public static void allowNotification(){
		try{
			Reusables.waitThread(1);
			if (Reusables.isElementPresent(allowNotificationBtn) == true){
				Reusables.acceptAlert();
			}
			else if (Reusables.isElementPresent(allowNotificationBtn) == false){
			}
		}catch(NoSuchElementException e){
			Logs.warn("Allow Notification popup not visible. "+e.getClass().getName());
			}
		}
	}
