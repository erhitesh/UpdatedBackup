package com.eduven.modules;

import java.util.List;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class LanguagePhrases {

	// IosDriver instance
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	// Locator Identity
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By language_phrases_icon = By.name(DataConstants.language_and_phrase_header_txt);
	public static By for_element_count = By.name("TermName");//By.xpath("//UIACollectionCell");
	public static By search_bar_icon = By.xpath("//UIASearchBar");
	public static By unlock_btn = By.name("audio opt1");
	public static By lock_btn = By.name("audio opt1 disable");
	public static By select_language_header_txt = By.xpath("//UIATableGroup[@name='Select Language']");
	public static By language_list = By.xpath("//UIATableCell");
	public static By termHederTxt = By.xpath("//UIANavigationBar[1]/UIAStaticText[1]");
	

	/**
	 * This method is used to click on the Languages & Phrases icon.
	 */
	public static void clickOnLanguagephrases() {
		try {
			Reusables.clickCommand(language_phrases_icon);
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Languages & Phrases. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify search bar is visible or not.
	 */
	public static void verfiySearchBarExistance(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(search_bar_icon), "Error Message! Search Bar icon not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Search Bar not visible. "+e.getClass().getName());
		}
	}
	
	
	   /**
	    * This method is used to generate random category.
	    * @param by : Locator type.
	    * @return : Return String as category.
	    */
	   public static String clickOnRandomSubCategory(String mainCategoryName){
		   String random_name = "";
			try{
				int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(mainCategoryName).size());
				random_name = DatabaseConnection.getSubCategoryList(mainCategoryName).get(randomNumber);
				//System.out.println("Random Name.."+random_name);
				Reusables.waitThread(2);
				List<IOSElement> listData = Reusables.getElementsList(for_element_count);
				for (int i = 0; i < listData.size(); i++){
					if (listData.get(i).getText().equalsIgnoreCase(random_name) == true){
						Reusables.waitThread(2);
						listData.get(i).click();
						break;
					}
				}
				}
			catch(NoSuchElementException e){
				Logs.error(mainCategoryName+" Category not found. "+random_name+ e.getClass().getName());
				}
			
		    return random_name;
		    }
	   
	
	
	/**
	 * This method is used to verify Language Header text.
	 * @return : IOSElement.
	 */
	public static boolean verifySelectLanguageHeaderTxtDisplayed(){
		boolean status = false;
		try{
			status = Reusables.isElementPresent(select_language_header_txt);
		}
		catch(NoSuchElementException e){
			Logs.error("Select language header text does not displayed. "+e.getClass().getName());
		}
		
		return status;
	}
	
	
	/**
	 * This method is used to select random name.
	 */
	public static void selectRandomLanguage(){
		try{
			int size = driver.findElements(language_list).size();
			int random_number = Reusables.randomNumber(size);
			if (random_number == 0 || random_number == size - 1) {
				random_number = random_number + 1;
				}
			String xpath = "//UIATableCell[" + random_number + "]";
			String random_name = Reusables.getElement(By.xpath(xpath)).getAttribute("name");
			Reusables.waitThread(2);
			Reusables.clickCommand(By.name(random_name));
		}
		catch(NoSuchElementException e){
			Logs.error("Select Language popup not display. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select language from language menu.
	 */
	public static void selectLangaugeFromLanguageMenu(){
		try{
			if (verifySelectLanguageHeaderTxtDisplayed() == true){
				selectRandomLanguage();
				}
			else if (verifySelectLanguageHeaderTxtDisplayed() == false){
				
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Select language header popup not displayed. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify selected term name appear or not on detail page.
	 * @param expectedTermHeader : for verify term exists on term detail page.
	 */
	public static void verifySelectedLanguageTermName(String expectedTermHeader){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(termHederTxt), expectedTermHeader, "Error Message!! Actual and Expected term not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected term not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to count the number of unlock button.
	 * @return : Integer Value.
	 */
	public static int countUnlockBtn(){
		
		return Reusables.getElementsList(unlock_btn).size();
	}
	
	
	/**
	 * This method is used to count the number of Lock button
	 * @return : Integer Value.
	 */
    public static int countLockBtn(){
		
		return Reusables.getElementsList(lock_btn).size();
	}
    
    /**
     * This method is used to verify Lock and unlock button status.
     */
    public static void verifyLockUnlockStatus(){
    	try{
    		Assert.assertTrue(countLockBtn() > countUnlockBtn(), "Error Message! Unlock button more than lock button");
    		}
    	catch(NoSuchElementException e){
    		Logs.error("Lock count less than unlock count btn, "+e.getClass().getName());
    		}
    	}
    
    /**
     * This method is used to click on the first lock button.
     */
    public static void clickFirstLockBtn(){
    	try{
    		Reusables.getElementsList(lock_btn).get(0).click();
    	}
    	catch(NoSuchElementException e){
    		Logs.error("Click operations not perform on the lock button. "+e.getClass().getName());
    	}
    }

}
