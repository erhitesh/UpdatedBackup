package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class HistoricalHangouts {
	
	/* IOSDriver instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Locator Identity */
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By historical_hangouts_icon = By.name(DataConstants.historical_hangout_header_text);
	public static By for_element_count = By.xpath("//UIACollectionCell");
	
	
	/**
	 * This method is used to click on the Historical Hangouts icon.
	 */
	public static void clickOnHistoricalHangouts(){
		try{
			Reusables.clickCommand(historical_hangouts_icon);
		}
		catch(NoSuchElementException e){
			Logs.error("Click on the Historical Hangouts icon not perform. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyHistoricalHangoutsHeaderTxt(){
		try{
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.historical_hangout_header_text, "Error Message! text message does not match.");
			}
		catch(NoSuchElementException e){
			Logs.error("Historical_hangout header text does not match. "+e.getClass().getName());
			}
		}
}
