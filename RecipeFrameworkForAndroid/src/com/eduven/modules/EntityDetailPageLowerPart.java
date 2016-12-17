package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EntityDetailPageLowerPart {
	
	
	/* Object Identification */
	public static By ingredientTxtView = By.name("Ingredients");
	public static By ingredientCount = By.id(DeviceRelatedInformation.getPackageName()+":id/main_parent_layout");
	public static By ingredientList = By.id(DeviceRelatedInformation.getPackageName()+":id/ingre_name");
	public static By methodTxtView = By.name("Method");
	public static By methodCount = By.id(DeviceRelatedInformation.getPackageName()+":id/centerText");
	public static By handfreeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/button_start_cooking");
	public static By methodTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/centerText");
	public static By voiceCommandHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/disclaimerText");
	public static By voiceCommandtxt = By.id(DeviceRelatedInformation.getPackageName()+":id/intro_text");
	public static By noThankxBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/cancel");
	
	public static By tagsTxtView = By.name("Tags");
	public static By tagsCount = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_tag_text");
	public static By tipsImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/tips_image");
	public static By tipsHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By nutritionImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/nutrition_image");
	public static By nutritionHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	
	/**
	 * This method is used to click on the Ingredients TextView.
	 */
	public static void clickOnIngredientTxtView(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(ingredientTxtView));
			Reusables.clickUsingElement(Reusables.getElement(ingredientTxtView));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> textview not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify ingredient element list.
	 */
	public static void verifyIngredientListCount(){
		try{
			Reusables.verifyElementCountExistance(ingredientCount);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> textview not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify ingredient values.
	 */
	public static void verifyIngredientNameList(String recipeName){
		List<String> ingredient_list;
		List<AndroidElement> list;
		try{
			String ingregientTxt = DatabaseConnection.ingredientsOnRecipeDetailPage(recipeName);
			ingredient_list = Reusables.getPatternListValue(ingregientTxt);
			clickOnIngredientTxtView();
			//System.out.println("Ingredient list "+ingredient_list);
			for (int i = 0;i < ingredient_list.size(); i++){
				while (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+WordUtils.capitalize(ingredient_list.get(i).trim())+"')]")) == false){
					list = Reusables.getElementsList(ingredientList);
					//System.out.println("List Size"+list.size());
					Reusables.swipeUp(list.get(list.size()-1), list.get(0));
					Reusables.waitThread(1);
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify ingredient name in ingredient list.
	 * @param ingredientName :
	 */
	public static void verifyIngredientNameInIngredientList(String ingredientName){
		List<AndroidElement> list;
		int i = 0;
		try{
			clickOnIngredientTxtView();
			list = Reusables.getElementsList(ingredientList);
			for (i = 0; i < list.size(); i++ ){
				if (list.get(i).getAttribute("name").contains(ingredientName)){ 
					break;
				}
				else if (i == list.size()){
					Reusables.swipeUp(list.get(list.size()-1), list.get(0));
					Reusables.waitThread(2);
					i = 0;
					}
				}
		}catch(NoSuchElementException e){
			Logs.error("Ingredients name not found in ingredient list. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify ingredient name not in ingredient list.
	 * @param ingredientName :
	 */
	public static void verifyIngredientNameNotInIngredientList(String ingredientName){
		List<AndroidElement> list;
		int i = 0;
		String lastName = "";
		String secondLastName = "";
		try{
			clickOnIngredientTxtView();
			list = Reusables.getElementsList(ingredientList);
			for (i = 0; i < list.size(); i++ ){
				lastName = list.get(list.size()-1).getAttribute("name").toString().trim();
				if (i == list.size()){
					Reusables.swipeUp(list.get(list.size()-1), list.get(0));
					Reusables.waitThread(2);
					secondLastName = list.get(list.size()-1).getAttribute("name").trim().toString();
					if (lastName.equalsIgnoreCase(secondLastName) == true){
						break;
					}
					i = 0;
					}
				}
		}catch(NoSuchElementException e){
			Logs.error("Ingredients name not found in ingredient list. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the tips image view.
	 * @return : Selected ingredient name.
	 */
	public static String clickOnIngredientTipsImageView(){
		String ingredientName = "";
		try{
			List<AndroidElement> tipsList = Reusables.getElementsList(tipsImageView);
			for (int i = 0; i < tipsList.size(); i++){
				tipsList.get(i).click();
				Reusables.waitForElement(tipsHeaderTxt);
				if (Reusables.getText(tipsHeaderTxt).contains("Benefits-") == true){
					ingredientName = Reusables.getText(tipsHeaderTxt).replaceAll("Benefits-", "").trim();
					System.out.println("Ingredient name "+ingredientName);
					//Reusables.verifyElementEnable(Reusables.getElement(tipsHeaderTxt), "Error Message!! Ingredient tips header text not found.");
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Ingredient tips header text not found. "+e.getClass().getName());
		}
		
		return ingredientName;
	}
	
	
	/**
	 * This method is used to verify ingredients benefits.
	 * @param ingredientsName
	 */
	public static void verifyIngredientsBenefits(String ingredientsName){
		List<String> benefitsDBList = DatabaseConnection.ingredientsBenefits(ingredientsName);
		try{
			for (int i = 0; i< benefitsDBList.size(); i++){
				/*while*/if (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+benefitsDBList.get(i).trim()+"')]")) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Logs.info("Benefits "+benefitsDBList.get(i).trim()+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient benefits are not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the ingredient nutrition image view.
	 */
	public static String clickOnIngredientNutritionImageView(){
		String ingredientName = "";
		try{
			List<AndroidElement> nutritionList = Reusables.getElementsList(nutritionImageView);
			for (int i = 0; i < nutritionList.size(); i++){
				nutritionList.get(i).click();
				if (Reusables.getText(nutritionHeaderTxt).contains("Nutrition-") == true){
					ingredientName = Reusables.getText(nutritionHeaderTxt).replaceAll("Nutrition-", "").trim();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Ingredient Nutrition Page not open."+e.getClass().getName());
		}
		
		return ingredientName;
	}
	
	//>>>>>>>>>>>>>>>>>>>> Method >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the Method TextView.
	 */
	public static void clickOnMethodTxtView(){
		try{
			if (Reusables.isElementPresent(methodTxtView) == false){
				Reusables.waitThread(2);
				Reusables.swipeLeft();
			}
			Reusables.waitForAndroidElement(Reusables.getElement(methodTxtView));
			Reusables.clickUsingElement(Reusables.getElement(methodTxtView));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Method textview not found. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to verify Method element list.
	 */
	public static void verifyMethodListText(String recipeName){
		String actualText = "";
		String expectedText = "";
		try{
			actualText = DatabaseConnection.methodText(recipeName);
			expectedText = Reusables.getText(methodTxt);
			Reusables.verifyEqualMessage(actualText, expectedText, "Error Message!Actual and Expected text not matched. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Method list not found. "+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to click on the handfree button
	 */
	public static void clickOnHandfreeButton(){
		try{
			Reusables.waitForElement(handfreeBtn);
			Reusables.clickCommand(handfreeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Hand free button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify voice command popup.
	 */
	public static void verifyVoiceCommandHeaderTxt(){
		try{
			Reusables.waitForElement(voiceCommandHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Hand free button popup not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the no thanks button.
	 */
	public static void clickOnNoThanksButton(){
		try{
			Reusables.waitForElement(noThankxBtn);
			Reusables.clickCommand(noThankxBtn);
		}catch(NoSuchElementException e){
			Logs.error("No Thanks button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify toast message.
	 */
	public static void verifyToastMessageForMethod(){
		String imageFilePath = "";
		try{
			imageFilePath = ScreenShot.takescreenShotCaptureForToast();
			Reusables.waitThread(2);
			Reusables.verifyToastMessageUsingImage(imageFilePath, DataConstants.toastMessageForMethod);
		}catch(NoSuchElementException e){
			Logs.error("Toast Message not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Tags TextView.
	 */
	public static void clickOnTagsTxtView(){
		try{
			if (Reusables.isElementPresent(tagsTxtView) == false){
				Reusables.waitThread(2);
				Reusables.swipeLeft();
			}
			Reusables.waitForElement(tagsTxtView);
			Reusables.clickCommand(tagsTxtView);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Tags textview not found. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to verify tags element list.
	 */
	public static void verifyTagsListCount(){
		try{
			Reusables.waitForElement(tagsCount);
			Reusables.verifyElementCountExistance(tagsCount);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Tags list textview not found. "+e.getClass().getName());
		}
	}
}
