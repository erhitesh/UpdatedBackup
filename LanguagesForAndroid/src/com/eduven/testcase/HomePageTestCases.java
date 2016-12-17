package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class HomePageTestCases {
	
	/* Global Declaration */
	String app_name = DataConstants.appName;
	String languageName = "";
	
	@Test(priority=0)
	public void install_app_and_language_selection_test(){
		languageName = LanguageCategoryPage.langugeSelection();
	}

	@Test(priority=2)
	public void verify_element_on_homePage_test(){
		HomePage.verifyAppName(app_name);
		HomePage.verifyEvMenuBtn();
		HomePage.verifySearchBtn();
	}
	
	@Test(priority=3)
	public void verify_footer_element_on_home_page_test(){
		Footer.verifyQuickListBtn();
		Footer.verifyEduBankBtn();
		Footer.verifyPurchaseBtn();
		Footer.verifyGamesBtn();
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
	
	@AfterClass
	public void close_app(){
		Reusables.terminatesAppInstance();
	}
}
