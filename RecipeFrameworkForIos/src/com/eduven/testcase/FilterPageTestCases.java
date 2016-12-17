package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.AllRecipes;
import com.eduven.modules.EvMenu;
import com.eduven.modules.Filter;
import com.eduven.modules.HomePage;
import com.eduven.modules.RecipeDetailPage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TasteBud;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class FilterPageTestCases {

	
	/* Global Variable Declaration */
	String ingredientNameForIncludeFilter = DataConstants.filterWithIncludeIngredients;
	String ingredientNameForExcludeFilter = DataConstants.filterWithExcludeIngredients;
	String typeOfDietForVeg = DataConstants.typeOfDietForVegetarian;
	String typeOfDietForAll = DataConstants.typeOfDietForAll;
	String expectedAlertMessage = DataConstants.filerAlertMessage;
	String filterOpeartionForInclude = "include";
	String filterOpeartionForExclude = "exclude";
	String tasteBudCategoryName = "";
	String typeOfDietName = "";
	String filterWord = "";
	String recipeName = "";
	String dietaryNeedName = "";
	
	
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
		typeOfDietForVeg = TypeOfDiet.selectTypeOfDiet(typeOfDietForVeg);
	}
	
	@Test(priority=10)
	public void testeBudPageNavigationTest(){
		TasteBud.navigateToTasteBudCategoryPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietForVeg);
	}
	
	@Test(priority=20)
	public void filterPageVerifyHeaderTextTest(){
		Filter.navigateToFilterPage();
		Filter.verifyFilterPageLoaded();
	}
	
	@Test(priority=30)
	public void filtePageWithIncludeIngredientTest(){
		filterWord = Filter.filterWithIncludeIngredients(ingredientNameForIncludeFilter);
		Filter.verifyAddedWordInIncludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		Filter.verifyFilterRecipesList(typeOfDietForVeg, tasteBudCategoryName, filterWord, filterOpeartionForInclude);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=35)
	public void filterPageVerifyIncludeIngredientNameInFilterRecipeTest(){
		TasteBud.navigateToTasteBudCategoryPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietForVeg);
		Filter.navigateToFilterPage();
		Filter.verifyFilterPageLoaded();
		filterWord = Filter.filterWithIncludeIngredients(ingredientNameForIncludeFilter);
		Filter.verifyAddedWordInIncludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		recipeName = Filter.selectFreeRecipeFromRecipeList();
		RecipeDetailPage.verifyRecipeName(recipeName);
		RecipeDetailPage.verifyIngredientNameInIngredientList(filterWord);
	}
	
	@Test(priority=40)
	public void filtePageWithExcludeIngredientTest(){
		HomePage.navigateToHomePage();
		TasteBud.navigateToTasteBudCategoryPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietForVeg);
		Filter.navigateToFilterPage();
		Filter.verifyFilterPageLoaded();
		filterWord = Filter.filterWithExcludeIngredients(ingredientNameForExcludeFilter);
		Filter.verifyAddedWordInExcludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		Filter.verifyFilterRecipesList(typeOfDietForVeg, tasteBudCategoryName, filterWord, filterOpeartionForExclude);
	}
	
	@Test(priority=45)
	public void filterPageVerifyExcludeIngredientNameInFilterRecipeTest(){
		HomePage.navigateToHomePage();
		TasteBud.navigateToTasteBudCategoryPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietForVeg);
		Filter.navigateToFilterPage();
		Filter.verifyFilterPageLoaded();
		filterWord = Filter.filterWithExcludeIngredients(ingredientNameForExcludeFilter);
		Filter.verifyAddedWordInExcludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		recipeName = Filter.selectFreeRecipeFromRecipeList();
		RecipeDetailPage.verifyRecipeName(recipeName);
		RecipeDetailPage.verifyIngredientNameNotInIngredientList(filterWord);
	}
	
	@Test(priority = 50)
	public void filtePageWithDietaryNeedTest(){
		HomePage.navigateToHomePage();
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForAll = TypeOfDiet.selectTypeOfDiet(typeOfDietForAll);
		AllRecipes.navigateToAllRecipePage();
		Filter.navigateToFilterPage();
		Filter.verifyFilterPageLoaded();
		dietaryNeedName = Filter.clickOnRandomDietaryNeed();
		Filter.verifyFilterRecipesListForDietaryNeeds(typeOfDietForAll, "", dietaryNeedName);
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
