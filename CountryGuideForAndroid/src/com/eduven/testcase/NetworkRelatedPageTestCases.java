package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.ArtAficionados;
import com.eduven.modules.Contribute;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class NetworkRelatedPageTestCases {

	/* Global Variable Declaration */
	String mainCategoryName = DataConstants.art_aficionados_header_text;
	String subCategoryName = "";
	String termName = "";
	
	boolean air_plane_mode_on = true;
	boolean wifi_mode_of = false;
	boolean data_mode_of = false;
	boolean air_plane_mode_off = false;
	boolean wifi_mode_on = true;

	
	@Test(priority=0)
	public void close_flyer_popup_test(){
		SplashScreen.hideAppRatePopup();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.closeFlyerPopup();
		}
	
	@Test(priority=1)
	public void navigate_to_sub_category_page_test(){
		ArtAficionados.clickOnArtAficionados();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
	}
	
	@Test(priority=2)
	public void test_network_turnoff_network_connection_test(){
		Reusables.getNetConnectionStatus(air_plane_mode_on, wifi_mode_of, data_mode_of);
	}
	
	@Test(priority=3)
	public void check_paid_term_after_network_off_for_airplane_mode_test(){
		Reusables.navigateToPremiumEntityDetailPage(mainCategoryName, subCategoryName);
		EntityDetailPage.clickOnBuyButton();
		Reusables.verifyPaidTermOptAfterNetworkOff(EntityDetailPage.buy_btn);
		Reusables.stepBack();
	}
	
	@Test(priority=4)
	public void check_evMenu_for_network_connection_test(){
		HomePage.navigateToHomePage();
		Contribute.navigateToMoreAppsPage();
		Reusables.verifyPaidTermOptAfterNetworkOff(HomePage.home_page_header_txt);
		
		Contribute.navigateToSettingPage();
		Contribute.clickOnShareApp();
		Reusables.verifyPaidTermOptAfterNetworkOff(Contribute.setting_page_header_txt);
		
		Reusables.stepBack();
		Contribute.navigateToContributePage();
		Contribute.addTitleMessage(DataConstants.contribute_title);
		Contribute.submitContributePage();
		Reusables.verifyPaidTermOptAfterNetworkOff(Contribute.contribute_popup_message);
		Reusables.clickCommand(Contribute.submit_contribute_message_popup);	
	}
	
	@Test(priority=5)
	public void test_network_turnon_network_connection_test(){
		Reusables.getNetConnectionStatus(air_plane_mode_off, wifi_mode_on, data_mode_of);
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		} else if (ITestResult.SKIP == result.getStatus()) {
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
