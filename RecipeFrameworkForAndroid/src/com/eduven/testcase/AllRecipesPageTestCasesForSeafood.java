package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.AllRecipes;
import com.eduven.modules.AllRecipesForSeafood;
import com.eduven.modules.HomePageForSeafood;
import com.eduven.modules.InAppPurchase;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class AllRecipesPageTestCasesForSeafood {
	
	
	/* Global Variable Declaration */
	String recipeName = "";
	String typeOfDietForSeafood = DataConstants.typeOfDietForAll;
	String typeOfDietName = "";
	String recipeType = "all";

	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePageForSeafood.verifyAppName();
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
		AllRecipesForSeafood.verifyRecipeNameList(typeOfDietForSeafood);
	}
	
	@Test(priority=30)
	public void allRecipesPageSelectRandomRecipeNameTest(){
		typeOfDietName = typeOfDietForSeafood;
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
	public void closeApp(){
		Reusables.terminatesAppInstance();
	}
}
