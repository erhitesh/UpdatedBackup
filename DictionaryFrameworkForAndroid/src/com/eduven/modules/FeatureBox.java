package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class FeatureBox {

	/* AndroidDriver Instance */
	AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By feature_box_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/feature_box"); 
	public static By feature_box_page_header_txt = By.name(DataConstants.feature_box_header_txt);
	public static By playerName_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/text");
	public static By previous_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/previous");
	public static By next_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/next");
	public static By description_lbl = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By entityName_txtview = By.id(DeviceRelatedInformation.getPackageName()+":id/termname");
	public static By entityPage_header_txt = By.name(DataConstants.playerDetailPageHeaderTxt);
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, FeatureBox instance.
	 */
	public static AndroidElement featureBoxInstance(){
		AndroidElement featureBox_element = null;
		try{
			featureBox_element = Reusables.getElement(feature_box_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Feature box Icon not found>>>  "+e.getClass().getName());
		}
		
		return featureBox_element;
	}
	

	/**
	 * This Method is used to verify home page feature box icon.
	 */
	public static void verifyHomePageFeatureBoxIcon(){
		try{
			Reusables.verifyElementPresent(featureBoxInstance(), "Error Message!!! Home Page feature box icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page feature box icon not found..>>"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Feature Box Icon.
	 */
	public static void NavigateToFeatureBoxPage(){
		try{
			Reusables.clickUsingElement(featureBoxInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on FeatureBox Icon "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyFeaturePageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(feature_box_page_header_txt), DataConstants.feature_box_header_txt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page..Feature Box Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get player name.
	 */
	public static String getSelectRandomName(){
		String playerName = "";
		try{
			int playerCount = Reusables.getElementsList(playerName_txt).size();
			playerName = Reusables.getTextFromList(playerName_txt, Reusables.randomNumber(playerCount));
			Reusables.clickCommand(By.name(playerName));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Player Name not found."+e.getClass().getName());
		}
		
		return playerName;
	}
	
	/**
	 * This method is used to verify page header txt.
	 */
	public static void verifyEntityHeaderPageText(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(entityPage_header_txt), DataConstants.feature_entity_header_txt, "Error Message!! Entity header txt not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>> Entity Header txt not matched.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the button.
	 */
	public static void clickOnButton(String operationType){
		try{
			if (operationType.equalsIgnoreCase("previous")){
				Reusables.clickUsingElement(Reusables.getElement(previous_btn));
			}
			else if (operationType.equalsIgnoreCase("next")){
				Reusables.clickUsingElement(Reusables.getElement(next_btn));
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> Buttons not clickable.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get Entity name.
	 */
	public static String getEntityName(){
		String entity_name = "";
		try{
			entity_name = Reusables.getText(entityName_txtview);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Entity Name not found.. "+e.getClass().getName());
		}
		return entity_name;
	}
	
	/**
	 * This method is used to verify entity name not matched..
	 */
	public static void verifyEntityNameAfterClick(String expectedEntityName){
		try{
			Reusables.verifyEqualMessage(getEntityName(), expectedEntityName, "Error Message!! Entity Name not found..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Entity Name not match.. "+e.getClass().getName());
		}
	}
}
