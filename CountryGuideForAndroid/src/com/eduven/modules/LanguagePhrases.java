package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class LanguagePhrases {

	// AndroidDriver instance
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	// Locator Identity
	public static By language_phrases_cat = By.name(DataConstants.language_phrase_header_txt);
	public static By language_phrase_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By unlock_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/audio");
	public static By lock_btn = By.name("Locked");
	public static By select_language_header_txt = By.name("Select Language");
	public static By language_list = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By for_element_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	

	/**
	 * This method is used to click on the Languages & Phrases icon.
	 */
	public static void clickOnLanguagePhrases() {
		try {
			while (Reusables.isElementPresent(language_phrases_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(language_phrases_cat);
			if (Reusables.isElementPresent(select_language_header_txt) || Reusables.isElementPresent(language_phrase_cat_header_txt) == true){	
			}
			else if (Reusables.isElementPresent(language_phrase_cat_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(language_phrases_cat);
			}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Languages & Phrases. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyLanguagePhrasesHeaderTxt(){
		try{
		Reusables.verifyEqualMessage(Reusables.getText(language_phrase_cat_header_txt), DataConstants.language_phrase_header_txt, "Error Message! text message does not match.");
	}
	catch(NoSuchElementException e){
		Logs.error("Art Aficionados header text does not match. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to verify selected language header find or not.
	 * @return
	 */
	public static boolean verifySelectLanguageHeaderTxtDisplayed(){
		boolean status = false;
		try{
			status = Reusables.isElementPresent(select_language_header_txt);
		}
		catch(NoSuchElementException e){
			Logs.error("Select language header text does not displayed. ");
		}
		
		return status;
	}
	
	
	public static void selectRandomLanguage(){
		try{
			List<AndroidElement> language_element = driver.findElements(language_list);
			int random_number = Reusables.randomNumber(language_element.size());
			Reusables.clickCommand(By.name(language_element.get(random_number).getAttribute("name").trim().toString()));
		}
		catch(NoSuchElementException e){
			Logs.error("Select Language popup not display... ");
		}
	}
	
	
	public static void selectLangaugeFromLanguageMenu(){
		try{
			if (verifySelectLanguageHeaderTxtDisplayed() == true){
				selectRandomLanguage();
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Select language header popup not displayed......");
		}
	}
	
	/**
	 * @return : unlock button count
	 */
	public static int countUnLockBtn(){
		int unlock_count = 0;
		int audio_count = Reusables.getElementsList(unlock_btn).size();
		if (audio_count > countLockBtn()){
			unlock_count = audio_count - countLockBtn();
		}
	
		return unlock_count;
	}
	
	
	/**
	 * @return : Lock button count
	 */
    public static int countLockBtn(){
		
		return Reusables.getElementsList(lock_btn).size() /2;
	}
    
    
    public static void verifyLockUnlockStatus(){
    	try{
    		Assert.assertTrue(countLockBtn() > countUnLockBtn(), "Error Message! Unlock button more than lock button");
    	}
    	catch(NoSuchElementException e){
    		Logs.error("Lock count less than unlock count btn. "+e.getClass().getName());
    	}
    }
    
    public static void clickFirstLockBtn(){
    	try{
    		int audio_count = Reusables.getElementsList(unlock_btn).size();
    		for (int i = 0; i <= audio_count; i++){
    			Reusables.clickCommand(unlock_btn);
    			if (Reusables.isElementPresent(EntityDetailPage.buy_btn) == false){
    				Reusables.waitThread(1);
    				Reusables.stepBack();
    				}
    			else if (Reusables.isElementPresent(EntityDetailPage.buy_btn) == true){
    				System.out.println("Lock found in the given category....");
    				break;
    				}
    			}
    		}
    	catch(NoSuchElementException e){
    		Logs.error("Click operations not perform on the lock button. "+e.getClass().getName());
    	}
    }
}
