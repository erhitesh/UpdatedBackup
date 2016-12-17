package com.eduven.testcase;

import java.util.List;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.QuickList;
import com.eduven.modules.SwitchLingo;
import com.eduven.modules.TermList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class SwitchLanguagePageTestCases {
	
	/* Global Declaration */
	String languageName = "";
	String randomCategoryName = "";
	String option = "allnativelangugae";
	List<String> term_list ;
	List<String> quick_list_term_list;
	
	@Test(priority=10)
	public void install_app_and_language_selection_test(){
		languageName = LanguageCategoryPage.langugeSelection();
		System.out.println("Selected Language Name..> "+languageName);
	}
	
	@Test(priority=20)
	public void navigate_to_switch_lingo_page_test(){
		SwitchLingo.navigateToSwitchLanguagePage();
	}
	
	@Test(priority=30)
	public void switch_lingo_change_base_language_test(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=40)
	public void purchase_native_langugae_test(){
		EntityDetailPage.purchaseForNativeLanguage(option);
	}
	
	@Test(priority=50)
	public void verify_category_list_after_base_language_change_test(){
		Reusables.verifyCategoryList(languageName);
	}
	
	@Test(priority=60)
	public void verify_term_header_and_term_name_test(){
		randomCategoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(randomCategoryName);
		term_list = TermList.getTermList(randomCategoryName, languageName);
		TermList.verifyTermNameList(term_list);
		Reusables.stepBack();
		Reusables.hideIndustrialization();
	}
	
	@Test(priority=65)
	public void navigate_to_quick_list_test(){
		QuickList.navigateToQuickListPage();
	}
	
	@Test(priority=70)
	public void verify_quick_list_headertxt_test(){
		QuickList.verifyQuickListHeader();
	}
	
	@Test(priority=80)
	public void verify_quick_list_category_test(){
		QuickList.verifyQuickListCategory(languageName);
	}
	
	@Test(priority=90)
	public void navigate_to_quick_list_term_test(){
		randomCategoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(randomCategoryName);
	}
	
	@Test(priority=100)
	public void verify_terms_name_on_termlist_page_test(){
		quick_list_term_list = QuickList.getTermList(randomCategoryName, languageName);
		QuickList.verifyTermNameList(quick_list_term_list);
		Reusables.stepBack();
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
