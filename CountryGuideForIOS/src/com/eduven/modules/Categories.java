package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Categories {
	
	/* IosDriver instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Locator identity */
	public static By categories = By.name("categories_menu.png");
	public static By for_element_count = By.xpath("//UIACollectionCell");
	
	
	/**
	 * This method is used to return category element
	 * @return  IOSElement.
	 */
	public static IOSElement categoriesIconButton(){
		return Reusables.getElement(categories);
	}
	
	/**
	 * This method is used to verify category button present.
	 */
	public static void verfiyCategoryIconPresent(){
		try{
			Reusables.verifyElementPresent(categoriesIconButton(), "Error Message! Categories icon not Displayed.");
		}catch(NoSuchElementException e){
			Logs.error("categories icon not visible. "+e.getClass().getName());
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
	public static void verifyCategoryList() {
		IOSElement element;
		try{
			List<IOSElement> list = Reusables.getElementsList(for_element_count);
			IOSElement firstElement = list.get(0);
			IOSElement lastElement = list.get(list.size()-1);
			for (int i = 0; i < DatabaseConnection.getMainCategories().size(); i++) {
				element = driver.findElement(By.name(DatabaseConnection.getMainCategories().get(i)));
				while (!element.isDisplayed()) {
					if (!lastElement.isDisplayed()){
						Reusables.swipeUp();
					}
					else if (!firstElement.isDisplayed()){
						Reusables.swipeDown();
					}
				} 
				Reusables.waitForIosElement(element);
				Logs.info("Categories Name.. "+element.getAttribute("name").toString() +"..Found");
			}
		}catch(NoSuchElementException e){
			Logs.error("Categories not found. "+e.getClass().getName());
			}
		}
}
