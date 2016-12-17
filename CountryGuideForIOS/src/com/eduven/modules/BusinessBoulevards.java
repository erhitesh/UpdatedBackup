package com.eduven.modules;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class BusinessBoulevards {

	// IosDriver instance
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	// Locator Identity
	public static By business_boulevards_cat = By.name(DataConstants.business_boulevards_header_txt);
	public static By subCategoryElementCount = By.name("SubCategoryTermName");//By.xpath("//UIACollectionCell");
	public static By categoryHeaderTxt = By.name("CategoryHeader");

	/**
	 * This method is used to click on the Business Boulevards icon.
	 */
	public static void clickOnBusinessBoulevards() {
		try {
			while (Reusables.isElementPresent(business_boulevards_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(business_boulevards_cat);
			if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.business_boulevards_header_txt) == true){
				
			}
			else if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.business_boulevards_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(business_boulevards_cat);
			}
		}
		catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the business boulevards. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyBusinessBoulevardsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(),DataConstants.business_boulevards_header_txt,"Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Business Boulevards header text not matched. "+e.getClass().getName());
		}
	}

/*	*//**
	 * Verify the elements inside the Business Boulevards tab.
	 *//*
	public static void verifyBusinessBoulevardsCategoryList() {
		IOSElement element;
		try {
			int elementCount = Reusables.getElementsList(for_element_count).size();
			for (int i = 0; i < elementCount; i++) {
				element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.business_boulevards_header_txt).get(i)));
				if (!element.isDisplayed()) {
					Reusables.swipeUp();
					} 
				Reusables.waitForIosElement(element);
				Logs.info("Find Business Boulevards Category... "+element.getText().toString());
				}
		}catch (NoSuchElementException e) {
			Logs.error("Business Boulevards entity not found."+e.getClass().getName());
		}
	}

	public static String clickOnRandomBusinessBoulevardsCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.business_boulevards_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.business_boulevards_header_txt).get(randomNumber);
			Reusables.clickCommand(By.name(random_name));
		} catch (NoSuchElementException e) {
			Logs.error("Click on the random name not perform. "+e.getClass().getName());
		}
		return random_name;

	}*/
}
