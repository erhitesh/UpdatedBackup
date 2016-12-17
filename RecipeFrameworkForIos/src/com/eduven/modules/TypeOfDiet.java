package com.eduven.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class TypeOfDiet {

	/* Global Variable Declaration */
	static String typeOfDietNameFromDB;
	
	/* Object Identification */
	public static By typeOfDietList = By.name("type_of_diet");
	public static By vegetarianBtn = By.xpath("//*[@name='type_of_diet'][1]");
	public static By nonVegetarianBtn = By.xpath("//*[@name='type_of_diet'][2]");
	public static By veganBtn = By.xpath("//*[@name='type_of_diet'][3]");
	public static By allRecipesBtn = By.xpath("//*[@name='type_of_diet'][4]");
	public static By hideTypeOfDietPopup = By.name("cross");
	

	/**
	 * This method is used to verify the type of diet list name.
	 */
	public static void verifyTypeOfDietNameList(){
		try{
			Reusables.waitForIOSElement(HomePage.appNameTxt);
			List<String> typeOfDieList = DatabaseConnection.getTypeOfDietList();
			for (int i = 0; i < typeOfDieList.size(); i++){
				Reusables.verifyEqualMessage(Reusables.getTextFromList(typeOfDietList, i), typeOfDieList.get(i), "Error Messsage!!Actual and Expected Type of diet not matched.");
				Logs.info("Type Of Diet Name "+typeOfDieList.get(i)+" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Type of diet name not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify alert message not displayed.
	 */
	public static void verifyAlertMessage(){
		try{
			if (Reusables.isElementPresent(By.name("OK")) == true){
				Reusables.waitForAlert();
				Reusables.verifyEqualMessage(Reusables.getAlertMessage(), DataConstants.typeOfDietAlertMsg, "Error Message!!Alert messages not matched.");
			}
			else if (Reusables.isElementPresent(HomePage.appNameTxt)==true){
				HomePage.verifyHomePageHeaderTxt();
			}
		}catch(NoSuchElementException e){
			Logs.error("Alert Message Not displayed. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used select random type of diet.
	 * @return : selected type of diet name.
	 */
	public static String selectTypeOfDiet(String typeOfDietName){
		List<String> typeOfDietList = DatabaseConnection.getTypeOfDietList();
		try{
			if (Reusables.isElementPresent(vegetarianBtn) == true){
				if (typeOfDietName.equalsIgnoreCase("vegetarian")){
					Reusables.waitThread(1);
					Reusables.clickCommand(vegetarianBtn);
					typeOfDietNameFromDB = typeOfDietList.get(0);
				}
				else if (typeOfDietName.equalsIgnoreCase("non-vegetarian")){
					Reusables.waitThread(1);
					Reusables.clickCommand(nonVegetarianBtn);
					typeOfDietNameFromDB = typeOfDietList.get(1);
				}
				else if (typeOfDietName.equalsIgnoreCase("vegan")){
					Reusables.waitThread(1);
					Reusables.clickCommand(veganBtn);
					typeOfDietNameFromDB = typeOfDietList.get(2);
				}
				else if (typeOfDietName.equalsIgnoreCase("all")){
					Reusables.waitThread(1);
					Reusables.clickCommand(allRecipesBtn);
					typeOfDietNameFromDB = typeOfDietList.get(3);
				}
			}
			else if (Reusables.getText(HomePage.appNameTxt).equalsIgnoreCase("meat lovers") || Reusables.getText(HomePage.appNameTxt).equalsIgnoreCase("Seafood Recipes") || Reusables.getText(HomePage.appNameTxt).equalsIgnoreCase("vegan")){
				typeOfDietNameFromDB = DataConstants.typeOfDietForAll;
			}
			else if (Reusables.isElementPresent(HomePage.homePageBtn)){
				typeOfDietNameFromDB = typeOfDietList.get(0);
				Reusables.waitThread(2);
			}
			verifyAlertMessage();
			SplashScreen.hideAppRatePopUp();
			HomePage.verifyAppName();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the type of diet list name. "+e.getClass().getName());
		}
		
		return typeOfDietNameFromDB;
	}
	
	
}
