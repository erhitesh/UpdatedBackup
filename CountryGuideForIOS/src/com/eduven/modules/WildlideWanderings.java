package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class WildlideWanderings {
	
	/* IOSDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */ 
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By wildlife_wanderings_icon = By.name(DataConstants.wildlife_wanderings_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");

	/**
	 * This method is used to click on the Wild lide Wanderings icon.
	 */
	public static void clickOnWildlifeWanderings() {
		try {
			Reusables.clickCommand(wildlife_wanderings_icon);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click on the Wildlife Wanderings icon not perform. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyWildlifeWanderingsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.wildlife_wanderings_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Wildlife Wanderings header text does not match. "+e.getClass().getName());
		}
	}
}
