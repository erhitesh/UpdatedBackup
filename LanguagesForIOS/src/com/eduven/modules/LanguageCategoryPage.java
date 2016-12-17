package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class LanguageCategoryPage {
	

	/* Global Declaration */
	static String languageSelectionValue;
	
	/* Object Identification */
	public static By appName = By.id("AppName");
	public static By languageCount = By.id("LanguageCount");
	public static By doneBtn = By.id("Done");
	public static By selectBaseLanguageTxt = By.id("Select Base Language");
	public static By categoryHeaderTxt = By.id("CategoryHeader");

 
	/**
	 * This method is used to wait for download base and target language.
	 */
	public static void waitForDownloadBaseAndTargetLanguage(){
		try{
			Reusables.waitThread(2);
			while (Reusables.isElementPresent(doneBtn) == true){
				Reusables.waitThread(10);
				if (Reusables.isElementPresent(doneBtn) == false)
					break;
			}
		}catch(NoSuchElementException e){
			Logs.error("Done Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to handle download image popup.
	 */
	public static void handleDownloadImagePopoup(){
		try{
			Reusables.waitThread(2);
			if (Reusables.alertInstance() != null){
				Reusables.dismissAlert();
				Reusables.waitThread(1);
			}
			else if (Reusables.alertInstance() == null){
			}
		}catch(NoSuchElementException e){
			Logs.error("Download images and laern easily! popup not found. "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to select random language from given list.
	 * @return : String, as selected name.
	 */
	public static String langugeSelection(){
		int number = 0;
		try{
			Reusables.waitThread(3);
			if (Reusables.isElementPresent(selectBaseLanguageTxt) == true){
				List<IOSElement> languageList = Reusables.getElementsList(languageCount);
				for (int i = 0; i < languageList.size(); i++){
					if (languageList.get(i).getText().equals("ENGLISH")){
						languageSelectionValue = languageList.get(i).getText().toLowerCase();
						Reusables.clickUsingElement(languageList.get(i));
					}
				}
				//waitForDownloadBaseAndTargetLanguage();
				handleDownloadImagePopoup();
				}
			else if (Reusables.isElementPresent(SwitchLingo.switchLingoHeaderTxt) == true){
				number = Reusables.randomNumber(Reusables.getElementsList(languageCount).size());
				List<IOSElement> languageList = Reusables.getElementsList(languageCount);
				languageSelectionValue = DatabaseConnection.getLanguageNameCorresSwitchLingo(languageList.get(number).getText()).toLowerCase();
				Reusables.clickUsingElement(languageList.get(number));
			}
			else if (Reusables.isElementPresent(selectBaseLanguageTxt) == false){
				Reusables.waitForIosElement(Reusables.getElement(categoryHeaderTxt));
				}
			}
		catch(NoSuchElementException e){
			Logs.error("Unable to change the base language. "+e.getClass().getName());
			}
		
		return languageSelectionValue;
		
		}
	
	public static List<String> languageNameListValue(){
		ArrayList<String> list = new ArrayList<String>();
		try{
			List<IOSElement> countList = Reusables.getElementsList(languageCount);
			for (int i = 0; i < countList.size(); i++){
				list.add(countList.get(i).getText());
			}
		}catch(NoSuchElementException e){
			Logs.error(""+e.getClass().getName());
		}
		
		return list;
	}
	}
