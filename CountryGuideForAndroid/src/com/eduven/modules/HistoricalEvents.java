package com.eduven.modules;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class HistoricalEvents {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */
	public static By historical_events_cat = By.name(DataConstants.historical_events_header_txt);
	public static By historical_events_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By clearDateBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/selectDateClear");
	public static By selectDate = By.id(DeviceRelatedInformation.getPackageName()+":id/selectDate");
	public static By selectMonthDayYearValue = By.id("android:id/numberpicker_input");
	public static By submitDateBtn = By.id("android:id/button1");
	
	public static By getEventDescriptionTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/event_detailtext");
	
	//public static By day_txt_view = By.id("android:id/date_picker_day");
	public static By month_txt_view = By.id("android:id/date_picker_month");
	public static By year_txt_view = By.id("android:id/date_picker_year");
	public static By year_value = By.id("android:id/month_text_view");

	/**
	 * This method is used to select the year value.
	 */
	public static void selectYearValue(){
		try{
			 List<AndroidElement> element = Reusables.getElementsList(year_value);
			 Reusables.clickUsingElement(element.get(2));
		}catch(NoSuchElementException e){
			Logs.error("Umable to select year value. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select date using calendar view.
	 */
	public static void selectDateUsingCalendarView(){
		try{
			int random_day_value = Reusables.randomNumber(25);
			Reusables.clickUsingElement(Reusables.getElement(month_txt_view));
			Reusables.waitThread(2);
			Reusables.clickUsingElement(Reusables.getElement(By.xpath("//*[@index='"+random_day_value+"']")));
			Reusables.waitForElement(year_txt_view);
			Reusables.clickUsingElement(Reusables.getElement(year_txt_view));
			Reusables.waitThread(2);
			selectYearValue();
			//Reusables.dragAndDrop(2, year_value);
			
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Calendar view not open.. "+e.getClass().getName());
		}
	}
	
	public static void selectDate(){
		try{
			if (Reusables.isElementPresent(month_txt_view) == true){
				System.out.println("Using Calendar View");
				selectDateUsingCalendarView();
			}
			else if (Reusables.isElementPresent(selectMonthDayYearValue) == true) {
				System.out.println("Using Normal View");
				selectDateValue(0, "May");
				selectDateValue(1, "04");
				selectDateValue(2, "1992");
			}
			submitDatePopUp();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Calendar view not open.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the historical events icon.
	 */
	public static void clickOnHistoricalEvents() {
		try{
			while (Reusables.isElementPresent(historical_events_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(historical_events_cat);
			if (Reusables.getText(historical_events_cat_header_txt).equals(DataConstants.historical_events_header_txt) == true){
			}
		else if (Reusables.getText(historical_events_cat_header_txt).equals(DataConstants.historical_events_header_txt) == false){
			HomePage.navigateToHomePage();
			Reusables.customSwipeUp(0.7f, 0.5f);
			Reusables.clickCommand(historical_events_cat);
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Historical Events. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the select date text view.
	 */
	public static void clickOnSelectDateTextView(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(selectDate));
		}catch(NoSuchElementException e){
			Logs.error("select date text view not found... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click to clear date value.
	 */
	public static void clearDateValue(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(clearDateBtn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Date value still set "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get Event text.
	 * @return : Event text message, type String
	 */
	public static String getHistory(){
		Reusables.waitThread(2);
		return Reusables.getElementsList(getEventDescriptionTxt).get(0).getAttribute("name");
		
	}
	
	/**
	 * This method is used to get Event text from DB.
	 * @return : Event text message, type String
	 */
	public static String getEventHistoryFromDB(){
		Reusables.waitThread(2);
		return DatabaseConnection.getEventDescription();
	}
	
	/**
	 * This method is used to verify event message description
	 */
	public static void verifyEventMessage(){
		try{
			Reusables.verifyEqualMessage(Reusables.getElementsList(getEventDescriptionTxt).get(0).getText(), getEventHistoryFromDB(), "Error Message!! Event message not Same....");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> Event Message text not matched..."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify event message description for particular date.
	 */
	public static void verifyEventMessageForSpecificDate(String expectedMessage){
		try{
			System.out.println(Reusables.getElementsList(getEventDescriptionTxt).get(0).getText());
			Reusables.verifyNotEqualMessage(Reusables.getElementsList(getEventDescriptionTxt).get(0).getText(), expectedMessage, "Error Message!! Event message Same....");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> Event Message text matched..."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to select date value from open calendar pop up.
	 */
	public static void selectDateValue(int valueindex, String fieldValue){
		AndroidElement dateInstance;
		try{
			Reusables.waitThread(1);
			dateInstance = Reusables.getElementsList(selectMonthDayYearValue).get(valueindex);
			dateInstance.click();
			dateInstance.clear();
			dateInstance.sendKeys(fieldValue);
		}
		catch(NoSuchElementException e){
			Logs.error("******************* Showing Month value not selected. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to save the entered value in text box.
	 */
	public static void submitDatePopUp(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(submitDateBtn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>> Done Button Still visible... "+e.getClass().getName());
		}
	}

}
