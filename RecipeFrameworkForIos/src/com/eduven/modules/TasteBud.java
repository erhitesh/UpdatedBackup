package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class TasteBud {
	
	
	/* Object Identification */
	public static By headerTxt = By.id("Header");
	public static By tasteBudImageView = By.id("Taste_Buds");
	public static By categoryList = By.id("category_name");
	public static By recipeNameList = By.id("recipe_name");
	public static By ratingTxt = By.id("default_rating");
	public static By addToEdubankBtn = By.id("button_add_to_edubank");
	

	/**
	 * This method is used to click on the Taste Bud button.
	 */
	public static void clickOnTasteBudButton(){
		try{
			Reusables.waitThread(2);
			HomePage.clickOnHomePageButton(DataConstants.tasteBudsBtn);
			Reusables.hideInterstitial();
		}catch(NoSuchElementException r){
			Logs.error("Taste Bud Page not loaded.. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Taste Bud Page Load or not.
	 */
	public static void verifyTasteBudPageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.tasteBudHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Taste Bud Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the taste bud page.
	 */
	public static void navigateToTasteBudCategoryPage(){
		clickOnTasteBudButton();
		verifyTasteBudPageLoaded();
	}
	
	/**
	 * This method is used to verify Taste Bud list terms.
	 * @param typeOfDiet : String type.
	 */
	public static void verifyTasteBudCategoryList(String typeOfDiet){
		String tasteBudName = "";
		List<String> tasteBudDbCategoryList;
		List<IOSElement> tasteBudList;
		try{
			tasteBudDbCategoryList = DatabaseConnection.tasteBudCategory(typeOfDiet);
			tasteBudList = Reusables.getIOSElementsList(categoryList);
			for (int i = 0; i < tasteBudList.size(); i++){
				tasteBudName = tasteBudList.get(i).getText();
				Reusables.verifyEqualMessage(tasteBudDbCategoryList.get(i), tasteBudName, "Error Message!Actual and Expected message not matched.");
				Logs.info("Taste Bud Category Name "+tasteBudName+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Taste Bud Category name "+tasteBudName+" not found."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the random Taste Bud name.
	 * @param typeOfDiet : String type.
	 * @return : Taste Bud term Name.
	 */
	public static String clickOnRandomTasteBudCategoryList(String typeOfDietName){
		String randomTasteBudName = "";
		List<IOSElement> elementList;
		List<String> tasteBudDBCatList;
		try{
			elementList = Reusables.getIOSElementsList(categoryList);
			tasteBudDBCatList = DatabaseConnection.tasteBudCategory(typeOfDietName);
		    randomTasteBudName = tasteBudDBCatList.get(Reusables.randomNumber(tasteBudDBCatList.size()-1));
		    System.out.println("Taste Bud Name..>"+randomTasteBudName);
		    for (int i = 0; i < elementList.size(); i++){
		    	if (elementList.get(i).getText().equalsIgnoreCase(randomTasteBudName)){
		    		elementList.get(i).click();
		    		Reusables.waitThread(2);
		    		break;
		    	}
		    }
		    SplashScreen.acceptAlcoholicBeverage();
		}catch(NoSuchElementException e){
			Logs.error("Taste Bud Name not clickable. "+e.getClass().getName());
		}
		
		return randomTasteBudName;
	}
	
	
	//>>>>>>>>>>>>>>>>>> Taste Bud Terms Related Task <<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void verifyTasteBudTermPageLoaded(String expectedTasteBudName){
		try{
			Reusables.waitForIOSElement(headerTxt);
			Reusables.verifyEqualMessage(Reusables.getText(headerTxt), expectedTasteBudName, "Error Message!! Taste Bud Terms Page not loaded..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Taste Bud Term Page Not Loaded.."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Taste Bud recipe name.
	 * @param typeOfDietName : String type
	 * @param tasteBudCategoryName : String type
	 */
	public static void verifyTasteBudCategoryRecipeList(String typeOfDietName, String tasteBudCategoryName){
		List<String> tasteBudDbRecipeNameList;
		List<IOSElement> tasteBudElementList;
		String recipeName = "";
		try{
			tasteBudDbRecipeNameList = DatabaseConnection.getTasteBudCategoryRecipeNameList(typeOfDietName, tasteBudCategoryName);
			tasteBudElementList = Reusables.getIOSElementsList(recipeNameList);
			for (int i = 0; i < tasteBudDbRecipeNameList.size(); i++){
				recipeName = tasteBudElementList.get(i).getText();
				/*if (Reusables.isElementPresent(By.xpath("//*[@value='"+recipeName+"']")) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}*/
				Reusables.verifyEqualMessage(tasteBudDbRecipeNameList.get(i), recipeName, "Error Message!Actual and Expected Text not matched.");
				Logs.info("Taste Bud Recipe Name "+recipeName+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected Text not matched."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to find the recipe name via search.
	 * @param recipeName : String type for searching.
	 */
	public static void findTermNameViaSearch(String recipeName){
		try{
			Reusables.waitForIOSElement(Search.searchBox);
			Reusables.enterMessageInTextBox(Search.searchBox, recipeName, true, "no key");
			//Reusables.enterMessageInTextBox(Search.searchBox, recipeName, "no key");
		}catch(NoSuchElementException e){
			Logs.error("Search box not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select random recipe name from recipe term page.
	 * @param recipeType.
	 * @param typeOfDietName.
	 * @param categoryName.
	 * @return : Selected recipe name.
	 */
	public static String selectRandomRecipeName(String recipeType, String typeOfDietName, String categoryName){
		  String recipeName = "";
		   List<IOSElement> searchRecipeList;
		   if (recipeType.equalsIgnoreCase("taste bud")){
			   recipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
			   while (recipeName.equalsIgnoreCase("")){
				   HomePage.navigateToHomePage();
				   TasteBud.navigateToTasteBudCategoryPage();
				   TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietName);
				   recipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
			   }
			   System.out.println("Selected Recipe Name "+recipeName);
		   }
		   else if (recipeType.equalsIgnoreCase("courses")){
			   recipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
			   while (recipeName.equalsIgnoreCase("")){
				   HomePage.navigateToHomePage();
				   Courses.navigateToCoursesCategoryPage();
				   Courses.clickOnRandomCourseCategoryList(typeOfDietName);
				   recipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
			   }
			   System.out.println("Selected Recipe Name "+recipeName);
		   }
		   else if (recipeType.equalsIgnoreCase("all recipe")){
			   recipeName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
			   System.out.println("Selected Recipe Name "+recipeName);
		   }
		   TasteBud.findTermNameViaSearch(recipeName);
		   searchRecipeList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
		   for (IOSElement element : searchRecipeList){
			   if (element.getText().equalsIgnoreCase(recipeName)){
				   element.click();
				   break;
			   }
		   }
		   /* Allow alcoholic beverage */
		   SplashScreen.acceptAlcoholicBeverage();
		   /* Hide Interstitial */
		   Reusables.hideInterstitial();
		   /* Hide App Rate Popup. */
		   SplashScreen.hideAppRatePopUp();
		   /* Select Unit System Measure Ingredients */
		   SplashScreen.selectUnitSystemMeasureIngredients();
		   Reusables.waitThread(3);
		   if (Reusables.isElementPresent(RecipeDetailPage.recipeHeaderTxt) == true){
			   Reusables.verifyEqualMessage(RecipeDetailPage.recipeName(), recipeName, "Error Message!Actual and Expected Recipe name not matched.");
		   }
		   
		   return recipeName;
	}
}
