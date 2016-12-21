package com.eduven.testcase;


import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Quiz;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class QuizPageTestCases {

	/* Global Variable Declaration */
	int selectedRound = 0;
	int questionCount = 0;

	@Test(priority=0)
	public void navigateToQuizPageTest(){
		Quiz.navigateToQuizPage();
	}

	@Test(priority=10)
	public void verifyQuizPageHederTextTest(){
		Quiz.verifyQuizPageHeaderTxt();
		/*Reusables.stepBack();
		Reusables.hideInterstetial();
		Quiz.navigateToQuizPage();
		Quiz.verifyQuizPageHeaderTxt();*/
	}

	@Test(priority=20)
	public void verifyRapidFireQuizTest(){
		Quiz.verifyRapidFireRound();
	}

	@Test(priority=30)
	public void selectQuestionRoundAndPlayRapidFireTest(){
		selectedRound = Quiz.selectRound(Quiz.randomRoundNumber());
		Quiz.verifyRapidFireHeaderTxt();
		questionCount = Quiz.selectAnswerFromGivenOption(selectedRound);
	}

	@Test(priority=40)
	public void verifyScoreCardForRapidFireAndTotalQuestionTest(){
		Quiz.allowSoccerGuide();
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(questionCount);
	}

	@Test(priority=50)
	public void verifyQuizResultInEdubankTest(){
		Quiz.clickOnEduBankImageView();
		Quiz.verifySavedInEduBankHeaderTxt();
		Quiz.navigateToShowTermOnEduBank();
		Quiz.verifyAddedTermInEduBank();
		Quiz.deleteAddedQuiz();
		Quiz.verifyQuizPageHeaderTxt();
	}

	@Test(priority=60)
	public void navigateToCategoryPageTest(){
		Quiz.clickOnCategory();
		Quiz.verifyCategoryPageLoad();
	}

	@Test(priority=70)
	public void unckeckAllSelectCheckBoxForCategoryTest(){
		Quiz.deselectAllCategoryCheckBox();
		Quiz.submitCategoryPage();
	}

	@Test(priority=80)
	public void hideCategoryPageAlertPopupTest(){
		Quiz.hideCategoryPage();
	}

	@Test(priority=90)
	public void suddenDeathQuizTest(){
		Quiz.clickOnSuddenDeath();
		Reusables.hideInterstetial();
		Quiz.verifyAlertMessageBeforeStartingQuizAndSubmitAlert();
		Quiz.verifySuddenDeathHeaderTxt();
		questionCount = Quiz.selectAnswerFromTimeTrackAndSuddenDeath();
	}

	@Test(priority=100)
	public void verifySuddenDeathQuizScorecardTest(){
		Quiz.allowSoccerGuide();
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(questionCount);
	}

	@Test(priority=110)
	public void verifyFacebookButtonOnSuddenDeathScoreboardPageTest(){
		Quiz.verifyFacebookImageView();
		Reusables.stepBack();
		Quiz.verifyQuizPageHeaderTxt();
	}

	@Test(priority=120)
	public void timeTrackQuizTest(){
		Quiz.clickOnTimeTrack();
		Reusables.hideInterstetial();
		Quiz.verifyAlertMessageBeforeStartingQuizAndSubmitAlert();
		Quiz.verifyTimeTrackHeaderTxt();
		questionCount = Quiz.selectAnswerFromTimeTrackAndSuddenDeath();
	}

	@Test(priority=130)
	public void verifyTimeTrackQuiScorecardTest(){
		Quiz.allowSoccerGuide();
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(questionCount);
	}

	@Test(priority=140)
	public void verifyEdubankButtonOnTimeTrackPageTest(){
		Quiz.verifyFacebookImageView();
		Reusables.stepBack();
		Quiz.verifyQuizPageHeaderTxt();
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
