package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.CarnivalsFestivals;
import com.eduven.modules.Categories;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class CarnivalsFestivalsPageTestCases {
	
	String mainCategoryName = DataConstants.carnivals_festivals_header_txt;
	String subCategoryName = "";
	String cityName = "";
	String termName = "";
	
	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void verify_carnivals_festivals_page_header_test(){
		CarnivalsFestivals.clickOnCarnivalsFestivals();
		CarnivalsFestivals.verifyCarnivalsFestivalsHeaderTxt();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		CarnivalsFestivals.clickOnCarnivalsFestivals();
		CarnivalsFestivals.verifyCarnivalsFestivalsHeaderTxt();
	}
	
	@Test(priority=2)
	public void carnivals_festivals_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void carnivals_festivals_page_free_entity_test(){
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkFreeEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=4)
	public void carnivals_festivals_page_premium_entity_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkPremiumEntity(mainCategoryName, subCategoryName);
	} 
	
	@Test(priority=5)
	public void carnivals_festivals_page_verify_contribute_entity_test(){
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
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	@Test(priority=7)
	public void carnivals_festivals_page_buy_subscription(){
		Reusables.navigateToPremiumEntityDetailPage(mainCategoryName, subCategoryName);
		EntityDetailPage.appPurchase();
	}
	
	@Test(priority=8)
	public void carnivals_festivals_page_check_paid_term_as_free_term_test(){
		CarnivalsFestivals.clickOnCarnivalsFestivals();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		CarnivalsFestivals.checkPremiumTermAsFreeTerm(mainCategoryName, subCategoryName);
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
