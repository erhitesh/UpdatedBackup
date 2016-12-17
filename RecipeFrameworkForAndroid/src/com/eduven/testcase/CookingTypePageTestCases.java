package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.CookingType;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class CookingTypePageTestCases {
	
	
	/* Global Variable Declaration */
	String cookingTypeTerm = "";
	String expectedRecipeName = "";
	String typeOfDietForVeg = DataConstants.typeOfDietForVegetarian;
	
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
	public void cooking_type_page_navigation_test(){
		CookingType.clickOnCookingTypeButton();
		CookingType.verifyCookingTypePageLoaded();
	}
	
	@Test(priority=20)
	public void cooking_type_page_verify_cooking_terms_test(){
		CookingType.verifyCookigTypeList();
	}
	
	@Test(priority=30)
	public void cooking_type_page_random_term_click_test(){
		cookingTypeTerm = CookingType.clickOnRandomCookingTypeTerm();
		CookingType.verifyCookingTypeTermPageLoaded(cookingTypeTerm);
	}
	
	@Test(priority=40)
	public void cooking_type_page_select_cooking_type_recipe_test(){
		expectedRecipeName = CookingType.clickRandomCookingTypeRecipeName();
	}
	
	@Test(priority=50)
	public void cooking_type_page_verify_selected_recipe_found_test(){
		CookingType.verifySelectRecipeName(expectedRecipeName);
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