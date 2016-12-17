package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EvMenu;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class EvMenuPageTestCases {

	
	/* Global variable Declaration */
	String languageName = "";
	//String wordText = DataConstants.contribute_word_text;
	String expectedFailContributeMessage = DataConstants.contribute_alert_message_for_failed_submission;
	String expectedSuccessfullContributeMessage = DataConstants.contribute_alert_message_for_successfull_submission;
	String categoryName = "";
	String expectedAlertMessage = DataConstants.category_settings_alert_message;
	String audienceType = "public";
	
	
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToMoreAppsPageTest(){
		EvMenu.navigateToMoreAppsPage();
		EvMenu.verifyMoreAppsPageLoaded();
		EvMenu.closeMoreAppsPage();
	}
	
	@Test(priority=30)
	public void verifyMoreAppsPageTest(){
		EvMenu.navigateToAppsList();
		EvMenu.clickOnAppNameFromAppList();
		EvMenu.verifyElementOnAppStorePage();
		EvMenu.closeAppStorePage();
		EvMenu.closeMoreAppsPage();
	}
	
	@Test(priority=40)
	public void navigateToContributePageTest(){
		EvMenu.navigateToContributePage();
		EvMenu.verifyContributePageLoaded();
	}
	
	@Test(priority=50)
	public void verifyContributePageWithoutTextTest(){
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
	}
	
	@Test(priority=60)
	public void verifyContributePageWithCategoryTest(){
		EvMenu.selectRandomCategoryValue();
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
		EvMenu.resetContributeTxtFieldEntries();
	}
	
	@Test(priority=70)
	public void verifyContributePageWithWordTest(){
		EvMenu.enterWordValue();
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
		EvMenu.resetContributeTxtFieldEntries();
	}
	
	@Test(priority=80)
	public void verifyContributePageWithRequiredTextTest(){
		EvMenu.selectRandomCategoryValue();
		EvMenu.enterWordValue();
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedSuccessfullContributeMessage);
	}
	
	@Test(priority=90)
	public void categorySettingPageTest(){
		EvMenu.navigateToCategorySetting();
		categoryName = EvMenu.selectCategory();
		EvMenu.submitSelectCategory(expectedAlertMessage);
		EvMenu.submitSettingPage();
		Categories.verifySpecificCategory(categoryName);
	}
	
	@Test(priority=100)
	public void wordOfTheDayTest(){
		EvMenu.navigateToWordOfTheDay();
		EvMenu.selectCategory();
		EvMenu.submitSelectCategory(expectedAlertMessage);
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=110)
	public void getInTouchPageTest(){
		/*EvMenu.navigateToGetInTouch();
		EvMenu.verifyGetInTouchLinks();
		EvMenu.submitSettingPage();*/
	}
	
	@Test(priority=120)
	public void dislcaimerPageTest(){
		EvMenu.navigateToDisclaimer();
		EvMenu.verifyDisclaimerPageLoaded();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=130)
	public void faqsPageTest(){
		EvMenu.navigateToFAQS();
		EvMenu.verifyFaqsPageLoaded();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=140)
	public void termAndConditionPageTest(){
		EvMenu.navigateToTermsAndCondition();
		EvMenu.verifyTermsAndConditionPageLoaded();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=150)
	public void privacyPolicyPageTest(){
		EvMenu.navigateToPrivacyPolicy();
		EvMenu.verifyPrivacyPolicyPageLoaded();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=160)
	public void selectAllCategoryInCategorySettingPageTest(){
		EvMenu.navigateToCategorySetting();
		EvMenu.markAllCategoryBtn();
		EvMenu.submitSelectCategory(expectedAlertMessage);
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=170)
	public void selectAllCategoryInWordOffTheDayPageTest(){
		EvMenu.navigateToWordOfTheDay();
		EvMenu.markAllCategoryBtn();
		EvMenu.submitSelectCategory(expectedAlertMessage);
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=180)
	public void rateThisAppTest(){
		/*EvMenu.navigateToRateThisApp();
		EvMenu.verifyElementOnAppStorePage();
		EvMenu.closeAppStorePage();
		EvMenu.submitSettingPage();*/
	}
	
/*	@Test(priority=182)
	public void evmenuShareAppTest(){
		EvMenu.navigateToAppSharePage();
	}
	
	@Test(priority=184)
	public void evmenuLoginFacebookTest(){
		EvMenu.facebookLogin();
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=185)
	public void evmenuSelectAudienceTest(){
		EvMenu.selectAudience(audienceType);
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=186)
	public void evmenuFacebookMessageSharingTest(){
		EvMenu.facebookShareMessage();
		EvMenu.postFacebookMessage();
		EvMenu.verifySuccessfullyPostFacebookMessage();
		EvMenu.submitSettingPage();
	}*/
	
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
