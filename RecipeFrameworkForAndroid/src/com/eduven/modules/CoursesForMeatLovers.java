package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class CoursesForMeatLovers {
	
	
	/**
	 * This method is used to verify Course recipe name.
	 * @param typeOfDietName : String type
	 * @param courseCategoryName : String type
	 */
	public static void verifyCourseCategoryRecipe(String typeOfDietName, String courseCategoryName){
		AndroidElement element = null;
		String courseRecipeName = "";
		try {
			Reusables.waitThread(4);
			List<String> courseDbRecipeNameList = DatabaseConnection.getCoursesCategoryRecipeNameList(typeOfDietName, courseCategoryName);
			SplashScreen.forAlphabeticSorting();
			for (int i = 0; i < courseDbRecipeNameList.size()/10; i++) {
				courseRecipeName = courseDbRecipeNameList.get(i);
				if (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+courseRecipeName+"')]")) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.xpath("//*[contains(@text,'"+courseRecipeName+"')]"));
				Logs.info("Course Recipe Name "+ element.getAttribute("name").toString() + " Found.");
			}
		}catch (NoSuchElementException e) {
			Logs.error("Course Recipe Name " + element.getAttribute("name")+ " not found. " + e.getClass().getName());
		}
	}
}
