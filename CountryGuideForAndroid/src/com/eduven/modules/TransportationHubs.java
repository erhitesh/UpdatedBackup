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


public class TransportationHubs {
	
	/* AndroidDriver instance */ 
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator Identity */
	public static By transporation_hub_cat = By.name(DataConstants.transportation_header_text);
	public static By transporation_hub_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By subcategory_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	
	
	/**
	 * This method is used to click on the transportation hub icon.
	 */
	public static void clickOnTransportationHub(){
		try{
			while (Reusables.isElementPresent(transporation_hub_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(transporation_hub_cat);
			if (Reusables.getText(transporation_hub_cat_header_txt).equals(DataConstants.transportation_header_text) == true){
				
			}
			else if (Reusables.getText(transporation_hub_cat_header_txt).equals(DataConstants.transportation_header_text) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(transporation_hub_cat);
				}
		}
		catch(NoSuchElementException e){
			Logs.error("Click opt not perform on  the Transportaion Hub. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyTransportationHeaderTxt(){
		try{
		Reusables.verifyEqualMessage(Reusables.getText(transporation_hub_cat_header_txt), DataConstants.transportation_header_text, "Error Message! text message does not match.");
		}
		catch(NoSuchElementException e){
			Logs.error("Transportation hub header text not matched. "+e.getClass().getName());
		}
	}
	
/*	
	*//**
	 * Verify the elements inside the transportation tab.
	 *//*
	public static void verifyTransportationHubCategoryList() {
		AndroidElement element = null;
		try{
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.transportation_header_text).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.transportation_header_text).get(i)));
                Reusables.waitForAndroidElement(element);
                Logs.info("Transportation Entity Found.."+element.getAttribute("name").toString());
			}
		}catch(NoSuchElementException e){
			Logs.error("Trnsportation entity "+element.toString()+" not found. "+e.getClass().getName());
		}
	}
	
	public static String clickOnRandomTransportationHubCategory(){
		String random_name="";
		try{
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.transportation_header_text).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.transportation_header_text).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		}catch(NoSuchElementException e){
			Logs.error("Click on the random name "+random_name+" not perform. "+e.getClass().getName());
		}
		
		return random_name;
	}*/
	
}
