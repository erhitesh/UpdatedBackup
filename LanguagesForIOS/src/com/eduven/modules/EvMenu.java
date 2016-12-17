package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class EvMenu {
	
	
	/* Object Identification */
	public static By evMenuBtn = By.id("neweduventurelogo");
	public static By evMenuMenuBtns = By.xpath("//UIACollectionCell");
	public static By moreAppsBtn = By.id("MoreApps");
	public static By appList = By.xpath("//UIACollectionCell");
	public static By detailsBtn = By.id("Details");
	public static By reviewBtn = By.id("Reviews");
	public static By relatedBtn = By.id("Related");
	public static By closeBtn = By.id("close button");
	public static By contributeHeaderTxt = By.id("ContributeHeader");
	public static By contributeSelectCategoryTxtBox = By.id("FieldCategoryText");
	public static By contributeSelectCategoryTypeTxt = By.xpath("//UIATableCell");
	public static By contributeWordForEditTermTxt = By.id("FieldNewWordText");
	public static By contributeWordTxt = By.id("FieldEnglishWordText");
	public static By contributeSubmitBtn = By.id("SubmitBtn");
	public static By contributeResetBtn = By.id("ResetBtn");
	public static By startRecordingBtn = By.id("icon record");
	public static By playRecordingBtn = By.id("icon play");
	public static By pausePlayRecordingBtn = By.id("Play");
	public static By stopRecordingBtn = By.id("icon stop");
	public static By doneBtn = By.id("Done");
	public static By settingHeaderTxt = By.id("AppSettingHeader");
	public static By settingLabelTxtCount = By.xpath("//UIATableCell");
	public static By settingLabelTxt = By.id("SettingListText");
	public static By getInTouchBtnList  = By.xpath("//UIAButton[starts-with(@name,'share')]");
	public static By facebookLinkBtn = By.xpath("//UIALink[@name='facebook'][1]");
	public static By twitterBtn = By.xpath("//*[@name='Join'][1]");
	public static By tumblrBtn = By.xpath("//UIALink[@name='Tumblr'][1]");
	public static By instaGramBtn = By.xpath("//UIAStaticText[@name='Instagram'][1]");
	public static By categorySettingHeaderTxt = By.id("SelectCategoryHeader");
	public static By categoryListTxt = By.xpath("//UIATableCell/UIAStaticText");
	public static By saveBtn = By.id("Save");
	public static By markChk = By.id("check box red");
	public static By unmarkChk = By.id("check box");
	public static By wordOFTheDayTxt = By.id("WODCategoryTitleHeader");
	public static By disclaimerHeaderTxt = By.xpath("//UIAStaticText[@name='Disclaimer']");
	public static By faqsHeaderTxt = By.xpath("//UIAStaticText[starts-with(@name,'FAQ')]");
	public static By privacyPolicyHeaderTxt = By.xpath("//*[contains(@name,'Privacy Policy')]");
	public static By termsAndConditionsHeaderTxt = By.xpath("//*[contains(@name,'Terms and Conditions')]");
	public static By facebook_username_txt_box = By.xpath("//UIATextField");
	public static By facebook_password_txt_box = By.xpath("//UIASecureTextField");
	public static By facebook_log_in_btn = By.xpath("//UIAButton[@name='Log In']");
	public static By facebook_msg_txt_box = By.xpath("//UIATextField");
	public static By facebook_post_btn = By.xpath("//UIAButton[@name='Post']");
	public static By facebook_audience_btn = By.xpath("//UIAButton[@name='Select who to share the post with']");
    public static By facebook_audience_public_btn = By.xpath("//UIAStaticText[@name='Friends']");
	public static By facebook_audience_friends_btn = By.xpath("//UIAStaticText[@name='Public']");
	public static By facebook_audience_onle_me_btn = By.xpath("//UIAStaticText[@name='Only Me']");
	public static By facebook_audience_custom_btn = By.xpath("//UIAStaticText[@name='Custom']");
	
	
	/**
	 * This method is used to get the instance of EvMenu button.
	 * @return
	 */
	public static IOSElement evMenuInstance(){
		
		return Reusables.getElement(evMenuBtn);
	}

	/**
	 * This method is used to verify EvMenu Button.
	 */
	public static void verifyEvMenuBtn(){
		try{
			Reusables.verifyElementPresent(evMenuInstance(), "Error Message!! EvMenu Button not found.");
		}catch(NoSuchElementException e){
			Logs.error("EvMenu Button Not Matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the EvMenu page.
	 */
	public static void navigateToEvMenuPage(){
		try{
			Reusables.waitForElement(evMenuBtn);
			Reusables.clickCommand(evMenuBtn);
			Reusables.waitThread(1);
		}catch(NoSuchElementException e){
			Logs.error("EnMenu Page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on EVMenu button.
	 * @param button_type : String
	 */
	public static void selectEvMenuButton(String button_type){
		try{
			List<IOSElement> buttonList = Reusables.getElementsList(evMenuMenuBtns);
			for (int i = 0; i < buttonList.size(); i++){
				if (buttonList.get(i).getAttribute("name").toString().equalsIgnoreCase(button_type)){
					buttonList.get(i).click();
					Reusables.waitThread(1);
					break;
				}
				else{
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Unbale to select"+ button_type+ "."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used click on the setting table cell value.
	 * @param cellValue : String type.
	 */
	public static void clickOnSettingUIATableCell(String cellValue){
		List<IOSElement> list;
		try{
			list = Reusables.getElementsList(settingLabelTxt);
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getText().contains(cellValue)){
					list.get(i).click();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Cell Name not found. "+e.getClass().getName());
		}
	}
	
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Settings Page >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to settings page.
	 */
	public static void navigateToSettingPage(){
		try{
			navigateToEvMenuPage();
			Reusables.waitThread(1);
			selectEvMenuButton("Settings");
			/*Reusables.waitForIosElement(Reusables.getElementsList(evMenuMenuBtns).get(0));
			Reusables.clickUsingElement(Reusables.getElementsList(evMenuMenuBtns).get(0));*/
		}catch(NoSuchElementException e){
			Logs.error("Settings page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Setting page loaded or not.
	 */
	public static void verifySettingPageLoaded(){
		try{
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getElement(doneBtn), "Error Message!!Settings Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("Settings Page not loaded"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the setting page.
	 */
	public static void submitSettingPage(){
		try{
			Reusables.waitForElement(doneBtn);
			Reusables.clickCommand(doneBtn);
		}catch(NoSuchElementException e){
			Logs.endTestCase("Setting page still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the category settings page.
	 */
	public static void navigateToCategorySetting(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnSettingUIATableCell(DataConstants.categorySettingsLabel);
			//Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(0));
			Reusables.verifyElementPresent(Reusables.getElement(categorySettingHeaderTxt), "Error Message!! Category Settings page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Category Setting page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select random category from category list.
	 * @return : return as String for verification.
	 */
	public static String selectCategory(){
		String selected_category = "";
		try{
			List<IOSElement> categoryList = Reusables.getElementsList(categoryListTxt);
			//System.out.println("Category List Size.."+categoryList.size());
			int randonNumber = Reusables.randomNumber(categoryList.size());
			Reusables.waitForElement(markChk);
			Reusables.verifyElementPresent(Reusables.getElement(markChk), "Error Message!!Red Mark button not visible.");
			Reusables.clickUsingElement(categoryList.get(randonNumber));
			Reusables.waitForElement(unmarkChk);
			Reusables.verifyElementPresent(Reusables.getElement(unmarkChk), "Error Message!!Red Mark button still visible.");
			selected_category = categoryList.get(randonNumber).getText();
			//System.out.println("Selected Category.."+selected_category);
		}catch(NoSuchElementException e){
			Logs.error("Category name not found. "+e.getClass().getName());
		}
		
		return selected_category;
	}
	
	/**
	 * This method is used to mark all category for display in category setting page.
	 */
	public static void markAllCategoryBtn(){
		try{
			if (Reusables.isElementPresent(unmarkChk) == true){
				Reusables.clickCommand(unmarkChk);
				//System.out.println("done");
			}
			else if (Reusables.isElementPresent(unmarkChk) == false){
				
			}
		}catch(NoSuchElementException e){
			Logs.error("Mark all category button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to submit the selected category value.
	 */
	public static void submitSelectCategory(String expectedMessage){
		try{
			Reusables.waitForElement(saveBtn);
			Reusables.clickCommand(saveBtn);
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.getAlertMessage(), expectedMessage, "Error Message!! Actual and expected messgae not macthed.");
			Reusables.acceptAlert();
		}catch(NoSuchElementException e){
			Logs.error(" Actual and expected messgae not macthed."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the Word of the day page.
	 */
	public static void navigateToWordOfTheDay(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(1));
			Reusables.verifyElementPresent(Reusables.getElement(wordOFTheDayTxt), "Error Message!! Word Of The Day page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Word Of The Day page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the get in touch with us page.
	 */
	public static void navigateToGetInTouch(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
			//Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(3));
		}catch(NoSuchElementException e){
			Logs.error("Get In Touch with us button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Facebook.
	 */
	public static void clickOnFbLink(){
		try{
			List<IOSElement> getintouchList = Reusables.getElementsList(getInTouchBtnList);
			getintouchList.get(2).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Fb Page not open. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Twitter.
	 */
	public static void clickOnTwitterLink(){
		try{
			List<IOSElement> getintouchList = Reusables.getElementsList(getInTouchBtnList);
			getintouchList.get(1).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Twitter Page not open. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Instagram link.
	 */
	public static void clickOnInstagramLink(){
		try{
			List<IOSElement> getintouchList = Reusables.getElementsList(getInTouchBtnList);
			getintouchList.get(3).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Instagram Page not open. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Tumblr link.
	 */
	public static void clickOnTumblrLink(){
		try{List<IOSElement> getintouchList = Reusables.getElementsList(getInTouchBtnList);
		getintouchList.get(4).click();
		Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Tumblr Page not open. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Mail Link.
	 */
	public static void clickOnMailLink(){
		try{
			List<IOSElement> getintouchList = Reusables.getElementsList(getInTouchBtnList);
			getintouchList.get(0).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Mail Page not open. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Facebook page loaded or not.
	 */
	public static void verifyFacebookPageLoaded(){
		try{
			Reusables.isElementPresent(facebookLinkBtn);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Facebook Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Twitter page loaded or not.
	 */
	public static void verifyTwitterPageLoaded(){
		try{
			Reusables.waitForElement(twitterBtn);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Twitter Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Instagram page loaded or not.
	 */
	public static void verifyInstagramPageLoaded(){
		try{
			Reusables.waitForElement(instaGramBtn);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Instagram Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Tumblr page loaded or not.
	 */
	public static void verifyTumblrPageLoaded(){
		try{
			Reusables.waitForElement(tumblrBtn);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Tumblr Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	
	/**
	 * This method is used to verify get in touch link workd or not.
	 */
	public static void verifyGetInTouchLinks(){
		clickOnFbLink();
		verifyFacebookPageLoaded();
		Reusables.stepBack();
		clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
		clickOnTwitterLink();
		//verifyTwitterPageLoaded();
		Reusables.stepBack();
		clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
		clickOnInstagramLink();
		verifyInstagramPageLoaded();
		Reusables.stepBack();
		clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
		clickOnTumblrLink();
		verifyTumblrPageLoaded();
		Reusables.stepBack();
	}
	
	/**
	 * This method is used to verify social site button existence.
	 */
	public static void verifySocialSiteBtnExistence(){
		try{
			Reusables.verifyElementCountExistance(getInTouchBtnList, true);
		}catch(NoSuchElementException e){
			Logs.error("Get In Touch related button not found. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Information and support >>>>>>>>>>>>>>>>>>>>>>>
	
	/**
	 * This method is used to navigate to the Disclaimer page.
	 */
	public static void navigateToDisclaimer(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnSettingUIATableCell(DataConstants.disclaimerTxt);
			//Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(6));
		}catch(NoSuchElementException e){
			Logs.error("Disclaimer page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Disclaimer page loaded or not.
	 */
	public static void verifyDisclaimerPageLoaded(){
		try{
			Reusables.waitForElement(disclaimerHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(disclaimerHeaderTxt), "Error Message!!Disclaimer Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("Disclaimer Page not loaded"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the FAQS page.
	 */
	public static void navigateToFAQS(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnSettingUIATableCell(DataConstants.faqsTxt);
			//Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(7));
		}catch(NoSuchElementException e){
			Logs.error("FAQS page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify FAQ's page loaded or not.
	 */
	public static void verifyFaqsPageLoaded(){
		try{
			Reusables.waitForElement(faqsHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(faqsHeaderTxt), "Error Message!!FAQ's Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("FAQ's Page not loaded"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the Terms And Condition page.
	 */
	public static void navigateToTermsAndCondition(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnSettingUIATableCell(DataConstants.termsAndConditionTxt);
			//Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(8));
		}catch(NoSuchElementException e){
			Logs.error("Terms And Condition page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Terms And Condition page loaded or not.
	 */
	public static void verifyTermsAndConditionPageLoaded(){
		try{
			Reusables.waitForElement(termsAndConditionsHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(termsAndConditionsHeaderTxt), "Error Message!!Terms And Condition Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("Terms And Condition Page not loaded"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the Privacy Policy page.
	 */
	public static void navigateToPrivacyPolicy(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnSettingUIATableCell(DataConstants.privacyPolicyTxt);
			//Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(9));
		}catch(NoSuchElementException e){
			Logs.error("Privacy Policy page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Privacy Policy page loaded or not.
	 */
	public static void verifyPrivacyPolicyPageLoaded(){
		try{
			Reusables.waitForElement(privacyPolicyHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(privacyPolicyHeaderTxt), "Error Message!!Privacy Policy Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("Privacy Policy Page not loaded"+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Contribute related task. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to contribute page.
	 */
	public static void navigateToContributePage(){
		try{
			navigateToEvMenuPage();
			selectEvMenuButton("Contribute");
		}catch(NoSuchElementException e){
			Logs.error("Contribute page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Contribute page loaded or not.
	 */
	public static void verifyContributePageLoaded(){
		try{
			Reusables.waitForElement(contributeHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(contributeHeaderTxt), "Error Message!!Contribute Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("Contribute Page not loaded"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the contribute page.
	 */
	public static void submitContributePage(){
		try{
			Reusables.waitForElement(contributeSubmitBtn);
			Reusables.clickCommand(contributeSubmitBtn);
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to reset the contribute entries.
	 */
	public static void resetContributeTxtFieldEntries(){
		try{
			Reusables.waitForElement(contributeResetBtn);
			Reusables.clickCommand(contributeResetBtn);
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page still visible. "+e.getClass().getName());
		}
	}
	
	
	// Recording Related Button
	/**
	 * This method is used to click on the start recording button.
	 */
	public static void clickOnStartRecordingBtn(){
		try{
			Reusables.waitForElement(startRecordingBtn);
			Reusables.clickCommand(startRecordingBtn);
			Reusables.verifyElementEnable(Reusables.getElement(stopRecordingBtn), "Error Message!!Stop Recording button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Click operation not performed on the Start button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the stop recording button.
	 */
	public static void clickOnStopRecordingBtn(){
		try{
			Reusables.waitForElement(stopRecordingBtn);
			Reusables.clickCommand(stopRecordingBtn);
			Reusables.verifyElementEnable(Reusables.getElement(startRecordingBtn), "Error Message!!Start Recording button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Click operation not performed on the stop button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the play recording button.
	 */
	public static void clickOnPlayRecordingBtn(){
		try{
			Reusables.waitForElement(playRecordingBtn);
			Reusables.clickCommand(playRecordingBtn);
			Reusables.verifyElementEnable(Reusables.getElement(pausePlayRecordingBtn), "Error Message!!Pause Recording button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Pasue button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify submission message after click on submit button.
	 * @param expectedMessage : String type for comparison.
	 */
	public static void verifyContribteSubmissionMessage(String expectedMessage){
		try{
			Reusables.waitForAlert();
			Reusables.verifyEqualMessage(Reusables.getAlertMessage(), expectedMessage, "Error Message!!Actual submission message not matched with expected one.");
			Reusables.acceptAlert();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Actual submission message not matched with expected one. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select the random category value from category list.
	 * @return : Return type String selected category value.
	 */
	public static String selectRandomCategoryValue() {
		String randomName = "";
		try{
			Reusables.clickCommand(contributeSelectCategoryTxtBox);
			Reusables.waitThread(2);
			List<IOSElement> categoryList = Reusables.getElementsList(contributeSelectCategoryTypeTxt);
			int randonNumber = Reusables.randomNumber(categoryList.size());
			Reusables.clickUsingElement(categoryList.get(randonNumber));
			randomName = categoryList.get(randonNumber).getAttribute("name").toString().trim();
		}catch(NoSuchElementException e){
			Logs.error("Random category value not selected from category list value. "+e.getClass().getName());
		}
		
		return randomName;
	}
	
	/**
	 * This method is used to enter text in word text box.
	 */
	public static void enterWordValue(/*String wordValue*/){
		List<String> categortList = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue);
		String randomCategoryName = "";
		String randomWord = "";
		try{
			randomCategoryName = categortList.get(Reusables.randomNumber(categortList.size()-1));
			randomWord = DatabaseConnection.getUnLockTerm(randomCategoryName, LanguageCategoryPage.languageSelectionValue);
			Reusables.enterMessageInTextBox(contributeWordTxt, randomWord);
			//Reusables.hideKeyboard("no key");
		}catch(NoSuchElementException e){
			Logs.error("Value not enetred in the word text box. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to enter text in word text box for edit term.
	 */
	public static void enterWordValueForEditTerm(String wordValue){
		try{
			Reusables.enterMessageInTextBox(contributeWordForEditTermTxt, wordValue);
			//Reusables.hideKeyboard("no key");
		}catch(NoSuchElementException e){
			Logs.error("Value not enetred in the word text box. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  More APP Related >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
	
	/**
	 * This method is used to navigate to more apps page.
	 */
	public static void navigateToMoreAppsPage(){
		try{
			navigateToEvMenuPage();
			selectEvMenuButton("More Apps");
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify More Apps page loaded or not.
	 */
	public static void verifyMoreAppsPageLoaded(){
		try{
			Reusables.waitForElement(closeBtn);
			Reusables.verifyElementPresent(Reusables.getElement(closeBtn), "Error Message!!More Apps Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to open the app list page.
	 */
	public static void navigateToAppsList(){
		try{
			Reusables.waitForElement(moreAppsBtn);
			Reusables.clickCommand(moreAppsBtn);
		}catch(NoSuchElementException e){
			Logs.error("App List page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the random app name from the app list page.
	 */
	public static void clickOnAppNameFromAppList(){
		try{
			List<IOSElement> applist = Reusables.getElementsList(appList);
			applist.get(Reusables.randomNumber(applist.size()-1)).click();
		}catch(NoSuchElementException e){
			Logs.error("App List page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify element related the rate this app.
	 */
	public static void verifyElementOnAppStorePage(){
		try{
			Reusables.waitForElement(detailsBtn);
			Reusables.verifyElementPresent(Reusables.getElement(detailsBtn), "Error Messsage!Detail button not found.");
			Reusables.verifyElementPresent(Reusables.getElement(reviewBtn), "Error Messsage!Review button not found.");
			Reusables.verifyElementPresent(Reusables.getElement(relatedBtn), "Error Messsage!Related button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Elements not found on the iTune Store Page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to hide the iTune Store page.
	 */
	public static void closeAppStorePage(){
		try{
			Reusables.waitThread(5);
			Reusables.tapOnElementUsingCoordinate(1, 0, 50);
			Reusables.waitThread(5);
			//System.out.println(Reusables.isElementPresent(SplashScreen.hideiTuneStorePage));
			Reusables.tapOnElementUsingLocator(SplashScreen.hideiTuneStorePage);
		}catch(NoSuchElementException e){
			Logs.error("App Store page still visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to close More Apps page.
	 */
	public static void closeMoreAppsPage(){
		try{
			Reusables.waitForElement(closeBtn);
			Reusables.clickCommand(closeBtn);
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page still visible. "+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> App Sharing >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		/**
		 * This method is used to navigate to the social site for app sharing.
		 */
		public static void navigateToAppSharePage(){
			try{
				navigateToSettingPage();
				verifySettingPageLoaded();
				Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(5));
				//Reusables.verifyElementPresent(Reusables.getElement(wordOFTheDayTxt), "Error Message!! Word Of The Day page not found.");
			}catch(NoSuchElementException e){
				Logs.error("App Sharing page not found. "+e.getClass().getName());
			}
		}

		
		/**
		 * This method is used to verify Login button present or not.
		 */
		public static void verifyLoginButton(){
			try{
				Reusables.waitThread(5);
				Reusables.verifyElementPresent(Reusables.getElement(facebook_log_in_btn), "Error Message! Login Button not visible");
				}
			catch(NoSuchElementException e){
				Logs.error("Login Button not visible. "+e.getClass().getName());
				}
			}
		
		/**
		 * This method is used to enter the user name.
		 */
		public static void enterUsername(){
			try{
				IOSElement userName = Reusables.getElement(facebook_username_txt_box);
				userName.click();
				userName.clear();
				userName.sendKeys(DataConstants.facebookUserName);
				}
			catch(NoSuchElementException e){
				Logs.error("username not entered in the text box. "+e.getClass().getName());
				}
			}
		
		/**
		 * This method is used to enter the user password.
		 */
		public static void enterPassword(){
			try{
				IOSElement userPass = Reusables.getElement(facebook_password_txt_box);
				userPass.click();
				userPass.sendKeys(DataConstants.facebookPassword);
			}
			catch(NoSuchElementException e){
				Logs.error("password not entered in the text box. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to click on FaceBook Submit button.
		 */
		public static void facebookSubmit(){
			try{
				Reusables.clickCommand(facebook_log_in_btn);
				}
			catch(NoSuchElementException e){
				Logs.error("Log In button still visible. "+e.getClass().getName());
				}
			}
		
		
		/**
		 * This method is used to check FaceBook Login Status.
		 * @return : Boolean.
		 */
		public static boolean facebookLoginStatus(){
			boolean status = false;
			try{
				IOSElement element = Reusables.getElement(facebook_log_in_btn);
				if ( element.isDisplayed()){
					status = true;
					}
				else if(element.isDisplayed() == false){
					status = false;
				}
				}
			catch(NoSuchElementException e){
				Logs.warn("Facebook user Name and password text box not visible. ");
				}
			return status;
			}

		
		
		/**
		 * This method is used to Logged in into FaceBook.
		 */
		public static void facebookLogin(){
			try{
				Reusables.waitThread(10);
				boolean status = facebookLoginStatus();
				if (status == true){
					enterUsername();
					enterPassword();
					facebookSubmit();
				}
				}
			catch(NoSuchElementException e){
				Logs.error("Enable to login facebook, Share to Facebook text not showing. "+e.getClass().getName());
				}
			}
		
		
		/**
		 * This method is used to verify FaceBook post message.
		 */
		public static void verifyFacebookPostButton(){
			try{
				Reusables.waitThread(5);
				Reusables.verifyElementPresent(Reusables.getElement(facebook_post_btn), "Error Message! Facebool text not visible******");
				}
			catch(NoSuchElementException e){
				Logs.error("Facebook post not visible. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to click on the post button.
		 */
		public static void postFacebookMessage(){
			try{
				Reusables.clickCommand(facebook_post_btn);
				Reusables.waitThread(3);
				}
			catch(NoSuchElementException e){
				Logs.error("Facebook post is still visible. "+e.getClass().getName());
				}
			}
		
		/**
		 * This method is used to click on the FaceBook option for sharing the app.
		 */
		public static void facebookShareMessage(){
			try{
				IOSElement element = Reusables.getElement(facebook_msg_txt_box);
				//element.setValue(DataConstants.facebook_message);
				element.click();
				element.sendKeys(DataConstants.facebookMessage);
				Reusables.waitThread(2);
				Reusables.hideKeyboard("no key");
				}
			catch(NoSuchElementException e){
				Logs.error("Facebook text not visible. "+e.getClass().getName());
				}
			}
		
		/**
		 * This method is used to click on the Audience button.
		 */
		public static void clickOnAudience(){
			try{
				Reusables.clickCommand(facebook_audience_btn);
				}
			catch(NoSuchElementException e){
				Logs.error("Error Message! Not visible. "+e.getClass().getName());
				}
			}
		
		/**
		 * This method is used to select the audience type.
		 * @param audience_type : String Type 
		 */
		public static void selectAudience(String audience_type){
			try{
				if (audience_type.equals("Public")){
					Reusables.clickCommand(facebook_audience_public_btn);
				}
				else if (audience_type.equals("Friends")){
					Reusables.clickCommand(facebook_audience_friends_btn);
				}
				else if(audience_type.equals("Only Me")){
					Reusables.clickCommand(facebook_audience_onle_me_btn);
				}
			}
			catch(NoSuchElementException e){
				Logs.error("Audience not selected. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify alert message for successfully post facebook message.
		 */
		public static void verifySuccessfullyPostFacebookMessage(){
			try{
				Reusables.verifyEqualMessage(Reusables.getAlertMessage(), DataConstants.successfullyPostFacebookMessage, "Error Message!Alert message not matched.");
				Reusables.acceptAlert();
			}catch(NoSuchElementException e){
				Logs.error("Alert Message not found. "+e.getClass().getName());
			}
		}
		
		
		/* Rate This App */ 
		/**
		 * This method is used to navigate to the rate this app page.
		 */
		public static void navigateToRateThisApp(){
			try{
				navigateToSettingPage();
				Reusables.clickUsingElement(Reusables.getElementsList(settingLabelTxtCount).get(5));
			}catch(NoSuchElementException e){
				Logs.error("Rate This app page not open. "+e.getClass().getName());
			}
		}
}
