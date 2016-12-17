package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class TasteBudForMeatLovers {
	
	
	/* Object Identification */
	public static By sortByAlphabetsBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/sort_alphabet");
	public static By sortByPopularityBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/sort_popular");
	public static By getPremiumVersionTxt = By.id("android:id/title_template");
	
	
	/**
	 * This method is used to verify Taste Bud recipe name.
	 * @param typeOfDietName : String type
	 * @param tasteBudCategoryName : String type
	 */
	public static void verifyTasteBudCategoryRecipeList(String typeOfDietName, String tasteBudCategoryName){
		AndroidElement element = null;
		String tasteBudRecipeName = "";
		try {
			Reusables.waitThread(4);
			List<String> tasteBudDbRecipeNameList = DatabaseConnection.getTasteBudCategoryRecipeNameList(typeOfDietName, tasteBudCategoryName);
			SplashScreen.forAlphabeticSorting();
			for (int i = 0; i < tasteBudDbRecipeNameList.size()/10; i++) {
				tasteBudRecipeName = tasteBudDbRecipeNameList.get(i);
				if (Reusables.isElementPresent(By.xpath("//*[contains(@text,'"+tasteBudRecipeName+"')]")) == false) {
					Reusables.swipeUp();
				    Reusables.waitThread(1);
				 }
				element = Reusables.getElement(By.xpath("//*[contains(@text,'"+tasteBudRecipeName+"')]"));
				//Logs.info("Taste Bud Recipe Name "+ element.getAttribute("name").toString() + " Found.");
			}
		}catch (NoSuchElementException e) {
			Logs.error("Taste Bud Recipe Name " + element.getAttribute("name")+ " not found. " + e.getClass().getName());
		}
	}
}
