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
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=10)
	public void verifyElementOnHomePageTest(){
		HomePage.verifyHomePageSearchBoxIcon();
		HomePage.verifyHomePageEvMenuIcon();
		HomePage.verifyHomePageCategoryIcon();
		//HomePage.verifyHomePageContributeIcon();
		//HomePage.verifyHomePageEduBankIcon();
		HomePage.verifyHomePageMoreAppsIcon();
		HomePage.verifyHomePageQuizIcon();
	}
	
	@Test(priority=20)
	public void homePageSearchBoxTest(){
		HomePage.navigateToSearchBoxPage();
		HomePage.verifySearchBoxPageNavigation();
		Reusables.stepBack();
	}
	
	@Test(priority=30)
	public void homePageEvMenuTest(){
		HomePage.navigateToEvMenuPage();
		HomePage.verifyEvMenuPageNavigation();
		Reusables.stepBack();
	}
	
	@Test(priority=40)
	public void homePageCategoryTest(){
		HomePage.navigateToCategoryPage();
		HomePage.verifyCategoryPageNavigation();
		Reusables.stepBack();
	}
	
	@Test(priority=50)
	public void homePageEdubankTest(){
		/*HomePage.NavigateToEduBankPage();
		HomePage.verifyEduBankPageNavigation();
		Reusables.stepBack();*/
	}
	
	@Test(priority=60)
	public void homePageMoreAppsTest(){
		HomePage.navigateToMoreAppsPage();
		HomePage.verifyMoreAppsPageNavigation();
		Reusables.stepBack();
	}
	
	@Test(priority=70)
	public void homePageQuizTest(){
		HomePage.navigateToQuizPage();
		HomePage.verifyQuizPageNavigation();
		Reusables.stepBack();
		Reusables.hideInterstetial();
	}
	
	@Test(priority=80)
	public void verifyAdsBannerTest(){
		HomePage.verifyAds();
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
