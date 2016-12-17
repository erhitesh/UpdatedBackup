package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Wildlife {

	/* IosDriver instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By wildlife_icon = By.name(DataConstants.wildlife_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");

	/**
	 * This method is used to click on the Wild life icon.
	 */
	public static void clickOnWildlife() {
		try {
			Reusables.clickCommand(wildlife_icon);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Wildlife. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyWildlifeHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.wildlife_header_txt, "Error Message! text message does not match.");
			}
		catch (NoSuchElementException e) {
			Logs.error("Wildlife header text not matched. "+e.getClass().getName());
			}
		}
}
