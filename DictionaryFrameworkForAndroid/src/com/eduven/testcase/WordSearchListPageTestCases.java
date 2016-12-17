 package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class WordSearchListPageTestCases {

	
	/* Global Variable Declaration */
	String randomMainCategoryName = "";
	String rightWord = "";
	String wrongWord = "";
	String randomIndexValue = "";
	int indexNumberOccurance = 0;
	
	
	@Test(priority=1)
	public void wordsearchlist_page_navigate_to_search_wordlistPage_test(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		randomMainCategoryName = Categories.clickOnRandomCategory();
	}
	
	@Test(priority=10)
	public void wordsearchlist_page_verify_header_txt_test(){
		WordSearchList.verifyWordSearchPageLoaded(randomMainCategoryName);
	}
	
	@Test(priority=20)
	public void wordsearchlist_page_verify_footer_elements_test(){
		//Footer.verifyFeatureBox();
		Footer.verifyContribute();
		Footer.verifyLock();
		Footer.verifyEduBank();
		Footer.verifyQuiz();
	}
	
	@Test(priority=30)
	public void wordsearchlist_page_verify_right_search_test(){
		rightWord = DatabaseConnection.getUnLockTerm(randomMainCategoryName);
		System.out.println("Search Word..."+rightWord);
		WordSearchList.EnterText(rightWord);
		WordSearchList.verifyRightSearch();
		Reusables.stepBack();
	}
	
	@Test(priority=40)
	public void wordsearchlist_page_verify_wrong_search_test(){
		randomMainCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(randomMainCategoryName);
		wrongWord = Reusables.randomSpecialTextGenerator(8);
		WordSearchList.EnterText(wrongWord);
		WordSearchList.verifyWrongSearch();
		Reusables.stepBack();
	}
	
	@Test(priority=50)
	public void wordsearchlist_page_verify_search_word_by_index_test(){
		randomMainCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(randomMainCategoryName);
		randomIndexValue = WordSearchList.indexRandomValue();
		indexNumberOccurance = WordSearchList.clickOnIndexListElements(randomIndexValue);
		WordSearchList.verifySelectedIndexValue(randomIndexValue, indexNumberOccurance);
	}
	
	@Test(priority=60)
	public void verify_ads_banner_test(){
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
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
