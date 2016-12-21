package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class NetworkRelatedTestCases {

	
	/* Global variable Declaration */
	String mediumTypeForAppSharing = DataConstants.appSharingTypeForFb;
	boolean airplaneModeOn = true;
	boolean wifiModeOff = false;
	boolean dataModeOff = false;
	boolean airplaneModeOff = false;
	boolean wifiModeOn = true;
	
	
	@Test(priority=10)
	public void categorypagenavigatetocategorytest(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
	}
	
	@Test(priority=20)
	public void turnOffNetworkConnectionTest(){
		Reusables.getNetConnectionStatus(airplaneModeOn, wifiModeOff, dataModeOff);
	}
	
	@Test(priority=30)
	public void checkEvMenuappsharingfornetworkconnectiontest(){
		EvMenu.navigateToGetInTouch();
		Reusables.stepBack();
		EvMenu.clickOnShareApp();
		EvMenu.selectShareType(mediumTypeForAppSharing);
		Reusables.verifyConnectionRelatedError();
		Reusables.stepBack();
	}
	
	@Test(priority=32)
	public void checkEvMenuForInformationAndSupportFprNetworkConnectionTest(){
		EvMenu.navigateToTermsAndConditionsPage();
		Reusables.verifyConnectionErrorForWebView();
		Reusables.stepBack();
		Reusables.stepBack();
		EvMenu.navigateToPrivacyPolicyPage();
		Reusables.verifyConnectionErrorForWebView();
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	@Test(priority=35)
	public void moreAppsRelatedtest(){
		EvMenu.navigateToMoreAppsPage();
		Reusables.verifyConnectionRelatedError();
	}
	
	@Test(priority=40)
	public void purchaseApprelatedConnectivityTest(){
		InAppPurchase.navigateToInAppPurchasePage();
		InAppPurchase.clickOnUnlockButton();
		InAppPurchase.verifyUnlockButtonStillVisible();
	}
	
	@Test(priority=60)
	public void turnOnNetworkConnectionTest(){
		Reusables.getNetConnectionStatus(airplaneModeOff, wifiModeOn, dataModeOff);
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
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
