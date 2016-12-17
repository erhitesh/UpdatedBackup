package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.modules.RecipeDetailPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TasteBud;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class RecipeDetailPageTestCases {

	
	/* Global Variable Declaration */
	String tasteBudCategory = "";
	String typeOfDietName = DataConstants.typeOfDietForVegetarian;
	String ingredientsName = "";
	String recipeType = "taste bud";
	String recipeName = "";
	String plannerType = "breakfast";
	String plannerTime = "";
	String ingredientName = "";

	
	@Test(priority=0)
	public void splashScreenHandlingTest(){
		SplashScreen.hideAppRatePopUp();
	}
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=5)
	public void selectFirstTypeOfDietTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietName = TypeOfDiet.selectTypeOfDiet(typeOfDietName);
	}
	
	@Test(priority=10)
	public void testeBudPageNavigationTest(){
		TasteBud.navigateToTasteBudCategoryPage();
	}
	
	@Test(priority=11)
	public void navigateToDetailPage(){
		tasteBudCategory = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietName);
		TasteBud.verifyTasteBudTermPageLoaded(tasteBudCategory);
		recipeName = TasteBud.selectRandomRecipeName(recipeType, typeOfDietName, tasteBudCategory);
	}
	
	@Test(priority = 20)
	public void verifyRecipeServingsValueTest(){
		RecipeDetailPage.verifyRecipeServingsValue(typeOfDietName, recipeName);
	}

	@Test(priority = 28)
	public void verifyCookingTimeTest(){
		RecipeDetailPage.verifyRecipeCookingTimeValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 35)
	public void verifyRecipeRatingValueTest(){
		RecipeDetailPage.verifyChefRecipeRatingValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 45)
	public void verifyRecipeNutritionTest(){
		RecipeDetailPage.clickOnRecipeNutrition();
		RecipeDetailPage.verifyRecipeNameOnNutritionPage(recipeName);
		RecipeDetailPage.verifyRecipeNutritionValue();
		RecipeDetailPage.verifyRecipeNutritionQty();
		RecipeDetailPage.verifyRecipeNutritionDRI();
		RecipeDetailPage.recipeNutritionDriAlertPopup();
		RecipeDetailPage.closeRecipeNutritionPopUp();
	}
	
	@Test(priority = 50)
	public void verifyMenuPlannerTest(){
		RecipeDetailPage.clickOnMenuPlanner();
		RecipeDetailPage.verifyRecipeNameOnMenuPlannerPage(recipeName);
		RecipeDetailPage.selectPlannerType(plannerType);
		plannerTime = RecipeDetailPage.plannerTimeForPlannerType(plannerType);
		RecipeDetailPage.verifyPlannerTimeAfterSelectPlannerType(plannerTime);
		RecipeDetailPage.changeDate();
		RecipeDetailPage.submitMenuPlannerPage();
		RecipeDetailPage.verifySuccessfullySubmitMenuPlannerAlert(recipeName);
	}
	
	@Test(priority=55)
	public void verifyIngredientNameListTest(){
		RecipeDetailPage.verifyIngredientNameList(recipeName);
	}
	
	@Test(priority=60)
	public void verifyIngredientNutritionTest(){
		ingredientName = RecipeDetailPage.clickOnIngredientNutritionBtn();
		RecipeDetailPage.verifyIngredientNutritionValue(ingredientName);
		RecipeDetailPage.verifyIngredientNutritionQty(ingredientName);
		RecipeDetailPage.verifyIngredientNutritionDriValue(ingredientName);
		RecipeDetailPage.recipeNutritionDriAlertPopup();
		RecipeDetailPage.closeRecipeNutritionPopUp();
	}
	
	@Test(priority=70)
	public void verifyIngredientTipsTest(){
		ingredientName = RecipeDetailPage.clickOnIngredientBenefitsBtn(recipeName);
		RecipeDetailPage.verifyIngredientsBenefits(ingredientName);
		Reusables.oneStepBack();
	}
	
	@Test(priority=80)
	public void verifyMethodTest(){
		RecipeDetailPage.clickOnMethod();
		RecipeDetailPage.verifyMethodListText();
		RecipeDetailPage.clickOnHandfreeButton();
		RecipeDetailPage.pauseHandfreeButton();
		RecipeDetailPage.verifySimilarRecipeList();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if (ITestResult.FAILURE==result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP==result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE==result.getStatus()){
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void resetApp(){
		Reusables.terminatesAppInstance();
	}
}

