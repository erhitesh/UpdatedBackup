package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Interstetial;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class CheckInterstetialBeforePurchaseTestCases {
	
	
	/* Global Declaration */
	boolean interstetialStatusBeforePayment = true;
	
	@Test(priority=1)
	public void checkInterstetialForCategoryTest(){
		Interstetial.interstetialForCategory();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=10)
	public void checkInterstetialForSearchTest(){
		Interstetial.interstetialForSearch();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=20)
	public void checkInterstetialForInAppTest(){
		Interstetial.interstetialForInApp();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=30)
	public void checkInterstetialForTermDetailPageTest(){
		Reusables.stepBack();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
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
