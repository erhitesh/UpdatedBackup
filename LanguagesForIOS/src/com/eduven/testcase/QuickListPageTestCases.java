package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.QuickList;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class QuickListPageTestCases {
	
	
	/* Global variable Declaration */
	String languageName = "";
	String categoryName = "";
	List<String> quickListTermList;
	
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToQuickListTest(){
		QuickList.navigateToQuickListPage();
	}
	
	@Test(priority=30)
	public void verifyQuickListHeadertxtTest(){
		QuickList.verifyQuickListHeaderTxt();
	}
	
	@Test(priority=40)
	public void verifyQuickListCategoryTest(){
		QuickList.verifyQuickListCategory();
	}
	
	@Test(priority=50)
	public void navigateToQuickListTermTest(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(categoryName);
	}
	
	@Test(priority=60)
	public void verifyTermsNameOnTermlistPageTest(){
		quickListTermList = QuickList.getTermList(categoryName, languageName);
		QuickList.verifyTermNameList(quickListTermList);
		Reusables.stepBack();
	}
	
	@Test(priority=70)
	public void verifyUnlockTermNameTest(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyUnLockTermName(categoryName, languageName);
		Reusables.stepBack();
	}
	
	@Test(priority=80)
	public void verifyLockTermNameTest(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyLockTermName(categoryName, languageName);
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
