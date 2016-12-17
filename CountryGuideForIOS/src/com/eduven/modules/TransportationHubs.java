package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class TransportationHubs {
	
	/* IosDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Locator Identity */
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By transporation_hub_icon = By.name(DataConstants.transportation_header_text);
	public static By for_element_count = By.xpath("//UIACollectionCell");
	
	
	/**
	 * This method is used to click on the transportation hub icon.
	 */
	public static void clickOnTransportationHub(){
		try{
			Reusables.clickCommand(transporation_hub_icon);
			}
		catch(NoSuchElementException e){
			Logs.error("Click opt not perform on  the Transportaion Hub. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyTransportationHeaderTxt(){
		try{
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.transportation_header_text, "Error Message! text message does not match.");
			}
		catch(NoSuchElementException e){
			Logs.error("Transportation hub header text not matched. "+e.getClass().getName());
			}
		}
}
