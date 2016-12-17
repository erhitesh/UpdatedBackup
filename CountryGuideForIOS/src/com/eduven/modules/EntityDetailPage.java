package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class EntityDetailPage {
	
	/* IOSDriver instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Locator Identity */
	public static By term_name_txt = By.name("TermName");
	public static By detail_page_fb_icon = By.name("FBShareButton");
	public static By favourite_icon = By.name("FavBtn");
	public static By description = By.name("Description");
	public static By pck_btn = By.name("package with glow");
	public static By add_btn = By.name("ad free with shadow");
	public static By buy_btn = By.name("Buy");
	public static By restore_btn = By.name("Restore");
	public static By cancel_btn = By.name("cancel button");
	//For buy subscription
	public static By existing_apple_id_btn = By.name("Use Existing Apple ID");
	public static By userName_txt = By.xpath("//UIATextField");
	public static By userPass_txt = By.xpath("//UIASecureTextField");
	public static By confirm_message = By.xpath("//UIAStaticText[@name='Confirm Your In-App Purchase']");	
	public static By already_purchase_message = By.xpath("//UIAStaticText[2]");
	public static By thank_you_message = By.xpath("//UIAStaticText[@name='Thank You']");
	public static By congratulation_message = By.xpath("//UIAStaticText[@name='Congratulations!']");
	
	//****************************************Free entity***************************************
	public static String getEntityName(){
		String termName = "";
		try{
			termName = Reusables.getElement(term_name_txt).getText();
			System.out.println("Term Name.."+termName);
			
		}
		catch(NoSuchElementException e){
			Logs.error("Term Name Not found. "+e.getClass().getName());
		}
		
		return termName;
	}
	
	public static void checkFBLogo(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(detail_page_fb_icon), "Error Message! Facebook icon not displayed.");
		}
		catch(NoSuchElementException e){
			Logs.error("FaceBook icon present not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check Favorite Icon.
	 */
	public static void checkFavIcon(){
		try{
		Reusables.verifyElementPresent(Reusables.getElement(favourite_icon), "Error Message!! Favourite icon not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Favourite icon not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check Description header text.
	 */
	public static void checkDescriptionHeader(){
		try{
		Reusables.verifyElementPresent(Reusables.getElement(description), "Error Messgae! Description Header text not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Description Header not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify free entity detail for Favorite Logo.
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
			Logs.error("Add button icon not present. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify buy button Existance.
	 */
	public static void verifyBuyButtonExistance(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(buy_btn), "Error Message! Buy button not visible.");
			}
		catch(NoSuchElementException e){
			Logs.error("Buy button icon not present. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify restore button.
	 */
	public static void verifyRestoreButtonExistance(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(restore_btn), "Error Message! Restore button not visible.");
			}
		catch(NoSuchElementException e){
			Logs.error("Restore button icon not present. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to return the instance of cancel button.
	 * @return : IOSElement.
	 */
	public static IOSElement cancelButton(){
		
		return Reusables.getElement(cancel_btn);
		}
	
	/**
	 * This method is used to verify cancel button existance.
	 */
	public static void verifyCancelButtonExistance(){
		try{
			Reusables.verifyElementPresent(cancelButton(), "Error Message! Cancel button not appear.");
			}
		catch(NoSuchElementException e){
			Logs.error("cancel button not exist. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to click on the cancel button.
	 */
	public static void clickOnCancelButton(){
		try{
			Reusables.click_using_element(cancelButton());
			}
		catch(NoSuchElementException e){
			Logs.error("Click on the cancel button icon not perform. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify paid entity details.
	 */
	public static void detailPageVerificationForPaidEntity(){
		verifyCancelButtonExistance();
		verifyAddButtonExistance();
		verifyRestoreButtonExistance();
		verifyBuyButtonExistance();
		verifyCancelButtonExistance();
		}
	
	
	//************************************For Unlock *****************************
	public static void clickOnBuyButtonutton(){
		try{
			Reusables.clickCommand(buy_btn);
			}
		catch(NoSuchElementException e){
			Logs.error("Buy Button still visible. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to enter user name.
	 */
	public static void enterUserName(){
		try{
			IOSElement userName = Reusables.getElement(userName_txt);
			userName.click();
			userName.sendKeys(DataConstants.userName);
			}
		catch(NoSuchElementException e){
			Logs.error("UserName is not visible. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to enter user password.
	 */
	public static void enterUserPass(){
		try{
			IOSElement userPass = Reusables.getElement(userPass_txt);
			userPass.click();
			userPass.sendKeys(DataConstants.userPass);
		}
		catch(NoSuchElementException e){
			Logs.error("userPass is not visible. "+e.getClass().getName());
			}
		}
	
	public static Alert alert_instance(){
		
		return Reusables.alertInstance();
	}
	
	/**
	 * This method is used to verify first time login
	 * @return : boolean as status.
	 */
	public static boolean verifyFirstTimeSignin(){
		clickOnBuyButtonutton();
		alert_instance();
		boolean status = false;
		try{
			Reusables.waitThread(4);
			if (Reusables.getElement(existing_apple_id_btn).isDisplayed() == true){
				status = true;
				Reusables.clickCommand(existing_apple_id_btn);
			}
			}
		catch(NoSuchElementException e){
			//Logs.error("Use Existing Apple ID not visible. "+e.getClass().getName());
			}
		
		return status;
		}
	
	/**
	 * This method is used to sign In Store.
	 */
	public static void signInStore(){
		boolean login_type = verifyFirstTimeSignin();
		//System.out.println("Login Status. "+login_type);
		if ( login_type == true){
			enterUserName();
			enterUserPass();
			}
		else if (Reusables.isElementPresent(buy_btn) == true){
		}
		else if ( login_type == false){
			enterUserPass();
			}
		alert_instance().accept();
		}
	
	/**
	 * This method is used to verify app sign in confirmation message.
	 */
	public static void appSigninConfirmationMessges(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(buy_btn), "Error Message! Buy button not visbile...");
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>> Buy button not visible. "+e.getClass().getName());
			}
		Reusables.waitThread(1);
		alert_instance().accept();
		}

//********************************* alredy_purchased ************************************
	public static void alredyPurchasedMessageAlert(){
		try{
			Reusables.waitThread(3);
			Assert.assertTrue(Reusables.getAlertMessage().contains(DataConstants.already_purchase_app_message), "Error Message Alert messages does not matched..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Already Purchased message not displayed. "+e.getClass().getName());
			}
		}
	
	public static void alreadyConfirmPurchasedAlert(){
		try{
			alert_instance().accept();
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Thank you message not visible. "+e.getClass().getName());
			}
		}
	
	public static void alreadyConfirmPurchaseAlertPopup(){
		alredyPurchasedMessageAlert();
		alreadyConfirmPurchasedAlert();
		}
	
	public static void donePayment(){
		Reusables.acceptAlert();
		Reusables.acceptAlert();
		Reusables.acceptAlert();
	}
	
//**************************************thank_you*******************************	
	public static void verifyThankYouMessageAlert(){
		try{
			Reusables.waitThread(1);
			Assert.assertTrue(Reusables.getAlertMessage().contains(DataConstants.thank_you_message), "Error Message! Alert messages does not matched.");
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>> Thank you message still visible. "+e.getClass().getName());
			}
		}
	
	public static void acceptThankYouMessageAlert(){
		alert_instance().accept();
		}
	
	public static void thankYouAlertPopup(){
		verifyThankYouMessageAlert();
		acceptThankYouMessageAlert();
		}
	
//*************************************	congratulation|*********************
	public static void verifyCongratulationMessageAlert(){
		try{
			Reusables.waitThread(2);
			Assert.assertTrue(Reusables.getAlertMessage().contains(DataConstants.congratuation_message), "Error Message! Alert messages does not matched.");
			}
		catch(NoSuchElementException e){
			Logs.error("Congratulation message not display. "+e.getClass().getName());
			}
		}
	
	public static void acceptCongratulationAlert(){
		alert_instance().accept();
	}
	
	
	public static void congratulationAlertPopup(){
		verifyCongratulationMessageAlert();
		acceptCongratulationAlert();
		}
	
}
