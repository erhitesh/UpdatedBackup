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
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class AutoPlayPageTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String categoryName = "";
	int delayTime = 2;
	String firstTermName = "";
	
	@Test(priority=0)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=10)
	public void handlingRateAppPopupTest(){
		SplashScreen.hideAppRatePopup();
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
	public void verifyButtonsRelatedAutPlayTest(){
		AutoPlay.verifyButtonPresent();
	}
	
	@Test(priority=45)
	public void getFirstTermNameBeforeStartTest(){
		firstTermName = AutoPlay.getTermName();
	}
	
	@Test(priority=48)
	public void increaseDelayTimeTest(){
		AutoPlay.clickOnDelayTime();
		AutoPlay.selectDelayTime(delayTime);
	}
	
	@Test(priority=49)
	public void startTurboPlayTest(){
		AutoPlay.clickOnAutoPlayBtn();
	}
	
	@Test(priority=50)
	public void verifyElementAfterStartTurboPlayTest(){
		AutoPlay.verifyElementStatusAfterStartPlayButton();	
	}
	
	@Test(priority=52)
	public void verifyAutoPlayWorksTest(){
		AutoPlay.verifyTermNameAfterAutoPlay(firstTermName);
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
	public void close_app(){
		Reusables.terminatesAppInstance();
	}

}
