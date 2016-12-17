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
import com.eduven.modules.SplashScreen;
import com.eduven.modules.SwitchLingo;
import com.eduven.modules.TermList;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class SwitchLanguagePageTestCases {
	
	
	/* Global variable Declaration */
	String languageName = "";
	String categoryName = "";
	String option = "allnativelangugae";
	List<String> term_list;
	List<String> quick_list_term_list;
	List<String> category_list;
	
	
	@Test(priority=0)
	public void handlingRateAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToSswitchLingoPageTest(){
		SwitchLingo.navigateToSwitchLanguagePage();
	}
	
	@Test(priority=30)
	public void switchLingoChangeBaseLanguageTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=40)
	public void purchaseNativeLangugaeTest(){
		EntityDetailPage.purchaseForNativeLanguage(option);
	}
	
	@Test(priority=45)
	public void languageSelectionTest1(){
		Reusables.waitThread(2);
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=50)
	public void verifyCategoryListAfterBaseLanguageChangeTest(){
		category_list = Categories.getCategoryList(languageName);
		Categories.verifyCategoryListAndTermCount(category_list);
	}
	
	@Test(priority=60)
	public void verifyTermHeaderAndTermNameListTest(){
		categoryName = Categories.clickOnRandomCategory();
		TermList.verifyTermListHeaderTxt(categoryName);
		term_list = TermList.getTermList(categoryName, languageName);
		TermList.verifyTermNameList(term_list);
		Reusables.stepBack();
	}
	
	@Test(priority=65)
	public void navigateToQuickListTest(){
		QuickList.navigateToQuickListPage();
	}
	
	@Test(priority=70)
	public void verifyQuickListHeadertxtTest(){
		QuickList.verifyQuickListHeaderTxt();
	}
	
	@Test(priority=80)
	public void verifyQuickListCategoryTest(){
		QuickList.verifyQuickListCategory();
	}
	
	@Test(priority=90)
	public void navigateToQuickListTermTest(){
		categoryName = QuickList.clickOnRandomQuickList();
		QuickList.verifyQuickListTermHeaderTxt(categoryName);
	}
	
	@Test(priority=100)
	public void verifyTermsNameOnTermlistPageTest(){
		quick_list_term_list = QuickList.getTermList(categoryName, languageName);
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
