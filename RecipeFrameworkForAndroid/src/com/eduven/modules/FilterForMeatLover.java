package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class FilterForMeatLover {
	
	
	/**
	 * This method is used to verify to show the recipes list related filter word 
	 */
	public static void verifyFilterRecipesList(String typeOfDiet, String tasteBudCategoryName, String ingredientName, String filterOpeartion){
		List<String> recipesListFromDb = null;
		if (filterOpeartion.equalsIgnoreCase("exclude")){
			recipesListFromDb = DatabaseConnection.recipesNameListExcludeFilter(typeOfDiet, tasteBudCategoryName, ingredientName);
		}
		else if (filterOpeartion.equalsIgnoreCase("include")){
			recipesListFromDb = DatabaseConnection.recipesNameListIncludeFilter(typeOfDiet, tasteBudCategoryName, ingredientName);
		}
		System.out.println("Db Recipe List"+recipesListFromDb);
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(Filter.filterBtn) == true){
				Reusables.verifyElementEnable(Reusables.getElement(Filter.filterBtn), "Error Message!Filter Button not loaded.");
				SplashScreen.forAlphabeticSorting();
				for (int i = 0; i < recipesListFromDb.size(); i++){
					while (Reusables.isElementPresent(By.name(recipesListFromDb.get(i))) == false){
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}
					Logs.info("Recipe Name "+recipesListFromDb.get(i)+" found.");
				}
			}
			else if (Reusables.isElementPresent(Filter.filterBtn) == false){
				SplashScreen.allowMediaFilesAndContacts();
			    SplashScreen.selectUnitSystemMeasureIngredients();
			    Reusables.verifyElementEnable(Reusables.getElement(Filter.detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
			}
		}catch(NoSuchElementException e){
			Logs.error("Not showing the recipes list related filter. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify ingredient name from filter recipe name.
	 */
	public static String selectFirstRecipeFromRecipeList(){
		String recipeName = "";
		List<AndroidElement> recipeList;
		int  i = 0;
		try{
			recipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			recipeName = recipeList.get(0).getAttribute("name").trim().toString();
			recipeList.get(0).click();
			while (Reusables.isElementPresent(SplashScreen.getPremiumVersionTxt)==true){
				Reusables.oneStepBack();
				Reusables.waitThread(1);
				i++;
				recipeList.get(i).click();
			}
			SplashScreen.selectUnitSystemMeasureIngredients();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Name not found in recipe name. "+e.getClass().getName());
		}
		
		return recipeName;
	}
	
	
	/**
	 * This method is used to verify ingredient name from filter recipe name.
	 */
	public static String selectFreeRecipeFromRecipeList(){
		String recipeName = "";
		List<AndroidElement> recipeList;
		boolean recipeStatus = false;
		try{ 
			recipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			for (int i = 0; i < recipeList.size(); i++){
				recipeName = recipeList.get(i).getText().trim().toString();
				recipeStatus = DatabaseConnection.checkRecipeStatus(recipeName);
				if (recipeStatus == true){
					recipeList.get(i).click();
					Reusables.waitThread(2);
					break;
				}
			}
			SplashScreen.selectUnitSystemMeasureIngredients();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Name not found in recipe name. "+e.getClass().getName());
		}
		
		return recipeName;
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>> Filter with exclude ingredients >>>>>>>>>>>>>>>>>
	
	/**
	 * This method is used to click on the clear all for clear the selected values dietary need.
	 */
	public static void clearAllDietaryNeed(){
		try{
			Reusables.waitForElement(Filter.clearAllDietaryNeed);
			Reusables.clickCommand(Filter.clearAllDietaryNeed);
		}catch(NoSuchElementException e){
			Logs.error("Clear All Dietary need button not found. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>> Filter By Diet >>>>>>>>>>>>>>>>
	public static String clickOnRandomDietaryNeed(){
		String randomDietaryNeedName = "";
		List<AndroidElement> dietaryNeedList;
		int dietaryNeedsRandomNumber = 0;
		boolean getRecipeStatus = false;
		try{
			dietaryNeedList = Reusables.getElementsList(Filter.filterByDietaryNeedCount);
			dietaryNeedsRandomNumber = Reusables.randomNumber(dietaryNeedList.size()-1);
			System.out.println("Dietary Needs Count.. "+dietaryNeedsRandomNumber);
			randomDietaryNeedName = dietaryNeedList.get(dietaryNeedsRandomNumber).getAttribute("name").trim().toString();
			System.out.println("Dietary Needs Name "+randomDietaryNeedName);
			while (Reusables.isElementPresent(Filter.filterBtn) == false){
				Reusables.clickUsingElement(dietaryNeedList.get(dietaryNeedsRandomNumber));
				Filter.clickOnGetRecipesBtn();
				getRecipeStatus = Reusables.isElementPresent(Filter.getRecipeNameBtn);
				System.out.println("Get recipe status..> "+getRecipeStatus);
				if (getRecipeStatus == false){
					boolean status = Reusables.isElementPresent(Filter.filterBtn);
					if (status == true){
						Reusables.verifyElementEnable(Reusables.getElement(Filter.filterBtn), "Error Message!! Filter Button not loaded.");
						break;
					}
					else if (status == false){
						SplashScreen.allowMediaFilesAndContacts();
						//SplashScreen.acceptAlcoholicBeverage();
					    SplashScreen.selectUnitSystemMeasureIngredients();
					    Reusables.verifyElementEnable(Reusables.getElement(Filter.detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
					}
				}
				else{
					clearAllDietaryNeed();
					dietaryNeedsRandomNumber++;
					if (dietaryNeedsRandomNumber > dietaryNeedList.size()){
						dietaryNeedsRandomNumber = 0;
						System.out.println("DietaryNeedsRandom Number..>"+dietaryNeedsRandomNumber);
						}
					}
				}
		}catch(NoSuchElementException e){
			Logs.error(">>> Filter not perform for dietary needs. "+e.getClass().getName());
		}
		
		return randomDietaryNeedName;
	}
	
	/**
	 * This method is used to verify the recipe list based on the below parameters.
	 * @param typeOfDiet : String type
	 * @param tasteBudCategoryName
	 * @param ingredientName
	 */
	public static void verifyFilterRecipesListForDietaryNeeds(String typeOfDiet, String tasteBudCategoryName, String dietaryNeed){
		List<String> recipesListFromDb = DatabaseConnection.recipesNameListForDietaryNeeds(typeOfDiet, tasteBudCategoryName, dietaryNeed);
		//System.out.println("Db Recipe List"+recipesListFromDb.size());
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(Filter.filterBtn) == true){
				for (int i = 0; i < recipesListFromDb.size(); i++){
					while (Reusables.isElementPresent(By.name(recipesListFromDb.get(i))) == false){
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}
					Logs.info("Recipe Name "+recipesListFromDb.get(i)+" found.");
				}
			}
			else if (Reusables.isElementPresent(Filter.filterBtn) == false){
				SplashScreen.allowMediaFilesAndContacts();
			    SplashScreen.selectUnitSystemMeasureIngredients();
			    Reusables.verifyElementEnable(Reusables.getElement(Filter.detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Not showing the recipes list related filter. "+e.getClass().getName());
		}
	}
}
