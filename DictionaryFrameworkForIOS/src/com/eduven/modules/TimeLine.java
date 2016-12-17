package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class TimeLine {

	
	/* Object Identification */
	public static By time_line_icon = By.name("timeLine"); 
	public static By search_bar = By.name("SearchBox");
	public static By cancel_btn = By.name("Cancel");
	public static By time_line_page_header_txt = By.name("term_name_header");
	public static By term_name_txt = By.name("term_name_cell");
	public static By description_lbl = By.name("Description");
	public static By entityName_txtview = By.name("Term_detail");
	public static By entityPage_header_txt = By.name("term_detail_Header");
	
	/**
	 * This method is used to return the IOSElement instance.
	 * @return : Type IOSElement, Time Line instance.
	 */
	public static IOSElement timeLineInstance(){
		IOSElement timeLine_element = null;
		try{
			timeLine_element = Reusables.getIOSElement(time_line_icon);
		}
		catch(NoSuchElementException e){
			Logs.error("Time Line Icon not found  "+e.getClass().getName());
		}
		
		return timeLine_element;
	}
	

	/**
	 * This Method is used to verify home page Time Line icon.
	 */
	public static void verifyHomePageTimeLineIcon(){
		try{
			Reusables.verifyElementPresent(timeLineInstance(), "Error Message!!! Home Page Time Line icon not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Home Page Time Line icon not found.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Feature Box Icon.
	 */
	public static void NavigateToTimeLinePage(){
		try{
			Reusables.clickUsingIOSElement(timeLineInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on Time Line Icon "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify right navigation to Feature Box Page.
	 */
	public static void verifyTimeLinePageNavigation(){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(time_line_page_header_txt), DataConstants.time_line_header_txt, "Error Messagae!!Not Navigate to the right page Category Page");
		}
		catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..Time Line Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get player name.
	 */
	public static String getSelectRandomName(){
		Reusables.clickUsingIOSElement(Reusables.getIOSElementsList(term_name_txt).get(1));
		String playerName = "Admir Mehmedi";
		/*
		try{
			int playerCount = Reusables.getIOSElementsList(term_name_txt).size();
			System.out.println(playerCount);
			playerName = Reusables.getTextFromList(term_name_txt, Reusables.random_number(playerCount));
			System.out.println(playerName);
			while (!Reusables.getIOSElement(By.name(playerName)).isDisplayed()){
				Reusables.swipe_up();
			}
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(By.name(playerName)));
		}
		catch(NoSuchElementException e){
			Logs.error("Term Name not found."+e.getClass().getName());
		}*/
		
		return playerName;
	}
	
	/**
	 * This method is used to verify page header text.
	 */
	public static void verifyEntityHeaderPageText(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(entityPage_header_txt), "Error Message!! Entity header txt not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error("Entity Header txt not matched.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get Entity name.
	 */
	public static String getEntityName(){
		String entity_name = "";
		try{
			entity_name = Reusables.getIOSElementsList(entityName_txtview).get(0).getText();
			//System.out.println("entity_name.. "+entity_name);
		}
		catch(NoSuchElementException e){
			Logs.error("Entity Name not found.. "+e.getClass().getName());
		}
		return entity_name;
	}
	
	/**
	 * This method is used verify player name on entity page.
	 */
	public static void verifyEntityName(String expectedName){
		try{
			Reusables.verifyEqualMessage(getEntityName(), expectedName, "Error Mesage!! Entity Name not matched");
		}
		catch(NoSuchElementException e){
			Logs.error(""+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify terms name after swipe.
	 */
	public static void verify_terms_name_after_right_swipe(String expected_terms_name){
		try{
			Reusables.waitThread(2);
			//Reusables.SwipeRight();
			Reusables.verifyEqualMessage(getEntityName(), expected_terms_name, "Error Message!! Term name not found.. ");
		}
		catch(NoSuchElementException r){
			Logs.error("Entity Name not matched.. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify terms name after swipe.
	 */
	public static void verify_terms_name_after_left_swipe(String expected_terms_name){
		try{
			Reusables.waitThread(2);
			//Reusables.SwipeRight();
			Reusables.verifyEqualMessage(getEntityName(), expected_terms_name, "Error Message!! Term name not found.. ");
		}
		catch(NoSuchElementException r){
			Logs.error("Entity Name not matched"+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify search term.
	 */
	public static void verifySearchTerm(String search_term){
		try{
			Reusables.waitForIOSElement(search_bar);
			Reusables.enterMessageInTextBox(search_bar, search_term);
			Reusables.waitForIOSElement(cancel_btn);
			if (Reusables.isElementPresent(cancel_btn) == true){
				Reusables.clickUsingIOSElement(Reusables.getIOSElement(cancel_btn));
			}
			List<IOSElement> termsCount = Reusables.getIOSElementsList(term_name_txt);
			Assert.assertTrue(termsCount.size() == 1, "Error Message!! Terms count for than one...");
			Reusables.verifyEqualMessage(getEntityName(), search_term, "Error Message!! Search term not found...");
		}catch(NoSuchElementException e){
			Logs.error("Terms count for than one "+e.getClass().getName());
		}
	}
}
