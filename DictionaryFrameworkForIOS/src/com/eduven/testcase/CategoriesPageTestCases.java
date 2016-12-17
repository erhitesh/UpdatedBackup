package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class CategoriesPageTestCases {

	
	@Test(priority = 0)
	public void navigateToCategoryPageTest() {
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		Reusables.oneStepBack();
		HomePage.verifyHomePageCategoryIcon();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
	}

	@Test(priority = 10)
	public void verifyFooterElementTest() {
		Footer.verifyContribute();
		Footer.verifyInApp();
		Footer.verifyEduBank();
		Footer.verifyQuiz();
	}

	@Test(priority=20)
	public void verifyCategoryNameListTest(){
		Categories.verifyCategoryList();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
	}

	@AfterClass
	public void closeApp() {
		Reusables.terminatesAppInstance();
	}

}