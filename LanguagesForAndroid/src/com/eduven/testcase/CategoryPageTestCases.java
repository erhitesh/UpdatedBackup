package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class CategoryPageTestCases {
	
	/* Global Declaration */
	String languageName = "";
	
	@Test(priority=1)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
		System.out.println("Language Name..>"+languageName);
	}
	
	@Test(priority=2)
	public void verifyCategoryHeaderTxtTest(){
		Categories.verifyCategoryHeaderTxt();
	}
	
	@Test(priority=3)
	public void verifyCategoryListTest(){
		Reusables.verifyCategoryList(languageName);
	}
	
	@Test(priority=4)
	public void verifyCategoryTermCountTest(){
		List<String> category_list = Categories.getCategoryList(languageName);
		Categories.verifyCategoryTermCount(category_list);
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
