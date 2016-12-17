package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EduBank;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.QuickList;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TermList;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class EduBankPageTestCases {
	
	
	/* Global Variable Declaration */
	String languageName = "";
	String category_name = "";
	String firstTermName = "";
	String secondTermName = "";
	
	
	@Test(priority=0)
	public void handlingRateAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToEdubankTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
	}
	
	@Test(priority=30)
	public void navigateToTermPageTest(){
		category_name = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(category_name);
	}
	
	@Test(priority=40)
	public void addTermInEdubankTest(){
		firstTermName = TermList.getTermName(0);
		Reusables.waitThread(1);
		secondTermName = TermList.getTermName(1);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(0);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(1);
		Reusables.waitThread(2);
	}
	
	@Test(priority=50)
	public void verifyAddedTermInEdubankTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyTermInEduBank(firstTermName);
		EduBank.verifyTermInEduBank(secondTermName);
	}
	
	@Test(priority=60)
	public void removeTermsFromEdubankTest(){
		EduBank.removeSpecificTermFromEduBank(1);
	}
	
	@Test(priority=70)
	public void verifyAddedTermInEdubankAfterRemovedItTest(){
		EduBank.verifyTermInEduBankAfterRemove(secondTermName);
	}
	
	@Test(priority=80)
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
	public void navigateToQuicklistPageTest(){
		QuickList.navigateToQuickListPage();
		QuickList.verifyQuickListHeaderTxt();
	}
	
	@Test(priority=95)
	public void navigateToQuicklistTermPageTest(){
		category_name = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(category_name);
	}
	
	@Test(priority=98)
	public void addTermInEdubankForQuicklistTest(){
		firstTermName = QuickList.getTermName(0);
		Reusables.waitThread(1);
		secondTermName = QuickList.getTermName(1);
		EduBank.addTermInEduBank(0);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(1);
		Reusables.stepBack();
		QuickList.clickOnDoneBtn();
	}
	
	@Test(priority=100)
	public void verifyAddedTermInEdubankForQuicklistTest(){
		EduBank.navigateToEduBankPage();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyTermInEduBank(firstTermName);
		EduBank.verifyTermInEduBank(secondTermName);
	}
	
	@Test(priority=105)
	public void removeTermsFromEdubankForQuicklistTest(){
		EduBank.removeSpecificTermFromEduBank(1);
	}
	
	@Test(priority=110)
	public void verifyAddedTermInEdubankForQuicklistAfterRemoveOneTermTest(){
		EduBank.verifyTermInEduBankAfterRemove(secondTermName);
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
