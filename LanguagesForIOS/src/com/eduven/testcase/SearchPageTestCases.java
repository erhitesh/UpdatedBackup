package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.Search;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class SearchPageTestCases {
	
	
	/* Global variable Declaration */
	String languageName = "";
	String searchTermName = "";
	String searchForUnlock = "unlock";
	String searchForLock = "lock";
	List<String> list;
	
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToSearchPageTest(){
		Search.NavigateToSearchPage();
	}
	
	@Test(priority=30)
	public void verifySearchPageHeaderTest(){
		Search.verifySearchHeaderTxt();
	}
	
	@Test(priority=40)
	public void freeTermSearchTest(){
		list = Search.searchWord(searchForUnlock);
		searchTermName = list.get(0);
		System.out.println("Now selecting search word");
		Search.selectSearchWord(list.get(1));
		Search.verifySearchWord(searchTermName);
	}

	@Test(priority=50)
	public void searchPageAudioTest(){
		Search.startAudio();
		Reusables.stepBack();
		Search.submitSearchWord();
	}
	
	@Test(priority=60)
	public void premiumTermSearchTest(){
		Search.NavigateToSearchPage();
		list = Search.searchWord(searchForLock);
		searchTermName = list.get(0);
		Search.selectSearchWord(list.get(1));
		Search.verifySearchWord(searchTermName);
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
