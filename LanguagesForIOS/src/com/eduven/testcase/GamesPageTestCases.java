package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Games;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class GamesPageTestCases {
	

	/* Global Variable Declaration */
	String languageName = "";
	String questionCount = "";
	String sliderPercentage = DataConstants.sliderValue;
	
	@Test(priority=0)
	public void handlingRateTheAppPopupTest(){
		SplashScreen.hideAppRatePopup();
	} 
	
	@Test(priority=10)
	public void languageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=20)
	public void verifyNavigationToGamesPageTest(){
		Games.navigateToGamesPage();
	}
	
	@Test(priority=25)
	public void verifyGamesListNavigationTest(){
		//Games.verifyGameListNavigationTest();
	}
	
	@Test(priority=30)
	public void selectGamesFromGameListTest(){
		Games.selectGames();
	}
	
	@Test(priority=36)
	public void verifyQuestionCountTest(){
		Reusables.hideInterstetial();
		Games.performSlider(sliderPercentage);
		questionCount = Games.getQuestionCount();
	}
	
	@Test(priority=40)
	public void startGamesTest(){
		Games.clickOnBeginnerBtn();
		Games.startGame();
	}
	
	@Test(priority=45)
	public void verifyElementOnMainGamePageTest(){
		Games.verifySkipBtn();
		Games.clickOnPauseBtn();
		Games.clickOnResumeBtn();
		Games.clickOnSkipButton(questionCount);
	}
	
	@Test(priority=50)
	public void verifyAttemptedQuestionOnScoreBoardTest(){
		Games.verifyAttemptedQuestion(questionCount);
	}
	
	@Test(priority=60)
	public void verifyWrongAttemptedQuestionOnScoreBoardTest(){
		Games.verifyWrongAttemptedQuestion();
	}
	
	@AfterMethod
	public void tear_down(ITestResult result){
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
