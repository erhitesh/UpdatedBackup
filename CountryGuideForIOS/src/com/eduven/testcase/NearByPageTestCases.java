package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.NearBySearch;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class NearByPageTestCases {
	
	/* Global Declaration */
	int pinsCountBefore = 0;
	int pinsCountAfter = 0;
	
	@Test(priority=1)
	public void splash_screen_handling_test(){
		SplashScreen.allowNotification();
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=2)
	public void navigate_to_nearBy_page_test(){
		NearBySearch.clickOnNearByButton();
		NearBySearch.handleAlertPopUp();
		NearBySearch.verifyNearByPageLoad();
	}
	
	@Test(priority=3)
	public void verify_element_on_near_by_page_test(){
		NearBySearch.verifyDrawButton();
		NearBySearch.verifyFilterButton();
		NearBySearch.verifySelectMarkerButton();
	}
	
	@Test(priority=4)
	public void verify_pins_count_test(){
		NearBySearch.clickOnResetButton();
		pinsCountBefore = NearBySearch.getPinsCount();
		NearBySearch.clickOnFilterButton();
		NearBySearch.deselectCategoryFromFilterPopUp();
		NearBySearch.clickOnFilterButton();
		pinsCountAfter = NearBySearch.getPinsCount();
		NearBySearch.verifyPinsCountFromFilterPopUp(pinsCountBefore, pinsCountAfter);
	}
	
	@Test(priority=5)
	public void draw_map_test(){
		NearBySearch.clickOnDrawButton();
		NearBySearch.verifyDrawLine();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}

	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
