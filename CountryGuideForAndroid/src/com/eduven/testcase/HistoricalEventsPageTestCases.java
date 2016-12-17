package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.HistoricalEvents;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class HistoricalEventsPageTestCases {
	
	String eventMessage_txt = "";
	
	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void verify_historical_events_page_header_test(){
		HistoricalEvents.clickOnHistoricalEvents();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		HistoricalEvents.clickOnHistoricalEvents();
	}
	
	@Test(priority=2)
	public void historical_events_page_get_event_message_text_test(){
		eventMessage_txt = HistoricalEvents.getHistory();
	}
	
	@Test(priority=3)
	public void verify_event_description_text_test(){
		HistoricalEvents.verifyEventMessage();
	}
	
	@Test(priority=4)
	public void historical_page_enter_date_test(){
		HistoricalEvents.clickOnSelectDateTextView();
		HistoricalEvents.selectDate();
	}
	
	@Test(priority=5)
	public void verify_event_message_text_for_specific_date_test(){
		HistoricalEvents.verifyEventMessageForSpecificDate(eventMessage_txt);
	}

	@AfterMethod 
	public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
	 }
   } 
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
