package com.eduven.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class TypeOfDiet {

	/* Global Variable Declaration */
	static String type_of_diet_name_from_db;
	
	/* Object Identification */
	public static By appNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_Title");
	public static By vegetarianImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/veg_pref");
	public static By nonVegetarianImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/non_veg_pref");
	public static By veganImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/vegan_pref");
	public static By allRecipeImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/all_pref");
	public static By skipToAppTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/textview_skip");
	
	
	/**
	 * This method is used to verify the type of diet list name.
	 */
	public static void verifyTypeOfDietNameList(){
		try{
			List<String> typeOfDieList = DatabaseConnection.verifyTypeOfDietList();
			for (int i = 0; i < typeOfDieList.size(); i++){
				Reusables.verifyElementPresent(Reusables.getElement(By.name(typeOfDieList.get(i))), "Error Messsage!!Type of diet name not found.");
				Logs.info("Type Of Diet Name "+typeOfDieList.get(i)+" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Type of diet name not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the skip to App text view.
	 */
	public static void clickOnSkipToAppTxtView(){
		try{
			Reusables.waitThread(3);
			while (Reusables.isElementPresent(HomePage.nextArrow)){
				Reusables.clickCommand(HomePage.nextArrow);
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.warn("Skip To App textview not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the value of selected type of diet name.
	 * @return : String as type of diet name.
	 */
	public static String selectFirstTypeOfDiet(){
		String firstTypeOfDietName = "";
		try{
			Reusables.waitForElement(vegetarianImageView);
			Reusables.clickCommand(vegetarianImageView);
			clickOnSkipToAppTxtView();
			Reusables.waitForElement(HomePage.home_page_header_txt);
		}catch(NoSuchElementException e){
			Logs.error("Type of diet name not found. "+e.getClass().getName());
		}
		
		return firstTypeOfDietName;
	}
	
	
	/**
	 * This method is used select random type of diet.
	 * @return : selected type of diet name.
	 */
	public static String selectTypeOfDiet(String typeOfDietName){
		List<String> typeOfDietList = DatabaseConnection.getTypeOfDietList();
		try{
			if (Reusables.isElementPresent(vegetarianImageView) == true){
				if (typeOfDietName.equalsIgnoreCase("vegetarian")){
					Reusables.waitThread(1);
					Reusables.clickCommand(vegetarianImageView);
					type_of_diet_name_from_db = typeOfDietList.get(0);
				}
				else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
					Reusables.waitThread(1);
					Reusables.clickCommand(nonVegetarianImageView);
					type_of_diet_name_from_db = typeOfDietList.get(1);
				}
				else if (typeOfDietName.equalsIgnoreCase("vegan")){
					Reusables.waitThread(1);
					Reusables.clickCommand(veganImageView);
					type_of_diet_name_from_db = typeOfDietList.get(2);
				}
				else if (typeOfDietName.equalsIgnoreCase("all")){
					Reusables.waitThread(1);
					Reusables.clickCommand(allRecipeImageView);
					type_of_diet_name_from_db = typeOfDietList.get(3);
				}
				clickOnSkipToAppTxtView();
				HomePage.verifyHomePageHeaderTxt();
			}
			else if (Reusables.getText(HomePage.appNameTxt).equalsIgnoreCase("meat lovers")){
				Reusables.verifyElementTextPresent(HomePage.appNameTxt, DataConstants.appName);
				type_of_diet_name_from_db = DataConstants.typeOfDietForAll;
			}
			else if (Reusables.getText(HomePage.appNameTxt).equalsIgnoreCase("seafood")){
				Reusables.verifyElementTextPresent(HomePage.appNameTxt, DataConstants.appName);
				type_of_diet_name_from_db = DataConstants.typeOfDietForAll;
			}
			else if (Reusables.isElementPresent(HomePage.home_page_header_txt) == true){
				HomePage.verifyHomePageHeaderTxt();
				type_of_diet_name_from_db = DataConstants.typeOfDietForVegetarian;
			}
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the type of diet list name. "+e.getClass().getName());
		}
		
		return type_of_diet_name_from_db;
	}
}
