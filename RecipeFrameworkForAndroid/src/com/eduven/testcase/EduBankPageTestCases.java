package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.EduBank;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TasteBud;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EduBankPageTestCases {
	
	
	/* Global variable declaration */
	String firstRecipeName = "";
	String secondRecipeName = "";
	String tasteBusCategoryName = "";
	String typeOfDietForVeg = DataConstants.typeOfDietForVegetarian;
	String typeOfDietName = "";
	
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
	public void navigateToEdubankPageTest(){
		EduBank.clickOnEduBank();
	}
	
	@Test(priority=20)
	public void verifyEdubankHeaderTest(){
		EduBank.verifyEduBankHeaderText();
	}

	@Test(priority=30)
	public void edubankNavigateToTasteBudPageTest(){
		TasteBud.navigateToTasteBudPage();
		TasteBud.verifyTasteBudPageLoaded();
		tasteBusCategoryName = TasteBud.clickOnRandomTasteBudCategory(typeOfDietForVeg);
	}
	
	@Test(priority=40)
	public void addRecipeNameToEdubankTest(){
		TasteBud.verifyTasteBudTermPageLoaded(tasteBusCategoryName);
		firstRecipeName = EduBank.addRecipeToEdubankFromRecipeList(0);
		secondRecipeName = EduBank.addRecipeToEdubankFromRecipeList(2);
		Reusables.oneStepBack();
		Reusables.oneStepBack();
	}
	
	@Test(priority=50)
	public void edubankVerifyAddedRecipeInEdubankTest(){
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderText();
		EduBank.verifyAddedRecipeNameInEdubank(firstRecipeName);
		EduBank.verifyAddedRecipeNameInEdubank(secondRecipeName);
		}
	
	@Test(priority=60)
	public void edubankRemoveRecipeNameFromEduBankTest(){
		EduBank.removeAllRecipeFromEduBank();
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
