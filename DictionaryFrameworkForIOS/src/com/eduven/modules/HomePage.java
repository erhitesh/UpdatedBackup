package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class HomePage {
	

	/* Object identification */
	public static By searchBtn = By.id("Search_button");
	public static By categoryBtn = By.id("Categories_button");
	public static By otherBtn = By.id("Other_button"); //timeLine for archery  time line
	public static By quizBtn = By.id("Quiz_button");
	public static By moreAppBtn = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]");//By.id("logo");
	public static By searchPageHeaderTxt  = By.id("Terms_Header");
	public static By categoryHeaderTxt= By.id(DataConstants.categoryHeaderTxt);
	public static By otherHeaderTxt = By.id(DataConstants.time_line_header_txt);
	public static By moreAppPageCloseBtn = By.id("close button");
	public static By quizPageHeaderTxt= By.id("Quiz_Header");
	public static By addBannerImageview = By.id("");
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, Search box instance.
	 */
	public static IOSElement searchBoxInstance(){
		IOSElement searchBox_element = null;
		try{
			searchBox_element = Reusables.getIOSElement(searchBtn);}
		catch(NoSuchElementException e){
			Logs.error("Search box Icon not found. "+e.getClass().getName());
		}
		return searchBox_element;
	}
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, Category instance.
	 */
	public static IOSElement categoryInstance(){
		IOSElement cat_element = null;
		try{
			cat_element = Reusables.getIOSElement(categoryBtn);}
		catch(NoSuchElementException e){
			Logs.error("Category Button not found. "+e.getClass().getName());
		}
		
		return cat_element;
	}
	
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, FeatureBox instance.
	 */
	public static IOSElement optionalElement(){
		IOSElement featureBox_element = null;
		try{
			featureBox_element = Reusables.getIOSElement(otherBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Time Line Icon not found>>>  "+e.getClass().getName());
		}
		
		return featureBox_element;
	}
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, MoreApps instance.
	 */
	public static IOSElement moreAppsInstance(){
		IOSElement moreApps_element = null;
		try{
			moreApps_element = Reusables.getIOSElement(moreAppBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("MoreApps Icon not found. "+e.getClass().getName());
		}
		
		return moreApps_element;
	}
	
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, Quiz instance.
	 */
	public static IOSElement quizInstance(){
		IOSElement quiz_element = null;
		try{
			quiz_element = Reusables.getIOSElement(quizBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Quiz Icon not found. "+e.getClass().getName());
		}
		
		return quiz_element;
	}
	
	/**
	 * This Method is used to verify home page search box.
	 */
	public static void verifyHomePageSearchBoxIcon(){
		try{
			Reusables.verifyElementPresent(searchBoxInstance(), "Error Message!!! Home Page search box icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Home Page search box icon not found. "+e.getClass().getName());
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
			Logs.error("Home Page Category icon not found..>>"+e.getClass().getName());
		}
	}
	
	
	/**
	 * This Method is used to verify home page Time Line icon.
	 */
	public static void verifyHomePageOptionalIcon(){
		try{
			Reusables.verifyElementPresent(optionalElement(), "Error Message!!! Home Page optional icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Home Page Time Line icon not found..>>"+e.getClass().getName());
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
			Logs.error("Home Page moreApps icon not found..>>"+e.getClass().getName());
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
	public static void NavigateToSearchBoxPage(){
		try{
			Reusables.clickUsingIOSElement(searchBoxInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on Search Box>> "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Category Icon .
	 */
	public static void NavigateToCategoryPage(){
		try{
			Reusables.clickUsingIOSElement(categoryInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on Category Icon >> "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Feature Box Icon.
	 */
	public static void NavigateToFeatureBoxPage(){
		try{
			Reusables.clickUsingIOSElement(optionalElement());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on FeatureBox Icon "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the MoreApps Icon.
	 */
	public static void NavigateToMoreAppsPage(){
		try{
			Reusables.clickUsingIOSElement(moreAppsInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>>> Click Operation not perform on MoreApps Icon "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Quiz Icon.
	 */
	public static void NavigateToQuizPage(){
		try{
			Reusables.clickUsingIOSElement(quizInstance());
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
			Reusables.verifyEqualMessage(Reusables.getText(searchPageHeaderTxt), DataConstants.searchHeaderTxt, "Error Message!! Not Navigate to the search box");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. Search Box Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for Category Page.
	 */
	public static void verifyCategoryPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(categoryHeaderTxt), DataConstants.categoryHeaderTxt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page..Category Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyTimeLinePageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(otherHeaderTxt), DataConstants.time_line_header_txt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page..Time Line Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify right navigation for moreApps.
	 */
	public static void verifyMoreAppsPageNavigation(){
		try{
			Reusables.waitForIOSElement(moreAppPageCloseBtn);
			Reusables.verifyElementPresent(Reusables.getIOSElement(moreAppPageCloseBtn), "Error Messagae!! More Apps Page not open...");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. More Apps "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to close the more apps page.
	 */
	public static void closeMoreAppsPage(){
		try{
			Reusables.waitForIOSElement(moreAppPageCloseBtn);
			Reusables.clickCommand(moreAppPageCloseBtn);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> More Apps Page Still Visible.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation for Quiz.
	 */
	public static void verifyQuizPageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(quizPageHeaderTxt), DataConstants.quizHeaderTxt, "Error Messagae!! Quiz Page not open");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Not Navigate to the right page.. Quiz "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to check ads Pop up visible or not.
	 */
	public static void verifyAds(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(addBannerImageview), "Error Message!! Ads banner not visible....");
		}
		catch(NoSuchElementException e){
			Logs.warn(">>>>>>>>>>>>>>>>>>> Ads popup not visible... "+e.getAdditionalInformation());
		}
	}

	
}
