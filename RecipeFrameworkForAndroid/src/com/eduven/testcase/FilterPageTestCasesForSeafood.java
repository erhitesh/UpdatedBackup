package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.AllRecipes;
import com.eduven.modules.EntityDetailPageLowerPart;
import com.eduven.modules.EntityDetailPageUpperPart;
import com.eduven.modules.Filter;
import com.eduven.modules.FilterForMeatLover;
import com.eduven.modules.HomePage;
import com.eduven.modules.HomePageForSeafood;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TasteBud;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class FilterPageTestCasesForSeafood {
	
	
	/* Global Variable Declaration */
	String expectedHeaderTxt = DataConstants.filterPageHeaderTxt;
	String ingredientNameForIncludeFilter = DataConstants.filter_with_include_ingredients;
	String ingredientNameForExcludeFilter = DataConstants.filter_with_exclude_ingredients;
	String typeOfDietForSeafood = DataConstants.typeOfDietForAll;
	String expectedAlertMessage = DataConstants.filerAlertMessage;
	String filterOpeartionForInclude = "include";
	String filterOpeartionForExclude = "exclude";
	String taste_bud_category_name = "";
	String typeOfDietName = "";
	String filterWord = "";
	String recipeName = "";
	String dietaryNeedName = "";
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePageForSeafood.verifyAppName();
	}
	
	@Test(priority=6)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=10)
	public void testeBudPageNavigationTest(){
		TasteBud.clickOnTasteBudButton();
		TasteBud.verifyTasteBudPageLoaded();
		taste_bud_category_name = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForSeafood);
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
		FilterForMeatLover.verifyFilterRecipesList(typeOfDietForSeafood, taste_bud_category_name, filterWord, filterOpeartionForInclude);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=35)
	public void filterPageVerifyIncludeIngredientNameInFilterRecipeTest(){
		TasteBud.navigateToTasteBudPage();
		taste_bud_category_name = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForSeafood);
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(DataConstants.filterPageHeaderTxt);
		filterWord = Filter.filterWithIncludeIngredients(ingredientNameForIncludeFilter);
		Filter.verifyAddedWordInIncludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		recipeName = FilterForMeatLover.selectFirstRecipeFromRecipeList();
		EntityDetailPageUpperPart.verifyRecipeName(recipeName);
		EntityDetailPageLowerPart.verifyIngredientNameInIngredientList(filterWord);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=40)
	public void filtePageWithExcludeIngredientTest(){
		TasteBud.navigateToTasteBudPage();
		taste_bud_category_name = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForSeafood);
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(DataConstants.filterPageHeaderTxt);
		filterWord = Filter.filterWithExcludeIngredients(ingredientNameForExcludeFilter);
		Filter.verifyAddedWordInExcludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		FilterForMeatLover.verifyFilterRecipesList(typeOfDietForSeafood, taste_bud_category_name, filterWord, filterOpeartionForExclude);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=45)
	public void filterPageVerifyExcludeIngredientNameInFilterRecipeTest(){
		TasteBud.navigateToTasteBudPage();
		taste_bud_category_name = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForSeafood);
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(DataConstants.filterPageHeaderTxt);
		filterWord = Filter.filterWithExcludeIngredients(ingredientNameForExcludeFilter);
		Filter.verifyAddedWordInExcludeList(filterWord);
		Filter.clickOnGetRecipesBtn();
		recipeName = FilterForMeatLover.selectFirstRecipeFromRecipeList();
		EntityDetailPageUpperPart.verifyRecipeName(recipeName);
		EntityDetailPageLowerPart.verifyIngredientNameNotInIngredientList(filterWord);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority = 50)
	public void filtePageWithDietaryNeedTest(){
		AllRecipes.navigateToAllRecipePage();
		Filter.navigateToFilterPage();
		Filter.verifyMessageForFilter(expectedAlertMessage);
		Filter.verifyFilterPageLoaded(expectedHeaderTxt);
		dietaryNeedName = Filter.clickOnRandomDietaryNeed();
		Filter.verifyFilterRecipesListForDietaryNeeds(typeOfDietForSeafood, "", dietaryNeedName);
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
