package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EvMenuPageTestCases {
	
	
	/* Global Variable Declaration */
	String blankTitle = DataConstants.blankTitleTxtMessage;
	String spaceTitle = DataConstants.spacesTitleTxtMessage;
	String titleTxt = DataConstants.titleTxtMessage;
	String shareMediumType = "Facebook";
	String audienceType = "Friends";
	String appNameFromMoreAppsPage = "";

	
	@Test(priority=1)
	public void evMenuContributePageTest(){
		EvMenu.navigateToContributePage();
		EvMenu.verifyContributePageLoaded();
	}
	
	@Test(priority=10)
	public void evMenuAddBlankTitleToContributeTest(){
		EvMenu.addTitleMessage(blankTitle);
		EvMenu.submitContributePage();
		EvMenu.allowToAccessContacts();
		EvMenu.contributeContinue();
		EvMenu.verifyContributePopUpMessage(DataConstants.contributePopupMessageForBlank);
		EvMenu.submitContributeMessagePopup();
		EvMenu.verifyContributePageLoaded();
	}
	
	@Test(priority=20)
	public void evMenuAddSpaceAsTitleToContributeTest(){
		EvMenu.addTitleMessage(spaceTitle);
		EvMenu.submitContributePage();
		EvMenu.verifyContributePopUpMessage(DataConstants.contributePopupMessageForBlank);
		EvMenu.submitContributeMessagePopup();
		EvMenu.verifyContributePageLoaded();
	}
	
	@Test(priority=30)
	public void evMenuAddMessageTitleToContributeTest(){
		EvMenu.verifyAddContributeMessageAfterFixIteration();
	}
	
/*	@Test(priority=40)
	public void evMenuPageMoreAppsTest(){
		EvMenu.navigateToMoreAppsPage();
		EvMenu.verifyMoreAppsPageLoaded();
		appNameFromMoreAppsPage = EvMenu.getAppNameOnMoreAppsPage();
		EvMenu.clickOnInstallButton();
		//Contribute.verifyAppNameMessageOnPlayStorePage(appNameFromMoreAppsPage);
		EvMenu.verifyPlayStorePageOpen();
		Reusables.stepBack();
		Reusables.stepBack();
		Categories.verifyCategoryPageLoaded();
	}*/
	
	@Test(priority=50)
	public void evMenuSettingsTest(){
		EvMenu.navigateToSettingPage();
		EvMenu.verifySettingPageLoaded();
		Reusables.stepBack();
		Categories.verifyCategoryPageLoaded();
	}
	
	@Test(priority=60)
	public void evMenuDisclaimerTest(){
		EvMenu.navigateToDisclaimerPage();
		EvMenu.verifyInformationAndSupportForDisclaimer();
		Reusables.stepBack();
	}
	
	@Test(priority=70)
	public void evMenuTermsAndConditionsTest(){
		EvMenu.navigateToTermsAndConditionsPage();
		EvMenu.verifyInformationAndSupportForTermsAndConditions();
		Reusables.stepBack();
	}
	
	@Test(priority=80)
	public void evMenuPrivacyPolicyTest(){
		EvMenu.navigateToPrivacyPolicyPage();
		EvMenu.verifyInformationAndSupportForPrivacyPolicy();
		Reusables.stepBack();
	}
	
	@Test(priority=85)
	public void evMenuGetInTouchPageTest(){
		EvMenu.navigateToGetInTouch();
		EvMenu.verifyGetInTouchLinks();
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
/*	@Test(priority=90)
	public void evMenuShareAppTest(){
		EvMenu.navigateToSettingPage();
		EvMenu.clickOnShareApp();
		EvMenu.selectShareType(shareMediumType);
	}
	
	@Test(priority=100)
	public void evMenuLoginFacebook(){
		EvMenu.facebookLogin();
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=110)
	public void evMenuSelectAudienceTest(){
		EvMenu.selectAudience(audienceType);
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=120)
	public void evMenuFacebookMessageSharingTest(){
		EvMenu.facebookShareMessage();
		EvMenu.postFacebookMessage();
	}
	
	@Test(priority=125)
	public void evMenuRateThisAppTest(){
		EvMenu.navigateToRateThisApp();
		EvMenu.verifyRateThisAppUserName(DataConstants.userName);
	}*/
	
	@Test(priority=130)
	public void verifyAdsBannerTest(){
		HomePage.verifyAds();
	}
	
	 @AfterMethod 
	 public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
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
	 public void closeApp(){
		 Reusables.terminatesAppInstance();
	 }
}
