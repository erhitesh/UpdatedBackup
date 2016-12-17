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


public class SpiritualSanctuaries {
	
	/* Android Driver Instance */ 
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */ 
	public static By spiritual_sanctuaries_cat_entity = By.name(DataConstants.spiritual_sanctuaries_header_txt);
	public static By spiritual_sanctuaries_cat_entity_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By for_element_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");

	/**
	 * This method is used to click on the Sports icon.
	 */
	public static void clickOnSpiritualSanctuaries() {
		try {
			while (Reusables.isElementPresent(spiritual_sanctuaries_cat_entity) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(spiritual_sanctuaries_cat_entity);
			if (Reusables.getText(spiritual_sanctuaries_cat_entity_header_txt).equals(DataConstants.spiritual_sanctuaries_header_txt) == true){	
			}
			else if (Reusables.getText(spiritual_sanctuaries_cat_entity_header_txt).equals(DataConstants.spiritual_sanctuaries_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(spiritual_sanctuaries_cat_entity);
				}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Spiritual Sanctuaries. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifySpiritualSanctuariesHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(spiritual_sanctuaries_cat_entity_header_txt), DataConstants.spiritual_sanctuaries_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Spiritual Sanctuaries header text not matched. "+e.getClass().getName());
		}
	}
/*
	*//**
	 * Verify the elements inside the Spiritual Sanctuaries tab.
	 *//*
	public static void verifySpiritualSanctuariesCategoryList() {
		AndroidElement element = null;
		try {
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.spiritual_sanctuaries_header_txt).size(); i++) {
				if (i % element_count_value == 0 && i / element_count_value >= 1){
				Reusables.swipeUp();
				}
				element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.spiritual_sanctuaries_header_txt).get(i)));
				Reusables.waitForAndroidElement(element);
				Logs.info("Spiritual Sanctuaries Entity Found.."+element.getAttribute("name").toString());
			}
		}

		catch (NoSuchElementException e) {
			Logs.error("Spiritual Sanctuaries entity "+element.toString()+"not found. "+e.getClass().getName());
		}
	}

	public static String clickOnRandomSpiritualSanctuariesCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.spiritual_sanctuaries_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.spiritual_sanctuaries_header_txt).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error("Click on the random name "+random_name+" not perform. "+e.getClass().getName());
		}
		return random_name;

	}

*/
}
