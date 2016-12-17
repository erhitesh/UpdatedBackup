package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Cities;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class CitiesPageTestCases {

	String citiesName = "";
	String countryName = "";
	
	@Test(priority = 0)
	public void handling_splash_screen_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}

	@Test(priority = 1)
	public void cities_page_icon_test() {
		Cities.clickOnCitiesIcon();
	}

	@Test(priority = 2)
	public void verify_cities_page_cities_list_test() {
		Cities.verifyCitiesList();
	}

	@Test(priority = 3)
	public void click_on_random_city_test() {
		citiesName = Cities.clickOnRandomCitiesList();
	}
	
	@Test(priority = 4)
	public void verify_random_city_header_txt_and_sub_category_header_test() {
		Cities.verifyCategoryAndSubcategoryHeaderTxt(citiesName);
	}

	@Test(priority = 5)
	public void cities_page_verify_contribute_entity_test() {
		Reusables.verifyContributeEntity();
	}
	
	@Test(priority=6)
	public void remove_random_category_from_filter_layout_test(){
		HomePage.navigateToHomePage();
		Cities.clickOnFilterBtn();
		countryName = Cities.deSelectRandomCountryFromCountryLayout();
	}
	
	@Test(priority=7)
	public void verify_city_name_correspond_to_country_name_test(){
		Reusables.stepBack();
		Cities.verifyCityCorrespondingCityRemoved(countryName);
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
