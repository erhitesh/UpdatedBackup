package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class TasteBudForVegan {
	
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
			SplashScreen.forAlphabeticSorting();
			Reusables.waitThread(2);
			tasteBudDbRecipeNameList = DatabaseConnection.getTasteBudCategoryRecipeNameList(typeOfDietName, tasteBudCategoryName);
			tasteBudElementList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
			for (int i = 0; i < tasteBudDbRecipeNameList.size(); i++){
				recipeName = tasteBudElementList.get(i).getText();
				Reusables.verifyEqualMessage(tasteBudDbRecipeNameList.get(i), recipeName, "Error Message!Actual and Expected Text not matched.");
				Logs.info("Taste Bud Recipe Name "+recipeName+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected Text not matched."+e.getClass().getName());
		}
	}

}
