package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class EduBank {
	
	/* IOSDriver instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	
	/* Locator Identity */
	public static By eduBank_category = By.name("favorites_menu.png");
	public static By element_count = By.xpath("//UIACollectionCell");
	public static By eduBank_icon = By.name("FavBtn");
	public static By add_favourite_name = By.xpath("//UIAStaticText[1]");
	
	/**
	 * This method is used to click on the EduBank category icon.
	 */
	public static void clickEduBankCategory(){
		try{
			Reusables.getElement(eduBank_category).click();
			}
		catch(NoSuchElementException e){
			Logs.error("Error Message EduBank category not click. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to accept the alert PopUp.
	 */
	public static void acceptAlertPopup(){
		try{
			Reusables.acceptAlert();
			}
		catch(NoSuchElementException e){
			Logs.error("Alert popup not accepted. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify alert message either match or not.
	 */
	public static void verifyAlertMessage(){
		try{
			Reusables.verifyEqualMessage(Reusables.getAlertMessage(), DataConstants.alert_message, "Error Message! Alert text does not match.");			
			}
		catch(NoSuchElementException e){
			Logs.error("Alert message not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to find out count of entity in EduBank.
	 * @return : Integer.
	 */
	public static int elementCountInEduBank(){
		return Reusables.getElementsList(element_count).size();
	}
	
	/**
	 * This method is used to click on the first entity in EduBank.
	 */
	public static void clickFirstEduBankElement(){
		Reusables.getElementsList(element_count).get(0).click();
	}
	
	/**
	 * This method is used to add entity to EduBank.
	 */
	public static void addEntityToEduBank(){
		try {
			Reusables.clickCommand(eduBank_icon);
			}
		catch (NoSuchElementException e) {
			Logs.error("Entity not added in edubank.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to remove entity from EduBank.
	 */
	public static void removeEntityFromEduBank(){
		addEntityToEduBank();
	}
	
	/**
	 * This method is used to navigate to EduBank.
	 */
	public static void navigateToEduBank(){
		while (! Reusables.getElement(eduBank_category).isDisplayed()){
			Reusables.stepBack();
			}
		}
	
	/**
	 * This method is used to get the added entity name.
	 * @return : String.
	 */
	public static String getFavouriteCategoryName(){
		return Reusables.getElement(add_favourite_name).getText();
	}	
}
