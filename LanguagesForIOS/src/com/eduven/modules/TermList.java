package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class TermList {
	
	
	/* Object Identification */
	public static By termPageHeaderTxt = By.id("TermHeader");
	public static By termNameTxt = By.id("TermName");
	public static By translationNameTxt = By.id("TranslationName");
	public static By phoenticsNameTxt = By.id("PhoenticsName");
	public static By audioBtn = By.id("spk1");
	public static By autoPlayBtn = By.id("icon autoplay");
	public static By editTermBtn = By.id("EditTerm");
	public static By lockTerm = By.id("LockedTranslation");
	
	
	
	/**
	 * This method is used to get the instance of term list header text.
	 * @return : IOSElement as instance.
	 */
	public static IOSElement termListInstance(){
		
		return Reusables.getElement(termPageHeaderTxt);
	}
	
	public static String getTermListHeaderName(){
		String termListHeaderName = "";
		try{
			termListHeaderName = Reusables.getText(termListInstance());
			//System.out.println("Term List Header Name..>"+termListHeadrName);
		}catch(NoSuchElementException e){
			Logs.error("Term List Header Name not found. "+e.getClass().getName());
		}
		
		return termListHeaderName;
	}
	
	/**
	 * This method is used to verify term list header text.
	 */
	public static void verifyTermListHeaderTxt(String expectedTermName){
		try{
			Reusables.waitForElement(termPageHeaderTxt);
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
			term_name = Reusables.getText(Reusables.getElementsList(termNameTxt).get(index));
			System.out.println("term Name..> "+term_name);
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
			termListCat = DatabaseConnection.getTermListAsPhoenticsName(mainCategory, languageName);
		}catch(NoSuchElementException e){
			Logs.error("Term name not found. "+e.getClass().getName());
		}
		
		return termListCat;
	}
	
	/**
	 * This method is used to get TermList as rendering name from term list page .
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
				Reusables.verifyEqualMessage(element.getText(), termName, "Error Message!! Actual and expected Term Name not matched.");
				Logs.info("Term Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Term Name list.
	 */
	public static void verifyTermNameListAsPhonetics(List<String> term_list_cat){
		IOSElement element;
		String termName = "";
		try{
			List<IOSElement> termList = Reusables.getElementsList(phoenticsNameTxt);
			List<String> dataTermList = term_list_cat;
			for (int i = 0; i < termList.size(); i++){
				//System.out.println("App Phonetics name.."+termList.get(i).getText()+"<<<<<db term name..>>>"+dataTermList.get(i));
				termName = dataTermList.get(i);
				element = termList.get(i);
				Reusables.waitThread(1);
				/* Verify data and actual term name  for term page */
				Reusables.verifyEqualMessage(element.getText(), termName, "Error Message!! Actual and expected Phonetics Text not matched.");
				Logs.info("Phonetics  Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Phonetics Name not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Term Name list.
	 */
	public static void verifyTermNameListAsRendering(List<String> term_list_cat){
		IOSElement element;
		String termName = "";
		try{
			List<IOSElement> termList = Reusables.getElementsList(translationNameTxt);
			List<String> dataTermList = term_list_cat;
			for (int i = 0; i < termList.size(); i++){
				System.out.println("App Rendering name.."+termList.get(i).getText()+"<<<<<db term name..>>>"+dataTermList.get(i));
				termName = dataTermList.get(i);
				element = termList.get(i);
				Reusables.waitThread(1);
				/* Verify data and actual term name  for term page */
				Reusables.verifyEqualMessage(element.getText(), termName, "Error Message!! Actual and expected Rendering Text not matched.");
				Logs.info("Rendering Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Rendering Name not matched. "+e.getClass().getName());
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
			unLockTerm = DatabaseConnection.getUnLockTerm(mainCategory, languageName);
			List<IOSElement> termList = Reusables.getElementsList(termNameTxt);
			for (int i = 0; i < termList.size(); i++){
				if (termList.get(i).getText().equalsIgnoreCase(unLockTerm) == true){
					termList.get(i).click();
					Reusables.waitThread(1);
					Reusables.verifyElementPresent(termList.get(i), "Error Message!! Unlock Term Name not found.");
					break;
				}
			}
			//Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[@value='"+unLockTerm+"']")), "Error Message!! Unlock Term Name not found.");
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
			Reusables.waitThread(4);
			lock_term = DatabaseConnection.getLockTerm(mainCategory, languageName);
			System.out.println("Lock term.."+lock_term);
			List<IOSElement> termList = Reusables.getElementsList(termNameTxt);
			for (int i = 0; i < termList.size(); i++){
				if (termList.get(i).getText().equalsIgnoreCase(lock_term) == true){
					//System.out.println("Status..>"+Reusables.isElementPresent(By.xpath("//*[@value='"+lock_term+"']")));
					termList.get(i).click();
					Reusables.waitThread(2);
					Reusables.acceptAlert();
					Reusables.waitThread(1);
					break;
				}
			}
			Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[@value='"+lock_term+"']")), "Error Message!! Lock Term Name not found.");
		}catch(NoSuchElementException e){
			Logs.error("Locked Term Name not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify lock term present.
	 * @param statusValue : status value for checking condition.
	 */
	public static void verifyLockTermBeforePurchase(String mainCategory){
		String lockTerm = DatabaseConnection.getLockTerm(mainCategory, LanguageCategoryPage.languageSelectionValue);
		List<IOSElement> list = Reusables.getElementsList(termNameTxt);
		try{
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getText().equalsIgnoreCase(lockTerm) == true){
					list.get(i).click();
					Reusables.waitThread(1);
					if (Reusables.alertInstance() != null){
						Reusables.acceptAlert();
						}
					else if (Reusables.alertInstance() == null){
						Assert.fail("Error Message!! Term appear as unlock.");
						}
					}
				}
			}catch(NoSuchElementException e){
				Logs.error("Lock term not present before purchase. "+e.getClass().getName());
				}
		}
	
	/**
	 * This method is used to verify lock term now appear as unlock term.
	 * @param statusValue : status value for checking condition.
	 */
	public static void verifyLockTermAfterPurchase(String mainCategory){
		String lockTerm = DatabaseConnection.getLockTerm(mainCategory, LanguageCategoryPage.languageSelectionValue);
		List<IOSElement> list = Reusables.getElementsList(termNameTxt);
		try{
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getText().equalsIgnoreCase(lockTerm) == true){
					list.get(i).click();
					Reusables.waitThread(1);
					Reusables.verifyElementPresent(list.get(i), "Error Message!! Lock Term Still Visible.");
				}
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
			String actualTermName = Reusables.getElementsList(termNameTxt).get(0).getText();
			Reusables.verifyEqualMessage(actualTermName, expectedTermName, "Error Message!!Actual term Name and expected term name not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual term Name and expected term name not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to perform edit term related operation.
	 */
	public static void editTermForContribute(){
		try{
			Reusables.waitThread(2);
			List<IOSElement> editTermList = Reusables.getElementsList(editTermBtn);
			editTermList.get(0).click();
			Reusables.waitThread(2);
			EvMenu.verifyContributePageLoaded();
		}catch(NoSuchElementException e){
			Logs.error("Contribute page not open. "+e.getClass().getName());
		}
	}
}
