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


public class Categories {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator identity */
	public static By categories = By.id(DeviceRelatedInformation.getPackageName()+":id/catView");
	public static By category_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	
	
	/**
	 * This method is used to return category element
	 * @return  AndroidElement.
	 */
	public static AndroidElement categoriesIconButton(){
		return Reusables.getElement(categories);
	}
	
	/**
	 * This method is used to verify Category Icon on home page.
	 */
	public static void verfiyCategoryIconPresent(){
		try{
			Reusables.verifyElementPresent(categoriesIconButton(), "Error Message! Categories icon not Displayed.");
		}
		catch(NoSuchElementException e){
			Logs.error("Categories icon not visible. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the categories icon button.
	 */
	public static void clickOnCategoriesIconButton(){
		try{
			categoriesIconButton().click();
		}
		catch(NoSuchElementException e){
			Logs.error("click opt not perform on the categories icon. "+e.getClass().getName());
		}	
	}
	
	/**
	 * Verify the elements inside the categories tab.
	 */
	public static void verifyCategoryEntityList() {

		AndroidElement element = null;
		try{
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(category_count);
			for (int i = 0; i < Reusables.getCategoryList(DataConstants.categories, "~").size(); i++) {
				if (i % element_count_value == 0 && i / element_count_value >= 1){
				Reusables.swipeUp();
				}
				element = driver.findElement(By.name(Reusables.getCategoryList(DataConstants.categories, "~").get(i)));
				Reusables.waitForAndroidElement(element);
				//Logs.info("Catagory Entity Found.."+element.getAttribute("name").toString());
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" Categories "+element.getText().toString()+ e.getClass().getName());
		}
		
		}
}
