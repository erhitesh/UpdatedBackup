package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class ArtAficionados {
	
	    /* AndroidDriver instance */
		static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
		
		/* Locator Identity */
		public static By art_aficionados_cat = By.name(DataConstants.art_aficionados_header_text);
		public static By art_aficionados_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
		public static By element_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
		
		/**
		 * This method is used to click on the Art Aficionados icon.
		 */
		public static void clickOnArtAficionados(){
			try{
				while (Reusables.isElementPresent(art_aficionados_cat) == false){
					Reusables.swipeUp();
				}
				Reusables.clickCommand(art_aficionados_cat);
				if (Reusables.getText(art_aficionados_cat_header_txt).equals(DataConstants.art_aficionados_header_text) == true){
					
				}
				else if (Reusables.getText(art_aficionados_cat_header_txt).equals(DataConstants.art_aficionados_header_text) == false){
					HomePage.navigateToHomePage();
					Reusables.customSwipeUp(0.7f, 0.5f);
					Reusables.clickCommand(art_aficionados_cat);
					}
				}
			catch(NoSuchElementException e){
				Logs.error("Click operation not perform on the Art Aficionados icon. "+e.getClass().getName());
				}
			}
		
		/**
		 * This method is used to verify Header text.
		 */
		public static void verifyArtAficionadosHeaderTxt(){
			try{
			Reusables.verifyEqualMessage(Reusables.getText(art_aficionados_cat_header_txt), DataConstants.art_aficionados_header_text, "Error Message! text message does not match.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>Actual and expected text does not match. "+e.getClass().getName());
			}
		}
		
		/**
		 * Verify the elements inside the Art Aficionados tab.
		 *//*
		public static void verifyArtAficionadosCategoryList() {
			AndroidElement element = null;
			try{
				Reusables.waitThread(4);
				int element_count_value = Reusables.elementCount(for_element_count);	
				for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).size(); i++){
				
					if (i % element_count_value == 0 && i / element_count_value >= 1){
						System.out.println("Value Of i.."+i);
						Reusables.swipeUp();
						}
	                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).get(i)));
	                if (Reusables.isElementPresent(By.name(element.getAttribute("name").toString())) == true){
	                	
	                }
	                else if (Reusables.isElementPresent(HomePage.homeBtn) == true){
	                	System.out.println("Inside loop");
	                	Reusables.swipeUp();
	                }
	                Reusables.waitForAndroidElement(element);
	                Logs.info("Art Aficionados Entity Found.."+element.getAttribute("name").toString());
					}
			}
			catch(NoSuchElementException e){
				Logs.error("Art Aficionados Entity"+element.getAttribute("name").toString()+" not found. "+e.getClass().getName());
				}
		}
		
		*//**
		 * This method is used to click on the random art aficionados
		 * @return
		 *//*
		public static String clickOnRandomArtAficionadosCategory(){
			String random_name = "";
			try{
				int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).size());
				random_name = DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).get(randomNumber);
				Reusables.clickUsingScrollToExactTxt(random_name);
			}catch(NoSuchElementException e){
				Logs.error("Art Aficionados element "+random_name+ e.getClass().getName());
			}
		    return random_name;
		}*/
		
/*		*//**
		 * This method is used to click on city name inside term name.
		 *//*
		public static void clickOnCityNameInSideTermName(String cityName){
			try{
				Reusables.waitThread(2);
				while (Reusables.isElementPresent(By.name(cityName)) == false){
					Reusables.customSwipeUp(0.7f, 0.5f);
				}
				for (int i = 0; i < 6; i++){
					Reusables.customSwipeUp(0.7f, 0.5f);
					Reusables.waitThread(1);
				}
				Reusables.clickUsingString(cityName);
				Reusables.waitThread(2);
			}
			catch(NoSuchElementException e){
				Logs.error("City Name not found. "+e.getClass().getName());
			}
		}
		
		*//**
		 * This method is used to get city header name.
		 * @return : String as city name.
		 *//*
		public static String getCityHeaderName(){
			String city_header_name= "";
			try{
				Reusables.waitForElement(city_header_txt);
				city_header_name = Reusables.getText(city_header_txt);
			}catch(NoSuchElementException e){
				Logs.error("City Header Name not found. "+e.getClass().getName());
			}
			
			return city_header_name;
		}
		
		*//**
		 * This method is used to verify city header text.
		 * @param expectedName : for verification
		 *//*
		public static void verifyCityHeaderName(String expectedName){
			try{
				Reusables.verifyEqualMessage(getCityHeaderName(), expectedName, "Error Message!! Actual and Expected text not matched.");
			}catch(NoSuchElementException e){
				Logs.error("Actual and Expected text not matched. "+e.getClass().getName());
			}
		}*/
}
