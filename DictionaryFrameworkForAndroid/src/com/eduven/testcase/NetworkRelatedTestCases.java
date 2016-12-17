package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
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
	
	@Test(priority=10)
	public void category_page_navigate_to_category_test(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
	}
	
	@Test(priority=20)
	public void test_network_turnoff_network_connection_test(){
		Reusables.getNetConnectionStatus(air_plane_mode_on, wifi_mode_of, data_mode_of);
	}
	
	@Test(priority=30)
	public void check_evMenu_app_sharing_for_network_connection_test(){
		EvMenu.navigateToGetInTouch();Reusables.stepBack();
		EvMenu.clickOnShareApp();
		EvMenu.selectShareType("facebook");
		Reusables.verifyConnectionRelatedError();
		Reusables.stepBack();
	}
	
	@Test(priority=32)
	public void check_evmenu_for_information_and_support_for_network_connection_test(){
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
	public void more_apps_related_test(){
		EvMenu.navigateToMoreAppsPage();
		Reusables.verifyConnectionRelatedError();
	}
	
	@Test(priority=40)
	public void purchase_app_related_connectivity_test(){
		InAppPurchase.navigateToInAppPurchasePage();
		InAppPurchase.clickOnUnlockButton();
		InAppPurchase.verifyUnlockButtonStillVisible();
	}
	
	@Test(priority=60)
	public void test_network_turnon_network_connection_test(){
		Reusables.getNetConnectionStatus(air_plane_mode_off, wifi_mode_on, data_mode_of);
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
