package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Quiz {
	
	
	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By quiz_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/quiz_box");
	public static By quiz_page_header_txt = By.name("Select Quiz Type");
	public static By category_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/choosecategories");
	public static By category_header_txtView = By.name("Select All Categories"); 
	public static By category_submit_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/quizme");
	public static By category_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By category_chkimageView = By.id(DeviceRelatedInformation.getPackageName()+":id/chkboximg");
	
	
	public static By timetrack_and_sudden_death_quiz_box = By.id(DeviceRelatedInformation.getPackageName()+":id/blurQuiz");
	public static By quess_time_track_layout = By.id(DeviceRelatedInformation.getPackageName()+":id/guessCEOtimeattck");
	public static By sudden_death_layout = By.id(DeviceRelatedInformation.getPackageName()+":id/guessCEOsuddendeath");
	
	public static By rapid_fire_box = By.id(DeviceRelatedInformation.getPackageName()+":id/rapidfire");
	public static By radio_button_chk = By.className("android.widget.RadioButton");
	public static By rapid_fire_page_header_txt = By.xpath("//*[@class='android.widget.TextView' and @index='2']");
	public static By select_answer_txtview = By.xpath("//*[contains(@resource-id, ':id/Option_')]");
	public static By hint_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/hint");
	public static By score_card_header_txt = By.name("Scorecard");
	public static By totol_question_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tot_question");
	public static By totol_correct_question_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tot_time");
	public static By totol_wrong_question_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tot_incorrect");
	public static By alert_message = By.id("android:id/message");
	public static By submit_alert_popup = By.id("android:id/button1");
	public static By discard_alert_popup = By.id("android:id/button2");
	public static By eduBank_score_imageView = By.id(DeviceRelatedInformation.getPackageName()+":id/fav_score");
	public static By added_text_in_edubank = By.id(DeviceRelatedInformation.getPackageName()+":id/_label");
	//public static By added_text_in_edubank_for_tap = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By allow_add_photo_from_phone = By.id("com.android.packageinstaller:id/permission_allow_button");
	
	public static By saved_in_edubank_popup_header_txt = By.name("Saved in EduBank!");
	public static By show_edubank_added_entity = By.id("android:id/button1");
	public static By added_entity_in_edubank = By.xpath("//*[starts-with(@text, 'Quiz :')]");
	public static By deleteAddedQuizInEdubank = By.id("android:id/title");
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Quiz instance.
	 */
	public static AndroidElement quizInstance(){
		AndroidElement quiz_element = null;
		try{
			quiz_element = Reusables.getElement(quiz_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Quiz Icon not found>>>  "+e.getClass().getName());
		}
		
		return quiz_element;
	}
	
	/**
	 * This method is used to click on the Quiz Icon.
	 */
	public static void NavigateToQuizPage(){
		try{
			Reusables.clickUsingElement(quizInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on Quiz Icon "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for Quiz.
	 */
	public static void verifyQuizPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(quiz_page_header_txt), DataConstants.quizHeaderTxt1, "Error Messagae!! Quiz Page not open");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. Quiz "+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Category Related >>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the category button.
	 */
	public static void clickOnCategory(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(category_btn));
		}
		catch(NoSuchElementException e){
			Logs.error(" >>>>>>>>>>>>>>>>>>>>> click Operation not perform on the Category button "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify category page loaded or not.
	 */
	public static void verifyCategoryPageLoad(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(category_header_txtView), "Error Message!! Category Page not loaded..");
		}
		catch(NoSuchElementException e){
			Logs.error(" >>>>>>>>>>>>>>>>>>>>> Category Page header text not found. "+e.getClass().getName());
		}
	}
	
	public static void getPropertyValue(){
		try{
			AndroidElement element = Reusables.getElementsList(category_chkimageView).get(0);
			System.out.println(element.getCssValue("color"));
			System.out.println(element.getCssValue("font-size"));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> property value.."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to submit category page.
	 */
	public static void submitCategoryPage(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(category_submit_btn));
		}
		catch(NoSuchElementException e){
			Logs.error(" >>>>>>>>>>>>>>>> Category Page not submit. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to DeSelect all Category checkbox.
	 */
	public static void DeselectAllCategoryChk(){
		try{
			Reusables.clickUsingElement(Reusables.getElementsList(category_chkimageView).get(0));
		}
		catch(NoSuchElementException e){
			Logs.error(" >>>>>>>>>>>>>>>> Category Page not submit. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Hide Category Page.
	 */
	public static void hideCategoryPage(){
		try{
			Reusables.tapOnElementUsingCoordinates(1, 75, 200);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Category Page not submit. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Rapid Fire >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method id used to verify rapid round.
	 */
	public static void verifyRapidFireRound(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(rapid_fire_box), "Error Message!! Rapid Fire box not found...");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Rapid Fire Round box not displayed.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to return random round number.
	 */
	public static int randomRoundNumber(){
		int round_number = 0;
		try{
			round_number = Reusables.randomNumber(Reusables.getElementsList(radio_button_chk).size());
			//System.out.println("Random round Number.."+round_number);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Not Returning Any random Number "+e.getClass().getName());
		}
		
		return round_number;
	}
	
	/**
	 * This method id used to select round question type.
	 * @param round : type integer
	 * @return : integer value.
	 */
	public static int selectRound(int random_round_value){
		int round_value = random_round_value;
		try{
			Reusables.clickUsingElement(Reusables.getElementsList(radio_button_chk).get(random_round_value));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Round type not select "+e.getClass().getName());
		}
		
		return round_value;
	}
	
	/**
	 * This method id used to verify header text.
	 */
	public static void verifyRapidFireHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(rapid_fire_page_header_txt), "Error Messsage!! Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Header txt not found "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to return random string.
	 */
	public static int randomAnswer(){
		int index_value = 0;
		try{
			index_value = Reusables.randomNumber(Reusables.getElementsList(select_answer_txtview).size());
			//answer = Reusables.random_category_entity_name(DataConstants.answer_list);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Not Returning Any Random Answer "+e.getClass().getName());
		}
		
		return index_value;
	}
	
	/**
	 * This method id used to select answer.
	 * @param answer_text : Type String, answer option.
	 */
	public static int selectAnswerFromGivenObjective(int index_value){
		int total_question = 0;
		try{
			while (Reusables.isElementPresent(select_answer_txtview) == true){
				Reusables.clickUsingElement(Reusables.getElementsList(select_answer_txtview).get(index_value));
				Reusables.waitThread(1);
				total_question++;
			}
			//System.out.println("Total Question Count.."+total_question);
		}
		catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>>>>>> Not selected any answer.. "+r.getClass().getName());
		}
		
		return total_question;
	}
	
	/**
	 * This method id used to verify score card header txt.
	 */
	public static void verifyScoreCardHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(score_card_header_txt), "Error Messsage!! Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Score card Header txt not found "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to verify total question on score card.
	 */
	public static void verifyTotalSelectedRound(int total_question){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(totol_question_txtView), Integer.toString(total_question), "Error Message!! Select Question Round And Score card Question not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Score card Header txt not found "+e.getClass().getName());
		}
	}
	
	/**
	 * his method id used to deny access media content from mobile device.
	 */
	public static void allowSoccerGuide(){
		try{
			if (Reusables.isElementPresent(allow_add_photo_from_phone) == true){
				Reusables.clickCommand(allow_add_photo_from_phone);
			}
			else if (Reusables.isElementPresent(allow_add_photo_from_phone) == false){
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>> popup Message not found "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Sudden Death >>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the Sudden Death Quiz button.
	 */
	public static void clickOnSuddenDeath(){
		try{
			Reusables.waitForElement(sudden_death_layout);
			Reusables.clickUsingElement(Reusables.getElement(sudden_death_layout));
		}
		catch(NoSuchElementException e){
			Logs.error(" >>>>>>>>>>click Operation not perform on the Sudden Death button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify alert message.
	 */
	public static void verifyAlertMessageAndSubmit(){
		try{
			if (Reusables.isElementPresent(alert_message) == true){
				Reusables.verifyElementPresent(Reusables.getElement(alert_message), "Error Message!! Alert message not found.");
				Reusables.clickUsingElement(Reusables.getElement(submit_alert_popup));
				}
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>Alert Message not matched. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method id used to verify header text.
	 */
	public static void verifySuddenDeathHeaderTxt(){
		try{
			Reusables.waitForElement(rapid_fire_page_header_txt);
			Reusables.verifyElementPresent(Reusables.getElement(rapid_fire_page_header_txt), "Error Messsage!! Sudden Death Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Sudden Death Header txt not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to select answer.
	 * @param answer_text : Type String, answer option.
	 */
	public static int selectAnswerTimeTrackAndSuddenDeath(int index_value){
		int total_question = 0;
		try{
			while (Reusables.isElementPresent(select_answer_txtview) == true){
				Reusables.clickUsingElement(Reusables.getElementsList(select_answer_txtview).get(index_value));
				Reusables.waitThread(2);
				total_question++;
				System.out.println(total_question);
			}
		}
		catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>>>>>> Not selected any answer. "+r.getClass().getName());
		}
		
		return total_question;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Guess Time Track >>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the Time track Quiz button.
	 */
	public static void clickOnTimeTrack(){
		try{
			Reusables.waitForElement(quess_time_track_layout);
			Reusables.clickUsingElement(Reusables.getElement(quess_time_track_layout));
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>click Operation not perform on the Time Track button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method id used to verify header text.
	 */
	public static void verifyTimeTrackHeaderTxt(){
		try{
			Reusables.waitForElement(rapid_fire_page_header_txt);
			Reusables.verifyElementPresent(Reusables.getElement(rapid_fire_page_header_txt), "Error Messsage!!Time Track Header txt not found..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Time Track Header txt not found "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Related EduBank >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to return the edubank instance.
	 * @return : return type android element.
	 */
	public static AndroidElement edubankInstance(){
		
		return Reusables.getElement(eduBank_score_imageView);
	}
	
	/**
	 * This method is used to verify EduBank image view present or not.
	 */
	public static void verifyEduBankImageView(){
		try{
			Reusables.waitThread(3);
			Reusables.verifyElementPresent(edubankInstance(), "Error Message!! EduBank ImageView not present..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> EduBank ImageView Not Present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EduBank image view.
	 */
	public static void clickOnEduBankImageView(){
		try{
			Reusables.waitForElement(eduBank_score_imageView);
			Reusables.clickUsingElement(Reusables.getElement(eduBank_score_imageView));
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
			Reusables.verifyElementPresent(Reusables.getElement(saved_in_edubank_popup_header_txt), "Error Message!! Saved in EduBank! Header txt not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Saved In edubank popup box not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to show the saved entity in EduBank.
	 */
	public static void showSavedTermInEduBank(){
		try{
			Reusables.waitForElement(show_edubank_added_entity);
			Reusables.clickUsingElement(Reusables.getElement(show_edubank_added_entity));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Saved In edubank popup box still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify added entity in EduBank.
	 */
	public static void verifyAddedTermInEduBank(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(added_entity_in_edubank), "Error Message!! Quiz not added in the edubank..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> Added Quiz Not found Exception... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to delete added quiz in the EduBank.
	 */
	public static void deleteAddedQuiz(){
		Dimension deviceSize = Reusables.getAppScreenSize();
		try{
			if (deviceSize.equals(new Dimension(800, 1172))){
				Reusables.clickAndHoldOperation(Reusables.getElement(category_txtView));
			}
			else {
				Reusables.clickAndHoldOperation(Reusables.getElement(added_entity_in_edubank));
			}
			Reusables.clickUsingElement(Reusables.getElement(deleteAddedQuizInEdubank));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Added Quiz Still Present.. "+e.getClass().getName());
		}
	}
	
}
