package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Contribute {

	
	    /* AndroidDriver Instance */
		AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

		/* Object Identification */
		public static By home_page_evMenu_icon = By.xpath("//*[@content-desc='More options']");
		public static By contribute_btn = By.name("Contributions");
		public static By contribute_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
		public static By contribute_txtbox = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
		public static By contribute_profile_pic_imageview = By.id(DeviceRelatedInformation.getPackageName()+":id/contribute_image");
		public static By contribute_submit_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/contribute");
		public static By enter_message_to_txt_box = By.id(DeviceRelatedInformation.getPackageName()+":id/word");
		public static By contribute_popup_message = By.id("android:id/message");
		public static By submit_contribute_message_popup = By.id("android:id/button1");
		public static By unlock_info_txt = By.name("Unlocked Info!");
		public static By entityPageHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
		
		public static By more_apps_btn = By.name("More Apps");
		public static By moreAppsMessage = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
		
		public static By settings_btn = By.name("Settings");
		public static By setting_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");

		// Information and support
		public static By disclaimer_lbl = By.name("Disclaimer");
		public static By disclaimer_lbl_txt = By.name("Disclaimer");
		public static By terms_and_conditions_lbl = By.name("Terms and Conditions");
		public static By terms_and_conditions_lbl_txt = By.name("Terms and Conditions");
		public static By privacy_lbl = By.name("Privacy Policy");
		public static By privacy_lbl_txt = By.name("Privacy Policy");
		public static By faq_lbl = By.name("FAQ");
		public static By faq_lbl_txt = By.name("FAQ");
		
		// Social
		public static By share_app_lbl = By.name("Share this app");
		public static By share_app_by_facebook_lbl = By.name("Facebook");
		public static By share_app_by_other_socialSite_lbl = By.name("Others");
		
		// Share App
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
		
		
		
		/**
		 * This method is used to return the AndroidElement instance.
		 * @return : Type AndroidElement, EvMenu instance.
		 */
		public static AndroidElement evMenuInstance(){
			AndroidElement evMenu_element = null;
			try{
				evMenu_element = Reusables.getElement(home_page_evMenu_icon);
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>>>>>>> EvMenu Icon not found>>>  "+e.getClass().getName());
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
				Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on EvMenu Icon >> "+e.getClass().getName());
			}
		}

		  
		  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Contribute button >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
			/**
			 * This method is used to click on the contribute button inside contribute page
			 */
			public static void clickOnContributeButton() {
				try {
					Reusables.clickUsingElement(Reusables.getElement(contribute_btn));
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>> Click operation not perform on the Contribute sub button >>.>>"+e.getClass().getName());
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
					Reusables.verifyEqualMessage(Reusables.getText(contribute_page_header_txt), DataConstants.contribute_header_txt, "Error Messaeg!! Contribute header txt not matched with expected ones.");
				}
				catch(NoSuchElementException e){
					Logs.error(">>>>>>>>>>>>>>>>> Contribute Page not loaded..."+e.getClass().getName());
				}
			}
			
			/**
			 * This method is used to verify profile pic adder present or not.
			 */
			public static void verifyPicAddedOnContribute(){
				try{
					Reusables.verifyElementPresent(Reusables.getElement(contribute_profile_pic_imageview), "Error Message!! Profile Pic Added Image view not found");
				}
				catch(NoSuchElementException e){
					Logs.error(">>>>>>>>>>>>>>> Profile Pic Added Image view not found.. "+e.getClass().getName());
				}
			}
			
			/**
			 * This method is used to add title on the contribute page
			 * @param title_txt : String type
			 */
			public static void addTitleMessage(String title_txt_msg) {
				try {
					Reusables.enterMessageInTextBox(contribute_txtbox, title_txt_msg);
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>>>>>>> Enable to add title message >>>>>>"+e.getClass().getName());
				}
			}
			
			
			/**
			 * This method is used to verify status of contribute button.
			 */
			public static void verifyContributeButtonStatus(){
				try{
					Reusables.verifyElementPresent(Reusables.getElement(contribute_submit_btn), "Error Message!! Contribute button not enable.");
				}
				catch(NoSuchElementException e){
					Logs.error(">>>>>>>>>>>>> Contribute button not found.. "+e.getClass().getName());
				}
			}
			
			/**
			 * This method is used to submit the contribute page.
			 */
			public static void submitContributePage(){
				try{
					Reusables.waitForAndroidElement(Reusables.getElement(contribute_submit_btn));
					Reusables.clickUsingElement(Reusables.getElement(contribute_submit_btn));
				}
				catch(NoSuchElementException e){
					Logs.error(">>>>>>>>>>>>>>>>>> Contribute Submit button not visible..."+e.getClass().getName());
				}
			}
			
			
			/**
			 * This method is used to verify contribute Pop up message after add empty title message.
			 */
			public static void verifyContributePopUpMessage(String expected_message){
				try{
					Reusables.verifyEqualMessage(Reusables.getText(contribute_popup_message), expected_message, "Error Message!! Contribute message popup not matched with expected ones.");
				}
				catch(NoSuchElementException e){
					Logs.error(">>>>>>>>>>>>>>>> Contribute Message popup not visible.....>>>"+e.getClass().getName());
				}
			}
			
			
			/**
			 * This method is used to submit the submit the contribute pop up message.
			 */
			public static void submitContributeMessagePopup(){
				try{
					Reusables.clickUsingElement(Reusables.getElement(submit_contribute_message_popup));
				}
				catch(NoSuchElementException e){
					Logs.error(">>>>>>>>>>>>>>>>>>>> Contribute button not visible>>>>>>>"+e.getClass().getName());
				}
			}
			
	   //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> More Apps >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		/**
		 * This method is used to click on the more Apps button
		 */
		public static void clickOnMoreAppsButton() {
			try {
				Reusables.clickCommand(more_apps_btn);

			} catch (NoSuchElementException e) {
				Logs.error("****Click operation not perform on the More Apps Button>>>*"+e.getClass().getName());
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

				Reusables.verifyElementPresent(Reusables.getElement(moreAppsMessage), "Error Message!! More Apps Page not loaded...");

			} catch (NoSuchElementException e) {
				Logs.error("******More Apps Page not visible********"+e.getClass().getName());
			}
		}

	     //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Setting button >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		/**
		 * This method is used to click on the settings button inside EvMenu.
		 */
		public static void clickOnSettingsButton() {
			try {
				Reusables.clickUsingElement(Reusables.getElement(settings_btn));

			} catch (NoSuchElementException e) {
				Logs.error(">>>>>>>>>>>>>>>>> Click operation not perform on settings button..."+e.getClass().getName());
			}
		}

		/**
		 * This method is used to verify setting page loaded or not.
		 */
		public static void verifySettingPageLoaded() {
			try {
				Reusables.verifyElementPresent(Reusables.getElement(entityPageHeaderTxt), "Error Message!!! Setting page not opened.");
			} catch (NoSuchElementException e) {
				Logs.error(">>>>>>> Setting page not loaded >>>>>>>"+e.getClass().getName());
			}
		}

		/**
		 * This method is used to navigate to the settings page
		 */
		public static void navigateToSettingPage() {
			navigateToEvMenuPage();
			clickOnSettingsButton();
		}
		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Information and support >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		    /**
		     * This method is used to click on the disclaimer button.
		     */
			public static void clickOnDisclaimer() {
				try {
					Reusables.clickUsingElement(Reusables.getElement(disclaimer_lbl));
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>> Click operation not perform on disclaimer "+e.getClass().getName());
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
					Reusables.verifyElementPresent(Reusables.getElement(entityPageHeaderTxt),"Error Message! Disclaimer page not loaded");
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>>Error Message! Disclaimer page not loaded>>>>>>>>>>>>>>>>>"+e.getClass().getName());
				}
			}

			
			/**
			 * This method is used to click on the privacy policy button.
			 */
			public static void clickOnPrivacyPolicy() {
				try {
					Reusables.clickCommand(privacy_lbl);
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>> Click operation not perform on the privacy policy button.."+e.getClass().getName());
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
			public static void verifyPrivacyPageLoaded() {
				try {
					Reusables.verifyElementPresent(Reusables.getElement(entityPageHeaderTxt), "Error Message! Privacy page not loaded");
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>> Error Message! Privacy page not loaded >>>>>>>>>>>>>>>>>"+e.getClass().getName());
				}
			}

			/**
			 * This method is used to click on the terms and conditions button.
			 */
			public static void clickOnTermsAndConditions() {
				try {
					Reusables.clickUsingElement(Reusables.getElement(terms_and_conditions_lbl));
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>> Click operation not perform on the terms and conditions button.."+e.getClass().getName());
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
					Reusables.verifyElementPresent(Reusables.getElement(entityPageHeaderTxt), "Error Message! terms and conditions page not loaded");
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>> Error Message! terms and conditions page not loaded "+e.getClass().getName());
				}
			}

			/**
		     * This method is used to click on the FAQ button.
		     */
			public static void clickOnFaq() {
				try {
					Reusables.clickUsingElement(Reusables.getElement(faq_lbl));
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>> Click operation not perform on FAQ "+e.getClass().getName());
				}
			}

			/**
			 * This method is used to navigate to FAQ page.
			 */
			public static void navigateToFaqPage(){
				navigateToSettingPage();
				clickOnFaq();
			}
			
			/**
			 * This method is used to verify Disclaimer page loaded or not
			 */
			public static void verifyFaqPageLoaded() {
				try {
					Reusables.verifyElementPresent(Reusables.getElement(entityPageHeaderTxt),"Error Message! FAQ page not loaded");
				} catch (NoSuchElementException e) {
					Logs.error(">>>>>>>>>>>>>>>>>Error Message! FAQ page not loaded>>>>>>>>>>>>>>>>>"+e.getClass().getName());
				}
			}

			
			
			/**
			 * This method is used to verify Disclaimer related operations.
			 */
			public static void verifyInformationAndSupportForDisclaimer(){
				clickOnDisclaimer();
				verifyDisclaimerPageLoaded();
				Reusables.stepBack();
			}
			
			/**
			 * This method is used to verify Terms and conditions related operations.
			 */
			public static void verifyInformationAndSupportForTermsAndConditions(){
				clickOnTermsAndConditions();
				verifyTermsAndConditionsPageLoaded();
				Reusables.stepBack();
				
			}
			
			/**
			 * This method is used to verify Privacy Policy related operations.
			 */
			public static void verifyInformationAndSupportForPrivacyPolicy(){
				clickOnPrivacyPolicy();
				verifyPrivacyPageLoaded();
				Reusables.stepBack();
			}
			
			/**
			 * This method is used to verify FAQ related operations.
			 */
			public static void verifyInformationAndSupportForFaq(){
				clickOnFaq();
				verifyFaqPageLoaded();
				Reusables.stepBack();
			}

		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> feedback >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		/**
		 * This method is used to click on the share this app.
		 */
		public static void clickOnShareApp() {
			try {
				Reusables.clickUsingElement(Reusables.getElement(share_app_lbl));
			} catch (NoSuchElementException e) {
				Logs.error(">>>>>>>>>>>>>>>>>>> Click operation not perform on the share this app lbl.."+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to select share type.
		 * @param share_medium : Type String
		 */
		public static void selectShareType(String share_medium_type){
			
			try{
				if (share_medium_type.equalsIgnoreCase("facebook")){
					Reusables.clickUsingElement(Reusables.getElement(share_app_by_facebook_lbl));
				}
				
				else if (share_medium_type.equalsIgnoreCase("others")) {
					Reusables.clickUsingElement(Reusables.getElement(share_app_by_other_socialSite_lbl));
				}
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>>>>>>> Share app medium not found..>>>"+e.getClass().getName());
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
				userName.sendKeys(DataConstants.facebook_user_name);
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>>>>>>> username text box not found.. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter user password in password box.
		 */
		public static void enterPassword(){
			try{
				AndroidElement userPass = Reusables.getElement(facebook_password_txt_box);
				userPass.click();
				userPass.sendKeys(DataConstants.facebook_password);
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>>>>>>> user password text box not found.. "+e.getClass().getName());
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
				Logs.error(">>>>>>>>>>>>>>>>>>>>> Facebook submit button not found.. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to check Facebook login status.
		 * @return : Type boolean, return Facebook status.
		 */
		public static boolean facebookLoginStatus(){
			boolean status = false;
			try{
				AndroidElement element = Reusables.getElement(facebook_log_in_btn);
				
				if ( element.isDisplayed()){
					status = true;
				}
			}
			catch(NoSuchElementException e){
				Logs.warn(">>>>>>>>>>>>>>> Facebook user Name and password text box not visible "+e.getClass().getName());
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
				//System.out.println("Facbook status...."+status);
				if (status == true){
					enterUsername();
					enterPassword();
					submitFacebook();
				}
				
				else if (status == false) {
					//System.out.println("Else Part block");
					verifyFacebookPostButton();
				}
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>> Enable to login facebook, Share to Facebook text not showing "+e.getClass().getName());
			}
		}

		
		/**
		 * This method is used to verify facebook post message.
		 */
		public static void verifyFacebookPostButton(){
			try{
				Reusables.waitThread(5);
				Reusables.verifyElementPresent(Reusables.getElement(facebook_post_btn), "Error Message!!!Facebool text not visible******");
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>>>> Facebook post not visible "+e.getClass().getName());
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
				Logs.error(">>>>>>>>>>>>> Error Message!Audience type Not visible "+e.getClass().getName());
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
				Logs.error(">>>>>>>>>>>>>>>>>>>>> Error Message!! Selected audience type not matched.."+e.getClass().getName());
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
				Logs.error("Error Message! Audience type not found>>>>>>>>>>>>>"+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to share message on facebook.
		 */
		public static void facebookShareMessage(){
			try{
				AndroidElement element = Reusables.getElement(facebook_msg_txt_box);
				element.click();
				element.sendKeys(DataConstants.facebook_post_message);
				Reusables.waitThread(2);
				Reusables.stepBack();
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>> Facebook text not visible "+e.getClass().getName());
			}
		}


}
