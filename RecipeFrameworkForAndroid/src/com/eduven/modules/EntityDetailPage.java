package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class EntityDetailPage {
	
	
	/* Locator Identification */     
	public static By detail_page_header_text = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.xpath("//*[@text='Recipe Detail']");
	public static By recipe_name = By.id(DeviceRelatedInformation.getPackageName()+":id/title");
	public static By editEdubankBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dots");
	
	//For buy subscription
	public static By get_full_App_btn = By.name("Get full App");
	public static By restore_btn = By.xpath("//*[@name='Restore'][1]");
	public static By buy_btn = By.xpath("//*[@name='Buy'][1]");
	public static By closePurchaseAppPage = By.name("close button");

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Free Entity Related >>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to verify selected Recipe name on Recipe detail page.
	 */
	public static void verifyRecipeName(String expectedEntityName){
		try{
			Reusables.verifyEqualMessage(EntityDetailPageUpperPart.recipeName(), expectedEntityName, "Error Message!! Recipe Name not matched...");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>> Recipe Name not found.  "+e.getClass().getName());
		}
	}
	

	/**
	 * this method is used to verify free entity detail for favorite Logo.
	 */
	public static void detailPageVerificationForFreeEntity(String expectedRecipeName){
		verifyDetailPagePageLoaded();
		verifyRecipeName(expectedRecipeName);
	}
	
	//****************************************************For Paid Entity************************************
	/**
	 * this method is used to verify Restore Button.
	 */
	 public static void verifyRestoreButton(){
		 try{
			 Reusables.waitThread(1);
			 Reusables.verifyElementEnable(Reusables.getElement(restore_btn), "Error Message!!Restore Button not found...");
		 }
		 catch(NoSuchElementException e){
			 Logs.error(">>>>>>>>>>>>>>>>Restore Button not found... "+e.getClass().getName());
		 }
	 }
	
	/**
	 * This method is used to verify buy button present or not.
	 */
	public static void verifyBuyButtonExistance(){
		try{
		Reusables.verifyElementEnable(Reusables.getElement(buy_btn), "Error Message!!! Buy button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Buy button not present >>>>>>>>> "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify close the app purchase button.
	 */
	public static void verifyLockPurchaseAppButton(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(closePurchaseAppPage), "Error Message!!Verify close buton not found.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>> Close Button not Found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to close the app purchase page.
	 */
	public static void clockPurchaseAppPage(){
		try{
			if (Reusables.isElementPresent(closePurchaseAppPage) == true){
				Reusables.clickUsingElement(Reusables.getElement(closePurchaseAppPage));
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>> This method is used to close the 'app purchase' page"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify paid entity details.
	 */
	public static void detailPageVerificationForPaidEntity(){
		verifyLockPurchaseAppButton();
		verifyRestoreButton();
		verifyBuyButtonExistance();
	}


	/* Detail Page verification */
	
	/**
	 * This method is used to verify Detail page loaded or not..
	 */
	public static void verifyDetailPagePageLoaded(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(detail_page_header_text), DataConstants.detail_page_header, "Error Message!! Detail Page is not Loaded.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>Detail Page is not Loaded. "+e.getClass().getName());
		}
	}
	
	
	
	/*	
	//>>>>>>>>>>>>>>>>>>>>>>>>> For Purchase App  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	*//**
	 * This method is used to click on the Buy button.
	 *//*
	public static void clickOnBuyButton(){
		try{
			Reusables.click_using_element(Reusables.get_element(buy_btn));
		}
		catch(Exception e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Buy Button still visible "+e.getClass().getName());
		}
	}
	
	*//**
	 * This method is used to verify app purchase title message.
	 *//*
	public static void verifyAppPurchaseTitle(){
		try{
			String app_purchase_title_message = Reusables.alert_instance().getText();
			System.out.println("App Title..."+app_purchase_title_message);
			Reusables.verify_txt_message(app_purchase_title_message, DataConstants.app_purchase_confirmatim_title, "Error Message! App purchase alert text message does not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> App purchase title message does not matched "+e.getClass().getName());
		}
	}

	
	*//**
	 * This method is used to verify app purchase successfully message.
	 *//*
	public static void verifyPurchaseAppSuccessfullMessage(){
		try{
			Reusables.verify_element_present(Reusables.get_element(app_successful_completion_msg), "Error Message!! Payment SuccessFull message not present.!!");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> App purchase successfully message not found.."+e.getClass().getName());
		}
	}
	
	
	//********************************* alredy_purchased ************************************
	public static boolean alreadyPurchasedMessage(){
		boolean status = false;
		try{
			Reusables.verify_txt_message(Reusables.getText(already_purchase_message_popup), DataConstants.already_purchase_app_message, "Error Message!! Alert messages does not matched..");
			status = true;
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Already Purchased message not displayed.... "+e.getClass().getName());
		}
		
		return status;
	}
	
	*//**
	 * This method is used to submit the already purchase pop up message box.
	 *//*
	public static void submitAlreadyPurchasePopUpMessageBox(){
		try{
			
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Already purchase popup message still visible.."+e.getClass().getName());
		}
	}

	*//**
	 * This method is used to purchase app subscription.
	 *//*
	public static void appPurchase(){
		Reusables.waitThread(4);
		
		if (alreadyPurchasedMessage() == true){
			Reusables.waitThread(2);
			submitAlreadyPurchasePopUpMessageBox();
		}
		else if (Reusables.alert_instance().getText().equalsIgnoreCase(DataConstants.app_purchase_confirmatim_title)){
			verifyAppPurchaseTitle();
			clickOnBuyButton();
			Reusables.waitThread(2);
		}
	}*/
}
