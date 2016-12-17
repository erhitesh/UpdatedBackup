package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class EntityDetailPage {
	
	/* IOSDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator Identity */                      
	public static By termNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/title_textView");
	public static By favourite_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_fav_btn");
	public static By description = By.name("Description");
	
	public static By pck_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/premium_allPackage_pack");
	public static By add_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/premium_adfree_pack");
	public static By buy_btn = By.name("Buy");
	public static By restore_btn = By.name("Restore");
	
	//For buy subscription
	public static By already_purchase_message = By.id("android:id/message");
	public static By app_purchase_txt = By.name("Sample Title");
	public static By continue_subscription = By.name("BUY");
	public static By app_successful_completion_msg = By.name("Payment Successful");

	
	/**
	 * This method is used to get term name.
	 * @return : String.
	 */
	public static String getTermName(){
		String termName = "";
		try{
			termName = Reusables.getElement(termNameTxt).getText();
		}catch(NoSuchElementException e){
			Logs.error("Term Name not found. "+e.getClass().getName());
		}
		
		return termName;
	}
	
	/**
	 * This method is used to check the eduBank button present or not.
	 */
	public static void checkFavIcon(){
		try{
		Reusables.verifyElementPresent(Reusables.getElement(favourite_icon), "Error Message! Favourite icon not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>Favourite icon not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check either description text present or not.
	 */
	public static void checkDescriptionHeader(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(description), "Error Messgae! Description Header text not visible.");
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>> Description Header not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify free entity detail for favorite Logo.
	 */
	public static void detailPageVerificationForFreeEntity(){
		checkFavIcon();
	}
	
	//****************************************************For Paid Entity************************************
	public static void verifyAddButtonExistance(){
		try{
		Reusables.verifyElementPresent(Reusables.getElement(add_btn), "Error Message! Add button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Add button icon not present. "+e.getClass().getName());
		}
	}
	
	public static void verifyBuyButtonExistance(){
		try{
		Reusables.verifyElementPresent(Reusables.getElement(buy_btn), "Error Message! Buy button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Buy button icon not present. "+e.getClass().getName());
		}
	}
	
	public static void verifyRestoreButtonExistance(){
		try{
		Reusables.verifyElementPresent(Reusables.getElement(restore_btn), "Error Message! Restore button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Restore button icon not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify paid entity details.
	 */
	public static void detailPageVerificationForPaidEntity(){
		verifyAddButtonExistance();
		verifyRestoreButtonExistance();
		verifyBuyButtonExistance();
	}
	
	
	//************************************For Unlock *****************************
	public static void clickOnBuyButton(){
		try{
			Reusables.clickCommand(buy_btn);
		}
		catch(NoSuchElementException e){
			Logs.error("Buy Button still visible. "+e.getClass().getName());
		}
	}
	
	public static void verifyAppPurchaseTitle(){
		try{
			String app_purchase_title_message = Reusables.getText(app_purchase_txt);
			Reusables.verifyEqualMessage(app_purchase_title_message, DataConstants.alert_message_before_app_purchase, "Error Message! App purchase alert text message does not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("App purchase title message does not matched");
		}
	}
	
	//********************************* alredy_purchased ************************************
	public static boolean alreadyPurchasedMessage(){
		boolean status = false;
		try{
			Reusables.verifyEqualMessage(Reusables.getText(already_purchase_message), DataConstants.already_purchase_app_message, "Error Message Alert messages does not matched..");
			status = true;
		}
		catch(NoSuchElementException e){
			return false;
			//Logs.error("Already Purchased message not displayed.... "+e.getClass().getName());
		}
		
		return status;
	}

//*************************************	congratulation|*********************
	public static void verifyCongratulationMessage(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(app_successful_completion_msg), DataConstants.congratuation_message, "Error Message! Alert messages does not matched.....");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Congratulation message not display. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to in app purchase.
	 */
	public static void appPurchase(){
		clickOnBuyButton();
		Reusables.waitThread(4);
		try{
			if (alreadyPurchasedMessage() == true){
				Reusables.waitThread(2);
				Reusables.clickCommand(restore_btn);
			}
			else if (Reusables.getText(app_purchase_txt).equalsIgnoreCase(DataConstants.alert_message_before_app_purchase) == true){
				verifyAppPurchaseTitle();
				Reusables.clickCommand(continue_subscription);
				Reusables.waitThread(2);
				verifyCongratulationMessage();
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Unable to process the In App Purchase. "+e.getClass().getName());
		}
	}
}
