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
	
	
	/* Global variable Declaration */
	String termName = "";
	String nextTermName = "";
	String previousTermName = "";
	String termDescription = "";
	String contributeTitle = "";
	String contributeDescription = "";
	String categoryName = "";
	
	
	@Test(priority=0)
	public void navigateToTermPageTest(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(categoryName);
	}
	
	@Test(priority=10)
	public void navigateToTermDetailPageTest(){
		termName = WordSearchList.navigateToTermDetailPage(categoryName);
		WordSearchList.verifyTermDetailPageLoaded();
		HomePage.backToHomePage();
	}
	
	@Test(priority=20)
	public void verifyPremiumTermOnDetailPageTest(){
		Categories.navigateToCategoryPage();
		categoryName = Categories.clickOnRandomCategory();
		Reusables.checkPremiumTerm(categoryName);
	}
	
	@Test(priority=30)
	public void verifyFreeTermOnDetailPageTest(){
		termName = Reusables.checkFreeTerm(categoryName);
	}
	
	@Test(priority=40)
	public void navigateToContributePageTest(){
		termDescription = TermDetailPage.getTermDescription();
		TermDetailPage.clickOnEditContribute();
		TermDetailPage.verifyContributePageLoaded();
	}
	
	@Test(priority=50)
	public void verifyContributeTitleAndDescriptionTest(){
		contributeTitle = TermDetailPage.getContributeTitle();
		contributeDescription = TermDetailPage.getContributeDescription();
		TermDetailPage.verifyContributePageTitle(contributeTitle, termName);
		TermDetailPage.verifyContributePageDescription(contributeDescription, termDescription);
		Categories.backToCategoryPage();
	}

	@Test(priority=60)
	public void verifyTermNameAfterNextClickTest(){
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.navigateToTermDetailPageForAudio(categoryName);
		termName = TermDetailPage.getTermName();
		TermDetailPage.clickOnNextButton();
		TermDetailPage.clickOnNextButton();
		nextTermName = TermDetailPage.getTermName();
		TermDetailPage.verifyTermName(nextTermName, termName);
	}
	
	@Test(priority=70)
	public void verifyTermNameAfterPrevClickTest(){
		termName = TermDetailPage.getTermName();
		TermDetailPage.clickOnPreviousButton();
		previousTermName = TermDetailPage.getTermName();
		TermDetailPage.verifyTermName(previousTermName, termName);
	}
	
	@Test(priority=80)
	public void verifySpeakAudioTest(){
		TermDetailPage.verifyButtonsEnableBeforeSpeakButtonClick();
		TermDetailPage.clickOnSpeakButton();
		TermDetailPage.verifyButtonsDisableAfterSpeakButtonClick();
		TermDetailPage.clickOnSpeakButton();
	}
	
	@Test(priority=90)
	public void verifyAutoPlayAudioTest(){
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
	 public void closeApp(){
		 Reusables.terminatesAppInstance();
	 }
}
