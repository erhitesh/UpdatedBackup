package com.eduven.constants;

public interface DataConstants {
	
	/* App Name */
	static String appName = "Learn Tamil";
	static String languageNameForPhonetics = appName.substring(6).toLowerCase();
	static String languageNameForRendering = appName.substring(6).toLowerCase();
	
	/* Implicit wait time */
	static int implicitWaitTime = 30;
	
	/* FaceBook Related data */ 
	static String facebookUserName = "ma2011.test@gmail.com";
	static String facebookPassword = "EVtesters16";
	static String facebookMessage = appName+"....";
	static String successfullyPostFacebookMessage = "Success Successfully shared on your Facebook wall!";
	
	/* iTunes store credential and data */
	static String userName="ranjeet.singh@mediaagility.in";
	static String userPass="Edutainment123*";
	static String alreadyPurchaseAppMessage1 = "This In-App purchase has already been bought. It will be restored for free.  [Environment: Sandbox]";
	static String alreadyPurchaseAppMessage2 = "You've already purchased this. Would you like to get it again for free? [Environment: Sandbox]";
	static String thankYouMessage = "You are all set Your purchase"; /*was successfull.";*/
	static String congratuationMessage = "Congratulations!";//You *purchase Successful!";
	static String applicationRestoreMessage = "Congratulation! Your complete application has been restored";
	
	/* For EduBank */
	static String eduBank = "";
	static String alert_message = "Alert No items in EduBank";
	static String alert_message_for_edubank = "Message There is nothing in the EduBank yet.";

	/* Database location */
	static String dbLoc = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/LanguagesForIOS/pkg_iLP_ldprodlangpkg.db";
	
	/* Search Related Data */
	static String search_word = "Food";
	
	
	/* Games Related Data */
	static String sliderValue = "fifty";
	/* Buy App Related */
	static String alert_message_for_add_free = "";
	
	/* EvMenu Related Data */
	static String contribute_alert_message_for_failed_submission_for_termpage = "Message Please fill at least one of the fields.";
	static String contribute_alert_message_for_failed_submission = "Message Please fill the mandatory fields.";
	static String contribute_alert_message_for_successfull_submission = "Message Thanks for this valuable suggestion.";
	static String contribute_word_text = "Gold";
	static String category_settings_alert_message = "Message Your settings are saved.";
	static String categorySettingsLabel = "Category Settings";
	static String getInTouchTxt = "Get in touch with us";
	static String shareThisAppTxt = "Share this app";
	static String rateThisAppTxt = "Rate this app!";
	static String faqsTxt = "FAQ's";
	static String disclaimerTxt = "Disclaimer";
	static String privacyPolicyTxt = "Privacy Policy";
	static String termsAndConditionTxt = "Terms and Conditions";
}
