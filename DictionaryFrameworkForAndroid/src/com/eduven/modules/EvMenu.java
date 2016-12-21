package com.eduven.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidElement;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;

public class EvMenu {


	/* object identification */
	public static By evmneuImageView = By.xpath("//*[@content-desc='More options']");
	public static By contributeBtn = By.name("Contribute");//By.id(DeviceRelatedInformation.getPackageName()+":id/title"); // 
	public static By contributePageHeaderTxt = By.name("Contribute");
	public static By contributeSubmitBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/contribute");
	public static By enterMessageToTxtBox = By.id(DeviceRelatedInformation.getPackageName()+":id/word");
	public static By contributePopupMessage = By.id("android:id/message");
	public static By continueContinueBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/skip_btn");
	public static By contributeEmailRadioBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/radioBtn");
	public static By allowToAccessContactsBtn = By.id("com.android.packageinstaller:id/permission_allow_button");
	public static By submitAppreciateMessagePopup = By.id("android:id/button1");
	public static By submit_contribute_message_popup = By.id("android:id/button1");
	public static By submission_for_get_unlock_term_btn = By.name("Later");
	public static By unlockInfoTxt = By.name("Unlocked Info!");
	public static By cancelBtn = By.name("Cancel");
	public static By evMenuMenuBtns = By.id("com.ma.ld.dict.engg:id/title");
	public static By moreAppsBtn = By.name("More Apps");
	public static By installBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/installCrosspormotion");
	public static By appNameOnMoreAppPage = By.id(DeviceRelatedInformation.getPackageName()+":id/label_appName");
	public static By appNameOnPlayStore = By.id("com.android.vending:id/title_title");
	public static By installBtnOnPlayStorePage = By.id("com.android.vending:id/buy_button");
	public static By openBtn = By.id("com.android.vending:id/launch_button");
	public static By moreAppsMessage = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
	public static By settings_btn = By.name("Settings");
	public static By setting_page_header_txt = By.name("Settings");
	public static By disclaimerLbl = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_disclaimer");
	public static By disclaimerLblTxt = By.name("Disclaimer");
	public static By termsAndConditionsTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_terms");
	public static By termsAndConditionsUrlTxt = By.id("com.android.chrome:id/url_bar");
	public static By privacyPolicyTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_privacy");
	public static By privacypolicyUrlTxt = By.id("com.android.chrome:id/url_bar");
	public static By privacyPolicyHeaderTxt = By.xpath("//*[@content-desc='Edutainment Ventures PRIVACY POLICY']");
	public static By shareAppLbl = By.name("Share this app");
	public static By shareAppByFacebookLbl = By.name("Facebook");
	public static By share_app_by_other_socialSite_lbl = By.name("Others");
	public static By facebook_username_txt_box = By.id("com.facebook.katana:id/login_username");
	public static By facebook_password_txt_box = By.id("com.facebook.katana:id/login_password");
	public static By facebook_log_in_btn = By.id("com.facebook.katana:id/login_login");
	public static By facebook_msg_txt_box = By.id("com.facebook.katana:id/status_text");
	public static By facebook_post_btn = By.id("com.facebook.katana:id/post_button");
	public static By facebook_audience_btn = By.id("com.facebook.katana:id/selectable_privacy_text");
	public static By facebook_audience_public_btn = By.id("com.facebook.katana:id/item_privacy_icon");
	public static By facebook_audience_friends_btn = By.id("com.facebook.katana:id/item_privacy_icon");
	public static By facebook_audience_onle_me_btn = By.id("com.facebook.katana:id/item_privacy_icon");
	public static By facebook_selected_audience_type = By.id("com.facebook.katana:id/audience_picker_autocomplete_input");

	public static By getInTouchTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_send_us_feedback");
	public static By getInTouchUrl = By.id("com.android.chrome:id/url_bar");
	public static By fb_imageView = By.id(DeviceRelatedInformation.getPackageName()+":id/fbBtn");
	public static By twitter_imageView = By.id(DeviceRelatedInformation.getPackageName()+":id/twiterBtn");
	public static By instagram_imageView = By.id(DeviceRelatedInformation.getPackageName()+":id/instaBtn");
	public static By mail_imageView = By.id(DeviceRelatedInformation.getPackageName()+":id/mailBtn");
	public static By tumblr_imageView = By.id(DeviceRelatedInformation.getPackageName()+":id/tumblrBtn");

	public static By rateThisApp = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_rate_this_app");
	public static By userIdTxt = By.id("com.android.vending:id/my_display_name");


	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, EvMenu instance.
	 */
	public static AndroidElement evMenuInstance(){
		AndroidElement evMenu_element = null;
		try{
			evMenu_element = Reusables.getElement(evmneuImageView);
		}
		catch(NoSuchElementException e){
			Logs.error(" EvMenu Icon not found  "+e.getClass().getName());
		}

		return evMenu_element;
	}


	/**
	 * This method is used to click on the EvMenu Icon .
	 */
	public static void navigateToEvMenuPage(){
		try{
			Reusables.waitForAndroidElement(evMenuInstance());
			Reusables.clickUsingElement(evMenuInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on EvMenu Icon. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on EVMenu button.
	 * @param button_type : String
	 */
	public static void selectEvMenuButton(String button_type){
		try{
			List<AndroidElement> buttonList = Reusables.getElementsList(evMenuMenuBtns);
			for (int i = 0; i < buttonList.size(); i++){
				if (buttonList.get(i).getText().equalsIgnoreCase(button_type)){
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

	// Contribute button 
	/**
	 * This method is used to click on the contribute button inside contribute page
	 */
	public static void clickOnContributeButton() {
		try {
			Reusables.clickUsingElement(Reusables.getElement(contributeBtn));
		} catch (NoSuchElementException e) {
			Logs.error(" Click operation not perform on the Contribute sub button ."+e.getClass().getName());
		}
	}


	/**
	 * This method is used to navigate to the contribute page.
	 */
	public static void navigateToContributePage() {
		navigateToEvMenuPage();
		clickOnContributeButton();
	}


	/**
	 * This method is used to verify contribute page loaded or not.
	 */
	public static void verifyContributePageLoaded(){
		try{
			Reusables.waitThread(1);
			Reusables.verifyEqualMessage(Reusables.getText(contributePageHeaderTxt), DataConstants.contributeHeaderTxt, "Error Messaeg!! Contribute header txt not matched with expected ones.");
		}
		catch(NoSuchElementException e){
			Logs.error(" Contribute Page not loaded..."+e.getClass().getName());
		}
	}


	/**
	 * This method is used to add title on the contribute page
	 * @param title_txt : String type
	 */
	public static void addTitleMessage(String title_txt_msg) {
		try {
			Reusables.enterMessageInTextBox(enterMessageToTxtBox, title_txt_msg);
		} catch (NoSuchElementException e) {
			Logs.error(" Enable to add title message "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to submit the contribute page.
	 */
	public static void submitContributePage(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(contributeSubmitBtn));
			Reusables.clickUsingElement(Reusables.getElement(contributeSubmitBtn));
		}
		catch(NoSuchElementException e){
			Logs.error(" Contribute Submit button not visible..."+e.getClass().getName());
		}
	}


	/**
	 * This method is used to allow to access the user contacts.
	 */
	public static void allowToAccessContacts(){
		try{
			if (Reusables.isElementPresent(allowToAccessContactsBtn) == true){
				Reusables.clickCommand(allowToAccessContactsBtn);
				Reusables.waitThread(2);
			}
			else{

			}
		}catch(NoSuchElementException e){
			Logs.warn("Allow to access user contacts popup not display. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the continue button.
	 */
	@SuppressWarnings("unused")
	public static void contributeContinue(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(continueContinueBtn) == true){
				List<AndroidElement> list = Reusables.getElementsList(contributeEmailRadioBtn);
				for (int i = 0; i < list.size(); i++){
					list.get(i).click();
					break;
				}
				Reusables.clickCommand(continueContinueBtn);
			}
			else if (Reusables.isElementPresent(continueContinueBtn) == false){
			}
		}catch(NoSuchElementException e){
			Logs.error("Continue Button not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify contribute Pop up message after add empty title message.
	 */
	public static void verifyContributePopUpMessage(String expected_message){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(contributePopupMessage), expected_message, "Error Message!! Contribute message popup not matched with expected ones.");
		}
		catch(NoSuchElementException e){
			Logs.error(" Contribute Message popup not visible....."+e.getClass().getName());
		}
	}


	/**
	 * This method is used to submit the contribute pop up message.
	 */
	public static void submitContributeMessagePopup(){
		try{
			Reusables.waitForElement(submit_contribute_message_popup);
			Reusables.clickUsingElement(Reusables.getElement(submit_contribute_message_popup));
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute button not visible "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to submit the appreciate message pop up.
	 */
	public static void appreciateYourEffortMessagePopup(){
		try{
			Reusables.waitForElement(submitAppreciateMessagePopup);
			Reusables.clickUsingElement(Reusables.getElement(submitAppreciateMessagePopup));
		}
		catch(NoSuchElementException e){
			Logs.error("Appreciate your effort popup message not display. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify unlock category header txt.
	 */
	public static void verifyUnlockCategory(){
		try{
			Reusables.waitForElement(unlockInfoTxt);
			Reusables.verifyEqualMessage(Reusables.getText(unlockInfoTxt), DataConstants.categoryUnlockTermHeaderTxt, "Error Message!! Category unlock header not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("Unlock Term detail page not display. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify unlock term count.
	 */
	public static void verifyUnlockTermCount(){
		String unlockTerms = "";
		int status;
		try{
			Reusables.waitForElement(unlockInfoTxt);
			while (Reusables.getElement(TermDetailPage.nextBtn).isEnabled()){
				System.out.println("Next Button status.."+Reusables.getElement(TermDetailPage.nextBtn).isEnabled());
				unlockTerms = TermDetailPage.getTermName();
				status = DatabaseConnection.checkTermStatus(unlockTerms);
				/*Assert.assertTrue(status==0, "Error Message!Already unlock term coming inside lock term.");*/
				if (status==1){
					Logs.error("Error Message!Already unlock term coming inside lock term.");
				}
				Reusables.clickCommand(TermDetailPage.nextBtn);
				}
				/*Reusables.clickCommand(TermDetailPage.nextBtn);
				count++;
				System.out.println("count.."+count);
				unlockTerms = TermDetailPage.getTermName();
				status = DatabaseConnection.checkTermStatus(unlockTerms);
				System.out.println("Status"+status);
				if (status==0){
					if (count==9){
						break;
					}
				}*/
			Reusables.waitForElement(unlockInfoTxt);
		}catch(NoSuchElementException e){
			Logs.error("Unlock Term Count not matched. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify pop up message after fix iteration.
	 */
	public static void verifyAddContributeMessageAfterFixIteration(){
		String contributeTermName = "";
		try{
			for (int i = 0; i <= 5; i++){
				List<String> list = DatabaseConnection.getMainCategories();
				contributeTermName = DatabaseConnection.getUnLockTerm(DatabaseConnection.getMainCategories().get(Reusables.randomNumber(list.size()-1)));
				addTitleMessage(contributeTermName);//(DataConstants.title_txt_message);
				submitContributePage();
				if (i < 5){
					verifyContributePopUpMessage(DataConstants.contributePopupMessageForTxt);
					submitContributeMessagePopup();
					verifyUnlockCategory();
					verifyUnlockTermCount();
					Reusables.stepBack();
					Reusables.hideInterstetial();
					navigateToContributePage();
				}
				else{
					verifyContributePopUpMessage(DataConstants.contributePopupMessageAfterFixIteration);
					appreciateYourEffortMessagePopup();
					Categories.verifyCategoryPageLoaded();
					//HomePage.verifyHomePageHeaderTxt();
				}	
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Message not matched. "+e.getClass().getName());
		}
	}


	// More Apps 
	/**
	 * This method is used to click on the more Apps button
	 */
	public static void clickOnMoreAppsButton() {
		try {
			Reusables.waitForElement(moreAppsBtn);
			Reusables.clickCommand(moreAppsBtn);
		} 
		catch (NoSuchElementException e) {
			Logs.error("More Apps Button not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to navigate to the More Apps page. 
	 */
	public static void navigateToMoreAppsPage(){
		navigateToEvMenuPage();
		clickOnMoreAppsButton();
	}

	/**
	 * This method is used to verify More Apps page loaded or not
	 */
	public static void verifyMoreAppsPageLoaded() {
		try {
			Reusables.waitForElement(moreAppsMessage);
			Reusables.verifyElementPresent(Reusables.getElement(moreAppsMessage), "Error Message!! More Apps Page not loaded...");
		} catch (NoSuchElementException e) {
			Logs.error(" More Apps Page not visible. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to get app name from more apps page.
	 * @return : appName as String.
	 */
	public static String getAppNameOnMoreAppsPage(){
		String appName = "";
		try{
			Reusables.waitForElement(appNameOnMoreAppPage);
			appName = Reusables.getText(appNameOnMoreAppPage);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get app name from more apps page. "+e.getClass().getName());
		}

		return appName;
	}


	/**
	 * This method is used to click on the insall button on more apps page.
	 */
	public static void clickOnInstallButton() {
		try {
			Reusables.waitForElement(installBtn);
			Reusables.clickCommand(installBtn);
		}
		catch (NoSuchElementException e) {
			Logs.error("Apps not found on more apps page. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to get app name from google play store page.
	 * @return : appName as String.
	 */
	public static String getAppNameFromPlayStorePage(){
		String appName = "";
		try{
			Reusables.waitForElement(appNameOnPlayStore);
			appName = Reusables.getText(appNameOnPlayStore);
		}catch(NoSuchElementException e){
			Logs.error("Unable to app name from google play store page. "+e.getClass().getName());
		}

		return appName;
	}

	/**
	 * This method is used to verify app name from more apps page and play store page.
	 * @param expectedAppName : for verification.
	 */
	public static void verifyAppNameMessageOnPlayStorePage(String expected_AppName){
		try{
			Reusables.waitForElement(appNameOnPlayStore);
			Reusables.verifyEqualMessage(getAppNameFromPlayStorePage(), expected_AppName, "Error Message!!Actual And Expected app not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual And Expected app name not matched."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify play store page open or not.
	 */
	public static void verifyPlayStorePageOpen(){
		try{
			Reusables.waitForElement(appNameOnPlayStore);
			if (Reusables.isElementPresent(installBtnOnPlayStorePage) == true){
				Reusables.verifyElementPresent(Reusables.getElement(installBtnOnPlayStorePage), "Error Message!!Install button found.");
			}
			else if (Reusables.isElementPresent(openBtn) == true){
				Reusables.verifyElementPresent(Reusables.getElement(openBtn), "Error Message!!Open button not found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Play Store page not open. "+e.getClass().getName());
		}
	}

	// Setting button 
	/**
	 * This method is used to click on the settings button inside EvMenu.
	 */
	public static void clickOnSettingsButton() {
		try {
			Reusables.waitForElement(settings_btn);
			Reusables.clickUsingElement(Reusables.getElement(settings_btn));
		} 
		catch (NoSuchElementException e) {
			Logs.error("Settings button not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify setting page loaded or not.
	 */
	public static void verifySettingPageLoaded() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(setting_page_header_txt), "Error Message!!! Setting page not opened.");
		} catch (NoSuchElementException e) {
			Logs.error(" Setting page not loaded "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to navigate to the settings page
	 */
	public static void navigateToSettingPage() {
		navigateToEvMenuPage();
		clickOnSettingsButton();
	}

	// Information and support 

	/**
	 * This method is used to click on the disclaimer button.
	 */
	public static void clickOnDisclaimer() {
		try {
			Reusables.waitForElement(disclaimerLbl);
			Reusables.clickUsingElement(Reusables.getElement(disclaimerLbl));
		} catch (NoSuchElementException e) {
			Logs.error(" Click operation not perform on disclaimer "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to navigate to Disclaimer page.
	 */
	public static void navigateToDisclaimerPage(){
		navigateToSettingPage();
		clickOnDisclaimer();
	}

	/**
	 * This method is used to verify Disclaimer page loaded or not
	 */
	public static void verifyDisclaimerPageLoaded() {
		try {
			Reusables.waitForElement(disclaimerLblTxt);
			Reusables.verifyElementPresent(Reusables.getElement(disclaimerLblTxt),"Error Message!! Disclaimer page not loaded.");
		} catch (NoSuchElementException e) {
			Logs.error("Disclaimer page not loaded. "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to click on the privacy policy button.
	 */
	public static void clickOnPrivacyPolicy() {
		try {
			if (Reusables.isElementPresent(privacyPolicyTxtView) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(privacyPolicyTxtView);
		} catch (NoSuchElementException e) {
			Logs.error("Click operation not perform on the privacy policy button.."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to navigate to Privacy Policy page.
	 */
	public static void navigateToPrivacyPolicyPage(){
		navigateToSettingPage();
		clickOnPrivacyPolicy();
	}

	/**
	 * This method is used to verify privacy policy page loaded or not
	 */
	public static void verifyPrivacyPolicyPageLoaded() {
		try {
			Reusables.verifyElementTextPresent(privacypolicyUrlTxt, DataConstants.privacyPolicyUrlText);
			Reusables.waitThread(2);
		} catch (NoSuchElementException e) {
			Logs.error("Privacy Policy page not loaded. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the terms and conditions button.
	 */
	public static void clickOnTermsAndConditions() {
		try {
			if (Reusables.isElementPresent(termsAndConditionsTxtView) == false){
				Reusables.swipeUp();
			}
			Reusables.clickUsingElement(Reusables.getElement(termsAndConditionsTxtView));
		} catch (NoSuchElementException e) {
			Logs.error(" Click operation not perform on the terms and conditions button.."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to navigate to Terms and Conditions page.
	 */
	public static void navigateToTermsAndConditionsPage(){
		navigateToSettingPage();
		clickOnTermsAndConditions();
	}


	/**
	 * This method is used to verify terms and conditions page loaded or not.
	 */
	public static void verifyTermsAndConditionsPageLoaded() {
		try {
			//Reusables.verifyElementPresent(Reusables.getElement(termsAndConditionsUrlTxt), "Error Message! terms and conditions page not loaded");
			Reusables.verifyElementTextPresent(termsAndConditionsUrlTxt, DataConstants.termAndConditionUrlText);
			Reusables.waitThread(2);
		} catch (NoSuchElementException e) {
			Logs.error("Terms and Conditions page not loaded. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Disclaimer related operations.
	 */
	public static void verifyInformationAndSupportForDisclaimer(){
		verifyDisclaimerPageLoaded();
		Reusables.stepBack();
	}

	/**
	 * This method is used to verify Terms and conditions related operations.
	 */
	public static void verifyInformationAndSupportForTermsAndConditions(){
		verifyTermsAndConditionsPageLoaded();
		Reusables.stepBack();

	}

	/**
	 * This method is used to verify Privacy Policy related operations.
	 */
	public static void verifyInformationAndSupportForPrivacyPolicy(){
		verifyPrivacyPolicyPageLoaded();
		Reusables.stepBack();
	}


	// feedback related 
	/**
	 * This method is used to click on the share this app.
	 */
	public static void clickOnShareApp() {
		try {
			Reusables.waitForElement(shareAppLbl);
			Reusables.clickUsingElement(Reusables.getElement(shareAppLbl));
		} catch (NoSuchElementException e) {
			Logs.error(" Click operation not perform on the share this app lbl.."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to select share type.
	 * @param share_medium : Type String
	 */
	public static void selectShareType(String share_medium_type){

		try{
			if (share_medium_type.equalsIgnoreCase("facebook")){
				Reusables.clickUsingElement(Reusables.getElement(shareAppByFacebookLbl));
			}

			else if (share_medium_type.equalsIgnoreCase("others")) {
				Reusables.clickUsingElement(Reusables.getElement(share_app_by_other_socialSite_lbl));
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" Share app medium not found.."+e.getClass().getName());
		}
	}

	public static void verifyLoginButton(){
		try{
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getElement(facebook_log_in_btn), "Error Message! Login Button not visible");
		}
		catch(NoSuchElementException e){
			Logs.error("****************Login Button not visible***************************");
		}
	}

	/**
	 * This method is used to enter User name in email id text box.
	 */
	public static void enterUsername(){
		try{
			AndroidElement userName = Reusables.getElement(facebook_username_txt_box);
			userName.click();
			userName.clear();
			userName.sendKeys(DataConstants.fbUserName);
		}
		catch(NoSuchElementException e){
			Logs.error(" username text box not found.. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to enter user password in password box.
	 */
	public static void enterPassword(){
		try{
			AndroidElement userPass = Reusables.getElement(facebook_password_txt_box);
			userPass.click();
			userPass.sendKeys(DataConstants.fbPass);
		}
		catch(NoSuchElementException e){
			Logs.error(" user password text box not found.. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to submit the Facebook login.
	 */
	public static void submitFacebook(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(facebook_log_in_btn));
		}
		catch(NoSuchElementException e){
			Logs.error(" Facebook submit button not found.. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to check Facebook login status.
	 * @return : Type boolean, return Facebook status.
	 */
	public static boolean facebookLoginStatus(){
		boolean status = false;
		try{
			if (Reusables.isElementPresent(facebook_log_in_btn) == true){
				status = true;
			}
			else if (Reusables.isElementPresent(facebook_log_in_btn) == false){
				status = false;
			}
		}
		catch(NoSuchElementException e){
			Logs.warn(" Facebook user Name and password text box not visible "+e.getClass().getName());
		}

		return status;
	}

	/**
	 * This method is used to login using facebook credentials.
	 */
	public static void facebookLogin(){
		try{
			Reusables.waitThread(10);
			boolean status = facebookLoginStatus();
			if (status == true){
				enterUsername();
				enterPassword();
				submitFacebook();
			}
			else if (status == false) {
				verifyFacebookPostButton();
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" Enable to login facebook, Share to Facebook text not showing "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to verify facebook post message.
	 */
	public static void verifyFacebookPostButton(){
		try{
			Reusables.waitThread(5);
			Reusables.waitForElement(facebook_post_btn);
			Reusables.verifyElementPresent(Reusables.getElement(facebook_post_btn), "Error Message!!!Facebool text not visible******");
		}
		catch(NoSuchElementException e){
			Logs.error(" Facebook post not visible "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to post message on facebook.
	 */
	public static void postFacebookMessage(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(facebook_post_btn));
			Reusables.waitThread(3);
		}
		catch(NoSuchElementException e){
			Logs.error("**************************Facebook post is still visible******************");
		}

	}

	/**
	 * This method is used to click on the audience lbl.
	 */
	public static void clickOnAudience(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(facebook_audience_btn));
		}
		catch(NoSuchElementException e){
			Logs.error(" Error Message!Audience type Not visible "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify selected audience type.
	 */
	public static void verifySelectedAudienceType(String selected_audience_type, String ErrorMessage){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(facebook_selected_audience_type), selected_audience_type, ErrorMessage);
		}
		catch(NoSuchElementException e){
			Logs.error(" Error Message!! Selected audience type not matched.."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to select audience type.
	 * @param audience_type : Audience type.
	 */
	public static void selectAudience(String audience_type){
		try{
			clickOnAudience();
			if (audience_type.equalsIgnoreCase(("Public"))){
				Reusables.clickUsingElement(Reusables.getElementsList(facebook_audience_public_btn).get(0));
				verifySelectedAudienceType(audience_type, "Error Message!! Selected Audience type not matched..");
				Reusables.stepBack();
			}
			else if (audience_type.equalsIgnoreCase("Friends")){
				Reusables.clickUsingElement(Reusables.getElementsList(facebook_audience_friends_btn).get(1));
				verifySelectedAudienceType(audience_type, "Error Message!! Selected Audience type not matched..");
				Reusables.stepBack();
			}
			else if(audience_type.equalsIgnoreCase("Only Me")){
				Reusables.clickUsingElement(Reusables.getElementsList(facebook_audience_onle_me_btn).get(2));
				verifySelectedAudienceType(audience_type, "Error Message!! Selected Audience type not matched..");
				Reusables.stepBack();
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Error Message! Audience type not found"+e.getClass().getName());
		}
	}

	/**
	 * This method is used to share message on facebook.
	 */
	public static void facebookShareMessage(){
		try{
			AndroidElement element = Reusables.getElement(facebook_msg_txt_box);
			element.click();
			element.sendKeys(DataConstants.fbPostMessage);
			Reusables.waitThread(2);
			Reusables.stepBack();
		}
		catch(NoSuchElementException e){
			Logs.error(" Facebook text not visible "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to navigate to the get in touch with us page.
	 */
	public static void navigateToGetInTouch(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			Reusables.waitForElement(getInTouchTxtView);
			Reusables.clickCommand(getInTouchTxtView);
			Reusables.waitThread(1);
		}
		catch(NoSuchElementException e){
			Logs.error("Get In Touch with us button not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the Facebook.
	 */
	public static void clickOnFbLink(){
		try{
			Reusables.waitForElement(fb_imageView);
			Reusables.clickCommand(fb_imageView);
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
			Reusables.waitForElement(twitter_imageView);
			Reusables.clickCommand(twitter_imageView);
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
			Reusables.waitForElement(instagram_imageView);
			Reusables.clickCommand(instagram_imageView);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Instagram Page not open. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the Tumblr link.
	 */
	public static void clickOnTumblrLink(){
		try{
			Reusables.waitForElement(tumblr_imageView);
			Reusables.clickCommand(tumblr_imageView);
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
			Reusables.waitForElement(mail_imageView);
			Reusables.clickCommand(mail_imageView);
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
			Reusables.waitForElement(getInTouchUrl);
			Reusables.verifyElementTextPresent(getInTouchUrl, DataConstants.getInTouchFbTxt);
			Reusables.stepBack();
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
			Reusables.waitForElement(getInTouchUrl);
			Reusables.verifyElementTextPresent(getInTouchUrl, DataConstants.getInTouchTwitterTxt);
			Reusables.stepBack();
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
			Reusables.waitForElement(getInTouchUrl);
			Reusables.verifyElementTextPresent(getInTouchUrl, DataConstants.getInTouchInstagramTxt);
			Reusables.stepBack();
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
			Reusables.waitForElement(getInTouchUrl);
			Reusables.verifyElementTextPresent(getInTouchUrl, DataConstants.getInTouchTumblrTxt);
			Reusables.stepBack();
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
		clickOnTwitterLink();
		verifyTwitterPageLoaded();
		clickOnInstagramLink();
		verifyInstagramPageLoaded();
		clickOnTumblrLink();
		verifyTumblrPageLoaded();
	}


	/**
	 * This method is used to navigate to the rate this app page.
	 */
	public static void navigateToRateThisApp(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			Reusables.clickCommand(rateThisApp);
			/* Verify open button */
			Reusables.verifyElementPresent(Reusables.getElement(openBtn), "Error Message!! Open button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Rate This app page not open. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify user name no rate this app page.
	 */
	public static void verifyRateThisAppUserName(String expectedUserName){
		String actualUserName = "";
		try{
			Reusables.waitThread(2);
			while (Reusables.isElementPresent(userIdTxt) == false){
				Reusables.swipeUp();
			}
			actualUserName = Reusables.getText(userIdTxt);
			Reusables.verifyEqualMessage(actualUserName, expectedUserName, "Error Message!! Actual and Expected User name not matched.");
		}catch(NoSuchElementException e){
			Logs.error("UserName not found on the rate this app page. "+e.getClass().getName());
		}
	}

}
