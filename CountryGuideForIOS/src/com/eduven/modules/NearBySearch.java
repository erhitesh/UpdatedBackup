package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class NearBySearch {
	
	/* IOSDriver Instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Object Identification */
	public static By nearByBtn = By.name("NearByBtn");
	public static By acceptAlert = By.name("Allow");
	public static By selectMarkerBtn = By.name("Select marker");
	public static By drawBtn = By.name("Draw");
	public static By resetBtn = By.name("Reset");
	public static By filterBtn = By.name("legends");
	public static By pinsCount = By.xpath("//*[starts-with(@name, 'GMSMarker')]");
	public static By draw_lines = By.xpath("//*[starts-with(@name, 'GMSPolygon')]");
	public static By for_element_count = By.xpath("//UIATableCell");
	
	
	/**
	 * This method is used to click on the near by button.
	 */
	public static void clickOnNearByButton(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(nearByBtn));
			Reusables.click_using_element(Reusables.getElement(nearByBtn));
			}
		catch(NoSuchElementException e){
			Logs.error("Near By button not found. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to verify near by page open or not.
	 */
	public static void verifyNearByPageLoad(){
		try{
			Reusables.waitThread(3);
			Reusables.verifyElementPresent(Reusables.getElement(drawBtn), "Error Message!! Near By page not open.");
			}
		catch(NoSuchElementException e){
			Logs.error("Near By Page not Open. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to return the instance of element.
	 * @param by : locator type.
	 * @return : IOSElement.
	 */
	public static IOSElement getInstance(By by){
		
		return Reusables.getElement(by);
	}
	
	/**
	 * This method is used to verify Draw button.
	 */
	public static void verifyDrawButton(){
		try{
			Reusables.verifyElementPresent(getInstance(drawBtn), "Error Message!! Draw Button Not Present.");
		}catch(NoSuchElementException e){
			Logs.error("Draw button not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Select Marker Button.
	 */
	public static void verifySelectMarkerButton(){
		try{
			Reusables.verifyElementPresent(getInstance(selectMarkerBtn), "Error Message!! Select Marker Button Not Present.");
		}catch(NoSuchElementException e){
			Logs.error("Select Marker Button not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Pins Button.
	 */
	public static void verifyFilterButton(){
		try{
			Reusables.verifyElementPresent(getInstance(filterBtn), "Error Message!! Filter Button Not Present.");
		}catch(NoSuchElementException e){
			Logs.error("Pins button not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Reset Button. 
	 */
	public static void verifyResetButton(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElement(resetBtn), "Error Message!! Reset Button Not Present.");
		}catch(NoSuchElementException e){
			Logs.error("Reset button not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to handle the alert pop up.
	 */
	public static void handleAlertPopUp(){
		try{
			if (Reusables.isElementPresent(acceptAlert) == true){
				Reusables.acceptAlert();
			}
			else if (Reusables.isElementPresent(acceptAlert) == false){
				
			}
		}catch(NoSuchElementException e){
			Logs.warn("Alert popup not visible.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Draw button.
	 */
	public static void clickOnDrawButton(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(drawBtn));
			Reusables.click_using_element(Reusables.getElement(drawBtn));
			}
		catch(NoSuchElementException e){
			Logs.error("Draw button not found. "+e.getClass().getName());
			}
		}
	
	
	/**
	 * This method is used to click on the select marker button.
	 */
	public static void clickOnSelectMarkerButton(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(selectMarkerBtn));
			Reusables.click_using_element(Reusables.getElement(selectMarkerBtn));
			}
		catch(NoSuchElementException e){
			Logs.error("Select Marker button not found. "+e.getClass().getName());
			}
		}
	
	
	/**
	 * This method is used to click on the Filter button.
	 */
	public static void clickOnFilterButton(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(filterBtn));
			Reusables.click_using_element(Reusables.getElement(filterBtn));
			Reusables.waitThread(2);
			}
		catch(NoSuchElementException e){
			Logs.error("Filter button not found. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to click on the Reset button.
	 */
	public static void clickOnResetButton(){
		try{
			Reusables.waitForIosElement(Reusables.getElement(resetBtn));
			Reusables.click_using_element(Reusables.getElement(resetBtn));
			}
		catch(NoSuchElementException e){
			Logs.error("Reset button not found. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to get the pins count.
	 * @return : Integer, pins count.
	 */
	public static int getPinsCount(){
		int pinCount = 0;
		try{
			pinCount = Reusables.getElementsList(pinsCount).size();
			}
		catch(NoSuchElementException e){
			Logs.error("Pins not found. "+e.getClass().getName());
			}
		
		return pinCount;
		
		}
	
	/**
	 * This method is used to De-select category name from filter pop up.
	 */
	public static void deselectCategoryFromFilterPopUp(){
		try{
			List<IOSElement> categoryList = Reusables.getElementsList(for_element_count);
			for (int i = 0; i < categoryList.size(); i++){
				Reusables.click_using_element(categoryList.get(i));
				i++;
			}
		}catch(NoSuchElementException e){
			Logs.error("Filter Page Not Open. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify pins counts after DeSelect some category from filter page..
	 * @param beforeDeselectPinsCount : Type Integer before DeSelect.
	 * @param expectedPinsCount : Type Integer after DeSelect.
	 */
	public static void verifyPinsCountFromFilterPopUp(int beforeDeselectPinsCount, int expectedPinsCount){
		try{
			Reusables.verifyNotEqualMessage(Integer.toString(beforeDeselectPinsCount), Integer.toString(expectedPinsCount), "Error Message!! Pins count still same.");
			}
		catch(NoSuchElementException e){
			Logs.error("Pins count still same. "+e.getClass().getName());
		}
	}	
	
	/**
	 * This method is used to verify draw line.
	 */
	public static void verifyDrawLine(){
		try{
			Reusables.waitThread(2);
			Reusables.swipeLeft();
			//Reusables.drawLine(pinsCount);
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElementsList(draw_lines).get(0), "Error Messsage!! Draw Line Not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Draw Line not visible.. "+e.getClass().getName());
		}
	}
}
