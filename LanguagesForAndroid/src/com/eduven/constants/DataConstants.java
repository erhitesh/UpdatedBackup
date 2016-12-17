package com.eduven.constants;

public interface DataConstants {
	
	/* App Name */
	static String appName = "Speak SMART Danish";
	static String languageNameForPhonetics = "Danish".toLowerCase();
	static String languageNameForRendering = "Danish".toLowerCase();
	
	/* FaceBook Related data */ 
	static String fbuserName = "ma2011.test@gmail.com";
	static String fbPassword = "EVtesters16";
	static String fbMessage = appName;
	
	/* Payment Related Data */
	static String alert_message_before_app_purchase = "Sample Title";
	static String already_purchase_app_message = "Already purchased! Do you want it again for free?";//"you've already purchased this. Would you like to get it again for free?";
	static String thank_you_message = "Thanku You Your purchase was successfull.";
	static String congratuation_message = "Payment Successful";
	
	/* For EduBank */
	static String eduBank = "";
	static String alert_message = "Alert No items in EduBank";
	static String alert_message_for_edubank = "Message There is nothing in the EduBank yet.";

	/* Database location */
	static String dbLoc = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/LanguagesForAndroid/pkg_iLP_ldprodlangpkg.db";
	
	/* Search Related Data */
	static String search_wordForUnlock = "Food";
	static String search_wordForLock = "Colors";
	
	/* Buy App Related */
	static String alert_message_for_add_free = "";
	
	/* EvMenu Related Data */
	static String evMenuMoreAppsBtn = "More Apps";
	static String evMenuContributeBtn = "Contribute";
	static String evMenuSettingsBtn = "Settings";
	static String contributeHeaderTxt = "Contribute";
	static String settingsHeaderTxt = "Settings";
	static String contribute_alert_message_for_failed_submission = "Please fill the mandatory fields.";
	static String contribute_alert_message_for_failed_submission_for_term_list_page = "Please fill at least one of the fields.";
	static String contribute_alert_message_for_successfull_submission = "Thanks for this valuable suggestion.";
	static String categorySettingHeaderTxt = "Category Settings";
	//static String wordOfTheDayHeaderTxt = "Word of the day"+" Category Selection";
	static String contribute_word_text = "Gold";
	static String category_settings_alert_message = "Your settings are saved.";//"Your settings have been saved.";
	static String disclaimerHeaderTxt = "Disclaimer";
	static String faqsHeaderTxt = "FAQ's";
	static String term_condition_url_text = "terms.php";
	static String privacy_policy_url_text = "privacy.php";
	static String userName = "Test MA";
	
	/* FeedBack related data */
	static String get_in_touch_fb_txt = "facebook.com";
	static String get_in_touch_twitter_txt = "twitter.com";
	static String get_in_touch_instagram_txt = "instagram.com";
	static String get_in_touch_tumblr_txt = "tumblr.com";
	
	/* Network Related Data */
	static String connectivity_related_message = "Requires internet connectivity. Please try again later.";
	
	/* Wait time */
	static int implicitWaitTime = 20;
}
