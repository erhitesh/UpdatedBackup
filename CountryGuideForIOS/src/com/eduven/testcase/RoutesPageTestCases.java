package com.eduven.testcase;

import org.openqa.selenium.Point;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.Routes;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class RoutesPageTestCases {
	
	String mainCategoryName = DataConstants.routes_header_txt;
	String subCategoryName = "";
	String speedButton = "Five";
    Point point;
	
	@Test(priority=0)
	public void routes_page_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void routes_page_header_test(){
		Routes.clickOnRoutes();
		Routes.verifyRoutesHeaderTxt();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		Routes.clickOnRoutes();
		Routes.verifyRoutesHeaderTxt();
	}
	
	@Test(priority=2)
	public void routes_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void routes_page_free_entity_test(){
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkFreeEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=4)
	public void routes_page_premium_entity_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkPremiumEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=5)
	public void routes_page_entity_detail_play_button_existance_test(){
		Reusables.navigateToFreeEntityDetailPage(mainCategoryName, subCategoryName);
		Routes.verifPlayButtonExistance();
	}
	
	@Test(priority=6)
	public void routes_page_entity_detail_street_view_button_existance_test(){
		Routes.verifyStreetViewButtonExistance();
	}
	
	@Test(priority=7)
	public void routes_page_entity_detail_speed_up_button_existance_test(){
		Routes.verifySpeedUpButtonExistance();
	}
	
	@Test(priority=8)
	public void routes_page_entity_detail_play_button_action_existance_test(){
		Routes.clickOnPlayButton();
		Routes.hidePlayButtonPopUp();
	}
	
	@Test(priority=9)
	public void routes_page_entity_detail_pause_button_action_test(){
		Routes.clickOnPauseButton();
	}
	
	@Test(priority=10)
	public void routes_page_entity_detail_street_view_button_action_test(){
		Routes.clickOnStreetViewButton();
		Routes.hide_street_view();
	}
	
	@Test(priority=11)
	public void route_page_entity_detail_speed_up_button_test(){
		Routes.selectSpeedUpButton(speedButton);
	}
	
	@Test(priority=12)
	public void route_page_entity_detail_verify_coordinates_test(){
		Routes.clickOnPlayButton();
		point = Routes.getGsmCoordinateValue(Routes.getGsmCount());
		Reusables.waitThread(10);
		Routes.getGsmCoordinateValue(Routes.getGsmCount());
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
