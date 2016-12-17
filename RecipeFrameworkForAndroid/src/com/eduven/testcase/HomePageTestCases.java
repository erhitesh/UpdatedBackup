package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.HomePage;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class HomePageTestCases {
	
	
	/* Global Variable Declaration */
	String typeOfDiet = DataConstants.typeOfDietForVegetarian;
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=5)
	public void selectFirstTypeOfDietTest(){
		TypeOfDiet.selectTypeOfDiet(typeOfDiet);
	}
	
	@Test(priority=6)
	public void inAppPurchaseTest(){
		InAppPurchase.upgradeToPremium();
	}
	
	@Test(priority=10)
	public void homePageAppHeaderTextTest(){
		HomePage.verifyHomePageHeaderTxt();
	}
	
	@Test(priority=20)
	public void homePageSearchTest(){
		HomePage.verifySearchButton();
		HomePage.clickOnSearchButton();
		HomePage.verifySearchPageHeaderText();
		Reusables.oneStepBack();
	}
	
	@Test(priority=30)
	public void homePageEvMenuTest(){
		HomePage.verifyEvMenuButton();
		HomePage.clickOnEvMenuButton();
		HomePage.verifyEvMenuElement();
		Reusables.oneStepBack();
	}
	
	@Test(priority=40)
	public void homePageRecipesListTest(){
		HomePage.clickOnCourese();
		HomePage.clickOnTasteBud();
		HomePage.clickOnAllRecipes();
		HomePage.clickOnCookWith();
		HomePage.clickOnTips();
		HomePage.clickOnEduBank();
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
