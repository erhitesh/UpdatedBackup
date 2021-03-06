package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class SpiritualSanctuaries {
	
	/* IosDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */
	public static By spiritual_sanctuaries_icon = By.name(DataConstants.spiritual_sanctuaries_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");
	public static By categoryHeaderTxt = By.name("CategoryHeader");

	/**
	 * This method is used to click on the Sports icon.
	 */
	public static void clickOnSpiritualSanctuaries() {
		try {
			Reusables.clickCommand(spiritual_sanctuaries_icon);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Spiritual Sanctuaries. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifySpiritualSanctuariesHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.spiritual_sanctuaries_header_txt, "Error Message! text message does not match.");
			}
		catch (NoSuchElementException e) {
			Logs.error("Spiritual Sanctuaries header text not matched. "+e.getClass().getName());
			}
		}
}
