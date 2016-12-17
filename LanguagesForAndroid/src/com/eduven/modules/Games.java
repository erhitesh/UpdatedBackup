package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Games {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By gamesBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_game");
	public static By gamesHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By gamesList = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_game_name");
	public static By beginnerBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_level_easy");
	public static By expertBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_level_hard");
	public static By startBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_start");
	public static By questionCountTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_sel_questions");
	public static By pauseBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_pause");
	public static By resumeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_resume");
	public static By skipBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_skip");
	public static By soundBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_sound");
	public static By attemptedQuestionTxt = By.name("AttemptedQuestionText");
	public static By scroreBoardPageHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_Answers");
	public static By wrongAttemptedQuesestionTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_wrong_attempts");
	public static By optionBtn = By.xpath("//android.widget.Button[starts-with(@resource-id, '"+DeviceRelatedInformation.getPackageName()+":id/btn_option')]");
	// using contains ....> "//android.widget.Button[contains(@resource-id, ':id/btn_option')]"
	
	
	/**
	 * This method is used to get Games button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getGamesBtnInstance(){
		
		return Reusables.getElement(gamesBtn);
	}
	
	
	/**
	 * This method is used to navigate to the Games page.
	 */
	public static void navigateToGamesPage(){
		try{
			Reusables.waitThread(5);
			getGamesBtnInstance().click();
			Reusables.verifyElementPresent(Reusables.getElement(gamesHeaderTxt), "Error Message!! CLick operation not perform on Game button.");
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Games Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Games header text.
	 */
	public static void verifyGamesHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(gamesHeaderTxt), "Error Message!! Games Page Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Games Page Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select the games type from the given list.
	 * @param game_type : game name.
	 */
	public static String selectGames(String game_type){
		String selected_games_type = "";
		try{
			Reusables.waitThread(1);
			List<AndroidElement> games_list = Reusables.getElementsList(gamesList);
			for (AndroidElement element : games_list){
				if (element.getText().equalsIgnoreCase(game_type) == true){
					//System.out.println("Selected Games Type."+element.getText());
					selected_games_type = element.getText();
					element.click();
					Reusables.waitThread(2);
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Unable to select game from games list. "+e.getClass().getName());
		}
		
		return selected_games_type;
	}

	
	/**
	 *  This method is used to get game type.
	 * @return : String value as selected game type.
	 */
	public static String getSelectedGamesHeaderValue(){
		String gameValue = "";
		try{
			Reusables.waitForElement(gamesHeaderTxt);
			gameValue = Reusables.getText(gamesHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Games Value not found. "+e.getClass().getName());
		}
		
		return gameValue;
	}
	
	/**
	 * This method is used to verify game header text found or not.
	 * @param expectedGameHeader : String type for verify correct navigation.
	 */
	public static void verifySelectedGameTypeHeaderTxt(String expectedGameHeader){
		try{
			Reusables.waitForElement(gamesHeaderTxt);
			Reusables.verifyEqualMessage(getSelectedGamesHeaderValue(), expectedGameHeader, "Error Message!!Selected Games Type Page not open.");
		}catch(NoSuchElementException e){
			Logs.error("Not navigate to the right page."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Beginner Button on game page.
	 */
	public static void verifyBeginnerBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(beginnerBtn), "Error Message!!Beginner Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Beginer Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Expert Button on game page.
	 */
	public static void verifyExpertBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(expertBtn), "Error Message!!Expert Button not present.");;
		}catch(NoSuchElementException e){
			Logs.error("Expert Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Skip Button on game page.
	 */
	public static void verifySkipBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(skipBtn), "Error Message!!Skip Button not present.");;
		}catch(NoSuchElementException e){
			Logs.error("Skip Button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Sound Button on game page.
	 */
	public static void verifySoundBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(soundBtn), "Error Message!!Sound Button not present.");;
		}catch(NoSuchElementException e){
			Logs.error("Spund Button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Pause Button on game page.
	 */
	public static void verifyPauseBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(pauseBtn), "Error Message!!Pause Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Pause Button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on pause button.
	 */
	public static void clickOnPauseBtn(){
		try{
			verifyPauseBtn();
			Reusables.clickCommand(pauseBtn);
			verifyReusmeBtn();
		}catch(NoSuchElementException e){
			Logs.error("Click perform action not perform on the pause button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Resume Button on game page.
	 */
	public static void verifyReusmeBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(resumeBtn), "Error Message!!Resume Button not present.");;
		}catch(NoSuchElementException e){
			Logs.error("Resume Button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Resume Button.
	 */
	public static void clickOnResumeBtn(){
		try{
			verifyReusmeBtn();
			Reusables.clickCommand(resumeBtn);
			verifyPauseBtn();
		}catch(NoSuchElementException e){
			Logs.error("Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get the question count for the game.
	 * @return : int value as total question. 
	 */
	public static String getQuestionCount(){
		String questionCount = "";
		try{
			questionCount = Reusables.getText(Reusables.getElement(questionCountTxt)).replaceAll("Questions:-","").trim();	
			//System.out.println("Question count.."+questionCount);
		}catch(NoSuchElementException e){
			Logs.error("Question count value not found. "+e.getClass().getName());
		}
		
		return questionCount;
	}
	
	/**
	 * This method is used to start the game.
	 */
	public static void startGame(){
		try{
			Reusables.waitForElement(startBtn);
			Reusables.clickCommand(startBtn);
			Reusables.hideIndustrialization();
		}catch(NoSuchElementException e){
			Logs.error("Start Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the skip button.
	 * @param questionCount : for performing click operation.
	 * @return : int value as question count.
	 */
	public static int clickOnSkipButton(String questionCount){
		int question_count = 0;
		try{
			question_count = Integer.parseInt(questionCount);
			//System.out.println("Question count.."+question_count);
			for (int i = 0; i < question_count; i++){
				Reusables.clickCommand(skipBtn);
				/*Reusables.waitForElement(skipBtn);
				if (Reusables.isElementPresent(skipBtn) == true){
					Reusables.clickUsingElement(Reusables.getElement(skipBtn));
					Reusables.waitThread(1);
				}
				else if (Reusables.isElementPresent(skipBtn) == false){
				}*/
			}
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getElementsList(scroreBoardPageHeaderTxt).get(0), "Error Message!! Scroe Board page not open.");
		}catch(NoSuchElementException e){
			Logs.error("Skip Button not found. "+e.getClass().getName());
		}
		
		return question_count;
	}
	
	/**
	 * This method is used to get attempted question.
	 */
	public static String getAttemptedQuestion(){
		String attempedQuestion = "";
		try{
			attempedQuestion = Reusables.getElement(attemptedQuestionTxt).getText();
			//System.out.println("AttempedQuestion...>"+attempedQuestion);
		}catch(NoSuchElementException e){
			Logs.error("Attemptes Question Count not found. "+e.getClass().getName());
		}
		
		return attempedQuestion;
	}
	
	/**
	 * This method is used to get wrong attempted question.
	 */
	public static String getWrongAttemptedQuestion(){
		String wrongAttempedQuestion = "";
		try{
			wrongAttempedQuestion = Reusables.getElement(attemptedQuestionTxt).getText();
		}catch(NoSuchElementException e){
			Logs.error("Wrong Attemptes Question Count not found. "+e.getClass().getName());
		}
		
		return wrongAttempedQuestion;
	}
	
	
	/**
	 * This method is used to verify attempted question in score page.
	 * @param expectedAttemptedQuestion : 
	 * @param actualQuestion :
	 */
	public static void verifyAttemptedQuestion(String actualQuestion, String expectedAttemptedQuestion){
		try{
			Reusables.verifyEqualMessage(actualQuestion, expectedAttemptedQuestion, "Error Message!! Attempted question are not macth with expected one.");
		}catch(NoSuchElementException e){
			Logs.error("Attempted question are not macth with expected one. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify wrong attempted question in score page.
	 */
	public static void verifyWrongAttemptedQuestion(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(wrongAttemptedQuesestionTxt), "Error Message!! Wrong Attempted question are not found in score page.");
		}catch(NoSuchElementException e){
			Logs.error("Wrong Attempted Question not shown in score page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Start Button on game page.
	 */
	public static void verifyStartBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(startBtn), "Error Message!!Start Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Start Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on Beginner button.
	 */
	public static void clickOnBeginnerBtn(){
		try{
			Reusables.waitForElement(beginnerBtn);
			Reusables.clickCommand(beginnerBtn);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on beginnerBtn button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on expert button.
	 */
	public static void clickOnExpertBtn(){
		try{
			Reusables.waitForElement(expertBtn);
			Reusables.clickCommand(expertBtn);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on expert button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to game list navigation test.
	 */
	public static void verifyGameListNavigationTest(){
		String gameName = "";
		try{
			List<AndroidElement> list = Reusables.getElementsList(gamesList);
			for (int i = 0; i < list.size(); i++){
				gameName = list.get(i).getAttribute("name");
				list.get(i).click();
				if (gameName.startsWith("Image Based Quiz") == true){
					LanguageCategoryPage.handleDownloadImagePopoup();
				}
				Reusables.waitThread(2);
				Games.verifyStartBtn();
				Games.verifyBeginnerBtn();
				Games.verifyExpertBtn();
				Games.clickOnBeginnerBtn();
				Games.startGame();
				Reusables.waitThread(4);
				Reusables.hideIndustrialization();
				Games.verifySkipBtn();
				Games.clickOnPauseBtn();
				Games.clickOnResumeBtn();
				Reusables.stepBack();
			}
		}catch(NoSuchElementException e){
			Logs.error("Not Perform right navigation. "+e.getClass().getName());
		}
	}
}
