package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EvMenu;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TermList;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class TermListPageTestCases {
	
	/* Global variable Declaration */
	String languageName = "";
	String languageNameForPhonetics = DataConstants.languageNameForPhonetics;
	String categoryName = "";
	List<String> term_list ;
	String wordText = DataConstants.contribute_word_text;
    String expectedFailContributeMessage = DataConstants.contribute_alert_message_for_failed_submission_for_termpage;
    String expectedSuccessfullContributeMessage = DataConstants.contribute_alert_message_for_successfull_submission;
	
    
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToTermlistPageTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
	}
	
	@Test(priority=30)
	public void verifyTermsNameOnTermlistPageTest(){
		term_list = TermList.getTermList(categoryName, languageName);
		TermList.verifyTermNameList(term_list);
		Reusables.stepBack();
	}
	
	@Test(priority=40)
	public void verifyUnlockTermNameTest(){
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyUnLockTermName(categoryName, languageName);
		Reusables.stepBack();
	}
	
	@Test(priority=50)
	public void verifyLockTermNameTest(){
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyLockTermName(categoryName, languageName);
		Reusables.stepBack();
	}
	
	/*@Test(priority=52)
	public void verify_phonetics_name_on_termlist_page_test(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		term_list = TermList.getTermListAsPhoneticsName(categoryName, languageNameForPhonetics);
		TermList.verifyTermNameListAsPhonetics(term_list);
		Reusables.stepBack();
	}
	
	@Test(priority=55)
	public void verify_rendering_name_on_termlist_page_test(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		term_list = TermList.getTermListAsRenderingName(categoryName, languageNameForPhonetics);
		TermList.verifyTermNameListAsRendering(term_list);
		Reusables.stepBack();
	}*/
	
	@Test(priority=60)
	public void navigateToEditTermPageTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.editTermForContribute();
	}
	
	@Test(priority=65)
	public void verifyContributePageWithoutTextTest(){
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
	}
	
	@Test(priority=70)
	public void verifyContributePageWithWordTest(){
		EvMenu.enterWordValueForEditTerm(wordText);
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedSuccessfullContributeMessage);
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
	public void closApp(){
		Reusables.terminatesAppInstance();
	}

}
