package com.eduven.modules;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class SplashScreen {

	/* Driver instance */ 
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator identity */ 
	public static By discover_btn = By.name("Discover");
	public static By close_flyer_popup = By.id(DeviceRelatedInformation.getPackageName()+":id/cancelFlyer");
	public static By rate_the_app_popup = By.name("No, thanks");
	public static By allowMediaContent = By.id("com.android.packageinstaller:id/permission_allow_button");
	public static By evMenuBtn = By.xpath("//android.widget.ImageView[@content-desc='More options']");

	/**
	 * This method is used to return the IOSElement Instance.
	 * @return : IOSElement
	 */
	public static AndroidElement rateAppInstance(){
		
		return Reusables.getElement(rate_the_app_popup);
	}
	
	/**
	 * This method is used to click on the No, Thanks button.
	 */
	public static void hideAppRatePopup(){
		try{
			/*if (Reusables.isElementPresent(rate_the_app_popup) == true){
				rateAppInstance().click();
			}
			else if (Reusables.isElementPresent(rate_the_app_popup) == false){
				
			}*/
			}
		catch(NoSuchElementException e){
			Logs.warn(" Rate the App popup does not Visible.. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to return the IOSElement Instance.
	 * @return : IOSElement
	 */
	public static AndroidElement discoverButtonInstance(){
		
		return Reusables.getElement(discover_btn);
	}

	/**
	 * This method is used to click on the Discover button.
	 */
	public static void clickOnDiscoverButton(){
		try{
			/*if (Reusables.isElementPresent(discover_btn) == true){
				discoverButtonInstance().click();
				}
			else if (Reusables.isElementPresent(discover_btn) == false){
			}*/
			}
		catch(NoSuchElementException e){
			Logs.warn("Discover Button not Visible. "+e.getClass().getName());
			}
		}
	
	
	/**
	 * This method is used to cancel the flyer Pop up.
	 */
	public static void closeFlyerPopup(){
		try{
			Reusables.waitThread(20);
			Reusables.waitForElement(close_flyer_popup);
			if (Reusables.isElementPresent(close_flyer_popup) == true){
				Reusables.clickUsingElement(Reusables.getElement(close_flyer_popup));
				}
			else if (Reusables.isElementPresent(close_flyer_popup) == false){
				
			}
			}
		catch(NoSuchElementException e){
			Logs.warn("Flyer popup not visible. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to allow media files.
	 */
	public static void allowMediaFilesToAccess(){
		try{
			if (Reusables.isElementPresent(allowMediaContent) == true){
				Reusables.clickUsingElement(Reusables.getElement(allowMediaContent));
			}
			else if (Reusables.isElementPresent(evMenuBtn) == true){
				Reusables.verifyElementPresent(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found..");
			}
		}catch(NoSuchElementException e){
			Logs.warn(">>>>>>>>>> Allow Media Content pop up not found.. "+e.getClass().getName());
		}
	}
	
	}
