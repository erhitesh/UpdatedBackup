package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class HomePage {
	
	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator identification */
	public static By minor_bugs_fixed_alert_txt = By.id("android:id/message");
	public static By accept_alert_popup = By.id("android:id/button1");
	public static By app_header_txt = By.name(DataConstants.appName);
	public static By home_app_header_txt = By.name(DataConstants.appName);
	public static By home_page_search_box_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/action_search");
	public static By home_page_evMenu_icon = By.xpath("//*[@content-desc='More options']");
	public static By home_page_cat_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/cat_box");
	public static By home_page_contribute_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/feature_box");//
	public static By home_page_eduBank_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/fav_box");//:id/fav_box
	public static By home_page_quiz_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/quiz_box");
	public static By home_page_moreApps_icon = By.id(DeviceRelatedInformation.getPackageName()+":id/moreapps");
	public static By add_banner_imageview = By.id(DeviceRelatedInformation.getPackageName()+":id/adView");
	public static By search_header_txt  = By.name(DataConstants.searchBoxHeaderTxt);
	public static By search_txt_box = By.id(DeviceRelatedInformation.getPackageName()+":id/searching");
	public static By evMenu_page_header_txt = By.name(DataConstants.evMenuTermTxt);
	public static By category_page_header_txt= By.name(DataConstants.categoryHeaderTxt);
	public static By contribute_page_header_txt = By.name(DataConstants.feature_box_header_txt);
	public static By eduBank_page_popup_msg = By.name(DataConstants.eduBankEmptyPopUpMsg);
	public static By moreApp_page_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
	public static By quiz_page_header_txt1 = By.name(DataConstants.quizHeaderTxt1);
	public static By quiz_page_header_txt2 = By.name(DataConstants.quizHeaderTxt2);
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Search box instance.
	 */
	public static AndroidElement searchBoxInstance(){
		AndroidElement searchBox_element = null;
		try{
			searchBox_element = Reusables.getElement(home_page_search_box_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Search box Icon not found>>>  "+e.getClass().getName());
		}
		
		return searchBox_element;
	}
	
	
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
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Category instance.
	 */
	public static AndroidElement categoryInstance(){
		AndroidElement cat_element = null;
		try{
			cat_element = Reusables.getElement(home_page_cat_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Category Icon not found>>>  "+e.getClass().getName());
		}
		
		return cat_element;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, contribute instance.
	 */
	public static AndroidElement contributeInstance(){
		AndroidElement contribute_element = null;
		try{
			contribute_element = Reusables.getElement(home_page_contribute_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Contribute Icon not found>>>  "+e.getClass().getName());
		}
		
		return contribute_element;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, EduBank instance.
	 */
	public static AndroidElement eduBankInstance(){
		AndroidElement eduBank_element = null;
		try{
			eduBank_element = Reusables.getElement(home_page_eduBank_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> EduBank Icon not found>>>  "+e.getClass().getName());
		}
		
		return eduBank_element;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, MoreApps instance.
	 */
	public static AndroidElement moreAppsInstance(){
		AndroidElement moreApps_element = null;
		try{
			moreApps_element = Reusables.getElement(home_page_moreApps_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> MoreApps Icon not found>>>  "+e.getClass().getName());
		}
		
		return moreApps_element;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Quiz instance.
	 */
	public static AndroidElement quizInstance(){
		AndroidElement quiz_element = null;
		try{
			quiz_element = Reusables.getElement(home_page_quiz_icon);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Quiz Icon not found>>>  "+e.getClass().getName());
		}
		
		return quiz_element;
	}

	
	/**
	 * This Method is used to verify home page header text.
	 */
	public static void verifyAppName(){
		try{
			Reusables.waitForElement(app_header_txt);
			Reusables.verifyEqualMessage(Reusables.getText(app_header_txt), DataConstants.homePageHeaderTxt, "Error Message!!! Home Page header txt not matched with expected ones.");
		}
		catch(NoSuchElementException e){
			Logs.error("Home Page header txt not matched with expected ones. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This Method is used to verify home page search box.
	 */
	public static void verifyHomePageSearchBoxIcon(){
		try{
			Reusables.verifyElementPresent(searchBoxInstance(), "Error Message!!! Home Page search box icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page search box icon not found...>>"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This Method is used to verify home page evMenu icon.
	 */
	public static void verifyHomePageEvMenuIcon(){
		try{
			Reusables.verifyElementPresent(evMenuInstance(), "Error Message!!! Home Page evMenu icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page EvMenu icon not found..>>"+e.getClass().getName());
		}
	}
	
	/**
	 * This Method is used to verify home page Category icon.
	 */
	public static void verifyHomePageCategoryIcon(){
		try{
			Reusables.verifyElementPresent(categoryInstance(), "Error Message!!! Home Page Category icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page Category icon not found..>>"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This Method is used to verify home page contibute icon.
	 */
	public static void verifyHomePageContributeIcon(){
		try{
			Reusables.verifyElementPresent(contributeInstance(), "Error Message!!! Home Page contibute icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page contibute icon not found..>>"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This Method is used to verify home page eduBank icon.
	 */
	public static void verifyHomePageEduBankIcon(){
		try{
			Reusables.verifyElementPresent(eduBankInstance(), "Error Message!!! Home Page EduBank icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page eduBank icon not found..>>"+e.getClass().getName());
		}
	}
	
	/**
	 * This Method is used to verify home page moreApps icon.
	 */
	public static void verifyHomePageMoreAppsIcon(){
		try{
			Reusables.verifyElementPresent(moreAppsInstance(), "Error Message!!! Home Page moreApps icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page moreApps icon not found..>>"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This Method is used to verify home page Quiz icon.
	 */
	public static void verifyHomePageQuizIcon(){
		try{
			Reusables.verifyElementPresent(quizInstance(), "Error Message!!! Home Page Quiz icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>>Home Page Quiz icon not found..>>"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Search Box Icon .
	 */
	public static void navigateToSearchBoxPage(){
		try{
			Reusables.waitForElement(home_page_search_box_icon);
			Reusables.clickUsingElement(searchBoxInstance());
			Reusables.waitForElement(search_txt_box);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on Search Box>> "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EvMenu Icon .
	 */
	public static void navigateToEvMenuPage(){
		try{
			Reusables.clickUsingElement(evMenuInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on EvMenu Icon >> "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Category Icon .
	 */
	public static void navigateToCategoryPage(){
		try{
			Reusables.clickUsingElement(categoryInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on Category Icon >> "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Feature Box Icon.
	 */
	public static void navigateToFeatureBoxPage(){
		try{
			Reusables.clickUsingElement(contributeInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on FeatureBox Icon "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EduBank Icon.
	 */
	public static void navigateToEduBankPage(){
		try{
			Reusables.clickUsingElement(eduBankInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on EduBank Icon "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the MoreApps Icon.
	 */
	public static void navigateToMoreAppsPage(){
		try{
			Reusables.clickUsingElement(moreAppsInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on MoreApps Icon "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Quiz Icon.
	 */
	public static void navigateToQuizPage(){
		try{
			Reusables.clickUsingElement(quizInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on Quiz Icon "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for Search Box.
	 */
	public static void verifySearchBoxPageNavigation(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.getText(search_header_txt), DataConstants.searchBoxHeaderTxt, "Error Message!! Not Navigate to the search box");
			Reusables.stepBack();
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. Search Box Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for EvMenu Page.
	 */
	public static void verifyEvMenuPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(evMenu_page_header_txt), DataConstants.evMenuTermTxt, "Error Message!! Not Navigate to Ev Menu Page ");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. EvMenu Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for Category Page.
	 */
	public static void verifyCategoryPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(category_page_header_txt), DataConstants.categoryHeaderTxt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page..Category Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyFeaturePageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(contribute_page_header_txt), DataConstants.feature_box_header_txt, "Error Messagae!!Not Navigate to the Contribute page not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">Contribute page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for EduBank Page.
	 */
	public static void verifyEduBankPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(eduBank_page_popup_msg), DataConstants.eduBankEmptyPopUpMsg, "Error Messagae!!Not Navigate to the right page EduBank Page");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page..EduBank Page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for moreApps.
	 */
	public static void verifyMoreAppsPageNavigation(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(moreApp_page_txt), "Error Messagae!! More Apps Page not open...");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. More Apps "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for Quiz.
	 */
	public static void verifyQuizPageNavigation(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(quiz_page_header_txt1) == true){
				Reusables.verifyEqualMessage(Reusables.getText(quiz_page_header_txt1), DataConstants.quizHeaderTxt1, "Error Messagae!! Quiz Page not open");
			}
			else if (Reusables.isElementPresent(Reusables.getElement(quiz_page_header_txt2)) == true){
				Reusables.verifyEqualMessage(Reusables.getText(quiz_page_header_txt2), DataConstants.quizHeaderTxt2, "Error Messagae!! Quiz Page not open");
			}
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>Not Navigate to the Quiz Page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check ads popups visible or not.
	 */
	public static void verifyAds(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(add_banner_imageview), "Error Message!! Ads banner not visible....");
		}
		catch(NoSuchElementException e){
			Logs.warn(">>>>>>>>>>>>>>>>>>> Ads popup not visible... "+e.getAdditionalInformation());
		}
	}
	
	/**
	 * This method is used to verify and handle the minor bug fixed alert popup.
	 */
	public static void handleMinorBugFixedAlertPopup(){
		try{
			Reusables.waitThread(3);
			if (Reusables.isElementPresent(minor_bugs_fixed_alert_txt) == true){
				Reusables.verifyElementTextPresent(minor_bugs_fixed_alert_txt, DataConstants.minorBugsTxt);
				Reusables.clickCommand(accept_alert_popup);
			}
			else if (Reusables.isElementPresent(minor_bugs_fixed_alert_txt) == false){
			}
		}catch(NoSuchElementException e){
			Logs.warn("Minor Bug Fixed alert popup not appear. "+e.getClass().getName());
		}
	}
}
