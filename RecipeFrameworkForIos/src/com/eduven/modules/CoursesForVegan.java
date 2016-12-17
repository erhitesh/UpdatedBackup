package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class CoursesForVegan {

	
	/**
	 * This method is used to verify courses recipe name.
	 * @param typeOfDietName : String type
	 * @param coursesName : String type
	 */
	public static void verifyCoursesCategoryRecipeList(String typeOfDietName, String coursesCategoryName){
		List<String> coursesDBRecipeNameList;
		List<IOSElement> CoursesElementList;
		String recipeName = "";
		try{
			SplashScreen.forAlphabeticSorting();
			Reusables.waitThread(1);
			coursesDBRecipeNameList = DatabaseConnection.getCoursesCategoryRecipeNameList(typeOfDietName, coursesCategoryName);
			CoursesElementList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
			for (int i = 0; i < coursesDBRecipeNameList.size()/10; i++){
				recipeName = CoursesElementList.get(i).getText();
				Reusables.verifyEqualMessage(coursesDBRecipeNameList.get(i), recipeName, "Error Message!Actual and Expected Text not matched.");
				Logs.info("Taste Bud Recipe Name "+recipeName+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected Text not matched. "+e.getClass().getName());
		}
	}
}
