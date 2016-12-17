package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class CategoriesPageTestcases {
	
	@Test(priority=0)
	public void navigate_to_category_page_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void category_verify_category_list_test(){
		Categories.clickOnCategoriesIconButton();
		Categories.verifyCategoryList();
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void close_app(){
		Reusables.terminatesAppInstance();
	}
}
