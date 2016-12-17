package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Footer;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class InAppPurchaseTestCases {

	
	/* Global variable declaration */
	String categoryName = "";
	String termName = "";
	
	
	@Test(priority=1)
	public void navigateToTermPageTest(){
		Categories.navigateToCategoryPage();
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(categoryName);
	}
	
	@Test(priority=10)
	public void verifyLockTermBeforePurchaseTest(){
		termName = Reusables.checkPremiumTerm(categoryName);
	}
	
	@Test(priority=20)
	public void inAppPurchaseTest(){
		Footer.clickOnInAppPurchase();
		InAppPurchase.verifyElementOnInAppPurchasePageLoad();
		InAppPurchase.signInToiTuneStore();
	}
	
	@Test(priority=30)
	public void verifyLockTermAfterPurchaseTest(){
		Reusables.checkPremiumTermAsFreeTerm(categoryName);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if (ITestResult.SKIP == result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.FAILURE == result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
