package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Interstetial;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class CheckInterstetialBeforePurchase {
	
	/* Global Declaration */
	String languageName = "";
	boolean interstetialStatusBeforePayment = true;
	String game_type = "Army Of Categories";
	String randomCategoryName = "";

	
	@Test(priority=10)
	public void handlingRateAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=15)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void verifyInterstetialForWordListTest(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForWordList();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=25)
	public void verifyInterstetialForSearchTest(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForSearch();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
		Categories.backToHomePage();
	}
	
	@Test(priority=30)
	public void verifyInterstetialForQuicklistTest(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForQuickList();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=35)
	public void verifyInterstetialForGamesTest(){
		Interstetial.interstetialForPayQuiz(game_type);
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
		Categories.backToHomePage();
	}
	
	@Test(priority=40)
	public void verifyInterstetialForInAppTest(){
		Categories.verifyCategoryHeaderTxt();
		Interstetial.interstetialForInApp();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
		Categories.verifyCategoryHeaderTxt();
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
