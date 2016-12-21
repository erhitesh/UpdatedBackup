package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class InAppPurchaseTestCases {
	
	
	/* Global Variable Declaration */
	String randomMainCategoryName = "";
	String paidTermBeforePurchase = "";
	String paidTermAfterPurchase = "";
	boolean statusValue = false;
	
	
	@Test(priority=1)
	public void navigateToCategoryPageTest(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
	}
	
	@Test(priority=10)
	public void verifyPremiumTermBeforePurchaseTest(){
		randomMainCategoryName = Categories.clickOnRandomCategory();
		paidTermBeforePurchase = Reusables.checkPremiumTerm(randomMainCategoryName);
	}
	
	@Test(priority=15)
	public void inAppPurchaseTest(){
		InAppPurchase.navigateToInAppPurchasePage();
		InAppPurchase.appPurchase();
	}
	
	@Test(priority=20)
	public void verifyInAppBtnAfterPurchaseTest(){
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		InAppPurchase.verifyMoreAppsImageView();
	}

	@Test(priority=25)
	public void verifyPremiumTermAppearAsFreenTermTest(){
		randomMainCategoryName = Categories.clickOnRandomCategory();
		paidTermAfterPurchase = DatabaseConnection.getLockTerm(randomMainCategoryName);
		InAppPurchase.verifyLockTermAfterPurchase(paidTermAfterPurchase, statusValue);
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
