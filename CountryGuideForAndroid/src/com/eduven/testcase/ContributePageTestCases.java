package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Contribute;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;

public class ContributePageTestCases {
	
	String blank_title = DataConstants.blank_title_txt_message;
	String space_title = DataConstants.spaces_title_txt_message;
	String title_txt = DataConstants.contribute_title;
	String share_medium_type = "Facebook";
	String audience_type = "Friends";

	
	@Test(priority=0)
	public void close_flyer_popup_test(){
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void contribute_page_navigate_to_contribute_test(){
		Contribute.navigateToContributePage();
		Contribute.verifyContributePageLoaded();
	}
	
	@Test(priority=2)
	public void contribute_page_verify_profile_pic_adder_test(){
		Contribute.verifyContributePageLoaded();
	}
	
	@Test(priority=3)
	public void contribute_page_add_contribute_without_title_test(){
		Contribute.addTitleMessage(blank_title);
		Contribute.verifyContributeButtonStatus();
		Contribute.verifyPicAddedOnContribute();
	}
	
	@Test(priority=4)
	public void contribute_page_add_contribute_with_space_title_test(){
		Contribute.addTitleMessage(space_title);
		Contribute.verifyContributeButtonStatus();
		Contribute.verifyPicAddedOnContribute();
	}
	
	@Test(priority=5)
	public void contribute_page_add_contribute_with_title_test(){
		Contribute.addTitleMessage(title_txt);
		Contribute.verifyContributeButtonStatus();
		Contribute.submitContributePage();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=6)
	public void contribute_page_more_apps_test(){
		Contribute.navigateToMoreAppsPage();
		Contribute.verifyMoreAppsPageLoaded();
		Reusables.stepBack();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=7)
	public void contribute_page_navigate_to_settings_page_test(){
		Contribute.navigateToSettingPage();
		Contribute.verifySettingPageLoaded();
	}
	
	@Test(priority=8)
	public void contribute_page_settings_information_and_support_disclaimer_test(){
		Contribute.verifyInformationAndSupportForDisclaimer();
		Contribute.verifySettingPageLoaded();
	}
	
	@Test(priority=9)
	public void contribute_page_settings_information_and_support_faqs_test(){
		Contribute.verifyInformationAndSupportForFaq();
		Contribute.verifySettingPageLoaded();
	}
	
	@Test(priority=10)
	public void contribute_page_settings_information_and_support_privacy_policy_test(){
		Contribute.verifyInformationAndSupportForPrivacyPolicy();
		Contribute.verifySettingPageLoaded();
	}
	
	@Test(priority=11)
	public void contribute_page_settings_information_and_support_for_terms_and_conditions_test(){
		Contribute.verifyInformationAndSupportForTermsAndConditions();
		Contribute.verifySettingPageLoaded();
	}
	
	@Test(priority=12)
	public void contribute_page_navigate_to_app_sharing_page_test(){
		Contribute.verifySettingPageLoaded();
		Contribute.clickOnShareApp();
		Contribute.selectShareType(share_medium_type);
	}
	
	@Test(priority=13)
	public void contribute_page_facebook_login_test(){
		Contribute.facebookLogin();
		Contribute.verifyFacebookPostButton();
	}
	
	@Test(priority=14)
	public void contribute_page_select_audience_test(){
		Contribute.selectAudience(audience_type);
		Contribute.verifyFacebookPostButton();
	}
	
	@Test(priority=15)
	public void contribute_page_facebook_message_sharing_test(){
		Contribute.facebookShareMessage();
		Contribute.postFacebookMessage();
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
