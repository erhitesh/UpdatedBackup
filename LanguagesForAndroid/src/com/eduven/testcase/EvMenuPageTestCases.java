package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EvMenu;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EvMenuPageTestCases {

	
	/* Global Declaration */
	String languageName = "";
	String wordText = DataConstants.contribute_word_text;
	String expectedFailContributeMessage = DataConstants.contribute_alert_message_for_failed_submission;
	String expectedSuccessfullContributeMessage = DataConstants.contribute_alert_message_for_successfull_submission;
	String categoryName = "";
	String category_term_name = "";
	String expectedAlertMessage = DataConstants.category_settings_alert_message;
	String app_sharing_type = "facebook";
	String audience_type = "friends";
	String selected_audience_type = "";
	
	
	@Test(priority=10)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void navigateToMoreAppsPageTest(){
		EvMenu.navigateToMoreAppsPage();
	}
	
	@Test(priority=30)
	public void verifyMoreAppsPageLoadedTest(){
		EvMenu.verifyMoreAppsPageLoaded();
	}
	
	@Test(priority=35)
	public void navigateToAppListPageTest(){
		EvMenu.navigateToMoreAppsListPage();
		EvMenu.selectAppNameFromAppList();
	}
	
	@Test(priority=36)
	public void verifyGooglePlayStorePageLoadedTest(){
		EvMenu.verifyGooglePlayStorePageLoaded();
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	@Test(priority=40)
	public void navigateContributePageTest(){
		EvMenu.navigateToContributePage();
		EvMenu.verifyContributePageLoaded();
	}
	
	@Test(priority=50)
	public void verifyContributePageWithoutTextTest(){
		EvMenu.submitContributePage();
		EvMenu.contributeContinue();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
	}
	
	@Test(priority=60)
	public void verifyContributePageWithCategoryTest(){
		EvMenu.selectRandomCategoryValue(languageName);
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
		EvMenu.resetContributeTxtFieldEntries();
	}
	
	@Test(priority=70)
	public void verifyContributePageWithWordTest(){
		EvMenu.enterWordValue(wordText);
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedFailContributeMessage);
		EvMenu.resetContributeTxtFieldEntries();
	}
	
	@Test(priority=80)
	public void verifyContributePageWithRequiredTextTest(){
		EvMenu.selectRandomCategoryValue(languageName);
		EvMenu.enterWordValue(wordText);
		EvMenu.submitContributePage();
		EvMenu.verifyContribteSubmissionMessage(expectedSuccessfullContributeMessage);
	}
	
	@Test(priority=90)
	public void categorySettingPageTest(){
		EvMenu.navigateToCategorySetting();
		EvMenu.verifyCategorySettingPageLoaded();
		categoryName = EvMenu.selectCategory(languageName);
		EvMenu.submitSelectCategory(expectedAlertMessage);
		EvMenu.submitSettingPage();
		Categories.verifySpecificCategory(categoryName);
	}
	
	@Test(priority=100)
	public void wordOfDayTest(){
		EvMenu.navigateToWordOfTheDay();
		EvMenu.selectWordOfTheDayCategory(languageName);
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=110)
	public void verifyDislcaimerTest(){
		EvMenu.navigateToDisclaimer();
		EvMenu.verifyDisclaimerPageLoaded();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=120)
	public void verifyFaqsTest(){
		EvMenu.navigateToFAQS();
		EvMenu.verifyFaqsPageLoaded();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=130)
	public void verifyTermAndConditionTest(){
		EvMenu.navigateToTermsAndCondition();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=140)
	public void verifyPrivacyPolicyTest(){
		EvMenu.navigateToPrivacyPolicy();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=150)
	public void checkAllCategoryInCategorySettingTest(){
		EvMenu.navigateToCategorySetting();
		EvMenu.verifyCategorySettingPageLoaded();
		EvMenu.markAllCategoryBtn();
		EvMenu.submitSelectCategory(expectedAlertMessage);
		EvMenu.submitSettingPage();
		Categories.verifySpecificCategory(categoryName);
	}
	
	@Test(priority=160)
	public void getInTouchPageTest(){
		EvMenu.navigateToGetInTouch();
		EvMenu.verifySocialSiteBtnExistence();
		EvMenu.verifyGetInTouchLinks();
		Reusables.stepBack();
		EvMenu.submitSettingPage();
	}
	
/*	@Test(priority=170)
	public void navigate_to_app_sharing_test(){
		EvMenu.navigateToAppSharePage();
		EvMenu.appSharingType(app_sharing_type);
	}
	
	@Test(priority=180)
	public void login_into_social_site_test(){
		EvMenu.facebookLogin();
	}
	
	@Test(priority=190)
	public void app_sharing_message_test(){
		EvMenu.facebookShareMessage();
		EvMenu.clickOnAudience();
	}
	
	@Test(priority=200)
	public void verify_audience_type_and_post_message_test(){
		selected_audience_type = EvMenu.selectAudience(audience_type);
		EvMenu.verifySelectedAudienceType(selected_audience_type);
		EvMenu.postFacebookMessage();
		EvMenu.submitSettingPage();
	}*/
	
	@Test(priority=210)
	public void verifyRateThisAppTest(){
		EvMenu.navigateToRateThisApp();
		EvMenu.verifyRateThisAppUserName(DataConstants.userName);
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
	
	@AfterClass()
	public void closeApp(){
		Reusables.terminatesAppInstance();
		}
}
