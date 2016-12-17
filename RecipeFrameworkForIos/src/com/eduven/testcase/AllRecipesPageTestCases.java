package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.AllRecipes;
import com.eduven.modules.EvMenu;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.RecipeDetailPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class AllRecipesPageTestCases {
	
	
	/* Global Variable Declaration */
	String recipeName = "";
	String typeOfDietName = DataConstants.typeOfDietForAll;
	String recipeType = "all";
	String ingredientName = "";
	String plannerType = "breakfast";
	String plannerTime = "";
	
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
	
	@Test(priority=8)
	public void allRecipesPageNavigationTest(){
		AllRecipes.navigateToAllRecipePage();
	}
	
	@Test(priority=10)
	public void verifyFooterTest(){
		Footer.verifyHomeButton();
		Footer.verifyCookWithButton();
		Footer.verifyTipsButton();
		Footer.verifyEduBankButton();
		Footer.verifyShopButton();
	}

	@Test(priority=20)
	public void allRecipesPageVerifyAllRecipesTermsTest(){
		AllRecipes.verifyRecipeNameList(typeOfDietName);
	}
	
	@Test(priority=25)
	public void tasteBudPageVerifyPremiumTasteBudRecipeTest(){
		HomePage.navigateToHomePage();
		AllRecipes.navigateToAllRecipePage();
		Reusables.checkPremiumRecipe(typeOfDietName, "", recipeType);
		InAppPurchase.hideInAppPurchasePage();
	}
	
	@Test(priority=30)
	public void verifyFreeRecipeTest(){
		HomePage.navigateToHomePage();
		AllRecipes.navigateToAllRecipePage();
		recipeName = Reusables.checkFreeRecipe(typeOfDietName, "", recipeType);
	}
	
	@Test(priority = 35)
	public void verifyRecipeServingsValueTest(){
		RecipeDetailPage.verifyRecipeServingsValue(typeOfDietName, recipeName);
	}

	@Test(priority = 48)
	public void verifyCookingTimeTest(){
		RecipeDetailPage.verifyRecipeCookingTimeValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 50)
	public void verifyRecipeRatingValueTest(){
		RecipeDetailPage.verifyChefRecipeRatingValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 75)
	public void verifyRecipeNutritionTest(){
		RecipeDetailPage.clickOnRecipeNutrition();
		RecipeDetailPage.verifyRecipeNameOnNutritionPage(recipeName);
		RecipeDetailPage.verifyRecipeNutritionValue();
		RecipeDetailPage.verifyRecipeNutritionQty();
		RecipeDetailPage.verifyRecipeNutritionDRI();
		RecipeDetailPage.recipeNutritionDriAlertPopup();
		RecipeDetailPage.closeRecipeNutritionPopUp();
	}
	
	@Test(priority = 80)
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
	
	@Test(priority=85)
	public void verifyIngredientNameListTest(){
		RecipeDetailPage.verifyIngredientNameList(recipeName);
	}
	
	@Test(priority=90)
	public void verifyIngredientNutritionTest(){
		ingredientName = RecipeDetailPage.clickOnIngredientNutritionBtn();
		RecipeDetailPage.verifyIngredientNutritionValue(recipeName);
		RecipeDetailPage.verifyIngredientNutritionQty(ingredientName);
		RecipeDetailPage.verifyIngredientNutritionDriValue(ingredientName);
		RecipeDetailPage.recipeNutritionDriAlertPopup();
		RecipeDetailPage.closeRecipeNutritionPopUp();
	}
	
	@Test(priority=100)
	public void verifyIngredientTipsTest(){
		ingredientName = RecipeDetailPage.clickOnIngredientBenefitsBtn(recipeName);
		RecipeDetailPage.verifyIngredientsBenefits(ingredientName);
		Reusables.oneStepBack();
	}
	
	@Test(priority=110)
	public void verifyMethodTest(){
		RecipeDetailPage.clickOnMethod();
		RecipeDetailPage.verifyMethodListText();
		RecipeDetailPage.clickOnHandfreeButton();
		RecipeDetailPage.pauseHandfreeButton();
		RecipeDetailPage.verifySimilarRecipeList();
	}
	
	@AfterMethod 
	public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
	 }
   } 
	
	@AfterClass
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
