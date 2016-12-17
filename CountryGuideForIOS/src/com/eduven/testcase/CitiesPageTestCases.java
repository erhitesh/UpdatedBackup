package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Cities;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;

public class CitiesPageTestCases {

	String citiesName = "";
	String subCategoryName = "";
	
	@Test(priority=0)
	public void handling_splash_screen_test() {
		SplashScreen.allowNotification();
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void cities_page_icon_test(){
		Cities.clickOnCitiesIcon();
	}
	
	@Test(priority=2)
	public void verify_cities_page_cities_list_test(){
		Cities.verifyCitiesCategoryList();
	}
	
	@Test(priority = 3)
	public void click_on_random_city_test() {
		citiesName = Cities.clickOnRandomCitiesCategory();
	}
	
	@Test(priority = 4)
	public void verify_random_city_header_txt_and_sub_category_header_test() {
		Cities.verifyCityAndCityPageHeaderText(citiesName);
	}
	
	@Test(priority=5)
	public void verify_subcategory_and_term_page_header_text_test(){
		subCategoryName = Cities.clickOnRandomSubCategory();
		Cities.verifySubCategoryAndTermPageHeaderTxt(subCategoryName);
	}
	
	@Test(priority = 6)
	public void cities_page_verify_contribute_entity_test() {
		Reusables.verifyContributeEntity();
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
	public void close_app(){
		Reusables.terminatesAppInstance();
		
	}

}
