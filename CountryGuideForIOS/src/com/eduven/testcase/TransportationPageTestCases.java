package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TransportationHubs;
import com.eduven.report.ScreenShot;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class TransportationPageTestCases {

	String mainCategoryName = DataConstants.transportation_header_text;
	String subCategoryName = "";
	String termName = "";
	String cityName = "";
	
	@Test(priority=0)
	public void transportation_page_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void transportation_page_header_test(){
		TransportationHubs.clickOnTransportationHub();
		TransportationHubs.verifyTransportationHeaderTxt();
		Reusables.stepBack();
    	Categories.verfiyCategoryIconPresent();
    	TransportationHubs.clickOnTransportationHub();
    	TransportationHubs.verifyTransportationHeaderTxt();
	}
	
	@Test(priority=2)
	public void transportation_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void transportation_page_free_entity_test(){
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkFreeEntity(mainCategoryName, subCategoryName);
	}

	@Test(priority=4)
	public void transportation_page_premium_entity_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkPremiumEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=5)
	public void verify_contribute_entity_test(){
		Reusables.verifyContributeEntity();
	}
	
	@Test(priority=6)
	public void verify_city_name_and_header_text_inside_term_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		termName = Reusables.navigateToFreeEntityDetailPage(mainCategoryName, subCategoryName);
		cityName = DatabaseConnection.categoryCityName(mainCategoryName, subCategoryName,termName);
		Reusables.clickOnCityNameInSideTermName(cityName);
		Reusables.verifyCityHeaderName(cityName);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()) {
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
