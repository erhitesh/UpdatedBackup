package com.eduven.modules;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class Games {
	
	
	/* Object Identification */
	public static By gamesBtn = By.xpath("//UIAButton[@name='games barButton'][1]");
	public static By gamesHeaderTxt = By.name("GameHeader");
	public static By gamesList = By.xpath("//UIATableCell");
	public static By doneBtn = By.name("Done");
	public static By beginnerBtn = By.name("BeginnerText");
	public static By expertBtn = By.name("ExpertText");
	public static By startBtn = By.name("StartText");
	public static By questionCountTxt = By.name("QuestionCount");
	public static By timerIcon = By.name("time-icon.png");
	public static By wrongAnswerIcon = By.name("wrong-answers.png");
	public static By sroreIcon = By.id("score.png");
	public static By pauseBtn = By.name("pause");
	public static By resumeBtn = By.name("Resume");
	public static By skipBtn = By.name("skip");
	public static By scoreBoardPage = By.name("Answers");
	public static By attemptedQuestionTxt = By.name("AttemptedQuestionText");
	public static By wrongAttemptedQuesestionTxt = By.name("WrongAttemptsText");
	public static By slider = By.id("SliderValue");
	public static By gamesCategory = By.id("GameType");
	public static By gamesSubCategory = By.id("GameSubTypeCell");
	
	
	
	/**
	 * This method is used to get Games button instance.
	 * @return : IOSElement.
	 */
	public static IOSElement getGamesBtnInstance(){
		return Reusables.getElement(gamesBtn);
	}
	
	
	/**
	 * This method is used to navigate to the Games page.
	 */
	public static void navigateToGamesPage(){
		try{
			Reusables.waitThread(5);
			Reusables.tapOnElementUsingLocator(gamesBtn);
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
	
	public static void verifyGamesRelatedElements(){
		Reusables.waitThread(3);
		Reusables.hideInterstetial();
		Games.verifyStartBtn();
		Games.verifyBeginnerBtn();
		Games.verifyExpertBtn();
		Games.clickOnBeginnerBtn();
		Games.startGame();
		Games.verifyWrongAnswerIcon();
//		Games.verifyScoreIcon();
		Games.clickOnPauseBtn();
		Games.clickOnResumeBtn();
		Reusables.stepBack();
		Games.clickOnExpertBtn();
		Games.startGame();
//		Games.verifyTimeIcon();
//		Games.verifyScoreIcon();
		Games.verifyWrongAnswerIcon();
		Games.clickOnPauseBtn();
		Games.clickOnResumeBtn();
		Reusables.stepBack();
		Reusables.stepBack();
	}
	
	/**
	 * This method is used to game list navigation test.
	 */
	public static void verifyGameListNavigationTest(){
		String gameName = "";
		List<IOSElement> gamesCategoryList;
		List<IOSElement> gamesSubCategoryList;
		try{
			if (DeviceRelatedInformation.deviceType().equalsIgnoreCase("ipad")){
				gamesCategoryList = Reusables.getElementsList(gamesCategory);
				for (int i = 0; i < gamesCategoryList.size(); i++){
					gamesCategoryList.get(i).click();
					Reusables.waitThread(2);
					gamesSubCategoryList = Reusables.getElementsList(gamesSubCategory);
					for (int j = 0; j < gamesSubCategoryList.size(); j++){
						gamesSubCategoryList.get(j).click();
						System.out.println("Games Sub Category Name.."+gamesSubCategoryList.get(j).getText());
						if (gamesSubCategoryList.get(j).getText().startsWith("Image Based Quiz")){
							LanguageCategoryPage.handleDownloadImagePopoup();
						}
						verifyGamesRelatedElements();
					}
				}
			}
			else {
				List<IOSElement> list = Reusables.getElementsList(gamesList);
				for (int i = 0; i < list.size(); i++){
					gameName = list.get(i).getText();//getAttribute("name");
					list.get(i).click();
					if (gameName.startsWith("Image Based Quiz") == true){
						LanguageCategoryPage.handleDownloadImagePopoup();
					}
					verifyGamesRelatedElements();
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Not Perform right navigation. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit Games Page.
	 */
	public static void submitGamePage(){
		try{
			Reusables.waitAndClick(doneBtn);
		}catch(NoSuchElementException e){
			Logs.error("Done Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select the games type from the given list.
	 */
	public static void selectGames(){
		try{
			Reusables.waitThread(3);
			if (DeviceRelatedInformation.deviceType().equalsIgnoreCase("ipad")){
				Reusables.getElementsList(gamesSubCategory).get(0).click();
			}
			else{
				List<IOSElement> list = Reusables.getElementsList(gamesList);
				list.get(0).click();
			}
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Unable to select game from games list. "+e.getClass().getName());
		}
				
	}
	
	/**
	 * This method is used to get the question count for the game.
	 * @return : int value as total question. 
	 */
	public static String getQuestionCount(){
		String questionCount = "";
		try{
			questionCount = Reusables.getText(Reusables.getElement(questionCountTxt)).replaceAll("Questions :","").trim();																							
			//System.out.println("Question count..>"+questionCount);
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
			Reusables.waitThread(2);
			Reusables.clickCommand(startBtn);
		}catch(NoSuchElementException e){
			Logs.error("Start Button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the skip button.
	 * @param questionCount : how many times perform click operation.
	 */
	public static void clickOnSkipButton(String questionCount){
		try{
			int question_count = Integer.parseInt(questionCount);
			for (int i = 0; i < question_count; i++){
				Reusables.waitThread(2);
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
			Reusables.verifyElementPresent(Reusables.getElementsList(scoreBoardPage).get(0), "Error Message!! Scroe Board page not open.");
		}catch(NoSuchElementException e){
			Logs.error("Skip Button not found. "+e.getClass().getName());
		}
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
	 */
	public static void verifyAttemptedQuestion(String expectedAttemptedQuestion){
		try{
			Reusables.verifyNotEqualMessage(getAttemptedQuestion(), expectedAttemptedQuestion, "Error Message!! Attempted question are not found in score page.");
		}catch(NoSuchElementException e){
			Logs.error("Attempted Question not shown in score page. "+e.getClass().getName());
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
			Reusables.waitThread(3);
			Reusables.verifyElementPresent(Reusables.getElement(skipBtn), "Error Message!!Skip Button not present.");;
		}catch(NoSuchElementException e){
			Logs.error("Skip Button not found. "+e.getClass().getName());
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
	 * This method is used to verify timer Icon present or not.
	 */
	public static void verifyTimeIcon(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElement(timerIcon), "Error Message!!Timer Icon not found.");
		}catch(NoSuchElementException e){
			Logs.error("Timer Icon not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Wrong answer Icon present or not.
	 */
	public static void verifyWrongAnswerIcon(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElement(wrongAnswerIcon), "Error Message!!Wrong Answer Icon not found.");
		}catch(NoSuchElementException e){
			Logs.error("Wrong Answer Icon not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Score Icon present or not.
	 */
	public static void verifyScoreIcon(){
		try{
			Reusables.waitThread(1);
			Reusables.verifyElementPresent(Reusables.getElement(sroreIcon), "Error Message!!Score Icon not found.");
		}catch(NoSuchElementException e){
			Logs.error("Score Icon not present. "+e.getClass().getName());
		}
	}
	
	
	public static void performSloderTesting(int percentage){
		IOSElement sliderElement = Reusables.getElement(slider);
		int sliderSize = sliderElement.getSize().getWidth();
		System.out.println("Slider Size.."+sliderSize);
		TouchAction action = new TouchAction(Reusables.driver);
		action.moveTo(sliderElement, ((sliderSize*percentage)/100), 0).perform();
		Reusables.waitThread(4);
		System.out.println("perform");
	}
	
	public static void performSlider(String percentage){
		String sliderSize = "";
		IOSElement sliderElement = Reusables.getElement(slider);
		if (percentage.equalsIgnoreCase("fifty")){
			sliderSize = ".5";
		}
		else if (percentage.equalsIgnoreCase("sixty")){
			sliderSize = ".6";
		}
		else if (percentage.equalsIgnoreCase("eighty")){
			sliderSize = ".8";
		}
		else if (percentage.equalsIgnoreCase("twenty")){
			sliderSize = ".2";
		}
		sliderElement.sendKeys(sliderSize); //simply value 50 percentage as .5
	}
}
