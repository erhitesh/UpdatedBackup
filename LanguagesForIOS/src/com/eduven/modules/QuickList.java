package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class QuickList {
	
	
	/* Object Identification */
	public static By quickListBtn = By.xpath("//UIAButton[@name='quick list'][1]");
	public static By quickListHeaderTxt = By.name("QuickListHeader");
	public static By quickList = By.name("QuickList");
	public static By submitDoneBtn = By.name("Done");
	public static By termListHeaderTxt = By.name("QuickListTerm");
	public static By termNameTxt = By.name("TermName");
	public static By translationNameTxt = By.name("TranslationName");
	public static By phoenticsNameTxt = By.name("PhoenticsName");
	public static By audioBtn = By.name("spk1");
	public static By autoPlayBtn = By.name("icon autoplay");
	public static By editTermBtn = By.name("EditTerm");
	public static By lockTerm = By.name("LockedTranslation");
	public static By adds = By.name("Close Advertisement");

	
	/**
	 * This method is used to navigate to the Quick List page.
	 */
	public static void navigateToQuickListPage(){
		try{
			Reusables.waitThread(10);
			//System.out.println("Display.."+Reusables.getElementsList(quickListBtn).get(0).isDisplayed()+"<...Enable.."+Reusables.getElement(quickListBtn).isEnabled());
			Reusables.tapOnElementUsingLocator(quickListBtn);
			//Reusables.clickUsingElement(Reusables.getElementsList(quickListBtn).get(0));
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Quick List Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify QuickList header text.
	 */
	public static void verifyQuickListHeaderTxt(){
		try{
			Reusables.waitThread(4);
			Reusables.verifyElementPresent(Reusables.getElement(quickListHeaderTxt), "Error Message!! Quick List Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Quick List Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the done button.
	 */
	public static void clickOnDoneBtn(){
		try{
			Reusables.waitAndClick(submitDoneBtn);
		}catch(NoSuchElementException e){
			Logs.error("Done Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify quick list category
	 */
	public static void verifyQuickListCategory(){
		List<IOSElement> quick_list_cat;
		List<String> data_quick_list;
		try{
			Reusables.waitThread(4);
			quick_list_cat = Reusables.getElementsList(quickList);
			data_quick_list = DatabaseConnection.getQuickListCategory(LanguageCategoryPage.languageSelectionValue);
			for (int i = 0; i < data_quick_list.size(); i++){
				Reusables.verifyEqualMessage(quick_list_cat.get(i).getText(), data_quick_list.get(i), "Error Message!!Actual and expected quick list term not matched.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Actual and expected quick list term not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the random number 
	 * @return : String, as random name.
	 */
	public static String clickOnRandomQuickList(){
		String randomName = "";
		try{
			Reusables.waitThread(2);
			List<String> list = DatabaseConnection.getQuickListCategory(LanguageCategoryPage.languageSelectionValue);
			Reusables.waitThread(4);
		    randomName = list.get(Reusables.randomNumber(list.size()));
		    //System.out.println("Random Quick List Name..>"+randomName);
			List<IOSElement> quickCatList = Reusables.getElementsList(quickList);
			for (int i = 0; i < quickCatList.size(); i++){
				if (quickCatList.get(i).getText().equalsIgnoreCase(randomName) == true){
					quickCatList.get(i).click();
					break;
				}
			}
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on random name. "+e.getClass().getName());
		}
		
		return randomName;
	}
	

	/**
	 * This method is used to get term name from term list page.
	 * @param index : Type Integer for getting the value of specified element value.
	 * @return : integer value.
	 */
	public static String getTermName(int index){
		String term_name = "";
		try{
			term_name = Reusables.getText(Reusables.getElementsList(termNameTxt).get(index));
			//System.out.println("term Name..> "+term_name);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return term_name;
	}
	
	
	/**
	 * This method is used to get the instance of term list header text.
	 * @return : IOSElement as instance.
	 */
	public static IOSElement termListInstance(){
		
		return Reusables.getElement(termListHeaderTxt);
	}
	
	public static String getTermListHeaderName(){
		String termListHeadrName = "";
		try{
			termListHeadrName = Reusables.getText(termListInstance());
			//System.out.println("Term List Header Name..>"+termListHeadrName);
		}catch(NoSuchElementException e){
			Logs.error("Term List Header Name not found. "+e.getClass().getName());
		}
		
		return termListHeadrName;
	}
	
	/**
	 * This method is used to verify term list header text.
	 */
	public static void verifyQuickListTermHeaderTxt(String expectedTermName){
		try{
			//Reusables.waitForElement(termListHeaderTxt);
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(getTermListHeaderName(), expectedTermName, "Error Message!! Actual Term List not matched with expected one.");
		}catch(NoSuchElementException e){
			Logs.error("Actual Term List not matched with expected one. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get TermList from term list page.
	 * @param mainCategory : main category name.
	 * @param languageName : language name for checking
	 */
	public static List<String> getTermList(String mainCategory, String languageName){
		List<String> termListCat = new ArrayList<String>();
		try{
			termListCat = DatabaseConnection.getQuickTermList(mainCategory, languageName);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return termListCat;
	}
	
	
	/**
	 * This method is used to verify Term Name list.
	 */
	public static void verifyTermNameList(List<String> term_list_cat){
		IOSElement element;
		String termName = "";
		try{
			List<IOSElement> termList = Reusables.getElementsList(termNameTxt);
			List<String> dataTermList = term_list_cat;
			for (int i = 0; i < dataTermList.size(); i++){
				termName = dataTermList.get(i);
				element = termList.get(i);
				Reusables.waitThread(1);
				/* Verify data and actual term name  for term page */
				Reusables.verifyEqualMessage(element.getText(), termName, "Error Message!! Actual and expected text not matched.");
				Logs.info("Term Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Unlock term name.
	 * @param mainCategory : String type, Main Category Name.
	 * @param languageName : String type, for language.
	 */
	public static void verifyUnLockTermName(String mainCategory, String languageName){
		String unLockTerm = "";
		try{
			unLockTerm = DatabaseConnection.getUnLockTermForQuickList(mainCategory, languageName);
			List<IOSElement> termList = Reusables.getElementsList(termNameTxt);
			for (int i = 0; i < termList.size(); i++){
				if (termList.get(i).getText().equalsIgnoreCase(unLockTerm) == true){
					//System.out.println("Unlock term name.."+termList.get(i).getText());
					termList.get(i).click();
					Reusables.waitThread(1);
					break;
				}
			}
			Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[@value='"+unLockTerm+"']")), "Error Message!! Unlock Term Name not found.");
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
		String lock_term = "";
		try{
			lock_term = DatabaseConnection.getLockTermForQuickList(mainCategory, languageName);
			List<IOSElement> termList = Reusables.getElementsList(termNameTxt);
			for (int i = 0; i < termList.size(); i++){
				if (termList.get(i).getText().equalsIgnoreCase(lock_term) == true){
					//System.out.println("Lock term name.."+termList.get(i).getText());
					termList.get(i).click();
					Reusables.waitThread(2);
					Reusables.verifyElementPresent(Reusables.getElement(submitDoneBtn), "Error Message!!Purchase app page not visible.");
					Reusables.clickCommand(submitDoneBtn);
					Reusables.waitThread(2);
					Reusables.clickCommand(adds);
					break;
				}
			}
			Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[@value='"+lock_term+"']")), "Error Message!! Lock Term Name not found.");
		}catch(NoSuchElementException e){
			Logs.error("Locked Term Name not found. "+e.getClass().getName());
		}
	}

}
