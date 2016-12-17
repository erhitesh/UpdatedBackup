package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Routes {
	
	/* AndroidDriver instance */ 
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */ 
	public static By routes_cat_entity = By.name(DataConstants.routes_header_txt);
	public static By routes_cat_entity_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By for_element_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	public static By my_location_btn = By.name("my_location");
	public static By play_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_route_play");
	public static By pause_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_route_play");
	public static By street_view_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_streetview");
	public static By street_view_disable_btn = By.name("street view disable");
	public static By speed_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_popup");
	public static By speed_up_icons = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_icon");
	public static By speed_up_tracks = By.id(DeviceRelatedInformation.getPackageName()+":id/tracks");
	public static By gsm_maker_count = By.xpath("//UIAButton[starts-with(@name, 'GMSMarker')]");

	
	/**
	 * This method is used to click on the Routes icon.
	 */
	public static void clickOnRoutes() {
		try {
			while (Reusables.isElementPresent(routes_cat_entity) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(routes_cat_entity);
			if (Reusables.getText(routes_cat_entity_header_txt).equals(DataConstants.routes_header_txt) == true){
				
			}
			else if (Reusables.getText(routes_cat_entity_header_txt).equals(DataConstants.routes_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(routes_cat_entity);
				}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Routes. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyRoutesHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(routes_cat_entity_header_txt),DataConstants.routes_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Routes header text not matched. "+e.getClass().getName());
		}
	}

/*	*//**
	 * Verify the elements inside the Routes tab.
	 *//*
	public static void verifyRoutesCategoryList() {
		AndroidElement element = null;
		try {
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.routes_header_txt).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.routes_header_txt).get(i)));
                Reusables.waitForAndroidElement(element);
                Logs.info("Routes Entity Found.."+element.getAttribute("name").toString());
			}
		}
		catch (NoSuchElementException e) {
			Logs.error("Routes entity "+element.toString()+" not found. "+e.getClass().getName());
		}
	}

	public static String clickOnRandomRoutesCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.routes_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.routes_header_txt).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error("Click on the random name "+random_name+ e.getClass().getName());
		}
		return random_name;

	}
	*/
	//*********************play button >>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to return the instance of play button.
	 * @return
	 */
	public static AndroidElement playBtnInstance(){
		
		return Reusables.getElement(play_btn);
	}
	
	public static void verifyPlayButtonExistance(){
		try{
			Reusables.waitForElement(play_btn);
			Reusables.verifyElementPresent(playBtnInstance(), "Error Message! Play button not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Play button not visible. "+e.getClass().getName());
		}
	}
	
	public static void clickOnPlayButton(){
		try{
			Reusables.clickUsingElement(playBtnInstance());
			Reusables.waitThread(4);
		}
		catch(NoSuchElementException e){
			Logs.error(" Click operation not perform on the play button because pause button not visible. "+e.getClass().getName());
		}
	}
	
	
	public static void hidePopUpMessageBox(){
		try{
			Reusables.tapOnElementUsingCoordinates(1, 250, 250);
		}
		catch(NoSuchElementException e){
			Logs.error("Tap operation not perform. "+e.getClass().getName());
		}
	}
	
	//**********************************pause button >>>>>>>>>>>>>>>>>>>>>>>>>
	
	public static AndroidElement pauseButtonInstance(){
		
		return Reusables.getElement(pause_btn);
	}
	
	public static void verifyPauseButtonExistance(){
		try{
			Reusables.verifyElementPresent(pauseButtonInstance(), "Error Message! Pause button not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Pause Button not visible. ");
		}
	}
	
	public static void clickOnPauseButton(){
		try{
			Reusables.clickUsingElement(pauseButtonInstance());
			verifyPlayButtonExistance();
		}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the pause button because play button not visible. ");
		}
	}
	
	//***********************street view****************************
	public static AndroidElement streetViewButtonInstance(){
		
		return Reusables.getElement(street_view_btn);
		
	}
	
	
	public static void verifyStreetViewButtonExistance(){
		try{
			Reusables.verifyElementPresent(streetViewButtonInstance(), "Error Message!Street view button not found");
		}
		catch(NoSuchElementException e){
			Logs.error("Street view button not visible, "+e.getClass().getName());
		}
	}
	
	
	public static void clickOnStreetViewButton(){
		try{
			Reusables.clickUsingElement(streetViewButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the street view button. "+e.getClass().getName());
		}
	}
	
	public static void hideStreetView(){
		try{
			Reusables.clickCommand(street_view_disable_btn);
		}
		catch(NoSuchElementException e){
			Logs.error("Error Street view is still visible. "+e.getClass().getName());
		}
	
	}
	
	
	/*********************************************Speed up*************************************************/
	public static void verifySpeedButtonExistance(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElement(speed_btn), "Error Message! Speed up button not display.");
		}
		catch(NoSuchElementException e){
			Logs.error("Speed up button not visible. ");
		}
	}
	
	public static void verifyTracks(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(speed_up_tracks), "Error Message! Speed Up Tracks not visible.........");
		}
		catch(NoSuchElementException e){
			Logs.error("Speed tracks is not visible. ");
		}
	}
	
	/**
	 * This method is used to return the total number speed up buttons.
	 * @return : type int
	 */
	public static int speed_up_count(){
		
		return Reusables.getElementsList(speed_up_icons).size();
	}
	
	public static void select_speed_up_button(){
		Reusables.clickCommand(speed_btn);
		verifyTracks();
		Reusables.clickUsingElement(Reusables.getElementsList(speed_up_icons).get(Reusables.randomNumber(speed_up_count())));
		verifySpeedButtonExistance();
	}
	
	/* *************************coordinates**************************************** */
	public static int getGsmCount(){
		//System.out.println("Gsm count.."+Reusables.get_elements_list(gsm_maker_count).size());
		return Reusables.getElementsList(gsm_maker_count).size();
	}
	
	/**
	 * This method is used to get pint location of pins.
	 * @param coordinate_value : Type int
	 * @return : Return the coordinates value of the pins.
	 */
	public static Point getGsmCoordinateValue(int coordinate_value){
		String xpath_for_routes = "//UIAButton[starts-with(@name, 'GMSMarker')]["+coordinate_value+"]";
		return Reusables.getElement(By.xpath(xpath_for_routes)).getLocation();
	}
	
	/**
	 * This method is used to verify either point are moving or not.
	 * @param point1 : first pin location before start.
	 * @param point2 : Destination pin location after start.
	 */
	public static void verifyGsmLocationMovable(Point point1, Point point2){
		Assert.assertFalse(point1 != point2, "Error Message! Gsm maker not moving..");
	}
}
