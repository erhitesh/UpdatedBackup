package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Courses;
import com.eduven.modules.EntityDetailPageLowerPart;
import com.eduven.modules.EntityDetailPageUpperPart;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class CoursePageTestCases {
	
	
	/* Global Variable Declaration */
	String course_category_name = "";
	String typeOfDietForVeg = DataConstants.typeOfDietForVegetarian;
	String type_of_diet_for_non_veg = DataConstants.typeOfDietForNonVegetarian;
	String type_of_diet_for_vegan = DataConstants.typeOfDietForVegan;
	String type_of_diet_for_all = DataConstants.typeOfDietForAll;
	String recipeType = "courses";
	String typeOfDietName = "";
	String recipeName = "";
	String plannerTime = "";
	String plannerType = "dinner";
	String ingredientsName = "";
	String toast_message_for_invalid_format = DataConstants.toastMessageForInvalidMenuPlanner;
	String toast_message_for_successfully_done_menu_planner = DataConstants.toastMessageForSuccessfullyAddedMenuPlanner;
	
	
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
	
	@Test(priority=8)
	public void coursesPageNavigationTest(){
		Courses.navigateToCoursePage();
		Courses.verifyCoursePageLoaded();
	}
	
	@Test(priority=10)
	public void verifyCoursesListTest(){
		Courses.verifyCourseCategory(typeOfDietForVeg);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=14)
	public void verifyCoursesRecipePageLoadTest(){
		Courses.navigateToCoursePage();
		Courses.verifyCoursePageLoaded();
		course_category_name = Courses.clickOnRandomCourseCategory(typeOfDietForVeg);
		Courses.verifyCourseTermPageLoaded(course_category_name);
		typeOfDietName = typeOfDietForVeg;
		Courses.verifyCourseCategoryRecipe(typeOfDietName, course_category_name);
		HomePage.navigateToHomePage();
	}
	
	@Test(priority=15)
	public void verifyFreeCoursesRecipeTest(){
		Courses.navigateToCoursePage();
		Courses.verifyCoursePageLoaded();
		course_category_name = Courses.clickOnRandomCourseCategory(typeOfDietForVeg);
		Courses.verifyCourseTermPageLoaded(course_category_name);
		typeOfDietName = typeOfDietForVeg;
		recipeName = Reusables.checkFreeRecipe(typeOfDietName, course_category_name, recipeType);
	}
	
	@Test(priority = 20)
	public void verifyRecipeServingsValueTest(){
		EntityDetailPageUpperPart.verifyRecipeServingsValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 30)
	public void verifyCookingTimeTest(){
		EntityDetailPageUpperPart.verifyRecipeCookingTimeValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 40)
	public void verifyRecipeRatingValueTest(){
		EntityDetailPageUpperPart.verifyChefRecipeRatingValue(typeOfDietName, recipeName);
	}
	
	@Test(priority = 45)
	public void verifyRecipeNutritionTest(){
		EntityDetailPageUpperPart.clickOnRecipeNutrition();
		EntityDetailPageUpperPart.VerifyRecipeNutritionHeaderTxt();
		EntityDetailPageUpperPart.verifyRecipeNutritionValue();
		EntityDetailPageUpperPart.verifyRecipeNutritionQty();
		EntityDetailPageUpperPart.verifyRecipeNutritionDriValue();
		EntityDetailPageUpperPart.nutritionDriAlertPopup();
		Reusables.oneStepBack();
	}
	
	@Test(priority = 50)
	public void verifyMenuPlannerTest(){
		EntityDetailPageUpperPart.clickOnMenuPlanner();
		EntityDetailPageUpperPart.verifyMenuPlannerHeaderTxt();
		EntityDetailPageUpperPart.setPlanName();
		EntityDetailPageUpperPart.selectPlannerType(plannerType);
		plannerTime = EntityDetailPageUpperPart.plannerTimeForPlannerType(plannerType);
		EntityDetailPageUpperPart.verifyPlannerTimeAfterSelectPlannerType(plannerTime);
		/*EntityDetailPageUpperPart.submitMenuPlannerPage();
		EntityDetailPageUpperPart.verifyToastMessageForMenuPlanner(toast_message_for_invalid_format);*/
		EntityDetailPageUpperPart.selectDate();
		EntityDetailPageUpperPart.submitMenuPlannerPage();
		//EntityDetailPageUpperPart.verifyToastMessageForMenuPlanner(toast_message_for_successfully_done_menu_planner);
	}
	
	@Test(priority=55)
	public void verifyIngredientNameListTest(){
		EntityDetailPageLowerPart.verifyIngredientNameList(recipeName);
	}
	
	@Test(priority=60)
	public void verifyIngredientNutritionTest(){
		EntityDetailPageLowerPart.clickOnIngredientTxtView();
		EntityDetailPageLowerPart.verifyIngredientListCount();
		ingredientsName = EntityDetailPageLowerPart.clickOnIngredientNutritionImageView();
		EntityDetailPageUpperPart.VerifyRecipeNutritionHeaderTxt();
		EntityDetailPageUpperPart.verifyIngredientNutritionValue(ingredientsName);
		EntityDetailPageUpperPart.verifyIngredientNutritionQty(ingredientsName);
		EntityDetailPageUpperPart.verifyIngredientNutritionDriValue(ingredientsName);
		EntityDetailPageUpperPart.nutritionDriAlertPopup();
		Reusables.oneStepBack();
	}
	
	@Test(priority=70)
	public void verifyIngredientTipsTest(){
		ingredientsName = EntityDetailPageLowerPart.clickOnIngredientTipsImageView();
		EntityDetailPageLowerPart.verifyIngredientsBenefits(ingredientsName);
		Reusables.oneStepBack();
	}
	
	@Test(priority=80)
	public void verifyMethodTest(){
		EntityDetailPageLowerPart.clickOnMethodTxtView();
		EntityDetailPageLowerPart.verifyMethodListText(recipeName);
		EntityDetailPageLowerPart.clickOnHandfreeButton();
		EntityDetailPageLowerPart.verifyVoiceCommandHeaderTxt();
		EntityDetailPageLowerPart.clickOnNoThanksButton();
		//EntityDetailPageLowerPart.verifyToastMessageForMethod();
	}
	
	@Test(priority=90)
	public void verifyTagsTest(){
		EntityDetailPageLowerPart.clickOnTagsTxtView();
		EntityDetailPageLowerPart.verifyTagsListCount();
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
