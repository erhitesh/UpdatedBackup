package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Filter {

	
	/* Object Identification */
	public static By filterBtn = By.id("filter");
	public static By filterPageHeaderTxt = By.id("Header");
	public static By clearAllIngredientFilter = By.xpath("//*[@name='Clear All'][1]"); // clear ingredient search
	public static By searchTxtBox = By.id("ingredient_name");
	public static By searchList = By.id("search_word");
	public static By includeBtn = By.id("Include");
	public static By includeMarkBtn = By.id("+");
	public static By includeIngredientsName = By.id("include_name");
	public static By excludeBtn = By.id("Exclude");
	public static By excludeMarkBtn = By.id("-");
	public static By excludeIngredientsName = By.id("exclude_name");
	public static By getRecipeNameBtn = By.id("GET RECIPES");
	public static By detailPageShareBtn = By.id(":id/share");
	public static By filterByDietaryNeedCount = By.id("Dietary_need");
	public static By clearAllDietaryNeed = By.xpath("//*[@name='Clear All'][2]"); // clear dietary
	
	/**
	 * This method is used to click on the filter button.
	 */
	public static void clickOnFilterBtn(){
		try{
			Reusables.waitForIOSElement(filterBtn);
			Reusables.clickCommand(filterBtn);
		}catch(NoSuchElementException e){
			Logs.error("Filter Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the filter page.
	 */
	public static void navigateToFilterPage(){
		clickOnFilterBtn();
	}

	
	/**
	 * This method is used to verify filter page not loaded.
	 */
	public static void verifyFilterPageLoaded(){
		try{
			Reusables.waitForIOSElement(includeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Filter Page header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the include button.
	 */
	public static void clickOnIncludeButton(){
		try{
			Reusables.waitForIOSElement(includeBtn);
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
			Reusables.waitForIOSElement(excludeBtn);
			Reusables.clickCommand(excludeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Exclude button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select search word from search list.
	 */
	public static void selectWordFromSearchList(String searchWord){
		List<IOSElement> searchlist;
		try{
			Reusables.waitForIOSElement(searchList);
			searchlist = Reusables.getIOSElementsList(searchList);
			for (IOSElement element : searchlist){
				if (element.getText().equalsIgnoreCase(searchWord)){
					element.click();
					Reusables.waitThread(1);
					break;
				}
			}
			
		}catch(NoSuchElementException e){
			Logs.error("Search list not found. "+e.getClass().getName());
		}
	}
	/**
	 * This method is used to filter the recipe list with ingredients.
	 */
	public static String filterWithIncludeIngredients(String filterword){
		String filterWord = "";
		try{
			Reusables.waitForIOSElement(searchTxtBox);
			Reusables.enterMessageInTextBox(searchTxtBox, filterword);
			selectWordFromSearchList(filterword);
			filterWord = filterword.toLowerCase();
			clickOnIncludeButton();
		}catch(NoSuchElementException e){
			Logs.error("Filter with ingredients name not found. "+e.getClass().getName());
		}
		
		return filterWord;
	}
	
	/**
	 * This method is used to verify filter word show in include list.
	 */
	public static void verifyAddedWordInIncludeList(String expectedWord){
		String includeName = "";
		try{
			Reusables.waitForIOSElement(includeIngredientsName);
			includeName = Reusables.getText(includeIngredientsName).replaceAll(",", "").toLowerCase();
			Reusables.verifyEqualMessage(includeName, expectedWord.toLowerCase(), "Error Message!Filter word not found in include list.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter word not found in include list. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the get recipes button.
	 */
	public static void clickOnGetRecipesBtn(){
		try{
			Reusables.waitForIOSElement(getRecipeNameBtn);
			Reusables.clickCommand(getRecipeNameBtn);
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
		List<IOSElement> recipesList;
		if (filterOpeartion.equalsIgnoreCase("exclude")){
			recipesListFromDb = DatabaseConnection.recipesNameListExcludeFilter(typeOfDiet, tasteBudCategoryName, ingredientName);
		}
		else if (filterOpeartion.equalsIgnoreCase("include")){
			recipesListFromDb = DatabaseConnection.recipesNameListIncludeFilter(typeOfDiet, tasteBudCategoryName, ingredientName);
		}
		//System.out.println("Db Recipe List"+recipesListFromDb);
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(filterBtn) == true){
				Reusables.verifyElementEnable(Reusables.getIOSElement(filterBtn), "Error Message!Filter Button not loaded.");
				recipesList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
				for (int i = 0; i < recipesListFromDb.size(); i++){
					/*while (Reusables.isElementPresent(By.name(recipesListFromDb.get(i))) == false){
						Reusables.swipeUp();
						Reusables.waitThread(1);
					}*/
					Reusables.verifyEqualMessage(recipesListFromDb.get(i), recipesList.get(i).getText(), "Error Message!Actual and expected message not matched.");
					Logs.info("Recipe Name "+recipesListFromDb.get(i)+" found.");
				}
			}
			else if (Reusables.isElementPresent(filterBtn) == false){
			    SplashScreen.selectUnitSystemMeasureIngredients();
			    Reusables.verifyElementEnable(Reusables.getIOSElement(detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Not showing the recipes list related filter. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify ingredient name from filter recipe name.
	 */
	public static String selectFreeRecipeFromRecipeList(){
		String recipeName = "";
		List<IOSElement> recipeList;
		boolean recipeStatus = false;
		try{ 
			recipeList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
			for (int i = 0; i < recipeList.size(); i++){
				recipeName = recipeList.get(i).getText().trim().toString();
				recipeStatus = DatabaseConnection.checkRecipeStatus(recipeName);
				if (recipeStatus == true){
					recipeList.get(i).click();
					SplashScreen.acceptAlcoholicBeverage();
					SplashScreen.selectUnitSystemMeasureIngredients();
					Reusables.hideInterstitial();
					SplashScreen.hideAppRatePopUp();
					SplashScreen.dismissMoreRecipeAlertPopUp();
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
	 * This method is used to filter the recipe list with ingredients.
	 */
	public static String filterWithExcludeIngredients(String filterword){
		String filterWord = "";
		try{
			Reusables.waitForIOSElement(searchTxtBox);
			Reusables.enterMessageInTextBox(searchTxtBox, filterword);
			selectWordFromSearchList(filterword);
			filterWord = filterword.toLowerCase();
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
		String excludeName = "";
		try{
			Reusables.waitForIOSElement(excludeIngredientsName);
			excludeName = Reusables.getText(excludeIngredientsName).replaceAll(",", "").toLowerCase();
			Reusables.verifyEqualMessage(excludeName, expectedWord.toLowerCase(), "Error Message!! Filter word not found in Exclude list.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Filter word not found in Exclude list. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the clear all for clear the selected values dietary need.
	 */
	public static void clearAllDietaryNeed(){
		try{
			Reusables.waitForIOSElement(clearAllDietaryNeed);
			Reusables.clickCommand(clearAllDietaryNeed);
		}catch(NoSuchElementException e){
			Logs.error("Clear All Dietary need button not found. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>> Filter By Diet >>>>>>>>>>>>>>>>
	public static String clickOnRandomDietaryNeed(){
		String randomDietaryNeedName = "";
		List<IOSElement> dietaryNeedList;
		int dietaryNeedsRandomNumber = 0;
		boolean getRecipeStatus = false;
		try{
			dietaryNeedList = Reusables.getIOSElementsList(filterByDietaryNeedCount);
			dietaryNeedsRandomNumber = Reusables.randomNumber(dietaryNeedList.size()-1);
			System.out.println("Dietary Needs Count.. "+dietaryNeedsRandomNumber);
			randomDietaryNeedName = dietaryNeedList.get(dietaryNeedsRandomNumber).getAttribute("name").trim().toString();
			System.out.println("Dietary Needs Name "+randomDietaryNeedName);
			while (Reusables.isElementPresent(filterBtn) == false){
				Reusables.clickUsingIOSElement(dietaryNeedList.get(dietaryNeedsRandomNumber));
				clickOnGetRecipesBtn();
				getRecipeStatus = Reusables.isElementPresent(getRecipeNameBtn);
				System.out.println("Get recipe status..> "+getRecipeStatus);
				if (getRecipeStatus == false){
					boolean status = Reusables.isElementPresent(filterBtn);
					if (status == true){
						Reusables.verifyElementEnable(Reusables.getIOSElement(filterBtn), "Error Message!! Filter Button not loaded.");
						break;
					}
					else if (status == false){
						//SplashScreen.allowMediaFilesAndContacts();
						SplashScreen.acceptAlcoholicBeverage();
					    SplashScreen.selectUnitSystemMeasureIngredients();
					    Reusables.verifyElementEnable(Reusables.getIOSElement(detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
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
			    SplashScreen.selectUnitSystemMeasureIngredients();
			    Reusables.verifyElementEnable(Reusables.getIOSElement(detailPageShareBtn), "Error Message!! Detail Page Share button not found. ");
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Not showing the recipes list related filter. "+e.getClass().getName());
		}
	}
}

