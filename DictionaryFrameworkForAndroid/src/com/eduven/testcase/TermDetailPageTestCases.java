package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.HomePage;
import com.eduven.modules.TermDetailPage;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class TermDetailPageTestCases {
	
	
	/* Global Declaration */
	String termName = "";
	String nextTermName = "";
	String previousTermName = "";
	String termDescription = "";
	String contributeTitle = "";
	String contributeDescription = "";
	String randomMainCategoryName = "";
	
	
	@Test(priority=0)
	public void termDetailPage_navigate_to_wordSearchlist_page_test(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		randomMainCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(randomMainCategoryName);
	}
	
	@Test(priority=10)
	public void termDetailPage_navigate_to_termdetail_page_test(){
		termName = WordSearchList.navigateToTermDetailPage();
		WordSearchList.verifyTermDetailPageLoaded();
		Reusables.stepBack();
	}
	
	@Test(priority=20)
	public void termDetailPage_free_term_test(){
		Reusables.checkFreeTerm(randomMainCategoryName);
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	@Test(priority=30)
	public void termDetailPage_premium_term_test(){
		Categories.navigateToCategoryPage();
		randomMainCategoryName = Categories.clickOnRandomCategory();
		Reusables.checkPremiumTerm(randomMainCategoryName);
	}
	
	@Test(priority=40)
	public void contributePage_navigate_to_contribute_page_test(){
		/*Categories.NavigateToCategoryPage();
		Categories.clickOnRandomCategory();*/
		
		WordSearchList.navigateToTermDetailPage();
		WordSearchList.verifyTermDetailPageLoaded();
		termName = TermDetailPage.getTermName();
		termDescription = TermDetailPage.getTermDescription();
		TermDetailPage.clickOnEditContribute();
		TermDetailPage.verifyContributePageLoaded();
	}
	
	@Test(priority=50)
	public void contributePage_verify_contribute_title_and_description_test(){
		contributeTitle = TermDetailPage.getContributeTitle();
		contributeDescription = TermDetailPage.getContributeDescription();
		TermDetailPage.verifyContributePageTitle(contributeTitle, termName);
		TermDetailPage.verifyContributePageDescription(contributeDescription, termDescription);
		Reusables.stepBack();
		//Reusables.stepBack();
	}

	@Test(priority=60)
	public void termDetailPage_verify_entityName_for_next_btn_test(){
		termName = TermDetailPage.getTermName();
		TermDetailPage.clickOnNextButton();
		TermDetailPage.clickOnNextButton();
		nextTermName = TermDetailPage.getTermName();
		TermDetailPage.verifyTermName(nextTermName, termName);
	}
	
	@Test(priority=70)
	public void termDetailPage_verify_entityName_for_previous_btn_test(){
		termName = TermDetailPage.getTermName();
		TermDetailPage.clickOnPreviousButton();
		previousTermName = TermDetailPage.getTermName();
		TermDetailPage.verifyTermName(previousTermName, termName);
	}
	
	@Test(priority=80)
	public void termDetailPage_verify_speak_audio_test(){
		TermDetailPage.verifyButtonsEnableBeforeSpeakButtonClick();
		TermDetailPage.clickOnSpeakButton();
		TermDetailPage.verifyButtonsDisableAfterSpeakButtonClick();
		TermDetailPage.clickOnSpeakButton();
	}
	
	@Test(priority=90)
	public void termDetailPage_verify_autoPlay_audio_test(){
		TermDetailPage.verifyButtonsEnableBeforeAutoPlayButtonClick();
		TermDetailPage.clickOnAutoPlayButton();
		TermDetailPage.verifyButtonsDisableAfterAutoPlayButtonClick();
		TermDetailPage.stopAutoPlayPauseButton();
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
