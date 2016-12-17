package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class Courses {
	
	
	
	/**
	 * This method is used to click on the course button.
	 */
	public static void clickOnCourseButton(){
		try{
			HomePage.clickOnHomePageButton(DataConstants.coursesBtn);
		}catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>>> Course Page not loaded.. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Course Page Load or not.
	 */
	public static void verifyCoursePageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.courseHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Course Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the courses page.
	 */
	public static void navigateToCoursesCategoryPage(){
		clickOnCourseButton();
		Reusables.hideInterstitial();
		verifyCoursePageLoaded();
	}
	
	/**
	 * This method is used to verify course list
	 */
	public static void verifyCourseList(String typeOfDiet){
		String coursesName = "";
		List<String> coursesDbCategoryList;
		List<IOSElement> coursesList;
		try{
			coursesDbCategoryList = DatabaseConnection.coursesCategory(typeOfDiet);
			coursesList = Reusables.getIOSElementsList(TasteBud.categoryList);
			for (int i = 0; i < coursesList.size(); i++){
				coursesName = coursesList.get(i).getText();
				Reusables.verifyEqualMessage(coursesDbCategoryList.get(i), coursesName, "Error Message!Actual and Expected message not matched.");
				Logs.info("Courses Category Name "+coursesName+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Courses Category Name "+coursesName+" not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the random course name
	 * @return : Course Name
	 */
	public static String clickOnRandomCourseCategoryList(String typeOfDietName){
		String randomCoursesName = "";
		List<IOSElement> elementList;
		List<String> coursesDBCatList;
		try{
			elementList = Reusables.getIOSElementsList(TasteBud.categoryList);
			coursesDBCatList = DatabaseConnection.coursesCategory(typeOfDietName);
			randomCoursesName = coursesDBCatList.get(Reusables.randomNumber(coursesDBCatList.size()));
		    System.out.println("Courses Name..>"+randomCoursesName);
		    for(IOSElement element : elementList){
		    	if (element.getText().equalsIgnoreCase(randomCoursesName)==true){
		    		element.click();
		    		break;
		    	}
		    }
		}catch(NoSuchElementException e){
			Logs.error("Courses Name not clickable. "+e.getClass().getName());
		}
		
		return randomCoursesName;
	}
	
	
	//>>>>>>>>>>>>>>>>>> Course Terms Related Task <<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void verifyCourseTermPageLoaded(String expectedCourseName){
		try{
			Reusables.waitForIOSElement(TasteBud.headerTxt);
			Reusables.verifyEqualMessage(Reusables.getText(TasteBud.headerTxt), expectedCourseName, "Error Message!! Course Terms Page not loaded..");
		}catch(NoSuchElementException e){
			Logs.error("Courses Term Page Not Loaded. "+e.getClass().getName());
		}
	}

	
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
