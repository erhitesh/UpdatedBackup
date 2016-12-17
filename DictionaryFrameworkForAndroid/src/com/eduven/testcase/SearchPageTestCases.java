package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.HomePage;
import com.eduven.modules.Search;
import com.eduven.modules.TermDetailPage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class SearchPageTestCases {

	
	/* Global Variable Declaration */
	String termName = "";
	
	
	@Test(priority=0)
	public void navigateToSearchPageTest(){
		HomePage.verifyAppName();
		Search.navigateToSearchBoxPage();
		Search.verifySearchPageHeaderTxt();
	}
	
	@Test(priority=10)
	public void verifySearchTermTest(){
		termName = Search.searchTerm();
	}
	
	@Test(priority=20)
	public void verifyTermNameOnDetailPageTest(){
		Search.verifySearchResultHeaderTxt();
		TermDetailPage.verifyTermNameOnTermDetailPage(termName);
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
