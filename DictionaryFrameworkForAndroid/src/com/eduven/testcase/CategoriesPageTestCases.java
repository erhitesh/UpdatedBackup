package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class CategoriesPageTestCases {
	
	
	@Test(priority=0)
	public void navigateToCategoryPageTest(){
		//HomePage.handleMinorBugFixedAlertPopup();
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		Reusables.stepBack();
		HomePage.verifyHomePageCategoryIcon();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
	}
	
	@Test(priority=10)
	public void verifyFooterElementTest(){
		Footer.featureBox();
		Footer.contribute();
		Footer.buy();
		Footer.eduBank();
		Footer.quiz();
	}
	
	@Test(priority=15)
	public void verifyCategoryNameListTest(){
		Reusables.verifyCategoryList();
	}
	
	@Test(priority=20)
	public void verifyCategoryNameHeaderTextTest(){
		Reusables.stepBack();
		Reusables.hideInterstetial();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		Categories.verifyCategoryTermHeaderText();
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
