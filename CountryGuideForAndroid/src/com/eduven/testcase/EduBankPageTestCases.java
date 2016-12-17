package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EduBank;
import com.eduven.modules.HistoricalHangouts;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;

public class EduBankPageTestCases {
	
    String eduBank_saved_entity = "";
    String mainCategoryName = DataConstants.historical_hangout_header_text;
    String subCategoryName = "";


	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}

	@Test(priority=1)
	public void eduBank_page_check_entity_in_eduBank_test() {
		EduBank.clickEduBankCategory();
		EduBank.verifyEntityInEduBank();
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
		eduBank_saved_entity = EduBank.getFavouriteEntityName();
		System.out.println("eduBank_saved_entity...."+eduBank_saved_entity);
	}

	@Test(priority=4)
	public void navigate_to_edubank_test(){
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=5)
	public void verify_eduBank_add_entity_test(){
		EduBank.clickEduBankCategory();
		EduBank.clickFirstEduBankEntity();
		EduBank.clickFirstEduBankEntity();
		Reusables.verifyEqualMessage(EduBank.getFavouriteEntityName(), eduBank_saved_entity, "Error Message! Not match both text");
	}
	
	@Test(priority=6)
	public void remove_entity_from_eduBank(){
		EduBank.removeEntityFromEduBank();
		Reusables.stepBack();
		EduBank.clickEduBankCategory();
		EduBank.verifyEntityInEduBank();
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
