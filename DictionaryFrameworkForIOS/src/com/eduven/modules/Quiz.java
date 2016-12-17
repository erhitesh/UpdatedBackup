package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class Quiz {
	

	/* Object Identification */
	public static By quizPageHeaderTxt = By.id("Quiz_Header");
	public static By categoryBtn = By.name("Categories");
	public static By categoryheadertxtView = By.name("Select Categories:"); 
	public static By categorysubmitbtn = By.name("Done");
	public static By categorytxtView = By.name("");
	public static By categoryselectchkimageView = By.name("tick box");
	public static By categoryunselectchkimageView = By.name("tick box non highlight");
	
	
	public static By timetrackandsuddendeathquizbox = By.name("Who am I?");
	public static By quesstimetracklayout = By.xpath("//UIAButton[3]");
	public static By suddendeathlayout = By.xpath("//UIAButton[4]");
	
	public static By rapidfirebox = By.name("Select Rounds");
	public static By radiobuttonchk = By.name("radio unselected");
	public static By rapidfirepageheadertxt = By.xpath("//UIANavigationBar[1]/UIAStaticText[1]");
	public static By selectanswertxtview = By.name("OptionButton");
	public static By hintbtn = By.name("skip");
	public static By scorecardheadertxt = By.name("Scorecard");
	public static By totolquestiontxtView = By.name("Question Count");
	public static By totolcorrectquestiontxtView = By.name("Total time");
	public static By totolwrongquestiontxtView = By.name("Incorrect count");
	public static By alertmessage = By.id("android:id/message");
	public static By submitalertpopup = By.id("android:id/button1");
	public static By discardalertpopup = By.id("android:id/button2");
	public static By eduBankscoreimageView = By.name("add to staples");
	
	/*public static By showedubankaddedentity = By.id("android:id/button1");*/
	public static By addedentityinedubank = By.xpath("//UIATableCell[5]");
	public static By deleteAddedQuizInEdubank = By.name("Delete");
	public static By editSelected = By.name("edit selected");
	
	
	/**
	 * This method is used to verify right navigation for Quiz.
	 */
	public static void verifyQuizPageHeaderTxt(){
		try{
			Reusables.hideInterstitial();
			Reusables.waitForIOSElement(quizPageHeaderTxt);
			Reusables.verifyEqualMessage(Reusables.getText(quizPageHeaderTxt), DataConstants.quizHeaderTxt, "Error Messagae!! Quiz Page not open");
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
			Reusables.clickCommand(categoryBtn);
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
			Reusables.verifyElementPresent(Reusables.getIOSElement(categoryheadertxtView), "Error Message!! Category Page not loaded..");
		}
		catch(NoSuchElementException e){
			Logs.error(" Category Page header text not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit category page.
	 */
	public static void submitCategoryPage(){
		try{
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(categorysubmitbtn));
		}
		catch(NoSuchElementException e){
			Logs.error(" Category Page not submit. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check the status of Check box.
	 */
	public static void verifySelectCheckBoxStatus(){
		try{
			//System.out.println(Reusables.getIOSElementsList(categoryselectchkimageView).get(0).isDisplayed());
			Reusables.verifyElementEnable(Reusables.getIOSElementsList(categoryselectchkimageView).get(0), "Error Message!! CheckBox Still Enables...");
		}
		catch(NoSuchElementException e){
			Logs.error("CheckBox Not Enables... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to DeSelect all Category check box.
	 */
	public static void deSelectAllCategoryChk(){
		try{
			Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(categoryselectchkimageView).get(0));
			Reusables.waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error(" Checkbox still selected. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Select all Category check box.
	 */
	public static void selectAllCategoryChk(){
		try{
			Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(categoryunselectchkimageView).get(0));
			Reusables.waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error(" CheckBox Still Not Selected. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check the status of Check box.
	 */
	public static void verifyDeSelectCheckBoxStatus(){
		try{
			//System.out.println(Reusables.getIOSElementsList(categoryunselectchkimageView).get(0).isDisplayed());
			Reusables.verifyElementEnable(Reusables.getIOSElementsList(categoryunselectchkimageView).get(0), "Error Message!! CheckBox Still Enables...");
		}
		catch(NoSuchElementException e){
			Logs.error("CheckBox Still Visible... "+e.getClass().getName());
		}
	}

	// Rapid Fire 
	/**
	 * This method id used to verify rapid round.
	 */
	public static void verifyRapidFireRound(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(rapidfirebox), "Error Message!! Rapid Fire box not found...");
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
			roundnumber = Reusables.randomNumber(Reusables.getIOSElementsList(radiobuttonchk).size());
			//System.out.println("Random round Number.."+roundnumber);
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
			Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(radiobuttonchk).get(randomRoundValue));
			if (randomRoundValue == 0){
				roundValue =  5;
			}
			else if (randomRoundValue == 1) {
				roundValue = 10;
			}			
            else if (randomRoundValue == 2) {
            	roundValue = 15;
			}			
            else if (randomRoundValue == 3) {
            	roundValue = 20;
            }			
            else if (randomRoundValue == 4) {
            	roundValue = 25;
            }
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
			Reusables.verifyElementPresent(Reusables.getIOSElement(rapidfirepageheadertxt), "Error Messsage!! Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Header txt not found "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to return random string.
	 */
	public static int randomAnswer(){
		int indexvalue = 0;
		try{
			indexvalue = Reusables.randomNumber(Reusables.getIOSElementsList(selectanswertxtview).size());
			//System.out.println("indexvalue.."+indexvalue);
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
	public static int selectAnswerFromGivenObjective(int indexvalue){
		int totalquestion = 0;
		try{
			while (Reusables.isElementPresent(selectanswertxtview) == true){
				Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(selectanswertxtview).get(indexvalue));
				Reusables.waitThread(1);
				totalquestion++;
			}
			//System.out.println("Total Question Count.."+totalquestion);
		}
		catch(NoSuchElementException r){
			Logs.error("Not selected any answer.. "+r.getClass().getName());
		}
		
		return totalquestion;
	}
	
	/**
	 * This method id used to verify score card header text.
	 */
	public static void verifyScoreCardHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(scorecardheadertxt), "Error Messsage!! Header txt not found..");
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
			Reusables.verifyEqualMessage(Reusables.getText(totolquestiontxtView), Integer.toString(totalquestion), "Error Message!! Select Question Round And Score card Question not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("Score card Header txt not found "+e.getClass().getName());
		}
	}

	//  Sudden Death 
	/**
	 * This method is used to click on the Sudden Death Quiz button.
	 */
	public static void clickOnSuddenDeath(){
		try{
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(suddendeathlayout));
		}
		catch(NoSuchElementException e){
			Logs.error(" click Operation not perform on the Sudden Death button "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify alert message.
	 */
	public static void verifyAlertMessageAndSubmit(){
		try{
			
			if (Reusables.isElementPresent(alertmessage) == true){
				Reusables.verifyElementPresent(Reusables.getIOSElement(alertmessage), "Error Message!! Alert message not found.");
				Reusables.clickUsingIOSElement(Reusables.getIOSElement(submitalertpopup));
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Alert Message not matched "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to verify header text.
	 */
	public static void verifySuddenDeathHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(rapidfirepageheadertxt), "Error Messsage!! Sudden Death Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Sudden Death Header txt not found "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to select answer.
	 * @param answertext : Type String, answer option.
	 */
	public static int selectAnswerTimeTrackAndSuddenDeath(int indexvalue){
		int totalquestion = 0;
		try{
			while (Reusables.isElementPresent(selectanswertxtview) == true){
				Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(selectanswertxtview).get(indexvalue));
				Reusables.waitThread(2);
				totalquestion++;
				//System.out.println(totalquestion);
			}
		}
		catch(NoSuchElementException r){
			Logs.error("Not selected any answer.. "+r.getClass().getName());
		}
		
		return totalquestion;
	}
	
	// Guess Time Track 
	/**
	 * This method is used to click on the Time track Quiz button.
	 */
	public static void clickOnTimeTrack(){
		try{
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(quesstimetracklayout));
		}
		catch(NoSuchElementException e){
			Logs.error(" click Operation not perform on the Time Track button "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method id used to verify header text.
	 */
	public static void verifyTimeTrackHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(rapidfirepageheadertxt), "Error Messsage!!Time Track Header txt not found..");
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
	public static IOSElement edubankInstance(){
		
		return Reusables.getIOSElement(eduBankscoreimageView);
	}
	
	/**
	 * This method is used to verify edubank image view present or not.
	 */
	public static void verifyEduBankImageView(){
		try{
			Reusables.verifyElementPresent(edubankInstance(), "Error Message!! EduBank ImageView not present..");
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
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(eduBankscoreimageView));
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on the edubank imagview.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the eduBank page.
	 */
	public static void navigateToEduBank(){
		Reusables.oneStepBack();
		Reusables.waitThread(2);
		Reusables.oneStepBack();
		Reusables.waitThread(2);
		HomePage.NavigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		Footer.clickOnEduBank();
	}
	
    /**
	 * This method is used to verify saved in EduBank Alert displayed or not.
	 */
	public static void verifySavedInEduBankAlertTxt(){
		try{
			//System.out.println(Reusables.getalertmessage());
			Reusables.verifyEqualMessage(Reusables.getAlertMessage(), DataConstants.savedInEduabnkAlertMsg, "Error Message!! Saved in EduBank! Header txt not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Saved In edubank Alert not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to accept the alert pop up.
	 */
	public static void acceptAlert(){
		try{
			Reusables.acceptAlert();
		}
		catch(NoSuchElementException e){
			Logs.error("Alert accept not performed... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify added entity in EduBank.
	 */
	public static void verifyAddedEntityInEduBank(){
		try{
			Reusables.waitForIOSElement(addedentityinedubank);
			Reusables.verifyElementPresent(Reusables.getIOSElement(addedentityinedubank), "Error Message!! Quiz not added in the edubank..");
		}
		catch(NoSuchElementException e){
			Logs.error("Added Quiz Not found Exception... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to delete added quiz in the EduBank.
	 */
	public static void deleteAddedQuiz(){
		try{
			Reusables.dragAndDrop(editSelected, addedentityinedubank);
			handlingAlertPopup();
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(deleteAddedQuizInEdubank));
			Reusables.acceptAlert();
		}
		catch(NoSuchElementException e){
			Logs.error("Added Quiz Still Present.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to handle the alert pop up.
	 */
	public static void handlingAlertPopup(){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(768, 1024))){
			}
			else{
				if (Reusables.alertInstance() != null){
					Reusables.dismissAlert();
					Reusables.waitThread(2);
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(".. Alert handle not visible.. "+e.getClass().getName());
		}
	}
}
