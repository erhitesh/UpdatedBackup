package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.modules.Categories;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.Interstetial;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;

public class CheckInterstetialAfterPurchaseTestCases {


	/* Global variable Declaration */
	boolean interstetialStatusAfterPayment = false;

	@Test(priority=0)
	public void checkInterstetialForInAppTest(){
		Categories.navigateToCategoryPage();
		InAppPurchase.navigateToInAppPurchasePage();
		InAppPurchase.appPurchase();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
	}

	@Test(priority=10)
	public void checkInterstetialForCategoryTest(){
		Interstetial.interstetialForCategory();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
	}

	@Test(priority=20)
	public void checkInterstetialForSearchTest(){
		Interstetial.interstetialForSearch();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
	}

	@Test(priority=30)
	public void checkInterstetialForTermDetailPageTest(){
		Reusables.stepBack();
		Interstetial.verifyInterstetialBtn(interstetialStatusAfterPayment);
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