package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EVMenu;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EvMenuPageTestCases {
	
	
	@Test(priority=0)
	public void navigateToEvmenuTest(){
		Categories.navigateToCategoryPage();
		EVMenu.navigateToInfoPage();
		EVMenu.submitEvMenuPage();
	}
	
	@Test(priority=5)
	public void verifyMoreAppsTest(){
		EVMenu.navigateToMoreAppsPage();
		EVMenu.navigateToAppsList();
		EVMenu.clickOnAppNameFromAppList();
		EVMenu.verifyElementOnAppStorePage();
		EVMenu.closeAppStore();
		EVMenu.closeMoreAppsPage();
		EVMenu.closeMoreAppsPage();
	}
	
	@Test(priority=8)
	public void verifyInformationAndSupprotForDisclaimerTest(){
		EVMenu.navigateToInfoPage();
		EVMenu.navigateToDisclaimerPage();
		//EVMenu.verifyDisclaimerPageLoaded();
		Reusables.oneStepBack();
		EVMenu.submitEvMenuPage();
	}
	
	@Test(priority=10)
	public void verifyInformationAndSupprotForPrivacyPolicyTest(){
		EVMenu.navigateToInfoPage();
		EVMenu.navigateToPrivacyPolicyPage();
		//EVMenu.verifyPrivacyPageLoaded();
		Reusables.oneStepBack();
		EVMenu.submitEvMenuPage();
	}
	
	@Test(priority=15)
	public void verifyInformationAndSupprotForTermsAndConditionsTest(){
		EVMenu.navigateToInfoPage();
		EVMenu.navigateToTermsAndConditionsPage();
		//EVMenu.verifyTermsAndConditionsPageLoaded();
		Reusables.oneStepBack();
		EVMenu.submitEvMenuPage();
	}
	
	@Test(priority=60)
	public void verifyInformationAndSupprotForGetInTouchTest(){
		EVMenu.verifyGetInTouchLinks();
		EVMenu.submitEvMenuPage();
	} 
	
	@Test(priority=25)
	public void evmenuShareAppTest(){
		EVMenu.navigateToAppSharing();
	}
	
	@Test(priority=30)
	public void evmenuLoginFacebookTest(){
		EVMenu.facebookLogin();
		EVMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=35)
	public void evmenuSelectAudienceTest(){
		EVMenu.selectAudience(DataConstants.audienceTypePublic);
		EVMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=40)
	public void evmenuFacebookMessageSharingTest(){
		EVMenu.facebookShareMessage();
		EVMenu.postFacebookMessage();
		EVMenu.acceptOpenThisPageInAppName();
		EVMenu.appSharingSuccessfullMessage();
		EVMenu.submitEvMenuPage();
	}
	
	@Test(priority=50)
	public void rateThisAppTest(){
		EVMenu.navigateToRateThisApp();
		EVMenu.verifyElementOnAppStorePage();
		//EVMenu.closeAppStorePage();
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
