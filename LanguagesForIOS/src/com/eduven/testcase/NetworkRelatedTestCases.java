package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.EvMenu;
import com.eduven.modules.Footer;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.SwitchLingo;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class NetworkRelatedTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String option = "allfunctionality";

	
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void networkTurnOffNetworkConnectionTest(){
		Categories.verifyCategoryHeaderTxt();
		Reusables.networkConnectionTest();
	}
	
	@Test(priority=30)
	public void checkEVMenuForNetworkConnectionTest(){
		EvMenu.navigateToSettingPage();
		Reusables.verifyConnectionRelatedError(EvMenu.doneBtn);
		EvMenu.submitSettingPage();
		EvMenu.navigateToAppSharePage();
		Reusables.verifyConnectionRelatedError(EvMenu.doneBtn);
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=40)
	public void purchaseAppRelatedConnectivityTest(){
		EntityDetailPage.navigateToPurchasePage();
		Reusables.verifyConnectionRelatedError(Footer.purchaseBtn);
		Reusables.stepBack();
	}
	
	@Test(priority=50)
	public void swicthLingoRelatedConnectivityTest(){
		SwitchLingo.navigateToSwitchLanguagePage();
		LanguageCategoryPage.langugeSelection();
		SwitchLingo.verifySwitchLingoHeaderTxt();
	}
	
	@Test(priority=60)
	public void networkTurnOnNetworkConnectionTest(){
		Reusables.networkConnectionTest();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		} else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		}
	
	@AfterClass
	public void closeApp() {
		Reusables.terminatesAppInstance();
	}

}
