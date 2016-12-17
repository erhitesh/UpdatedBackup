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
	public void home_page_splash_screen_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void home_page_header_txt_test(){
		HomePage.verifyHomePageHeaderTxt();
	}
	
	@Test(priority=2)
	public void home_page_ev_menu_test(){
		HomePage.verfiyEvMenuLogoPresent();
	}
	
	@Test(priority=3)
	public void home_page_categories_test(){
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=4)
	public void home_page_cities_test(){
		HomePage.verifyCitiesIconPresent();
	}
	
	 @AfterMethod 
	 public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
	 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());  
	 }
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
   } 
	 
	 @AfterClass
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
