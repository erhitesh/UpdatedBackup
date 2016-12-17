package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EduBank;
import com.eduven.modules.HistoricalHangouts;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;

public class EduBankPageTestCases {
	
    String eduBank_saved_entity = "";
    String mainCategoryName = DataConstants.historical_hangout_header_text;
    String subCategoryName = "";

	@Test(priority=0)
	public void eduBank_page_splash_screen_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}

	@Test(priority=1)
	public void eduBank_page_check_favourite_and_alert_test() {
		EduBank.clickEduBankCategory();
		EduBank.verifyAlertMessage();
		EduBank.acceptAlertPopup();
	}
	
	@Test(priority=2)
	public void eduBank_page_navigate_to_entity_detail_test(){
		HistoricalHangouts.clickOnHistoricalHangouts();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.navigateToFreeEntityDetailPage(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=3)
	public void eduBank_page_add_favourite_to_eduBank_test(){
		EduBank.addEntityToEduBank();
		eduBank_saved_entity = EduBank.getFavouriteCategoryName();
	}

	@Test(priority=4)
	public void navigate_to_edubank_test(){
		Reusables.stepBack();
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	@Test(priority=5)
	public void verify_eduBank_add_entity_test(){
		EduBank.clickEduBankCategory();
		EduBank.clickFirstEduBankElement();
		Reusables.verifyEqualMessage(EduBank.getFavouriteCategoryName(), eduBank_saved_entity, "Error Message! Not match both text");
	}
	
	@Test(priority=6)
	public void remove_entity_from_eduBank(){
		EduBank.removeEntityFromEduBank();
		Reusables.stepBack();
		EduBank.clickEduBankCategory();
		EduBank.verifyAlertMessage();
		EduBank.acceptAlertPopup();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}

	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
