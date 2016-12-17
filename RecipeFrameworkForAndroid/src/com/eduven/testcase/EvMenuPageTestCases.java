package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.Tips;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EvMenuPageTestCases {
	
	/* Global Variable Declaration */
	String shareType = "facebook";
	String audience_type = "public";
	String type_of_diet_for_veg = DataConstants.typeOfDietForVegetarian;
	String appNameFromMoreAppsPage = "";
	String recipeName = "";
	String ingredientName = "";
	String methodValue = "";
	String userName = DataConstants.user_name;
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=5)
	public void selectFirstTypeOfDietTest(){
		type_of_diet_for_veg = TypeOfDiet.selectTypeOfDiet(type_of_diet_for_veg);
	}
	
	@Test(priority=6)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=10)
	public void navigateToEvmenuTest(){
		EvMenu.navigateToEvMenuPage();
		EvMenu.verifyEvMenuList();
	}
	
	@Test(priority=20)
	public void evmenuMoreAppsTest(){
		EvMenu.clickOnMoreAppButton();
		EvMenu.verifyMoreAppPageLoaded();
		appNameFromMoreAppsPage = EvMenu.getAppNameOnMoreAppsPage();
		EvMenu.clickOnInstallButton();
		EvMenu.verifyPlayStorePageOpen();
		Reusables.oneStepBack();
		Reusables.oneStepBack();
	}
	
	@Test(priority=30)
	public void evmenuTipsTest(){
		EvMenu.navigateToEvMenuPage();
		EvMenu.clickOnTipsButton();
		Tips.verifyTipsPageHeaderText();
		//Tips.verifyTipsRelatedDescription(DataConstants.tip_description_name_for_beauty);
		Reusables.oneStepBack();
	}
	
	@Test(priority=40)
	public void evmenuContributeWithIngredientsTest(){
		EvMenu.navigateToContributePage();
		EvMenu.verifyContributePageLoaded();
		recipeName = EvMenu.fillTextBoxValue();
		ingredientName = EvMenu.addIngredientsValue(recipeName);
		EvMenu.submitIngredientValue();
		Reusables.oneStepBack();
		EvMenu.verifyIngredientName(ingredientName);
		methodValue = EvMenu.addMethodValue();
		EvMenu.verifyMethodTxt(methodValue);
		EvMenu.submitContribute();
		SplashScreen.allowMediaFilesAndContacts();
		SplashScreen.verifyUserIdPopUp();
		String imageFilePath = ScreenShot.takescreenShotCaptureForToast();
		Reusables.verifyToastMessageUsingImage(imageFilePath, DataConstants.toastMessageForContribute);
	}
	
	@Test(priority=50)
	public void evmenuInformationAndSupportForDisclaimerTest(){
		EvMenu.navigateToDisclaimerPage();
		EvMenu.verifyDisclaimerPageLoaded();
		Reusables.oneStepBack();
		Reusables.oneStepBack();
	}
	
	@Test(priority=52)
	public void evmenuInformationAndSupportForTermAndConditionTest(){
		EvMenu.navigateToTermsAndConditionsPage();
		EvMenu.verifyTermsAndConditionsPageLoaded();
		Reusables.oneStepBack();
		Reusables.oneStepBack();
	}
	
	@Test(priority=53)
	public void evmenuInformationAndSupportForPrivacyPolicyTest(){
		EvMenu.navigateToPrivacyPolicyPage();
		EvMenu.verifyPrivacyPolicyPageLoaded();
		Reusables.oneStepBack();
		Reusables.oneStepBack();
	}
	
	@Test(priority=55)
	public void evmenuFeedbackGetInTouchTest(){
		EvMenu.navigateToGetInTouch();
		EvMenu.verifyGetInTouchLinks();
	}
	
	@Test(priority=60)
	public void evmenuShareAppTest(){
		EvMenu.navigateToShareThisApp();
		EvMenu.selectShareType(shareType);
	}
	
	@Test(priority=70)
	public void evmenuLoginFacebookTest(){
		EvMenu.facebookLogin();
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=80)
	public void evmenuSelectAudienceTest(){
		EvMenu.selectAudience(audience_type);
		EvMenu.verifyFacebookPostButton();
	}
	
	@Test(priority=90)
	public void evmenuFacebookMessageSharingTest(){
		EvMenu.facebookShareMessage();
		EvMenu.postFacebookMessage();
		Reusables.oneStepBack();
	}
	
	@Test(priority=100)
	public void evmenuRateAppTest(){
		EvMenu.navigateToRateThisApp();
		EvMenu.verifyRateThisAppUserName(userName);
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
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
	
}
