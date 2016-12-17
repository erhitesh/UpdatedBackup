package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class AllRecipes {
	
	
	/* Object Identification */
	public static By allrecipes_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/icon_all_recipes");
	public static By allrecipes_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Recipes");
	public static By all_recipes_list_count = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	public static By recipeDetailPageHeadertxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	
	/**
	 * This method is used to return the instance of All Recipes button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement allRecipesInstance(){
		
		return Reusables.getElement(allrecipes_btn);
	}
	
	/**
	 * This method is used to click on the All Recipes button.
	 */
	public static void clickOnAllRecipesButton(){
		try{
			if (Reusables.isElementPresent(allrecipes_btn) == false){
				Reusables.swipeUp();
			}
			else if (Reusables.isElementPresent(allrecipes_btn) == false){
				Reusables.swipeDown();
			}
			Reusables.waitForAndroidElement(Reusables.getElement(allrecipes_btn));
			allRecipesInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
		    SplashScreen.acceptAlcoholicBeverage();
		}catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>>> All Recipes Page not loaded.. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the all recipe page.
	 */
	public static void navigateToAllRecipePage(){
		clickOnAllRecipesButton();
	}
	
	/**
	 * This method is used to verify All Recipes Page Load or not.
	 */
	public static void verifyAllRecipesPageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.all_recipes_header_value);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> All Recipes Page Header not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Recipe Name.
	 * @param typeOfDietName : 
	 */
	public static void verifyRecipeNameList(String typeOfDietName){
		String recipeName = "";
		AndroidElement element;
		try{
			Reusables.waitThread(4);
			List<String> dbRecipeNameList = DatabaseConnection.allRecipeList(typeOfDietName);
			for (int i = 0; i < dbRecipeNameList.size()/4; i++) {
				recipeName = dbRecipeNameList.get(i);
				while (Reusables.isElementPresent(By.name(recipeName)) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.name(recipeName));
				Logs.info("Recipe Name "+ element.getAttribute("name").toString() + " Found.");
				}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Recipe Name not Found.. "+e.getClass().getName());
			}
	}
	
	
	/**
	 * This method is used to click on the random All Recipes name.
	 * @param typeOfDietName : 
	 * @return : All Recipes term Name
	 */
	public static String clickOnRandomRecipeName(String typeOfDietName){
		String randomRecipesName = "";
		try{
			randomRecipesName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
			System.out.println("Random Recipes Name..>"+randomRecipesName);
			TasteBud.findTermNameViaSearch(randomRecipesName);
			List<AndroidElement> searchRecipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			for (AndroidElement element : searchRecipeList){
				if (element.getAttribute("name").equalsIgnoreCase(randomRecipesName)){
					element.click();
				}
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Random All Recipes Name not clickable. "+e.getClass().getName());
			}
		
		return randomRecipesName;
	}	
	
	//>>>>>>>>>>>>>>>>>> All Recipes Terms Related Task <<<<<<<<<<<<<<<<<<<<<<<<<<<<
	/**
	 * This method is used to verify recipe name on detail page.
	 */
	public static void verifyDetailPageLoaded(){
		try{
			Reusables.waitForElement(recipeDetailPageHeadertxt);
			Reusables.verifyEqualMessage(Reusables.getText(recipeDetailPageHeadertxt), DataConstants.detail_page_header, "Error Message!! Recipe Detail Page not found..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Recipe Page Not Loaded.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe name on detail page.
	 * @param expectedAllRecipesName, Select recipe on recipe page, type String.
	 */
	public static void verifyRecipeNameOnDetailPage(String expectedRecipesName){
		try{
			Reusables.waitForElement(EntityDetailPageUpperPart.recipeNameTxt);
			Reusables.verifyEqualMessage(EntityDetailPageUpperPart.recipeName(), expectedRecipesName, "Error Message!! All Recipes Terms Page not loaded..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Recipe Name not match on recipe detail page. "+e.getClass().getName());
		}
	}

}
