package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.Wildlife;
import com.eduven.report.Logs;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class WildlifePageTestCases {
	
	String subCategoryName = "";
	String mainCategoryName = DataConstants.wildlife_header_txt;
	
	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void verify_wildlife_page_header_test(){
		Wildlife.clickOnWildlife();
		Wildlife.verifyWildlifeHeaderTxt();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		Wildlife.clickOnWildlife();
		Wildlife.verifyWildlifeHeaderTxt();
	}
	
	@Test(priority=2)
	public void wildlife_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);;
	}
	
	@Test(priority=3)
	public void wildlif_page_free_entity_test(){
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkFreeEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=4)
	public void wildlif_page_premium_entity_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkPremiumEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=5)
	public void wildlife_page_verify_contribute_entity_test(){
		Reusables.verifyContributeEntity();
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 Logs.error("This Method is used to takes screen shot for Failure TestCase..."+result.getMethod().getMethodName());
	 }
	 
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 Logs.error("This Method is used to takes screen shot for SKIP TestCase..."+result.getMethod().getMethodName());
	 }
	 
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 Logs.error("This Method is used to takes screen shot for SuccessPrecentage Failure TestCase..."+result.getMethod().getMethodName());
	 }
   } 
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}

}
