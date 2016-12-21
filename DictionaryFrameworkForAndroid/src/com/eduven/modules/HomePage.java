package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import io.appium.java_client.android.*;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class HomePage {
	
	
	/* Locator identification */
	public static By minorbugsfixedalerttxt = By.id("android:id/message");
	public static By acceptalertpopup = By.id("android:id/button1");
	public static By appheadertxt = By.xpath("//android.widget.TextView[@text='Famous Actors and Movies' and @index='0']");//By.name(DataConstants.appName);
	public static By homeappheadertxt = By.name(DataConstants.appName);
	public static By homepagesearchboxicon = By.id(DeviceRelatedInformation.getPackageName()+":id/actionsearch");
	public static By homepageevMenuicon = By.xpath("//*[@content-desc='More options']");
	public static By homepagecaticon = By.id(DeviceRelatedInformation.getPackageName()+":id/catbox");
	public static By homepagecontributeicon = By.id(DeviceRelatedInformation.getPackageName()+":id/featurebox");//
	public static By homePageEduBankIcon = By.id(DeviceRelatedInformation.getPackageName()+":id/favbox");//:id/favbox
	public static By homePageQuizIcon = By.id(DeviceRelatedInformation.getPackageName()+":id/quiz_box");
	public static By homepagemoreAppsicon = By.id(DeviceRelatedInformation.getPackageName()+":id/moreapps");
	public static By addbannerimageview = By.id(DeviceRelatedInformation.getPackageName()+":id/adView");
	public static By searchheadertxt  = By.name(DataConstants.searchBoxHeaderTxt);
	public static By searchtxtbox = By.id(DeviceRelatedInformation.getPackageName()+":id/searching");
	public static By evMenupageheadertxt = By.name(DataConstants.evMenuTermTxt);
	public static By categorypageheadertxt= By.name(DataConstants.categoryHeaderTxt);
	public static By contributepageheadertxt = By.name(DataConstants.featureBoxHeaderTxt);
	public static By eduBankpagepopupmsg = By.name(DataConstants.eduBankEmptyPopUpMsg);
	public static By moreApppagetxt = By.id(DeviceRelatedInformation.getPackageName()+":id/moreappsAnimation");
	public static By quizpageheadertxt1 = By.name(DataConstants.quizHeaderTxt1);
	public static By quizpageheadertxt2 = By.name(DataConstants.quizHeaderTxt2);
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Search box instance.
	 */
	public static AndroidElement searchBoxInstance(){
		AndroidElement searchBoxelement = null;
		try{
			searchBoxelement = Reusables.getElement(homepagesearchboxicon);
		}
		catch(NoSuchElementException e){
			Logs.error(" Search box Icon not found  "+e.getClass().getName());
		}
		
		return searchBoxelement;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, EvMenu instance.
	 */
	public static AndroidElement evMenuInstance(){
		AndroidElement evMenuelement = null;
		try{
			evMenuelement = Reusables.getElement(homepageevMenuicon);
		}
		catch(NoSuchElementException e){
			Logs.error(" EvMenu Icon not found  "+e.getClass().getName());
		}
		
		return evMenuelement;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Category instance.
	 */
	public static AndroidElement categoryInstance(){
		AndroidElement catelement = null;
		try{
			catelement = Reusables.getElement(homepagecaticon);
		}
		catch(NoSuchElementException e){
			Logs.error(" Category Icon not found  "+e.getClass().getName());
		}
		
		return catelement;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, contribute instance.
	 */
	public static AndroidElement contributeInstance(){
		AndroidElement contributeelement = null;
		try{
			contributeelement = Reusables.getElement(homepagecontributeicon);
		}
		catch(NoSuchElementException e){
			Logs.error(" Contribute Icon not found  "+e.getClass().getName());
		}
		
		return contributeelement;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, EduBank instance.
	 */
	public static AndroidElement eduBankInstance(){
		AndroidElement eduBankelement = null;
		try{
			eduBankelement = Reusables.getElement(homePageEduBankIcon);
		}
		catch(NoSuchElementException e){
			Logs.error(" EduBank Icon not found  "+e.getClass().getName());
		}
		
		return eduBankelement;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, MoreApps instance.
	 */
	public static AndroidElement moreAppsInstance(){
		AndroidElement moreAppselement = null;
		try{
			moreAppselement = Reusables.getElement(homepagemoreAppsicon);
		}
		catch(NoSuchElementException e){
			Logs.error(" MoreApps Icon not found  "+e.getClass().getName());
		}
		
		return moreAppselement;
	}
	
	
	/**
	 * This method is used to return the AndroidElement instance.
	 * @return : Type AndroidElement, Quiz instance.
	 */
	public static AndroidElement quizInstance(){
		AndroidElement quizelement = null;
		try{
			quizelement = Reusables.getElement(homePageQuizIcon);
		}
		catch(NoSuchElementException e){
			Logs.error(" Quiz Icon not found  "+e.getClass().getName());
		}
		
		return quizelement;
	}

	
	/**
	 * This Method is used to verify home page header text.
	 */
	public static void verifyAppName(){
		try{
			Reusables.waitForElement(appheadertxt);
			Reusables.verifyEqualMessage(Reusables.getText(appheadertxt), DataConstants.homePageHeaderTxt, "Error Message!!! Home Page header txt not matched with expected ones.");
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
			Logs.error("Home Page search box icon not found..."+e.getClass().getName());
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
			Logs.error("Home Page EvMenu icon not found.."+e.getClass().getName());
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
			Logs.error("Home Page Category icon not found.."+e.getClass().getName());
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
			Logs.error("Home Page contibute icon not found.."+e.getClass().getName());
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
			Logs.error("Home Page eduBank icon not found.."+e.getClass().getName());
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
			Logs.error("Home Page moreApps icon not found.."+e.getClass().getName());
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
			Logs.error("Home Page Quiz icon not found.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Search Box Icon .
	 */
	public static void navigateToSearchBoxPage(){
		try{
			Reusables.waitForElement(homepagesearchboxicon);
			Reusables.clickUsingElement(searchBoxInstance());
			Reusables.waitForElement(searchtxtbox);
		}
		catch(NoSuchElementException e){
			Logs.error(" Click Operation not perform on Search Box "+e.getClass().getName());
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
			Logs.error(" Click Operation not perform on EvMenu Icon  "+e.getClass().getName());
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
			Logs.error(" Click Operation not perform on Category Icon  "+e.getClass().getName());
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
			Logs.error(" Click Operation not perform on FeatureBox Icon "+e.getClass().getName());
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
			Logs.error(" Click Operation not perform on EduBank Icon "+e.getClass().getName());
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
			Logs.error(" Click Operation not perform on MoreApps Icon "+e.getClass().getName());
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
			Logs.error(" Click Operation not perform on Quiz Icon "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for Search Box.
	 */
	public static void verifySearchBoxPageNavigation(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.getText(searchheadertxt), DataConstants.searchBoxHeaderTxt, "Error Message!! Not Navigate to the search box");
			Reusables.stepBack();
		}
		catch(NoSuchElementException e){
			Logs.error(" Not Navigate to the right page.. Search Box Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for EvMenu Page.
	 */
	public static void verifyEvMenuPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(evMenupageheadertxt), DataConstants.evMenuTermTxt, "Error Message!! Not Navigate to Ev Menu Page ");
		}
		catch(NoSuchElementException e){
			Logs.error(" Not Navigate to the right page.. EvMenu Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for Category Page.
	 */
	public static void verifyCategoryPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(categorypageheadertxt), DataConstants.categoryHeaderTxt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error(" Not Navigate to the right page..Category Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyFeaturePageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(contributepageheadertxt), DataConstants.featureBoxHeaderTxt, "Error Messagae!!Not Navigate to the Contribute page not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute page not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for EduBank Page.
	 */
	public static void verifyEduBankPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(eduBankpagepopupmsg), DataConstants.eduBankEmptyPopUpMsg, "Error Messagae!!Not Navigate to the right page EduBank Page");
		}
		catch(NoSuchElementException e){
			Logs.error(" Not Navigate to the right page..EduBank Page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for moreApps.
	 */
	public static void verifyMoreAppsPageNavigation(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(moreApppagetxt), "Error Messagae!! More Apps Page not open...");
		}
		catch(NoSuchElementException e){
			Logs.error(" Not Navigate to the right page.. More Apps "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for Quiz.
	 */
	public static void verifyQuizPageNavigation(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(quizpageheadertxt1) == true){
				Reusables.verifyEqualMessage(Reusables.getText(quizpageheadertxt1), DataConstants.quizHeaderTxt1, "Error Messagae!! Quiz Page not open");
			}
			else if (Reusables.isElementPresent(Reusables.getElement(quizpageheadertxt2)) == true){
				Reusables.verifyEqualMessage(Reusables.getText(quizpageheadertxt2), DataConstants.quizHeaderTxt2, "Error Messagae!! Quiz Page not open");
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Not Navigate to the Quiz Page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check ads popups visible or not.
	 */
	public static void verifyAds(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(addbannerimageview), "Error Message!! Ads banner not visible....");
		}
		catch(NoSuchElementException e){
			Logs.warn(" Ads popup not visible... "+e.getAdditionalInformation());
		}
	}
	
	/**
	 * This method is used to verify and handle the minor bug fixed alert popup.
	 */
	public static void handleMinorBugFixedAlertPopup(){
		try{
			Reusables.waitThread(3);
			if (Reusables.isElementPresent(minorbugsfixedalerttxt) == true){
				Reusables.verifyElementTextPresent(minorbugsfixedalerttxt, DataConstants.minorBugsTxt);
				Reusables.clickCommand(acceptalertpopup);
			}
			else if (Reusables.isElementPresent(minorbugsfixedalerttxt) == false){
			}
		}catch(NoSuchElementException e){
			Logs.warn("Minor Bug Fixed alert popup not appear. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the Home page.
	 */
	public static void backToHomePage(){
		try{
			while (!Reusables.checkElementVisibilityStatus(appheadertxt)){
				Reusables.stepBack();
				Reusables.hideInterstetial();
				Reusables.waitThread(2);
			}
		}catch(NoSuchElementException e){
			Logs.error("Home page not found. "+e.getClass().getName());
		}
	}
}
