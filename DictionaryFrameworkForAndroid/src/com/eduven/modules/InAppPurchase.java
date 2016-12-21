package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;

public class InAppPurchase {
	

	/* Object Identification */
	public static By noThanksBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_cancel");
	public static By unlockNowBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_upgrade");
	public static By contributeLaterBtn = By.id("android:id/button2");
	public static By contributeLaterAlertPopupMessage = By.id("android:id/message");
	public static By sampleTitleMessageTxt = By.id("com.android.vending:id/item_title");
	public static By buyBtn = By.id("com.android.vending:id/continue_button");
	public static By alreadyPurchaseAlrtMessagePopup = By.id("android:id/message");
	public static By submitPaymentAlertPopup = By.id("android:id/button1");
	public static By appSuccessfullyCompletionMessage = By.name("Payment Successful");
	public static By moreAppImgView = By.id(DeviceRelatedInformation.getPackageName()+":id/unlock");


	/**
	 * This method is used to navigate to In App Purchase page.
	 */
	public static void navigateToInAppPurchasePage(){
		try{
			Footer.verifyLock();
			Reusables.clickCommand(Footer.buyImageView);
			Reusables.waitForElement(unlockNowBtn);
		}catch(NoSuchElementException e){
			Logs.error("In App Purchase Page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the unlock button.
	 */
	public static void clickOnUnlockButton(){
		try{
			Reusables.waitForElement(unlockNowBtn);
			Reusables.clickUsingElement(Reusables.getElement(unlockNowBtn));
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
			Reusables.waitForElement(unlockNowBtn);
			Reusables.verifyElementPresent(Reusables.getElement(unlockNowBtn), "Error Message!! unlock now button not visible.");
		}catch(NoSuchElementException e){
			Logs.error("Unlock Now button not visible."+e.getClass().getName());
		}
	}
	/**
	 * This method is used to verify app purchase title message.
	 */
	public static void verifyAppPurchaseTitle(){
		try{
			String app_purchase_title_message = Reusables.getText(sampleTitleMessageTxt);
			System.out.println("App Title..."+app_purchase_title_message);
			Reusables.verifyEqualMessage(Reusables.getText(sampleTitleMessageTxt), DataConstants.alertMessageBeforeAppPurchase, "Error Message! App purchase alert text message does not matched.");
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
			Reusables.clickUsingElement(Reusables.getElement(buyBtn));
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
			Reusables.verifyElementPresent(Reusables.getElement(appSuccessfullyCompletionMessage), "Error Message!! Payment SuccessFull message not present.!!");
		}
		catch(NoSuchElementException e){
			Logs.error("App purchase successfully message not found.."+e.getClass().getName());
		}
	}
	
	
	//********************************* alredy_purchased ************************************
	public static boolean alreadyPurchasedMessage(){
		boolean status = false;
		try{
			Reusables.verifyEqualMessage(Reusables.getText(alreadyPurchaseAlrtMessagePopup), DataConstants.alreadyPurchaseAppMessage, "Error Message!! Alert messages does not matched..");
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
			Reusables.waitForElement(submitPaymentAlertPopup);
			Reusables.clickCommand(submitPaymentAlertPopup);
		}
		catch(NoSuchElementException e){
			Logs.error("Already purchase popup message still visible.."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to purchase app subscription.
	 */
	public static void appPurchase(){
		clickOnUnlockButton();
		Reusables.waitThread(4);
		if (alreadyPurchasedMessage() == true){
			Reusables.waitThread(2);
			submitAlreadyPurchasePopUpMessageBox();
		}
		else if (Reusables.getText(sampleTitleMessageTxt).equalsIgnoreCase(DataConstants.alertMessageBeforeAppPurchase)){
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
			Reusables.waitForElement(moreAppImgView);
			Reusables.verifyElementPresent(Reusables.getElement(moreAppImgView), "Error Message!! More Apps imageview not found.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps imageview Not found. "+e.getClass().getName());
		}
	}

}
