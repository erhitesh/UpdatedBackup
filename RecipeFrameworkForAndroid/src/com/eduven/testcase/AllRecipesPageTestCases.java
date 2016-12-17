package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.AllRecipes;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class AllRecipesPageTestCases {
	
	
	/* Global Variable Declaration */
	String recipeName = "";
	String type_of_diet_for_veg = DataConstants.typeOfDietForAll;
	String typeOfDietName = "";
	String recipeType = "all";

	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=5)
	public void selectFirstTypeOfDietTest(){
		type_of_diet_for_veg = TypeOfDiet.selectTypeOfDiet(type_of_diet_for_veg);
	}
	
	@Test(priority=6)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=10)
	public void allRecipesPageNavigationTest(){
		AllRecipes.navigateToAllRecipePage();
		AllRecipes.verifyAllRecipesPageLoaded();
	}

	@Test(priority=20)
	public void allRecipesPageVerifyallRecipesTermsTest(){
		AllRecipes.verifyRecipeNameList(type_of_diet_for_veg);
	}
	
	@Test(priority=30)
	public void allRecipesPageSelectRandomRecipeNameTest(){
		typeOfDietName = type_of_diet_for_veg;
		Reusables.checkFreeRecipe(typeOfDietName, "", recipeType);
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
	public void close_app(){
		Reusables.terminatesAppInstance();
	}
}
