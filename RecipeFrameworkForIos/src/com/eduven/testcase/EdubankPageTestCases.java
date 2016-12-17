package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EduBank;
import com.eduven.modules.EvMenu;
import com.eduven.modules.Footer;
import com.eduven.modules.HomePage;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TasteBud;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EdubankPageTestCases {

	
	/* Global variable declaration */
	String firstRecipeName = "";
	String secondRecipeName = "";
	String tasteBudCategoryName = "";
	String typeOfDietForVeg = DataConstants.typeOfDietForVegetarian;
	String typeOfDietName = "";
	
	
	@Test(priority=0)
	public void splashScreenHandlingTest(){
		SplashScreen.hideAppRatePopUp();
	}
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyHomePageHeaderTxt();
	}
	
	@Test(priority=4)
	public void selectTypeOfDietTest(){
		EvMenu.navigateToChangePreferencePage();
		typeOfDietName = TypeOfDiet.selectTypeOfDiet(DataConstants.typeOfDietForVegetarian);
	}
	
	@Test(priority=10)
	public void removeAllTermFromEdubankTest(){
		EduBank.navigateToEdubank();
		EduBank.removeAllRecipeFromEduBank();
		Footer.navigateToHomePage();
	}
	
	@Test(priority=15)
	public void addTermInEdubankTest(){
		TasteBud.navigateToTasteBudCategoryPage();
		tasteBudCategoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietName);
		TasteBud.verifyTasteBudTermPageLoaded(tasteBudCategoryName);
		firstRecipeName = EduBank.addRecipeToEdubankFromRecipeList(0);
		secondRecipeName = EduBank.addRecipeToEdubankFromRecipeList(2);
	}
	
	@Test(priority=20)
	public void edubankVerifyAddedRecipeInEdubankTest(){
		Footer.navigateToEdubank();
		EduBank.verifyEduBankHeaderText();
		EduBank.verifyAddedRecipeNameInEdubank(firstRecipeName);
		EduBank.verifyAddedRecipeNameInEdubank(secondRecipeName);
	}
	
	@Test(priority=25)
	public void edubankRemoveRecipeNameFromEduBankTest(){
		EduBank.removeAllRecipeFromEduBank();
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
