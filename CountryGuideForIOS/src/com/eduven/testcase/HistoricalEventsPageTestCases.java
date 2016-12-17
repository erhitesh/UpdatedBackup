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
	
	@Test(priority=0)
	public void historical_events_page_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void historical_events_page_header_test(){
		HistoricalEvents.clickOnHistoricalEvents();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		HistoricalEvents.clickOnHistoricalEvents();
		
	}
	
	/*@Test(priority=2)
	public void historical_events_page_select_month_test(){
		HistoricalEvents.select_month_value();
	}
*/
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		} 
		else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}

}
