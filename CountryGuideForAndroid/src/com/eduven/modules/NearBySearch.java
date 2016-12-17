package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class NearBySearch {
	
	/* AndroidDriver Instance */
	AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By nearby_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/nearby");
	public static By nearby_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By resetBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/map_reset");
	public static By drawShapeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_draw_shape");
	public static By selectmarkerBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/selectDrawMarker");
	
	
	
	/**
	 * This method is used to click on the nearby button.
	 */
	public static void clickOnNearByButton(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(nearby_btn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Nearby Button still visible,,, "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify near by page header text.
	 */
	public static void verifyNearByPageHeaderTxt(String expected_Header_txt){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(nearby_page_header_txt), expected_Header_txt, "Error Message!! Actual Header txt does not matched with expected ones.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Near By page header txt not  found.. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to return the instance of reset button.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getResetInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(resetBtn);
		}catch(NoSuchElementException e){
			Logs.error("Reset Button Not visible. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance of Draw Shape button.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getDrawShapeInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(drawShapeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Draw Shape Button Not visible. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance of Select Marker button.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getSelectMarkerInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(selectmarkerBtn);
		}catch(NoSuchElementException e){
			Logs.error("Select Marker Button Not visible. "+e.getClass().getName());
		}
		
		return element;
	}
	
	
	/**
	 * This method is used to verify reset button.
	 */
	public static void verifyResetButton(){
		try{
			Reusables.verifyElementPresent(getResetInstance(), "Error Message!! Reset Button not visible.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>Reset Button not visible.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Draw Shape button.
	 */
	public static void verifyDrawShapeButton(){
		try{
			Reusables.verifyElementPresent(getDrawShapeInstance(), "Error Message!! Draw Shape Button not visible.");
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>Draw Shape Button not visible.. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify Select Marker button.
	 */
	public static void verifySelectMarkerButton(){
		try{
			Reusables.verifyElementPresent(getSelectMarkerInstance(), "Error Message!! Select Marker Button not visible.");
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>Select Marker Button not visible.. "+e.getClass().getName());
			}
		}
	
}
