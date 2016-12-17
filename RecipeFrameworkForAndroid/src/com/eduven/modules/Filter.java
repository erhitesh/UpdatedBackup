package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class Filter {
	
	
	/* Object Identification */
	public static By filterBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/filter");
	public static By alertMessage = By.id("android:id/message");
	public static By acceptAlertPopup = By.id("android:id/button1");
	public static By filterPageHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By clearAllIngredientFilter = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_clear_ingredients");
	public static By includeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_plus");
	public static By includeMarkBtn = By.name("+");
	public static By includeIngredientsName = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_added_items");
	public static By excludeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_minus");
	public static By excludeMarkBtn = By.name("-");
	public static By excludeIngredientsName = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_removed_items");
	public static By searchImageView = By.id("android:id/search_button");
	public static By searchIngredientTxtView = By.id("android:id/search_src_text");
	public static By getRecipeNameBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/go_simple_search");
	public static By detailPageShareBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/share");
	public static By filterByDietaryNeedCount = By.id(DeviceRelatedInformation.getPackageName()+":id/textview");
	public static By clearAllDietaryNeed = By.id(DeviceRelatedInformation.getPackageName()+":id/txt_clear_grid");
	
	/**
	 * This method is used to click on the filter button.
	 */
	public static void clickOnFilterBtn(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(filterBtn));
			Reusables.clickUsingElement(Reusables.getElement(filterBtn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>> Filter Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the filter page.
	 */
	public static void navigateToFilterPage(){
		clickOnFilterBtn();
	}
	
	/**
	 * This method is used to verify alert message text.
	 * @param expectedAlertMessage
	 */
	public static void verifyMessageForFilter(String expectedAlertMessage){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(alertMessage) == true){
				String alertActualMessage = Reusables.getAlertMessage(alertMessage);
				Reusables.verifyEqualMessage(alertActualMessage, expectedAlertMessage, "Error Message!Filter alert message not matched.");
				Reusables.clickCommand(acceptAlertPopup);
			}
			else{
			}
		}catch(NoSuchElementException e){
			Logs.error("Filter alert message not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify filter page not loaded.
	 */
	public static void verifyFilterPageLoaded(String expectedHeaderTxt){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(filterPageHeaderTxt));
			//Reusables.verifyEqualMessage(Reusables.getText(filterPageHeaderTxt), expectedHeaderTxt, "Error Message!! Filter page header text not found.");
			Reusables.verifyPageLoaded(expectedHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter Page header text not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the include button.
	 */
	public static void clickOnIncludeButton(){
		try{
			Reusables.waitForElement(includeBtn);
			Reusables.clickCommand(includeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Include button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the exclude button.
	 */
	public static void clickOnExcludeButton(){
		try{
			Reusables.waitForElement(excludeBtn);
			Reusables.clickCommand(excludeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Exclude button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to filter the recipe list with ingredients.
	 */
	public static String filterWithIncludeIngredients(String filter_word){
		String filterWord = "";
		try{
			Reusables.waitForElement(searchImageView);
			Reusables.clickCommand(searchImageView);
			Reusables.enterMessageInTextBox(searchIngredientTxtView, filter_word);
			filterWord = filter_word.toLowerCase();
			clickOnIncludeButton();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter with ingredients name not found. "+e.getClass().getName());
		}
		
		return filterWord;
	}
	
	/**
	 * This method is used to verify filter word show in include list.
	 */
	public static void verifyAddedWordInIncludeList(String expectedWord){
		try{
			Reusables.waitForElement(includeIngredientsName);
			//System.out.println("Include name.."+Reusables.getText(includeIngredientsName).toLowerCase());
			Reusables.verifyEqualMessage(Reusables.getText(includeIngredientsName).toLowerCase(), expectedWord.toLowerCase(), "Error Message!Filter word not found in include list.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter word not found in include list. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the get recipes button.
	 */
	public static void clickOnGetRecipesBtn(){
		try{
			Reusables.waitForElement(getRecipeNameBtn);
			Reusables.clickUsingElement(Reusables.getElement(getRecipeNameBtn));
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Get recipes button not found. "+e.getClass().getName());
		}
	}
	
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
		//List<AndroidElement> recipeList = Reusables.getElementsList(TasteBud.taste_bud_recipe_list_txtview);
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(filterBtn) == true){
				Reusables.verifyElementEnable(Reusables.getElement(filterBtn), "Error Message!Filter Button not loaded.");
				for (int i = 0; i < recipesListFromDb.size(); i++){
					while (Reusables.isElementPresent(By.name(recipesListFromDb.get(i))) == false){
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}
					Logs.info("Recipe Name "+recipesListFromDb.get(i)+" found.");
				}
			}
			else if (Reusables.isElementPresent(filterBtn) == false){
				SplashScreen.allowMediaFilesAndContacts();
			    SplashScreen.selectUnitSystemMeasureIngredients();
			    Reusables.verifyElementEnable(Reusables.getElement(detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Not showing the recipes list related filter. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify ingredient name from filter recipe name.
	 */
	public static String selectFirstRecipeFromRecipeList(){
		String recipeName = "";
		List<AndroidElement> recipeList;
		try{
			recipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			recipeName = recipeList.get(0).getAttribute("name").trim().toString();
			recipeList.get(0).click();
			SplashScreen.selectUnitSystemMeasureIngredients();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Name not found in recipe name. "+e.getClass().getName());
		}
		
		return recipeName;
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>> Filter with exclude ingredients >>>>>>>>>>>>>>>>>
	/**
	 * This method is used to filter the recipe list with ingredients.
	 */
	public static String filterWithExcludeIngredients(String filter_word){
		String filterWord = "";
		try{
			Reusables.waitForElement(searchImageView);
			Reusables.clickCommand(searchImageView);
			Reusables.enterMessageInTextBox(searchIngredientTxtView, filter_word);
			filterWord = filter_word.toLowerCase();
			clickOnExcludeButton();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter with ingredients name not found. "+e.getClass().getName());
		}
		
		return filterWord;
	}
	
	/**
	 * This method is used to verify filter word show in exclude list.
	 */
	public static void verifyAddedWordInExcludeList(String expectedWord){
		try{
			Reusables.waitForElement(excludeIngredientsName);
			Reusables.verifyEqualMessage(Reusables.getText(excludeIngredientsName).toLowerCase(), expectedWord.toLowerCase(), "Error Message!! Filter word not found in Exclude list.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter word not found in Exclude list. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the clear all for clear the selected values dietary need.
	 */
	public static void clearAllDietaryNeed(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(clearAllDietaryNeed));
			Reusables.clickUsingElement(Reusables.getElement(clearAllDietaryNeed));
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
			dietaryNeedList = Reusables.getElementsList(filterByDietaryNeedCount);
			dietaryNeedsRandomNumber = Reusables.randomNumber(dietaryNeedList.size()-1);
			System.out.println("Dietary Needs Count.. "+dietaryNeedsRandomNumber);
			randomDietaryNeedName = dietaryNeedList.get(dietaryNeedsRandomNumber).getAttribute("name").trim().toString();
			System.out.println("Dietary Needs Name "+randomDietaryNeedName);
			while (Reusables.isElementPresent(filterBtn) == false){
				Reusables.clickUsingElement(dietaryNeedList.get(dietaryNeedsRandomNumber));
				clickOnGetRecipesBtn();
				getRecipeStatus = Reusables.isElementPresent(getRecipeNameBtn);
				System.out.println("Get recipe status..> "+getRecipeStatus);
				if (getRecipeStatus == false){
					boolean status = Reusables.isElementPresent(filterBtn);
					if (status == true){
						Reusables.verifyElementEnable(Reusables.getElement(filterBtn), "Error Message!! Filter Button not loaded.");
						break;
					}
					else if (status == false){
						SplashScreen.allowMediaFilesAndContacts();
						SplashScreen.acceptAlcoholicBeverage();
					    SplashScreen.selectUnitSystemMeasureIngredients();
					    Reusables.verifyElementEnable(Reusables.getElement(detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
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
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(filterBtn) == true){
				for (int i = 0; i < recipesListFromDb.size(); i++){
					while (Reusables.isElementPresent(By.name(recipesListFromDb.get(i))) == false){
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}
					Logs.info("Recipe Name "+recipesListFromDb.get(i)+" found.");
				}
			}
			else if (Reusables.isElementPresent(filterBtn) == false){
				SplashScreen.allowMediaFilesAndContacts();
			    SplashScreen.selectUnitSystemMeasureIngredients();
			    Reusables.verifyElementEnable(Reusables.getElement(detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Not showing the recipes list related filter. "+e.getClass().getName());
		}
	}
}
