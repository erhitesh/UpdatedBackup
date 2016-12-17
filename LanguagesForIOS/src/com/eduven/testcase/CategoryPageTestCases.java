package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class CategoryPageTestCases {
	
	
	/* Global Declaration */
	String languageName = "";
	
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
	public void verifyCategoriesList(){
		List<String> category_list = Categories.getCategoryList(languageName);
		Categories.verifyCategoryListAndTermCount(category_list);
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
