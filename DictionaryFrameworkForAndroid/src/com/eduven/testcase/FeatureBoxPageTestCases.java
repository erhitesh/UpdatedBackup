package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.FeatureBox;
import com.eduven.modules.HomePage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class FeatureBoxPageTestCases {
	String randomEntityName = "";
	String entityName = "";
	String operationTypeForPrevious = "previous";
	String operationTypeForNext = "next";
	
	@Test(priority=0)
	public void featurebox_page_navigate_to_featurebox_test(){
		FeatureBox.NavigateToFeatureBoxPage();
		FeatureBox.verifyFeaturePageNavigation();
	}
	
	@Test(priority=1)
	public void featurebox_page_select_random_player_test(){
		randomEntityName = FeatureBox.getSelectRandomName();
		System.out.println("randomEntityName"+randomEntityName);
	}

	@Test(priority=2)
	public void featurebox_page_verify_right_page_navigation_test(){
		FeatureBox.verifyEntityHeaderPageText();
		entityName = FeatureBox.getEntityName();
	}
	
	@Test(priority=3)
	public void featurebox_page_verify_entityName_next_click_test(){
		FeatureBox.clickOnButton(operationTypeForNext);
		FeatureBox.verifyEntityNameAfterClick(entityName);
	}
	
	@Test(priority=4)
	public void featurebox_page_verify_entityName_previous_click_test(){
		entityName = FeatureBox.getEntityName();
		FeatureBox.clickOnButton(operationTypeForPrevious);
		FeatureBox.verifyEntityNameAfterClick(entityName);
	}
	
	@Test(priority=5)
	public void verify_ads_banner_test(){
		HomePage.verifyAds();
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
