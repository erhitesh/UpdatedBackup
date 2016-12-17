package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Categories {

	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By categoryHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tab_title");
	public static By categoryList = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By categoryTermCount = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_number");
	
	/**
	 * This method is used to verify category header text.
	 */
	public static void verifyCategoryHeaderTxt(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElement(categoryHeaderTxt), "Error Message!! Category Header text not found.");
		}catch(NoSuchElementException e){
			Logs.error("Category Header text not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get category values and hold it in a list.
	 * @param languageName : String type, 
	 * @return : List as categories values.
	 */
	public static List<String> getCategoryList(String languageName){
		List<String> category_list = new ArrayList<String>();
		try{
			category_list = DatabaseConnection.getMainCategories(languageName);
		}catch(NoSuchElementException e){
			Logs.error("Category List not found. "+e.getClass().getName());
		}

		return category_list;
	}
	
	
	/**
	 * This method is used to get get term count value.
	 * @param mainCategoryName : category name for get count value. 
	 * @return : integer.
	 */
	public static int dataTermCount(String mainCategoryName){
		int term_count = 0;
		try{
			term_count = DatabaseConnection.getTermList(mainCategoryName, LanguageCategoryPage.languageSelectionValue).size();
		}catch(NoSuchElementException e){
			Logs.error("Term count not found. "+e.getClass().getName());
		}
		
		return term_count;
	}
	
	
	/**
	 * This method is used to get get term count value as ArrayList.
	 * @param categorylist : ArrayList value for 
	 * @return : ArrayList of int type.
	 */
	public static ArrayList<Integer> dataTermCountList(List<String> categorylist){
		ArrayList<Integer> list = new ArrayList<Integer>();
		try{
			for (int i = 0; i < categorylist.size(); i++){
				list.add(DatabaseConnection.getTermList(categorylist.get(i), LanguageCategoryPage.languageSelectionValue).size());
			}
		}catch(NoSuchElementException e){
			Logs.error("Term count not found. "+e.getClass().getName());
		}
		
		return list;
	}
	
	
	/**
	 * This method is used to click on the random number 
	 * @return : String, as random name.
	 */
	public static String clickOnRandomCategory(){
		String randomName = "";
		int randomNumber = 0;
		String firstLastName = "";
		String secondLastName = "";
		try{
			List<String> dbList = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue);
			randomNumber = Reusables.randomNumber(dbList.size());
			randomName = dbList.get(randomNumber);
			System.out.println("Random Name..>"+randomName);
			while (Reusables.isElementPresent(By.name(randomName)) == false){
				AndroidElement firstLastElement = Reusables.getElementsList(categoryList).get(Reusables.getElementsList(categoryList).size()-1);
				firstLastName = firstLastElement.getText();
				Reusables.swipeUp();
				Reusables.waitThread(1);
				AndroidElement secondLastElement = Reusables.getElementsList(categoryList).get(Reusables.getElementsList(categoryList).size()-1);
				secondLastName = secondLastElement.getText();
				if (firstLastName.equals(secondLastName) == true){
					while (Reusables.isElementPresent(By.name(randomName)) == false){
						Reusables.swipeDown();
						}
					}
				else if (firstLastName.equals(secondLastName) == false){
				}
			}
			Reusables.clickCommand(By.name(randomName));
			if (DeviceRelatedInformation.getDeviceVersionName().contains("Marsmallow")){
				SplashScreen.allowMediaFileAccessPopup();
			}
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on random name. "+e.getClass().getName());
		}
		
		return randomName;
	}
	
	
	/**
	 * This method is used to verify particular category on category page.
	 * @param categoryName : String type categoryName for comparison.
	 */
	public static void verifySpecificCategory(String categoryName){
		List<String> categoryList;
		try{
			categoryList = DatabaseConnection.getMainCategories(LanguageCategoryPage.languageSelectionValue);
			for (int i = 0; i < categoryList.size(); i++){
				while (Reusables.isElementPresent(By.name(categoryList.get(i))) == false){
					Reusables.swipeUp();
				    if (categoryList.get(categoryList.size() - 1).equalsIgnoreCase(categoryName) == false){
				    	break;
					}
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Category Name found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify category list after change the base language.
	 * @param languageName : for selecting different value for different category.
	 */
	public static void verifyCategoryListAfterChangeBaseLangugae(String languageName){
		try{
			Reusables.waitForElement(categoryHeaderTxt);
			String expectedFirstCategoryName = getCategoryList(languageName).get(0);
			String actualFirstCategoryName = Reusables.getElementsList(categoryList).get(0).getText();
			Reusables.verifyEqualMessage(actualFirstCategoryName, expectedFirstCategoryName, "Error Message!! Actual and expected category not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected category not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify category term count.
	 * @param categorylist : List type 
	 */
	public static void verifyCategoryTermCount(List<String> categorylist){
		AndroidElement element = null;
		int termCount = 0;
		try{
			Reusables.waitThread(4);
			while (Reusables.isElementPresent(By.name(categorylist.get(0))) == false){
				Reusables.swipeDown();
				Reusables.waitThread(1);
				}
			List<Integer> category_term_count = dataTermCountList(categorylist);
			for (int i = 0; i < category_term_count.size(); i++){
				/*if (i % elementCount == 0 && i / elementCount >= 1){
					Reusables.swipeUp();
					Reusables.waitThread(1);
					}*/
				termCount = category_term_count.get(i);
				if (Reusables.isElementPresent(By.name(""+termCount)) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
                element = Reusables.getElement(By.name(""+termCount));
                Reusables.waitForAndroidElement(element);
                //Logs.info("Category term count. "+element.getAttribute("name").toString()+" Found.");
				}
		}catch(NoSuchElementException e){
			Logs.error("Term count "+element.getAttribute("name")+" not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to back to game page.
	 */
	public static void backToHomePage(){
		try{
			Reusables.waitThread(1);
			while (Reusables.isElementPresent(Search.searchBtn) == false){
				Reusables.stepBack();
			}
		}catch(NoSuchElementException e){
			Logs.error("Games Page not found. "+e.getClass().getName());
		}
	}
}
