package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class HistoricalEvents {
	
	/* IosDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */ 
	public static By historical_events_cat = By.name(DataConstants.historical_events_header_txt);
	public static By historical_events_header_txt = By.name("Select a date and know about a historical event!");

	
	/**
	 * This method is used to click on the historical events icon.
	 */
	public static void clickOnHistoricalEvents() {
		try{
			while (Reusables.isElementPresent(historical_events_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(historical_events_cat);
			if (Reusables.isElementPresent(historical_events_header_txt) == true){
				
			}
			else if (Reusables.isElementPresent(historical_events_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(historical_events_cat);
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not performed on Historical Events. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get month history from app.
	 * @return : String.
	 */
	public static String getEventHistory(){
		String event_message = "";
		try{
			//event_message = Reusables.getElementsList(by)
		}catch(NoSuchElementException e){
			Logs.error("Unable to fetch event description from app. "+e.getClass().getName());
		}
		
		return event_message;
	}
	
	/**
	 * This method is used to get History from db.
	 * @return : String.
	 */
	public static String getEventHistoryFromDb(){
		String event_htistory = "";
		try{
			event_htistory = DatabaseConnection.getEventDescription();
		}catch(NoSuchElementException e){
			Logs.error("Unable to fetch data from database. "+e.getClass().getName());
		}
		
		return event_htistory;
	}
	
	/**
	 * This method is used to verify actual and expected event description text message.
	 */
	public static void verifyEventDescriptionMessage(){
		try{
			//Reusables.verifyEqualMessage(actual_txt, expected_txt, error_msg);
		}catch(NoSuchElementException e){
			Logs.error(""+e.getClass().getName());
		}
	}
}
