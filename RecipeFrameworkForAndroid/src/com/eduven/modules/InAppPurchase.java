package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class InAppPurchase {
	
	
	/* Object Identification */
	public static By upgradeToPremiumTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/upgrade_to_premium");
	public static By app_purchase_txt = By.id("com.android.vending:id/item_title");
	public static By buyBtn = By.id("com.android.vending:id/continue_button");
	public static By submit_payment_popup = By.id("android:id/button1");
	public static By already_purchase_message_popup = By.id("android:id/message");
	
	
	/**
	 * This method is used to click on the upgrade to premium.
	 */
	public static void clickOnUpgradeToPremium(){
		try{
			Reusables.waitForElement(upgradeToPremiumTxtView);
			Reusables.clickCommand(upgradeToPremiumTxtView);
		}catch(NoSuchElementException e){
			Logs.error("upgrade to premium text view not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to return boolean value.
	 * @return boolean value.
	 */
	public static boolean alreadyPurchasedMessage(){
		boolean status = false;
		try{
			if (Reusables.isElementPresent(already_purchase_message_popup)==true){
				Reusables.verifyEqualMessage(Reusables.getText(already_purchase_message_popup), DataConstants.already_purchase_app_message, "Error Message!! Alert messages does not matched..");
				status = true;
			}
			else {
				status = false;
			}
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
	 * This method is used to verify app purchase title message.
	 */
	public static void verifyAppPurchaseTitle(){
		try{
			String app_purchase_title_message = Reusables.getText(app_purchase_txt);
			System.out.println("App Title..."+app_purchase_title_message);
			Reusables.verifyEqualMessage(Reusables.getText(app_purchase_txt), DataConstants.alert_message_before_app_purchase, "Error Message! App purchase alert text message does not matched.");
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
			Reusables.waitForElement(buyBtn);
			Reusables.clickCommand(buyBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Buy button Still not visible... "+e.getClass().getName());
		}
	} 
	
	/**
	 * This method is used to purchase app subscription.
	 */
	public static void appPurchase(){
		clickOnUpgradeToPremium();
		Reusables.waitThread(4);
		if (alreadyPurchasedMessage() == true){
			Reusables.waitThread(2);
			submitAlreadyPurchasePopUpMessageBox();
		}
		else if (Reusables.getText(app_purchase_txt).equalsIgnoreCase(DataConstants.alert_message_before_app_purchase)){
			verifyAppPurchaseTitle();
			clickOnBuyButtonGooglePlayStorePage();
			Reusables.waitThread(2);
		}
	}
	
	/**
	 * This method is used to purchase app.
	 */
	public static void upgradeToPremium(){
		try{
			EvMenu.navigateToSettingPage();
			appPurchase();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Unable to purchase the app. "+e.getClass().getName());
		}
	}

}
