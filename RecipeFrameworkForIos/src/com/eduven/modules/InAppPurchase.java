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
	public static By restoreBtn = By.xpath("//*[@name='Restore'][1]");
	public static By buyFullFunctionalityBtn = By.xpath("//*[@name='Buy'][1]");
	public static By buyAddFreeBtn = By.xpath("//*[@name='Buy'][1]");
	public static By alertBuyBtn = By.name("Buy");
	public static By hideInAppPurchasePageBtn = By.id("close button");
	//For buy subscription
	public static By existing_apple_id_btn = By.name("Use Existing Apple ID");
	public static By userName_txt = By.xpath("//UIATextField");
	public static By userPass_txt = By.xpath("//UIASecureTextField");
	public static By confirm_message = By.xpath("//UIAStaticText[@name='Confirm Your In-App Purchase']");	
	public static By already_purchase_message = By.xpath("//UIAStaticText[2]");
	public static By thank_you_message = By.xpath("//UIAStaticText[@name='Thank You']");
	public static By congratulation_message = By.xpath("//UIAStaticText[@name='Congratulations!']");
	
	
	//****************************************************For Paid Entity************************************
	/**
	 * This method is used to verify Restore Button.
	 */
	 public static void verifyRestoreButton(){
		 try{
			 Reusables.waitThread(1);
			 Reusables.verifyElementPresent(Reusables.getIOSElement(restoreBtn), "Error Message!!Restore Button not found...");
		 }
		 catch(NoSuchElementException e){
			 Logs.error("Restore Button not found... "+e.getClass().getName());
		 }
	 }
	
	/**
	 * This method is used to verify buy button present or not.
	 */
	public static void verifyBuyButtonExistance(){
		try{
		Reusables.verifyElementPresent(Reusables.getIOSElement(buyFullFunctionalityBtn), "Error Message!!! Buy button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Buy button not present >>>>>>>>> "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify paid entity details.
	 */
	public static void verificationForPaidRecipe(){
		verifyRestoreButton();
		verifyBuyButtonExistance();
	}

	
	/**
	 * This method is used to hide inapp purchase page.
	 */
	public static void hideInAppPurchasePage(){
		try{
			Reusables.waitForIOSElement(hideInAppPurchasePageBtn);
			Reusables.clickCommand(hideInAppPurchasePageBtn);
		}catch(NoSuchElementException e){
			Logs.error("InApp Purchase page still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the buy button.
	 */
	public static void clickOnBuyButton(){
		try{
			Reusables.waitForIOSElement(buyFullFunctionalityBtn);
			Reusables.clickCommand(buyFullFunctionalityBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click Opearation not perform on the buy button. "+e.getClass().getName());
		}
		}
	
	/**
	 * This method is used to enter user name.
	 */
	public static void enterUserName(){
		try{
			IOSElement userName = Reusables.getIOSElement(userName_txt);
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
			IOSElement userPass = Reusables.getIOSElement(userPass_txt);
			userPass.click();
			userPass.sendKeys(DataConstants.password);
		}catch(NoSuchElementException e){
			Logs.error("userPass is not entered in the userpass textbox. "+e.getClass().getName());
		}
		}
	
	/**
	 * This method is used to select purchase type.
	 * @param option : for selection purchase option.
	 */
	public static void selectPurchaseOption(String option){
		try{
			Reusables.waitForIOSElement(buyFullFunctionalityBtn);
			Reusables.waitThread(2);
			if (option.equalsIgnoreCase("adfree")){
				Reusables.clickCommand(buyAddFreeBtn);
			}
			else if (option.equalsIgnoreCase("allfunctionality")){
				Reusables.clickCommand(buyFullFunctionalityBtn);
			}
		}catch(NoSuchElementException e){
			Logs.error("Purchase Options not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify first time login
	 * @param option : for selection purchase option. 
	 * @return : boolean as status.
	 */
	public static boolean verifyFirstTimeSignin(String option){
		Reusables.waitThread(2);
		selectPurchaseOption(option);
		Reusables.waitThread(2);
		clickOnBuyButton();
		boolean status = false;
		try{
			Reusables.waitThread(4);
			if (Reusables.isElementPresent(existing_apple_id_btn) == true){
				status = true;
				Reusables.clickCommand(existing_apple_id_btn);
				Reusables.waitThread(2);
			}
			else if (Reusables.isElementPresent(existing_apple_id_btn) == false){
				status = false;
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Use Existing Apple ID not visible. "+e.getClass().getName());
			}
		
		return status;
		}
	
	/**
	 * This method is used to sign In Store.
	 * @param option : for selection purchase option. 
	 */
	public static void signInITuneStore(String option){
		boolean login_type = verifyFirstTimeSignin(option);
		System.out.println("Status click.."+login_type);
		if (login_type == true){
			enterUserName();
			enterUserPass();
			Reusables.acceptAlert();
			}
		else if (Reusables.isElementPresent(buyFullFunctionalityBtn) == true){
		}
		else if (login_type == false){
			enterUserPass();
			Reusables.waitThread(2);
			Reusables.acceptAlert();
			Reusables.waitThread(2);
			}
		}
	
	/**
	 * This method is used to verify app sign in confirmation message.
	 */
	public static void inAppPurchaseConfirmationMessges(){
		try{
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getIOSElement(alertBuyBtn), "Error Message!Buy button not visbile.");
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
		}
		catch(NoSuchElementException e){
			Logs.error("Already Purchased message not displayed. "+e.getClass().getName());
			}
		}
	
	public static void confirmAlreadyPurchaseAlert(){
		try{
			Reusables.waitThread(3);
			Reusables.acceptAlert();
			Reusables.waitThread(3);
		}
		catch(NoSuchElementException e){
			Logs.error("Thank you message not visible");
			}
		}
	
	public static void alreadyConfirmPurchaseAlertPopup(){
		clickOnBuyButton();
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

}
