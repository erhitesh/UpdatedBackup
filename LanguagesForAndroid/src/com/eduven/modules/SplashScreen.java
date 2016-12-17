package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class SplashScreen {

	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator identity */ 
	public static By allowNotificationBtn = By.name("OK");
	public static By hide_app_rate_btn = By.name("Cancel");
	public static By allowMediaAccessFilesAndContacts = By.id("com.android.packageinstaller:id/permission_allow_button");
	
	/**
	 * This method is used to return the instance of hide rate popup message.
	 * @return
	 */
	public static AndroidElement rateAppInstance(){
		return Reusables.getElement(hide_app_rate_btn);
	}
	
	/**
	 * This method is used to hide the pop up message for rating the app.
	 */
	public static void hideAppRatePopup(){
		try{
			/*Reusables.waitThread(2);
			if (Reusables.isElementPresent(hide_app_rate_btn) == true){
				rateAppInstance().click();
				}
			else if (Reusables.isElementPresent(hide_app_rate_btn) == false){
			}*/
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
			/*Reusables.waitThread(1);
			if (Reusables.isElementPresent(allowNotificationBtn) == true){
				Reusables.acceptAlert();
			}
			else if (Reusables.isElementPresent(allowNotificationBtn) == false){
			}*/
		}catch(NoSuchElementException e){
			Logs.warn("Allow Notification popup not visible. "+e.getClass().getName());
			}
		}
	
	public static void allowMediaFileAccessPopup(){
		try{
			if (Reusables.isElementPresent(allowMediaAccessFilesAndContacts)==true){
				Reusables.clickCommand(allowMediaAccessFilesAndContacts);
				}
				else {
				}
		}catch(NoSuchElementException e){
			Logs.warn("Alert popup not found. "+e.getClass().getName());
		}
		}
	}
