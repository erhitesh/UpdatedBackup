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
	int selected_round = 0;
	int question_count = 0;

	@Test(priority=0)
	public void quiz_page_navigate_to_quiz_page_test(){
		Quiz.NavigateToQuizPage();
	}
	
	@Test(priority=10)
	public void quiz_page_verify_quiz_page_heder_text_test(){
		Quiz.verifyQuizPageNavigation();
		Reusables.stepBack();
		Reusables.hideInterstetial();
		Quiz.NavigateToQuizPage();
		Quiz.verifyQuizPageNavigation();
	}
	
	@Test(priority=20)
	public void quiz_page_verifyRapidFireBox_test(){
		Quiz.verifyRapidFireRound();
	}
	
	@Test(priority=30)
	public void quiz_page_select_round_and_answer_test(){
		Quiz.selectRound(Quiz.randomRoundNumber());
		Quiz.verifyRapidFireHeaderTxt();
		question_count = Quiz.selectAnswerFromGivenObjective(Quiz.randomAnswer());
	}
	
	@Test(priority=40)
	public void quiz_page_verifyRedCard_ScoreCard_and_total_question(){
		Quiz.allowSoccerGuide();
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(question_count);
	}
	
	@Test(priority=50)
	public void quiz_page_verifyEdubank_test(){
		Quiz.clickOnEduBankImageView();
		Quiz.verifySavedInEduBankHeaderTxt();
		Quiz.showSavedTermInEduBank();
		Quiz.verifyAddedTermInEduBank();
		Quiz.deleteAddedQuiz();
		Quiz.verifyQuizPageNavigation();
	}
	
	@Test(priority=60)
	public void quiz_page_naviagte_to_categoryPage_test(){
		Quiz.clickOnCategory();
		Quiz.verifyCategoryPageLoad();
	}
	
	@Test(priority=70)
	public void quiz_page_category_page_operation_test(){
		Quiz.DeselectAllCategoryChk();
		Quiz.submitCategoryPage();
	}
	
	@Test(priority=80)
	public void quiz_page_hide_category_page_popup_test(){
		Quiz.hideCategoryPage();
	}
	
	@Test(priority=90)
	public void quiz_page_sudden_death_test_quiz_test(){
		Quiz.clickOnSuddenDeath();
		Quiz.verifyAlertMessageAndSubmit();
		Quiz.verifySuddenDeathHeaderTxt();
		question_count = Quiz.selectAnswerFromGivenObjective(Quiz.randomAnswer());
	}
	
	@Test(priority=100)
	public void quiz_page_verify_sudden_death_quiz_scorecard_test(){
		Quiz.allowSoccerGuide();
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(question_count);
	}
	
	@Test(priority=110)
	public void quiz_page_verify_edubank_imageview_in_sudden_death_test(){
		Quiz.verifyEduBankImageView();
		Reusables.stepBack();
		Quiz.verifyQuizPageNavigation();
	}
	
	@Test(priority=120)
	public void quiz_page_time_track_quiz_test(){
		Quiz.clickOnTimeTrack();
		Quiz.verifyAlertMessageAndSubmit();
		Quiz.verifyTimeTrackHeaderTxt();
		question_count = Quiz.selectAnswerFromGivenObjective(Quiz.randomAnswer());
	}
	
	@Test(priority=130)
	public void quiz_page_verify_time_track_quiz_scorecard_test(){
		Quiz.allowSoccerGuide();
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(question_count);
	}
	
	@Test(priority=140)
	public void quiz_page_verify_edubank_imageview_in_time_track_test(){
		Quiz.verifyEduBankImageView();
		Reusables.stepBack();
		Quiz.verifyQuizPageNavigation();
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
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
