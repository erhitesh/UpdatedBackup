package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class AllRecipes {
	
	
	/* Object Identification */
	public static By allRecipesImageView = By.id("Home_Button");
	public static By recipePageHeaderTxt = By.id("Header");
	
	/**
	 * This method is used to click on the All Recipes button.
	 */
	public static void clickOnAllRecipesButton(){
		try{
			HomePage.clickOnHomePageButton(DataConstants.allRecipesBtn);
		}catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>>> All Recipes Page not loaded.. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify All Recipes Page Load or not.
	 */
	public static void verifyAllRecipesPageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.allRecipesHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> All Recipes Page not loaded. "+e.getClass().getName());
		}
	}
	
	public static void navigateToAllRecipePage(){
		clickOnAllRecipesButton();
	}
	
	/**
	 * This method is used to verify Recipe Name.
	 * @param typeOfDietName : 
	 */
	public static void verifyRecipeNameList(String typeOfDietName){
		String recipeName = "";
		List<IOSElement> recipeNameList;
		List<String> dbRecipeNameList;
		try{
			Reusables.waitThread(4);
			recipeNameList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
			dbRecipeNameList = DatabaseConnection.allRecipeList(typeOfDietName);
			for (int i = 0; i < dbRecipeNameList.size()/10; i++) {
				recipeName = recipeNameList.get(i).getText();
				System.out.println("recipe Name.."+recipeName);
				Reusables.verifyEqualMessage(dbRecipeNameList.get(i), recipeName, "Error Message!Actual and Expected text not matched.");
				Logs.info("Recipe "+recipeNameList.get(i)+" Found.");
				}
		}
		catch(NoSuchElementException e){
			Logs.error("Recipe Name not Found.. "+e.getClass().getName());
			}
	}
	
	
	/**
	 * This method is used to click on the random All Recipes name.
	 * @param typeOfDietName : String type.
	 * @return : Recipes term Name.
	 */
	public static String clickOnRandomAllRecipesList(String typeOfDietName){
		String dbRecipeName = "";
		List<IOSElement> recipesList;
		try{
			dbRecipeName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
			recipesList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
			for (int i = 0; i < recipesList.size(); i++){
				//System.out.println(recipesList.get(i).getText());
				if (recipesList.get(i).getText().equalsIgnoreCase(dbRecipeName)){
					System.out.println("Print");
					recipesList.get(i).click();
					break;
				}
			}
			Reusables.waitForIOSElement(RecipeDetailPage.recipeNameTxt);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Random All Recipes Name not clickable"+e.getClass().getName());
		}
		
		return dbRecipeName;
	}
	
/*	
	//>>>>>>>>>>>>>>>>>> All Recipes Terms Related Task <<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void verifyTermDetailPageLoaded(){
			try{
				Reusables.waitForIOSElement(TermDetailPage.recipeNameTxt);
				Reusables.verifyPageLoaded(DataConstants.recipeDetailPageHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("All Recipes Term Page Not Loaded.."+e.getClass().getName());
		}
	}*/

}
