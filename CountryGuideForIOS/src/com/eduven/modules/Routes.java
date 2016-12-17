package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Routes {
	
	/* IosDriver instance */ 
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	/* Locator Identity */
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By routes_icon = By.name(DataConstants.routes_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");
	public static By my_location_btn = By.name("my_location");
	public static By play_btn = By.name("play");
	public static By pause_btn = By.name("pause");
	public static By street_view_btn = By.name("street view");
	public static By street_view_disable_btn = By.name("street view disable");
	public static By speed_up_btn1 = By.name("1");
	public static By speed_up_btn2 = By.name("2");
	public static By speed_up_btn3 = By.name("3");
	public static By speed_up_btn4 = By.name("4");
	public static By speed_up_btn5 = By.name("5");
	public static By gsm_maker_count = By.xpath("//UIAButton[starts-with(@name, 'GMSMarker')]");

	
	/**
	 * This method is used to click on the Routes icon.
	 */
	public static void clickOnRoutes() {
		try {
			Reusables.clickCommand(routes_icon);
			}
		catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Routes. "+e.getClass().getName());
			}
		}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyRoutesHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.routes_header_txt, "Error Message! text message does not match.");
			}
		catch (NoSuchElementException e) {
			Logs.error("Routes header text not matched. "+e.getClass().getName());
			}
		}

	
	/**
	 * This method is used to return the play button instance.
	 * @return : IOSElement.
	 */
	public static IOSElement playBtnInstance(){
		
		return Reusables.getElement(play_btn);
		
	}
	
	/**
	 * This method is used to verify play button existance.
	 */
	public static void verifPlayButtonExistance(){
		try{
			Reusables.verifyElementPresent(playBtnInstance(), "Error Message! Play button not found.");
			}
		catch(NoSuchElementException e){
			Logs.error("Play button not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the play button.
	 */
	public static void clickOnPlayButton(){
		try{
			Reusables.click_using_element(playBtnInstance());
			}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the play button because pause button not visible. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to hide play button pop up.
	 */
	public static void hidePlayButtonPopUp(){
		try{
			Reusables.tap_on_element_using_coordinates(1, 78, 80);
			}
		catch(NoSuchElementException e){
			Logs.error("Tap operation not perform. "+e.getClass().getName());
			}
	}
	
	//********************************** pause button >>>>>>>>>>>>>>>>>>>>>>
	public static IOSElement pauseButtonInstance(){
		
		return Reusables.getElement(pause_btn);
	}
	
	public static void verifyPauseButtonExistance(){
		try{
			Reusables.verifyElementPresent(pauseButtonInstance(), "Error Message! Pause button not found.");
			}
		catch(NoSuchElementException e){
			Logs.error("Pause Button not visible. "+e.getClass().getName());
			}
		}
	
	public static void clickOnPauseButton(){
		try{
			Reusables.click_using_element(pauseButtonInstance());
			verifPlayButtonExistance();
			}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the pause button because play button not visible. "+e.getClass().getName());
			}
		}
	
	//*********************** street view ****************************
	public static IOSElement streetViewButtonInstance(){
		return Reusables.getElement(street_view_btn);
	}
	
	
	public static void verifyStreetViewButtonExistance(){
		try{
			Reusables.verifyElementPresent(streetViewButtonInstance(), "Error Message!Street view button not found");
			}
		catch(NoSuchElementException e){
			Logs.error("Street view button not visible. "+e.getClass().getName());
			}
		}
	
	
	public static void clickOnStreetViewButton(){
		try{
			Reusables.click_using_element(streetViewButtonInstance());
			}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the street view button. "+e.getClass().getName());
			}
		}
	
	public static void hide_street_view(){
		try{
			Reusables.clickCommand(street_view_disable_btn);
			}
		catch(NoSuchElementException e){
			Logs.error("Error Street view is still visible. "+e.getClass().getName());
		}
	}
	
	
	//************************ Speed up >>>>>>>>>>>>>>>>>>>>>>>>>>
	public static void verifySpeedUpButtonExistance(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(speed_up_btn1), "Error Message! Speed up button not display.");
		}
		catch(NoSuchElementException e){
			Logs.error("Speed up button not visible. "+e.getClass().getName());
		}
	}
	
	public static void selectSpeedUpButton(String select_speed_up){
		Reusables.clickCommand(speed_up_btn1);
		
		if (select_speed_up.equalsIgnoreCase("two")){
			Reusables.clickCommand(speed_up_btn2);
			Reusables.verifyElementPresent(Reusables.getElement(speed_up_btn2), "Error Message! Speed up button second not select");
		}
		
		else if (select_speed_up.equalsIgnoreCase("three")){
			Reusables.clickCommand(speed_up_btn3);
			Reusables.verifyElementPresent(Reusables.getElement(speed_up_btn3), "Error Message! Speed up button third not select");
		}
		
		else if (select_speed_up.equalsIgnoreCase("four")){
			Reusables.clickCommand(speed_up_btn4);
			Reusables.verifyElementPresent(Reusables.getElement(speed_up_btn4), "Error Message! Speed up button fourth not select");
		}
		
		else if (select_speed_up.equalsIgnoreCase("five")){
			Reusables.clickCommand(speed_up_btn5);		
			Reusables.verifyElementPresent(Reusables.getElement(speed_up_btn5), "Error Message! Speed up button fifth not select");
		}
	}
	
	
	//*************************coordinates****************************************
	public static int getGsmCount(){
		//System.out.println("Gsm count.."+Reusables.get_elements_list(gsm_maker_count).size());
		return Reusables.getElementsList(gsm_maker_count).size();
	}
	
	public static Point getGsmCoordinateValue(int coordinate_value){
		String xpath_for_routes = "//UIAButton[starts-with(@name, 'GMSMarker')]["+coordinate_value+"]";
		
		return Reusables.getElement(By.xpath(xpath_for_routes)).getLocation();
	}
	
	public static void verifyGsmLocationMovable(Point point1, Point point2){
		Assert.assertFalse(point1 != point2, "Error Message! Gsm maker not moving..");
	}
}
