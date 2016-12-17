package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class EvMenu {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By evMenuBtn = By.xpath("//*[@content-desc='More options']");
	public static By evMenuMenuBtns = By.id(DeviceRelatedInformation.getPackageName()+":id/title");
	public static By moreAppsPage = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
	public static By appsList = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	public static By googlePlayStoreLayout = By.id("com.android.vending:id/controls_container");
	public static By contributeHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_title");
	public static By contribute_select_category_type = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_category");
	public static By contribute_select_category_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_title");
	public static By contribute_selected_category = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By contribute_wordTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_word");
	public static By enterPhoneticsTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_phonetic");
	public static By continueContinueBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/skip_btn");
	public static By contributeEmailRadioBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/radioBtn");
	public static By submitContributeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_contribute");
	public static By editContributeSubmitBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_submit");
	public static By contributeResetBtn =  By.id(DeviceRelatedInformation.getPackageName()+":id/btn_reset");
	public static By alert_popup = By.id("android:id/button1");
	public static By alert_popup_message = By.id("android:id/message");
	public static By settingHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By categorysettingtxtview = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_category_settings");
	public static By categorySettingHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By categorySettingList = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By saveBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_save");
	public static By markAllChk = By.id(DeviceRelatedInformation.getPackageName()+":id/select_all");
	public static By unmarkChk = By.id(DeviceRelatedInformation.getPackageName()+":id/checkbox1");
	public static By wordOfTheDayCategory = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_prefrence_setting");
	public static By wordOfTheDayCategoryHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By wordOfTheDayCategoryListView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By getInTouchTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_send_us_feedback");
	public static By getInTouchBtn = By.xpath("//android.widget.ImageView[starts-with(@resource-id, '"+DeviceRelatedInformation.getPackageName()+":id/')]");
	public static By getInTouchFacebookImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/fbBtn");//
	public static By getInTouchTwitterImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/twiterBtn");
	public static By getInTouchInstagramImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/instaBtn");
	public static By getInTouchTumblrImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/tumblrBtn");
	public static By getInTouchImageViewUrl = By.xpath("//*[contains(@resource-id,':id/url')]");
	
	public static By disclaimerTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_disclaimer");
	public static By disclaimerHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By faqsTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_faq");
	public static By faqsHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By termAndConditionTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_terms");
	public static By termAndConditionUrlTxt = By.id("com.android.browser:id/url");
	public static By privacyPolicyTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_privacy");
	public static By privacyPolicyUrlTxt = By.id("com.android.browser:id/url");
	public static By app_sharing_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_share_this_app");
	public static By app_sharing_type_facebook = By.id(DeviceRelatedInformation.getPackageName()+":id/fbLayout");
	public static By app_sharing_type_other = By.id(DeviceRelatedInformation.getPackageName()+":id/allChannelsLayout");
	public static By facebook_username_txt_box = By.id("com.facebook.katana:id/login_username");
	public static By facebook_password_txt_box = By.id("com.facebook.katana:id/login_password");
	public static By facebook_log_in_btn = By.id("com.facebook.katana:id/login_login");
	public static By facebook_msg_txt_box = By.id("com.facebook.katana:id/status_text");
	public static By facebook_post_btn = By.id("com.facebook.katana:id/button_share");
	public static By facebook_audience_btn = By.id("com.facebook.katana:id/subtitle_view");
    public static By select_audience_type_btn = By.id("com.facebook.katana:id/item_label");
    public static By submitAudienceTypeBtn = By.id("com.facebook.katana:id/done_button");
	
    public static By rateThisAppTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_rate_this_app");
    public static By userIdTxt = By.id("com.android.vending:id/my_display_name");
    public static By installBtn = By.id("com.android.vending:id/buy_button");
    public static By uninstallBtn = By.id("com.android.vending:id/uninstall_button");
    public static By openBtn = By.id("com.android.vending:id/launch_button");
    
    
	/**
	 * This method is used to get the instance of EvMenu button.
	 * @return
	 */
	public static AndroidElement evMenuInstance(){
		
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
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Settings Page >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to settings page.
	 */
	public static void navigateToSettingPage(){
		try{
			navigateToEvMenuPage();
			Reusables.waitThread(1);
			selectEvMenuButton(DataConstants.evMenuSettingsBtn);
		}catch(NoSuchElementException e){
			Logs.error("Settings page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Setting page loaded or not.
	 */
	public static void verifySettingPageLoaded(){
		try{
			Reusables.waitForElement(settingHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.evMenuSettingsBtn);
		}catch(NoSuchElementException e){
			Logs.error("Settings Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the setting page.
	 */
	public static void submitSettingPage(){
		try{
			Reusables.stepBack();
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
			Reusables.waitThread(2);
			Reusables.clickCommand(categorysettingtxtview);
			Reusables.waitThread(2);
			//Reusables.verifyElementPresent(Reusables.getElement(categorySettingHeaderTxt), "Error Message!! Category Settings page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Category Setting page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Category setting page loaded or not.
	 */
	public static void verifyCategorySettingPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.categorySettingHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Category setting page not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select random category from category list.
	 * @return : return as String for verification.
	 * @param languageName : String for language selection
	 */
	public static String selectCategory(String languageName){
		String selected_category = "";
		int randonNumber = 0;
		try{
			List<String> categoryList = DatabaseConnection.getMainCategories(languageName);
			randonNumber = Reusables.randomNumber(categoryList.size());
			selected_category = categoryList.get(randonNumber);
			System.out.println("Selected Category.."+selected_category);
			Reusables.waitForElement(markAllChk);
			Reusables.verifyElementPresent(Reusables.getElement(markAllChk), "Error Message!!Red Mark button not visible.");
			while (Reusables.isElementPresent(By.name(selected_category)) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(By.name(categoryList.get(randonNumber)));
			List<AndroidElement> unmark_count = Reusables.getElementsList(unmarkChk);
			for (int i = 0; i < unmark_count.size(); i++){
				if (unmark_count.get(i).isSelected() == false){
					Reusables.verifyElementPresent(Reusables.getElementsList(unmarkChk).get(i), "Error Message!!Red Mark button still visible.");
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Category name not found. "+e.getClass().getName());
		}
		
		return selected_category;
	}
	
	
	/**
	 * This method is used to select random category from category list
	 * @param languageName : 
	 */
	public static void selectWordOfTheDayCategory(String languageName){
		String selected_category = "";
		int randonNumber = 0;
		List<AndroidElement> categoryList;
		try{
			categoryList = Reusables.getElementsList(wordOfTheDayCategoryListView);
			System.out.println("Category List Size.."+categoryList.size());
			randonNumber = Reusables.randomNumber(categoryList.size());
			selected_category = categoryList.get(randonNumber).getText();
			System.out.println("selected_category..>"+selected_category);
			while (Reusables.isElementPresent(By.name(selected_category)) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(By.name(selected_category));
			if (Reusables.isElementPresent(alert_popup) == true){
				Reusables.clickCommand(alert_popup);
			}
			else if (Reusables.isElementPresent(alert_popup) == false){	
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Selected Word Name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to mark all category for display in category setting page.
	 */
	public static void markAllCategoryBtn(){
		try{
			if (Reusables.getElement(markAllChk).isSelected() == true){
			}
			else if (Reusables.getElement(markAllChk).isSelected() == false){
				Reusables.clickCommand(markAllChk);
				System.out.println("done");
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
			Reusables.clickCommand(saveBtn);
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.getText(alert_popup_message), expectedMessage, "Error Message!! Actual and expected messgae not macthed.");
			Reusables.clickCommand(alert_popup);
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
			Reusables.waitThread(2);
			Reusables.clickCommand(wordOfTheDayCategory);
			Reusables.verifyElementPresent(Reusables.getElement(wordOfTheDayCategoryHeaderTxt), "Error Message!! Word Of The Day page not found.");
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
			Reusables.waitForElement(getInTouchTxtView);
			Reusables.clickCommand(getInTouchTxtView);
		}catch(NoSuchElementException e){
			Logs.error("Get In Touch with us button not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the Facebook.
	 */
	public static void clickOnFbLink(){
		try{
			Reusables.waitForElement(getInTouchFacebookImageView);
			Reusables.clickCommand(getInTouchFacebookImageView);
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
			Reusables.waitForElement(getInTouchTwitterImageView);
			Reusables.clickCommand(getInTouchTwitterImageView);
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
			Reusables.waitForElement(getInTouchInstagramImageView);
			Reusables.clickCommand(getInTouchInstagramImageView);
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
			Reusables.waitForElement(getInTouchTumblrImageView);
			Reusables.clickCommand(getInTouchTumblrImageView);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Tumblr Page not open. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Facebook page loaded or not.
	 */
	public static void verifyFacebookPageLoaded(){
		try{
			Reusables.waitForElement(getInTouchImageViewUrl);
			Reusables.verifyElementTextPresent(getInTouchImageViewUrl, DataConstants.get_in_touch_fb_txt);
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
			Reusables.waitForElement(getInTouchImageViewUrl);
			Reusables.verifyElementTextPresent(getInTouchImageViewUrl, DataConstants.get_in_touch_twitter_txt);
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
			Reusables.waitForElement(getInTouchImageViewUrl);
			Reusables.verifyElementTextPresent(getInTouchImageViewUrl, DataConstants.get_in_touch_instagram_txt);
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
			Reusables.waitForElement(getInTouchImageViewUrl);
			Reusables.verifyElementTextPresent(getInTouchImageViewUrl, DataConstants.get_in_touch_tumblr_txt);
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
		//navigateToGetInTouch();
		clickOnTwitterLink();
		verifyTwitterPageLoaded();
		//navigateToGetInTouch();
		clickOnInstagramLink();
		verifyInstagramPageLoaded();
		//navigateToGetInTouch();
		clickOnTumblrLink();
		verifyTumblrPageLoaded();
	}
	
	//>>>>>>>>>>>>>>>>>> Rate This App >>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the rate this app.
	 */
	public static void clickOnRateThisApp(){
		try{
			Reusables.waitThread(2);
			Reusables.clickCommand(rateThisAppTxt);
			Reusables.waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error("CLick Operation not perform on the rate this app. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the rate this app page.
	 */
	public static void navigateToRateThisApp(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnRateThisApp();
			/* Verify open button */
			if (Reusables.isElementPresent(openBtn)){
				Reusables.verifyElementPresent(Reusables.getElement(openBtn), "Error Message!! Open button not found.");
			}
			else if (Reusables.isElementPresent(uninstallBtn)){
				Reusables.verifyElementPresent(Reusables.getElement(uninstallBtn), "Error Message!! UnInstall button not found.");
			}
			else if (Reusables.isElementPresent(googlePlayStoreLayout)){
				Reusables.verifyElementPresent(Reusables.getElement(googlePlayStoreLayout), "Error Message!! Google Play Store text not found.");
			}
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
				Reusables.waitThread(1);
				Reusables.swipeUp();
				Reusables.waitThread(1);
			}
			actualUserName = Reusables.getText(userIdTxt);
			Reusables.verifyEqualMessage(actualUserName, expectedUserName, "Error Message!! Actual and Expected User name not matched.");
		}catch(NoSuchElementException e){
			Logs.error("UserName not found on the rate this app page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify social site button existence.
	 */
	public static void verifySocialSiteBtnExistence(){
		try{
			Reusables.verifyElementCountExistance(getInTouchBtn, true);
		}catch(NoSuchElementException e){
			Logs.error("Get In Touch related button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify that get in touch button not perform any action.
	 */
	public static void verifyGetInTouchPageNavigation(){
		try{
			Reusables.clickUsingElement(Reusables.getElementsList(getInTouchBtn).get(0));
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Not navigate to right page navigation. "+e.getClass().getName());
		}
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Information and support >>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on disclaimer button.
	 */
	public static void clickOnDisclaimer(){
		try{
			if (Reusables.isElementPresent(disclaimerTxtView) == false){
				Reusables.swipeUp();
			}
			Reusables.clickUsingElement(Reusables.getElement(disclaimerTxtView));
			Reusables.verifyElementPresent(Reusables.getElement(disclaimerHeaderTxt), "Error Message!! Disclaimer page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on Disclaimer button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the Disclaimer page.
	 */
	public static void navigateToDisclaimer(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnDisclaimer();
		}catch(NoSuchElementException e){
			Logs.error("Disclaimer page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify the Disclaimer page loaded or not.
	 */
	public static void verifyDisclaimerPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.disclaimerHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Disclaimer page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on FAQ's button.
	 */
	public static void clickOnFAQ(){
		try{
			if (Reusables.isElementPresent(faqsTxtView) == false){
				Reusables.swipeUp();
			}
			Reusables.clickUsingElement(Reusables.getElement(faqsTxtView));
			Reusables.verifyElementPresent(Reusables.getElement(faqsHeaderTxt), "Error Message!! FAQ's page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on FAQ's button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the FAQS page.
	 */
	public static void navigateToFAQS(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnFAQ();
		}catch(NoSuchElementException e){
			Logs.error("FAQS page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify the FAQS page loaded or not.
	 */
	public static void verifyFaqsPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.faqsHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("FAQS page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on Term And Condition button.
	 */
	public static void clickOnTermAndCondition(){
		try{
			if (Reusables.isElementPresent(termAndConditionTxtView) == false){
				Reusables.swipeUp();
			}
			Reusables.clickUsingElement(Reusables.getElement(termAndConditionTxtView));
			Reusables.waitThread(2);
			Reusables.verifyElementTextPresent(termAndConditionUrlTxt, DataConstants.term_condition_url_text);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on Term And Condition button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the Terms And Condition page.
	 */
	public static void navigateToTermsAndCondition(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnTermAndCondition();
		}catch(NoSuchElementException e){
			Logs.error("Terms And Condition page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on Privacy Policy button.
	 */
	public static void clickOnPrivacyPolicy(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(privacyPolicyTxtView) == false){
				Reusables.swipeUp();
			}
			Reusables.clickUsingElement(Reusables.getElement(privacyPolicyTxtView));
			Reusables.waitThread(2);
			Reusables.verifyElementTextPresent(privacyPolicyUrlTxt, DataConstants.privacy_policy_url_text);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on Privacy Policy Button. "+e.getClass().getName());
		}
	}
	
	
	
	/**
	 * This method is used to navigate to the Privacy Policy page.
	 */
	public static void navigateToPrivacyPolicy(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnPrivacyPolicy();
		}catch(NoSuchElementException e){
			Logs.error("Privacy Policy page not found. "+e.getClass().getName());
		}
	}
	
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Contribute related task. >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to contribute page.
	 */
	public static void navigateToContributePage(){
		try{
			navigateToEvMenuPage();
			selectEvMenuButton(DataConstants.evMenuContributeBtn);
			/*Reusables.waitForAndroidElement(Reusables.getElementsList(evMenuMenuBtns).get(1));
			Reusables.clickUsingElement(Reusables.getElementsList(evMenuMenuBtns).get(1));*/
		}catch(NoSuchElementException e){
			Logs.error("Contribute page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Contribute page loaded or not.
	 */
	public static void verifyContributePageLoaded(){
		try{
			Reusables.waitForElement(submitContributeBtn);
			//Reusables.verifyElementTextPresent(contributeHeaderTxt, DataConstants.contributeHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Contribute Page not loaded"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify edit term Contribute page loaded or not.
	 */
	public static void verifyEditTermContributePageLoaded(){
		try{
			Reusables.waitForElement(editContributeSubmitBtn);//public static By editContributeSubmitBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_submit");
		}catch(NoSuchElementException e){
			Logs.error("Contribute Page not loaded"+e.getClass().getName());
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
	 * This method is used to submit the contribute page.
	 */
	public static void submitContributePage(){
		try{
			Reusables.waitForElement(submitContributeBtn);
			Reusables.clickCommand(submitContributeBtn);
			Reusables.waitThread(1);
			if (DeviceRelatedInformation.getDeviceVersionName().contains("Marsmallow") || DeviceRelatedInformation.getDeviceVersionName().contains("Nougat")){
				SplashScreen.allowMediaFileAccessPopup();
			}
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the edit contribute page.
	 */
	public static void submitEditContributePage(){
		try{
			Reusables.waitForElement(editContributeSubmitBtn);
			Reusables.clickCommand(editContributeSubmitBtn);
			Reusables.waitThread(1);
			if (DeviceRelatedInformation.getDeviceVersionName().contains("Marsmallow") || DeviceRelatedInformation.getDeviceVersionName().contains("Nougat")){
				SplashScreen.allowMediaFileAccessPopup();
			}
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
	
	/**
	 * This method is used to verify submission message after click on submit button.
	 * @param expectedMessage : String type for comparison.
	 */
	public static void verifyContribteSubmissionMessage(String expectedMessage){
		try{
			if (Reusables.isElementPresent(alert_popup) == true){
				//Reusables.verifyEqualMessage(Reusables.getText(alert_popup_message), expectedMessage, "Error Message!!Actual submission message not matched with expected one.");
				if (Reusables.getText(alert_popup_message).contains(DataConstants.contribute_alert_message_for_successfull_submission)){
					Reusables.waitThread(4);
				}
				else if (Reusables.getText(alert_popup_message).contains(DataConstants.contribute_alert_message_for_failed_submission) || Reusables.getText(alert_popup_message).contains(DataConstants.contribute_alert_message_for_failed_submission_for_term_list_page)){
					Reusables.clickCommand(alert_popup);
				}
			}
			else if (Reusables.isElementPresent(alert_popup) == false){
			}
		}catch(NoSuchElementException e){
			Logs.error("Actual submission message not matched with expected one. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select the random category value from category list.
	 * @return : Return type String selected category value.
	 */
	public static String selectRandomCategoryValue(String languageName) {
		String randomName = "";
		List<AndroidElement> categoryList;
		try{
			Reusables.clickCommand(contribute_select_category_type);
			Reusables.waitThread(2);
			categoryList = Reusables.getElementsList(contribute_selected_category);
			randomName = categoryList.get(Reusables.randomNumber(categoryList.size()-1)).getAttribute("name");//.getText();
			while (Reusables.isElementPresent(By.name(randomName)) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(By.name(randomName));
		}catch(NoSuchElementException e){
			Logs.error("Random category value not selected from category list value. "+e.getClass().getName());
		}
		
		return randomName;
	}
	
	/**
	 * This method is used to enter text in word text box.
	 */
	public static void enterWordValue(String wordValue){
		try{
			Reusables.enterMessageInTextBox(contribute_wordTxt, wordValue);
		}catch(NoSuchElementException e){
			Logs.error("Value not enetred in the word text box. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to enter text in word text box.
	 */
	public static void enterPhoneticsValue(String wordValue){
		try{
			Reusables.enterMessageInTextBox(enterPhoneticsTxt, wordValue);//public static By enterPhoneticsTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_phonetic");
		}catch(NoSuchElementException e){
			Logs.error("Value not enetred in the word text box. "+e.getClass().getName());
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
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  More APP Related >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
	/**
	 * This method is used to navigate to more apps page.
	 */
	public static void navigateToMoreAppsPage(){
		try{
			navigateToEvMenuPage();
			Reusables.waitThread(2);
			selectEvMenuButton(DataConstants.evMenuMoreAppsBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on More apps button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify More Apps page loaded or not.
	 */
	public static void verifyMoreAppsPageLoaded(){
		try{
			Reusables.waitForElement(moreAppsPage);
			Reusables.verifyElementPresent(Reusables.getElement(moreAppsPage), "Error Message!!More Apps Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to more appsList page.
	 */
	public static void navigateToMoreAppsListPage(){
		try{
			Reusables.waitForElement(moreAppsPage);
			Reusables.clickCommand(moreAppsPage);
		}catch(NoSuchElementException e){
			Logs.error("MoreApp List Page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select and click on random app name.
	 */
	public static void selectAppNameFromAppList(){
		List<AndroidElement> appList;
		try{
			appList = Reusables.getElementsList(appsList);
			Reusables.clickUsingElement(appList.get(Reusables.randomNumber(appList.size())));
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on the app name from app list page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify google play store page open or not.
	 */
	public static void verifyGooglePlayStorePageLoaded(){
		try{
			if (Reusables.isElementPresent(googlePlayStoreLayout)){
				Reusables.verifyElementPresent(Reusables.getElement(googlePlayStoreLayout), "Error Message!! Google Play Store text not found.");
			}
			else if (Reusables.isElementPresent(installBtn)){
				Reusables.verifyElementPresent(Reusables.getElement(installBtn), "Error Message!! Install button not found.");
			}
			else if (Reusables.isElementPresent(openBtn)){
				Reusables.verifyElementPresent(Reusables.getElement(openBtn), "Error Message!! Open button not found.");
			}
			else if (Reusables.isElementPresent(uninstallBtn)){
				Reusables.verifyElementPresent(Reusables.getElement(uninstallBtn), "Error Message!! UnInstall button not found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("google play store page not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to close More Apps page.
	 */
	public static void closeMoreAppsPage(){
		try{
			Reusables.stepBack();;
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
				Reusables.clickUsingElement(Reusables.getElement(app_sharing_txtView));
				Reusables.waitThread(2);
			}catch(NoSuchElementException e){
				Logs.error("Facebook layout not found. "+e.getClass().getName());
			}
		}

		
		/**
		 * This method is used to select app sharing type layout.
		 * @param app_sharing_type : String type for selecting app sharing type.
		 */
		public static void appSharingType(String app_sharing_type){
			try{
				Reusables.waitForElement(app_sharing_type_facebook);
				if (app_sharing_type.equalsIgnoreCase("facebook")){
					Reusables.clickCommand(app_sharing_type_facebook);
				}
				else if (app_sharing_type.equalsIgnoreCase("others")){
					Reusables.clickCommand(app_sharing_type_other);
				}
			}catch(NoSuchElementException e){
				Logs.error("App Sharing Type layout not found. "+e.getClass().getName());
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
				AndroidElement userName = Reusables.getElement(facebook_username_txt_box);
				userName.click();
				userName.clear();
				userName.sendKeys(DataConstants.fbuserName);
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
				AndroidElement userPass = Reusables.getElement(facebook_password_txt_box);
				userPass.click();
				userPass.sendKeys(DataConstants.fbPassword);
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
				if (Reusables.isElementPresent(facebook_log_in_btn) == true){
					status = true;
				}
				else if (Reusables.isElementPresent(facebook_log_in_btn) == false){
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
				System.out.println("Facbook status...."+status);
				if (status == true){
					enterUsername();
					enterPassword();
					facebookSubmit();
				}
				else if (status == false){
					verifyFacebookPostButton();
				}
				verifyFacebookPostButton();
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
				Reusables.waitThread(5);
				Reusables.clickCommand(facebook_post_btn);
				Reusables.waitThread(5);
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
				AndroidElement element = Reusables.getElement(facebook_msg_txt_box);
				element.click();
				element.sendKeys(DataConstants.fbMessage);
				Reusables.waitThread(2);
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
				Reusables.waitThread(3);
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
		public static String selectAudience(String audience_type){
			String selected_audience_type = "";
			try{
				List<AndroidElement> audienceList = Reusables.getElementsList(select_audience_type_btn);
				for (int i = 0; i < audienceList.size(); i++){
					if (audienceList.get(i).getText().equalsIgnoreCase(audience_type)){
						selected_audience_type = audienceList.get(i).getText();
						//System.out.println("selected_audience_type"+selected_audience_type);
						audienceList.get(i).click();
						Reusables.waitThread(2);
						/*Reusables.stepBack();*/
						Reusables.clickCommand(submitAudienceTypeBtn);
						Reusables.waitThread(3);
						break;
					}
					else {
						
					}
				}
			}
			catch(NoSuchElementException e){
				Logs.error("Audience not selected. "+e.getClass().getName());
			}
			
			return selected_audience_type;
		}
		
		/**
		 * This method is used to get the audience type value.
		 * @return
		 */
		public static String getAudienceValue(){
			String audienceVaue = "";
			try{
				Reusables.waitForElement(facebook_audience_btn);
				audienceVaue = Reusables.getElement(facebook_audience_btn).getText().trim();
				//System.out.println("Audience Value.."+audienceVaue);
			}catch(NoSuchElementException e){
				Logs.error("Unable to get Audience Value. "+e.getClass().getName());
			}
			
			return audienceVaue;
		}
		
		/**
		 * This method is used to verify either selected audience type matched or not.
		 * @param expectedAudienceVaue : for verify audience value matched or not.
		 */
		public static void verifySelectedAudienceType(String expectedAudienceVaue){
			try{
				Reusables.waitForAndroidElement(Reusables.getElement(facebook_audience_btn));
				Reusables.verifyEqualMessage(getAudienceValue(), expectedAudienceVaue, "Error Message!! Select profile type not found.");
			}catch(NoSuchElementException e){
				Logs.error("Select profile type not found. "+e.getClass().getName());
			}
		}
}
