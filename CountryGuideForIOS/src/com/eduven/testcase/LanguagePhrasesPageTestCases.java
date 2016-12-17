package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.LanguagePhrases;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class LanguagePhrasesPageTestCases {
	
	String mainCategoryName = DataConstants.language_and_phrase_header_txt;
	String subCategoryName = "";
	String termName = "";
	
	@Test(priority=0)
	public void language_phrases_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void language_phrases_page_header_test(){
		LanguagePhrases.clickOnLanguagephrases();
		LanguagePhrases.verfiySearchBarExistance();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		LanguagePhrases.clickOnLanguagephrases();
		LanguagePhrases.verfiySearchBarExistance();
	}
	
	@Test(priority=2)
	public void language_phrases_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void language_phrase_page_select_random_category_test(){                                                  
		termName = LanguagePhrases.clickOnRandomSubCategory(mainCategoryName);
	}
	
	@Test(priority=4)
	public void language_phrase_page_select_language_from_language_menu_test(){
		Reusables.hideIndustrialization();
		LanguagePhrases.selectLangaugeFromLanguageMenu();
	}
	
	@Test(priority=5)
	public void verify_term_name_on_termdetail_page_test(){
		LanguagePhrases.verifySelectedLanguageTermName(termName);
	}
	
	@Test(priority=6)
	public void language_phrases_page_verify_lock_unlock_btn_test(){
		Reusables.hideIndustrialization();
		LanguagePhrases.verifyLockUnlockStatus();	
	}

	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}

}
