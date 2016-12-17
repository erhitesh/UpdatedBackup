package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Contribute {

	/* IOSDriver Instance */ 
	IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/*  Locator Values */
	public static By contribute_btn = By.name("Contribute");
	public static By contribute_sub_btn = By.name("CONTRIBUTE");
	public static By add_image_btn = By.xpath("//UIAImage[@name='contribute_defaultImage.png'][1]");
	public static By enter_message_txt_box = By.xpath("//UIATextField[1]");
	public static By cancel_btn = By.name("Cancel");
	public static By more_apps_btn = By.name("More Apps");
	public static By cross_promo_btn = By.name("crossPromoClose");
	public static By settings_btn = By.name("Settings");
	public static By app_setting_lbl = By.name("App Settings");
	public static By done_btn = By.name("Done");
	public static By disclaimer_lbl = By.name("Disclaimer");
	public static By disclaimer_lbl_txt = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[1]");
	public static By faqs_lbl = By.name("FAQ's");
	public static By faqs_lbl_txt = By.xpath("//UIAStaticText[1]");
	public static By privacy_lbl = By.name("Privacy Policy");
	public static By privacy_lbl_txt = By.xpath("//UIAStaticText[@name='YOUR PRIVACY IS OUR PRIORITY'][1]");
	public static By share_app_txt = By.name("Share this app");
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
	 * This method is used to click on the EvMenu.
	 */
	public static void clickOnEvMenu() {
		try {
			Reusables.clickCommand(HomePage.ev_menu_btn);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click operation not perform on the ev menu. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to click on the contribute button.
	 */
	public static void clickOnContributeButton() {
		try {
			Reusables.clickCommand(contribute_btn);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click operation not perform on the contribute button. "+e.getClass().getName());
		}
	}

// *********************************More Apps*********************************************
	/**
	 * This method is used to click on the more Apps button.
	 */
	public static void clickOnMoreAppsButton() {
		try {
			Reusables.clickCommand(more_apps_btn);
			}
		catch (NoSuchElementException e) {
			Logs.error("More Apps Button not found. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to navigate to more Apps page.
	 */
	public static void navigateToMoreApps(){
		clickOnEvMenu();
		clickOnMoreAppsButton();
	}

	/**
	 * This method is used to verify more apps page loaded or not.
	 */
	public static void verifyMoreAppsPageLoaded() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(cross_promo_btn),	"Error Message! Cross promo button not visible, More Apps page not loaded**********");
			}
		catch (NoSuchElementException e) {
			Logs.error("More Apps Page not visible. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to close more apps page.
	 */
	public static void closeMoreAppaPage(){
		try{
			Reusables.clickCommand(cross_promo_btn);
			}
		catch(NoSuchElementException e){
			Logs.error("More apps page is still visible. "+e.getClass().getName());
			}
		}

// *********************************Setting button****************************************
	/**
	 * This method is used to click on the setting button.
	 */
	public static void clickOnSettingsButton() {
		try {
			Reusables.clickCommand(settings_btn);
			}
		catch (NoSuchElementException e) {
			Logs.error("Settings Button not found. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify setting page loaded or not.
	 */
	public static void verifySettingPageLoaded() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(app_setting_lbl),	"Error Message! Setting page not opened.");
			} 
		catch (NoSuchElementException e) {
			Logs.error("Setting page not visible. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to navigate to settings page,
	 */
	public static void navigateToSetting() {
		clickOnEvMenu();
		clickOnSettingsButton();
		}
	
	/**
	 * This method is used to click on done button.
	 */
	public static void settingDone() {
		try {
			Reusables.clickCommand(done_btn);
			}
		catch (NoSuchElementException e) {
			Logs.error("Done Button still visible. "+e.getClass().getName());
			}
		}

	// ****************Feedback************************************
	public static void clickOnShareApp() {
		try {
			Reusables.clickCommand(share_app_txt);
			}
		catch (NoSuchElementException e) {
			Logs.error("Share App Button not found. "+e.getClass().getName());
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
			userName.sendKeys(DataConstants.facebook_user_name);
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
			userPass.sendKeys(DataConstants.facebook_password);
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
			}
		catch(NoSuchElementException e){
			Logs.error("Enable to login facebook, Share to Facebook text not showing. "+e.getClass().getName());
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
			else if (element.isDisplayed() == false){
				status = false;
			}
			}
		catch(NoSuchElementException e){
			Logs.warn("Facebook user Name and password text box not visible. ");
			}
		
		return status;
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
			element.sendKeys(DataConstants.facebook_message);
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
			else if (audience_type.equals("")){
				Reusables.clickCommand(facebook_audience_custom_btn);
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Audience not selected. "+e.getClass().getName());
		}
	}

	// ***************** Information and support ********************
	/**
	 * This method is used to click on the Disclaimer button
	 */
	public static void clickOnDisclaimer() {
		try {
			Reusables.clickCommand(disclaimer_lbl);
			}
		catch (NoSuchElementException e) {
			Logs.error("Disclaimer Button not Found. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Disclaimer page loaded.
	 */
	public static void verifyDisclaimerPageLoaded() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(disclaimer_lbl_txt), "Error Message! Disclaimer page not loaded");
			}
		catch (NoSuchElementException e) {
			Logs.error("Error Message! Disclaimer page not loaded. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to click on the privacy policy.
	 */
	public static void clickOnPrivacyPolicy() {
		try {
			Reusables.clickCommand(privacy_lbl);
			}
		catch (NoSuchElementException e) {
			Logs.error("Privacy  button not found. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify privacy page loaded.
	 */
	public static void verifyPrivacyPageLoaded() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(privacy_lbl_txt), "Error Message! Privacy page not loaded");
			}
		catch (NoSuchElementException e) {
			Logs.error("Error Message! Privacy page not loaded. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to click on the Faqs.
	 */
	public static void clickOnFaqs() {
		try {
			Reusables.clickCommand(faqs_lbl);
			}
		catch (NoSuchElementException e) {
			Logs.error("Faqs Button not found. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify faqs page loaded or not.
	 */
	public static void verifyFaqsPageLoaded() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(faqs_lbl_txt), "Error Message! Faq's page not loaded");
			}
		catch (NoSuchElementException e) {
			Logs.error("Error Message! Faq's page not loaded. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to 
	 */
	public static void verify_information_support_for_disclaimer(){
		clickOnDisclaimer();
		verifyDisclaimerPageLoaded();
		Reusables.stepBack();
		
	}
	
	/**
	 * This method is used to verify information for support.
	 */
	public static void verifyInformationSupportForFaqs(){
		clickOnFaqs();
		verifyFaqsPageLoaded();
		Reusables.stepBack();
		
	}
	
	/**
	 * This method is used to verify information and support privacy.
	 */
	public static void verifyInformationSupportForPrivacy(){
		clickOnPrivacyPolicy();
		verifyPrivacyPageLoaded();
		Reusables.stepBack();
	}
	
// ********************************Cancel button **********************************************
	/**
	 * This method is used to click on the cancel button.
	 */
	public static void clickOnCancelButton() {
		try {
			Reusables.clickCommand(cancel_btn);
			} 
		catch (NoSuchElementException e) {
			Logs.error("Cancel button is still visible. "+e.getClass().getName());
			}
		}

// ****************************************Contribute button************************************
	/**
	 * This method is used to click on the contribute button inside contribute page.
	 */
	public static void clickOnContributeSubButton() {
		try {
			Reusables.clickCommand(contribute_sub_btn);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click operation not perform on the Contribute sub button. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify profile pic added present or not.
	 */
	public static void verifyProfilePicAdder() {
		try {
			Reusables.verifyElementPresent(Reusables.getElement(add_image_btn), "Error Message! Profile pic adder button does not exists************.");
			}
		catch (NoSuchElementException e) {
			Logs.error("Profile Pic adder not visible. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to add title on the contribute page
	 * @param title_txt : String type
	 */
	public static void addTitle(String title_txt) {
		try {
			Reusables.enterMessageInTextBox(enter_message_txt_box, title_txt);
			}
		catch (NoSuchElementException e) {
			Logs.error("Enable to add title message. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to navigate to contribute page.
	 */
	public static void navigateToContribute() {
		clickOnEvMenu();
		clickOnContributeButton();
	}
}
