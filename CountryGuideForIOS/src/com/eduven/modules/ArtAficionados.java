package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class ArtAficionados {
	
	    /* IOSDriver instance */
		static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
		
		/* Locator Identity */
		public static By art_aficionados_cat = By.name(DataConstants.art_aficionados_header_text);
		public static By categoryHeaderTxt = By.name("CategoryHeader");
		public static By for_element_count = By.xpath("//UIACollectionCell");

		/**
		 * This method is used to click on the Art Aficionados icon.
		 */
		public static void clickOnArtAficionados(){
			try{
				while (Reusables.isElementPresent(art_aficionados_cat) == false){
					Reusables.swipeUp();
				}
				Reusables.clickCommand(art_aficionados_cat);
				if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.art_aficionados_header_text) == true){
					
				}
				else if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.art_aficionados_header_text) == false){
					HomePage.navigateToHomePage();
					Reusables.customSwipeUp(0.7f, 0.5f);
					Reusables.clickCommand(art_aficionados_cat);
				}
			}catch(NoSuchElementException e){
				Logs.error(" Click operation not perform on the Art Aficionados icon. "+e.getClass().getName());
			}
		}
		
		/**
		 * This method is used to verify Header text.
		 */
		public static void verifyArtAficionadosHeaderTxt(){
			try{
				Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.art_aficionados_header_text, "Error Message! text message does not match.");
				}
		catch(NoSuchElementException e){
			Logs.error("Art Aficionados header text does not match. "+e.getClass().getName());
			}
			}
}
