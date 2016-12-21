package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.AndroidElement;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class TermDetailPage {
	
	
	/* Object Identification */   
	public static By termName = By.id(DeviceRelatedInformation.getPackageName()+":id/termname");
	public static By favouriteIcon = By.id(DeviceRelatedInformation.getPackageName()+":id/add_to_favorites");
	public static By descriptionLbl = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By termDescriptionMessageTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By editContributeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/editContribute");
	public static By contributeSubmitBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/contribute");
	public static By contributeTitle = By.id(DeviceRelatedInformation.getPackageName()+":id/word");
	public static By contributeDescription = By.id(DeviceRelatedInformation.getPackageName()+":id/desciption");
	public static By previousBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/previous");
	public static By nextBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/next");
	public static By speakBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/speak");
	public static By autoPlayBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/autoplay");
	public static By autoPlayPauseBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/autoplaypause");
	
	//For buy subscription
	public static By noThanksBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_cancel");
	public static By unlockNowBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_upgrade");
	public static By contributeLaterBtn = By.id("android:id/button2");
	public static By contributeLaterAlertMessage = By.id("android:id/message");
	

	// Edit Contribute 
	
	/**
	 * This method is used to get the entity name.
	 * @return : Title Name, type String
	 */
	public static String getTermName(){
		String termNameValue = "";
		try{
			Reusables.waitThread(1);
			termNameValue = Reusables.getText(termName);
		}
		catch(NoSuchElementException e){
			Logs.error("Term Name not found. "+e.getClass().getName());
		}
		
		return termNameValue;
	}
	
	/**
	 * This method is used to verify term name on term detail page.
	 * @param termName : String type 
	 */
	public static void verifyTermNameOnTermDetailPage(String termName){
		try{
			Reusables.verifyEqualMessage(getTermName(), termName, "Error Message!!Actual & Expected term not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("Actual & Expected term not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get the entity Description.
	 * @return : Description, type String
	 */
	public static String getTermDescription(){
		String termDescription = "";
		try{
			Reusables.waitForElement(termDescriptionMessageTxt);
			termDescription = Reusables.getTextFromList(termDescriptionMessageTxt, 1);
		}
		catch(NoSuchElementException e){
			Logs.error("Term Description not found. "+e.getClass().getName());
		}
		
		return termDescription;
	}
	
	
	/**
	 * This method is used to click on the edit contribute.
	 */
	public static void clickOnEditContribute(){
		try{
			Reusables.waitForElement(editContributeBtn);
			Reusables.clickUsingElement(Reusables.getElement(editContributeBtn));
		}
		catch(NoSuchElementException e){
			Logs.error("Edit contribute button still visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Contribute page loaded.
	 */
	public static void verifyContributePageLoaded(){
		try{
			Reusables.stepBack();
			Reusables.waitForElement(contributeSubmitBtn);
			Reusables.verifyElementPresent(Reusables.getElement(contributeSubmitBtn), "Error Message!!Contribute button not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get contribute title name.
	 */
	public static String getContributeTitle(){
		String contributeTitleTxt = "";
		try{
			contributeTitleTxt = Reusables.getText(contributeTitle);
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute title text not found."+e.getClass().getName());
		}
		
		return contributeTitleTxt;
	}
	
	/**
	 * This method is used to get contribute description message.
	 */
	public static String getContributeDescription(){
		String contribute_description_txt = "";
		try{
			contribute_description_txt = Reusables.getText(contributeDescription);
		}
		catch(NoSuchElementException e){
			Logs.error(" Contribute description text not found."+e.getClass().getName());
		}
		
		return contribute_description_txt;
	}
	
	/**
	 * This method is used to verify contribute title with entity title.
	 */
	public static void verifyContributePageTitle(String contributeTitle, String entityTitle){
		try{
			Reusables.waitThread(1);
			Reusables.verifyEqualMessage(contributeTitle, entityTitle, "Error Message!! Contribute Term not matched with Term Name.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Term not matched with Term Name. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify contribute title with entity title.
	 */
	public static void verifyContributePageDescription(String contributeDescription, String entityDescription){
		try{
			Reusables.waitThread(1);
			Reusables.verifyEqualMessage(contributeDescription, entityDescription, "Error Message!! Contribute Description not matched with Term Description.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Description not matched with Term Description. "+e.getClass().getName());
		}
	}
	
	
	// Free Entity Related 
	/**
	 * This method is used to verify selected entity name on entity detail page.
	 */
	public static void verifyCategoryTermName(String expectedTermName){
		try{
			Reusables.waitForElement(termName);
			Reusables.verifyEqualMessage(getTermName(), expectedTermName, "Error Message!! Term Name not matched...");
		}
		catch(NoSuchElementException e){
			Logs.error("Term Name not found.  "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to check the eduBank icon present or not
	 */
	public static void checkFavIcon(){
		try{
			Reusables.waitForElement(favouriteIcon);
			Reusables.verifyElementPresent(Reusables.getElement(favouriteIcon), "Error Message! Favourite icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Favourite icon not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to check description lbl.
	 */
	public static void checkDescriptionHeaderLbl(){
		try{
			Reusables.waitForElement(descriptionLbl);
			Reusables.verifyElementPresent(Reusables.getElement(descriptionLbl), "Error Messgae!!Description Header text not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Description Header not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * this method is used to verify free entity detail for favorite logo.
	 */
	public static void detailPageVerificationForFreeTerm(String expectedTermName){
		verifyCategoryTermName(expectedTermName);
		checkDescriptionHeaderLbl();
		checkFavIcon();
	}
	
	
	//****************************************************For Paid Entity************************************
	/**
	 * this method is used to verify No Thanks button present or not.
	 */
	 public static void verifyNoThanksButton(){
		 try{
			 Reusables.waitForElement(noThanksBtn);
			 Reusables.verifyElementPresent(Reusables.getElement(noThanksBtn), "Error Message!! No Thanks button not found...");
		 }
		 catch(NoSuchElementException e){
			 Logs.error("No Thanks button not present. "+e.getClass().getName());
		 }
	 }
	
	/**
	 * this method is used to verify buy button present or not.
	 */
	public static void verifyUnlockButtonExistance(){
		try{
			Reusables.waitForElement(unlockNowBtn);
			Reusables.verifyElementPresent(Reusables.getElement(unlockNowBtn), "Error Message!!! Unlock Now button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Unlock Now button not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify paid entity details.
	 */
	public static void detailPageVerificationForPaidTerm(){
		verifyNoThanksButton();
		verifyUnlockButtonExistance();;
	}
	
	
	// Audio control related
	/**
	 * This method is used to return the instance of Previous Button.
	 */
	public static AndroidElement previousButtonInstance(){
		
		return Reusables.getElement(previousBtn);
	}
	
	
	/**
	 * This method is used to return the instance of Next Button.
	 */
	public static AndroidElement nextButtonInstance(){
		
		return Reusables.getElement(nextBtn);
	}
	
	
	/**
	 * This method is used to return the instance of Speak Button.
	 */
	public static AndroidElement speakButtonInstance(){
		
		return Reusables.getElement(speakBtn);
	}
	
	
	/**
	 * This method is used to return the instance of AutoPlay Button.
	 */
	public static AndroidElement autoPlayButtonInstance(){
		
		return Reusables.getElement(autoPlayBtn);
	}
	
	/**
	 * This method is used to click on the Previous Button.
	 */
	public static void clickOnPreviousButton(){
		try{
			Reusables.clickUsingElement(previousButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(" Previous Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Next Button.
	 */
	public static void clickOnNextButton(){
		try{
			Reusables.clickUsingElement(nextButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(" Next Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Speak Button.
	 */
	public static void clickOnSpeakButton(){
		try{
			Reusables.clickUsingElement(speakButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(" Speak Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Auto Play Button
	 */
	public static void clickOnAutoPlayButton(){
		try{
			while (Reusables.getElement(autoPlayBtn).isEnabled() == false){
				Reusables.waitThread(2);
			}
			Reusables.clickUsingElement(autoPlayButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(" AutoPlay Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Auto Play Button
	 */
	public static void stopAutoPlayPauseButton(){
		try{
			if (Reusables.getElement(autoPlayPauseBtn).isEnabled() == true){
				Reusables.clickUsingElement(Reusables.getElement(autoPlayPauseBtn));
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" AutoPlay Button not clickable... "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify element enable.
	 */
	public static void verifyButtonsEnableBeforeSpeakButtonClick(){
		Reusables.verifyElementEnable(nextButtonInstance(), "Error Message!! Next Button still disable");
		Reusables.verifyElementEnable(previousButtonInstance(), "Error Message!! Previous Button still disable");
		Reusables.verifyElementEnable(autoPlayButtonInstance(), "Error Message!! AutoPlay Button still disable");
	}
	
	/**
	 * This method is used to verify element Disable.
	 */
	public static void verifyButtonsDisableAfterSpeakButtonClick(){
		Reusables.verifyElementDisable(nextButtonInstance(), "Error Message!! Next Button still enable");
		Reusables.verifyElementDisable(previousButtonInstance(), "Error Message!! Previous Button still enable");
		Reusables.verifyElementDisable(autoPlayButtonInstance(), "Error Message!! AutoPlay Button still enable");
	}
	
	/**
	 * This method is used to verify element enable.
	 */
	public static void verifyButtonsEnableBeforeAutoPlayButtonClick(){
		Reusables.verifyElementEnable(nextButtonInstance(), "Error Message!! Next Button still Disable");
		Reusables.verifyElementEnable(previousButtonInstance(), "Error Message!! Previous Button still Disable");
		Reusables.verifyElementEnable(speakButtonInstance(), "Error Message!! Speak Button still Disable");
	}
	
	/**
	 * This method is used to verify element Disable.
	 */
	public static void verifyButtonsDisableAfterAutoPlayButtonClick(){
		Reusables.verifyElementDisable(nextButtonInstance(), "Error Message!! Next Button still enable");
		Reusables.verifyElementDisable(previousButtonInstance(), "Error Message!! Previous Button still enable");
		Reusables.verifyElementDisable(speakButtonInstance(), "Error Message!! Speak Button still enable");
	}
	
	/**
	 * his method is used to verify entity name after click next/previous button.
	 */
	public static void verifyTermName(String beforeClick, String afterClick){
		try{
			Reusables.verifyNotEqualMessage(beforeClick, afterClick, "Error Message!! Entity Name not matched...");
		}
		catch(NoSuchElementException r){
			Logs.error(" Term Name not matched...."+r.getClass().getName());
		}
	}
	
	// Related Contribute later 
	/**
	 * This method is used to verify contribute later popup message.
	 */
	public static void verifyContributeLaterMessagePopUp(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(contributeLaterAlertMessage), DataConstants.contributeLaterPopupMessage, "Error Message!! Contribute later message not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute later message not found....."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to submit the contribute later popup message.
	 * @param termName : Strinf type 
	 */
	public static void submitContributeLaterPopupMessage(String termName){
		try{
			Reusables.waitThread(1);
			Reusables.clickUsingElement(Reusables.getElement(contributeLaterBtn));
			Reusables.waitThread(1);
			Reusables.verifyElementPresent(Reusables.getElement(By.name(termName)), "Error Message!! Entity Name not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Later btn still visible... "+e.getClass().getName());
		}
	}
}
