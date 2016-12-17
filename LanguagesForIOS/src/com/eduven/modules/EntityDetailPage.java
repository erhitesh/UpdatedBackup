package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class EntityDetailPage {
	
	
	/* Object Identification */
	public static By purchaseBtn = By.xpath("//UIAButton[@name='be pro'][1]");
	public static By doneBtn = By.name("Done");
	public static By premiumBtn = By.xpath("//UIAButton[@name='buttonWithAdd']");
	public static By allFunctionalityBtn = By.xpath("//UIAButton[@name='buttonWithFullFunctionality']");
	public static By allNativeLanguageBtn = By.name("buttonWithNativeLanguage");
	public static By buyBtn = By.id("Buy");
	public static By restoreBtn = By.name("Restore");
	public static By cancelBtn = By.name("Cancel");
	public static By moreAppsBtn = By.name("more apps");
	//For buy subscription
	public static By existing_apple_id_btn = By.name("Use Existing Apple ID");
	public static By userName_txt = By.xpath("//UIATextField");
	public static By userPass_txt = By.xpath("//UIASecureTextField");
	public static By confirm_message = By.xpath("//UIAStaticText[@name='Confirm Your In-App Purchase']");	
	public static By already_purchase_message = By.xpath("//UIAStaticText[2]");
	public static By thank_you_message = By.xpath("//UIAStaticText[@name='Thank You']");
	public static By congratulation_message = By.xpath("//UIAStaticText[@name='Congratulations!']");
	
	
	
	/**
	 * This method is used to get Purchase button instance.
	 * @return : IOSElement.
	 */
	public static IOSElement getPurchaseBtnInstance(){
		
		return Reusables.getElement(purchaseBtn);
	}
	
	
	/**
	 * This method is used to verify either Purchase Button present or not.
	 */
	public static void verifyPurchaseBtn(){
		try{
			Reusables.verifyElementPresent(getPurchaseBtnInstance(), "Error Message!! Purchase Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Purchase Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the Purchase page.
	 */
	public static void navigateToPurchasePage(){
		try{
			Reusables.waitThread(2);
			Reusables.tapOnElementUsingLocator(purchaseBtn);
			Reusables.waitThread(8);
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Purchase Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify premium word not found.
	 */
	public static void verifyPremiumWord(){
		try{
			Reusables.waitThread(1);
			Reusables.verifyElementNotPresent(Reusables.getElement(premiumBtn), "Error Message!!Premium Word Present.");
		}catch(NoSuchElementException e){
			Logs.error("Premium word found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select purchase type.
	 * @param option : for selection purchase option.
	 */
	public static void selectPurchaseOption(String option){
		try{
			//Reusables.waitForElement(doneBtn);
			Reusables.waitThread(2);
			if (option.equalsIgnoreCase("adfree")){
				Reusables.tapOnElementUsingLocator(premiumBtn);
			}
			else if (option.equalsIgnoreCase("allfunctionality")){
				Reusables.tapOnElementUsingLocator(allFunctionalityBtn);
			}
			else if (option.equalsIgnoreCase("allnativelangugae")){
				Reusables.waitThread(6);
				Reusables.tapOnElementUsingLocator(allNativeLanguageBtn);
			}
		}catch(NoSuchElementException e){
			Logs.error("Purchase Options not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Buy Button.
	 */
	public static void clickOnBuyBtn(){
		try{
			Reusables.waitThread(6);
			alertInstance();
			Reusables.waitThread(1);
			Reusables.clickCommand(buyBtn);
		}catch(NoSuchElementException e){
			Logs.error("Buy Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Cancel Button.
	 */
	public static void clickOnCancelButton(){
		try{
			Reusables.waitThread(2);
			alertInstance();
			Reusables.clickCommand(cancelBtn);
		}catch(NoSuchElementException e){
			Logs.error("Cancel Button not found. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to click on the Restore Button.
	 */
	public static void clickOnRestoreBtn(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(restoreBtn));
			Reusables.clickCommand(restoreBtn);
		}catch(NoSuchElementException e){
			Logs.error("Restore Button not found. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to click on the Cancel Button.
	 */
	public static void clickOnCancelBtn(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(cancelBtn));
			Reusables.clickCommand(cancelBtn);
		}catch(NoSuchElementException e){
			Logs.error("Cancel Button not found. "+e.getClass().getName());
		}
	}
	
	
	
	//************************************For Unlock *****************************
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
	
	public static Alert alertInstance(){
		
		return Reusables.alertInstance();
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
		clickOnBuyBtn();
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
	public static void signInStore(String option){
		boolean login_type = verifyFirstTimeSignin(option);
		if (login_type == true){
			enterUserName();
			enterUserPass();
			alertInstance().accept();
			}
		else if (Reusables.isElementPresent(buyBtn)){
		}
		else if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.applicationRestoreMessage)){
		}
		else if (login_type == false){
			enterUserPass();
			Reusables.waitThread(2);
			alertInstance().accept();
			Reusables.waitThread(2);
			}
		}
	
	/**
	 * This method is used to verify app sign in confirmation message.
	 */
	public static void appSigninConfirmationMessges(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(buyBtn), "Error Message! Buy button not visbile...");
			}
		catch(NoSuchElementException e){
			Logs.error("Buy button not visible. "+e.getClass().getName());
			}
		alertInstance().accept();
		}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Application restore >>>>>>>>>>>>>>>>>>>>>
	public static void applicationRestore(){
		Reusables.waitThread(2);
		if (Reusables.alertInstance().getText().equalsIgnoreCase(DataConstants.applicationRestoreMessage)){
			Reusables.acceptAlert();
			Reusables.waitThread(2);
		}
		else{
			alreadyConfirmPurchaseAlertPopup();
			thankYouAlertPopup();
			congratulationAlertPopup();
			Reusables.hideInterstetial();
		}
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
	
	public static void confirmAlreadyPurchaseAlert(){
		try{
			Reusables.waitThread(3);
			alertInstance().accept();
			Reusables.waitThread(3);
		}
		catch(NoSuchElementException e){
			Logs.error("Thank you message not visible");
			}
		}
	
	public static void alreadyConfirmPurchaseAlertPopup(){
		clickOnBuyBtn();
		alredyPurchasedMessageAlert();
		//confirmAlreadyPurchaseAlert();
		}
	
    //>>>>>>>>>>>>>>>>>>>>>>>>>>> thank You >>>>>>>>>>>>>>>>>>>>>>
	public static void verifyThankYouMessageAlert(){
		try{
			Reusables.waitThread(6);
			Assert.assertTrue(Reusables.alertInstance().getText().contains(DataConstants.thankYouMessage), "Alert messages does not matched.");
			}
		catch(NoSuchElementException e){
			Logs.error("Thank you message still visible. "+e.getClass().getName());
			}
		}
	
	public static void acceptThankYouMessageAlert(){
		Reusables.waitThread(3);
		alertInstance().accept();
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
			Assert.assertTrue(Reusables.alertInstance().getText().contains(DataConstants.congratuationMessage), "Alert messages not matched.");
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
		alertInstance().accept();
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
	 * This method is used to verify moreApp button.
	 */
	public static void verifyMoreAppsBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(moreAppsBtn), "Error Message!! More Apps Button not found.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Purchase button.
	 */
	public static void verifyPurchaseBtnNotPresent(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(purchaseBtn) == false){
				Reusables.verifyElementNotPresent(Reusables.getElement(purchaseBtn), "Error Messsage!! Purchase button Present.");
			}
		}catch(NoSuchElementException e){
			Logs.error("InApp Button found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to purchase native language.
	 * @param option : for purchase 
	 */
	public static void purchaseForNativeLanguage(String option){
		try{
			Reusables.waitThread(3);
			if (Reusables.isElementPresent(allNativeLanguageBtn) == true){
				signInStore(option);
				applicationRestore();
			}
			else if (Reusables.isElementPresent(Categories.categoryHeaderTxt) == true){
				Categories.verifyCategoryHeaderTxt();
			}
		}catch(NoSuchElementException e){
			Logs.error("Purchase Page/Category Header text not found. "+e.getClass().getName());
		}
	}
}
