package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.EvMenu;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SwitchLingo;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class NetworkRelatedTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String option = "allfunctionality";
	boolean air_plane_mode_on = true;
	boolean wifi_mode_of = false;
	boolean data_mode_of = false;
	boolean air_plane_mode_off = false;
	boolean wifi_mode_on = true;

	
	@Test(priority=1)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=2)
	public void turnoffNetworkConnectionTest(){
		Reusables.getNetConnectionStatus(air_plane_mode_on, wifi_mode_of, data_mode_of);
	}
	
	@Test(priority=3)
	public void verifyEVMenuForNetworkConnectionTest(){
		EvMenu.navigateToGetInTouch();
		EvMenu.verifyGetInTouchPageNavigation();
		EvMenu.verifySocialSiteBtnExistence();
		Reusables.stepBack();
		Reusables.stepBack();
		EvMenu.navigateToAppSharePage();
		Reusables.verifyConnectionRelatedError();
		Reusables.stepBack();
	}
	
	@Test(priority=4)
	public void verifyPurchaseAppRelatedNetworkConnectionTest(){
		EntityDetailPage.navigateToPurchasePage();
		EntityDetailPage.selectPurchaseOption(option);
		Reusables.verifyConnectionRelatedError();
		Reusables.stepBack();
	}
	
	@Test(priority=5)
	public void verifySwicthLingoRelatedNetworkConnectionTest(){
		SwitchLingo.navigateToSwitchLanguagePage();
		LanguageCategoryPage.langugeSelection();
		SwitchLingo.verifySwitchLingoHeaderTxt();
	}
	
	@Test(priority=6)
	public void turnOnNetworkConnectionTest(){
		Reusables.getNetConnectionStatus(air_plane_mode_off, wifi_mode_on, data_mode_of);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		} 
		else if (ITestResult.SKIP == result.getStatus()) {
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
