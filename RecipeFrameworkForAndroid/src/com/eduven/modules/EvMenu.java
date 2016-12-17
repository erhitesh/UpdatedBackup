package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;

public class EvMenu {
	
	
	/* Object Identification */
	public static By evMenu_btn = By.xpath("//*[@content-desc='More options']");
	public static By evMenuMenuBtns = By.id(DeviceRelatedInformation.getPackageName()+":id/title");
	
	public static By tips_btn = By.name("Tips");
	public static By subHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By tips_page_header_txt = By.name("Tips");
	
	public static By contribute_btn = By.name("Contribute");
	public static By contribute_page_headertxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	public static By settings_btn = By.name("Settings");
	public static By settings_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By changePrefencesTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/change_food_preferences");
	
	public static By moreApp_btn= By.name("More Apps");
	public static By installBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/installCrosspormotion");
	public static By appNameOnMoreAppPage = By.id(DeviceRelatedInformation.getPackageName()+":id/label_appName");
	public static By moreApps_page_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
	public static By appNameOnPlayStore = By.id("com.android.vending:id/title_title");
	public static By installBtnOnPlayStorePage = By.id("com.android.vending:id/buy_button");
	public static By openBtn = By.id("com.android.vending:id/launch_button");
	public static By moreAppsMessage = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
	
	public static By recipeNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	public static By servingsTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/servings");
	public static By cookingTimeTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/cooking_time");
	public static By ingredientNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/ingredient_name");
	public static By quantityTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/ingredient_quantity");
	public static By unitTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/ingredient_unit");
	public static By selectIngredientBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/ingredient");
	
	public static By preparationmethodBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/preparation");
	public static By addDescriptionTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/description");
	
	public static By submitIngredientBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/add_ingredient_button");
	public static By submitMethodBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/add_preparation_step_button");
	public static By submitcontributeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/contribute");
	
	public static By disclaimerBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/disclaimer");
	public static By disclaimerPageHeaderTxt = By.xpath("//*[@content-desc='Disclaimer']");
	
	public static By termsAndConditionsTxtView = By.name("Terms and Conditions");
	public static By termsAndConditionsUrlTxt = By.id("com.android.chrome:id/url_bar");
	public static By privacyPolicyTxtView = By.name("Privacy Policy");
	public static By privacypolicyUrlTxt = By.id("com.android.chrome:id/url_bar");
	
	public static By rateThisApp = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_rate_this_app");
	public static By userIdTxt = By.id("com.android.vending:id/my_display_name");
	
	public static By getInTouchTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/send_us_feedback");
	public static By getInTouchHeadeTxt = By.name("Get in touch with us");
	public static By getInTouchfacebookImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/facebook");
	public static By getInTouchtwitterImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/twitter");
	public static By getInTouchtumblrImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/tumblr");
	public static By getInTouchinstagramImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/instagram");
	public static By getInTouchmailImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/tumblr");
	public static By get_in_touch_url = By.id("com.android.chrome:id/url_bar");
	
	public static By ShareThisAppBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/share_this_app");
	public static By selectFb = By.id(DeviceRelatedInformation.getPackageName()+":id/fbLayout");
	public static By selectOthers = By.id(DeviceRelatedInformation.getPackageName()+":id/fbLayout");
	public static By facebookUserName = By.id("com.facebook.katana:id/login_username");
	public static By facebookUserPassword = By.id("com.facebook.katana:id/login_password");
	public static By facebookLogInBtn = By.id("com.facebook.katana:id/login_login");
	public static By facebookPostBtn = By.id("com.facebook.katana:id/button_share"); //com.facebook.katana:id/button_share
	public static By facebookAudienceBtn = By.id("com.facebook.katana:id/subtitle_prefix_view");
	public static By facebookSelectedAudienceValue = By.id("com.facebook.katana:id/audience_picker_autocomplete_input");
	public static By facebookAudiencePublicBtn = By.id("com.facebook.katana:id/is_picked_checkbox");
	public static By facebookAudienceFriendsBtn = By.id("com.facebook.katana:id/is_picked_checkbox");
	public static By facebookAudienceOnlyMeBtn = By.id("com.facebook.katana:id/is_picked_checkbox");
	public static By facebookmsgtxtbox = By.id("com.facebook.katana:id/status_text");
	public static By doneBtn = By.id("com.facebook.katana:id/done_button");
	
	
	/**
	 * This method is used to click on EvMenu button on home page.
	 */
	public static void clickOnEvMenuButton(){
		try{
			Reusables.waitForElement(evMenu_btn);
			Reusables.clickUsingElement(Reusables.getElement(evMenu_btn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the evmenu page.
	 */
	public static void navigateToEvMenuPage(){
		clickOnEvMenuButton();
	}
	
	/**
	 * This method is used to verify EvMenu Menu list.
	 */
	public static void verifyEvMenuList(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(tips_btn));
			Reusables.verifyElementEnable(Reusables.getElement(tips_btn), "Error Message!! Tips Button not found..");
			Reusables.verifyElementEnable(Reusables.getElement(contribute_btn), "Error Message!! Contribute Button not found..");
			Reusables.verifyElementEnable(Reusables.getElement(settings_btn), "Error Message!! Settings Button not found..");
			Reusables.verifyElementEnable(Reusables.getElement(moreApp_btn), "Error Message!! More Apps Button not found..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu List not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on EvMenu button.
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
	
	//>>>>>>>>>>>>>>>>>>>>>> Tips >>>>>>>>>>>>>>>>>>>>>>>
	public static void clickOnTipsButton(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(tips_btn));
			Reusables.clickUsingElement(Reusables.getElement(tips_btn));
			SplashScreen.allowMediaFilesAndContacts();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Tips Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify tips page loaded.
	 */
	public static void verifyTipsPageLoaded(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(tips_page_header_txt), "Error Message!!Tips Page not loaded..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> Tips Page not loaded"+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>> More Apps >>>>>>>>>>>>>>>>>>>>>>>
		public static void clickOnMoreAppButton(){
			try{
				Reusables.waitForAndroidElement(Reusables.getElement(moreApp_btn));
				Reusables.clickUsingElement(Reusables.getElement(moreApp_btn));
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>> More Apps Button not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify more Apps page loaded.
		 */
		public static void verifyMoreAppPageLoaded(){
			try{
				Reusables.verifyElementEnable(Reusables.getElement(moreApps_page_txt), "Error Message!! More Apps Page not loaded..");
			}catch(NoSuchElementException e){
				Logs.error(">>>> More Apps Page not loaded"+e.getClass().getName());
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
		
	//>>>>>>>>>>>>>>>>>>>>>> Contribute >>>>>>>>>>>>>>>>>>>>>>>
		public static void clickOnContributeButton(){
			try{
				Reusables.waitForAndroidElement(Reusables.getElement(contribute_btn));
				Reusables.clickUsingElement(Reusables.getElement(contribute_btn));
				SplashScreen.allowMediaFilesAndContacts();
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>> Contribute Button not found. "+e.getClass().getName());
			}
		}
		
		public static void navigateToContributePage(){
			navigateToEvMenuPage();
			clickOnContributeButton();
		}
		
		/**
		 * This method is used to verify Contribute page loaded.
		 */
		public static void verifyContributePageLoaded(){
			try{
				Reusables.verifyElementEnable(Reusables.getElement(contribute_page_headertxt), "Error Message!!Contributes Page not loaded..");
			}catch(NoSuchElementException e){
				Logs.error(">>>> Contributes Page not loaded"+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Recipe name.
		 */
		public static void enterRecipeName(String recipeName){
			try{
				Reusables.enterMessageInTextBox(recipeNameTxt, recipeName);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>> Recipe Name txt box not found./ "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Servings Value.
		 */
		public static void enterServingsValue(String servingValue){
			try{
				Reusables.enterMessageInTextBox(servingsTxt, servingValue);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>Servings txt box not found./ "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Cooking time.
		 */
		public static void enterCookingTime(String cookingTime){
			try{
				Reusables.enterMessageInTextBox(cookingTimeTxt, cookingTime);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>Cooking txt box not found./ "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Ingredient Name.
		 */
		public static String enterIngredientName(String ingredientName){
			String enterIngredient_name = "";
			try{
				Reusables.waitForElement(ingredientNameTxt);
				Reusables.enterMessageInTextBox(ingredientNameTxt, ingredientName);
				Reusables.oneStepBack();
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>Ingredient Name txt box not found./ "+e.getClass().getName());
			}
			return enterIngredient_name;
		}
		
		/**
		 * This method is used to enter the Quantity Value.
		 */
		public static void enterQuantityValue(){
			try{
				Reusables.enterMessageInTextBox(quantityTxt, DataConstants.quantity);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>Quantity Value txt box not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter the Unit Value.
		 */
		public static void enterUnitValue(){
			try{
				Reusables.waitForElement(unitTxt);
				Reusables.enterMessageInTextBox(unitTxt, DataConstants.unit);
				Reusables.oneStepBack();
			}catch(NoSuchElementException e){
				Logs.error("Unit Value txt box not found."+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to submit the ingredient values.
		 */
		public static void submitIngredientValue(){
			try{
				Reusables.waitForElement(submitIngredientBtn);
				Reusables.clickCommand(submitIngredientBtn);
			}catch(NoSuchElementException e){
				Logs.error("Add ingredient button not found. "+e.getClass().getName());
			}
		}
		
		public static void verifyIngredientName(String expectedIngredientName){
			try{
				Reusables.waitForElement(selectIngredientBtn);
				Reusables.waitForElement(By.name(expectedIngredientName));
			}catch(NoSuchElementException e){
				Logs.error("Ingredient Name not found. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to Select method type.
		 */
		public static void selectMethod(){
			try{
				Reusables.waitForAndroidElement(Reusables.getElement(preparationmethodBtn));
				Reusables.clickUsingElement(Reusables.getElement(preparationmethodBtn));
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>PreparationMethod button not found."+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to enter the Method Name.
		 */
		public static void enterMethodValue(String methodValue){
			try{
				Reusables.waitForElement(addDescriptionTxt);
				Reusables.enterMessageInTextBox(addDescriptionTxt, methodValue);
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>PreparationMethod txt box not found. "+e.getClass().getName());
			}
		}
	
		
		/**
		 * This method is used to add method preparation.
		 */
		public static void submitMethodValue(){
			try{
				Reusables.waitForAndroidElement(Reusables.getElement(submitMethodBtn));
				Reusables.clickUsingElement(Reusables.getElement(submitMethodBtn));
			}catch(NoSuchElementException e){
				Logs.error(">>>>>> Add Preparation btn not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to submit contribute.
		 */
		public static void submitContribute(){
			try{
				Reusables.waitForAndroidElement(Reusables.getElement(submitcontributeBtn));
				Reusables.clickUsingElement(Reusables.getElement(submitcontributeBtn));
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>> Contribute button not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to fill text box values.
		 */
		public static String fillTextBoxValue(){
			List<String> list = DatabaseConnection.contributeRelatedData();
			enterRecipeName(list.get(0));
			enterServingsValue(list.get(1));
			enterCookingTime(list.get(2));
			
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
			methodValue = DataConstants.method_txt;
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
				Reusables.waitForElement((submitMethodBtn));
				Reusables.waitForElement(By.name(expectedMethodName));
			}catch(NoSuchElementException e){
				Logs.error("Method Name not found. "+e.getClass().getName());
			}
		}
		
		/* Information and supports */
		public static void clickOnDisclaimerButton(){
			try{
				if (Reusables.isElementPresent(disclaimerBtn)==false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Reusables.waitForAndroidElement(Reusables.getElement(disclaimerBtn));
				Reusables.clickUsingElement(Reusables.getElement(disclaimerBtn));
			}catch(NoSuchElementException e){
				Logs.error(">>>>>>>> Disclaimer Button not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to navigate to Disclaimer page.
		 */
		public static void navigateToDisclaimerPage(){
			navigateToSettingPage();
			clickOnDisclaimerButton();
		}
		
		/**
		 * This method is used to verify Disclaimer page loaded.
		 */
		public static void verifyDisclaimerPageLoaded(){
			try{
				Reusables.verifyElementEnable(Reusables.getElement(disclaimerPageHeaderTxt), "Error Message!! Disclaimer Page not loaded..");
			}catch(NoSuchElementException e){
				Logs.error(">>>> Disclaimer Page not loaded"+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to click on the privacy policy button.
		 */
		public static void clickOnPrivacyPolicy() {
			try {
				if (Reusables.isElementPresent(privacyPolicyTxtView) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
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
				//Reusables.verifyElementPresent(Reusables.getElement(privacypolicyUrlTxt), "Error Message!!Privacy Policy Page not loaded.");
				Reusables.verifyElementTextPresent(privacypolicyUrlTxt, DataConstants.privacy_policy_url_text);
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
				//Reusables.verifyElementPresent(Reusables.getElement(termsAndConditionsUrlTxt), "Error Message! terms and conditions page not loaded");
				Reusables.verifyElementTextPresent(termsAndConditionsUrlTxt, DataConstants.term_and_condition_url_text);
				Reusables.waitThread(2);
				} catch (NoSuchElementException e) {
					Logs.error("Terms and Conditions page not loaded. "+e.getClass().getName());
			}
		}

		
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> feedback >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		/* Get In Touch With Us */
		/**
		 * This method is used to navigate to the get in touch with us page.
		 */
		public static void navigateToGetInTouch(){
			try{
				navigateToSettingPage();
				while (Reusables.isElementPresent(getInTouchTxt)==false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Reusables.waitForElement(getInTouchTxt);
				Reusables.clickCommand(getInTouchTxt);
				Reusables.waitThread(1);
			}
			catch(NoSuchElementException e){
				Logs.error("Get In Touch with us textview not found. "+e.getClass().getName());
			}
		}

		/**
		 * This method is used to click on the Facebook.
		 */
		public static void clickOnFbLink(){
			try{
				Reusables.waitForElement(getInTouchfacebookImageView);
				Reusables.clickCommand(getInTouchfacebookImageView);
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
				Reusables.waitForElement(getInTouchtwitterImageView);
				Reusables.clickCommand(getInTouchtwitterImageView);
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
				Reusables.waitForElement(getInTouchinstagramImageView);
				Reusables.clickCommand(getInTouchinstagramImageView);
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
				Reusables.waitForElement(getInTouchtumblrImageView);
				Reusables.clickCommand(getInTouchtumblrImageView);
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
				Reusables.waitForElement(getInTouchmailImageView);
				Reusables.clickCommand(getInTouchmailImageView);
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
				Reusables.waitForElement(get_in_touch_url);
				Reusables.verifyElementTextPresent(get_in_touch_url, DataConstants.get_in_touch_fb_txt);
				Reusables.oneStepBack();
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
				Reusables.waitForElement(get_in_touch_url);
				Reusables.verifyElementTextPresent(get_in_touch_url, DataConstants.get_in_touch_twitter_txt);
				Reusables.oneStepBack();
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
				Reusables.waitForElement(get_in_touch_url);
				Reusables.verifyElementTextPresent(get_in_touch_url, DataConstants.get_in_touch_instagram_txt);
				Reusables.oneStepBack();
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
				Reusables.waitForElement(get_in_touch_url);
				Reusables.verifyElementTextPresent(get_in_touch_url, DataConstants.get_in_touch_tumblr_txt);
				Reusables.oneStepBack();
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
			navigateToGetInTouch();
			clickOnTwitterLink();
			verifyTwitterPageLoaded();
			Reusables.oneStepBack();
			navigateToGetInTouch();
			clickOnInstagramLink();
			verifyInstagramPageLoaded();
			Reusables.oneStepBack();
			navigateToGetInTouch();
			clickOnTumblrLink();
			verifyTumblrPageLoaded();
			Reusables.oneStepBack();
		}
		
		/* Rate This App */ 
		/**
		 * This method is used to navigate to the rate this app page.
		 */
		public static void navigateToRateThisApp(){
			try{
				navigateToSettingPage();
				if (Reusables.isElementPresent(rateThisApp)==false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
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
					Reusables.waitThread(1);
				}
				actualUserName = Reusables.getText(userIdTxt);
				Reusables.verifyEqualMessage(actualUserName, expectedUserName, "Error Message!! Actual and Expected User name not matched.");
			}catch(NoSuchElementException e){
				Logs.error("UserName not found on the rate this app page. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to click on the share this app.
		 */
		public static void clickOnShareApp() {
			try {
				while (Reusables.isElementPresent(ShareThisAppBtn)==false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Reusables.clickCommand(ShareThisAppBtn);
			} catch (NoSuchElementException e) {
				Logs.error("Click operation not perform on the share this app lbl.. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to navigate to the share this app.
		 */
		public static void navigateToShareThisApp(){
			navigateToSettingPage();
			clickOnShareApp();
		}
		
		/**
		 * This method is used to select share type.
		 * @param share_medium : Type String For selecting sharing medium.
		 */
		public static void selectShareType(String share_medium_type){
			try{
				if (share_medium_type.equalsIgnoreCase("facebook")){
					Reusables.clickUsingElement(Reusables.getElement(selectFb));
				}
				else if (share_medium_type.equalsIgnoreCase("others")) {
					Reusables.clickUsingElement(Reusables.getElement(selectOthers));
				}
			}
			catch(NoSuchElementException e){
				Logs.error("Share app medium not found..>>>"+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to verify login button.
		 */
		public static void verifyLoginButton(){
			try{
				Reusables.waitThread(5);
				Reusables.verifyElementPresent(Reusables.getElement(facebookLogInBtn), "Error Message! Login Button not visible");
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>> Login Button not visible. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to enter User name in email id text box.
		 */
		public static void enterUsername(){
			try{
				Reusables.waitForElement(facebookUserName);
				Reusables.enterMessageInTextBox(facebookUserName, DataConstants.facebook_userName);
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
				Reusables.waitForElement(facebookUserPassword);
				Reusables.enterMessageInTextBox(facebookUserPassword, DataConstants.facebook_userPass);
			}
			catch(NoSuchElementException e){
				Logs.error("User Password text box not found.. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to submit the FaceBook login.
		 */
		public static void submitFacebook(){
			try{
				Reusables.waitForElement(facebookLogInBtn);
				Reusables.clickCommand(facebookLogInBtn);
			}
			catch(NoSuchElementException e){
				Logs.error(">>>>>>>>>>>>>>>>>>>>> Facebook submit button not found.. "+e.getClass().getName());
			}
		}

		/**
		 * This method is used to login using facebook credentials.
		 */
		public static void facebookLogin(){
			try{
				Reusables.waitThread(10);
				if (Reusables.isElementPresent(facebookLogInBtn) == true){
					enterUsername();
					enterPassword();
					submitFacebook();
				}
				else if (Reusables.isElementPresent(facebookLogInBtn) == false) {
					verifyFacebookPostButton();
				}
			}
			catch(NoSuchElementException e){
				Logs.error("Enable to login facebook, Share to Facebook text not showing. "+e.getClass().getName());
			}
		}

		
		/**
		 * This method is used to verify facebook post message.
		 */
		public static void verifyFacebookPostButton(){
			try{
				Reusables.waitThread(5);
				Reusables.verifyElementEnable(Reusables.getElement(facebookPostBtn), "Error Message!!!Facebool text not visible******");
			}
			catch(NoSuchElementException e){
				Logs.error("Facebook post not visible "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to post message on facebook.
		 */
		public static void postFacebookMessage(){
			try{
				Reusables.waitForElement(facebookPostBtn);
				Reusables.clickCommand(facebookPostBtn);
				Reusables.waitThread(3);
			}
			catch(NoSuchElementException e){
				Logs.error("Facebook post is still visible. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to click on the audience lbl.
		 */
		public static void clickOnAudience(){
			try{
				Reusables.waitForElement(facebookAudienceBtn);
				Reusables.clickCommand(facebookAudienceBtn);
			}
			catch(NoSuchElementException e){
				Logs.error("Error Message!Audience type Not visible. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify selected audience type.
		 */
		public static void verifySelectedAudienceType(String selected_audience_type, String ErrorMessage){
			try{
				//Reusables.waitForElement(facebookSelectedAudienceValue);
				Reusables.verifyEqualMessage(Reusables.getText(facebookSelectedAudienceValue), selected_audience_type, ErrorMessage);
			}
			catch(NoSuchElementException e){
				Logs.error("Error Message!! Selected audience type not matched.. "+e.getClass().getName());
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
					Reusables.clickUsingElement(Reusables.getElementsList(facebookAudiencePublicBtn).get(0));
				}
				else if (audience_type.equalsIgnoreCase("Friends")){
					Reusables.clickUsingElement(Reusables.getElementsList(facebookAudienceFriendsBtn).get(1));
				}
				else if(audience_type.equalsIgnoreCase("Only Me")){
					Reusables.clickUsingElement(Reusables.getElementsList(facebookAudienceOnlyMeBtn).get(2));
				}
				Reusables.waitThread(2);
				verifySelectedAudienceType(audience_type, "Error Message!! Selected Audience type not matched..");
				Reusables.clickCommand(doneBtn);
			}
			catch(NoSuchElementException e){
				Logs.error("Error Message! Audience type not found>>>>>>>>>>>>> "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to share message on faceBook.
		 */
		public static void facebookShareMessage(){
			try{
				Reusables.waitForElement(facebookmsgtxtbox);
				Reusables.enterMessageInTextBox(facebookmsgtxtbox, DataConstants.facebook_post_message);
			}
			catch(NoSuchElementException e){
				Logs.error("Facebook text not visible. "+e.getClass().getName());
			}
		}

		
		//>>>>>>>>>>>>>>>>>>>>>> Settings >>>>>>>>>>>>>>>>>>>>>>>
		public static void clickOnSettingsButton(){
			try{
				Reusables.waitForElement(settings_btn);
				Reusables.clickCommand(settings_btn);
			}catch(NoSuchElementException e){
				Logs.error("Settings Button not found. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify Settings page loaded.
		 */
		public static void verifySettingsPageLoaded(){
			try{
				String pageHeaderName = Reusables.getText(subHeaderTxt);
				Reusables.verifyElementPresent(Reusables.getElement(By.name(pageHeaderName)), "Error Message!! Settings Page not loaded..");
			}catch(NoSuchElementException e){
				Logs.error(">>>> Settings Page not loaded. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to navigate to the settings page
		 */
		public static void navigateToSettingPage() {
			navigateToEvMenuPage();
			clickOnSettingsButton();
			verifySettingsPageLoaded();
		}
		
		/**
		 * This method is used to click on the change preference text view.
		 */
		public static void clickOnChangePreference(){
			try{
				Reusables.waitForElement(changePrefencesTxtView);
				Reusables.clickCommand(changePrefencesTxtView);
			}catch(NoSuchElementException e){
				Logs.error("preference text view not found. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * This method is used to navigate to the change preference page.
		 */
		public static void navigateToChangePreferencePage(){
			try{
				navigateToEvMenuPage();
				clickOnSettingsButton();
				verifySettingsPageLoaded();
				clickOnChangePreference();
				Reusables.waitThread(2);
			}catch(NoSuchElementException e){
				Logs.error("Change preference page not visible. "+e.getClass().getName());
			}
		}
	}
