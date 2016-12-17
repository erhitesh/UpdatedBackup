package com.eduven.testcase;


import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.Footer;
import com.eduven.modules.Quiz;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class QuizPageTestCases {

	
	/* Global Variable Declaration */
	int selectedRound = 0;
	int questionCount = 0;
	
	@Test(priority=0)
	public void navigateToQuixPageTest(){
		Categories.navigateToCategoryPage();
		Footer.navigateToQuiz();
		Quiz.verifyQuizPageHeaderTxt();
	}
	
	@Test(priority=10)
	public void verifyQuizPageHeaderTxtTest(){
		Quiz.verifyQuizPageHeaderTxt();
		Reusables.oneStepBack();
		Footer.navigateToQuiz();
		Quiz.verifyQuizPageHeaderTxt();
	}
	
	@Test(priority=20)
	public void verifyCategoryPageHeaderTxtTest(){
		Quiz.clickOnCategory();
		Quiz.verifyCategoryPageLoad();
	}
	
	@Test(priority=3)
	public void verifyDeselectCheckboxTest(){
		Quiz.verifySelectCheckBoxStatus();
		Quiz.deSelectAllCategoryChk();
		Quiz.verifyDeSelectCheckBoxStatus();
	}
	
	@Test(priority=4)
	public void veriffSelectCheckboxTest(){
		Quiz.selectAllCategoryChk();
		Quiz.verifySelectCheckBoxStatus();
	}
	
	@Test(priority=5)
	public void submitQuizTest(){
		Quiz.submitCategoryPage();
		Quiz.verifyQuizPageHeaderTxt();
	}
	
	@Test(priority=6)
	public void verifyRapidFireBoxTest(){
		Quiz.verifyRapidFireRound();
	}
	
	@Test(priority=7)
	public void VerifySelectedRoundAndAnswerTest(){
		Quiz.selectRound(Quiz.randomRoundNumber());
		Quiz.verifyRapidFireHeaderTxt();
		questionCount = Quiz.selectAnswerFromGivenObjective(Quiz.randomAnswer());
	}
	
	@Test(priority=8)
	public void verifyRedCardScoreCardAndTotalQuestion(){
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(questionCount);
	}
	
	@Test(priority=9)
	public void verifyQuizAddedInEdubankTest(){
		Quiz.clickOnEduBankImageView();
		Quiz.verifySavedInEduBankAlertTxt();
		Quiz.acceptAlert();
		Quiz.navigateToEduBank();
		Quiz.verifyAddedEntityInEduBank();
		Quiz.deleteAddedQuiz();
		Reusables.oneStepBack();
		Footer.clickOnQuiz();
	}
	
	@Test(priority=10)
	public void suddenDeathTestQuizTest(){
		Quiz.clickOnSuddenDeath();
		Quiz.verifySuddenDeathHeaderTxt();
		questionCount = Quiz.selectAnswerFromGivenObjective(Quiz.randomAnswer());
	}
	
	@Test(priority=11)
	public void verifySuddenDeathQuizScorecardTest(){
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(questionCount);
	}
	
	@Test(priority=12)
	public void verifyEdubankImageviewForSuddenDeathTest(){
		Quiz.verifyEduBankImageView();
		Reusables.oneStepBack();
		Quiz.verifyQuizPageHeaderTxt();
	}
	
	@Test(priority=13)
	public void timeTrackQuizTest(){
		Quiz.clickOnTimeTrack();
		Quiz.verifyTimeTrackHeaderTxt();
		questionCount = Quiz.selectAnswerFromGivenObjective(Quiz.randomAnswer());
	}
	
	@Test(priority=14)
	public void verifyTimeTrackQuizScorecardTest(){
		Quiz.verifyScoreCardHeaderTxt();
		Quiz.verifyTotalSelectedRound(questionCount);
	}
	
	@Test(priority=15)
	public void verifyEdubankImageviewInTimeTrackTest(){
		Quiz.verifyEduBankImageView();
		Reusables.oneStepBack();
		Quiz.verifyQuizPageHeaderTxt();
	}
	
	 @AfterMethod 
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
