package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.AutoPlay;
import com.eduven.modules.Categories;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TermList;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class AutoPlayPageTestCases {
	
	
	/* Global Variable Declaration */
	String languageName = "";
	String categoryName = "";
	int delayTime = 2;
	
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void verifyCategoryHeaderTxt(){
		Categories.verifyCategoryHeaderTxt();
	}
	
	@Test(priority=30)
	public void selectRandomCategoryTest(){
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
	}
	
	@Test(priority=40)
	public void verifyAutoPlayButtonTest(){
		AutoPlay.clickOnAutoPlayBtn();
		AutoPlay.verifyButtonPresent();
	}
	
	@Test(priority=45)
	public void increaseDealayTimeTest(){
		AutoPlay.selectDelayTime(delayTime);
	}
	
	@Test(priority=50)
	public void autoPlayButtonForPlayButtonTest(){
		AutoPlay.clickOnPlayButton();
		AutoPlay.verifyButtonAfterStartPlayButton();
	}
	
	@Test(priority=60)
	public void verify_auto_play_works_test(){
		//AutoPlay.verifyTermNameAfterAutoPlay();
	}
	
	@AfterMethod 
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
	
	@AfterClass()
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}

}
