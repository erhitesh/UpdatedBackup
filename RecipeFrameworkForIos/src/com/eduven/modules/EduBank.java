package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.Reusables;


public class EduBank {
	
	
	/* Object Identification */
	public static By edubankRecipeList = By.id("edubank_recipe");
	
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static void clickOnEduBank(){
		try{
			HomePage.clickOnHomePageButton(DataConstants.edubankBtn);
		}catch(NoSuchElementException e){
			Logs.error("EduBank button not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify edubank header text.
	 */
	public static void verifyEduBankHeaderText(){
		try {
			Reusables.verifyPageLoaded(DataConstants.eduBankHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Edubank page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the edubank page.
	 */
	public static void navigateToEdubank(){
		try{
			clickOnEduBank();
			verifyEduBankHeaderText();
		}catch(NoSuchElementException e){
			Logs.error("Edubank page not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the edubank button on recipe list page.
	 * @param index : integer value for add the recipe in edubank.
	 */
	public static String addRecipeToEdubankFromRecipeList(int index){
		List<IOSElement> eduBankList;
		List<IOSElement> recipeList;
		String recipeName = "";
		try{
			eduBankList = Reusables.getIOSElementsList(TasteBud.addToEdubankBtn);
			recipeList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
			recipeName = recipeList.get(index).getText().trim();
			eduBankList.get(index).click();
		}catch(NoSuchElementException e){
			Logs.error("Edubank buttton not found on recipe list page. "+e.getClass().getName());
		}
		return recipeName;
	}
	
	
	/**
	 * This method is used to click on the edubank button on recipe detail page.
	 */
	public static void addRecipeToEdubankFromRecipeDetailPage(){
		try{
			Reusables.waitForIOSElement(RecipeDetailPage.editEdubankBtn);
			Reusables.clickCommand(RecipeDetailPage.editEdubankBtn);
		}catch(NoSuchElementException e){
			Logs.error("Edubank buttton not found on recipe detail page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify added recipe name in edubank.
	 * @param recipeName : String as recipe name.
	 */
	public static void verifyAddedRecipeNameInEdubank(String recipeName){
		List<IOSElement> recipeList;
		try{
			recipeList = Reusables.getIOSElementsList(EduBank.edubankRecipeList);
			for (IOSElement recipe : recipeList){
				if (recipe.getText().trim().equalsIgnoreCase(recipeName)){
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Added Term not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to remove target recipe from EduBank.
	 * @param targetRecipeName : String type for removing recipe from edubank.
	 */
	public static void removeSpecificRecipeFromEduBank(String targetRecipeName){
		List<IOSElement> eduBankList;
		List<IOSElement> recipeList;
		try{
			eduBankList = Reusables.getIOSElementsList(TasteBud.addToEdubankBtn);
			recipeList = Reusables.getIOSElementsList(edubankRecipeList);
			for (int i = 0; i < recipeList.size(); i++){
				if (recipeList.get(i).getText().trim().equalsIgnoreCase(targetRecipeName)){
					eduBankList.get(i).click();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Added Recipe Name found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to remove added recipe from EduBank.
	 */
	public static void removeAllRecipeFromEduBank(){
		List<IOSElement> eduBankList;
		try{
			Reusables.waitThread(2);
			eduBankList = Reusables.getIOSElementsList(TasteBud.addToEdubankBtn);
			System.out.println("Edubank list size..."+eduBankList.size());
			while (eduBankList.size() > 0){
				eduBankList.get(eduBankList.size()-1).click();
				Reusables.waitThread(4);
				System.out.println("Edubank list size..."+eduBankList.size());
			}
			Assert.assertFalse(eduBankList.size() > 0, "Recipe Term Still present in the edubank.");
		}catch(NoSuchElementException e){
			Logs.error("Recipe Term Still present in the edubank. "+e.getClass().getName());
		}
	}

}
