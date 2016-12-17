 package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.Interstetial;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.TermList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class PurchaseTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String purchase_option = "adfree";
	String categoryName = "";
	boolean statusValueWithoutPurchase = false;
	boolean statusValueWithPurchase = false;
	boolean interstetialStatusAfterPayment = false;
	String game_type = "Army Of Categories";

	
	@Test(priority=1 )
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=3)
	public void verify_lock_term_before_purchase_test(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.verifyLockTermBeforePurchase(statusValueWithoutPurchase, categoryName, languageName);
	}
	
	@Test(priority=4)
	public void navigate_to_buy_test(){
		EntityDetailPage.navigateToPurchasePage();
	}
	
	@Test(priority=5)
	public void premium_word_purchase_test(){
		EntityDetailPage.signInStore(purchase_option);
	}
	
	@Test(priority=6)
	public void verify_more_app_btn_after_purchase(){
		EntityDetailPage.verifyMoreAppsBtn();
	}
	
	@Test(priority=7)
	public void verify_lock_term_appear_as_unlock_term_test(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.verifyLockTermAfterPurchase(statusValueWithPurchase);
		//
		Reusables.stepBack();
	}
	
	@Test(priority=15)
	public void verify_interstetial_for_games_test(){
		Interstetial.interstetialForPayQuiz(game_type);
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
		Categories.backToHomePage();
	}
	
	@Test(priority=20)
	public void verify_interstetial_for_word_list_test(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForWordList();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
	}
	
	@Test(priority=25)
	public void verify_interstetial_for_search_test(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForSearch();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
		Categories.backToHomePage();
	}
	
	@Test(priority=30)
	public void verify_interstetial_for_quicklist_test(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForQuickList();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
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
	public void restartApp(){
		Reusables.terminatesAppInstance();
	}
}
