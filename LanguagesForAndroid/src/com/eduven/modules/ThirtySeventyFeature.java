package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class ThirtySeventyFeature {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	
	/**
	 * This method is used to get term page header text.
	 * @return termheadertxt as string
	 */
	public static String getTermPageHeaderTxt(){
		String termHeaderName = "";
		try{
			Reusables.waitThread(1);
			termHeaderName = Reusables.getElement(TermList.termListHeaderTxt).getText();
		}catch(NoSuchElementException e){
			Logs.error("Term Page Header not found. "+e.getClass().getName());
		}
		
		return termHeaderName;
	}
	
	
	/**
	 * This method is used to verify thirty percentage feature.
	 */
	public static void checkThirtyPercentageUnlockTerm() {
		List<String> categorylist;
		List<String> fiftyPercentOfUnlockTermList;
		String categoryName = "";
		int fiftyPercentOfUnlockTermCount = 0;
		int unlockTermCount = 0;
		int thirtyPercentOfTotal = 0;
		int thirtyPercent = 0;
		List<AndroidElement> termListCat;
		try{
			categorylist = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue);
			for (int i = 0; i < categorylist.size(); i++){
				categoryName = categorylist.get(i);
				if (Reusables.isElementPresent(By.name(categoryName)) == false){
					List<AndroidElement> list = Reusables.getElementsList(Categories.categoryList);
					Reusables.swipeUp(list.get(list.size() - 1), list.get(0));
					Reusables.waitThread(1);
				}
				thirtyPercentOfTotal = (int) (Math.floor(DatabaseConnection.getTermList(categoryName, LanguageCategoryPage.languageSelectionValue).size()*15/100)+Math.floor(DatabaseConnection.getTermList(categoryName, LanguageCategoryPage.languageSelectionValue).size()*15/100));
				System.out.println("Total of thirty "+thirtyPercentOfTotal);
				thirtyPercent = DatabaseConnection.getUnlockTermCount(categoryName, LanguageCategoryPage.languageSelectionValue);
				System.out.println("Thirty Percent. "+thirtyPercent);
				if (thirtyPercentOfTotal == thirtyPercent){
					Logs.info("Unlock term ratio according equal to of equal terms.");
				}
				else if (thirtyPercentOfTotal == thirtyPercent) {
					Logs.error("Unlock term ratio not according to feature ratio. ");
				}
				fiftyPercentOfUnlockTermCount = (int) Math.floor(thirtyPercent*0.5);
				System.out.println("Fifty Percent of Unlock Term. "+fiftyPercentOfUnlockTermCount);
				Reusables.clickCommand(By.name(categoryName));
				Reusables.waitThread(1);
				Reusables.verifyEqualMessage(getTermPageHeaderTxt(), categoryName, "Error Message!!Actual and expected category name not matched.");
				Reusables.waitThread(1);
				termListCat = Reusables.getElementsList(TermList.termList);
				fiftyPercentOfUnlockTermList = DatabaseConnection.getFiftyPercentOfUnlockTerm(categoryName, LanguageCategoryPage.languageSelectionValue);
				for (int j = 0; j < fiftyPercentOfUnlockTermList.size(); j++){
					System.out.println("Unlock term "+fiftyPercentOfUnlockTermList.get(j));
					while (Reusables.isElementPresent(By.name(fiftyPercentOfUnlockTermList.get(j))) == false){
						Reusables.waitThread(1);
						Reusables.swipeUp(termListCat.get(termListCat.size() - 1), termListCat.get(0));
						Reusables.waitThread(1);
					}
					Reusables.clickCommand(By.name(fiftyPercentOfUnlockTermList.get(j)));
					if (Reusables.isElementPresent(TermList.alertAcceptBtn) == true){
						Logs.error("Lock term found.");
						Assert.fail("Lock term found inside 50 percent of unlock term list.");
						break;
						}
					unlockTermCount++;
					Reusables.waitThread(1);
					}
				System.out.println("Unlock term count.. "+unlockTermCount);
				if (unlockTermCount <= fiftyPercentOfUnlockTermCount){
					Logs.info("Thirty Percentage unlock term feature correct.");
				}
				else {
					Assert.fail("First Unlock term count more than fifty percent of total terms.");
				}
				Reusables.stepBack();
			}
			Categories.verifyCategoryHeaderTxt();
			Reusables.waitThread(1);
		}catch(NoSuchElementException e){
			
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>> for Checking first term as unlock term >>>>>>>>>>>>>>>>>>>>>>>>>>
	public static void checkFirstTermAsUnlockTerm(String languageName){
		List<String> categoryDBList;
		List<AndroidElement> wordList;
		String categoryName = "";
		try{
			categoryDBList = DatabaseConnection.getMainCategories(languageName);
			for (int  i = 0; i < categoryDBList.size() ; i++){
				categoryName = categoryDBList.get(i);
				while (Reusables.isElementPresent(By.name(categoryName))==false){
					Reusables.swipeUp();
				}
				Reusables.clickCommand(By.name(categoryName));
				if (DeviceRelatedInformation.getDeviceVersionName().contains("Marsmallow")){
					SplashScreen.allowMediaFileAccessPopup();
				}
				Reusables.verifyPageLoaded(categoryName);
				wordList = Reusables.getElementsList(TermList.termList);
				wordList.get(0).click();
				if (Reusables.isElementPresent(TermList.alertAcceptBtn)){
					Logs.error("First Term mark as lock term term. ");
				}
				Reusables.stepBack();
				if (Reusables.isElementPresent(Reusables.interstetialBtn)){
					Reusables.hideIndustrialization();
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("First Term found as lock term. "+e.getClass().getName());
		}
	}
}
