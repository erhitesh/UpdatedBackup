package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.Footer;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class WordSearchListPageTestCases {

	
	/* Global Variable Declaration */
	String categoryName = "";
	String rightWord = "";//DataConstants.rightSearch;
	String wrongWord = DataConstants.wrongSearch;
	String randomIndexValue = "";
	int indexNumberOccurance = 0;
	
	
	@Test(priority=0)
	public void navigateToTermPageTest(){
		Categories.navigateToCategoryPage();
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(categoryName);
	}
	
	@Test(priority=20)
	public void verifyFooterElementsTest(){
		Footer.verifyContribute();
		Footer.verifyInApp();
		Footer.verifyEduBank();
		Footer.verifyQuiz();
	}
	
	@Test(priority=30)
	public void verifySearchRelatedTest(){
		rightWord = DatabaseConnection.getUnLockTerm(categoryName);
		WordSearchList.EnterText(rightWord);
		WordSearchList.verifyRightSearch(rightWord);
		Reusables.oneStepBack();
	}
	
	@Test(priority=40)
	public void verifyWrongSearchTest(){
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(categoryName);
		WordSearchList.EnterText(wrongWord);
		WordSearchList.verifyWrongSearch(wrongWord);
		Reusables.oneStepBack();
	}
	
	@Test(priority=50)
	public void verifySearchWordByIndexTest(){
		/*categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(categoryName);
		randomIndexValue = WordSearchList.indexRandomValue();
		indexNumberOccurance = WordSearchList.clickOnIndexListElements(randomIndexValue);
		WordSearchList.verifySelectedIndexValue(randomIndexValue, indexNumberOccurance);*/
	}
	
	@Test(priority=60)
	public void verifyTermNameListTest(){
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(categoryName);
		WordSearchList.verifyTermNameList(categoryName);
		
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
