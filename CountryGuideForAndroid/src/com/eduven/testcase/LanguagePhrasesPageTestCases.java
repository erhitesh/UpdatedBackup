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
	
	String mainCategoryName = DataConstants.language_phrase_header_txt;
	String subCategoryName = "";
	
	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void verify_language_phrases_page_header_test(){
		LanguagePhrases.clickOnLanguagePhrases();
		LanguagePhrases.selectLangaugeFromLanguageMenu();
		LanguagePhrases.verifyLanguagePhrasesHeaderTxt();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		LanguagePhrases.clickOnLanguagePhrases();
		LanguagePhrases.verifyLanguagePhrasesHeaderTxt();
	}
	
	@Test(priority=2)
	public void language_phrases_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void language_phrase_page_select_random_category_test(){
		Reusables.clickOnRandomSubCategory(mainCategoryName);
	}
	
	@Test(priority=4)
	public void language_phrase_page_select_language_from_language_menu_test(){
		Reusables.hideIndustrialization();
		LanguagePhrases.selectLangaugeFromLanguageMenu();
	}
	
	@Test(priority=5)
	public void language_phrases_page_verify_lock_unlock_btn_test(){
		Reusables.hideIndustrialization();
		LanguagePhrases.verifyLockUnlockStatus();
	}
	
	@Test(priority=6)
	public void language_phrase_page_open_first_lock_word(){
		LanguagePhrases.clickFirstLockBtn();
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
	public void close_app() {
		Reusables.terminatesAppInstance();
	}

}
