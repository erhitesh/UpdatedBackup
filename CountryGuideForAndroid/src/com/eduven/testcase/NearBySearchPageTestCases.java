package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.NearBySearch;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;

public class NearBySearchPageTestCases {
	
	String expectedHeaderTxt = DataConstants.nearByPageHeaderTxt;
	
	
	@Test(priority=0)
	public void close_flyer_popup_test(){
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void navigate_to_nearBy_page_test(){
		NearBySearch.clickOnNearByButton();
		NearBySearch.verifyNearByPageHeaderTxt(expectedHeaderTxt);
	}
	
	@Test(priority=2)
	public void nearby_page_verify_button_instances_test(){
		NearBySearch.verifyResetButton();
		NearBySearch.verifyDrawShapeButton();
		NearBySearch.verifySelectMarkerButton();
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
