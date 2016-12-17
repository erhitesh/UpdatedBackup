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
	
	/* Global Variable declaration */
	String audience_type = "friends";
	String keyboard_key = "return";
	String blank_spaces = "     ";
	
	@Test(priority=0)
	public void contribute_page_test(){
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void contribute_page_navigate_to_contribute_test(){
		Contribute.navigateToContribute();
	}
	
	@Test(priority=2)
	public void contribute_page_verify_profile_pic_adder_test(){
		Contribute.verifyProfilePicAdder();
	}
	
	@Test(priority=3)
	public void contribute_page_add_contribute_without_title_test(){
		Contribute.clickOnContributeSubButton();
		Reusables.verifyEqualMessage(Reusables.getAlertMessage().toString(), DataConstants.contribute_alert_message_with_failure, "Error Message! Alert messages does not matched.");
		Reusables.acceptAlert();
		Contribute.verifyProfilePicAdder();
	}
	
	@Test(priority=4)
	public void contribute_page_add_contribute_with_space_title_test(){
		Contribute.addTitle(blank_spaces);
		Reusables.hideKeyboard(keyboard_key);
		Contribute.clickOnContributeSubButton();
		Reusables.verifyEqualMessage(Reusables.getAlertMessage().toString(), DataConstants.contribute_alert_message_succes, "Error Message! Alert messages does not matched.");
		Reusables.acceptAlert();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=5)
	public void contribute_page_add_contribute_with_title_test(){
	    Contribute.navigateToContribute();
		Contribute.addTitle(DataConstants.contribute_title);
		Reusables.hideKeyboard(keyboard_key);
		Contribute.clickOnContributeSubButton();
		Reusables.verifyEqualMessage(Reusables.getAlertMessage().toString(), DataConstants.contribute_alert_message_succes, "Error Message! Alert messages does not matched.");
		Reusables.acceptAlert();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=6)
	public void contribute_page_more_apps_test(){
		Contribute.navigateToMoreApps();
		Contribute.verifyMoreAppsPageLoaded();
		Contribute.closeMoreAppaPage();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=7)
	public void contribute_page_settings_information_and_support_disclaimer_test(){
		Contribute.navigateToSetting();
		Contribute.verifySettingPageLoaded();
		Contribute.verify_information_support_for_disclaimer();
		Contribute.settingDone();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=8)
	public void contribute_page_settings_information_and_support_faqs_test(){
		Contribute.navigateToSetting();
		Contribute.verifySettingPageLoaded();
		Contribute.verifyInformationSupportForFaqs();
		Contribute.settingDone();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=9)
	public void contribute_page_settings_information_and_support_privacy_test(){
		Contribute.navigateToSetting();
		Contribute.verifySettingPageLoaded();
		Contribute.verifyInformationSupportForPrivacy();
		Contribute.settingDone();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@Test(priority=11)
	public void contribute_page_settings_feedback_share_app_test(){
		Contribute.navigateToSetting();
		Contribute.verifySettingPageLoaded();
		Contribute.clickOnShareApp();
		Contribute.facebookLogin();
		Contribute.verifyFacebookPostButton();
		//Contribute.facebook_share_message();
		Contribute.clickOnAudience();
		Contribute.selectAudience(audience_type);
		Contribute.postFacebookMessage();
		Contribute.settingDone();
		HomePage.verfiyCategoryIconPresent();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}

	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
