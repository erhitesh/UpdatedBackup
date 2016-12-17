package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.eduven.modules.Games;
import com.eduven.modules.Interstetial;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class CheckInterstetialBeforePurchase {
	
	
	/* Global Declaration */
	String languageName = "";
	boolean interstetialStatusBeforePayment = true;
	String gameType = "Army Of Categories";

	
	@Test(priority=1)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=5)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}

	@Test(priority=10)
	public void verifyInterstetialForQuizTest(){
		Interstetial.interstetialForPayQuiz(gameType);
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
		Reusables.stepBack();
		Games.submitGamePage();
	}
	
	@Test(priority=15)
	public void verifyInterstetialForInAppTest(){
		Interstetial.interstetialForInApp();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@AfterTest
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
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
