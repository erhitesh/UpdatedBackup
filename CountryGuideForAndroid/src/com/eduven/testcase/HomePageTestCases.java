package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class HomePageTestCases {

	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void verify_home_page_app_header_txt_test(){
		HomePage.verifyAppHeaderTxt();
	}
	
	@Test(priority=2)
	public void home_page_header_txt_test(){
		HomePage.verifyHomePageHeaderTxt();
	}
	
	@Test(priority=3)
	public void home_page_ev_menu_test(){
		HomePage.verfiyEvMenuLogoPresent();
	}
	
	@Test(priority=4)
	public void home_page_categories_test(){
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=5)
	public void home_page_cities_test(){
		HomePage.verifyCitiesIconPresent();
	}
	
	@Test(priority=6)
	public void home_page_evMenu_test(){
		HomePage.verfiyEvMenuLogoPresent();
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
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
