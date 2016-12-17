package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class HomePageTestCases {
	
	/* Global Declaration */
	String appName = DataConstants.appName;
	String languageName = "";
	
	@Test(priority=0)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=10)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	}
	
	@Test(priority=20)
	public void verifyElementOnHomePageTest(){
		HomePage.verifyAppName(appName);
		HomePage.verifyEvMenuBtn();
		HomePage.verifySearchBtn();
	}
	
	@Test(priority=30)
	public void verifyFooterQuicklistButtonOnHomePageTest(){
		Footer.verifyQuickListBtn();	
	}
	
	@Test(priority=40)
	public void verifyFooterEdubankButtonOnHomePageTest(){
		Footer.verifyEduBankBtn();
	}
	
	@Test(priority=50)
	public void verifyFooterPurchaseButtonOnHomePageTest(){
		Footer.verifyPurchaseBtn();
	}
	
	@Test(priority=60)
	public void verifyFooterGameButtonOnHomePageTest(){
		Footer.verifyGamesBtn();
	}
	
	@Test(priority=70)
	public void verifyFooterSwitchLingoButtonOnHomePageTest(){
		Footer.verifySwitchLanguageBtn();
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
	
	@AfterClass()
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
