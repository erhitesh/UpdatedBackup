package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class RecipeDetailPage {
	

	/* Locator Identification */     
	public static By recipeHeaderTxt = By.id("Header");
	public static By shareBtn = By.id("share");
	public static By recipeNameTxt = By.id("recipe_name");
	public static By editEdubankBtn = By.id("fav plus");
	public static By servingsTxt = By.id("serving_value");
	public static By cookingTime = By.id("cook_time_value");
	public static By ratingBarByChef = By.id("default_rating");
	//>>>>>>>>>>>>>>>>>>>>>>> Nutrition Page >>>>>>>>>>>>>>>>>>>>>>>
	public static By recipeNutritionBtn = By.id("recipe_nutrition");
	public static By recipeNutritionTxt = By.id("recipe_name");
	public static By nutritionValue = By.id("nutrition_name");
	public static By nutritionQty = By.id("nutrition_quantity");
	public static By nutritionDri = By.id("nutrition_DRI");
	public static By nutritionDriInfo = By.id("info_button");
	public static By closeRecipeNutritionBtn = By.id("cross_button");
	//>>>>>>>>>>>>>>>>>>>>>> Menu Planner >>>>>>>>>>>>>>>>>>>>>>>>>
	public static By menuPlannerBtn = By.id("planner");
	public static By recipeNameOnMenuPlannerPage = By.id("recipe_name");
	public static By menuPlannerRadioBtns = By.xpath("//UIAButton[starts-with(@name,'radio_button_')]");
	public static By selectedDateAndTimeTxt = By.id("date_selected");
	public static By changeDateWheel = By.xpath("//UIAPickerWheel[1]");
	public static By submitMenuPlannerBtn = By.id("ADD");
	//>>>>>>>>>>>>>>>>>>>>> Ingredient >>>>>>>>>>>>>>>>>>>>>>>>>
	public static By ingredientsBtn = By.id("Ingredients");
	public static By ingredientNameTxtList = By.id("ingredient_name");
	public static By ingredientServingTxtList = By.id("ingredient_servings");
	public static By ingredientBenefitsBtnList = By.id("benefits icon");
	public static By ingredientNutritionBtnList = By.id("ingredient_nutrition");
	public static By benefitsHeaderTxt = By.id("Header");
	public static By ingredientsBenefitsTxtList = By.id("Ingredient_benefit");
	public static By ingredientNameTxt = By.id("ingredient_name");
	public static By ingredientInfoBtn = By.id("info_button");
	public static By ingredientNutritionNameTxt = By.id("nutrition_name");
	public static By ingredientNutritionQtyTxt = By.id("nutrition_quantity");
	public static By ingredientNutritionDriTxt = By.id("nutrition_DRI");
	//>>>>>>>>>>>>>>>>>>>>> Method >>>>>>>>>>>>>>>>>>>>>>>>>
	public static By methodBtn = By.id("Method");
	public static By methodText = By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]");
	public static By playMusicBtn = By.id("play music");
	public static By stopMusicBtn = By.id("stop music");
	//>>>>>>>>>>>>>>>>>>>>> Similar Recipes >>>>>>>>>>>>>>>>>>>>>>>>>
	public static By similarRecipeBtn = By.id("Similar Recipes");
	//>>>>>>>>>>>>>>>>>>>>> Tags >>>>>>>>>>>>>>>>>>>>>>>>>
	public static By tagsBtn = By.id("Tags");
	public static By segmentControl = By.id("segment_controller");
	public static By tagHeadTxt = By.id("tag_head");
	public static By tagValueTxt = By.id("tag_value");
	
	
	
	/**
	 * This method is used to verify Detail page loaded or not..
	 */
	public static void verifyDetailPagePageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyPageLoaded(DataConstants.detailPageHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Detail Page not Loaded. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get entity name.
	 */
	public static String recipeName(){
		String recipe_name = "";
		try{
			Reusables.waitForIOSElement(recipeNameTxt);
			recipe_name = Reusables.getText(recipeNameTxt);
			System.out.println("Recipe Name. "+recipe_name);
		}catch(NoSuchElementException e){
			Logs.error("Not found any recipe. "+e.getClass().getName());
		}
		return recipe_name;
	}
	
	/**
	 * This method is used to verify selected Recipe name on Recipe detail page.
	 */
	public static void verifyRecipeName(String expectedEntityName){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(recipeName(), expectedEntityName, "Error Message!! Recipe Name not matched...");
			}
		catch(NoSuchElementException e){
			Logs.error("Recipe Name not metched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to check the eduBank icon present or not
	 */
	public static void verifyAddEdubankButton(){
		try{
		Reusables.verifyElementPresent(Reusables.getIOSElement(editEdubankBtn), "Error Message! Favourite icon not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Favourite icon not present >>>"+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the eduBank
	 */
	public static void clickOnAddEdubankButton(){
		try{
			Reusables.waitForIOSElement(editEdubankBtn);
			Reusables.clickCommand(editEdubankBtn);
			}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the add to edubank buttom. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify free entity detail for favorite logo.
	 */
	public static void verificationForFreeRecipeTerm(String expectedRecipeName){
		verifyDetailPagePageLoaded();
		verifyRecipeName(expectedRecipeName);
		verifyAddEdubankButton();
	}
	
	
	
	/**
	 * This method is used to get the servings value.
	 * @return : Servings value.
	 */
	public static String recipeServingsValue(){
		String recipe_servings_value = "";
		try{
			Reusables.waitForIOSElement(servingsTxt);
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
		try{
			String serving_value = DatabaseConnection.recipeServings(typeOfDietName, recipeName);
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
		String recipeCookingTime = "";
		try{
			Reusables.waitForIOSElement(cookingTime);
			recipeCookingTime = Reusables.getText(cookingTime).replace("", "").trim();
		}catch(NoSuchElementException e){
			Logs.error("Recipe Cooking time value not found. "+e.getClass().getName());
		}
		
		return recipeCookingTime;
	}
	
	/**
	 * This method is used to verify Cooking Time value.
	 * @param typeOfDietName :
	 * @param recipeName :
	 */
	public static void verifyRecipeCookingTimeValue(String typeOfDietName, String recipeName){
		String recipeCookingTime = "";
		try{
			recipeCookingTime = DatabaseConnection.recipeActualTime(typeOfDietName, recipeName);
			Reusables.verifyEqualMessage(recipeCookingTime(), recipeCookingTime, "Error Message!Actual and Expected Cooking time not matched.");
		}catch(NoSuchElementException r){
			Logs.error("Actual and Expected Recipe Cooking time not matched. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the recipe rating value.
	 * @return : recipe rating value as String.
	 */
	public static String recipeRatingValue(){
		String recipeRatingValue = "";
		try{
			Reusables.waitForIOSElement(ratingBarByChef);
			recipeRatingValue = Reusables.getText(ratingBarByChef);
		}catch(NoSuchElementException e){
			Logs.error("Chef Rating value not found. "+e.getClass().getName());
		}
		
		return recipeRatingValue;
	}
	
	/**
	 * This method is used to verify chef rating value.
	 * @param typeOfDietName :
	 * @param recipeName :
	 */
	public static void verifyChefRecipeRatingValue(String typeOfDietName, String recipeName){
		String recipeRating = "";
		try{
			recipeRating = DatabaseConnection.recipeRatings(typeOfDietName, recipeName);
			Reusables.verifyEqualMessage(recipeRatingValue(), recipeRating, "Error Message!Actual and Expected Recipe Rating not matched.");
		}catch(NoSuchElementException r){
			Logs.error("Actual and Expected Recipe Rating not matched. "+r.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Recipe Nutrition Page >>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the nutrition button on detail page.
	 */
	public static void clickOnRecipeNutrition(){
		try{
			Reusables.waitForIOSElement(recipeNutritionBtn);
			Reusables.clickCommand(recipeNutritionBtn);
			Reusables.hideInterstitial();
			SplashScreen.hideAppRatePopUp();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Recipe Nutrition Button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify recipe name on nutrition page.
	 * @param recipeName : String type.
	 */
	public static void verifyRecipeNameOnNutritionPage(String recipeName){
		try{
			Reusables.waitForIOSElement(recipeNutritionTxt);
			recipeName = Reusables.getText(recipeNutritionTxt);
			Reusables.verifyEqualMessage(recipeName, recipeName, "Error Message!Actual and Expected recipe name not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected recipe name not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe nutrition value on recipe nutrition page.
	 */
	public static void verifyRecipeNutritionValue(){
		try{
			Reusables.verifyElementCountExistance(nutritionValue);
		}catch(NoSuchElementException e){
			Logs.error("Nutrition Value can not be zero. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe nutrition Quantity on recipe nutrition page.
	 */
	public static void verifyRecipeNutritionQty(){
		try{
			Reusables.verifyElementCountExistance(nutritionQty);
		}catch(NoSuchElementException e){
			Logs.error("Nutrition Quantity can not be zero. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify recipe nutrition Quantity on recipe nutrition page.
	 */
	public static void verifyRecipeNutritionDRI(){
		try{
			Reusables.verifyElementCountExistance(nutritionDri);
		}catch(NoSuchElementException e){
			Logs.error("Nutrition DRI can not be zero. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify dri alert popup.
	 */
	public static void recipeNutritionDriAlertPopup(){
		try{
			Reusables.waitForIOSElement(nutritionDriInfo);
			Reusables.clickCommand(nutritionDriInfo);
			if (Reusables.alertInstance() != null){
				if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.driAlertMessageTxt))
					Reusables.acceptAlert();
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("DRI value alert popup not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to close the nutrition alert popup.
	 */
	public static void closeRecipeNutritionPopUp(){
		try{
			Reusables.waitForIOSElement(closeRecipeNutritionBtn);
			Reusables.clickCommand(closeRecipeNutritionBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click operation is not perform on close button. "+e.getClass().getName());
		}
	}

	
	//>>>>>>>>>>>>>>>>>> Menu Planner Related task  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the menu planner.
	 */
	public static void clickOnMenuPlanner(){
		try{
			Reusables.waitForIOSElement(menuPlannerBtn);
			Reusables.clickCommand(menuPlannerBtn);;
		}catch(NoSuchElementException r){
			Logs.error("Click operation not perform on the Menu Planner button. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify recipe name on menu planner page.
	 * @param recipeName : String type.
	 */
	public static void verifyRecipeNameOnMenuPlannerPage(String recipeName){
		String expectedRecipeName = "";
		try{
			Reusables.waitForIOSElement(recipeNameOnMenuPlannerPage);
			expectedRecipeName = Reusables.getText(recipeNameOnMenuPlannerPage);
			Reusables.verifyEqualMessage(expectedRecipeName, recipeName, "Error Message!!Actual and Expected recipe name not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected recipe name not matched. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select planner type.
	 * @param : planner type, Type String
	 */
	public static void selectPlannerType(String plannerType){
		List<IOSElement> plannerTypeList;
		try{
			Reusables.waitForIOSElement(recipeNameOnMenuPlannerPage);
			plannerTypeList = Reusables.getIOSElementsList(menuPlannerRadioBtns);
			if (plannerType.equalsIgnoreCase("breakfast")){
				plannerTypeList.get(0).click();
			}
			else if (plannerType.equalsIgnoreCase("lunch")){
				plannerTypeList.get(1).click();
			}
			else if (plannerType.equalsIgnoreCase("dinner")){
				plannerTypeList.get(2).click();
			}
		}catch(NoSuchElementException r){
			Logs.error("Unable to select planner type. "+r.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to return the planner time based on planner type.
	 * @param planner_type : String value for planner time.
	 * @return : String value as planner time.
	 */
	public static String plannerTimeForPlannerType(String plannerType){
		String plannerTime = "";
		try{
			if (plannerType.equalsIgnoreCase("breakfast")){
				plannerTime = DataConstants.breakfastTiming;
			}
			else if (plannerType.equalsIgnoreCase("lunch")){
				plannerTime = DataConstants.lunchTiming;
			}
			else if (plannerType.equalsIgnoreCase("dinner")){
				plannerTime = DataConstants.dinnerTiming;
			}
			
		}catch(NoSuchElementException e){
			Logs.error("Planner time not found based on planner type. "+e.getClass().getName());
		}
		
		return plannerTime;
	}
	
	
	/**
	 * This method is used to get Planner time.
	 * @return String as time.
	 */
	public static String getPlannerTime(){
		String plannerTime = "";
		try{
			Reusables.waitForIOSElement(selectedDateAndTimeTxt);
			plannerTime = Reusables.getText(selectedDateAndTimeTxt);
			System.out.println("Time.."+plannerTime);
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
			Reusables.waitForIOSElement(selectedDateAndTimeTxt);
			Reusables.verifyElementTextPresent(selectedDateAndTimeTxt, expectedPlannerTime.trim());
		}catch(NoSuchElementException r){
			Logs.error("Planner Time not find. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to change planner date.
	 */
	public static void changeDate(){
		String date = "";
		try{
			date = Reusables.dayMonthDateCombination(new Date(), -1);
			Reusables.waitForIOSElement(changeDateWheel);
			Reusables.uiAPickerWheel(changeDateWheel, date);
			Reusables.waitThread(2);
			date = Reusables.dayMonthDateCombination(new Date(), 2);
			Reusables.uiAPickerWheel(changeDateWheel, date);
			Reusables.swipeDown();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the date wheel. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either select data alert popup display or not. 
	 */
	public static void verifyMenuPlannerAlertForEnterValidDate(){
		try{
			if (Reusables.alertInstance() != null){
				if (Reusables.getAlertMessage().contains(DataConstants.menuPlannerMessageForSelectDate))
					Reusables.acceptAlert();
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Please select date alert popup not display. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the add button on menu planner page.
	 */
	public static void submitMenuPlannerPage(){
		try{
			Reusables.waitForIOSElement(submitMenuPlannerBtn);
			Reusables.clickCommand(submitMenuPlannerBtn);
		}catch(NoSuchElementException e){
			Logs.error("Add button not found on menu planner page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to submit the planner alert message for successfully done.
	 * @param textMessage : String type for verify recipe name.
	 */
	public static void verifySuccessfullySubmitMenuPlannerAlert(String recipeName){
		try{
			if (Reusables.alertInstance() != null){
				if (Reusables.getAlertMessage().contains(recipeName))
					Reusables.acceptAlert();
				Reusables.waitThread(1);
			}
		}catch(NoAlertPresentException e){
			Logs.error("Alert popup not visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the ingredient button.
	 */
	public static void clickOnIngredientBtn(){
		try{
			Reusables.waitForIOSElement(ingredientsBtn);
			Reusables.clickCommand(ingredientsBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the ingredient button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify ingredient values.
	 */
	public static void verifyIngredientNameList(String recipeName){
		List<String> ingredientNameDBlist;
		List<IOSElement> ingredientNamelist;
		String ingredientName = "";
		try{
			ingredientNameDBlist = Reusables.getPatternListValue(DatabaseConnection.ingredientsOnRecipeDetailPage(recipeName));
			ingredientNamelist = Reusables.getIOSElementsList(ingredientNameTxtList);
			clickOnIngredientBtn();
			//System.out.println("Ingredient list "+ingredientNameDBlist);
			for (int i = 0;i < ingredientNameDBlist.size(); i++){
				ingredientName = ingredientNamelist.get(i).getText();
				Reusables.verifyEqualMessage(ingredientNameDBlist.get(i), ingredientName, "Error Message!!Actual and Expected ingredient not matched.");
				Logs.info("Ingredient Name "+ingredientName +" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient name not "+ingredientName+" found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify ingredient name in ingredient list.
	 * @param ingredientName :
	 */
	public static void verifyIngredientNameInIngredientList(String ingredientName){
		List<IOSElement> list;
		try{
			clickOnIngredientBtn();
			list = Reusables.getIOSElementsList(ingredientNameTxtList);
			for (int i = 0; i < list.size(); i++ ){
				if (list.get(i).getAttribute("name").contains(ingredientName)){ 
					break;
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
		List<IOSElement> ingredientNameList;
		int i = 0;
		try{
			clickOnIngredientBtn();
			ingredientNameList = Reusables.getIOSElementsList(ingredientNameTxtList);
			for (i = 0; i < ingredientNameList.size(); i++ ){
				if (ingredientNameList.get(i).getText().equalsIgnoreCase(ingredientName) == true){
					Reusables.waitThread(2);
					Assert.fail("Ingredient Name "+ingredientName +" Found.");
					break;
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
	public static String clickOnIngredientBenefitsBtn(String recipeName){
		String ingredientName = "";
		try{
			List<IOSElement> tipsList = Reusables.getIOSElementsList(ingredientBenefitsBtnList);
			for (int i = 0; i < tipsList.size(); i++){
				tipsList.get(i).click();
				if (Reusables.getText(benefitsHeaderTxt).contains("Benefits - "+recipeName) == true){
					ingredientName = Reusables.getText(benefitsHeaderTxt).replaceAll("Benefits - ", "").trim();
					System.out.println("Ingredient name "+ingredientName);
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
		List<String> ingredientsBenefitsNameDBList;
		List<IOSElement> ingredientsBenefitsNameList;
		String ingredientsBenefitsName = "";
		try{
			ingredientsBenefitsNameList = Reusables.getIOSElementsList(ingredientsBenefitsTxtList);
			ingredientsBenefitsNameDBList = DatabaseConnection.ingredientsBenefits(ingredientsName);
			for (int i = 0; i< ingredientsBenefitsNameDBList.size(); i++){
				ingredientsBenefitsName = ingredientsBenefitsNameList.get(i).getText();
				Logs.info("Benefits "+ingredientsBenefitsName+" found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient benefits "+ingredientsBenefitsName+" not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the ingredient nutrition image view.
	 */
	public static String clickOnIngredientNutritionBtn(){
		String ingredientName = "";
		List<IOSElement> nutritionList;
		try{
			nutritionList = Reusables.getIOSElementsList(ingredientNutritionBtnList);
			for (int i = 0; i < nutritionList.size(); i++){
				nutritionList.get(i).click();
				Reusables.waitForIOSElement(closeRecipeNutritionBtn);
				if (Reusables.isElementPresent(closeRecipeNutritionBtn) == true){
					ingredientName = Reusables.getText(ingredientNameTxt);
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Ingredient Nutrition Page not open."+e.getClass().getName());
		}
		
		return ingredientName;
	}
	
	
	/**
	 * This method is used to verify Ingredient Nutrition value on Ingredient Nutrition page.
	 * @param ingredientName : String type
	 */
	public static void verifyIngredientNutritionValue(String ingredientName){
		List<IOSElement> nutritionNameList;
		List<String> nutritionNameDBList;
		String nutritionName = "";
		try{
			nutritionNameDBList = DatabaseConnection.nutritionNameList(ingredientName);
			System.out.println(nutritionNameDBList);
			nutritionNameList = Reusables.getIOSElementsList(ingredientNutritionNameTxt);
			for (int i = 0; i < nutritionNameDBList.size(); i++){
				nutritionName = nutritionNameList.get(i).getText();
				Reusables.verifyEqualMessage(nutritionNameDBList.get(i).trim(), nutritionName, "Error Message!!Ingredient Nutrition Value not matched.");
				Logs.info("Ingredient Nutrition Value "+nutritionName+ "Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Nutrition Value"+nutritionName+ "Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Ingredient Nutrition Quantity on Ingredient Nutrition page.
	 * @param ingredientName : String type
	 */
	public static void verifyIngredientNutritionQty(String ingredientName){
		List<String> nutritionQtyDBList;
		List<IOSElement> nutritionQtyList;
		String nutritionQty = "";
		try{
			nutritionQtyList = Reusables.getIOSElementsList(ingredientNutritionQtyTxt);
			nutritionQtyDBList = (List<String>) DatabaseConnection.actualNutritionQuantityList(ingredientName);
			for (int i = 0; i < nutritionQtyDBList.size(); i++){
				nutritionQty = nutritionQtyList.get(i).getText();
				Reusables.verifyTextContains(nutritionQtyList.get(i).getText(), nutritionQtyDBList.get(i));
				Logs.info("Ingredient Nutrition qty "+nutritionQtyList.get(i).getText()+ "Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Ingredient Nutrition Quantity "+nutritionQty+" not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Ingredient Nutrition DRI value on Ingredient Nutrition page.
	 */
	public static void verifyIngredientNutritionDriValue(String ingredientName){
		/*List<String> nutritionDriDBList;
		List<IOSElement> nutritionDriList;
		String nutritionDriValue = "";
		try{
			nutritionDriList = Reusables.getIOSElementsList(ingredientNutritionDriTxt);
			nutritionDriDBList = (List<String>) DatabaseConnection.nutritionDriValues(ingredientName);
			for (int i = 0; i < nutritionDriDBList.size(); i++){
				nutritionDriValue = nutritionDriList.get(i).getText();
				Reusables.verifyTextContains(nutritionDriValue, nutritionDriDBList.get(i));
				Logs.info("Ingredient Nutrition DRI "+nutritionDriValue+" Found.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Nutrition DRI "+nutritionDriValue+" not found. "+e.getClass().getName());
		}*/
	}
	
	/**
	 * This method is used to close the nutrition alert popup.
	 */
	public static void closeIngredientNutritionPopUp(){
		try{
			Reusables.waitForIOSElement(closeRecipeNutritionBtn);
			Reusables.clickCommand(closeRecipeNutritionBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click operation is not perform on close button. "+e.getClass().getName());
		}
	}
	

	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Method Related Task >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the method button.
	 */
	public static void clickOnMethod(){
		try{
			Reusables.waitForIOSElement(methodBtn);
			Reusables.clickCommand(methodBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the method button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Method text message.
	 */
	public static void verifyMethodListText(/*String recipeName*/){
		try{
			Reusables.waitForIOSElement(methodText);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Method list not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the handfree button
	 */
	public static void clickOnHandfreeButton(){
		try{
			Reusables.waitForIOSElement(playMusicBtn);
			Reusables.clickCommand(playMusicBtn);
			Reusables.verifyElementPresent(Reusables.getIOSElement(stopMusicBtn), "Error Message!Pause button not found. ");
		}catch(NoSuchElementException e){
			Logs.error("Hand free button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the handfree button to pause button.
	 */
	public static void pauseHandfreeButton(){
		try{
			Reusables.waitForIOSElement(stopMusicBtn);
			Reusables.clickCommand(stopMusicBtn);
			Reusables.verifyElementPresent(Reusables.getIOSElement(playMusicBtn), "Error Message!Play button not found. ");
		}catch(NoSuchElementException e){
			Logs.error("Play button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the similar recipe button.
	 */
	public static void clickOnSimilarRecipe(){
		try{
			Reusables.waitForIOSElement(similarRecipeBtn);
			Reusables.clickCommand(similarRecipeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the similar recipe button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either similar recipe list exist or not.
	 */
	public static void verifySimilarRecipeList(){
		try{
			Reusables.verifyElementCountExistance(similarRecipeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Similar recipe not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Tag button.
	 */
	public static void clickOnTag(){
		try{
			Reusables.swipeLeft(Reusables.getIOSElement(similarRecipeBtn), Reusables.getIOSElement(ingredientsBtn));
			/*if (Reusables.elementVisiblity(tagsBtn) == false){
				Reusables.swipeLeft(Reusables.getIOSElement(tagsBtn), Reusables.getIOSElement(ingredientsBtn));
			}
			Reusables.waitForIOSElement(tagsBtn);
			Reusables.clickCommand(tagsBtn);*/
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Tags button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify tags heads and value should not be zero.
	 */
	public static void verifyTagHeadsAndValue(){
		try{
			Reusables.verifyElementCountExistance(tagHeadTxt);
			Reusables.verifyElementCountExistance(tagValueTxt);
		}catch(NoSuchElementException e){
			Logs.error("Tags Heads and value are zero. "+e.getClass().getName());
		}
	}
}
