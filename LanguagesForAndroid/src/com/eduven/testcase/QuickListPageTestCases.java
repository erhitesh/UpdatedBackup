package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.QuickList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class QuickListPageTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String categoryName = "";
	List<String> quick_list_term_list;
	
	@Test(priority=0)
	public void install_app_and_language_selection_test(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=2)
	public void navigate_to_quick_list_test(){
		QuickList.navigateToQuickListPage();
	}
	
	@Test(priority=3)
	public void verify_quick_list_headertxt_test(){
		QuickList.verifyQuickListHeader();
	}
	
	@Test(priority=4)
	public void verify_quick_list_category_test(){
		QuickList.verifyQuickListCategory(languageName);
	}
	
	@Test(priority=5)
	public void navigate_to_quick_list_term_test(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(categoryName);
	}
	
	@Test(priority=6)
	public void verify_terms_name_on_termlist_page_test(){
		quick_list_term_list = QuickList.getTermList(categoryName, languageName);
		QuickList.verifyTermNameList(quick_list_term_list);
		Reusables.stepBack();
	}
	
	@Test(priority=7)
	public void verify_unlock_term_name_on_term_list_page_test(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(categoryName);
		QuickList.verifyUnLockTermName(categoryName, languageName);
		Reusables.stepBack();
	}
	
	@Test(priority=8)
	public void verify_lock_term_name_on_term_list_page_test(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(categoryName);
		QuickList.verifyLockTermName(categoryName, languageName);
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
