package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.HomePage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class HomePageTestCases {

	
	@Test(priority=0)
	public void verifyElementOnHomePageTest(){
		HomePage.verifyHomePageSearchBoxIcon();
		HomePage.verifyHomePageCategoryIcon();
		HomePage.verifyHomePageOptionalIcon();
		HomePage.verifyHomePageMoreAppsIcon();
		HomePage.verifyHomePageQuizIcon();
	}
	
	@Test(priority=10)
	public void homePageSearchBoxTest(){
		HomePage.NavigateToSearchBoxPage();
		HomePage.verifySearchBoxPageNavigation();
		Reusables.oneStepBack();
	}
	
	@Test(priority=20)
	public void homePageCategoryTest(){
		HomePage.NavigateToCategoryPage();
		HomePage.verifyCategoryPageNavigation();
		Reusables.oneStepBack();
	}
	
	@Test(priority=30)
	public void homePageMoreAppsTest(){
		HomePage.NavigateToMoreAppsPage();
		HomePage.verifyMoreAppsPageNavigation();
		HomePage.closeMoreAppsPage();
	}
	
	@Test(priority=40)
	public void homePageQuizTest(){
		HomePage.NavigateToQuizPage();
		HomePage.verifyQuizPageNavigation();
		Reusables.oneStepBack();
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
	 
	 @AfterClass
	 public void closeApp(){
		 Reusables.terminatesAppInstance();
	 }
}
