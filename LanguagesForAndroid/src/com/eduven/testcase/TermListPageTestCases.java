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
import com.eduven.modules.TermList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class TermListPageTestCases {
	
	
	/* Global Declaration */
	String languageName = "";
	String categoryName = "";
	List<String> term_list ;
	String wordText = DataConstants.contribute_word_text;
	String languageNameForPhonetics = DataConstants.languageNameForPhonetics;
	String languageNameForRendering = DataConstants.languageNameForRendering;
	String expectedFailContributeMessage = DataConstants.contribute_alert_message_for_failed_submission_for_term_list_page;
    String expectedSuccessfullContributeMessage = DataConstants.contribute_alert_message_for_successfull_submission;
	
    
	@Test(priority=1)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
/*	@Test(priority=2)
	public void navigateToTermListPageTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
	}
	
	@Test(priority=3)
	public void verifyTermsNameOnTermListPageTest(){
		term_list = TermList.getTermList(categoryName, languageName);
		TermList.verifyTermNameList(term_list);
		Reusables.stepBack();
		Reusables.hideIndustrialization();
	}
	
	@Test(priority=4)
	public void verifyUnlockTermNameTest(){
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.verifyUnLockTermName(categoryName, languageName);
		Reusables.stepBack();
		Reusables.hideIndustrialization();
	}
	
	@Test(priority=5)
	public void verifyLockTermNameTest(){
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.verifyLockTermName(categoryName, languageName);
		Reusables.stepBack();
		Reusables.hideIndustrialization();
	}
	
	@Test(priority=52)
	public void verifyPhoneticsNameOnTermlistPageTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		term_list = TermList.getTermListAsPhoneticsName(categoryName, languageNameForPhonetics);
		TermList.verifyTermNameListAsPhonetics(term_list);
		Reusables.stepBack();
		Reusables.hideIndustrialization();
	}
	
	@Test(priority=55)
	public void verifyRenderingNameOnTermlistPageTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		term_list = TermList.getTermListAsRenderingName(categoryName, languageNameForPhonetics);
		TermList.verifyTermNameListAsRendering(term_list);
		Reusables.stepBack();
		Reusables.hideIndustrialization();
	}*/
	
	@Test(priority=60)
	public void navigateToEditTermPageTest(){
		Categories.verifyCategoryHeaderTxt();
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		TermList.editTermForContribute();
		Reusables.hideIndustrialization();
	}
	
	@Test(priority=65)
	public void verifyContributePageWithoutTextTest(){
		EvMenu.submitEditContributePage();
		EvMenu.contributeContinue();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
	}
	
	@Test(priority=70)
	public void verifyContributePageWithTest(){
		EvMenu.enterPhoneticsValue(wordText);
		EvMenu.submitEditContributePage();
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
	public void close_app(){
		Reusables.terminatesAppInstance();
	}

}
