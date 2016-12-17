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


public class QuickList {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By quickListBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_staples");
	public static By quickListHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By quickList = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_game_name");
	public static By submitDoneBtn = By.name("Done");
	public static By termListHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By termNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_word");
	public static By translationNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_rendring");
	public static By phoenticsNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_phonetic");
	public static By audioBtn = By.name("spk1");
	public static By autoPlayBtn = By.name("icon autoplay");
	public static By editTermBtn = By.name("EditTerm");
	public static By lockTerm = By.name("LockedTranslation");
	public static By adds = By.name("Close Advertisement");
	public static By unlock_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/dialog_upgrade");

	
	/**
	 * This method is used to navigate to the Quick List page.
	 */
	public static void navigateToQuickListPage(){
		try{
			Reusables.waitThread(5);
			Reusables.clickUsingElement(Reusables.getElementsList(quickListBtn).get(0));
			//System.out.println("click performs");
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> Quick List Page "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify QuickList header text.
	 */
	public static void verifyQuickListHeader(){
		try{
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
			Reusables.clickCommand(submitDoneBtn);
		}catch(NoSuchElementException e){
			Logs.error("Done Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * Verify the Quick List Category on Quick list page.
	 * @param languageName : String type for selecting Quick List for different language.
	 */
	public static void verifyQuickListCategory(String languageName) {
		AndroidElement element = null;
		String categoryName = "";
		try{
			Reusables.waitThread(4);
			for (int i = 0; i < DatabaseConnection.getQuickListCategory(languageName).size(); i++){
				categoryName = DatabaseConnection.getQuickListCategory(languageName).get(i);
				if (Reusables.isElementPresent(By.name(categoryName)) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				element = Reusables.getElement(By.name(categoryName));
                Reusables.waitForAndroidElement(element);
                Logs.info("Quick List. "+element.getAttribute("name").toString()+" Found.");
				}
		}
		catch(NoSuchElementException e){
			Logs.error("Quick List "+ element.getAttribute("name")+" not found. "+e.getClass().getName());
			}
	}
	
	
	/**
	 * This method is used to click on the random number 
	 * @return : String, as random name.
	 */
	public static String clickOnRandomQuickList(){
		String randomName = "";
		int randomNumber = 0;
		String firstLastName = "";
		String secondLastName = "";
		try{
			randomNumber = Reusables.randomNumber(DatabaseConnection.getQuickListCategory(LanguageCategoryPage.languageSelectionValue).size());
			randomName = DatabaseConnection.getQuickListCategory(LanguageCategoryPage.languageSelectionValue).get(randomNumber);
			//System.out.println("Random Name..>"+randomName);
			while (Reusables.isElementPresent(By.name(randomName)) == false){
				AndroidElement firstLastElement = Reusables.getElementsList(quickList).get(Reusables.getElementsList(quickList).size()-1);
				firstLastName = firstLastElement.getText();
				Reusables.swipeUp();
				Reusables.waitThread(1);
				AndroidElement secondLastElement = Reusables.getElementsList(quickList).get(Reusables.getElementsList(quickList).size()-1);
				secondLastName = secondLastElement.getText();
				if (firstLastName.equals(secondLastName) == true){
						while (Reusables.isElementPresent(By.name(randomName)) == false){
							//System.out.println("Inside inner while loop");
							Reusables.swipeDown();
						}
				}
				else if (firstLastName.equals(secondLastName) == false){
				}
			}
			Reusables.clickCommand(By.name(randomName));
			if (DeviceRelatedInformation.getDeviceVersionName().contains("Marsmallow")){
				SplashScreen.allowMediaFileAccessPopup();
			}
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
	 * @return : AndroidElement as instance.
	 */
	public static AndroidElement termListInstance(){
		
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
			Reusables.waitForElement(termListHeaderTxt);
			Reusables.verifyEqualMessage(getTermListHeaderName(), expectedTermName, "Error Message!! Actual Term List not matched with expected one.");
		}catch(NoSuchElementException e){
			Logs.error("Actual Term List not matched with expected one. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get TermList from term list page.
	 * @param mainCategory :
	 * @param languageName :
	 */
	public static List<String> getTermList(String mainCategory, String languageName){
		List<String> termListCat = new ArrayList<String>();
		try{
			termListCat = DatabaseConnection.getQuickTermList(mainCategory, languageName);
			//System.out.println("Term List Name.."+termListCat);
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
					/*Reusables.swipeUp();
					Reusables.waitThread(1);*/
					List<AndroidElement> list = Reusables.getElementsList(termNameTxt);
					Reusables.swipeUp(list.get(list.size() - 1), list.get(0));
					Reusables.waitThread(1);
				}
				element = Reusables.getElement(By.name(termName));
				/* Verify data and actual term name  for term page */
				Reusables.waitForAndroidElement(element);
				Logs.info("Term Name..> "+element.getText() +" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Term Name "+ element.getText()+" not . "+e.getClass().getName());
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
			unLockTerm = DatabaseConnection.getUnLockTermForQuickList(mainCategory, languageName);
			//System.out.println("Unlock Term.."+unLockTerm);
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
			lockTerm = DatabaseConnection.getLockTermForQuickList(mainCategory, languageName);
			//System.out.println("Lock Term.."+lockTerm);
			while (Reusables.isElementPresent(By.name(lockTerm)) == false){
				Reusables.swipeUp();
			}
			element = Reusables.getElement(By.name(lockTerm));
			Reusables.verifyElementPresent(element, "Error Message Lock term not found.");
			Reusables.clickUsingElement(element);
			Reusables.waitForElement(unlock_btn);
			Reusables.stepBack();
		}catch(NoSuchElementException e){
			Logs.error("Locked Term Name not found. "+e.getClass().getName());
		}
	}
	
}
