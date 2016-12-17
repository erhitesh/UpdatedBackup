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
	String languageName = "";
	boolean interstetialStatusBeforePayment = true;
	String game_type = "Army Of Categories";
	String randomCategoryName = "";
	
	@Test(priority=1)
	public void check_interstetial_for_category_test(){
		Interstetial.interstetialForCategory();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=10)
	public void check_interstetial_for_search_test(){
		Interstetial.interstetialForSearch();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=20)
	public void check_interstetial_for_inapp_test(){
		Interstetial.interstetialForInApp();
		Interstetial.verifyInterstetialBtn(interstetialStatusBeforePayment);
	}
	
	@Test(priority=30)
	public void check_interstetial_for_detail_page_test(){
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
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
