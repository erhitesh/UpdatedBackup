package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Cuisine {

	/* IosDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */
	public static By cuisine_cat = By.name(DataConstants.cuisine_header_txt);
	public static By cuisine_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By subcategory_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	public static By ingredients_btn = By.name("Ingredients");
	public static By directions_btn = By.name("Direction");
	public static By servings_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_serving");
	public static By cooking_time_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_cookinTime");
	public static By nutrition_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_nutrition");
	public static By nutri_image_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/nutri_image");
	
	/**
	 * This method is used to verify serving.
	 */
	public static void verifyServings(){
		try{
			//System.out.println("Servings values.."+Reusables.getText(servings_txt).replaceAll("Servings:", "").trim().toString());
			Assert.assertTrue(Integer.parseInt(Reusables.getText(servings_txt).replaceAll("Servings:", "").trim().toString()) > 0, "Error Message! Servings could not be zero");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>Serving is zero. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify cooking time.
	 */
	public static void verifyCookingTime(){
		try{
			Assert.assertTrue(Reusables.getText(cooking_time_txt) != null, "Error Message!!Cooking time is zero");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>Cooking time is null. "+e.getClass().getName());
		}
	}
	
	public static void verifyDirectionsBtn(){
		Reusables.verifyElementPresent(Reusables.getElement(directions_btn), "Error Message! Directions btn not display.");
	}
	
	public static void clickOnDirectionsBtn(){
		try{
			Reusables.getElement(directions_btn).click();
		}
		catch(NoSuchElementException e){
			Logs.error("Click opt not perform on Direction button. "+e.getClass().getName());
		}
	}
	
	public static void verifyClickOnDirectionBtn(){
		clickOnDirectionsBtn();
		//Assert.assertFalse(nutri_image().isDisplayed(), "Error Message! Nutri Image Display");
	}
	
	public static void verifyIngredientsBtn(){
		Reusables.verifyElementPresent(Reusables.getElement(ingredients_btn), "Error Message! Ingredients btn not display.");
	}
	
	public static void clickOnIngredientsBtn(){
		try{
			Reusables.getElement(ingredients_btn).click();
		}
		catch(NoSuchElementException e){
			Logs.error(" click opt not perform on Ingredients button. "+e.getClass().getName());
		}
	}
	
	public static void verifyClickOnIngredientsBtn(){
		clickOnIngredientsBtn();
		Assert.assertTrue(nutriImage().isDisplayed(), "Error Message! Nutri image not Display");
	}
	
	public static AndroidElement nutriImage(){
		//System.out.println("Nutri images first is visible.."+" "+Reusables.get_elements_list(nutri_image_btn).get(0).isDisplayed());
		return Reusables.getElementsList(nutri_image_btn).get(0);
	}
	
	public static void clickNutritionBtn(){
		try{
			Reusables.getElement(nutrition_btn).click();
			Reusables.waitThread(1);
		}
		catch(NoSuchElementException e){
			Logs.error("Click opt not perform on the Nutrition btn. "+e.getClass().getName());
		}
	}
	
	public static void verifyNutritionHeaderTxt(){
		Reusables.waitThread(3);
		Reusables.verifyEqualMessage(Reusables.getText(cuisine_cat_header_txt), "Nutritional Value", "Error Message! header value does not matched.");
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
			if (Reusables.getText(cuisine_cat_header_txt).equals(DataConstants.cuisine_header_txt) == true){
			}
			else if (Reusables.getText(cuisine_cat_header_txt).equals(DataConstants.cuisine_header_txt) == false){
				HomePage.navigateToHomePage();
			    Reusables.customSwipeUp(0.7f, 0.5f);
			    Reusables.clickCommand(cuisine_cat);
			    }
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on the cuisine term. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyCuisineHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(cuisine_cat_header_txt),DataConstants.cuisine_header_txt,"Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Cuisine header text not matched. "+e.getClass().getName());
		}
	}
}
