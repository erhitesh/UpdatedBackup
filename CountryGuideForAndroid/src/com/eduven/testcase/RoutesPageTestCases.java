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
import com.eduven.report.Logs;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class RoutesPageTestCases {
	
	String mainCategoryName = DataConstants.routes_header_txt;
	String subCategoryName = "";
    Point point;
	
	@Test(priority=0)
	public void close_flyer_popup_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
	}
	
	@Test(priority=1)
	public void verify_routes_page_header_test(){
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
		Routes.verifyPlayButtonExistance();
	}
	
	@Test(priority=6)
	public void routes_page_entity_detail_play_button_action_existance_test(){
		Routes.clickOnPlayButton();
		//Routes.hide_pop_up_message_box();
		Reusables.stepBack();
	}
	
	@Test(priority=7)
	public void routes_page_entity_detail_verify_pause_button_existance_test(){
		Routes.verifyPauseButtonExistance();
	}
	
	@Test(priority=8)
	public void routes_page_entity_detail_street_view_button_existance_test(){
		Routes.verifyStreetViewButtonExistance();
	}
	
	@Test(priority=9)
	public void routes_page_entity_detail_speed_up_button_existance_test(){
		Routes.verifySpeedButtonExistance();
	}

	@Test(priority=10)
	public void routes_page_entity_detail_pause_button_action_test(){
		Routes.clickOnPauseButton();
	}

	@Test(priority=11)
	public void routes_page_entity_detail_street_view_button_action_test(){
		Routes.clickOnStreetViewButton();
		//Routes.hide_street_view();
		Reusables.stepBack();
	}
	
	@Test(priority=12)
	public void route_page_entity_detail_select_speed_up_test(){
		Routes.clickOnPlayButton();
		Routes.select_speed_up_button();
	}
	
	@Test(priority=13)
	public void route_page_entity_detail_verify_coordinates_test(){
		
		point = Routes.getGsmCoordinateValue(Routes.getGsmCount());
		Reusables.waitThread(10);
		Routes.getGsmCoordinateValue(Routes.getGsmCount());
	}

	@AfterMethod 
	public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 Logs.error("This Method is used to takes screen shot for Failure TestCase..."+result.getMethod().getMethodName());
	 }
	 
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 Logs.error("This Method is used to takes screen shot for SKIP TestCase..."+result.getMethod().getMethodName());
	 }
	 
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 Logs.error("This Method is used to takes screen shot for SuccessPrecentage Failure TestCase..."+result.getMethod().getMethodName());
	 }
   } 
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
