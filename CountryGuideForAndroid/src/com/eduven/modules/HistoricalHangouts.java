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


public class HistoricalHangouts {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	
	//Locator Identity
	public static By historical_hangouts_cat_entity = By.name(DataConstants.historical_hangout_header_text);
	public static By historical_hangouts_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By subcategory_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	
	
	/**
	 * This method is used to click on the Historical Hang outs icon.
	 */
	public static void clickOnHistoricalHangouts(){
		try{
			while (Reusables.isElementPresent(historical_hangouts_cat_entity) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(historical_hangouts_cat_entity);
			if (Reusables.getText(historical_hangouts_cat_header_txt).equals(DataConstants.historical_hangout_header_text) == true){
			}
			else if (Reusables.getText(historical_hangouts_cat_header_txt).equals(DataConstants.historical_hangout_header_text) == false){
			HomePage.navigateToHomePage();
			Reusables.customSwipeUp(0.7f, 0.5f);
			Reusables.clickCommand(historical_hangouts_cat_entity);
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>> Click on the Historical Hangouts icon not perform. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyHistoricalHangoutsHeaderTxt(){
		try{
		Reusables.verifyEqualMessage(Reusables.getText(historical_hangouts_cat_header_txt), DataConstants.historical_hangout_header_text, "Error Message! text message does not match.");
	}
	catch(NoSuchElementException e){
		Logs.error("Historical_hangout header text does not match. "+e.getClass().getName());
		}
	}
	
/*	*//**
	 * Verify the elements inside the Historical Hangouts tab.
	 *//*
	public static void verifyHistoricalHangoutCategoryList() {
		AndroidElement element = null;
		try{
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.historical_hangout_header_text).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.historical_hangout_header_text).get(i)));
                Reusables.waitForAndroidElement(element);
                Logs.info("Historical Hangout Entity Found.."+element.getAttribute("name").toString());
				}
			}
			catch(NoSuchElementException e){
				Logs.error("Historical Hangouts Entity"+element.getAttribute("name").toString()+" not found. "+e.getClass().getName());
			}
		}
	
	*//**
	 * This method is used to click on the random historical Hangout.
	 * @return : Type String
	 *//*
	public static String clickOnRandomHistoricalHangoutsCategory(){
		String random_name = "";
		try{	
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.historical_hangout_header_text).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.historical_hangout_header_text).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> Historical Hangouts element"+random_name+" not found. "+e.getClass().getName());
		}
	    return random_name;
	}*/
	
}
