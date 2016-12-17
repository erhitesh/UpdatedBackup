package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class AllRecipesForVegan {
	
	
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
	

}
