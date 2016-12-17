package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EvMenu;
import com.eduven.modules.HomePage;
import com.eduven.modules.Search;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class SearchPageTestCases {

	
	/* Global Variable Declaration */
	String searchCategoryName = "";
	String searchSubCategoryName = "";
	String typeOfDietForVeg = DataConstants.typeOfDietForVegetarian;
	String typeOfDietForNonVeg = DataConstants.typeOfDietForNonVegetarian;
	String typeOfDietForVegan = DataConstants.typeOfDietForVegan;
	String typeOfDietForAll = DataConstants.typeOfDietForAll;
	
	
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
		typeOfDietForVeg = TypeOfDiet.selectTypeOfDiet(typeOfDietForVeg);
	}
	
	@Test(priority=10)
	public void searchPageHeaderTextTest(){
		Search.clickOnSearchButton();
		Search.verifySearchPageHeaderText();
	}
	
	@Test(priority=20)
	public void searchByLookupByRecipeForVegetarianTest(){
		Search.searchRecipeByLookUp(DataConstants.searchTypeRecipe, typeOfDietForVeg);
	}
	
	@Test(priority=23)
	public void searchByLookupByRecipeForNonVegetarianTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForNonVeg = TypeOfDiet.selectTypeOfDiet(typeOfDietForNonVeg);
		Search.navigateToSearchPage();
		Search.searchRecipeByLookUp(DataConstants.searchTypeRecipe, typeOfDietForNonVeg);
	}
	
	@Test(priority=25)
	public void searchByLookupByRecipeForVeganTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForVegan = TypeOfDiet.selectTypeOfDiet(typeOfDietForVegan);
		Search.navigateToSearchPage();
		Search.searchRecipeByLookUp(DataConstants.searchTypeRecipe, typeOfDietForVegan);
	}
	
	@Test(priority=27)
	public void searchByLookupByRecipeForAllTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForAll = TypeOfDiet.selectTypeOfDiet(typeOfDietForAll);
		Search.navigateToSearchPage();
		Search.searchRecipeByLookUp(DataConstants.searchTypeRecipe, typeOfDietForAll);
	}
	
	@Test(priority=30)
	public void searchByLookupByIngredientForVegTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForVeg = TypeOfDiet.selectTypeOfDiet(typeOfDietForVeg);
		Search.navigateToSearchPage();
		Search.searchRecipeByLookUp(DataConstants.searchTypeIngredient, typeOfDietForVeg);
	}
	
	@Test(priority=35)
	public void searchByLookupByIngredientForNonVegTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForNonVeg = TypeOfDiet.selectTypeOfDiet(typeOfDietForNonVeg);
		Search.navigateToSearchPage();
		Search.searchRecipeByLookUp(DataConstants.searchTypeIngredient, typeOfDietForNonVeg);
	}
	
	@Test(priority=40)
	public void searchPageNaviagateToTurboSearchPageTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietForAll = TypeOfDiet.selectTypeOfDiet(typeOfDietForAll);
		Search.navigateToSearchPage();
		Search.turboSeach();
	}
	
	@Test(priority=50)
	public void searchPageSelectSearchCategoryFromTurboTest(){
		searchCategoryName = Search.selectNameFromSearchCategoryFromList();
		searchSubCategoryName = Search.selectNameFromSearchSubCategoryList();
	}
	
	@Test(priority=60)
	public void searchPageVerifySearchCategoryAndSubCategryValueTest(){
		Search.verifyWordCategoryNameFromSearchCategories(searchCategoryName.trim()+searchSubCategoryName.trim());
	}
	
	@Test(priority=70)
	public void searchPageVerifyTurboSearchTest(){
		Search.clickOnGetRecipesButton();
		Search.verifyTurboSearchPageHeaderTxt();
	}
	
	@Test(priority=80)
	public void verifyTurboSearchRecipeTest(){
		Search.verifyTurboSearchRecipesList(typeOfDietForAll, searchCategoryName, searchSubCategoryName);
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
