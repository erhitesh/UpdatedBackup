package com.eduven.modules;

import java.util.List;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class EVMenu {
	
	
	/* Object Identification */
	public static By evMenuBtn = By.id("menu");
	public static By infoBtn = By.id("info");
	public static By submitInfoPage = By.id("Done");
	public static By cancelBtn = By.id("Cancel");
	public static By moreAppsBtn = By.id("Cross Promo1");
	public static By appList = By.xpath("//UIACollectionCell");
	public static By moreAppsCloseBtn = By.id("close button");	
	public static By moreAppListBtn = By.id("More_apps_list_button");
	public static By detailsBtn = By.id("Details");
	public static By reviewBtn = By.id("Reviews");
	public static By relatedBtn = By.id("Related");
	public static By closeBtn = By.id("close button");
	public static By disclaimerLbl = By.xpath("//UIAStaticText[@name='Disclaimer']");
	public static By disclaimerHeaderTxt = By.id("Information");
	public static By termsAndConditionsLbl = By.xpath("//UIAStaticText[@name='Terms and conditions']");
	public static By privacyPolicyLbl = By.xpath("//UIAStaticText[@name='Privacy Policy']");
	public static By shareAppTxt = By.xpath("//UIATableCell[@name='Share this app']");
	public static By getInTouchTxt = By.xpath("//UIAStaticText[@name='Get in touch']");
	public static By getInTouchFbBtn = By.xpath("//UIAButton[@name='share 1'][1]");
	public static By facebookHeaderTxt = By.id("");
	public static By getInTouchTwitterBtn = By.xpath("//UIAButton[@name='share 2'][1]");
	public static By twitterHeaderTxt = By.id("");
	public static By getInTouchTumblrBtn = By.xpath("//UIAButton[@name='share 3'][1]");
	public static By tumblrHeaderTxt = By.id("");
	public static By getInTouchInstagramBtn = By.xpath("//UIAButton[@name='share 4'][1]");
	public static By instagramHeaderTxt = By.id("");
	public static By getInTouchMailBtn = By.xpath("//UIAButton[@name='share 5'][1]");
	public static By rateThisAppTxt = By.id("Rate this app");
	public static By shareAppByFacebookLbl = By.id("Facebook");
	public static By shareAppByOtherSocialSiteLbl = By.id("Others");
	public static By facebookUserNameTextBox = By.id("com.facebook.katana:id/login_username");
	public static By facebookUserPassTextBox = By.id("com.facebook.katana:id/login_password");
	public static By facebookLogInBtn = By.id("com.facebook.katana:id/login_login");
	public static By facebookMsgTxtBox = By.id("Message");//By.xpath("//*[@name='Say something about this...']");
	public static By facebookPostBtn = By.id("Post");
	public static By openThisPageInBtn = By.id("Open");
	public static By facebookAudienceBtn = By.xpath("//UIATableCell[@name='Audience']");//By.id("com.facebook.katana:id/selectable_privacy_text");
    public static By facebookAudiencePublicBtn = By.xpath("//UIAStaticText[@name='Public']");//By.id("com.facebook.katana:id/item_privacy_icon");
	public static By facebookAudienceFriendsBtn = By.xpath("//UIAStaticText[@name='Friends']");//By.id("com.facebook.katana:id/item_privacy_icon");
	public static By facebookAudienceOnlyMeBtn = By.xpath("//UIAStaticText[@name='Only Me']");//By.id("com.facebook.katana:id/item_privacy_icon");
	public static By audienceValue = By.xpath("//UIATableCell[@name='Audience']//UIAStaticText[2]");
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, EvMenu instance.
	 */
	public static IOSElement evMenuInstance(){
		IOSElement evMenu_element = null;
		try{
			evMenu_element = Reusables.getIOSElement(evMenuBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("EvMenu Button not found. "+e.getClass().getName());
		}
		
		return evMenu_element;
	}
	
	
	/**
	 * This method is used to click on the EvMenu Icon .
	 */
	public static void navigateToEvMenu(){
		try{
			Reusables.waitForIOSElement(evMenuInstance());
			Reusables.clickUsingIOSElement(evMenuInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on EvMenu Icon. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the evMenu page.
	 */
	public static void submitEvMenuPage(){
		try{
			Reusables.waitForIOSElement(submitInfoPage);
			Reusables.clickCommand(submitInfoPage);
		}
		catch(NoSuchElementException e){
			Logs.error("Done Button Still present... "+e.getClass().getName());
		}
	}

	  
	  // Contribute button 
		/**
		 * This method is used to click on the contribute button inside contribute page
		 */
		public static void clickOnInfoButton() {
			try {
				Reusables.waitForIOSElement(infoBtn);
				Reusables.clickCommand(infoBtn);
			} catch (NoSuchElementException e) {
				Logs.error("Click operation not perform on the info button. "+e.getClass().getName());
			}
		}
		

		/**
		 * This method is used to navigate to the contribute page.
		 */
		public static void navigateToInfoPage() {
			navigateToEvMenu();
			clickOnInfoButton();
			verifyInfoPageLoaded();
		}
		 
		
		/**
		 * This method is used to verify contribute page loaded or not.
		 */
		public static void verifyInfoPageLoaded(){
			try{
				Reusables.waitThread(1);
				//Reusables.verifyElementPresent(Reusables.getIOSElement(contribute_page_header_txt), "Error Messaeg!! Contribute header txt not matched with expected ones.");
			}
			catch(NoSuchElementException e){
				Logs.error("Info Page not loaded. "+e.getClass().getName());
			}
		}
		 
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  More APP Related >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
	
		/**
		 * This method is used to click on the more Apps button
		 */
		public static void clickOnMoreAppsButton() {
			try {
				Reusables.clickCommand(moreAppsBtn);

			} catch (NoSuchElementException e) {
				Logs.error("****Click operation not perform on the More Apps Button*"+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify More Apps page loaded or not
		 */
		public static void verifyMoreAppsPageLoaded() {
			try {
				Reusables.verifyElementPresent(Reusables.getIOSElement(moreAppsCloseBtn), "Error Message!! More Apps Page not loaded...");
			} catch (NoSuchElementException e) {
				Logs.error(" More Apps Page Not Loaded. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to navigate to the More Apps page. 
		 */
		public static void navigateToMoreAppsPage(){
			navigateToEvMenu();
			clickOnMoreAppsButton();
			verifyMoreAppsPageLoaded();
		}
		
		
		/**
		 * This method is used to close More Apps page.
		 */
		public static void closeMoreAppsPage() {
			try {
				Reusables.waitThread(2);
				Reusables.tapOnIOSElement(moreAppsCloseBtn);
			} catch (NoSuchElementException e) {
				Logs.error("More Apps Page Still Open "+e.getClass().getName());
			}
		}
		
		
		
	/**
	 * This method is used to open the app list page.
	 */
	public static void navigateToAppsList(){
		try{
			Reusables.waitForIOSElement(moreAppListBtn);
			Reusables.clickCommand(moreAppListBtn);
		}catch(NoSuchElementException e){
			Logs.error("App List page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the random app name from the app list page.
	 */
	public static void clickOnAppNameFromAppList(){
		try{
			List<IOSElement> applist = Reusables.getIOSElementsList(appList);
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
			Reusables.waitForIOSElement(detailsBtn);
			Reusables.verifyElementPresent(Reusables.getIOSElement(detailsBtn), "Error Messsage!Detail button not found.");
			Reusables.verifyElementPresent(Reusables.getIOSElement(reviewBtn), "Error Messsage!Review button not found.");
			Reusables.verifyElementPresent(Reusables.getIOSElement(relatedBtn), "Error Messsage!Related button not found.");
		}catch(NoSuchElementException e){
			Logs.error("Elements not found on the iTune Store Page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to hide the iTune Store page.
	 */
	public static void closeAppStore(){
		try{
			Reusables.waitThread(5);
			Reusables.tapOnIOSElement(cancelBtn);
		}catch(NoSuchElementException e){
			Logs.error("App Store page still visible. "+e.getClass().getName());
		}
	}
	
	
	

	// Information and support 

	    /**
	     * This method is used to click on the disclaimer button.
	     */
		public static void clickOnDisclaimer() {
			try {
				Reusables.clickUsingIOSElement(Reusables.getIOSElement(disclaimerLbl));
			} catch (NoSuchElementException e) {
				Logs.error(" Click operation not perform on disclaimer "+e.getClass().getName());
			}
		}

		/**
		 * This method is used to navigate to Disclaimer page.
		 */
		public static void navigateToDisclaimerPage(){
			clickOnDisclaimer();
		}
		
		/**
		 * This method is used to verify Disclaimer page loaded or not
		 */
		public static void verifyDisclaimerPageLoaded() {
			try {
				Reusables.verifyElementPresent(Reusables.getIOSElement(disclaimerHeaderTxt),"Error Message! Disclaimer page not loaded");
			} catch (NoSuchElementException e) {
				Logs.error("Error Message! Disclaimer page not loaded"+e.getClass().getName());
			}
		}

		
		/**
		 * This method is used to click on the privacy policy button.
		 */
		public static void clickOnPrivacyPolicy() {
			try {
				Reusables.waitForIOSElement(privacyPolicyLbl);
				Reusables.clickCommand(privacyPolicyLbl);
			} catch (NoSuchElementException e) {
				Logs.error(" Click operation not perform on the privacy policy button.."+e.getClass().getName());
			}
		}

		/**
		 * This method is used to navigate to Privacy Policy page.
		 */
		public static void navigateToPrivacyPolicyPage(){
			clickOnPrivacyPolicy();
		}
		
		/**
		 * This method is used to verify privacy policy page loaded or not
		 */
		public static void verifyPrivacyPageLoaded() {
			try {
				Reusables.verifyElementPresent(Reusables.getIOSElement(disclaimerHeaderTxt), "Error Message! Privacy page not loaded");
			} catch (NoSuchElementException e) {
				Logs.error(" Error Message! Privacy page not loaded "+e.getClass().getName());
			}
		}

		/**
		 * This method is used to click on the terms and conditions button.
		 */
		public static void clickOnTermsAndConditions() {
			try {
				Reusables.clickUsingIOSElement(Reusables.getIOSElement(termsAndConditionsLbl));
			} catch (NoSuchElementException e) {
				Logs.error(" Click operation not perform on the terms and conditions button.."+e.getClass().getName());
			}
		}

		/**
		 * This method is used to navigate to Terms and Conditions page.
		 */
		public static void navigateToTermsAndConditionsPage(){
			clickOnTermsAndConditions();
		}
		
		
		/**
		 * This method is used to verify terms and conditions page loaded or not.
		 */
		public static void verifyTermsAndConditionsPageLoaded() {
			try {
				Reusables.verifyElementPresent(Reusables.getIOSElement(disclaimerHeaderTxt), "Error Message! terms and conditions page not loaded");
			} catch (NoSuchElementException e) {
				Logs.error(" Error Message! terms and conditions page not loaded "+e.getClass().getName());
			}
		}

		/**
		 * This method is used to verify Disclaimer related operations.
		 */
		public static void verifyInformationAndSupportForDisclaimer(){
			clickOnDisclaimer();
			verifyDisclaimerPageLoaded();
			Reusables.oneStepBack();
		}
		
		/**
		 * This method is used to verify Terms and conditions related operations.
		 */
		public static void verifyInformationAndSupportForTermsAndConditions(){
			clickOnTermsAndConditions();
			verifyTermsAndConditionsPageLoaded();
			Reusables.oneStepBack();
			
		}
		
		/**
		 * This method is used to verify Privacy Policy related operations.
		 */
		public static void verifyInformationAndSupportForPrivacyPolicy(){
			clickOnPrivacyPolicy();
			verifyPrivacyPageLoaded();
			Reusables.oneStepBack();
		}
		
		
		
		
		
		

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   Social  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 

	/**
	 * This method is used to click on the share this app.
	 */
	public static void clickOnShareApp() {
		try {
			Reusables.waitForIOSElement(shareAppTxt);
			Reusables.clickCommand(shareAppTxt);
		} catch (NoSuchElementException e) {
			Logs.error("Click operation not perform on the share this app lbl.."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to app sharing page.
	 */
	public static void navigateToAppSharing(){
		try{
			navigateToInfoPage();
			clickOnShareApp();
		}catch(NoSuchElementException e){
			Logs.error("App Sharing page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select share type.
	 * @param share_medium : Type String
	 */
	public static void selectShareType(String shareMediumType){
		
		try{
			if (shareMediumType.equalsIgnoreCase("facebook")){
				Reusables.clickUsingIOSElement(Reusables.getIOSElement(shareAppByFacebookLbl));
			}
			
			else if (shareMediumType.equalsIgnoreCase("others")) {
				Reusables.clickUsingIOSElement(Reusables.getIOSElement(shareAppByOtherSocialSiteLbl));
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" Share app medium not found. "+e.getClass().getName());
		}
	}
	
	public static void verifyLoginButton(){
		try{
			Reusables.waitThread(5);
			Reusables.verifyElementPresent(Reusables.getIOSElement(facebookLogInBtn), "Error Message! Login Button not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Login Button not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to enter User name in email id text box.
	 */
	public static void enterUsername(){
		try{
			IOSElement userName = Reusables.getIOSElement(facebookUserNameTextBox);
			userName.click();
			userName.clear();
			userName.sendKeys(DataConstants.fbUserName);
		}
		catch(NoSuchElementException e){
			Logs.error("Username text box not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to enter user password in password box.
	 */
	public static void enterPassword(){
		try{
			IOSElement userPass = Reusables.getIOSElement(facebookUserPassTextBox);
			userPass.click();
			userPass.sendKeys(DataConstants.fbUserPass);
		}
		catch(NoSuchElementException e){
			Logs.error("User password text box not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the Facebook login.
	 */
	public static void submitFacebook(){
		try{
			Reusables.clickCommand(facebookLogInBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Facebook submit button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check Facebook login status.
	 * @return : Type boolean, return Facebook status.
	 */
	public static boolean facebookLoginStatus(){
		boolean status = false;
		try{
			IOSElement element = Reusables.getIOSElement(facebookLogInBtn);
			if ( element.isDisplayed()){
				status = true;
			}
		}
		catch(NoSuchElementException e){
			Logs.warn("User already log in. "+e.getClass().getName());
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
			Logs.error("Neither Facebook username & password text box found nor Share to Facebook text visible. "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to verify face book post message.
	 */
	public static void verifyFacebookPostButton(){
		try{
			if (Reusables.isElementPresent(facebookPostBtn)){
				Reusables.waitThread(5);
				Reusables.verifyElementPresent(Reusables.getIOSElement(facebookPostBtn), "Error Message!!!Facebook text not visible******");
			}
			else{
				Logs.error(" User not logged into facebook account... ");
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Facebook post not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to post message on facebook.
	 */
	public static void postFacebookMessage(){
		try{
			Reusables.waitForIOSElement(facebookPostBtn);
			Reusables.clickCommand(facebookPostBtn);
			Reusables.waitThread(3);
		}
		catch(NoSuchElementException e){
			Logs.error("Facebook post is still visible. "+e.getClass().getName());
		}
		
	}
	
	/**
	 * This method is used rto
	 */
	public static void acceptOpenThisPageInAppName(){
		try{
			if (Reusables.isElementPresent(openThisPageInBtn)){
				if (Reusables.getAlertMessage().contains("Open this page in")){
					Reusables.acceptAlert();
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Open this page in alert not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the audience lbl.
	 */
	public static void clickOnAudience(){
		try{
			Reusables.waitForIOSElement(facebookAudienceBtn);
			Reusables.clickCommand(facebookAudienceBtn);
		}
		catch(NoSuchElementException e){
			Logs.error(" Error Message!Audience type Not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify selected audience type.
	 */
	public static void verifySelectedAudienceType(String expectedSelectedAudienceType, String message){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(audienceValue), expectedSelectedAudienceType, message);
		}
		catch(NoSuchElementException e){
			Logs.error(" Error Message!! Selected audience type not matched.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select audience type.
	 * @param audienceType : Audience type.
	 */
	public static void selectAudience(String audienceType){
		try{
			clickOnAudience();
			if (audienceType.equalsIgnoreCase(("Public"))){
				Reusables.clickCommand(facebookAudiencePublicBtn);
				verifySelectedAudienceType(audienceType, "Error Message!! Selected Audience type not matched..");
				//Reusables.oneStepBack();
			}
			else if (audienceType.equalsIgnoreCase("Friends")){
				Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(facebookAudienceFriendsBtn).get(1));
				verifySelectedAudienceType(audienceType, "Error Message!! Selected Audience type not matched..");
				Reusables.oneStepBack();
			}
			else if(audienceType.equalsIgnoreCase("Only Me")){
				Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(facebookAudienceOnlyMeBtn).get(2));
				verifySelectedAudienceType(audienceType, "Error Message!! Selected Audience type not matched..");
				Reusables.oneStepBack();
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
			IOSElement element = Reusables.getIOSElement(facebookMsgTxtBox);
			element.click();
			element.clear();
			element.setValue(DataConstants.fbMessage);
			//element.sendKeys(DataConstants.facebook_post_message);
			Reusables.waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error(" Facebook text not visible "+e.getClass().getName());
		}
	}
	
	public static void appSharingSuccessfullMessage(){
		try{
			if (Reusables.alertInstance() != null){
				Reusables.acceptAlert();
				Reusables.waitThread(2);
			}
		}
		catch(NoSuchElementException e){
			Logs.error("App Share message not found.. "+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Get in touch >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.
	
	public static void clickOnGetInTouch(){
		try{
			Reusables.waitForIOSElement(getInTouchTxt);
			Reusables.clickCommand(getInTouchTxt);
		}catch(NoSuchElementException e){
			Logs.error("Click operation is not perform on the Get in touch. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the get in touch with us page.
	 */
	public static void navigateToGetInTouch(){
		try{
			navigateToInfoPage();
			clickOnGetInTouch();
		}catch(NoSuchElementException e){
			Logs.error("Get In Touch with us button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Facebook.
	 */
	public static void clickOnFbLink(){
		try{
			//Reusables.waitForIOSElement(getInTouchFbBtn);
			Reusables.clickCommand(getInTouchFbBtn);
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
			//Reusables.waitForIOSElement(getInTouchTwitterBtn);
			Reusables.clickCommand(getInTouchTwitterBtn);
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
			Reusables.clickCommand(getInTouchInstagramBtn);
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
			//Reusables.waitForIOSElement(getInTouchTumblrBtn);
			Reusables.clickCommand(getInTouchTumblrBtn);
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
			Reusables.waitForIOSElement(getInTouchMailBtn);
			Reusables.clickCommand(getInTouchMailBtn);
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
			Reusables.waitForIOSElement(facebookHeaderTxt);
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
			Reusables.waitForIOSElement(twitterHeaderTxt);
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
			Reusables.waitForIOSElement(instagramHeaderTxt);
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
			Reusables.waitForIOSElement(tumblrHeaderTxt);
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Tumblr Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify get in touch link workd or not.
	 */
	public static void verifyGetInTouchLinks(){
		navigateToGetInTouch();
		clickOnFbLink();
		//verifyFacebookPageLoaded();
		Reusables.oneStepBack();
		/*clickOnGetInTouch();
		clickOnTwitterLink();
		//verifyTwitterPageLoaded();
		Reusables.oneStepBack();
		clickOnGetInTouch();
		clickOnInstagramLink();
		//verifyInstagramPageLoaded();
		Reusables.oneStepBack();
		clickOnGetInTouch();
		clickOnTumblrLink();
		//verifyTumblrPageLoaded();
*/		Reusables.oneStepBack();
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Rate This app >>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to the rate this app page.
	 */
	public static void navigateToRateThisApp(){
		try{
			navigateToInfoPage();
			Reusables.clickCommand(rateThisAppTxt);
		}catch(NoSuchElementException e){
			Logs.error("Rate This app page not open. "+e.getClass().getName());
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
			Reusables.tapOnIOSElement(SplashScreen.hideiTuneStorePage);
		}catch(NoSuchElementException e){
			Logs.error("App Store page still visible. "+e.getClass().getName());
		}
	}
}
