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


public class EduBank {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	
	/* Locator Identity */
	public static By eduBank_category = By.id(DeviceRelatedInformation.getPackageName()+":id/favView");
	public static By entity_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	public static By eduBank_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_fav_btn");
	public static By add_favourite_name = By.id(DeviceRelatedInformation.getPackageName()+":id/title_textView");
	public static By edubankAlertMessage = By.id("android:id/message");
	public static By edubankAlertAcceptBtn = By.id("android:id/button1");
	
	/**
	 * This method is used to click on the eduBank button.
	 */
	public static void clickEduBankCategory(){
		try{
			Reusables.waitForElement(eduBank_category);
			Reusables.getElement(eduBank_category).click();
		}
		catch(NoSuchElementException e){
			Logs.error("Error Message EduBank category not click. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify alert message for empty EduBank.
	 * 
	 */
	public static void edubankEmptyAlertMessage(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(edubankAlertMessage), DataConstants.edubankAlertMessage, "Error Message!!EduBank Alert Message Not matched");
		}catch(NoSuchElementException e){
			Logs.error("EduBank Alert Message Not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify either entity in eduBank or not
	 */
	public static void verifyEntityInEduBank(){
		try{
			edubankEmptyAlertMessage();
			Reusables.waitForElement(edubankAlertAcceptBtn);
			Reusables.clickCommand(edubankAlertAcceptBtn);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>> EduBank have entities. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to find out count of entities in eduBank.
	 * @return :type int , total entities in eduBank.
	 */
	public static int elementCountInEduBank(){
		
		return Reusables.getElementsList(entity_count).size();
	}
	
	/**
	 * This method is used to select first entity from eduBank entities.
	 */
	public static void clickFirstEduBankEntity(){
		Reusables.getElementsList(entity_count).get(0).click();
	}
	
	/**
	 * This method is used to add entity in the eduBank
	 */
	public static void addEntityToEduBank(){
		try {
			Reusables.clickCommand(eduBank_icon);
		} catch (NoSuchElementException e) {
		}
	}
	
	/**
	 * This method is used to remove entity from eduBank.
	 */
	public static void removeEntityFromEduBank(){
		addEntityToEduBank();
	}
	
	/**
	 * This method is used to navigate to eduBank.
	 */
	public static void navigateToEduBank(){
		while (! Reusables.getElement(eduBank_category).isDisplayed()){
			Reusables.stepBack();
		}
	}
	
	/**
	 * This method is used to get the entity name
	 * @return : type String, return entity name.
	 */
	public static String getFavouriteEntityName(){
		
		return Reusables.getElement(add_favourite_name).getText();
	}
}
