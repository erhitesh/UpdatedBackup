package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class ThirtySeventyFeature {
	
	/**
	 * This method is used to get term page header text.
	 * @return termheadertxt as string
	 */
	public static String getTermPageHeaderTxt(){
		String termHeaderName = "";
		try{
			Reusables.waitThread(1);
			termHeaderName = Reusables.getElement(TermList.termPageHeaderTxt).getText();
			//System.out.println("Term Page Header Name..> "+termHeaderName);
		}catch(NoSuchElementException e){
			Logs.error("Term Page Header not found. "+e.getClass().getName());
		}
		
		return termHeaderName;
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>> for Checking first term as unlock term >>>>>>>>>>>>>>>>>>>>>>>>>>
	
	/**
	 * This method is used to check first term as unlock term.
	 * @param languageName : String type.
	 */
	public static void checkFirstTermUnlock(String languageName){
		List<IOSElement> categoryList;
		List<IOSElement> wordList;
		String categoryName = "";
		try{
			categoryList = Reusables.getElementsList(Categories.categoryList);
			for (int  i = 0; i < categoryList.size() ; i++){
				categoryName = categoryList.get(i).getText();
				categoryList.get(i).click();
				Reusables.verifyPageLoaded(TermList.termPageHeaderTxt, categoryName);
				wordList = Reusables.getElementsList(TermList.termNameTxt);
				wordList.get(0).click();
				if (Reusables.alertInstance() != null){
					Reusables.acceptAlert();
					Logs.error("First Term visible as lock term. ");
					}
			}
		}catch(NoSuchElementException e){
			Logs.error("First term found as lock term. "+e.getClass().getName());
		}
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
		//int firstUnlockTermListCount = 0;
		List<IOSElement> termList;
		try{
			categorylist = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue);
			for (int i = 0; i < categorylist.size(); i++){
				categoryName = categorylist.get(i);
				unlockTermCount = 0;
				if (Reusables.isElementPresent(By.name(categoryName)) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				thirtyPercentOfTotal = (int) (Math.floor(DatabaseConnection.getTermList(categoryName, LanguageCategoryPage.languageSelectionValue).size()*15/100)+Math.floor(DatabaseConnection.getTermList(categoryName, LanguageCategoryPage.languageSelectionValue).size()*15/100));
				System.out.println("Total of thirty "+thirtyPercentOfTotal);
				thirtyPercent = DatabaseConnection.getUnlockTermCount(categoryName, LanguageCategoryPage.languageSelectionValue);
				System.out.println("Thirty Percent. "+thirtyPercent);
				if (thirtyPercentOfTotal == thirtyPercent){
					Logs.info("Ratio matched.");
				}
				else if (thirtyPercentOfTotal == thirtyPercent) {
					Logs.error("Ratio not matched.");
				}
				fiftyPercentOfUnlockTermCount = (int) Math.floor(thirtyPercent*0.5);
				System.out.println("Fifty Percent of Unlock Term. "+fiftyPercentOfUnlockTermCount);
				Reusables.clickCommand(By.name(categoryName));
				Reusables.waitThread(1);
				Reusables.verifyEqualMessage(getTermPageHeaderTxt(), categoryName, "Error Message!!Actual and expected category name not matched.");
				Reusables.waitThread(1);
				termList = Reusables.getElementsList(TermList.termNameTxt);
				fiftyPercentOfUnlockTermList = DatabaseConnection.getFiftyPercentOfUnlockTerm(categoryName, LanguageCategoryPage.languageSelectionValue);
				for (int j = 0; j < fiftyPercentOfUnlockTermList.size(); j++){
					System.out.println("Unlock term "+fiftyPercentOfUnlockTermList.get(j));
					while (Reusables.isElementPresent(By.name(fiftyPercentOfUnlockTermList.get(j))) == false){
						Reusables.waitThread(1);
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}
					termList.get(j).click();
					if (Reusables.isElementPresent(By.xpath("//UIAButton[@name='OK']")) == true){
						Logs.error("Lock term found.");
						Assert.fail("Lock term found inside 50 percent of unlock term list.");
						break;
						}
					else {
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
			Logs.error("Verify starting 30 percentage term as unlock terms. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify first term as unlock term for every category.
	 */
	public static void checkFirstTermAsUnlockTer(){
		List<IOSElement> categoryList;
		List<IOSElement> termList;
		try{
			categoryList = Reusables.getElementsList(Categories.categoryList);
			for (IOSElement element : categoryList){
				element.click();
				Reusables.verifyPageLoaded(TermList.termPageHeaderTxt, element.getText());
				termList = Reusables.getElementsList(TermList.termNameTxt);
				termList.get(0).click();
				if (Reusables.isElementPresent(By.name(termList.get(0).getAttribute("name")))){
					Logs.info("First Term as unlock term.");
				}
				else{
					Logs.error("First term as lock term.");
				}
				Reusables.stepBack();
				Reusables.waitThread(2);
			}
			
		}catch(NoSuchElementException e){
			Logs.error("First Term mark as lock term. "+e.getClass().getName());
		}
	}
		
	}
