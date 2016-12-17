package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class SplashScreen {

	/* Driver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator identification */ 
	public static By allowNotificationBtn = By.name("OK");
	public static By splash_screen_onstartup = By.name("DiscoverBtn");
	public static By flyer_image_logo = By.name("Flyer.jpg");
	public static By hide_rate_the_app_popup = By.name("No, thanks");

	
	public static IOSElement rateAppInstance(){
		return Reusables.getElement(hide_rate_the_app_popup);
	}
	
	/**
	 * This method is used to hide the pop up message for rating the app.
	 */
	public static void hideAppRatePopup(){
		try{
			Reusables.waitThread(5);
			if (Reusables.isElementPresent(hide_rate_the_app_popup) == true){
				rateAppInstance().click();
				}
			else if (Reusables.isElementPresent(hide_rate_the_app_popup) == false){
			}
			}
		catch(NoSuchElementException e){
			Logs.warn(" Rate the App popup does not close. "+e.getClass().getName());
			}
		}
	
	
	/**
	 * This method is used to wait splash screen on the App loading.
	 */
	public static void verifyForSplashScreen() {
		try{
		Reusables.waitForElement(splash_screen_onstartup);
		}catch(NoSuchElementException e){
			Logs.error("splash screen not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Discover button.
	 */
	public static void clickOnDiscoverButton(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(splash_screen_onstartup));
			Reusables.clickCommand(splash_screen_onstartup);
		}catch(NoSuchElementException e){
			Logs.error("Not click on Discover Button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to tap on the flyer image.
	 */
	public static void tapOnFlyerImage(){
		try{
			Reusables.tap_on_element_using_locator(flyer_image_logo);
		}catch(NoSuchElementException e){
			Logs.info("Click opt not perform on the flyer image. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to allow notification.
	 */
	public static void allowNotification(){
		try{
			Reusables.waitThread(2);
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
