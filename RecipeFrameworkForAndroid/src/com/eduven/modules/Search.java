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


public class Search {
	
	
	/* Object Identification */
	public static By search_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/search");
	public static By searchPageHeader = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Search");
	public static By lookUp_search_txt = By.xpath("//*[@text='Look Up By']");
	public static By searchby_recipe_name_chk = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	public static By recipeList = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	public static By recipeSearchHeaderTxt = By.xpath("//*[@text='Recipe Detail']");
	public static By searchby_ingredient_name_chk = By.id(DeviceRelatedInformation.getPackageName()+":id/ingredient_textview");
	public static By ingredientSearchHeaderTxt = By.xpath("//*[@text='Look up by']");
	public static By ingredientList = By.id(DeviceRelatedInformation.getPackageName()+":id/ingre_name");
	public static By lookup_search = By.id("android:id/search_src_text");
	public static By relativeSearchTextList = By.id(DeviceRelatedInformation.getPackageName()+":id/textview");
	public static By getRecipeBtnForLookUpSearch = By.id(DeviceRelatedInformation.getPackageName()+":id/go_simple_search");
	
	/* Turbo Search */ 
	public static By turbo_search_txt = By.xpath("//*[@text='Turbo Search']");
	public static By turbo_searchCategoryList = By.id(DeviceRelatedInformation.getPackageName()+":id/cat_textview");
	public static By turbo_SearchSubCategoryList = By.id(DeviceRelatedInformation.getPackageName()+":id/sub_cattextview");
	public static By turbo_generated_recipe = By.id(DeviceRelatedInformation.getPackageName()+":id/text");
	public static By crossBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/cross_button");
	public static By getRecipeBtnForTurboSearch = By.id(DeviceRelatedInformation.getPackageName()+":id/go_turbo_search");
	public static By turbo_search_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By recipesListTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	
	/**
	 * This method is used to Click on Search button on home page.
	 */
	public static void clickOnSearchButton(){
		try{
			Reusables.waitForElement(search_btn);
			Reusables.clickUsingElement(Reusables.getElement(search_btn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search Page not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Search page header text on Search page.
	 */
	public static void verifySearchPageHeaderText(){
		try{
			Reusables.waitForElement(searchPageHeader);
			Reusables.verifyElementEnable(Reusables.getElement(searchPageHeader), "Error Message!! Search Page Header not found");
		}catch(NoSuchElementException e){
			Logs.error("Search Page Header not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to search recipe by Ingredient.
	 */
	public static void SearchByIngredientName(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(searchby_ingredient_name_chk));
			Reusables.clickUsingElement(Reusables.getElement(searchby_ingredient_name_chk));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search By Ingredient Name Checkbox not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to search recipe by name.
	 */
	public static void SearchByRecipeName(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(searchby_recipe_name_chk));
			Reusables.clickUsingElement(Reusables.getElement(searchby_recipe_name_chk));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search By Recipe Name Checkbox not found. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to select the search word from given search list.
	 * @param searchText, for match the given list with this text.
	 */
	public static void selectTextFromRelativeSearchList(String searchText){
		try{
			List<AndroidElement> searchList = Reusables.getElementsList(relativeSearchTextList);
			for (int i = 0; i < searchList.size(); i++){
				if (searchList.get(i).getText().equalsIgnoreCase(searchText)){
					Reusables.clickUsingElement(searchList.get(i));
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
		List<AndroidElement> list;
		//String recipeNameForIngredient = "";
		try{
			if (searchType.equalsIgnoreCase("byrecipe")){
				SearchByRecipeName();
				searchWord = DatabaseConnection.getRecipeUnLockTerm(typeOfDietForSearchText);
				/*System.out.println("Search recipe for.. "+typeOfDietForSearchText+" <<<<<<<>>>>>>> "+searchWord);*/
			}
			else if (searchType.equalsIgnoreCase("byingredient")){
				SearchByIngredientName(); 
				searchWord = ingredientsNameForSearch(typeOfDietForSearchText);
				System.out.println("Search Ingredients for.. "+typeOfDietForSearchText+" <<<<<<<>>>>>>> "+searchWord);
			}
			/* Type Search text */
			Reusables.enterMessageInTextBox(lookup_search, searchWord);
			/* Match the search word from given relative search list. */
			selectTextFromRelativeSearchList(searchWord);
			Reusables.waitThread(2);
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
			SplashScreen.acceptAlcoholicBeverage();
			if (Reusables.isElementPresent(Filter.filterBtn) == true){
				SplashScreen.forAlphabeticSorting();
				list = Reusables.getElementsList(recipeList);
				if (searchType.equalsIgnoreCase("byrecipe")){
					while (Reusables.isElementPresent(By.name(searchWord)) == false){
						list = Reusables.getElementsList(recipeList);
						Reusables.swipeUp(list.get(list.size()-1), list.get(0));
						Reusables.waitThread(1);
					}
				}
				else if (searchType.equalsIgnoreCase("byingredient")){
					/*recipeNameForIngredient = list.get(0).getAttribute("name").toString().trim();
					System.out.println("Recipe Name for Ingredients "+recipeNameForIngredient);*/
					/* Select first recipe from visible list. */
					list.get(0).click();
					Reusables.waitThread(2);
				}
				SplashScreen.selectUnitSystemMeasureIngredients();
			}
			else if (Reusables.isElementPresent(EntityDetailPageUpperPart.shareTxtView) == true){
			}
			SplashScreen.selectUnitSystemMeasureIngredients();
			if (searchType.equalsIgnoreCase("byrecipe")){
				if (Reusables.isElementPresent(recipeSearchHeaderTxt) == true){
					Reusables.verifyElementPresent(Reusables.getElement(recipeSearchHeaderTxt), "Error Message!! Search By Recipe Name Detail Page not found.");
					Reusables.verifyEqualMessage(EntityDetailPageUpperPart.recipeName(), searchWord, "Error Message!! Actual and Expected text not matched.");
				}
			}
			else if (searchType.equalsIgnoreCase("byingredient")){
				if (Reusables.isElementPresent(EntityDetailPageLowerPart.ingredientTxtView) == true){
					Reusables.verifyElementPresent(Reusables.getElement(EntityDetailPageLowerPart.ingredientTxtView), "Error Message!Ingredient textview name not found on recipe detail page.");
					EntityDetailPageLowerPart.verifyIngredientNameInIngredientList(searchWord);
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Search not successfully done. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   For Turbo Search   >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public static void clickOnTurboSearch(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(turbo_search_txt));
			Reusables.clickUsingElement(Reusables.getElement(turbo_search_txt));
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
			List<AndroidElement> searchCategoryList = Reusables.getElementsList(turbo_searchCategoryList);
			randomValue = Reusables.randomNumber(searchCategoryList.size());
			if (randomValue == 0){
				randomValue++;
			}
			searchCategoryName = searchCategoryList.get(randomValue).getText();
			System.out.println("Search Category Name. "+searchCategoryName);
			Reusables.clickUsingElement(searchCategoryList.get(randomValue));
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
			List<AndroidElement> searchSubCategoryList = Reusables.getElementsList(turbo_SearchSubCategoryList);
			int randomValue = Reusables.randomNumber(searchSubCategoryList.size());
			searchSubCategoryName = searchSubCategoryList.get(randomValue).getText();
			System.out.println("Search Sub Category Name. "+searchSubCategoryName);
			Reusables.clickUsingElement(searchSubCategoryList.get(randomValue));
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
			Reusables.waitForElement(turbo_generated_recipe);
			search_and_subcategory_word_combination = Reusables.getText(turbo_generated_recipe).replaceAll("-", "").trim();
			//System.out.println("Course recipe name..>"+search_and_subcategory_word_combination);
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
			Reusables.waitForAndroidElement(Reusables.getElement(getRecipeBtnForTurboSearch));
			Reusables.clickUsingElement(Reusables.getElement(getRecipeBtnForTurboSearch));
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
			SplashScreen.acceptAlcoholicBeverage();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Get Recipe Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the verify turbo search page.
	 */
	public static void verifyTurboSearchPageHeaderTxt(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(turbo_search_page_header_txt));
			Reusables.verifyElementEnable(Reusables.getElement(turbo_search_page_header_txt), "Error Message!! Turbo Search Page Header not found..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Turbo Search Page Header not found.. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to search recipe by turbo.
	 */
	public static void turboSeach(){
		try{
			clickOnTurboSearch();
			selectNameFromSearchCategoryFromList();
			selectNameFromSearchSubCategoryList();
		}catch(NoSuchElementException e){
			Logs.error("Recipe Name not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe name list based on turbo search.
	 */
	public static void verifyTurboSearchRecipesList(String typeOfDietName, String searchCategory, String searchSubCategory){
		try{
			List<String> recipeDbList = DatabaseConnection.getRecipeNameForTurboSearch(typeOfDietName.toLowerCase().trim(), searchCategory.toLowerCase().trim(), searchSubCategory.toLowerCase().trim());
			if (DataConstants.appName.equalsIgnoreCase("seafood recipes") || DataConstants.appName.equalsIgnoreCase("meat lovers")){
				Reusables.waitForElement(SplashScreen.sortByAlphabetsBtn);
				if (Reusables.isElementPresent(SplashScreen.sortByAlphabetsBtn)){
					Reusables.clickCommand(SplashScreen.sortByAlphabetsBtn);
				}
			}
			for (int i = 0; i < recipeDbList.size(); i++){
				while (Reusables.isElementPresent(By.name(recipeDbList.get(i))) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Logs.info("Turbo search recipe name "+recipeDbList.get(i)+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Recipe Name not found. "+e.getClass().getName());
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
				ingredientsName = "Goat Meat";
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredients name not found. "+e.getClass().getName());
		}
		
		return ingredientsName;
	}

}
