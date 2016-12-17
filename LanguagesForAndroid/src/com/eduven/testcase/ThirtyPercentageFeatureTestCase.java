package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.ThirtySeventyFeature;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class ThirtyPercentageFeatureTestCase {

	/* Global Variable Declaration */
	String languageName = "";
	
	@Test(priority=0)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=3)
	public void checkFirstTermAsUnlockTermTest(){
		ThirtySeventyFeature.checkFirstTermAsUnlockTerm(languageName);
	}
	
	@Test(priority=5)
	public void check_thirty_percentage_feature_test(){
		//ThirtySeventyFeature.checkThirtyPercentageUnlockTerm();
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
