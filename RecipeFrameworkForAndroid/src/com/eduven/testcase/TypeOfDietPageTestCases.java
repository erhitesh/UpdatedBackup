package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.HomePage;
import com.eduven.modules.TypeOfDiet;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class TypeOfDietPageTestCases {

	
	/* Global Variable Declaration */
	String type_of_diet_name = DataConstants.typeOfDietForVegetarian;
	
	
	@Test(priority=1)
	public void verifyAppNameTest(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=10)
	public void verifyTypeOfDietNameTest(){
		TypeOfDiet.verifyTypeOfDietNameList();
	}
	
	@Test(priority=20)
	public void selectFirstTypeOfDietTest(){
		TypeOfDiet.selectTypeOfDiet(type_of_diet_name);
	}
	
	@Test(priority=30)
	public void verifyHomePageHeaderTest(){
		HomePage.verifyHomePageHeaderTxt();
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

