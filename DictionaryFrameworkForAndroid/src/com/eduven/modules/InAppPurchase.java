package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class InAppPurchase {
	
	/* Android Driver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By no_thanks_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_cancel");
	public static By unlock_now_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_upgrade");
	public static By contribute_later_btn = By.id("android:id/button2");
	public static By contribute_later_popup_message = By.id("android:id/message");
	public static By app_purchase_txt = By.name("Sample Title");
	public static By continue_subscription = By.name("BUY");
	public static By already_purchase_message_popup = By.id("android:id/message");
	public static By submit_payment_popup = By.id("android:id/button1");
	public static By app_successful_completion_msg = By.name("Payment Successful");
	public static By more_apps_imgView = By.id(DeviceRelatedInformation.getPackageName()+":id/unlock");
	
	
	
	
	//For Unlock 
	/**
	 * This method is used to navigate to In App Purchase page.
	 */
	public static void navigateToInAppPurchasePage(){
		try{
			Footer.verifyLock();
			Reusables.clickCommand(Footer.buyImageView);
			Reusables.waitForElement(unlock_now_btn);
		}catch(NoSuchElementException e){
			Logs.error("In App Purchase Page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the unlock button.
	 */
	public static void clickOnUnlockButton(){
		try{
			Reusables.waitForElement(unlock_now_btn);
			Reusables.clickUsingElement(Reusables.getElement(unlock_now_btn));
		}
		catch(Exception e){
			Logs.error(" Buy Button still visible "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify unlock button.
	 */
	public static void verifyUnlockButtonStillVisible(){
		try{
			Reusables.waitForElement(unlock_now_btn);
			Reusables.verifyElementPresent(Reusables.getElement(unlock_now_btn), "Error Message!! unlock now button not visible.");
		}catch(NoSuchElementException e){
			Logs.error("Unlock Now button not visible."+e.getClass().getName());
		}
	}
	/**
	 * This method is used to verify app purchase title message.
	 */
	public static void verifyAppPurchaseTitle(){
		try{
			String app_purchase_title_message = Reusables.getText(app_purchase_txt);
			System.out.println("App Title..."+app_purchase_title_message);
			Reusables.verifyEqualMessage(Reusables.getText(app_purchase_txt), DataConstants.alertMessageBeforeAppPurchase, "Error Message! App purchase alert text message does not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(" App purchase title message does not matched "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the buy button on google play store pop up message box.
	 */
	public static void clickOnBuyButtonGooglePlayStorePage(){
		try{
			Reusables.waitForElement(continue_subscription);
			Reusables.clickUsingElement(Reusables.getElement(continue_subscription));
		}
		catch(NoSuchElementException e){
			Logs.error("Buy button Still visible... "+e.getClass().getName());
		}
	} 
	
	
	/**
	 * This method is used to verify app purchase successfully message.
	 */
	public static void verifyPurchaseAppSuccessfullMessage(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(app_successful_completion_msg), "Error Message!! Payment SuccessFull message not present.!!");
		}
		catch(NoSuchElementException e){
			Logs.error("App purchase successfully message not found.."+e.getClass().getName());
		}
	}
	
	
	//********************************* alredy_purchased ************************************
	public static boolean alreadyPurchasedMessage(){
		boolean status = false;
		try{
			Reusables.verifyEqualMessage(Reusables.getText(already_purchase_message_popup), DataConstants.alreadyPurchaseAppMessage, "Error Message!! Alert messages does not matched..");
			status = true;
		}
		catch(NoSuchElementException e){
			Logs.error(" Already Purchased message not displayed.... "+e.getClass().getName());
		}
		
		return status;
	}
	
	/**
	 * This method is used to submit the already purchase pop up message box.
	 */
	public static void submitAlreadyPurchasePopUpMessageBox(){
		try{
			Reusables.waitForElement(submit_payment_popup);
			Reusables.clickCommand(submit_payment_popup);
		}
		catch(NoSuchElementException e){
			Logs.error("Already purchase popup message still visible.."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to purchase app subscription.
	 */
	public static void app_purchase(){
		clickOnUnlockButton();
		Reusables.waitThread(4);
		if (alreadyPurchasedMessage() == true){
			Reusables.waitThread(2);
			submitAlreadyPurchasePopUpMessageBox();
		}
		else if (Reusables.getText(app_purchase_txt).equalsIgnoreCase(DataConstants.alertMessageBeforeAppPurchase)){
			verifyAppPurchaseTitle();
			clickOnBuyButtonGooglePlayStorePage();
			Reusables.waitThread(2);
			HomePage.verifyHomePageCategoryIcon();
		}
	}
	
	/**
	 * This method is used to verify lock term now appear as unlock term.
	 * @param statusValue : status value for checking condition.
	 */
	public static void verifyLockTermAfterPurchase(String name, boolean statusValue){
		try{
			Reusables.verifyElementCountExistance(By.name(name), statusValue);
		}catch(NoSuchElementException e){
			Logs.error("Lock term still present after purchase. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify moreApp image view.
	 */
	public static void verifyMoreAppsImageView(){
		try{
			Reusables.waitForElement(more_apps_imgView);
			Reusables.verifyElementPresent(Reusables.getElement(more_apps_imgView), "Error Message!! More Apps imageview not found.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps imageview Not found. "+e.getClass().getName());
		}
	}

}
