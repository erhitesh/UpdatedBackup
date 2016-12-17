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
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By adfreeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_upgrade");
	public static By allFunctionalityBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/buy_full");
	public static By allNativeLanguageBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_buy_cards");
	public static By buyBtn = By.id("com.android.vending:id/continue_button");
	public static By purchaseBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/ivMoreApps");
	public static By restoreBtn = By.name("Restore");
	public static By moreAppsBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/ivMoreApps");
	public static By accept_alert = By.id("android:id/button1");
	public static By already_purchase_message = By.id("android:id/message");
	public static By app_purchase_txt = By.id("com.android.vending:id/item_title");
	public static By app_successful_completion_msg = By.name("Payment Successful");

	
	
	/**
	 * This method is used to navigate to the Purchase page.
	 */
	public static void navigateToPurchasePage(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(purchaseBtn));
			Reusables.clickUsingElement(Reusables.getElement(purchaseBtn));
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Purchase Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify elements on payment page.
	 */
	public static void verifyElementsOnPaymentPage(){
		try{
			
		}catch(NoSuchElementException e){
			Logs.error("Elements not found. "+e.getClass().getName());
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
				Reusables.clickCommand(adfreeBtn);
			}
			else if (option.equalsIgnoreCase("allfunctionality")){
				Reusables.clickUsingElement(Reusables.getElement(allFunctionalityBtn));
			}
			else if (option.equalsIgnoreCase("allnativelangugae")){
				Reusables.waitThread(6);
				Reusables.clickUsingElement(Reusables.getElement(allNativeLanguageBtn));
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
			Reusables.waitThread(2);
			Reusables.clickCommand(buyBtn);
		}catch(NoSuchElementException e){
			Logs.error("Buy Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify already purchase message.
	 * @return : boolean type for condition checking.
	 */
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
	
	/**
	 * This method is used to verify app purchase title.
	 * 
	 */
	public static void verifyAppPurchaseTitle(){
		try{
			String app_purchase_title_message = Reusables.getText(app_purchase_txt);
			//System.out.println(app_purchase_title_message);
			Reusables.verifyEqualMessage(app_purchase_title_message, DataConstants.alert_message_before_app_purchase, "Error Message! App purchase alert text message does not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("App purchase title message does not matched");
		}
	}
	
	/**
	 * This method is used to verify successfully app purchase message.
	 * 
	 */
	public static void verifyCongratulationMessage(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(app_successful_completion_msg), DataConstants.congratuation_message, "Error Message! Alert messages does not matched.....");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Congratulation message not display. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to sign In Store.
	 * @param option : for selection purchase option. 
	 */
	public static void signInStore(String option){
		selectPurchaseOption(option);
		try{
			if (alreadyPurchasedMessage() == true){
				Reusables.waitThread(2);
				Reusables.clickCommand(accept_alert);
			}
			else if (alreadyPurchasedMessage() == false){
				verifyAppPurchaseTitle();
				Reusables.clickCommand(buyBtn);
				Reusables.waitThread(2);
				//verifyCongratulationMessage();
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Unable to purchase app for full functionality. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to purchase native language.
	 * @param option : for purchase 
	 */
	public static void purchaseForNativeLanguage(String option){
		try{
			Reusables.waitThread(3);
			if (Reusables.isElementPresent(allFunctionalityBtn) == true){
				signInStore(option);
			}
			else if (Reusables.isElementPresent(Categories.categoryHeaderTxt) == true){
				Categories.verifyCategoryHeaderTxt();
			}
		}catch(NoSuchElementException e){
			Logs.error("Purchase Page/Category Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify moreApp button.
	 */
	public static void verifyMoreAppsBtn(){
		try{
			Reusables.waitForElement(moreAppsBtn);
			Reusables.verifyElementPresent(Reusables.getElement(moreAppsBtn), "Error Message!! More Apps Button not found.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps Button Not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify moreApp button.
	 */
	public static void verifyInAppBtn(){
		try{
			Reusables.verifyElementNotPresent(Reusables.getElement(purchaseBtn), "Error Message!! Purchase Button found.");
		}catch(NoSuchElementException e){
			Logs.error("Purchase Button found. "+e.getClass().getName());
		}
	}
	
}
