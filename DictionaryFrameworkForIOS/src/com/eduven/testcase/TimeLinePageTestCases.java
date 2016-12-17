package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.TimeLine;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class TimeLinePageTestCases {
	String randomEntityName = "";
	String search_term = DataConstants.time_line_search_term;
	
	@Test(priority=0)
	public void timeline_page_navigate_to_timeline_test(){
		TimeLine.NavigateToTimeLinePage();
		TimeLine.verifyTimeLinePageNavigation();
	}
	
	@Test(priority=1)
	public void timeline_page_select_random_player_test(){
		randomEntityName = TimeLine.getSelectRandomName();
		System.out.println("randomEntityName"+randomEntityName);
	}

	@Test(priority=2)
	public void timeline_page_verify_right_page_navigation_test(){
		TimeLine.verifyEntityHeaderPageText();
		TimeLine.verifyEntityName(randomEntityName);
	}
	
	@Test(priority=3)
	public void timeline_page_verify_terms_name_after_right_swipe_test(){
		randomEntityName = TimeLine.getEntityName();
		TimeLine.verify_terms_name_after_right_swipe(randomEntityName);
	}
	
	@Test(priority=4)
	public void timeline_page_verify_terms_name_after_left_swipe_test(){
		randomEntityName = TimeLine.getEntityName();
		TimeLine.verify_terms_name_after_left_swipe(randomEntityName);
	}
	
	@Test(priority=5)
	public void timeline_page_verify_search_test(){
		Reusables.oneStepBack();
		TimeLine.verifySearchTerm(search_term);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (ITestResult.FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()) {
			ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		}
	}

	@AfterClass
	public void closeApp() {
		Reusables.terminatesAppInstance();
	}

}
