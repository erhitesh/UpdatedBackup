package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Sports {
	
	// IosDriver instance
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	// Locator Identity
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By sports_icon = By.name(DataConstants.sports_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");

	/**
	 * This method is used to click on the Sports icon.
	 */
	public static void clickOnSports() {
		try {
			Reusables.clickCommand(sports_icon);
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Sports, "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifySportsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.sports_header_txt,"Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Transportation hub header text not matched. "+e.getClass().getName());
		}
	}
}
