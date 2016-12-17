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


public class WildlideWanderings {
	
	/* IOSDriver instance */ 
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */
	public static By wildlife_wanderings_cat = By.name(DataConstants.wildlife_wanderings_header_txt);
	public static By wildlife_wanderings_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By subcategory_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");

	/**
	 * This method is used to click on the Wild life Wanderings icon.
	 */
	public static void clickOnWildlifeWanderings() {
		try {
			while (Reusables.isElementPresent(wildlife_wanderings_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(wildlife_wanderings_cat);
			if (Reusables.getText(wildlife_wanderings_cat_header_txt).equals(DataConstants.wildlife_wanderings_header_txt) == true){
				
			}
			else if (Reusables.getText(wildlife_wanderings_cat_header_txt).equals(DataConstants.wildlife_wanderings_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(wildlife_wanderings_cat);
				}
		} catch (NoSuchElementException e) {
			Logs.error("Click on the Wildlife Wanderings icon not perform. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyWildlifeWanderingsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(wildlife_wanderings_cat_header_txt), DataConstants.wildlife_wanderings_header_txt,"Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Wildlife Wanderings header text does not match. "+e.getClass().getName());
		}
	}

/*	*//**
	 * Verify the elements inside the Wild life Wanderings tab.
	 *//*
	public static void verifyWildlifeWanderingsCategoryList() {
		AndroidElement element = null;
		try {
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).get(i)));
                Reusables.waitForAndroidElement(element);
				Logs.info("wildlife wanderings Entity Found.  "+element.getAttribute("name").toString());
			}
		} catch (NoSuchElementException e) {
			Logs.error("Wildlife Wanderings entity "+element.toString()+" not found. "+e.getClass().getName());
		}
	}

	public static String clickOnRandomWildlifeWanderingsCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.wildlife_wanderings_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.wildlife_wanderings_header_txt).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error("Willife Wanderings element"+ random_name + " not found. "+e.getClass().getName());
		}
		return random_name;
	}*/
}
