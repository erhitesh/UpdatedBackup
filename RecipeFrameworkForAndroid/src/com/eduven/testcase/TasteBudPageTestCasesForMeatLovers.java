package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EntityDetailPageLowerPart;
import com.eduven.modules.EntityDetailPageUpperPart;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TasteBud;
import com.eduven.modules.TasteBudForMeatLovers;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class TasteBudPageTestCasesForMeatLovers {
	
	
	/* Global Variable Declaration */
	String tasteBudCategoryName = "";
	String typeOfDietForCategory = DataConstants.typeOfDietForNonVegetarian;
	String typeOfDietForNonVeg = DataConstants.typeOfDietForAll;
	String recipe_name = "";
	String plannerTime = "";
	String plannerType = "breakfast";
	String recipeType = "taste buds";
	String typeOfDietName = "";
	String ingredientsName = "";
	String toastMessageForInvalidFormat = DataConstants.toastMessageForInvalidMenuPlanner;
	String toastMessageForSuccessfullyDoneMenuPlanner = DataConstants.toastMessageForSuccessfullyAddedMenuPlanner;
	
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=6)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=10)
	public void testeBudPageNavigationTest(){
		TasteBud.navigateToTasteBudPage();
		TasteBud.verifyTasteBudPageLoaded();
	}
	
	@Test(priority=30)
	public void tasteBudPageVerifyTasteBudCategoryTest(){
		TasteBud.verifyTasteBudCategoryList(typeOfDietForCategory);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=40)
	public void tasteBudPageVerifyTasteBudRecipeTermTest(){
		TasteBud.navigateToTasteBudPage();
		TasteBud.verifyTasteBudPageLoaded();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForCategory);
		TasteBud.verifyTasteBudTermPageLoaded(tasteBudCategoryName);
		typeOfDietName = typeOfDietForNonVeg;
		TasteBudForMeatLovers.verifyTasteBudCategoryRecipeList(typeOfDietName, tasteBudCategoryName);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=50)
	public void tasteBudPageVerifyFreeTasteBudRecipeTest(){
		TasteBud.navigateToTasteBudPage();
		TasteBud.verifyTasteBudPageLoaded();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForCategory);
		TasteBud.verifyTasteBudTermPageLoaded(tasteBudCategoryName);
		typeOfDietName = typeOfDietForNonVeg;
		recipe_name = Reusables.checkFreeRecipe(typeOfDietName, tasteBudCategoryName, recipeType);
	}
	
	@Test(priority = 51)
	public void verifyRecipeServingsValueTest(){
		EntityDetailPageUpperPart.verifyRecipeServingsValue(typeOfDietName, recipe_name);
	}
	
	@Test(priority = 52)
	public void verifyCookingTimeTest(){
		EntityDetailPageUpperPart.verifyRecipeCookingTimeValue(typeOfDietName, recipe_name);
	}
	
	@Test(priority = 53)
	public void verifyRecipeRatingValueTest(){
		EntityDetailPageUpperPart.verifyChefRecipeRatingValue(typeOfDietName, recipe_name);
	}
	
	@Test(priority = 54)
	public void verifyRecipeNutritionTest(){
		EntityDetailPageUpperPart.clickOnRecipeNutrition();
		EntityDetailPageUpperPart.VerifyRecipeNutritionHeaderTxt();
		EntityDetailPageUpperPart.verifyRecipeNutritionValue();
		EntityDetailPageUpperPart.verifyRecipeNutritionQty();
		EntityDetailPageUpperPart.verifyRecipeNutritionDriValue();
		EntityDetailPageUpperPart.nutritionDriAlertPopup();
		Reusables.oneStepBack();
	}
	
	@Test(priority = 55)
	public void verifyMenuPlannerTest(){
		EntityDetailPageUpperPart.clickOnMenuPlanner();
		EntityDetailPageUpperPart.verifyMenuPlannerHeaderTxt();
		EntityDetailPageUpperPart.setPlanName();
		EntityDetailPageUpperPart.selectPlannerType(plannerType);
		plannerTime = EntityDetailPageUpperPart.plannerTimeForPlannerType(plannerType);
		EntityDetailPageUpperPart.verifyPlannerTimeAfterSelectPlannerType(plannerTime);
		/*EntityDetailPageUpperPart.submitMenuPlannerPage();
		EntityDetailPageUpperPart.verifyToastMessageForMenuPlanner(toast_message_for_invalid_format);*/
		EntityDetailPageUpperPart.selectDate();
		EntityDetailPageUpperPart.submitMenuPlannerPage();
		//EntityDetailPageUpperPart.verifyToastMessageForMenuPlanner(toast_message_for_successfully_done_menu_planner);
	}
	
	@Test(priority=56)
	public void verifyIngredientNameListTest(){
		EntityDetailPageLowerPart.verifyIngredientNameList(recipe_name);
	}
	
	@Test(priority=60)
	public void verifyIngredientNutritionTest(){
		EntityDetailPageLowerPart.clickOnIngredientTxtView();
		EntityDetailPageLowerPart.verifyIngredientListCount();
		ingredientsName = EntityDetailPageLowerPart.clickOnIngredientNutritionImageView();
		EntityDetailPageUpperPart.VerifyRecipeNutritionHeaderTxt();
		EntityDetailPageUpperPart.verifyIngredientNutritionValue(ingredientsName);
		EntityDetailPageUpperPart.verifyIngredientNutritionQty(ingredientsName);
		EntityDetailPageUpperPart.verifyIngredientNutritionDriValue(ingredientsName);
		EntityDetailPageUpperPart.nutritionDriAlertPopup();
		Reusables.oneStepBack();
	}
	
	@Test(priority=70)
	public void verifyIngredientTipsTest(){
		ingredientsName = EntityDetailPageLowerPart.clickOnIngredientTipsImageView();
		EntityDetailPageLowerPart.verifyIngredientsBenefits(ingredientsName);
		Reusables.oneStepBack();
	}
	
	@Test(priority=80)
	public void verifyMethodTest(){
		EntityDetailPageLowerPart.clickOnMethodTxtView();
		EntityDetailPageLowerPart.verifyMethodListText(recipe_name);
		EntityDetailPageLowerPart.clickOnHandfreeButton();
		EntityDetailPageLowerPart.verifyVoiceCommandHeaderTxt();
		EntityDetailPageLowerPart.clickOnNoThanksButton();
		//EntityDetailPageLowerPart.verifyToastMessageForMethod();
	}
	
	@Test(priority=90)
	public void verifyTagsTest(){
		EntityDetailPageLowerPart.clickOnTagsTxtView();
		EntityDetailPageLowerPart.verifyTagsListCount();
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
   } 
	
	@AfterClass
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
