package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;

public class AllRecipesForSeafood {

	
	/**
	 * This method is used to verify Recipe Name.
	 * @param typeOfDietName : 
	 */
	public static void verifyRecipeNameList(String typeOfDietName){
		String recipeName = "";
		AndroidElement element;
		try{
			Reusables.waitThread(4);
			List<String> dbRecipeNameList = DatabaseConnection.allRecipeList(typeOfDietName);
			SplashScreen.forAlphabeticSorting();
			for (int i = 0; i < dbRecipeNameList.size()/100; i++) {
				recipeName = dbRecipeNameList.get(i);
				while (Reusables.isElementPresent(By.name(recipeName)) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.name(recipeName));
				Logs.info("Recipe Name "+ element.getAttribute("name").toString() + " Found.");
				}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Recipe Name not Found.. "+e.getClass().getName());
			}
	}
}
