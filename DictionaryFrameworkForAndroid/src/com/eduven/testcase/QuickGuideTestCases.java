package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.HomePage;
import com.eduven.modules.QuickGuide;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class QuickGuideTestCases {
	
	/* Global Variable Declaration */
	String viewNumber = "";
	
	@Test(priority=10)
	public void verify_home_page_header_text_test(){
		HomePage.verifyAppName();
	}

	@Test(priority=20)
	public void navigate_to_quick_guide_test(){
		QuickGuide.navigateToQuickGuidePage();
		QuickGuide.verifyQuickGuidePageLoaded();
	}
	
	@Test(priority=30)
	public void verifyElementOnQuickGuidePageTest(){
		QuickGuide.verifyPreviousButton();
		QuickGuide.verifyNextButton();
		QuickGuide.verifyPageView();
	}
	
	@Test(priority=40)
	public void verifyForwardNavigationTest(){
		viewNumber = QuickGuide.getViewNumber();
		QuickGuide.forwardNavigation();
		QuickGuide.verifyPageViewNavigation(viewNumber);
	}
	
	@Test(priority=50)
	public void verifyBackwardNavigationTest(){
		viewNumber = QuickGuide.getViewNumber();
		QuickGuide.backwardNavigation();
		QuickGuide.verifyPageViewNavigation(viewNumber);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if (ITestResult.FAILURE == result.getStatus()){
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
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
