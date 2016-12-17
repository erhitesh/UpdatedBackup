package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Contribute;
import com.eduven.modules.Footer;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class ContributePageTestCases {

	
	@Test(priority = 0)
	public void navigateToCategoryPageTest() {
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		Footer.verifyContribute();
	}
	
	@Test(priority=10)
	public void navigateToTheContributePageTest(){
		Contribute.clickOnContribute();
		Contribute.verifyContributePageLoaded();
	}
	
	@Test(priority=15)
	public void verifyContributeNowWithoutTextTest(){
		Contribute.submitContribute();
		Contribute.verifyContributeWithoutValue();
	}
	
	@Test(priority=20)
	public void verifyTitleTextTest(){
		Contribute.enterTitleMessage();
		Contribute.submitContribute();
		Contribute.verifyContributeSuccessfullSubmit();
	}
	
	@Test(priority=25)
	public void verifyDescriptionTextTest(){
		Contribute.clickOnContribute();
		Contribute.verifyContributePageLoaded();
		Contribute.enterDescriptionMessage();
		Contribute.submitContribute();
		Contribute.verifyContributeWithoutValue();
	}
	
	
	@Test(priority=30)
	public void verifyTitleAnsDescriptionTextTest(){
		Contribute.enterTitleMessage();
		Contribute.submitContribute();
		Contribute.verifyContributeSuccessfullSubmit();
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
