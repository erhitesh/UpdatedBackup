package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Movies {
	
	/* IosDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By movies_icon = By.name(DataConstants.movies_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");

	/**
	 * This method is used to click on the Movies icon.
	 */
	public static void clickOnMovies() {
		try {
			Reusables.clickCommand(movies_icon);
			} 
		catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Movies. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyMoviesHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.movies_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Movies header text not matched. "+e.getClass().getName());
		}
	}
}
