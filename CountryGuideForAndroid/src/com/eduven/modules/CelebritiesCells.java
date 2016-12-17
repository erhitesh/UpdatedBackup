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


public class CelebritiesCells {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */
	public static By celebrities_cells_cat = By.name(DataConstants.celebrities_cells_header_txt);
	public static By celebrities_cells_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
    public static By subcategory_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	
	/**
	 * This method is used to click on the Celebrities cells icon.
	 */
	public static void clickOnCelebritiesCells() {
		try {
			while (Reusables.isElementPresent(celebrities_cells_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(celebrities_cells_cat);
			if (Reusables.getText(celebrities_cells_cat_header_txt).equals(DataConstants.celebrities_cells_header_txt) == true){
				
			}
			else if (Reusables.getText(celebrities_cells_cat_header_txt).equals(DataConstants.celebrities_cells_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(celebrities_cells_cat);
				}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on the Celebrities Cells. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyCelebritiesCellsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(celebrities_cells_cat_header_txt),DataConstants.celebrities_cells_header_txt,"Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Actual and expected text not matched. "+e.getClass().getName());
		}
	}

/*	*//**
	 * Verify the elements inside the Celebrities cells tab.
	 *//*
	public static void verifyCelebritiesCellsCategoryList() {

		AndroidElement element = null;
		try {
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.celebrities_cells_header_txt).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
				element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.celebrities_cells_header_txt).get(i)));
                Reusables.waitForAndroidElement(element);
			    Logs.info("Celebrities Cells Entity Found.."+element.getAttribute("name").toString());
			}
		}
		catch (NoSuchElementException e) {
			Logs.error("Celebrities cells entity"+element.toString()+ e.getClass().getName());
		}
	}

	public static String clickOnRandomCelebritiesCellsCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.celebrities_cells_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.celebrities_cells_header_txt).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error("Click operation on the random name "+random_name+ e.getClass().getName());
		}
		return random_name;
	}*/
}
