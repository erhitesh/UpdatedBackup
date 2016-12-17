package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EduBank;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.QuickList;
import com.eduven.modules.TermList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EduBankPageTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String category_name = "";
	String first_term_name = "";
	String second_term_name = "";
	
	@Test(priority=0)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=2)
	public void navigateToEdubankTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
	}
	
	@Test(priority=3)
	public void navigateToTermPageTest(){
		category_name = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(category_name);
	}
	
	@Test(priority=4)
	public void addTermInEdubankTest(){
		first_term_name = TermList.getTermName(0);
		Reusables.waitThread(1);
		second_term_name = TermList.getTermName(1);
		EduBank.addTermInEduBank(0);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(1);
	}
	
	@Test(priority=5)
	public void verifyAddedTermInEdubankTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyTermInEduBank(second_term_name);
	}
	
	@Test(priority=6)
	public void remove_terms_from_Edubank_test(){
		EduBank.removeSpecificTermFromEduBank(1);
	}
	
	@Test(priority=7)
	public void verifyAddedTermInEdubankAfterRemoveOneTermTest(){
		EduBank.verifyTermInEduBankAfterRemove(second_term_name);
	}
	
	@Test(priority=8)
	public void removeAllTermsFromEdubankTest(){
		EduBank.removeAllTermFromEduBank();
		Reusables.stepBack();
	}
	
	@Test(priority=85)
	public void navigateToEdubankQuicklistTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
	}
	
	@Test(priority=90)
	public void navigateToEquicklistPageTest(){
		QuickList.navigateToQuickListPage();
		QuickList.verifyQuickListHeader();
	}
	
	@Test(priority=95)
	public void navigateToQuicklistTermPageTest(){
		category_name = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(category_name);
	}
	
	@Test(priority=98)
	public void addTermInEdubankForQuicklistTest(){
		first_term_name = QuickList.getTermName(0);
		Reusables.waitThread(1);
		second_term_name = QuickList.getTermName(1);
		EduBank.addTermInEduBank(0);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(1);
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	@Test(priority=100)
	public void verifyAddedTermInEdubankForQuicklistTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyTermInEduBank(second_term_name);
	}
	
	@Test(priority=105)
	public void removeTermsFromEdubankForQuicklistTest(){
		EduBank.removeSpecificTermFromEduBank(1);
	}
	
	@Test(priority=110)
	public void verifyAddedTermInEdubankForQuicklistAfterRemoveOnTermTest(){
		EduBank.verifyTermInEduBankAfterRemove(second_term_name);
	}
	
	@Test(priority=150)
	public void removeAllTermsFromEdubankForQuicklistTest(){
		EduBank.removeAllTermFromEduBank();
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
