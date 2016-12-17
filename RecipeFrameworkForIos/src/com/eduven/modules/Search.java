package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Search {
	
	
	/* Object Identification */
	public static By searchBtn = By.name("Search");
	public static By searchPageHeader = By.id("Header");
	public static By lookUpByBtn = By.id("Look Up By");
	public static By searchByRecipeNameBtn = By.id("radio_button_recipe");
	public static By searchByIngredientNameBtn = By.id("radio_button_ingredient");
	public static By searchBox = By.id("search_word");
	public static By lookUpBySearchList = By.id("search_list");
	public static By turboBtn = By.id("Turbo Search");
	public static By turboSearchCategoryList = By.id("category_table");
	public static By turboSearchSubCategoryList = By.id("subcategory_table");
	public static By turboGeneratedList = By.id("turbo_search_button");
	public static By findRecipeBtn = By.id("Find Recipes");
	public static By turboSearchPageHeaderTxt = By.id("Header");
	
	
	/**
	 * This method is used to verify Search button on home page.
	 */
	public static void verifySearchButton(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(searchBtn), "Error Message!! Search Button not found.. ");
		}catch(NoSuchElementException e){
			Logs.error("Search Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Click on Search button on home page.
	 */
	public static void clickOnSearchButton(){
		try{
			Reusables.waitForIOSElement(searchBtn);
			Reusables.clickCommand(searchBtn);
		}catch(NoSuchElementException e){
			Logs.error("click operation not perform on the search button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Search page header text on Search page.
	 */
	public static void verifySearchPageHeaderText(){
		try{
			Reusables.waitForIOSElement(searchPageHeader);
			Reusables.verifyPageLoaded(DataConstants.searchHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Search Page Header not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the search page.
	 */
	public static void navigateToSearchPage(){
		clickOnSearchButton();
		verifySearchPageHeaderText();
	}
	
	
	/**
	 * This method is used to click on the lookupby button.
	 */
	public static void clickOnLookUpByBtn(){
		try{
			Reusables.waitForIOSElement(lookUpByBtn);
			Reusables.clickCommand(lookUpByBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on the lookupby button. "+e.getClass().getName());
		}
	}
	
	
	
	/**
	 * This method is used to search recipe by Ingredient.
	 */
	public static void SearchByIngredientName(){
		try{
			Reusables.waitForIOSElement(searchByIngredientNameBtn);
			Reusables.clickCommand(searchByIngredientNameBtn);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search By Ingredient Name Checkbox not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to search recipe by name.
	 */
	public static void SearchByRecipeName(){
		try{
			Reusables.waitForIOSElement(searchByRecipeNameBtn);
			Reusables.clickCommand(searchByRecipeNameBtn);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search By Recipe Name Checkbox not found. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to select the search word from given search list.
	 * @param searchText, for match the given list with this text.
	 */
	public static void selectTextFromRelativeSearchList(String searchText){
		List<IOSElement> searchList;
		try{
			searchList = Reusables.getIOSElementsList(lookUpBySearchList);
			for (int i = 0; i < searchList.size(); i++){
				if (searchList.get(i).getText().equalsIgnoreCase(searchText)){
					Reusables.waitThread(2);
					searchList.get(i).click();
					break;
					}
				}
		}catch(NoSuchElementException e){
			Logs.error("Word Not Selected from given relative search. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to search Recipe Name By Look Up By.
	 * @param searchType, Search type, either By Recipe Name or By Ingredient Name.
	 * @param searchText, Type String, Name you want to search.
	 */
	public static void searchRecipeByLookUp(String searchType, String typeOfDietForSearchText){
		String searchWord = "";
		List<IOSElement> list;
		try{
			if (searchType.equalsIgnoreCase("byrecipe")){
				SearchByRecipeName();
				searchWord = DatabaseConnection.getRecipeUnLockTerm(typeOfDietForSearchText);
			}
			else if (searchType.equalsIgnoreCase("byingredient")){
				SearchByIngredientName(); 
				searchWord = ingredientsNameForSearch(typeOfDietForSearchText);
			}
			/* Type Search text */
			Reusables.enterMessageInTextBox(searchBox, searchWord, true, "no key");
			/* Match the search word from given relative search list. */
			selectTextFromRelativeSearchList(searchWord);
			Reusables.hideInterstitial();
			if (searchType.equalsIgnoreCase("byingredient")){
				list = Reusables.getIOSElementsList(TasteBud.recipeNameList);
				Reusables.waitThread(1);
				for (int i = 0; i < list.size(); i++){
					list.get(i).click();
					if (Reusables.getText(RecipeDetailPage.recipeHeaderTxt).equalsIgnoreCase(DataConstants.recipeDetailPageHeaderTxt)==false){
						InAppPurchase.hideInAppPurchasePage();
						Reusables.waitThread(1);
					}
				}
				
				list.get(0).click();
				Reusables.waitThread(2);
			}
			Reusables.waitThread(2);
			SplashScreen.acceptAlcoholicBeverage();
			SplashScreen.selectUnitSystemMeasureIngredients();
			SplashScreen.hideAppRatePopUp();
			SplashScreen.dismissMoreRecipeAlertPopUp();
			if (searchType.equalsIgnoreCase("byrecipe")){
				if (Reusables.isElementPresent(RecipeDetailPage.recipeHeaderTxt) == true){
					Reusables.verifyEqualMessage(RecipeDetailPage.recipeName(), searchWord, "Error Message!Actual and Expected text not matched.");
				}
			}
			else if (searchType.equalsIgnoreCase("byingredient")){
				if (Reusables.isElementPresent(RecipeDetailPage.ingredientsBtn) == true){
					RecipeDetailPage.verifyIngredientNameInIngredientList(searchWord);
				}
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Search not successfully done. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the ingredient value based on type of diet.
	 * @param typeOfDiet : String type for ingredient.
	 * @return : ingredients value.
	 */
	public static String ingredientsNameForSearch(String typeOfDiet){
		String ingredientsName = "";
		try{
			if (typeOfDiet.equalsIgnoreCase("vegetarian")){
				ingredientsName = "Onion";
			}
			else if (typeOfDiet.equalsIgnoreCase("non-vegetarian")){
				ingredientsName = "Meat Broth";
			}
			else if (typeOfDiet.equalsIgnoreCase("vegan")){
				ingredientsName = "";
			}
			else if (typeOfDiet.equalsIgnoreCase("all")){
				ingredientsName = "ginger";
			}
			else if (typeOfDiet.equalsIgnoreCase("seafood")){
				ingredientsName = "ginger";
			}
			else if (typeOfDiet.equalsIgnoreCase("sda")){
				ingredientsName = "ginger";
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredients name not found. "+e.getClass().getName());
		}
		
		return ingredientsName;
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   For Turbo Search   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		public static void clickOnTurboSearch(){
			try{
				Reusables.waitForIOSElement(turboBtn);;
				Reusables.clickCommand(turboBtn);
			}catch(NoSuchElementException e){
				Logs.error("Turbo Search text not found "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to select random value from search category list.
		 */
		public static String selectNameFromSearchCategoryFromList(){
			String searchCategoryName = "";
			int randomValue = 0;
			try{
				List<IOSElement> searchCategoryList = Reusables.getIOSElementsList(turboSearchCategoryList);
				randomValue = Reusables.randomNumber(searchCategoryList.size());
				if (randomValue == 0){
					randomValue++;
				}
				searchCategoryName = searchCategoryList.get(randomValue).getText();
				System.out.println("Search Category Name. "+searchCategoryName);
				for (int i = 0; i < searchCategoryList.size(); i++){
					if (searchCategoryList.get(i).getText().equalsIgnoreCase(searchCategoryName)){
						searchCategoryList.get(i).click();
						break;
					}
				}
			}catch(NoSuchElementException e){
				Logs.error("Random Name Value not selected from searchCategoryName List. "+e.getClass().getName());
			}
			
			return searchCategoryName;
		}
		
		/**
		 * This method is used to select random value from course list B.
		 */
		public static String selectNameFromSearchSubCategoryList(){
			String searchSubCategoryName = "";
			try{
				List<IOSElement> searchSubCategoryList = Reusables.getIOSElementsList(turboSearchSubCategoryList);
				int randomValue = Reusables.randomNumber(searchSubCategoryList.size());
				searchSubCategoryName = searchSubCategoryList.get(randomValue).getText();
				System.out.println("Search Sub Category Name. "+searchSubCategoryName);
				for (int i = 0; i < searchSubCategoryList.size(); i++){
					if (searchSubCategoryList.get(i).getText().equalsIgnoreCase(searchSubCategoryName)){
						searchSubCategoryList.get(i).click();
						break;
					}
				}
			}catch(NoSuchElementException e){
				Logs.error("Random Name Value not selected from searchSubCategoryName List. "+e.getClass().getName());
			}
			
			return searchSubCategoryName;
		}
		
		/**
		 * This method is used to return the course & ingredient combination.
		 * @return: type String, course & ingredient combination
		 */
		public static String generatedRecipeName(){
			String search_and_subcategory_word_combination = "";
			try{
				Reusables.waitForIOSElement(turboGeneratedList);
				search_and_subcategory_word_combination = Reusables.getText(turboGeneratedList).replaceAll("-", "").trim();
				System.out.println("Course recipe name..>"+search_and_subcategory_word_combination);
			}catch(NoSuchElementException e){
				Logs.error("Search Category and Search Sub Category combination not found. "+e.getClass().getName());
			}
			return search_and_subcategory_word_combination;
		}
		
		/**
		 * This method is used to verify random value generated from course list A & B.
		 */
		public static void verifyWordCategoryNameFromSearchCategories(String expected_recipe_combination){
			try{
				Reusables.verifyEqualMessage(generatedRecipeName(), expected_recipe_combination, "Error Message!!Actual search category name and search sub category not matched.");
			}catch(NoSuchElementException e){
				Logs.error("Actual search category name and search sub category not matched. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to click on the get recipes button.
		 */
		public static void clickOnGetRecipesButton(){
			try{
				Reusables.waitForIOSElement(findRecipeBtn);
				SplashScreen.acceptAlcoholicBeverage();
			}catch(NoSuchElementException e){
				Logs.error("Find Recipe btn not click. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to click on the verify turbo search page.
		 */
		public static void verifyTurboSearchPageHeaderTxt(){
			try{
				Reusables.verifyEqualMessage(Reusables.getText(turboSearchPageHeaderTxt), DataConstants.turboSearchHeaderTxt, "Error Message!Actual and Expected Text not matched.");;
			}catch(NoSuchElementException e){
				Logs.error("Turbo Search Header text not found. "+e.getClass().getName());
			}
			}
		
		/**
		 * This method is used to perform turbo search. 
		 */
		public static void turboSeach(){
			clickOnTurboSearch();
			selectNameFromSearchCategoryFromList();
			selectNameFromSearchSubCategoryList();
		}
		
		/**
		 * This method is used to verify recipe name list based on turbo search.
		 */
		public static void verifyTurboSearchRecipesList(String typeOfDietName, String searchCategory, String searchSubCategory){
			List<String> recipeDbList;
			List<IOSElement> recipeList;
			try{
				recipeList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
				recipeDbList = DatabaseConnection.getRecipeNameForTurboSearch(typeOfDietName.toLowerCase().trim(), searchCategory.toLowerCase().trim(), searchSubCategory.toLowerCase().trim());
				for (int i = 0; i < recipeDbList.size(); i++){
					System.out.println("Recipe Name are .."+recipeDbList.get(i));
					Reusables.verifyEqualMessage(recipeDbList.get(i), recipeList.get(i).getText(), "Error Message!Actual and Expected Message not matched.");
					Logs.info("Turbo search recipe name "+recipeDbList.get(i)+" found.");
				}
			}catch(NoSuchElementException e){
				Logs.error("Recipe Name not found. "+e.getClass().getName());
			}
		}
		
}
