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


public class TermList {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By termListHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By termList = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_word");
	public static By translationNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_rendring");
	public static By phoenticsNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_phonetic");
	public static By editTermBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_edit");
	public static By audioBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_audio");
	public static By lockTermTxt = By.xpath("//*[contains(@text, 'Locked')]");
	public static By alertAcceptBtn = By.id("android:id/button1");
	
	
	/**
	 * This method is used to get the instance of term list header text.
	 * @return : AndroidElement as instance.
	 */
	public static AndroidElement termListInstance(){
		
		return Reusables.getElement(termListHeaderTxt);
	}
	
	public static String getTermListHeaderName(){
		String termListHeadrName = "";
		try{
			termListHeadrName = Reusables.getText(termListInstance());
		}catch(NoSuchElementException e){
			Logs.error("Term List Header Name not found. "+e.getClass().getName());
		}
		
		return termListHeadrName;
	}
	
	/**
	 * This method is used to verify term list header text.
	 */
	public static void verifyTermListHeaderTxt(String expectedTermName){
		try{
			Reusables.waitThread(2);
			Reusables.waitForElement(termListHeaderTxt);
			Reusables.verifyEqualMessage(getTermListHeaderName(), expectedTermName, "Error Message!! Actual Term List not matched with expected one.");
		}catch(NoSuchElementException e){
			Logs.error("Actual Term List not matched with expected one. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to get term name from term list page.
	 * @param index : Type Integer for getting the value of specified element value.
	 * @return : integer value.
	 */
	public static String getTermName(int index){
		String term_name = "";
		try{
			term_name = Reusables.getText(Reusables.getElementsList(termList).get(index));
			//System.out.println("term Name..> "+term_name);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return term_name;
	}
	
	
	/**
	 * This method is used to get TermList from term list page.
	 */
	public static List<String> getTermList(String mainCategory, String languageName){
		List<String> termListCat = new ArrayList<String>();
		try{
			termListCat = DatabaseConnection.getTermList(mainCategory, languageName);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return termListCat;
	}
	
	
	/**
	 * This method is used to get TermList as phonetics name from term list page.
	 */
	public static List<String> getTermListAsPhoneticsName(String mainCategory, String languageName){
		List<String> termListCat = new ArrayList<String>();
		try{
			termListCat = DatabaseConnection.getTermListAsPhoneticsName(mainCategory, languageName);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return termListCat;
	}
	
	
	/**
	 * This method is used to get TermList as rendering name from term list page.
	 */
	public static List<String> getTermListAsRenderingName(String mainCategory, String languageName){
		List<String> termListCat = new ArrayList<String>();
		try{
			termListCat = DatabaseConnection.getTermListAsRenderingName(mainCategory, languageName);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return termListCat;
	}
	
	/**
	 * This method is used to verify Term Name list.
	 */
	public static void verifyTermNameList(List<String> term_list_cat){
		AndroidElement element = null;
		String termName = "";
		try{
			List<String> dataTermList = term_list_cat;
			for (int i = 0; i < dataTermList.size(); i++){
				termName = dataTermList.get(i);
				if (Reusables.isElementPresent(By.name(termName)) == false){
					List<AndroidElement> list = Reusables.getElementsList(termList);
					Reusables.swipeUp(list.get(list.size() - 1), list.get(0));
					Reusables.waitThread(1);
				}
				element = Reusables.getElement(By.name(termName));
				Reusables.waitForAndroidElement(element);
				//Reusables.verifyElementPresent(element, "Error Message!!"+element.getAttribute("name").toString()+" Not present.");
				Logs.info("Term Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name "+element.getAttribute("name").toString()+" not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Term Name list.
	 */
	public static void verifyTermNameListAsPhonetics(List<String> term_list_cat){
		AndroidElement element = null;
		String termName = "";
		try{
			List<String> dataTermList = term_list_cat;
			for (int i = 0; i < dataTermList.size(); i++){
				termName = dataTermList.get(i);
				while (Reusables.isElementPresent(By.name(termName)) == false){
					List<AndroidElement> list = Reusables.getElementsList(phoenticsNameTxt);
					Reusables.swipeUp(list.get(list.size() - 1), list.get(0));
					Reusables.waitThread(1);
				}
				element = Reusables.getElement(By.name(termName));
				Reusables.waitForAndroidElement(element);
				//Reusables.verifyElementPresent(element, "Error Message!!"+element.getAttribute("name").toString()+" Not present.");
				Logs.info("Term Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name "+element.getAttribute("name").toString()+" not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Term Name list.
	 */
	public static void verifyTermNameListAsRendering(List<String> term_list_cat){
		AndroidElement element = null;
		String termName = "";
		try{
			List<String> dataTermList = term_list_cat;
			for (int i = 0; i < dataTermList.size(); i++){
				termName = dataTermList.get(i);
				System.out.println(termName);
				while (Reusables.isElementPresent(By.name(termName)) == false){
					List<AndroidElement> list = Reusables.getElementsList(translationNameTxt);
					Reusables.swipeUp(list.get(list.size() - 1), list.get(0));
					Reusables.waitThread(1);
				}
				element = Reusables.getElement(By.name(termName));
				Reusables.waitForAndroidElement(element);
				//Reusables.verifyElementPresent(element, "Error Message!!"+element.getAttribute("name").toString()+" Not present.");
				Logs.info("Term Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name "+element.getAttribute("name").toString()+" not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Unlock term name.
	 * @param mainCategory : String type, Main Category Name.
	 * @param languageName : String type, for language.
	 */
	public static void verifyUnLockTermName(String mainCategory, String languageName){
		String unLockTerm = "";
		AndroidElement element;
		try{
			unLockTerm = DatabaseConnection.getUnLockTerm(mainCategory, languageName);
			while (Reusables.isElementPresent(By.name(unLockTerm)) == false){
				Reusables.swipeUp();
			}
			element = Reusables.getElement(By.name(unLockTerm));
			Reusables.verifyElementPresent(element, "Error Message Unlock term not found.");
			Reusables.clickUsingElement(element);
			Reusables.waitThread(1);
		}catch(NoSuchElementException e){
			Logs.error("UnLocked Term Name not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify lock term name.
	 * @param mainCategory : String type, Main Category Name.
	 * @param languageName : String type, for language.
	 */
	public static void verifyLockTermName(String mainCategory, String languageName){
		String lockTerm = "";
		AndroidElement element;
		try{
			lockTerm = DatabaseConnection.getLockTerm(mainCategory, languageName);
			while (Reusables.isElementPresent(By.name(lockTerm)) == false){
				Reusables.swipeUp();
			}
			element = Reusables.getElement(By.name(lockTerm));
			Reusables.verifyElementPresent(element, "Error Message Lock term not found.");
			Reusables.clickUsingElement(element);
			Reusables.waitThread(1);
			Reusables.clickCommand(alertAcceptBtn);
		}catch(NoSuchElementException e){
			Logs.error("UnLocked Term Name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify lock term present.
	 * @param statusValue : status value for checking condition.
	 */
	public static void verifyLockTermBeforePurchase(boolean statusValue, String mainCategory, String languageName){
		String lockTerm = "";
		List<AndroidElement> list;
		try{
			lockTerm = DatabaseConnection.getLockTerm(mainCategory, languageName);
			System.out.println("Lock Term Name "+lockTerm);
			while (Reusables.isElementPresent(By.name(lockTerm))==false){
				list = Reusables.getElementsList(termList);
				Reusables.swipeUp(list.get(list.size()-1), list.get(0));
				Reusables.waitThread(1);
			}
			Reusables.clickCommand(By.xpath("//*[contains(@text, '"+lockTerm+"')]"));
			//Reusables.clickUsingElement(Reusables.getElementsList(lockTermTxt).get(0));
			if (Reusables.isElementPresent(Reusables.getElement(alertAcceptBtn)) == true){
				Reusables.waitThread(2);
				Reusables.clickCommand(alertAcceptBtn);
				Reusables.verifyElementCountExistance(lockTermTxt, statusValue);
			}
		}catch(NoSuchElementException e){
			Logs.error("Lock term not present before purchase. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify lock term now appear as unlock term.
	 * @param statusValue : status value for checking condition.
	 */
	public static void verifyLockTermAfterPurchase(boolean statusValue){
		try{
			if (Reusables.isElementPresent(lockTermTxt) == true){
			}
			else if (Reusables.isElementPresent(lockTermTxt) == false){
				Reusables.verifyElementCountExistance(lockTermTxt, statusValue);
			}
		}catch(NoSuchElementException e){
			Logs.error("Lock term still present after purchase. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify term name after changing the base language.
	 */
	public static void verifyTermNameAfterLanguageChange(String mainCategory, String languageName){
		try{
			String expectedTermName = getTermList(mainCategory, languageName).get(0);
			String actualTermName = Reusables.getElementsList(termList).get(0).getText();
			Reusables.verifyEqualMessage(actualTermName, expectedTermName, "Error Message!!Actual term Name and expected term name not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual term Name and expected term name not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to perform edit term related operation.
	 */
	public static void editTermForContribute(){
		List<AndroidElement> editTermList;
		try{
			Reusables.waitThread(2);
			editTermList = Reusables.getElementsList(editTermBtn);
			editTermList.get(0).click();
			Reusables.waitThread(2);
			EvMenu.verifyEditTermContributePageLoaded();
		}catch(NoSuchElementException e){
			Logs.error("Contribute page not open. "+e.getClass().getName());
		}
	}
	

}
