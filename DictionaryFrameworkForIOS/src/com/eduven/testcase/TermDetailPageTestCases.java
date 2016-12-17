package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Contribute;
import com.eduven.modules.TermDetailPage;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class TermDetailPageTestCases {
	
	
	/* Global Variable Declaration */
	String termName = "";
	String termDescription = "";
	String contributeTitle = "";
	String contributeDescription = "";
	String randomCategoryName = "";
	
	
	@Test(priority=0)
	public void navigateTermPageTest(){
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		randomCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(randomCategoryName);
	}
	
	@Test(priority=10)
	public void navigateToTermDetailPageTest(){
		termName = WordSearchList.navigateToTermDetailPage(randomCategoryName);
		TermDetailPage.verifyTermDetailPageLoaded(termName);
		Categories.backToCategoryPage();
	}
	
	@Test(priority=13)
	public void verifyPremiumTermOnDetailPageTest(){
		randomCategoryName = Categories.clickOnRandomCategory();
		Reusables.checkPremiumTerm(randomCategoryName);
		Categories.backToCategoryPage();
	}
	
	@Test(priority=20)
	public void verifyFreeTermOnDetailPageTest(){
		randomCategoryName = Categories.clickOnRandomCategory();
		termName = Reusables.checkFreeTerm(randomCategoryName);
	}
	
	@Test(priority=30)
	public void verifyElementsOnTermDetailPageTest(){
		TermDetailPage.verifyElementOnTermDetailPage(randomCategoryName, termName);
	}
	
	@Test(priority=40)
	public void verifyContributeTitleAndDescriptionTest(){
		termName = TermDetailPage.getTermName();
		termDescription = TermDetailPage.getTermDescription();
		Contribute.clickOnEditContribute();
		Contribute.verifyContributePageLoaded();
		contributeTitle = Contribute.getContributeTitle();
		contributeDescription = Contribute.getContributeDescription();
		Contribute.verifyContributePageTitle(contributeTitle, termName);
		Contribute.verifyContributePageDescription(contributeDescription, termDescription);
		Reusables.hideKeyboard("no key");
		Reusables.oneStepBack();
	}

	@Test(priority=60)
	public void verifyTermNameAfterNextClickTest(){
		Categories.backToCategoryPage();
		randomCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.navigateToTermDetailPageForAudio(randomCategoryName);
		termName = TermDetailPage.getTermName();
		TermDetailPage.clickOnNextButton();
		TermDetailPage.verifyTermNameOnDetailPage(termName);
	}
	
	@Test(priority=70)
	public void verifyTermNameAfterPrevClickTest(){
		termName = TermDetailPage.getTermName();
		TermDetailPage.clickOnPreviousButton();
		TermDetailPage.verifyTermNameOnDetailPage(termName);
	}
	
	@Test(priority=80)
	public void verifySpeakAudioTest(){
		TermDetailPage.clickOnPlayButton();
		TermDetailPage.verifyElementAfterPlayBtnClick();
		TermDetailPage.clickOnStopPlayButton();
		TermDetailPage.verifyElementBeforePlayBtnClick();
	}
	
	@Test(priority=90)
	public void verifyAutoPlayAudioTest(){
		TermDetailPage.clickOnAutoPlayButton();
		TermDetailPage.verifyElementAfterAutoPlayStart();
		TermDetailPage.clickOnAutoPlayPauseButton();
		TermDetailPage.verifyElementBeforeAutoPlayStart();
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
