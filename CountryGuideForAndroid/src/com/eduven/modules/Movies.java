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


public class Movies {
	
	/* AndroidDriver Instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */
	public static By movies_cat = By.name(DataConstants.movies_header_txt);
	public static By movies_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By subcategorycount = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");

	/**
	 * This method is used to click on the Movies icon.
	 */
	public static void clickOnMovies() {
		try {
			while (Reusables.isElementPresent(movies_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(movies_cat);
			if (Reusables.getText(movies_cat_header_txt).equals(DataConstants.movies_header_txt) == true){
			}
			else if (Reusables.getText(movies_cat_header_txt).equals(DataConstants.movies_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(movies_cat);
			}
		} catch (NoSuchElementException e) {
			Logs.error(" Click opt not perform on  the Movies. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyMoviesHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(movies_cat_header_txt), DataConstants.movies_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Movies header text not matched. "+e.getClass().getName());
		}
	}

/*	
	*//**
	 * Verify the elements inside the Movies tab.
	 *//*
	public static void verifyMoviesCategoryList() {
		AndroidElement element = null;
		try {
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.art_aficionados_header_text).get(i)));
                Reusables.waitForAndroidElement(element);
                Logs.info("Movies Entity Found.."+element.getAttribute("name").toString());
			}
		}
		catch (NoSuchElementException e) {
			Logs.error(">>>>>>>>> Movies entity "+element.toString()+ e.getClass().getName());
		}
	}

	public static String clickOnRandomMoviesCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.movies_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.movies_header_txt).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error("Click on the random name "+random_name+ e.getClass().getName());
		}
		return random_name;

	}*/

}
