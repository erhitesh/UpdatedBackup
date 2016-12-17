package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class QuickGuide {

	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By quick_quide_txtview = By.id(DeviceRelatedInformation.getPackageName()+":id/feature1_box");
	public static By quick_guide_header_txt = By.name("Quick Guide");
	public static By previous_btn= By.id(DeviceRelatedInformation.getPackageName()+":id/btn_prev");
	public static By next_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_next");
	public static By page_view_number = By.id("android:id/text1");
	
	
	
	/**
	 * This method is used to click on the quick guide textview.
	 */
	public static void navigateToQuickGuidePage(){
		try{
			Reusables.waitForElement(quick_quide_txtview);
			Reusables.clickCommand(quick_quide_txtview);
		}catch(NoSuchElementException e){
			Logs.error("Quick Guide textview still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify quick guide page visible.
	 */
	public static void verifyQuickGuidePageLoaded(){
		try{
			Reusables.waitForElement(quick_guide_header_txt);
		}catch(NoSuchElementException e){
			Logs.error("Quick Guide Page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify previous button visible.
	 */
	public static void verifyPreviousButton(){
		try{
			Reusables.waitForElement(previous_btn);
		}catch(NoSuchElementException e){
			Logs.error("Previous button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the next button.
	 */
	public static void forwardNavigation(){
		try{
			Reusables.waitForElement(next_btn);
			Reusables.clickCommand(next_btn);
		}catch(NoSuchElementException e){
			Logs.error("Next button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify next button visible.
	 */
	public static void verifyNextButton(){
		try{
			Reusables.waitForElement(next_btn);
		}catch(NoSuchElementException e){
			Logs.error("Next button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the next button.
	 */
	public static void backwardNavigation(){
		try{
			Reusables.waitForElement(previous_btn);
			Reusables.clickCommand(previous_btn);
		}catch(NoSuchElementException e){
			Logs.error("Previous button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify page view visible.
	 */
	public static void verifyPageView(){
		try{
			Reusables.waitForElement(page_view_number);
		}catch(NoSuchElementException e){
			Logs.error("Page view not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get page view number.
	 * @return : String as view number.
	 */
	public static String getViewNumber(){
		String viewNumber = "";
		try{
			Reusables.waitForElement(page_view_number);
			viewNumber = Reusables.getText(page_view_number);
			
		}catch(NoSuchElementException e){
			Logs.error("View Number not found. "+e.getClass().getName());
		}
		
		return viewNumber;
	}
	
	
	public static void verifyPageViewNavigation(String expectedText){
		try{
			Reusables.verifyNotEqualMessage(getViewNumber(), expectedText, "Error Message!! View Navigation not correct.");
		}catch(NoSuchElementException e){
			Logs.error("View Navigation not correct. "+e.getClass().getName());
		}
	}

}
