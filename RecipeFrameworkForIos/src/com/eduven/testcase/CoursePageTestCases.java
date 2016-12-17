package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Courses;
import com.eduven.modules.EvMenu;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.RecipeDetailPage;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class CoursePageTestCases {
	
	
	/* Global variable Declaration */
	String coursesName = "";
	String typeOfDietName = "";
	String recipeType = "courses";
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
	
	@Test(priority=4)
	public void selectTypeOfDietTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietName = TypeOfDiet.selectTypeOfDiet(DataConstants.typeOfDietForVegetarian);
	}
	
	@Test(priority=10)
	public void coursePageNavigationTest(){
		Courses.navigateToCoursesCategoryPage();
	}
	
	@Test(priority=20)
	public void verifyFooterElementTest(){
		Footer.verifyHomeButton();
		Footer.verifyCookWithButton();
		Footer.verifyTipsButton();
		Footer.verifyEduBankButton();
		Footer.verifyShopButton();
	}
	
	@Test(priority=30)
	public void verifyCourseCategoryListTest(){
		Courses.verifyCourseList(typeOfDietName);
	}
	
	@Test(priority=40)
	public void verifyCoursesRecipeListTest(){
		HomePage.navigateToHomePage();
		Courses.navigateToCoursesCategoryPage();
		coursesName = Courses.clickOnRandomCourseCategoryList(typeOfDietName);
		Courses.verifyCourseTermPageLoaded(coursesName);
		Courses.verifyCoursesCategoryRecipeList(typeOfDietName, coursesName);
	}
	
	@Test(priority=50)
	public void verifyPremiumCoureRecipeNameTest(){
		HomePage.navigateToHomePage();
		Courses.navigateToCoursesCategoryPage();
		coursesName = Courses.clickOnRandomCourseCategoryList(typeOfDietName);
		Reusables.checkPremiumRecipe(typeOfDietName, coursesName, recipeType);
		InAppPurchase.hideInAppPurchasePage();
	}
	
	@Test(priority=60)
	public void verifyFreeCoursesRecipeTest(){
		Footer.navigateToHomePage();
		Courses.navigateToCoursesCategoryPage();
		coursesName = Courses.clickOnRandomCourseCategoryList(typeOfDietName);
		Courses.verifyCourseTermPageLoaded(coursesName);
		recipeName = Reusables.checkFreeRecipe(typeOfDietName, coursesName, recipeType);
		RecipeDetailPage.verifyRecipeName(recipeName);
	}
	
	@Test(priority = 65)
	public void verifyRecipeServingsValueTest(){
		RecipeDetailPage.verifyRecipeServingsValue(typeOfDietName, recipeName);
	}

	@Test(priority = 68)
	public void verifyCookingTimeTest(){
		RecipeDetailPage.verifyRecipeCookingTimeValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 70)
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
