package com.eduven.modules;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EntityDetailPageUpperPart {
	
	
	/* Object Identification */
	public static By recipeHeaderTxt = By.xpath("//*[@text='Recipe Detail']");
	public static By recipeNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/text");
	public static By servingsTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/servings");
	public static By cookingTime = By.id(DeviceRelatedInformation.getPackageName()+":id/cooking_time");
	public static By ratingBarByChef = By.id(DeviceRelatedInformation.getPackageName()+":id/chef_rating_bar");
	public static By eduBankImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/favourites");
	//>>>>>>>>>>>>>>>>>>>>>>> Nutrition Page >>>>>>>>>>>>>>>>>>>>>>>
	public static By recipeNutrition = By.id(DeviceRelatedInformation.getPackageName()+":id/nutrition");
	public static By recipeNutritionHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By nutritionValue = By.id(DeviceRelatedInformation.getPackageName()+":id/nutrition_name");
	public static By nutritionQty = By.id(DeviceRelatedInformation.getPackageName()+":id/nutrition_value");
	public static By nutritionDri = By.id(DeviceRelatedInformation.getPackageName()+":id/nutrition_dri");
	public static By nutritionDriAlert = By.id(DeviceRelatedInformation.getPackageName()+":id/dri_info_button");
	//>>>>>>>>>>>>>>>>>>>>>>> Menu Planner >>>>>>>>>>>>>>>>
	public static By recipeMenuPlanner = By.id(DeviceRelatedInformation.getPackageName()+":id/planner");
	public static By menuPlannerHeadertxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By planNameTxtBox = By.id(DeviceRelatedInformation.getPackageName()+":id/name_edittext");
	public static By breakfastChk = By.id(DeviceRelatedInformation.getPackageName()+":id/breakfast_imageview");
	public static By lunchChk = By.id(DeviceRelatedInformation.getPackageName()+":id/lunch_imageview");
	public static By dinnerChk = By.id(DeviceRelatedInformation.getPackageName()+":id/dinner_imageview");
	public static By getTime = By.id(DeviceRelatedInformation.getPackageName()+":id/time_edit_text");
	public static By selectDate = By.id(DeviceRelatedInformation.getPackageName()+":id/date_edit_text");
	public static By submitMenuPlanner = By.id(DeviceRelatedInformation.getPackageName()+":id/add_button");
	public static By selectMonthDayYearValue = By.id("android:id/numberpicker_input");
	public static By submitDateBtn = By.id("android:id/button1");
	
	public static By dayTxtView = By.id("android:id/date_picker_day");
	public static By monthTxtView = By.id("android:id/date_picker_month");
	public static By yearTxtView = By.id("android:id/date_picker_year");
	public static By yearValue = By.id("android:id/month_text_view");
	
	public static By yearValueForMas = By.id("android:id/date_picker_header_year");
	public static By nextBtn = By.id("android:id/next");
	public static By monthViewForMar = By.id("android:id/month_view"); 
	public static By dayValueCountForMar = By.className("android.view.View");
	public static By shareTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/share");
	
	public static By alertMessagePopup = By.id("android:id/message");
	public static By acceptAlertBtn = By.id("android:id/button1");
	
	
	/**
	 * This method is used to verify recipe detail page loaded or not.
	 */
	public static void verifyRecipeDetailPageLoaded(){
		try{
			Reusables.waitForElement(recipeHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.detail_page_header);
		}catch(NoSuchElementException e){
			Logs.error("Recipe Detail page not loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the recipe name.
	 * @return : String as recipe name.
	 */
	public static String recipeName(){
		String recipeNameValue = "";
		try{
			Reusables.waitForElement(recipeHeaderTxt);
			List<AndroidElement> elementList = Reusables.getElementsList(recipeNameTxt);
			if (elementList.size() == 1) {
				recipeNameValue = elementList.get(0).getAttribute("name");
			}
			else if (elementList.size() >= 2){
				recipeNameValue = elementList.get(1).getAttribute("name");
			}
		}catch(NoSuchElementException e){
			Logs.error("Recipe Name not found. "+e.getClass().getName());
		}
		
		System.out.println("Recipe Name.. "+recipeNameValue);
		return recipeNameValue;
	}
	
	
	/**
	 * This method is used to verify recipe name on detial page.
	 * @param expectedRecipeName : String type for verifing the actual recipe name with expected one.
	 */
	public static void verifyRecipeName(String expectedRecipeName){
		try{
			Reusables.waitForElement(recipeHeaderTxt);
			Reusables.verifyEqualMessage(recipeName(), expectedRecipeName, "Error Message!Actual and expected recipe name not matched. ");
		}catch(NoSuchElementException e){
			Logs.error("Actual and expected recipe name not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the servings value.
	 * @return : Servings value.
	 */
	public static String recipeServingsValue(){
		String recipe_servings_value = "";
		try{
			Reusables.waitForElement(servingsTxt);
			recipe_servings_value = Reusables.getText(servingsTxt).replace("Servings:", "").trim();
		}catch(NoSuchElementException e){
			Logs.error("Recipe Servings value not found. "+e.getClass().getName());
		}
		
		return recipe_servings_value;
	}
	
	/**
	 * This method is used to verify servings value.
	 * @param typeOfDietName :
	 * @param recipeName :
	 */
	public static void verifyRecipeServingsValue(String typeOfDietName, String recipeName){
		String serving_value = "";
		try{
			serving_value = DatabaseConnection.recipeServings(typeOfDietName, recipeName);
			Reusables.verifyEqualMessage(serving_value, recipeServingsValue(), "Error Message!Actual and Expected Recipe Servings value not matched.");
		}catch(NoSuchElementException r){
			Logs.error("Actual and Expected Recipe Servings value not matched. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the cooking time value.
	 * @return : cooking time value.
	 */
	public static String recipeCookingTime(){
		String recipe_cooking_time_value = "";
		try{
			Reusables.waitForElement(cookingTime);
			recipe_cooking_time_value = Reusables.getText(cookingTime).replace("Servings:", "").trim();
		}catch(NoSuchElementException e){
			Logs.error("Recipe Cooking time value not found. "+e.getClass().getName());
		}
		
		return recipe_cooking_time_value;
	}
	
	/**
	 * This method is used to verify Cooking Time value.
	 * @param typeOfDietName :
	 * @param recipeName :
	 */
	public static void verifyRecipeCookingTimeValue(String typeOfDietName, String recipeName){
		String recipe_cooking_time = "";
		try{
			recipe_cooking_time = DatabaseConnection.recipeActualTime(typeOfDietName, recipeName);
			Reusables.verifyEqualMessage(recipeCookingTime(), recipe_cooking_time, "Error Message!Actual and Expected Cooking time not matched.");
		}catch(NoSuchElementException r){
			Logs.error("Actual and Expected Recipe Cooking time not matched. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the recipe rating value.
	 * @return : recipe rating value as String.
	 */
	public static String recipeRatingValue(){
		String recipe_rating_value = "";
		try{
			Reusables.waitForElement(ratingBarByChef);
			recipe_rating_value = Reusables.getText(ratingBarByChef);
		}catch(NoSuchElementException e){
			Logs.error("Chef Rating value not found. "+e.getClass().getName());
		}
		
		return recipe_rating_value;
	}
	
	/**
	 * This method is used to verify chef rating value.
	 * @param typeOfDietName :
	 * @param recipeName :
	 */
	public static void verifyChefRecipeRatingValue(String typeOfDietName, String recipeName){
		String recipe_rating = "";
		try{
			recipe_rating = DatabaseConnection.recipeRatings(typeOfDietName, recipeName);
			Reusables.verifyEqualMessage(recipeRatingValue(), recipe_rating, "Error Message!Actual and Expected Recipe Rating not matched.");
		}catch(NoSuchElementException r){
			Logs.error("Actual and Expected Recipe Rating not matched. "+r.getClass().getName());
		}
	}
	
	
	
	/**
	 * This method is used to click on the nutrition button on detail page.
	 */
	public static void clickOnRecipeNutrition(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(recipeNutrition));
			Reusables.clickUsingElement(Reusables.getElement(recipeNutrition));
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the Recipe Nutrition Page. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify recipe nutrition text on recipe nutrition page.
	 */
	public static void VerifyRecipeNutritionHeaderTxt(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(recipeNutritionHeaderTxt), "Error Message!! Recipe nutrition header text not present.");
		}catch(NoSuchElementException e){
			Logs.error("Recipe nutrition header text not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe nutrition value on recipe nutrition page.
	 */
	public static void verifyRecipeNutritionValue(){
		try{
			Reusables.verifyElementCountExistance(nutritionValue);
		}catch(NoSuchElementException e){
			Logs.error("Recipe Nutrition Value can not be zero. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe nutrition Quantity on recipe nutrition page.
	 */
	public static void verifyRecipeNutritionQty(){
		try{
			Reusables.verifyElementCountExistance(nutritionQty);
		}catch(NoSuchElementException e){
			Logs.error("Recipe Nutrition Quantity can not be zero. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify recipe nutrition Quantity on recipe nutrition page.
	 */
	public static void verifyRecipeNutritionDriValue(){
		try{
			Reusables.verifyElementCountExistance(nutritionDri);
		}catch(NoSuchElementException e){
			Logs.error("Recipe Nutrition DRI can not be zero. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Ingredient Nutrition value on Ingredient Nutrition page.
	 * @param ingredientName : String type
	 */
	public static void verifyIngredientNutritionValue(String ingredientName){
		try{
			List<String> list = DatabaseConnection.nutritionNameList(ingredientName);
			for (int i = 0; i < list.size(); i++){
				if (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+list.get(i)+"')]")) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Logs.info("Ingredient Nutrition Value "+list.get(i)+ "Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Nutrition Value can not be zero. "+e.getClass().getName());
		}
	}
	
	
/*	*//**
	 * This method is used to verify Ingredient Nutrition Quantity on Ingredient Nutrition page.
	 * @param ingredientName : String type
	 *//*
	@SuppressWarnings("unchecked")
	public static void verifyIngredientNutritionQty(String ingredientName){
		try{
			while (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+DatabaseConnection.actualNutritionNameList(ingredientName).get(0)+"')]")) == false){
				Reusables.swipeDown();
				Reusables.waitThread(1);
			}
			List<String> nutrition_qty = (List<String>) DatabaseConnection.nutritionValue(ingredientName).get(1);
			for (int i = 0; i < nutrition_qty.size(); i++){
				if (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+nutrition_qty.get(i)+"')]")) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Logs.info("Ingredient Nutrition qty "+nutrition_qty.get(i)+ "Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Nutrition Quantity can not be zero. "+e.getClass().getName());
		}
	}
	*/
	
	/**
	 * This method is used to verify Ingredient Nutrition Quantity on Ingredient Nutrition page.
	 * @param ingredientName : String type
	 */
	public static void verifyIngredientNutritionQty(String ingredientName){
		try{
			while (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+DatabaseConnection.nutritionNameList(ingredientName).get(0)+"')]")) == false){
				Reusables.swipeDown();
				Reusables.waitThread(1);
			}
			List<String> nutrition_qty = (List<String>) DatabaseConnection.actualNutritionQuantityList(ingredientName);
			for (int i = 0; i < nutrition_qty.size(); i++){
				long d = Math.round(Float.parseFloat(nutrition_qty.get(i))*100/100.00);
				if (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+d+"')]")) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Logs.info("Ingredient Nutrition qty "+nutrition_qty.get(i)+ "Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Nutrition Quantity can not be zero. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Ingredient Nutrition DRI value on Ingredient Nutrition page.
	 */
	public static void verifyIngredientNutritionDriValue(String ingredientName){
		String nutritionDriValue = "";
		List<String> nutrition_dri;
		int i = 0;
		try{
			while (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+DatabaseConnection.nutritionNameList(ingredientName).get(0)+"')]")) == false){
				Reusables.swipeDown();
				Reusables.waitThread(1);
			}
			nutrition_dri = (List<String>) DatabaseConnection.nutritionDriValues(ingredientName);
			for (i = 0; i < nutrition_dri.size(); i++){
				nutritionDriValue = nutrition_dri.get(i);
				if (nutritionDriValue==null){
					i++;
					/*nutritionDriValue = "-";
					Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[contains(@text,'-'])")), "Error Message!Dri Value not found");*/
				}
				else if (Reusables.isElementPresent(By.xpath("//*[starts-with(@text,'"+nutritionDriValue+"')]")) == false){
					Reusables.swipeUp();
					Reusables.waitThread(1);
				}
				Logs.info("Ingredient Nutrition DRI "+nutrition_dri.get(i)+ "Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Nutrition DRI can not be zero. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify dri value.
	 */
	public static void nutritionDriAlertPopup(){
		try{
			Reusables.waitForElement(nutritionDriAlert);
			Reusables.clickCommand(nutritionDriAlert);
			Reusables.verifyElementTextPresent(alertMessagePopup, DataConstants.dri_alert_message);
			Reusables.waitForElement(acceptAlertBtn);
			Reusables.clickCommand(acceptAlertBtn);
		}catch(NoSuchElementException e){
			Logs.error("DRI value alert popup not visible. "+e.getClass().getName());
		}
	}
	

	
	//>>>>>>>>>>>>>>>>>>> Menu Planner >>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the menu planner.
	 */
	public static void clickOnMenuPlanner(){
		try{
			Reusables.waitForElement(recipeMenuPlanner);
			Reusables.clickUsingElement(Reusables.getElement(recipeMenuPlanner));
		}catch(NoSuchElementException r){
			Logs.error(">>>>>> Recipe Menu Planner button not found. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify menu planner header text.
	 */
	public static void verifyMenuPlannerHeaderTxt(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(menuPlannerHeadertxt));
			Reusables.verifyPageLoaded(DataConstants.menu_planner_header_txt);
		}catch(NoSuchElementException r){
			Logs.error(">>>>>>Menu Planner header text not found. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to set the plan name.
	 */
	public static void setPlanName(){
		String planName = Reusables.randomTextGen(6);
		try{
			planName = Reusables.randomTextGen(6);
			Reusables.enterMessageInTextBox(planNameTxtBox, planName);
		}catch(NoSuchElementException r){
			Logs.error(">>>>>> Unable to set the random plan name. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select planner type.
	 * @param : planner type, Type String
	 */
	public static void selectPlannerType(String plannerType){
		try{
			Reusables.waitForElement(breakfastChk);
			if (plannerType.equalsIgnoreCase("breakfast")){
				Reusables.clickUsingElement(Reusables.getElement(breakfastChk));
			}
			else if (plannerType.equalsIgnoreCase("lunch")){
				Reusables.clickUsingElement(Reusables.getElement(lunchChk));
			}
			else if (plannerType.equalsIgnoreCase("dinner")){
				Reusables.clickUsingElement(Reusables.getElement(dinnerChk));
			}
		}catch(NoSuchElementException r){
			Logs.error(">>>>>> Unable to select planner type. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to return the planner time based on planner type.
	 * @param planner_type : String value for planner time.
	 * @return : String value as planner time.
	 */
	public static String plannerTimeForPlannerType(String planner_type){
		String planner_time = "";
		try{
			if (planner_type.equalsIgnoreCase("breakfast")){
				planner_time = DataConstants.breakfastTiming;
			}
			else if (planner_type.equalsIgnoreCase("lunch")){
				planner_time = DataConstants.lunchTiming;
			}
			else if (planner_type.equalsIgnoreCase("dinner")){
				planner_time = DataConstants.dinnerTiming;
			}
			
		}catch(NoSuchElementException e){
			Logs.error("Planner time not found based on planner type. "+e.getClass().getName());
		}
		
		return planner_time;
	}
	
	
	/**
	 * This method is used to get Planner time.
	 * @return String as time.
	 */
	public static String getPlannerTime(){
		String plannerTime = "";
		try{
			Reusables.waitForElement(getTime);
			plannerTime = Reusables.getText(getTime);
			//System.out.println("Time.."+plannerTime);
		}catch(NoSuchElementException r){
			Logs.error(">>>>>> Unable to fetch planner time. "+r.getClass().getName());
		}
		
		return plannerTime;
	}
	
	/**
	 * This method is used to click on the menu planner.
	 */
	public static void verifyPlannerTimeAfterSelectPlannerType(String expectedPlannerTime){
		try{
			Reusables.waitForElement(getTime);
			Reusables.verifyEqualMessage(getPlannerTime(), expectedPlannerTime.trim(), "Error Message!! Planner Time not Matched.");
		}catch(NoSuchElementException r){
			Logs.error("Planner Time not Matched. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on date link.
	 */
	public static void clickOnDateLink(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(selectDate));
			Reusables.clickCommand(selectDate);
		}catch(NoSuchElementException r){
			Logs.error("Date textview not found. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select date using calendar view for MashMallow.
	 */
	public static void selectDateForMash(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(nextBtn));
			Reusables.clickUsingElement(Reusables.getElement(nextBtn));
			List<MobileElement> daysCount = Reusables.getElement(monthViewForMar).findElements(dayValueCountForMar);
//			System.out.println("Days Count.."+daysCount.size());
			daysCount.get(Reusables.randomNumber(daysCount.size()-1)).click();
			
		}catch(NoSuchElementException e){
			Logs.error("Calendar view not open.. for mashmallow "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select date using calendar view for LoLipop.
	 */
	public static void selectDateUsingCalendarView(){
		try{
			int random_day_value = Reusables.randomNumber(25);
			Reusables.clickUsingElement(Reusables.getElement(monthTxtView));
			Reusables.waitThread(2);
			Reusables.clickUsingElement(Reusables.getElement(By.xpath("//*[@index='"+random_day_value+"']")));
			Reusables.waitForElement(yearTxtView);
			Reusables.clickUsingElement(Reusables.getElement(yearTxtView));
			Reusables.waitThread(2);
			selectYear();
			
		}catch(NoSuchElementException e){
			Logs.error("Calendar view not open.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select year value
	 */
	public static void selectYear(){
		   List<AndroidElement> element = Reusables.getElementsList(yearValue);
		   if (element.size() == 5 || element.get(3).getText().equals("2017")){
			   element.get(3).click();
		   }
	}
	
	
	/**
	 * This method is used to select date value from open calendar pop up for kitKat.
	 */
	public static void selectDateValue(int valueindex, String fieldValue){
		AndroidElement dateInstance;
		try{
			Reusables.waitThread(1);
			dateInstance = Reusables.getElementsList(selectMonthDayYearValue).get(valueindex);
			dateInstance.click();
			dateInstance.clear();
			dateInstance.sendKeys(fieldValue);
		}
		catch(NoSuchElementException e){
			Logs.error("Showing Month value not selected. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to submit the select date value.
	 */
	public static void submitDatePopUp(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(submitDateBtn));
			Reusables.clickUsingElement(Reusables.getElement(submitDateBtn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>> Done Button Still visible... "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select date.
	 */
	public static void selectDate(){
		try{
			clickOnDateLink();
			if (Reusables.isElementPresent(monthTxtView) == true){
//				System.out.println("For Lollipop");
				selectDateUsingCalendarView();
			}
			else if (Reusables.isElementPresent(selectMonthDayYearValue) == true) {
//				System.out.println("For Kitkat");
				selectDateValue(0, "May");
				selectDateValue(1, "04");
				selectDateValue(2, "1992");
			}
			else if (Reusables.isElementPresent(yearValueForMas) == true){
//				System.out.println("For MarshMallow");
				selectDateForMash();
			}
			submitDatePopUp();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Calendar view not open.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify menu planner toast message.
	 * @param toastMessage : String type for searching text in toast text.
	 */
	public static void verifyToastMessageForMenuPlanner(String toastMessage){
		String imageFilePath = "";
		try{
			imageFilePath = ScreenShot.takescreenShotCaptureForToast();
			Reusables.waitThread(2);
			Reusables.verifyToastMessageUsingImage(imageFilePath, toastMessage);
		}catch(NoSuchElementException e){
			Logs.error("Menu Planner toast message not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the add button on menu planner page.
	 */
	public static void submitMenuPlannerPage(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(submitMenuPlanner));
			Reusables.clickUsingElement(Reusables.getElement(submitMenuPlanner));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Add button not found on menu planner page. "+e.getClass().getName());
		}
	}
}
