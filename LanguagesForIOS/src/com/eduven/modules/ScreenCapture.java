package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class ScreenCapture {
	
	
	/* Object Identification */
	public static By languageCount = By.name("LanguageCount");
	public static By categoryList = By.name("CategoryList");
	public static By termNameTxt = By.name("TermName");
	public static By addFavBtn = By.id("AddFavourite");
	public static By eduBankHeaderTxt = By.name("EduBankHeader");
	
	/**
	 * This method is used to take screenshot of the failed test case.
	 * @param name: name of the language.
	 * @param screenshotNumbering : for identifing screenshot.
	 * @throws IOException 
	 */
	public static void takesScreenShotCapture(int screenshotNumbering, String languageName){
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/LanguagesForIOS/ScreenCaptures/"+DataConstants.appName+"/"+languageName+"/";
		File src_file = ((TakesScreenshot) Reusables.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src_file, new File(screenshot_lacation+languageName+"_"+screenshotNumbering+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
	
	
	
	public static String switchLingo(int indexValue){
		String languageValue = "";
		try{
			if (Reusables.isElementPresent(SwitchLingo.switchLingoHeaderTxt) == true){
				List<IOSElement> languageList = Reusables.getElementsList(languageCount);
				System.out.println("Language List Size.."+languageList.size()+"First index value..."+languageList.get(0).getText());
				languageValue = DatabaseConnection.getLanguageNameCorresSwitchLingo(DatabaseConnection.convertToUTF8(languageList.get(indexValue).getText())).toLowerCase();
				System.out.println("Language Name.."+languageValue);
				languageList.get(indexValue).click();
				Reusables.waitThread(1);
				//Reusables.clickUsingElement(languageList.get(indexValue));
			}
		}catch(NoSuchElementException e){
			Logs.error("Unable to perform switch lingo operation. "+e.getClass().getName());
		}
		
		return languageValue;
	}
	
	public static void createFolders(List<String> folderList){
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/LanguagesForIOS/ScreenCaptures/";
		File file = new File(screenshot_lacation);
		if (file.exists() == true){
		}
		else if (file.exists() == false){
			file.mkdir();
		}
		//Create App Name folder
		File appNameFolder = new File(screenshot_lacation+DataConstants.appName+"/");
		if (appNameFolder.exists() == true){
		}
		else if (appNameFolder.exists() == false){
			appNameFolder.mkdir();
		}
		// Create language name folder inside app.
		for (int i = 0; i < folderList.size(); i++){
			File appLanguageName = new File(appNameFolder+"/"+folderList.get(i)+"/");
			if (appLanguageName.exists() == true){
			}
			else if (appLanguageName.exists() == false){
				appLanguageName.mkdir();
			}
		}
	}

	/**
	 * This method is used to click on the random number 
	 * @param categoryIndex : passing the index number for selecting category name.
	 * @return : String, category name.
	 */
	public static String clickOnCategory(int categoryIndex){
		String randomName = "";
		try{
			Reusables.waitThread(5);
			List<IOSElement> mainCatList = Reusables.getElementsList(categoryList);
		    randomName = mainCatList.get(categoryIndex).getText();
		    System.out.println("Main Category Name..>"+randomName);
			mainCatList.get(categoryIndex).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on random name. "+e.getClass().getName());
		}
		
		return randomName;
	}
	
	
	/**
	 * This method is used to click on the random number 
	 * @return : String, as random name.
	 */
	public static String clickOnRandomCategory(){
		String randomName = "";
		int randomNumber = 0;
		try{
			Reusables.waitThread(5);
			List<IOSElement> mainCatList = Reusables.getElementsList(categoryList);
		    randomNumber = Reusables.randomNumber(mainCatList.size()-1);
		    randomName = mainCatList.get(randomNumber).getText();
		    System.out.println("Category Name..>"+randomName);
		    mainCatList.get(randomNumber).click();
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on random name. "+e.getClass().getName());
		}
		
		return randomName;
	}
	
	/**
	 * This method is used to click on the term name 
	 * @return : String, as random name.
	 */
	public static String clickOnTermNameAndEdubank(int termIndex){
		String randomName = "";
		try{
			Reusables.waitThread(5);
			//List<IOSElement> termList = Reusables.getElementsList(termNameTxt);
			List<IOSElement> eduBankList = Reusables.getElementsList(addFavBtn);
			//termList.get(termIndex).click();
			Reusables.waitThread(2);
			eduBankList.get(termIndex).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on random name. "+e.getClass().getName());
		}
		return randomName;
	}
	
	/**
	 * This method is used to remove all added term name from EduBank.
	 */
	public static void removeAllTermFromEduBank(){
		try{
			//List<IOSElement> favoriteBtns = Reusables.getElementsList(addFavBtn);
			while (Reusables.getElementsList(eduBankHeaderTxt).size() > 0){
				Reusables.getElementsList(addFavBtn).get(Reusables.getElementsList(addFavBtn).size()-1).click();
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Add Favorite Button is still visible. "+e.getClass().getName());
		}
	}
}
