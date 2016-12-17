package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.AllRecipes;
import com.eduven.modules.EntityDetailPageLowerPart;
import com.eduven.modules.EntityDetailPageUpperPart;
import com.eduven.modules.EvMenu;
import com.eduven.modules.Filter;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TasteBud;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class FilterPageTestCases {
	
	
	/* Global Variable Declaration */
	String expectedHeaderTxt = DataConstants.filterPageHeaderTxt;
	String ingredientNameForIncludeFilter = DataConstants.filter_with_include_ingredients;
	String ingredientNameForExcludeFilter = DataConstants.filter_with_exclude_ingredients;
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
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=5)
	public void selectFirstTypeOfDietTest(){
		typeOfDietForVeg = TypeOfDiet.selectTypeOfDiet(typeOfDietForVeg);
	}
	
	@Test(priority=6)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=10)
	public void testeBudPageNavigationTest(){
		TasteBud.clickOnTasteBudButton();
		TasteBud.verifyTasteBudPageLoaded();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForVeg);
	}
	
	@Test(priority=20)
	public void filterPageVerifyHeaderTextTest(){
		Filter.clickOnFilterBtn();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(expectedHeaderTxt);
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
		TasteBud.navigateToTasteBudPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForVeg);
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(DataConstants.filterPageHeaderTxt);
		filterWord = Filter.filterWithIncludeIngredients(ingredientNameForIncludeFilter);
		Filter.verifyAddedWordInIncludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		recipeName = Filter.selectFirstRecipeFromRecipeList();
		EntityDetailPageUpperPart.verifyRecipeName(recipeName);
		EntityDetailPageLowerPart.verifyIngredientNameInIngredientList(filterWord);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=40)
	public void filtePageWithExcludeIngredientTest(){
		TasteBud.navigateToTasteBudPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForVeg);
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(DataConstants.filterPageHeaderTxt);
		filterWord = Filter.filterWithExcludeIngredients(ingredientNameForExcludeFilter);
		Filter.verifyAddedWordInExcludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		Filter.verifyFilterRecipesList(typeOfDietForVeg, tasteBudCategoryName, filterWord, filterOpeartionForExclude);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=45)
	public void filterPageVerifyExcludeIngredientNameInFilterRecipeTest(){
		TasteBud.navigateToTasteBudPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForVeg);
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(DataConstants.filterPageHeaderTxt);
		filterWord = Filter.filterWithExcludeIngredients(ingredientNameForExcludeFilter);
		Filter.verifyAddedWordInExcludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		recipeName = Filter.selectFirstRecipeFromRecipeList();
		EntityDetailPageUpperPart.verifyRecipeName(recipeName);
		EntityDetailPageLowerPart.verifyIngredientNameNotInIngredientList(filterWord);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority = 50)
	public void filtePageWithDietaryNeedTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForAll = TypeOfDiet.selectTypeOfDiet(typeOfDietForAll);
		AllRecipes.navigateToAllRecipePage();
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(expectedHeaderTxt);
		dietaryNeedName = Filter.clickOnRandomDietaryNeed();
		Filter.verifyFilterRecipesListForDietaryNeeds(typeOfDietForAll, "", dietaryNeedName);
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
