package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.Cuisine;
import com.eduven.modules.SplashScreen;
import com.eduven.report.ScreenShot;
import com.eduven.utils.Reusables;


public class CuisinePageTestCases {
	
	String mainCategoryName = DataConstants.cuisine_header_txt;
	String subCategoryName = "";
	
	@Test(priority=0)
	public void cuisine_page_test() {
		SplashScreen.hideAppRatePopup();
		SplashScreen.verifyForSplashScreen();
		SplashScreen.clickOnDiscoverButton();
		SplashScreen.tapOnFlyerImage();
	}
	
	@Test(priority=1)
	public void cuisine_page_header_test(){
		Cuisine.clickOnCuisine();
		Cuisine.verifyCuisineHeaderTxt();
		Reusables.stepBack();
		Categories.verfiyCategoryIconPresent();
		Cuisine.clickOnCuisine();
		Cuisine.verifyCuisineHeaderTxt();
	}
	
	@Test(priority=2)
	public void cuisine_page_entity_test(){
		Reusables.verifySubCategoryList(mainCategoryName);
	}
	
	@Test(priority=3)
	public void cuisine_page_free_entity_test(){
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkFreeEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=4)
	public void cuisine_page_premium_entity_test(){
		Reusables.stepBack();
		subCategoryName = Reusables.clickOnRandomSubCategory(mainCategoryName);
		Reusables.checkPremiumEntity(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=5)
	public void cuisine_page_navigate_to_entity_detail_test(){
		Reusables.navigateToFreeEntityDetailPage(mainCategoryName, subCategoryName);
	}
	
	@Test(priority=6)
	public void cuisine_page_verify_ingredients_and_directions_button_test(){
		Cuisine.verifyDirectionsBtn();
		Cuisine.verifyIngredientsBtn();
	}
	
	@Test(priority=7)
	public void cuisine_page_verify_ingredients_and_directions_button_action_test(){
		Cuisine.verifyClickOnDirectionBtn();
		Cuisine.verifyClickOnIngredientsBtn();
	}
	
	@Test(priority=8)
	public void cuisine_page_verify_cooking_servings_test(){
		Cuisine.verifyServings();
		Cuisine.verifyCookingTime();
	}
	
	@Test(priority=9)
	public void cuisine_page_verify_nutrition_test(){
		Cuisine.clickNutritionBtn();
		Reusables.tap_on_element_using_coordinates(1, 20, 84);
		Cuisine.clickOnTipsBtn();
		Reusables.waitThread(2);
		Reusables.tap_on_element_using_coordinates(1, 20, 84);
	}

	@Test(priority=10)
	public void cuisine_page_verify_contibute_entity(){
		Reusables.stepBack();
		Reusables.verifyContributeEntity();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		} else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void close_app() {
		Reusables.terminatesAppInstance();
	}

}
