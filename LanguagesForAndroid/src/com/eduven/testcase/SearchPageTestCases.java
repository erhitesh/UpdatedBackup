package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.Search;
import com.eduven.modules.SplashScreen;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class SearchPageTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String termName = "";
	String searchForUnlock = "unlock";
	String searchForLock = "lock";
	List<String> list;
	
	@Test(priority=0)
	public void install_app_and_language_selection_test(){
		languageName = LanguageCategoryPage.langugeSelection();
		//System.out.println("Selected Language Name..> "+languageName);
	}
	
	@Test(priority=1)
	public void navigate_to_search_page_test(){
		SplashScreen.hideAppRatePopup();
		Search.NavigateToSearchPage();
	}
	
	@Test(priority=2)
	public void verify_search_page_header_test(){
		Search.verifySearchHeaderTxt();
	}
	
	@Test(priority=3)
	public void search_word_for_Unlock_term_test(){
		list = Search.searchWord(searchForUnlock);
		termName = list.get(0);
		Search.selectSearchWord(list.get(1));
		Search.verifySearchWord(termName);
	}

	@Test(priority=4)
	public void search_page_audio_test(){
		Search.startAudio();
		Reusables.stepBack();
	}
	
	@Test(priority=5)
	public void search_word_test(){
		list = Search.searchWord(searchForLock);
		termName = list.get(0);
		Search.selectSearchWord(list.get(1));
		Search.verifySearchWord(termName);
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
