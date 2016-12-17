package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class Cities {
	
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	//Locator identity
	public static By cities = By.name("cities_menu.png");
	public static By for_element_count = By.xpath("//UIACollectionCell");
	public static By for_sub_element_count = By.xpath("//UIAStaticText[1]");
	
	public static By subcategoryheadertxt = By.name("CategoryHeader");
	public static By subcategoryterm = By.name("SubCategoryTermName");
	
	//Perform click operation
	public static void clickOnCitiesIcon(){
		try{
		Reusables.tap_on_element_using_locator(cities);	
		}catch(NoSuchElementException e){
			Logs.error("Click opt not perform the cities icon. "+e.getClass().getName());
		}
	}
	
	
	//This Method is used to verify either element present or not.
	public static void verifyCitiesCategoryList() {
		IOSElement element;
		try{
			int elementCount = Reusables.getElementsList(for_element_count).size();
			for (int i = 0; i < elementCount; i++) {
				element = driver.findElement(By.name(DatabaseConnection.getCitiesList().get(i)));
				if (!element.isDisplayed()) {
					Reusables.swipeUp();
					} 
				Reusables.waitForIosElement(element);
				Logs.info("City Name "+element.getAttribute("name").toString()+" Found.");
				}
			}catch(NoSuchElementException e){
				Logs.error("Cities not found. "+e.getClass().getName());
				}
		}
	
	/**
	 * This method is used to click on the random city.
	 * @return : Type String, return selected city name.
	 */
	public static String clickOnRandomCitiesCategory() {
		String random_name = "";
		try {
			int size = DatabaseConnection.getCitiesList().size();
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getCitiesList().size());
			random_name = DatabaseConnection.getCitiesList().get(randomNumber);
			while (!Reusables.getElement(By.name(random_name)).isDisplayed()){
				if (size/2 > randomNumber){
					Reusables.swipeDown();
				}
				else if (size/2 < randomNumber){
					Reusables.swipeUp();
				}
			}
			Reusables.clickCommand(By.name(random_name));
		} catch (NoSuchElementException e) {
			Logs.error("Not select any random city. "+e.getClass().getName());
		}
		return random_name;
	}
	
	/**
	 * This method is used to sub category header text.
	 * @return
	 */
	public static String subCategoryHeaderTxt(){
		String txt = "";
		try{
			txt = Reusables.getElement(subcategoryheadertxt).getText();
		}catch(NoSuchElementException e){
			Logs.error("Error Message! Not found any text. "+e.getClass().getName());
		}
		
		return txt;
	}
	
	/**
	 * This method is used to verify city and city header name.
	 * @param expectedCityHeader: String type for verification.
	 */
	public static void verifyCityAndCityPageHeaderText(String expectedCityHeader){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(subCategoryHeaderTxt(), expectedCityHeader, "Error Message!! Actual and Expected city name matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected city name matched. "+e.getClass().getName());
			
		}
	}
	
	/**
	 * This method is used to click on random sub category element.
	 * @return : String type 
	 */
	public static String clickOnRandomSubCategory(){
		String sub_category_name = "";
		try{
			int randomNumber = Reusables.randomNumber(Reusables.getElementsList(for_sub_element_count).size());
			if (randomNumber == 0){
				randomNumber++;
			}
			List<IOSElement> list = Reusables.getElementsList(for_sub_element_count);
			sub_category_name = list.get(randomNumber).getText();
			list.get(randomNumber).click();
			
		}catch(NoSuchElementException e){
			Logs.error("Unable to perform click operation on element. "+e.getClass().getName());
		}
		
		return sub_category_name;
	}
	
	/**
	 * This method is used to verify subCategory and term page header text.
	 * @param expectedSubCategoryHeaderTxt
	 */
	public static void verifySubCategoryAndTermPageHeaderTxt(String subcategoryname){
		try{
			Reusables.waitThread(2);
			Reusables.verifyContainsText(subcategoryheadertxt, subcategoryname);
			}
		catch(NoSuchElementException e){
				Logs.error("Error Message! Entity header txt and Sub entity header txt does not match.");
		}
	}
	
/*	//>>>>>>>>>>>>>>>>>>>
	*//**
	 * This method is used to click on the random city.
	 * @return : Type String, return selected city name.
	 *//*
	public static String clickOnRandomCitiesList() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getCitiesList().size());
			random_name = DatabaseConnection.getCitiesList().get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error(" Random city name "+random_name+ e.getClass().getName());
		}
		return random_name;
	}
	
	*//**
	 * This method is used to verify category page header text.
	 * @return txt : as String for sub category header name.
	 *//*
	public static String subCategoryHeaderTxt(){
		String txt = "";
		try{
			txt = Reusables.getText(cities_sub_cate_header_txt);
		}catch(NoSuchElementException e){
			Logs.error("Error Message! Not found any text. "+e.getClass().getName());
		}
		
		return txt;
		
	}
	
	*//**
	 * This method is used to verify category and subCategory header text.
	 *//*
	public static void verifyCategoryAndSubcategoryHeaderTxt(String citiesName){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(cities_sub_cate_header_txt), citiesName.trim().toString(), "Error message! Selected city does not match with open city header txt.");
			String sub_cate = clickOnCitiesSubCategory();
			Reusables.verifyEqualMessage(Reusables.getText(cities_sub_cate_header_txt), sub_cate.trim().toString(), "Error Message! Cities sub category name does not matched with word category name");
		}catch(NoSuchElementException e){
			Logs.error("Error Message! Entity header txt and Sub entity header txt does not match.");
		}
	}
	
	*//**
	 * This method is used to click on cities sub category.
	 * @return : Type String, return cities name.
	 *//*
	public static String clickOnCitiesSubCategory(){
		String sub_cat_name = "";
		try{
			List<AndroidElement> element_count = Reusables.getElementsList(for_cities_sub_cat_count);
			sub_cat_name = element_count.get(0).getAttribute("name").trim().toString();
			element_count.get(0).click();
		}
		catch(NoSuchElementException e){
			Logs.error(" cities sub category"+sub_cat_name+ e.getClass().getName());
		}
		
		return sub_cat_name;
	}

	
	*//**
	 *  This method is used to verify SubCategory header text.
	 *  @param expectedHeaderTxt : String type for verification.
	 *//*
	public static void verifySubcategoryPageHeaderText(String expectedHeaderTxt){
		try{
			//Reusables.waitForElement(by);
		}catch(NoSuchElementException e){
			Logs.error("Actual and expeceted header text not matched. "+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> For filter >>>>>>>>>>>>>>>>>>>>>>>>
	*//**
	 * This method is used to click on filter button.
	 *//*
	public static void clickOnFilterBtn(){
		try{
			Reusables.waitThread(2);
			Reusables.clickCommand(filterBtn);
			verifyCategoryLayoutOpen();
		}catch(NoSuchElementException e){
			Logs.error("Filter button not button. "+e.getClass().getName());
		}
	}
	
	*//**
	 * This method is used to verify Country layout page open or not.
	 *//*
	public static void verifyCategoryLayoutOpen(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(countryLayout), "Error Message!!Country Layout pop up not found.");
		}catch(NoSuchElementException e){
			Logs.error("Country Layout pop up not found. "+e.getClass().getName());
		}
	}
	
	public static String deSelectRandomCountryFromCountryLayout(){
		String randomCountryName = "";
		try{
			randomCountryName = DatabaseConnection.getCountryName().get(Reusables.randomNumber(DatabaseConnection.getCountryName().size()));
			while (Reusables.isElementPresent(By.name(randomCountryName)) == false){
				Reusables.swipeUp();
				Reusables.waitThread(1);
			}
			Reusables.clickUsingString(randomCountryName);
			System.out.println("Random Name..>"+randomCountryName);
		}catch(NoSuchElementException e){
			Logs.error("Random country name not found. "+e.getClass().getName());
		}
		
		return randomCountryName;
	}
	
	*//**
	 * This method is used to verify city name not present correspond to country name.
	 * @param countryName : String type for verify city name not present.
	 *//*
	public static void verifyCityCorrespondingCityRemoved(String countryName){
		try{
			Reusables.waitForElement(HomePage.home_page_header_txt);
			String lastCityName = DatabaseConnection.getCitiesList().get(DatabaseConnection.getCitiesList().size()-1);
			String secondLastCityName = DatabaseConnection.getCitiesList().get(DatabaseConnection.getCitiesList().size()-2);
			String cityName = DatabaseConnection.getRemovedCityName(countryName);
			while (Reusables.isElementPresent(By.name(cityName)) == false){
				System.out.println("Inside while");
				Reusables.swipeUp();
				if(((Reusables.isElementPresent(By.name(secondLastCityName)) || Reusables.isElementPresent(By.name(lastCityName)))) == true){
					break;
				}
				}	
		}catch(NoSuchElementException e){
			Logs.error("City Name found. "+e.getClass().getName());
		}
	}
	
	*//**
	 * This method is used to hide filter page.
	 *//*
	public static void hideFilterPage(){
		try{
			Reusables.waitThread(3);
			Reusables.waitForElement(filterBtn);
			Reusables.clickCommand(filterBtn);
		}catch(NoSuchElementException e){
			Logs.error("Filter Button not found. "+e.getClass().getName());
		}
	}*/
}
