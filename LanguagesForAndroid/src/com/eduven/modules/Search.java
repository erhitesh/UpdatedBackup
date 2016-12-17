package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Search {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By searchBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/action_search");
	public static By searchHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By searchBarEle = By.id(DeviceRelatedInformation.getPackageName()+":id/et_search_text");
	public static By selectSearchWord = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_game_name");
	public static By searchWordNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_title");
	public static By audioBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_audio");
	public static By unlockNowBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_upgrade");
	
	
	/**
	 * This method is used to click on the search button.
	 */
	public static void NavigateToSearchPage(){
		try{
			Reusables.waitForElement(searchBtn);
			Reusables.clickCommand(searchBtn);
		}catch(NoSuchElementException e){
			Logs.error("Search Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify search header text.
	 */
	public static void verifySearchHeaderTxt(){
		try{
			Reusables.waitForElement(searchHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(searchHeaderTxt), "Error Message!! Search Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Search Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to enter text in search bar box.
	 * @return String as term name.
	 * @param termType : for lock or unlock term.
	 */
	public static ArrayList<String> searchWord(String termType){
		String termName = "";
		String expectedTermName = "";
		String randomCategory = "";
		ArrayList<String> list = new ArrayList<String>();
		try{
			Reusables.waitForElement(searchBarEle);
			randomCategory = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue).get(Reusables.randomNumber(DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue).size()));
			if (termType.equalsIgnoreCase("unlock")){
				termName = DatabaseConnection.getUnLockTerm(randomCategory, LanguageCategoryPage.languageSelectionValue);
			}
			else if (termType.equalsIgnoreCase("lock")){
				termName = DatabaseConnection.getLockTerm(randomCategory, LanguageCategoryPage.languageSelectionValue);
			}
			Reusables.enterMessageInTextBox(searchBarEle, termName);
			expectedTermName = termName+" [English - "+randomCategory.toUpperCase()+"]";
		}catch(NoSuchElementException e){
			Logs.error("Search bar box not found. "+e.getClass().getName());
		}
		//System.out.println("Expected Term Name.."+expectedTermName);
		list.add(termName);
		list.add(expectedTermName);
		
		return list;
	}
	
	
	/**
	 * This method is used to click on related search word.
	 * @param wordMatching : For matching correct search.
	 */
	public static void selectSearchWord(String wordMatching){
		try{
			Reusables.waitThread(1);
			List<AndroidElement> searchWordList = Reusables.getElementsList(selectSearchWord);
			for (int i = 0; i < searchWordList.size(); i++){
				//System.out.println("Text.."+searchWordList.get(i).getText());
				if (searchWordList.get(i).getText().equalsIgnoreCase(wordMatching)){
					searchWordList.get(i).click();
					Reusables.waitThread(1);
					break;
				}
				else{
				}
			}
			/*Reusables.waitThread(2);
			Reusables.clickUsingElement(Reusables.getElementsList(selectSearchWord).get(0));*/
		}catch(NoSuchElementException e){
			Logs.error("Search word related word not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get word name on search page.
	 * @return : String
	 */
	public static String getWordName(){
		String search_name = "";
		try{
			search_name = Reusables.getElement(searchWordNameTxt).getText().toString().trim();
		}catch(NoSuchElementException e){
			Logs.error("Word name not found. "+e.getClass().getName());
		}
		
		return search_name;
	}
	
	/**
	 * This method is used to verify search word.
	 */
	public static void verifySearchWord(String expectedWordName){
		try{
			if (Reusables.isElementPresent(unlockNowBtn) == true){
				Reusables.verifyElementPresent(Reusables.getElement(unlockNowBtn), "Error Message!!Payment page not visible.");
				Reusables.stepBack();
			}
			else if (Reusables.isElementPresent(unlockNowBtn) == false){
				Reusables.waitForAndroidElement(Reusables.getElement(searchWordNameTxt));
				Reusables.verifyElementTextPresent(searchWordNameTxt, expectedWordName);
			}	
		}catch(NoSuchElementException e){
			Logs.error("Actual Search word name not matched with expected ones. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to start audio.
	 */
	public static void startAudio(){
		try{
			Reusables.waitThread(1);
			Reusables.clickCommand(audioBtn);
		}catch(NoSuchElementException e){
			Logs.error("Audio button not clickable. "+e.getClass().getName());
		}
	}

}
