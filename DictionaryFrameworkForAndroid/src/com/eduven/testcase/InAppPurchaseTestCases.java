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
	public void category_page_navigate_to_category_test(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
	}
	
	@Test(priority=10)
	public void check_premium_term_before_purchase_test(){
		randomMainCategoryName = Categories.clickOnRandomCategory();
		paidTermBeforePurchase = Reusables.checkPremiumTerm(randomMainCategoryName);
	}
	
	@Test(priority=15)
	public void inAppPurchase_test(){
		InAppPurchase.navigateToInAppPurchasePage();
		InAppPurchase.app_purchase();
	}
	
	@Test(priority=20)
	public void checkInApp_btn_after_purchase_test(){
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		InAppPurchase.verifyMoreAppsImageView();
	}

	@Test(priority=25)
	public void verify_lock_term_appear_as_unlock_term_test(){
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
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
