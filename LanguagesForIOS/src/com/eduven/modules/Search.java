package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Search {
	
	
	/* Object Identification */
	public static By searchBtn = By.id("search");
	public static By searchHeaderTxt = By.id("SearchHeader");
	public static By searchBarEle = By.id("SearchPlaceholder");
	public static By searchList = By.id("SearchList");
	public static By submitSearchBtn = By.name("Done");
	public static By selectSearchWord = By.xpath("//UIATableCell");
	
	public static By searchWordNameTxt = By.id("TermName");
	public static By phoenticsNameTxt = By.id("PhoenticsName");
	public static By translationNameTxt = By.id("TranslationName");
	public static By audioBtn = By.id("spk1");
	
	
	/**
	 * This method is used to click on the search button.
	 */
	public static void NavigateToSearchPage(){
		try{
			Reusables.waitThread(3);
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
		ArrayList<String> list = new ArrayList<String>();
		String termName = "";
		String expectedTermName = "";
		String randomCategory = "";
		try{
			Reusables.waitThread(1);
			Reusables.waitForElement(searchBarEle);
		    randomCategory = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue).get(Reusables.randomNumber(DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue).size()));
			if (termType.equalsIgnoreCase("unlock")){
				termName = DatabaseConnection.getUnLockTerm(randomCategory, LanguageCategoryPage.languageSelectionValue);
			}
			else if (termType.equalsIgnoreCase("lock")){
				termName = DatabaseConnection.getLockTerm(randomCategory, LanguageCategoryPage.languageSelectionValue);
			}
		    //termName = termName.replace("'", "''");
		    //System.out.println("Term Name.."+termName);
			Reusables.enterTextUsingKeyBoard(termName, searchBarEle);
			expectedTermName = termName+" ["+randomCategory+"-"+LanguageCategoryPage.languageSelectionValue+"]";
		}catch(NoSuchElementException e){
			Logs.error("Search bar box not found. "+e.getClass().getName());
		}
		list.add(termName);//.replaceAll("''", "'"));
		list.add(expectedTermName);//.replaceAll("''", "'"));
		
		return list;
	}
	
	
	/**
	 * This method is used to submit search word.
	 */
	public static void submitSearchWord(){
		try{
			Reusables.waitAndClick(submitSearchBtn);
		}catch(NoSuchElementException e){
			Logs.error("Search word not found. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to click on related search word.
	 * @param wordMatching : For matching correct search.
	 */
	public static void selectSearchWord(String wordMatching){
		List<IOSElement> searchlist;
		try{
			By selectWord = By.xpath("//*[starts-with(@name,'"+wordMatching+"')][1]");
			Reusables.waitThread(2);
			searchlist = Reusables.getElementsList(searchList);
			for (IOSElement ele : searchlist){
				System.out.println("Search Name."+ele.getText());
				if (ele.getText().equalsIgnoreCase(wordMatching)){
					ele.click();
				}
			}
			//Reusables.clickCommand(selectWord);
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
			if (Reusables.isElementPresent(EntityDetailPage.allFunctionalityBtn) == true){
			}
			else if (Reusables.isElementPresent(EntityDetailPage.allFunctionalityBtn) == false){
				Reusables.waitForIosElement(Reusables.getElement(searchWordNameTxt));
				Reusables.verifyEqualMessage(getWordName(), expectedWordName, "Error Message!! Actual Search word name not matched with expected ones.");
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
			Reusables.clickCommand(audioBtn);
		}catch(NoSuchElementException e){
			Logs.error("Audio button not clickable. "+e.getClass().getName());
		}
	}

}
