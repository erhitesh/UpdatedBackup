package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EvMenuPageTestCases {
	
	
	/*Global Variable Declaration */
	String typeOfDietName = DataConstants.typeOfDietForVegetarian;
	String recipeName = "";
	String ingredientName = "";
	String methodValue = "";
	String audienceType = "public";
	
	
	@Test(priority=0)
	public void splashScreenHandlingTest(){
		SplashScreen.hideAppRatePopUp();
	}
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=5)
	public void selectFirstTypeOfDietTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietName = TypeOfDiet.selectTypeOfDiet(typeOfDietName);
	}
	
	@Test(priority=20)
	public void evmenuMoreAppsTest(){
		EvMenu.navigateToMoreAppsPage();
		EvMenu.verifyMoreAppsPageLoaded();
		EvMenu.openAppsList();
		EvMenu.clickOnAppNameFromAppList();
		EvMenu.verifyAppStorePageLoaded();
		EvMenu.verifyElementOnAppStorePage();
		EvMenu.closeAppStorePage();
		EvMenu.closeAppListPage();
		EvMenu.closeMoreAppsPage();
	}
	
	@Test(priority=40)
	public void evmenuContributeWithIngredientsTest(){
		EvMenu.navigateToContributePage();
		//EvMenu.verifyContributePageLoaded();
		recipeName = EvMenu.fillTextBoxValue();
		ingredientName = EvMenu.addIngredientsValue(recipeName);
		EvMenu.submitIngredientValue();
		methodValue = EvMenu.addMethodValue();
		EvMenu.submitContribute();
	}

	@Test(priority=50)
	public void evmenuInformationAndSupportForDisclaimerTest(){
		EvMenu.navigateToDisclaimer();
		EvMenu.verifyDisclaimerPageLoaded();
		Reusables.oneStepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=52)
	public void evmenuInformationAndSupportForTermAndConditionTest(){
		EvMenu.navigateToTermsAndCondition();
		EvMenu.verifyTermsAndConditionsPageLoaded();
		Reusables.oneStepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=53)
	public void evmenuInformationAndSupportForPrivacyPolicyTest(){
		EvMenu.navigateToPrivacyPolicy();
		EvMenu.verifyPrivacyPolicyPageLoaded();
		Reusables.oneStepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=60)
	public void evmenuInformationAndSupportForFaqsTest(){
		EvMenu.navigateToFAQS();
		EvMenu.verifyFaqsPageLoaded();
		Reusables.oneStepBack();
		EvMenu.submitSettingPage();
	}
	
	@Test(priority=65)
	public void evmenuFeedbackGetInTouchTest(){
		EvMenu.navigateToGetInTouch();
		EvMenu.verifyGetInTouchLinks();
	}
	
/*	@Test(priority=68)
	public void evmenuShareAppTest(){
		EvMenu.navigateToAppSharePage();
	}
	
	@Test(priority=70)
	public void evmenuLoginFacebookTest(){
		EvMenu.facebookLogin();
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=80)
	public void evmenuSelectAudienceTest(){
		EvMenu.selectAudience(audienceType);
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=90)
	public void evmenuFacebookMessageSharingTest(){
		EvMenu.facebookShareMessage();
		EvMenu.postFacebookMessage();
		EvMenu.verifySuccessfullyPostFacebookMessage();
		EvMenu.submitSettingPage();
	}*/
	
	@Test(priority=100)
	public void rateThisAppTest(){
		EvMenu.navigateToRateThisApp();
		EvMenu.verifyElementOnAppStorePage();
		EvMenu.closeAppStorePage();
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
