package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Contribute {

	
	/* Object Identification */
	public static By contributeBtn = By.id("Footer_contribute_button");
	public static By contributeHeaderTxt = By.id("Contribute_header");
	public static By contributeTtleTxtBox = By.id("Title_text");
	public static By contributeDescriptionTxtBox = By.id("Title_Description");
	public static By contributeSubmitBtn = By.id("Submit_contribution_button");
	public static By editContributeBtn = By.id("Edit_contribute_button");
	
	
	/**
	 * This method is used to click on the Footer contribute.
	 */
	public static void clickOnContribute(){
		try{
			Reusables.waitForIOSElement(contributeBtn);
			Reusables.clickCommand(contributeBtn);;
		}
		catch(NoSuchElementException e){
			Logs.error("Edit contribute button still visible.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the edit contribute.
	 */
	public static void clickOnEditContribute(){
		try{
			Reusables.waitForIOSElement(editContributeBtn);
			Reusables.clickCommand(editContributeBtn);;
		}
		catch(NoSuchElementException e){
			Logs.error("Edit contribute button still visible.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Contribute page loaded.
	 */
	public static void verifyContributePageLoaded(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(contributeHeaderTxt), "Error Message!! Contribute button not found.");
			Reusables.hideKeyboard("no key");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Page not loaded.."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to enter title message in the title text.
	 */
	public static void enterTitleMessage(){
		String titleName = "";
		try{
			titleName = DatabaseConnection.getUnLockTerm(DatabaseConnection.randomCategoryName());
			Reusables.waitForIOSElement(contributeTtleTxtBox);
			Reusables.enterMessageInTextBox(contributeTtleTxtBox, titleName, true, "no key");
		}catch(NoSuchElementException e){
			Logs.error("Unable to enter the text message in the text box. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to enter Description message in the title text.
	 */
	public static void enterDescriptionMessage(){
		String descriptionTxt = "";
		try{
			descriptionTxt = DatabaseConnection.termDescription();
			if (descriptionTxt.length() == 0){
				descriptionTxt = DatabaseConnection.termDescription();
			}
			Reusables.waitForIOSElement(contributeDescriptionTxtBox);
			Reusables.enterMessageInTextBox(contributeDescriptionTxtBox, descriptionTxt, true, "no key");
		}catch(NoSuchElementException e){
			Logs.error("Unable to enter the text message in the description text box. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get contribute title name.
	 */
	public static String getContributeTitle(){
		String contributeTitleTxt = "";
		try{
			contributeTitleTxt = Reusables.getText(contributeTtleTxtBox);
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute title text not found. "+e.getClass().getName());
		}
		
		return contributeTitleTxt;
	}
	
	/**
	 * This method is used to get contribute description message.
	 */
	public static String getContributeDescription(){
		String contributeDescriptionTxt = "";
		try{
			contributeDescriptionTxt = Reusables.getText(contributeDescriptionTxtBox);
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute description text not found. "+e.getClass().getName());
		}
		
		return contributeDescriptionTxt;
	}
	
	
	/**
	 * This method is used to verify contribute alert popup for blank text values for contribute.
	 */
	public static void verifyContributeWithoutValue(){
		try{
			if (Reusables.alertInstance() != null){
				Reusables.verifyEqualMessage(Reusables.getAlertMessage(), DataConstants.contributeAlertMessageForBlankText, "Error Message!Alert text not matched.");
				Reusables.acceptAlert();
				Reusables.waitThread(2);
			}
		}catch(NoSuchElementException e){
			Logs.error("Alert popup not found for empty text. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the contribute submit button.
	 */
	public static void submitContribute(){
		try{
			Reusables.waitForIOSElement(contributeSubmitBtn);
			Reusables.clickCommand(contributeSubmitBtn);
		}catch(NoSuchElementException e){
			Logs.error("Contribute submit button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify contribute alert popup for blank text values for contribute.
	 */
	public static void verifyContributeSuccessfullSubmit(){
		try{
			Reusables.waitThread(5);
			if (Reusables.alertInstance() != null){
				Reusables.verifyEqualMessage(Reusables.getAlertMessage(), DataConstants.contributeAlertMessageForSuccessfull, "Error Message!Alert text not matched.");
				Reusables.acceptAlert();
				Reusables.waitThread(2);
			}
		}catch(NoSuchElementException e){
			Logs.error("Alert popup not found for successfully submission. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify contribute title with entity title.
	 */
	public static void verifyContributePageTitle(String contributeTitle, String termTitle){
		try{
			Reusables.verifyEqualMessage(contributeTitle, termTitle, "Error Message!! Contribute Title not matched with Term Title.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Title not matched with Term Title."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify contribute title with entity title.
	 */
	public static void verifyContributePageDescription(String contributeDescription, String entityDescription){
		try{
			Reusables.verifyEqualMessage(contributeDescription, entityDescription, "Error Message!! Contribute Description not matched with Term Description.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Description not matched with Term Description. "+e.getClass().getName());
		}
	}
	
}
