package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class InAppPurchase {

	/* Object Identification */
	public static By buyBtn = By.xpath("//UIAButton[@name='Buy']");
	public static By restoreBtn = By.id("Restore");
	public static By noThanksBtn = By.id("No, Thanks");
	public static By unLockBtn = By.id("Unlock Now");
	public static By benefitsBtn = By.id("Benefits");
	//For buy subscription
	public static By existingAppleIdBtn = By.name("Use Existing Apple ID");
	public static By userNameTxtBox = By.xpath("//UIATextField");
	public static By userPassTxtBox = By.xpath("//UIASecureTextField");
	public static By buyAlertBtn = By.id("Buy");
	public static By confirmMessage = By.xpath("//UIAStaticText[@name='Confirm Your In-App Purchase']");	
	public static By alreadyPurchaseMessage = By.xpath("//UIAStaticText[2]");
	public static By thankYouMessage = By.xpath("//UIAStaticText[@name='Thank You']");
	public static By congratulationMessage = By.xpath("//UIAStaticText[@name='Congratulations!']");
	
	
	/**
	 * This method is used to click on the InApp purchase button.
	 */
	public static void clickOnBuy(){
		try{
			Reusables.waitForIOSElement(buyBtn);
			Reusables.clickCommand(buyBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to click on the buy button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either inapp purchase page open or not.
	 */
	public static void verifyElementOnInAppPurchasePageLoad(){
		try{
			Reusables.waitThread(3);
			Reusables.verifyElementPresent(Reusables.getIOSElement(benefitsBtn), "Error Message!!Benefits btn not found.");
			Reusables.waitForIOSElement(noThanksBtn);
			Reusables.waitForIOSElement(unLockBtn);
			Reusables.waitForIOSElement(restoreBtn);
		}catch(NoSuchElementException e){
			Logs.error("Elements not found on In App purchase page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the unlock button.
	 */
	public static void clickOnUnlockButton(){
		try{
			Reusables.waitForIOSElement(unLockBtn);
			Reusables.clickCommand(unLockBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to click on the unlock button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the No Thanks button.
	 */
	public static void clickOnNoThanks(){
		try{
			Reusables.waitForIOSElement(noThanksBtn);
			Reusables.clickCommand(noThanksBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to click on the no thanks button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to hide inapp purchase page.
	 */
	public static void hideInAppPurchasePage(){
		clickOnNoThanks();
	}
	
	/**
	 * This method is used to click on the restore button.
	 */
	public static void clickOnRestore(){
		try{
			Reusables.waitForIOSElement(restoreBtn);
			Reusables.clickCommand(restoreBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to click on the restore button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify paid entity details.
	 */
	public static void verificationForPaidTerm(){
		verifyElementOnInAppPurchasePageLoad();
	}
	
	
	/**
	 * This method is used to enter user name.
	 */
	public static void enterUserName(){
		try{
			IOSElement userName = Reusables.getIOSElement(userNameTxtBox);
			userName.click();
			userName.sendKeys(DataConstants.username);
			}
		catch(NoSuchElementException e){
			Logs.error("UserName is not entered in the username textbox. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to enter user password.
	 */
	public static void enterUserPass(){
		try{
			IOSElement userPass = Reusables.getIOSElement(userPassTxtBox);
			userPass.click();
			userPass.sendKeys(DataConstants.password);
		}catch(NoSuchElementException e){
			Logs.error("userPass is not entered in the userpass textbox. "+e.getClass().getName());
		}
		}
	
	
	/**
	 * This method is used to verify first time login
	 * @return : boolean as status.
	 */
	public static boolean verifyFirstTimeSignin(){
		Reusables.waitThread(2);
		boolean status = false;
		try{
			Reusables.waitThread(4);
			if (Reusables.isElementPresent(existingAppleIdBtn)){
				status = true;
				Reusables.clickCommand(existingAppleIdBtn);
				Reusables.waitThread(2);
			}
			else if (Reusables.isElementPresent(existingAppleIdBtn)==false){
				status = false;
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Use Existing Apple ID not visible. "+e.getClass().getName());
			}
		
		return status;
	}
	
	/**
	 * This method is used to verify app sign in confirmation message.
	 */
	public static void inAppPurchaseConfirmationMessges(){
		try{
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getIOSElement(buyAlertBtn), "Error Message!Buy button not visbile.");
			}
		catch(NoSuchElementException e){
			Logs.error("Buy button not visible. "+e.getClass().getName());
			}
		Reusables.acceptAlert();
		}

   //********************************* alredy_purchased ************************************
	public static void alredyPurchasedMessageAlert(){
		try{
			Reusables.waitThread(8);
			if (Reusables.alertInstance().getText().contains(DataConstants.alreadyPurchaseAppMessage2) == true){
				Assert.assertTrue(Reusables.alertInstance().getText().contains(DataConstants.alreadyPurchaseAppMessage2), "Error Message!! Message not found.");
				confirmAlreadyPurchaseAlert();
			}
			else if (Reusables.alertInstance().getText().contains(DataConstants.alreadyPurchaseAppMessage1) == true){
				Assert.assertTrue(Reusables.alertInstance().getText().contains(DataConstants.alreadyPurchaseAppMessage1), "Error Message!! Message not found.");
				confirmAlreadyPurchaseAlert();
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Already Purchased message not displayed. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to accept the already alert message popup.
	 */
	public static void confirmAlreadyPurchaseAlert(){
		try{
			Reusables.waitThread(3);
			Reusables.acceptAlert();
			Reusables.waitThread(3);
		}
		catch(NoSuchElementException e){
			Logs.error("Thank you message not visible. "+e.getClass().getName());
			}
		}
	
	public static void alreadyConfirmPurchaseAlertPopup(){
		clickOnBuy();
		alredyPurchasedMessageAlert();
		confirmAlreadyPurchaseAlert();
		}
	
   //**************************************thank_you*******************************	
	public static void verifyThankYouMessageAlert(){
		try{
			Reusables.waitThread(6);
			Assert.assertTrue(Reusables.getAlertMessage().contains(DataConstants.thankYouMessage), "Error Message!Actual and Expected messages are not matched.");
			}
		catch(NoSuchElementException e){
			Logs.error("Thank you message still visible. "+e.getClass().getName());
			}
		}
	
	public static void acceptThankYouMessageAlert(){
		Reusables.waitThread(3);
		Reusables.acceptAlert();
		Reusables.waitThread(3);
		}
	
	public static void thankYouAlertPopup(){
		verifyThankYouMessageAlert();
		acceptThankYouMessageAlert();
		}
	
    //*************************************	congratulation|*********************
	public static void verifyCongratulationMessageAlert(){
		try{
			Reusables.waitThread(5);
			Assert.assertTrue(Reusables.alertInstance().getText().contains(DataConstants.congratulationMessage), "Error Message!Actual and Expected messages are not matched.");
			}
		catch(NoSuchElementException e){
			Logs.error("Congratulation message not display. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to accept alert pop up.
	 */
	public static void acceptCongratulationAlert(){
		Reusables.waitThread(3);
		Reusables.acceptAlert();
		Reusables.waitThread(3);
	}
	
	/**
	 * This method is used verify app purchase successfully message.
	 */
	public static void congratulationAlertPopup(){
		verifyCongratulationMessageAlert();
		acceptCongratulationAlert();
	}
	
	
	/**
	 * This method is used to sign In Store. 
	 */
	public static void signInToiTuneStore(){
		clickOnUnlockButton();
		boolean loginType = verifyFirstTimeSignin();
		if (loginType==true){
			enterUserName();
			enterUserPass();
			Reusables.acceptAlert();
			}
		else if (Reusables.isElementPresent(buyBtn)){
		}
		else if (loginType==false){
			enterUserPass();
			Reusables.waitThread(2);
			Reusables.acceptAlert();
			Reusables.waitThread(2);
			}
		alreadyConfirmPurchaseAlertPopup();
		thankYouAlertPopup();
		congratulationAlertPopup();
	}
	
	
	
	/**
	 * This method is used to verify Purchase button.
	 */
	public static void verifyPurchaseBtnNotPresent(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(buyBtn) == false){
				Reusables.verifyElementNotPresent(Reusables.getIOSElement(buyBtn), "Error Messsage!! Purchase button Present.");
			}
		}catch(NoSuchElementException e){
			Logs.error("InApp Button found. "+e.getClass().getName());
		}
	}
}
