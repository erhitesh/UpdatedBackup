package com.eduven.modules;

import java.util.List;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class Quiz {


	/* Object Identification */
	public static By quizPageHeaderTxt = By.name("Select Quiz Type");
	public static By categoryBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/choosecategories");
	public static By categoryPageHaderTxtView = By.name("Select All Categories"); 
	public static By categorySubmitBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/quizme");
	public static By categorytxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By categoryCheckBox = By.id(DeviceRelatedInformation.getPackageName()+":id/chkboximg");
	// time track related 
	public static By timetrackandsuddendeathquizbox = By.id(DeviceRelatedInformation.getPackageName()+":id/blurQuiz");
	public static By timeTrackImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/guessCEOtimeattck");
	public static By suddenDeathImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/guessCEOsuddendeath");
	// rapid fire related
	public static By rapidFireChkCount = By.xpath("//android.widget.RadioButton[starts-with(@resource-id,'com.eduven.ld.dict.actors:id/radio')]");//By.id(DeviceRelatedInformation.getPackageName()+":id/rapidfire");
	public static By radioBtnChk = By.className("android.widget.RadioButton");
	public static By rapidFirePageHeaderTxt = By.xpath("//*[@class='android.widget.TextView' and @index='2']");
	public static By soundBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/sound");
	public static By pauseBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/pause");
	public static By timeCountProgressBar = By.id(DeviceRelatedInformation.getPackageName()+":id/circularprogressbar2");
	public static By questionNumberBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/quesNo");
	public static By nextBtn = By.id(DeviceRelatedInformation.getPackageName()+"");
	public static By resumeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/resume");
	// Scoreboard related
	public static By selectAnswerOption = By.xpath("//android.widget.TextView[starts-with(@resource-id,'com.eduven.ld.dict.actors:id/Option_')]");
	public static By scorecardheadertxt = By.name("Scorecard");
	public static By questionCountOnScoreBoard= By.id(DeviceRelatedInformation.getPackageName()+":id/tot_question");
	public static By totolCorrectQuestionTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tot_time");
	public static By totolWrongQuestionTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tot_incorrect");
	public static By alertMessage = By.id("android:id/message");
	public static By submitAlertPopup = By.id("android:id/button1");
	public static By dismissAlertPopup = By.id("android:id/button2");
	public static By fbImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/fb_share");
	public static By eduBankOnScoreCardImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/fav_score");
	public static By addedtextinedubank = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	//public static By addedtextinedubankfortap = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By allowAddPhotoFromPhone = By.id("com.android.packageinstaller:id/permissionallowbutton");
	// edubank for quiz related
	public static By savedInEdubankAlertHeaderTxt = By.name("Saved in EduBank!");
	public static By showeEdubankBtn = By.id("android:id/button1");
	public static By addedQuizInEdubank = By.id(DeviceRelatedInformation.getPackageName()+":id/_label");
	public static By deleteAddedQuizInEdubank = By.id("android:id/title");

	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Quiz instance.
	 */
	public static AndroidElement quizInstance(){
		AndroidElement quizelement = null;
		try{
			quizelement = Reusables.getElement(HomePage.homePageQuizIcon);
		}
		catch(NoSuchElementException e){
			Logs.error("Quiz Icon not found  "+e.getClass().getName());
		}

		return quizelement;
	}

	/**
	 * This method is used to click on the Quiz Icon.
	 */
	public static void navigateToQuizPage(){
		try{
			Reusables.clickUsingElement(quizInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on Quiz Icon "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to verify Quiz page header text.
	 */
	public static void verifyQuizPageHeaderTxt(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(quizPageHeaderTxt), DataConstants.quizHeaderTxt1, "Error Messagae!! Quiz Page not open");
		}
		catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page.. Quiz "+e.getClass().getName());
		}
	}


	// Category Related 
	/**
	 * This method is used to click on the category button.
	 */
	public static void clickOnCategory(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(categoryBtn));
		}
		catch(NoSuchElementException e){
			Logs.error(" click Operation not perform on the Category button "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify category page loaded or not.
	 */
	public static void verifyCategoryPageLoad(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(categoryPageHaderTxtView), "Error Message!! Category Page not loaded..");
		}
		catch(NoSuchElementException e){
			Logs.error("Category Page header text not found. "+e.getClass().getName());
		}
	}

	public static void getPropertyValue(){
		try{
			AndroidElement element = Reusables.getElementsList(categoryCheckBox).get(0);
			System.out.println(element.getCssValue("color"));
			System.out.println(element.getCssValue("font-size"));
		}
		catch(NoSuchElementException e){
			Logs.error("property value.."+e.getClass().getName());
		}
	}


	/**
	 * This method is used to submit category page.
	 */
	public static void submitCategoryPage(){
		try{
			Reusables.waitForElement(categorySubmitBtn);
			Reusables.clickUsingElement(Reusables.getElement(categorySubmitBtn));
		}
		catch(NoSuchElementException e){
			Logs.error(" Category Page not submit. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to DeSelect all Category checkbox.
	 */
	public static void deselectAllCategoryCheckBox(){
		List<AndroidElement> checkBoxList;
		try{
			checkBoxList = Reusables.getElementsList(categoryCheckBox);
			for (AndroidElement ele : checkBoxList){
				ele.click();
				Reusables.waitThread(1);
				break;
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Category checkbox still mark as check. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to Hide Category Page.
	 */
	public static void hideCategoryPage(){
		try{
			Reusables.tapOnElementUsingCoordinates(5, 5, 200);
		}
		catch(NoSuchElementException e){
			Logs.error("Category Page not submit. "+e.getClass().getName());
		}
	}

	// Rapid Fire 
	/**
	 * This method id used to verify rapid round.
	 */
	public static void verifyRapidFireRound(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(rapidFireChkCount), "Error Message!!Rapid Fire box not found...");
		}
		catch(NoSuchElementException e){
			Logs.error("Rapid Fire Round box not displayed.. "+e.getClass().getName());
		}
	}

	/**
	 * This method id used to return random round number.
	 */
	public static int randomRoundNumber(){
		int roundnumber = 0;
		try{
			roundnumber = Reusables.randomNumber(Reusables.getElementsList(rapidFireChkCount).size());
		}
		catch(NoSuchElementException e){
			Logs.error("Not Returning Any random Number "+e.getClass().getName());
		}

		return roundnumber;
	}

	/**
	 * This method id used to select round question type.
	 * @param round : type integer
	 * @return : integer value.
	 */
	public static int selectRound(int randomRoundValue){
		int roundValue = 0;
		try{
			if (randomRoundValue==0){
				roundValue = 5;
			}
			else if (randomRoundValue==1){
				roundValue = 10;
			}
			else if (randomRoundValue==2){
				roundValue = 15;
			}
			else if (randomRoundValue==3){
				roundValue = 20;
			}
			else if (randomRoundValue==4){
				roundValue = 25;
			}
			Reusables.clickUsingElement(Reusables.getElementsList(rapidFireChkCount).get(randomRoundValue));
		}
		catch(NoSuchElementException e){
			Logs.error("Round type not select "+e.getClass().getName());
		}

		return roundValue;
	}

	/**
	 * This method id used to verify header text.
	 */
	public static void verifyRapidFireHeaderTxt(){
		try{
			Reusables.waitForElement(rapidFirePageHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(rapidFirePageHeaderTxt), "Error Messsage!! Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Rapid Fire Games Page Header txt not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method id used to return random string.
	 */
	public static int randomAnswer(){
		int indexvalue = 0;
		try{
			indexvalue = Reusables.randomNumber(Reusables.getElementsList(selectAnswerOption).size());
			//answer = Reusables.randomcategoryentityname(DataConstants.answerlist);
		}
		catch(NoSuchElementException e){
			Logs.error("Not Returning Any Random Answer "+e.getClass().getName());
		}

		return indexvalue;
	}

	/**
	 * This method id used to select answer.
	 * @param answertext : Type String, answer option.
	 */
	public static int selectAnswerFromGivenOption(int roundValue){
		int totalquestion = 0;
		List<AndroidElement> optionList;
		try{
			optionList = Reusables.getElementsList(selectAnswerOption);
			for (int i = 0; i < roundValue; i++){
				optionList.get(Reusables.randomNumber(optionList.size())).click();
				totalquestion++;
				Reusables.waitThread(2);
			}
			//System.out.println("Total Question Count.."+totalquestion);
		}
		catch(NoSuchElementException r){
			Logs.error("Not selected any answer.. "+r.getClass().getName());
		}

		return totalquestion;
	}
	
	/**
	 * This method is used to select answer from available options for time track and sudden death.
	 */
	public static int selectAnswerFromTimeTrackAndSuddenDeath(){
		int questionCount = 0;
		List<AndroidElement> optionList;
		try{
			optionList = Reusables.getElementsList(selectAnswerOption);
			while (Reusables.isElementPresent(selectAnswerOption)){
				optionList.get(Reusables.randomNumber(optionList.size())).click();
				Reusables.waitThread(1);
				questionCount++;
				Reusables.waitThread(1);
			}
			//System.out.println("Total Question Count...>"+questionCount);
		}
		catch(NoSuchElementException r){
			Logs.error("Not Selectiong any option from given options.. "+r.getClass().getName());
		}

		return questionCount;
	}

	/**
	 * This method id used to verify score card header txt.
	 */
	public static void verifyScoreCardHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(scorecardheadertxt), "Error Messsage!! Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Score card Header txt not found "+e.getClass().getName());
		}
	}

	/**
	 * This method id used to verify total question on score card.
	 */
	public static void verifyTotalSelectedRound(int totalquestion){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(questionCountOnScoreBoard), Integer.toString(totalquestion), "Error Message!! Select Question Round And Score card Question not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("Score card Header txt not found "+e.getClass().getName());
		}
	}

	/**
	 * his method id used to deny access media content from mobile device.
	 */
	public static void allowSoccerGuide(){
		try{
			if (Reusables.isElementPresent(allowAddPhotoFromPhone)){
				Reusables.clickCommand(allowAddPhotoFromPhone);
			}
			else if (Reusables.isElementPresent(allowAddPhotoFromPhone) == false){
			}
		}
		catch(NoSuchElementException e){
			Logs.error("popup Message not found "+e.getClass().getName());
		}
	}

	//  Sudden Death 
	/**
	 * This method is used to click on the Sudden Death Quiz button.
	 */
	public static void clickOnSuddenDeath(){
		try{
			Reusables.waitForElement(suddenDeathImageView);
			Reusables.clickUsingElement(Reusables.getElement(suddenDeathImageView));
		}
		catch(NoSuchElementException e){
			Logs.error("click Operation not perform on the Sudden Death button. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify alert message.
	 */
	public static void verifyAlertMessageBeforeStartingQuizAndSubmitAlert(){
		try{
			if (Reusables.isElementPresent(alertMessage)){
				Reusables.verifyElementPresent(Reusables.getElement(alertMessage), "Error Message!!Alert message not found.");
				Reusables.clickCommand(submitAlertPopup);
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Alert Message not matched. "+e.getClass().getName());
		}
	}

	/**
	 * This method id used to verify header text.
	 */
	public static void verifySuddenDeathHeaderTxt(){
		try{
			Reusables.waitForElement(rapidFirePageHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(rapidFirePageHeaderTxt), "Error Messsage!! Sudden Death Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Sudden Death Header txt not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method id used to select answer.
	 * @param answertext : Type String, answer option.
	 */
	public static int selectAnswerTimeTrackAndSuddenDeath(int indexvalue){
		int totalquestion = 0;
		try{
			while (Reusables.isElementPresent(selectAnswerOption) == true){
				Reusables.clickUsingElement(Reusables.getElementsList(selectAnswerOption).get(indexvalue));
				Reusables.waitThread(2);
				totalquestion++;
				System.out.println(totalquestion);
			}
		}
		catch(NoSuchElementException r){
			Logs.error("Not selected any answer. "+r.getClass().getName());
		}

		return totalquestion;
	}

	// Guess Time Track 
	/**
	 * This method is used to click on the Time track Quiz button.
	 */
	public static void clickOnTimeTrack(){
		try{
			Reusables.waitForElement(timeTrackImageView);
			Reusables.clickUsingElement(Reusables.getElement(timeTrackImageView));
		}
		catch(NoSuchElementException e){
			Logs.error("click Operation not perform on the Time Track button. "+e.getClass().getName());
		}
	}


	/**
	 * This method id used to verify header text.
	 */
	public static void verifyTimeTrackHeaderTxt(){
		try{
			Reusables.waitForElement(rapidFirePageHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(rapidFirePageHeaderTxt), "Error Messsage!!Time Track Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Time Track Header txt not found "+e.getClass().getName());
		}
	}

	// Related EduBank 
	/**
	 * This method is used to return the edubank instance.
	 * @return : return type android element.
	 */
	public static AndroidElement edubankInstance(){

		return Reusables.getElement(eduBankOnScoreCardImageView);
	}

	/**
	 * This method is used to verify EduBank image view present or not.
	 */
	public static void verifyFacebookImageView(){
		try{
			Reusables.waitThread(3);
			Reusables.verifyElementPresent(Reusables.getElement(fbImageView), "Error Message!! EduBank ImageView not present..");
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank ImageView Not Present. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the EduBank image view.
	 */
	public static void clickOnEduBankImageView(){
		try{
			Reusables.waitForElement(eduBankOnScoreCardImageView);
			Reusables.clickUsingElement(Reusables.getElement(eduBankOnScoreCardImageView));
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on the edubank imagview.. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify saved in EduBank pop up box displayed or not.
	 */
	public static void verifySavedInEduBankHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(savedInEdubankAlertHeaderTxt), "Error Message!! Saved in EduBank! Header txt not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Saved In edubank popup box not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to show the saved quiz in EduBank.
	 */
	public static void navigateToShowTermOnEduBank(){
		try{
			Reusables.waitForElement(showeEdubankBtn);
			Reusables.clickUsingElement(Reusables.getElement(showeEdubankBtn));
		}
		catch(NoSuchElementException e){
			Logs.error("Saved In edubank alert box still visible. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify added entity in EduBank.
	 */
	public static void verifyAddedTermInEduBank(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(addedQuizInEdubank), "Error Message!! Quiz not added in the edubank..");
		}
		catch(NoSuchElementException e){
			Logs.error("Added Quiz Not found Exception... "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to delete added quiz in the EduBank.
	 */
	public static void deleteAddedQuiz(){
		Dimension deviceSize = Reusables.getAppScreenSize();
		try{
			if (deviceSize.equals(new Dimension(800, 1172))){
				Reusables.clickAndHoldOperation(Reusables.getElement(categorytxtView));
			}
			else {
				Reusables.clickAndHoldOperation(Reusables.getElement(addedQuizInEdubank));
			}
			Reusables.clickUsingElement(Reusables.getElement(deleteAddedQuizInEdubank));
		}
		catch(NoSuchElementException e){
			Logs.error("Added Quiz Still Present.. "+e.getClass().getName());
		}
	}

}
