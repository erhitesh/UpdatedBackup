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


public class TasteBud {
	
	
	/* Object Identification */
	public static By tasteBudPageHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Taste Buds");
	public static By tasteBudImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/taste_bud");
	public static By tasteBudListImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/course_name");
	public static By searchBox = By.id(DeviceRelatedInformation.getPackageName()+":id/search_src_text");
	public static By tasteBudRecipeListTxtview = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	
	
	/**
	 * This method is used to return the instance of Taste Bud button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement tasteBudInstance(){
		
		return Reusables.getElement(tasteBudImageView);
	}
	
	/**
	 * This method is used to click on the Taste Bud button.
	 */
	public static void clickOnTasteBudButton(){
		try{
			if (Reusables.isElementPresent(tasteBudImageView) == false){
				Reusables.swipeDown();
			}
			Reusables.waitForElement(tasteBudImageView);
			tasteBudInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
		}catch(NoSuchElementException r){
			Logs.error("Taste Bud Page not loaded.. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the tastebud page.
	 */
	public static void navigateToTasteBudPage(){
		clickOnTasteBudButton();
	}
	
	/**
	 * This method is used to verify Taste Bud Page Load or not.
	 */
	public static void verifyTasteBudPageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.taste_bud_header_value);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Taste Bud Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Taste Bud list terms.
	 * @param typeOfDiet :
	 */
	public static void verifyTasteBudCategoryList(String typeOfDiet){
		AndroidElement element = null;
		String tasteBudName = "";
		List<String> tasteBudDbCategoryList;
		try {
			Reusables.waitThread(4);
			tasteBudDbCategoryList = DatabaseConnection.tasteBudCategory(typeOfDiet);
			for (int i = 0; i < tasteBudDbCategoryList.size(); i++) {
				tasteBudName = tasteBudDbCategoryList.get(i).trim();
				if (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+tasteBudName+"')]")) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.xpath("//*[contains(@text,'"+tasteBudName+"')]"));
				//Logs.info("Taste Bud Category Name "+ element.getAttribute("name").toString() + " Found.");
			}
		}catch (NoSuchElementException e) {
			Logs.error("Taste Bud Name " + element.getAttribute("name")+ " not found. " + e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Taste Bud recipe name.
	 * @param typeOfDietName : String type
	 * @param tasteBudCategoryName : String type
	 */
	public static void verifyTasteBudCategoryRecipeList(String typeOfDietName, String tasteBudCategoryName){
		AndroidElement element = null;
		String tasteBudRecipeName = "";
		try {
			Reusables.waitThread(4);
			List<String> tasteBudDbRecipeNameList = DatabaseConnection.getTasteBudCategoryRecipeNameList(typeOfDietName, tasteBudCategoryName);
			for (int i = 0; i < tasteBudDbRecipeNameList.size(); i++) {
				tasteBudRecipeName = tasteBudDbRecipeNameList.get(i);
				if (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+tasteBudRecipeName+"')]")) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.xpath("//*[contains(@text,'"+tasteBudRecipeName+"')]"));
				//Logs.info("Taste Bud Recipe Name "+ element.getAttribute("name").toString() + " Found.");
			}
		}catch (NoSuchElementException e) {
			Logs.error("Taste Bud Recipe Name " + element.getAttribute("name")+ " not found. " + e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the random Taste Bud name
	 * @return : Taste Bud term Name
	 */
	public static String clickOnRandomTasteBudCategory(String typeOfDiet){
		String randomTasteBudName = "";
		try{
			randomTasteBudName = DatabaseConnection.randomTasteBudCategory(typeOfDiet);
			System.out.println("Random Taste Bud Name..>"+randomTasteBudName);
			while (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+randomTasteBudName+"')]")) == false){
				Reusables.swipeUp();
				Reusables.waitThread(1);
			}
			Reusables.clickCommand(By.xpath("//*[contains(@text,'"+randomTasteBudName+"')]"));
			if (Reusables.isElementPresent(SplashScreen.alcoholicBeverageBtn) == true){
				SplashScreen.acceptAlcoholicBeverage();
			}
			if (Reusables.isElementPresent(SplashScreen.remineLaterBtn) == true){
				SplashScreen.remindLaterRecipeImage();
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Random Taste Bud Name not clickable"+e.getClass().getName());
		}
		
		return randomTasteBudName;
	}
	
	
	//>>>>>>>>>>>>>>>>>> Taste Bud Terms Related Task <<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void verifyTasteBudTermPageLoaded(String expectedTasetBudName){
		try{
			Reusables.waitForElement(SplashScreen.appSubHeaderTxtView);
			Reusables.verifyEqualMessage(Reusables.getText(SplashScreen.appSubHeaderTxtView), expectedTasetBudName, "Error Message!! Taste Bud Terms Page not loaded..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Taste Bud Term Page Not Loaded.."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to find the recipe name via search.
	 * @param recipeName : String type for searching.
	 */
	public static void findTermNameViaSearch(String recipeName){
		try{
			Reusables.waitForElement(Search.search_btn);
			Search.clickOnSearchButton();
			Reusables.waitForElement(searchBox);
			Reusables.enterMessageInTextBox(searchBox, recipeName);
		}catch(NoSuchElementException e){
			Logs.error("Search box not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select random recipe name from recipe term page.
	 * @param recipeType
	 * @param typeOfDietName
	 * @param categoryName
	 * @return : Selected recipe name.
	 */
	public static String selectRandomRecipeName(String recipeType, String typeOfDietName, String categoryName){
		  String recipeName = "";
		   List<AndroidElement> searchRecipeList;
		   if (recipeType.equalsIgnoreCase("taste buds")){
			   recipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
			   while (recipeName.equalsIgnoreCase("")){
				   HomePage.navigateToHomePage();
				   TasteBud.navigateToTasteBudPage();
				   recipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
			   }
			   System.out.println("Selected Recipe Name "+recipeName);
		   }
		   else if (recipeType.equalsIgnoreCase("courses")){
			   recipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
			   while (recipeName.equalsIgnoreCase("")){
				   HomePage.navigateToHomePage();
				   Courses.navigateToCoursePage();
				   recipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
			   }
			   System.out.println("Selected Recipe Name "+recipeName);
		   }
		   else if (recipeType.equalsIgnoreCase("all recipe")){
			   recipeName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
			   System.out.println("Selected Recipe Name "+recipeName);
		   }
		   TasteBud.findTermNameViaSearch(recipeName);
		   searchRecipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
		   for (AndroidElement element : searchRecipeList){
			   if (element.getAttribute("name").equalsIgnoreCase(recipeName)){
				   element.click();
				   break;
			   }
		   }
		   /* Wait for moment for allow media content  */
		   SplashScreen.allowMediaFilesAndContacts();
		   /* Allow alcoholic beverage */
		   SplashScreen.acceptAlcoholicBeverage();
		   /* Select Unit System Measure Ingredients */
		   SplashScreen.selectUnitSystemMeasureIngredients();
		   Reusables.waitThread(3);
		   if (Reusables.isElementPresent(EntityDetailPageUpperPart.recipeHeaderTxt) == true){
			   Reusables.verifyEqualMessage(EntityDetailPageUpperPart.recipeName(), recipeName, "Error Message!Actual and Expected Recipe name not matched.");
		   }
		   
		   return recipeName;
	}
}
