package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.ArtAficionados;
import com.eduven.modules.Contribute;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class NetworkRelatedPageTestCases {

	/* Global Variable Declaration */
	String mainCategoryName = DataConstants.art_aficionados_header_text;
	String subCategoryName = "";
	String termName = "";
	
	
	@Test(priority=0)
	public void handle_splash_screen_test(){
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
		}
	
	@Test(priority=1)
	public void navigate_to_sub_category_page_test(){
		ArtAficionados.clickOnArtAficionados();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
	}
	
	@Test(priority=2)
	public void test_network_turnoff_network_connection_test(){
		Reusables.networkConnectionTest();
		}
	
	@Test(priority=3)
	public void check_paid_term_after_network_off_for_airplane_mode_test(){
		Reusables.clickUsingString(DatabaseConnection.getLockTerms(mainCategoryName, subCategoryName));
		Reusables.verifyPaidTermOptAfterNetworkOff(DataConstants.paid_term_alert_message_for_network_connection_off);
	}
	
	@Test(priority=4)
	public void check_evMenu_for_network_connection_test(){
		HomePage.navigateToHomePage();
		Contribute.navigateToMoreApps();
		Reusables.verifyPaidTermOptAfterNetworkOff(DataConstants.paid_term_alert_message_for_network_connection_off);
		Contribute.navigateToContribute();
		Reusables.verifyPaidTermOptAfterNetworkOff(DataConstants.paid_term_alert_message_for_network_connection_off);
		Contribute.navigateToSetting();
		Contribute.clickOnShareApp();
		Reusables.verifyPaidTermOptAfterNetworkOff(DataConstants.paid_term_alert_message_for_network_connection_off);
	}
	
	@Test(priority=5)
	public void test_network_turnon_network_connection_test(){
		Reusables.networkConnectionTest();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		} else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		}
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}
}
