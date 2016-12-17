package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Cuisine {

	/* IosDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */ 
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By cuisine_cat = By.name(DataConstants.cuisine_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");
	public static By ingredients_btn = By.name("Ingredients");
	public static By directions_btn = By.name("Directions");
	public static By servings_txt = By.xpath("//UIAStaticText[5]");
	public static By cooking_time_txt = By.xpath("//UIAStaticText[4]");
	public static By nutrition_btn = By.xpath("//UIAButton[@name='Nutrition opt2'][1]");
	public static By tips_btn = By.xpath("//UIAButton[@name='Tips'][1]");
	
	
	/**
	 * This method is used to verify servings.
	 */
	public static void verifyServings(){
		try{
			Assert.assertTrue(Integer.parseInt(Reusables.getElement(servings_txt).getText()) > 0, "Error Message! Servings could not be zero");
		}
		catch(NoSuchElementException e){
			Logs.error("Serving is zero. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify cooking time.
	 */
	public static void verifyCookingTime(){
		try{
			Assert.assertTrue(Reusables.getElement(cooking_time_txt).getText() != null, "Error Message! Cooking time could not be zero");
		}
		catch(NoSuchElementException e){
			Logs.error("Cooking time is null. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Directions button.
	 */
	public static void verifyDirectionsBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(directions_btn), "Error Message! Directions btn not display.");
		}
		catch(NoSuchElementException e){
			Logs.error("Directions button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the direction button.
	 */
	public static void clickOnDirectionsBtn(){
		try{
			Reusables.getElement(directions_btn).click();
		}
		catch(NoSuchElementException e){
			Logs.error("Click opt not perform on Direction button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify after click on the directions button.
	 */
	public static void verifyClickOnDirectionBtn(){
		clickOnDirectionsBtn();
		Assert.assertFalse(nutritionElement().isDisplayed(), "Error Message! Nutrition Btn Display");
	}
	
	/**
	 * This method is used to verify Ingredient button.
	 */
	public static void verifyIngredientsBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(ingredients_btn), "Error Message! Ingredients btn not display.");
		}
		catch(NoSuchElementException e){
			Logs.error("Ingredients Button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Ingredients button.
	 */
	public static void clickOnIngredientsBtn(){
		try{
			Reusables.getElement(ingredients_btn).click();
		}
		catch(NoSuchElementException e){
			Logs.error("click opt not perform on Ingredients button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Ingredient button after click operation performs.
	 */
	public static void verifyClickOnIngredientsBtn(){
		clickOnIngredientsBtn();
		Assert.assertTrue(nutritionElement().isDisplayed(), "Error Message! Nutrition Btn not Display");
	}
	
	/**
	 * This method is used to verify nutrition element.
	 * @return : IOSElement.
	 */
	public static IOSElement nutritionElement(){
		return Reusables.getElement(nutrition_btn);
	}
	
	/**
	 * This method is used to click on the Nutrition button.
	 */
	public static void clickNutritionBtn(){
		try{
			nutritionElement().click();
			Reusables.waitThread(1);
		}
		catch(NoSuchElementException e){
			Logs.error("Click opt not perform on the Nutrition btn. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to return the IOSElement.
	 * @return : IOSElement
	 */
	public static IOSElement tipsElementBtn(){
		return Reusables.getElement(tips_btn);
	}
	
	/**
	 * This method is used to click on the tips button.
	 */
	public static void clickOnTipsBtn(){
		try{
		tipsElementBtn().click();
		Reusables.waitThread(1);
		Reusables.acceptAlert();
		}catch(NoSuchElementException e){
			Logs.error("Click opt not perform on the Tips btn. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to click on the Cuisine icon.
	 */
	public static void clickOnCuisine() {
		try {
			while (Reusables.isElementPresent(cuisine_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(cuisine_cat);
			if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.cuisine_header_txt) == true){
				
			}
			else if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.cuisine_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(cuisine_cat);
			}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on the Cuisine category. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyCuisineHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.cuisine_header_txt, "Error Message! text message does not match.");
			}
		catch (NoSuchElementException e) {
			Logs.error("Cuisine header text not matched. "+e.getClass().getName());
			}
		}
	}
