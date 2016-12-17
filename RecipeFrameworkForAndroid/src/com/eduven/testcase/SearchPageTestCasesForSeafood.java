package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.HomePage;
import com.eduven.modules.HomePageForSeafood;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.Search;
import com.eduven.modules.SplashScreen;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class SearchPageTestCasesForSeafood {
	
	
	/* Global Variable Declaration */
	String searchCategoryName = "";
	String searchSubCategoryName = "";
	String typeOfDietForSeafood = DataConstants.typeOfDietForAll;
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePageForSeafood.verifyAppName();
	}
	
	@Test(priority=5)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=6)
	public void homePageAppHeaderTextTest(){
		HomePage.verifyHomePageHeaderTxt();
	}
	
	@Test(priority=10)
	public void searchPageHeaderTextTest(){
		Search.clickOnSearchButton();
		Search.verifySearchPageHeaderText();
	}
	
	@Test(priority=23)
	public void searchByLookupByRecipeForNonVegetarianTest(){
		Search.searchRecipeByLookUp(DataConstants.searchTypeRecipe, typeOfDietForSeafood);
		Reusables.oneStepBack();
		SplashScreen.allowMediaFilesAndContacts();
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=35)
	public void searchByLookupByIngredientForNonVegTest(){
		Search.clickOnSearchButton();
		Search.verifySearchPageHeaderText();
		Search.searchRecipeByLookUp(DataConstants.searchTypeIngredient, typeOfDietForSeafood);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=40)
	public void searchPageNaviagateToTurboSearchPageTest(){
		Search.clickOnSearchButton();
		Search.verifySearchPageHeaderText();
		Search.clickOnTurboSearch();
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
		Search.verifyTurboSearchRecipesList(typeOfDietForSeafood, searchCategoryName, searchSubCategoryName);
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
