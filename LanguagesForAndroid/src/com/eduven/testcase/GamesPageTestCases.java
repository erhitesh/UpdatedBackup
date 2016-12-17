package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Games;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class GamesPageTestCases {
	

	/* Global Declaration */
	String languageName = "";
	String questionCount = "";
	String game_type = "Army Of Categories";
	int attemped_question_count = 0;
	String expectedGameHeader = "";
	
	
	@Test(priority=5)
	public void installAppAndLanguageSelectionTest(){
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=10)
	public void navigateToGaemPageTest(){
		Games.navigateToGamesPage();
	}
	
	@Test(priority=15)
	public void verifyGameListNavigationTest(){
		Games.verifyGameListNavigationTest();
	}
	
	@Test(priority=20)
	public void selectGameFromGameListTest(){
		Reusables.stepBack();
		Games.navigateToGamesPage();
		expectedGameHeader = Games.selectGames(game_type);
	}
	
	@Test(priority=30)
	public void verifyElementOnGameHomeScreenTest(){
		Games.verifySelectedGameTypeHeaderTxt(expectedGameHeader);
		Games.verifyBeginnerBtn();
		Games.verifyExpertBtn();
	}
	
	@Test(priority=40)
	public void questionCountTest(){
		//Reusables.hideIndustrialization();
		questionCount = Games.getQuestionCount();
	}
	
	@Test(priority=50)
	public void startGameTest(){
		Games.startGame();
	}
	
	@Test(priority=60)
	public void verifyElementOnMainGamePageScreenTest(){
		Games.verifySkipBtn();
		Games.verifySoundBtn();
		Games.clickOnPauseBtn();
		Games.clickOnResumeBtn();
	}
	
	@Test(priority=70)
	public void selectRandomOptionForQuestionTest(){
		attemped_question_count = Games.clickOnSkipButton(questionCount);
	}
	@Test(priority=80)
	public void verifyAttemptedQuestionOnScoreBoardTest(){
		Games.verifyAttemptedQuestion(questionCount.trim(), String.valueOf(attemped_question_count).trim());
	}
	
	@Test(priority=90)
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
