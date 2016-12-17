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
	public static By evMenuBtn = By.id("menu");//By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[3]");//By.id("menu");
	public static By evMenuMenusBtns = By.xpath("//UIACollectionCell");
	public static By moreAppBtn = By.id("more_apps_button");
	public static By appList = By.xpath("//UIACollectionCell");
	public static By appStoreCloseBtn = By.id("Cancel");
	public static By closeBtn = By.id("close button");
	public static By settingDoneBtn = By.id("Done");
	
	public static By contributeHeaderTxt = By.id("Header");
	public static By recipeNameTxt = By.id("recipe_name");
	public static By servingsTxt = By.id("servings");
	public static By cookingTimeTxt = By.id("cooking_time");
	public static By ingredientNameTxt = By.id("ingredient_name");
	public static By quantityTxt = By.id("ingredient_quantity");
	public static By unitTxt = By.id("ingredient_unit");
	public static By selectIngredientBtn = By.id("INGREDIENTS");
	public static By preparationmethodBtn = By.id("METHOD");
	public static By addDescriptionTxt = By.id("add_step");
	public static By submitIngredientValueBtn = By.id("add");
	public static By submitMethodBtn = By.id("add");
	public static By submitcontributeBtn = By.id("Contribute");
	
	public static By settingHeaderTxt = By.name("Header");
	public static By settingPageCellCount = By.xpath("//UIATableCell");
	
	public static By getInTouchBtnList  = By.xpath("//UIAButton[starts-with(@name,'share')]");
	public static By disclaimerHeaderTxt = By.id("Header");
	public static By faqsHeaderTxt = By.id("Header");
	public static By privacyPolicyHeaderTxt = By.id("Header");
	public static By termsAndConditionsHeaderTxt = By.id("Header");
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
	public static By appStoreBtn = By.id("App Store");
	public static By cancelBtn = By.id("Cancel");
	public static By detailsBtn = By.id("Details");
	public static By reviewBtn = By.id("Reviews");
	public static By relatedBtn = By.id("Related");
	
	
	/**
	 * This method is used to get the instance of EvMenu button.
	 * @return
	 */
	public static IOSElement evMenuInstance(){
		
		return Reusables.getIOSElement(evMenuBtn);
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
			Reusables.waitForIOSElement(evMenuBtn);
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
			List<IOSElement> buttonList = Reusables.getIOSElementsList(evMenuMenusBtns);
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
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Settings Page >>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to settings page.
	 */
	public static void navigateToSettingPage(){
		try{
			navigateToEvMenuPage();
			Reusables.waitThread(1);
			selectEvMenuButton(DataConstants.evmenuSettingsBtn);
		}catch(NoSuchElementException e){
			Logs.error("Settings page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Setting page loaded or not.
	 */
	public static void verifySettingPageLoaded(){
		try{
			Reusables.waitForIOSElement(settingHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.evmenuSettingsBtn);
		}catch(NoSuchElementException e){
			Logs.error("Settings Page not loaded"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to submit the setting page.
	 */
	public static void submitSettingPage(){
		try{
			Reusables.waitForIOSElement(settingDoneBtn);
			Reusables.clickCommand(settingDoneBtn);
		}catch(NoSuchElementException e){
			Logs.endTestCase("Setting page still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used click on the setting table cell value.
	 * @param cellValue : String type.
	 */
	public static void clickOnSettingUIATableCell(String cellValue){
		List<IOSElement> list;
		try{
			list = Reusables.getIOSElementsList(settingPageCellCount);
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getAttribute("name").contains(cellValue)){
					list.get(i).click();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Cell Name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the change preference text view.
	 */
	public static void clickOnChangePreference(){
		try{
			Reusables.waitThread(2);
			clickOnSettingUIATableCell(DataConstants.changePreferenceTxt);
		}catch(NoSuchElementException e){
			Logs.error("preference text view not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the change preference page.
	 */
	public static void navigateToChangePreferencePage(){
		try{
			navigateToSettingPage();
			verifySettingPageLoaded();
			clickOnChangePreference();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Change preference page not visible. "+e.getClass().getName());
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
		}catch(NoSuchElementException e){
			Logs.error("Get In Touch with us button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Facebook.
	 */
	public static void clickOnFbLink(){
		try{
			List<IOSElement> getintouchList = Reusables.getIOSElementsList(getInTouchBtnList);
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
			List<IOSElement> getintouchList = Reusables.getIOSElementsList(getInTouchBtnList);
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
			List<IOSElement> getintouchList = Reusables.getIOSElementsList(getInTouchBtnList);
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
		try{List<IOSElement> getintouchList = Reusables.getIOSElementsList(getInTouchBtnList);
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
			List<IOSElement> getintouchList = Reusables.getIOSElementsList(getInTouchBtnList);
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
			Reusables.waitForIOSElement(faqsHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.getInTouchHeaderTxt);
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
			Reusables.waitForIOSElement(faqsHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.getInTouchHeaderTxt);
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
			Reusables.waitForIOSElement(faqsHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.getInTouchHeaderTxt);
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
			Reusables.waitForIOSElement(faqsHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.getInTouchHeaderTxt);
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
		Reusables.oneStepBack();
		clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
		clickOnTwitterLink();
		verifyTwitterPageLoaded();
		Reusables.oneStepBack();
		clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
		clickOnInstagramLink();
		verifyInstagramPageLoaded();
		Reusables.oneStepBack();
		clickOnSettingUIATableCell(DataConstants.getInTouchTxt);
		clickOnTumblrLink();
		verifyTumblrPageLoaded();
		Reusables.oneStepBack();
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
			//Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(settingPageCellCount).get(6));
			//Reusables.verifyElementPresent(Reusables.getElement(disclaimerHeaderTxt), "Error Message!! Disclaimer page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Disclaimer page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Disclaimer page loaded.
	 */
	public static void verifyDisclaimerPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.disclaimerHeaderText);
		}catch(NoSuchElementException e){
			Logs.error(">>>> Disclaimer Page not loaded"+e.getClass().getName());
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
			//Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(settingPageCellCount).get(7));
			//Reusables.verifyElementPresent(Reusables.getElement(faqsHeaderTxt), "Error Message!! FAQS page not found.");
		}catch(NoSuchElementException e){
			Logs.error("FAQS page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Faqs page loaded.
	 */
	public static void verifyFaqsPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.faqsHeaderText);
		}catch(NoSuchElementException e){
			Logs.error(">>>> FAQS Page not loaded. "+e.getClass().getName());
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
			//Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(settingPageCellCount).get(8));
		}catch(NoSuchElementException e){
			Logs.error("Terms And Condition page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Term and condition page loaded.
	 */
	public static void verifyTermsAndConditionsPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.termsAndConditionHeaderText);
		}catch(NoSuchElementException e){
			Logs.error(">>>> Terms and Conditions Page not loaded"+e.getClass().getName());
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
			//Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(settingPageCellCount).get(9));
		}catch(NoSuchElementException e){
			Logs.error("Privacy Policy page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Privacy policy page loaded.
	 */
	public static void verifyPrivacyPolicyPageLoaded(){
		try{
			Reusables.verifyPageLoaded(DataConstants.privacyPolicyHeaderText);
		}catch(NoSuchElementException e){
			Logs.error("Privacy policy Page not loaded"+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  More APP Related >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
	
	/**
	 * This method is used to navigate to more apps page.
	 */
	public static void navigateToMoreAppsPage(){
		try{
			navigateToEvMenuPage();
			selectEvMenuButton(DataConstants.evmenuMoreAppsBtn);
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify More Apps page loaded or not.
	 */
	public static void verifyMoreAppsPageLoaded(){
		try{
			Reusables.waitThread(10);
			Reusables.verifyElementPresent(Reusables.getIOSElement(closeBtn), "Error Message!!More Apps Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error("More Apps Page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to open the app list page.
	 */
	public static void openAppsList(){
		try{
			Reusables.waitForIOSElement(moreAppBtn);
			Reusables.clickCommand(moreAppBtn);
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
	 * This method is used to close More Apps page.
	 */
	public static void closeMoreAppsPage(){
		try{
			Reusables.tapOnIOSElement(closeBtn);
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
				clickOnSettingUIATableCell(DataConstants.shareThisAppTxt);
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
				Reusables.verifyElementPresent(Reusables.getIOSElement(facebook_log_in_btn), "Error Message! Login Button not visible");
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
				IOSElement userName = Reusables.getIOSElement(facebook_username_txt_box);
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
				IOSElement userPass = Reusables.getIOSElement(facebook_password_txt_box);
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
				IOSElement element = Reusables.getIOSElement(facebook_log_in_btn);
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
		 * This method is used to verify FaceBook post message.
		 */
		public static void verifyFacebookPostButton(){
			try{
				Reusables.waitThread(5);
				Reusables.verifyElementPresent(Reusables.getIOSElement(facebook_post_btn), "Error Message! Facebool text not visible******");
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
				Reusables.waitForIOSElement(facebook_post_btn);
				Reusables.clickCommand(facebook_post_btn);
				Reusables.waitThread(3);
				}
			catch(NoSuchElementException e){
				Logs.error("Facebook post is still visible. "+e.getClass().getName());
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
		
		/**
		 * This method is used to click on the FaceBook option for sharing the app.
		 */
		public static void facebookShareMessage(){
			try{
				IOSElement element = Reusables.getIOSElement(facebook_msg_txt_box);
				//element.setValue(DataConstants.facebook_message);
				element.click();
				element.sendKeys(DataConstants.facebookMessageTxt);
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
		
		
		/* Rate This App */ 
		/**
		 * This method is used to navigate to the rate this app page.
		 */
		public static void navigateToRateThisApp(){
			try{
				navigateToSettingPage();
				clickOnSettingUIATableCell(DataConstants.rateThisAppTxt);
			}catch(NoSuchElementException e){
				Logs.error("Rate This app page not open. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to verify app store page loaded.
		 */
		public static void verifyAppStorePageLoaded(){
			try{
				Reusables.verifyElementPresent(Reusables.getIOSElement(appStoreBtn), "Error Messsage!App Store button not found.");
			}catch(NoSuchElementException e){
				Logs.error("App Store button not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify element related the rate this app.
		 */
		public static void verifyElementOnAppStorePage(){
			try{
				Reusables.verifyElementPresent(Reusables.getIOSElement(detailsBtn), "Error Messsage!Detail button not found.");
				Reusables.verifyElementPresent(Reusables.getIOSElement(reviewBtn), "Error Messsage!Review button not found.");
				Reusables.verifyElementPresent(Reusables.getIOSElement(relatedBtn), "Error Messsage!Related button not found.");
			}catch(NoSuchElementException e){
				Logs.error("Rate this app element not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to hide the iTune Store page.
		 */
		public static void closeAppStorePage(){
			try{
				Reusables.waitThread(5);
				if (Reusables.isElementPresent(appStoreCloseBtn)){
					Reusables.clickCommand(appStoreCloseBtn);
				}
				else {
					Reusables.tapOnElementUsingCoordinate(1, 0, 50);
					Reusables.waitThread(5);
					Reusables.tapOnIOSElement(SplashScreen.hideiTuneStorePage);
				}
			}catch(NoSuchElementException e){
				Logs.error("App Store page still visible. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to hide the app list page.
		 */
		public static void closeAppListPage(){
			try{
				Reusables.waitThread(2);
				Reusables.tapOnIOSElement(closeBtn);
			}catch(NoSuchElementException e){
				Logs.error("App Store page still visible. "+e.getClass().getName());
			}
		}
		
		
		// Contribute Related data 
		/**
		 * This method is used to navigate to contribute page.
		 */
		public static void navigateToContributePage(){
			try{
				navigateToEvMenuPage();
				selectEvMenuButton(DataConstants.evmenuContributeBtn);
			}catch(NoSuchElementException e){
				Logs.error("Contribute page not loaded. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to verify Contribute page loaded.
		 */
		public static void verifyContributePageLoaded(){
			try{
				Reusables.waitForIOSElement(contributeHeaderTxt);
				Reusables.verifyPageLoaded(DataConstants.contributeHeaderTxt);
			}catch(NoSuchElementException e){
				Logs.error("Contributes Page not loaded. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Recipe name.
		 */
		public static void enterRecipeName(String recipeName){
			try{
				Reusables.enterMessageInTextBox(recipeNameTxt, recipeName, "return");
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>> Recipe Name txt box not found./ "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Servings Value.
		 */
		public static void enterServingsValue(String servingValue){
			try{
				Reusables.enterMessageInTextBox(servingsTxt, servingValue, "return");
			}catch(NoSuchElementException e){
				Logs.error("Servings txt box not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Cooking time.
		 */
		public static void enterCookingTime(String cookingTime){
			try{
				Reusables.enterMessageInTextBox(cookingTimeTxt, cookingTime, "return");
			}catch(NoSuchElementException e){
				Logs.error("Cooking txt box not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Ingredient Name.
		 */
		public static String enterIngredientName(String ingredientName){
			String enterIngredient_name = "";
			try{
				Reusables.waitForIOSElement(ingredientNameTxt);
				Reusables.enterMessageInTextBox(ingredientNameTxt, ingredientName, "return");
			}catch(NoSuchElementException e){
				Logs.error("Ingredient Name txt box not found./ "+e.getClass().getName());
			}
			return enterIngredient_name;
		}
		
		/**
		 * This method is used to enter the Quantity Value.
		 */
		public static void enterQuantityValue(){
			try{
				Reusables.enterMessageInTextBox(quantityTxt, DataConstants.quantity, "return");
			}catch(NoSuchElementException e){
				Logs.error("Quantity Value txt box not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Unit Value.
		 */
		public static void enterUnitValue(){
			try{
				Reusables.waitForIOSElement(unitTxt);
				Reusables.enterMessageInTextBox(unitTxt, DataConstants.unit, "return");
			}catch(NoSuchElementException e){
				Logs.error("Unit Value txt box not found."+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to submit the ingredient values.
		 */
		public static void submitIngredientValue(){
			try{
				Reusables.waitForIOSElement(submitIngredientValueBtn);
				Reusables.clickCommand(submitIngredientValueBtn);
			}catch(NoSuchElementException e){
				Logs.error("Add ingredient button not found. "+e.getClass().getName());
			}
		}
		
		public static void verifyIngredientName(String expectedIngredientName){
			try{
				Reusables.waitForIOSElement(selectIngredientBtn);
				Reusables.waitForIOSElement(By.name(expectedIngredientName));
			}catch(NoSuchElementException e){
				Logs.error("Ingredient Name not found. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to Select method type.
		 */
		public static void selectMethod(){
			try{
				Reusables.waitForIOSElement(preparationmethodBtn);
				Reusables.clickCommand(preparationmethodBtn);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>PreparationMethod button not found."+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to enter the Method Name.
		 */
		public static void enterMethodValue(String methodValue){
			try{
				Reusables.waitForIOSElement(addDescriptionTxt);
				Reusables.enterMessageInTextBox(addDescriptionTxt, methodValue, "no key");
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>PreparationMethod txt box not found. "+e.getClass().getName());
			}
		}
	
		
		/**
		 * This method is used to add method preparation.
		 */
		public static void submitMethodValue(){
			try{
				//Reusables.waitForIOSElement(submitMethodBtn);
				Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(submitMethodBtn).get(0));
			}catch(NoSuchElementException e){
				Logs.error(">>>>>> Add Preparation btn not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to submit contribute.
		 */
		public static void submitContribute(){
			try{
				Reusables.waitForIOSElement(submitcontributeBtn);
				Reusables.clickCommand(submitcontributeBtn);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>> Contribute button not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to fill text box values.
		 */
		public static String fillTextBoxValue(){
			List<String> list = DatabaseConnection.contributeRelatedData();
			try{
				enterRecipeName(list.get(0));
				enterServingsValue(list.get(1));
				enterCookingTime(list.get(2));
				
			}catch(NoSuchElementException e){
				Logs.error("Text value not display in the text boxes. "+e.getClass().getName());
			}
			
			return list.get(0).trim().toString();
		}
		
		/**
		 * This method is used to add ingredients values.
		 */
		public static String addIngredientsValue(String recipeName){
			String ingredientName = Reusables.getPatternListValue(DatabaseConnection.ingredientsOnRecipeDetailPage(recipeName)).get(0);
			enterIngredientName(ingredientName);
			enterQuantityValue();
			enterUnitValue();
			
			return ingredientName;
		}
	
		
		/**
		 * This method is used to add Method values.
		 * @return : String type method text.
		 */
		public static String addMethodValue(){
			String methodValue = "";
			selectMethod();
			methodValue = DataConstants.methodTxt;
			enterMethodValue(methodValue);
			submitMethodValue();
			
			return methodValue;
		}
	
		/**
		 * This method is used to verify method added text.
		 * @param expectedMethodName
		 */
		public static void verifyMethodTxt(String expectedMethodName){
			try{
				Reusables.waitForIOSElement((submitMethodBtn));
				Reusables.waitForIOSElement(By.name(expectedMethodName));
			}catch(NoSuchElementException e){
				Logs.error("Method Name not found. "+e.getClass().getName());
			}
		}
}
