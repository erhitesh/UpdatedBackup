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


public class Courses {
	
	
	/* Object Identification */
	public static By coursePageHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Courses");
	public static By coursesImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/courses2");
	public static By courseListTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/course_name");
	public static By recipeListTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	
	
	/**
	 * This method is used to return the instance of course button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement courseInstance(){
		
		return Reusables.getElement(coursesImageView);
	}
	
	/**
	 * This method is used to click on the course button.
	 */
	public static void clickOnCourseButton(){
		try{
			while (Reusables.isElementPresent(coursesImageView) == false){
				Reusables.swipeDown();
				Reusables.waitThread(1);
			}
			Reusables.waitForElement(coursesImageView);
			courseInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
		}catch(NoSuchElementException r){
			Logs.error("Course image view not found. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the course page.
	 */
	public static void navigateToCoursePage(){
		clickOnCourseButton();
	}
	
	/**
	 * This method is used to verify Course Page Load or not.
	 */
	public static void verifyCoursePageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.course_header_value);
		}catch(NoSuchElementException e){
			Logs.error("Course Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify course list.
	 * @param typeOfDiet : 
	 */
	public static void verifyCourseCategory(String typeOfDiet){
		AndroidElement element = null;
		String courseName = "";
		List<String> courseDbCategoryList;
		try {
			Reusables.waitThread(4);
			courseDbCategoryList = DatabaseConnection.coursesCategory(typeOfDiet);
			for (int i = 0; i < courseDbCategoryList.size(); i++) {
				courseName = courseDbCategoryList.get(i).trim();
				//System.out.println("Course Name"+courseName);
				if (courseName.equalsIgnoreCase("Hors D'oeuvre")){
					i = i +1;
					courseName = courseDbCategoryList.get(i).trim();
					//System.out.println("Course Name"+courseName);
				}
				while (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+courseName+"')]")) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.xpath("//*[contains(@text,'"+courseName+"')]"));
				Logs.info("Course Name "+ element.getAttribute("name").toString() + " Found.");
			}
		}catch (NoSuchElementException e) {
			Logs.error("Course Name " + element.getAttribute("name")+ " not found. " + e.getClass().getName());
		}
	}
	
	
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
			for (int i = 0; i < courseDbRecipeNameList.size(); i++) {
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
	
	/**
	 * This method is used to click on the random course name
	 * @param typeOfDiet :
	 * @return : Course Name, Type String
	 */
	public static String clickOnRandomCourseCategory(String typeOfDiet){
		String randomCourseName = "";
		int randomNumber = 0;
		List<String> courseCategoryList;
		try{
			courseCategoryList = DatabaseConnection.coursesCategory(typeOfDiet);
			randomNumber = Reusables.randomNumber(courseCategoryList.size());
			randomCourseName = courseCategoryList.get(randomNumber);
			if (randomCourseName.equalsIgnoreCase("Hors D'oeuvre")){
				randomNumber = randomNumber + 1;
				randomCourseName = courseCategoryList.get(randomNumber);
			}
			while (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+randomCourseName+"')]")) == false){
				Reusables.swipeUp();
				Reusables.waitThread(1);
			}
			Reusables.clickCommand(By.xpath("//*[contains(@text,'"+randomCourseName+"')]"));
			if (Reusables.isElementPresent(SplashScreen.alcoholicBeverageBtn) == true){
				SplashScreen.acceptAlcoholicBeverage();
			}
			if (Reusables.isElementPresent(SplashScreen.remineLaterBtn) == true){
				SplashScreen.remindLaterRecipeImage();
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Random Course Name not clickable. "+e.getClass().getName());
		}
		
		return randomCourseName;
	}
	
	
	//>>>>>>>>>>>>>>>>>> Course Terms Related Task <<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void verifyCourseTermPageLoaded(String expectedCourseName){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(coursePageHeaderTxt), expectedCourseName, "Error Message!! Course Terms Page not loaded..");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Course Term Page Not Loaded.."+e.getClass().getName());
		}
	}
}
