package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.BusinessBoulevards;
import com.eduven.modules.Categories;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class BusinessBoulevardsPageTestCases {
	
	String mainCategoryName = DataConstants.business_boulevards_header_txt;
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
	public void verify_business_boulevards_page_header_test(){
		BusinessBoulevards.clickOnBusinessBoulevards();
		BusinessBoulevards.verifyBusinessBoulevardsHeaderTxt();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		BusinessBoulevards.clickOnBusinessBoulevards();
		BusinessBoulevards.verifyBusinessBoulevardsHeaderTxt();	
	}
	
	@Test(priority=2)
	public void business_boulevards_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void business_boulevards_page_free_entity_test(){
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkFreeEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=4)
	public void business_boulevards_page_premium_entity_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkPremiumEntity(mainCategoryName, subCategoryName);
	}

	@Test(priority=5)
	public void business_boulevards_page_verify_contribute_entity(){
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
