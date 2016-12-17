package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class CelebritiesCells {
	// IosDriver instance
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	// Locator Identity
	public static By categoryHeaderTxt = By.name("categoryHeader");
	public static By celebrities_cells_cat = By.name(DataConstants.celebrities_cells_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");

	/**
	 * This method is used to click on the Celebrities cells icon.
	 */
	public static void clickOnCelebritiesCells() {
		try {
			while (Reusables.isElementPresent(celebrities_cells_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(celebrities_cells_cat);
			if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.celebrities_cells_header_txt) == true){
				
			}
			else if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.celebrities_cells_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(celebrities_cells_cat);
			}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Celebrities Cells. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyCelebritiesCellsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.celebrities_cells_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Celebrities cells header text not matched. "+e.getClass().getName());
		}
	}
}
