package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class HomePageTestCases {
	
	
	
	@Test(priority=0)
	public void splashScreenHandlingTest(){
		SplashScreen.hideAppRatePopUp();
	}
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyHomePageHeaderTxt();
	}
	
	@Test(priority=2)
	public void homePageSearchTest(){
		HomePage.verifySearchButton();
		HomePage.clickOnSearchButton();
		HomePage.verifySearchPageHeaderText();
		Reusables.oneStepBack();
	}
	
	@Test(priority=3)
	public void homePageEVMenuTest(){
		HomePage.verifyEvMenuButton();
		HomePage.clickOnEvMenuButton();
		HomePage.verifyEvMenuElement();
		HomePage.clickOnEvMenuButton();
	}
	
	@Test(priority=4)
	public void homePageRecipesListTest(){
		/*HomePage.clickOnCourese();
		Reusables.oneStepBack();*/
		HomePage.clickOnTasteBud();
		Reusables.oneStepBack();
		HomePage.clickOnAllRecipes();
		Reusables.oneStepBack();
		HomePage.clickOnCookWith();
		Footer.navigateToHomePage();
		HomePage.clickOnTips();
		Reusables.oneStepBack();
		HomePage.clickOnEduBank();
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
