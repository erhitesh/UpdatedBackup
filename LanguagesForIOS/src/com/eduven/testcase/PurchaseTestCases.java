 package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TermList;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class PurchaseTestCases {
	
	/* Global variable Declaration */
	String languageName = "";
	String purchase_option = "adfree";
	String categoryName = "";
	boolean statusValueWithoutPurchase = false;
	boolean statusValueWithPurchase = false;

	
	@Test(priority=10)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=20)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=30)
	public void verifyLockTermBeforePurchaseTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.verifyLockTermBeforePurchase(categoryName);
	}
	
	@Test(priority=40)
	public void navigateToBuyTest(){
		EntityDetailPage.navigateToPurchasePage();
	}
	
	@Test(priority=50)
	public void buyAppPurchaseTest(){
		EntityDetailPage.signInStore(purchase_option);
		EntityDetailPage.alreadyConfirmPurchaseAlertPopup();
		EntityDetailPage.thankYouAlertPopup();
		EntityDetailPage.congratulationAlertPopup();
	}
	
	@Test(priority=80)
	public void verifyPurchaseBtnAfterPurchase(){
		Reusables.stepBack();
		EntityDetailPage.verifyMoreAppsBtn();
	}
	
	@Test(priority=90)
	public void verifyLockTermAppearAsUnlockTermTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.verifyLockTermAfterPurchase(categoryName);
	}
	
	@AfterTest
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
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
