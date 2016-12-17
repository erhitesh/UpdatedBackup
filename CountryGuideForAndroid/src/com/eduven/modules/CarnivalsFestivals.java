package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class CarnivalsFestivals {

	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator Identity */
	public static By carnivals_festivals_cat = By.name(DataConstants.carnivals_festivals_header_txt);
	public static By carnivals_festivals_cat_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By subacategorycount = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");

	/**
	 * This method is used to click on the Carnivals & Festivals icon.
	 */
	public static void clickOnCarnivalsFestivals() {
		try {
			while (Reusables.isElementPresent(carnivals_festivals_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(carnivals_festivals_cat);
			if (Reusables.getText(carnivals_festivals_cat_header_txt).equals(DataConstants.carnivals_festivals_header_txt) == true){
				
			}
			else if (Reusables.getText(carnivals_festivals_cat_header_txt).equals(DataConstants.carnivals_festivals_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(carnivals_festivals_cat);
				}
		} catch (NoSuchElementException e) {
			Logs.error(">>>>>Click opt not perform on  the Carnivals & Festivals. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyCarnivalsFestivalsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getText(carnivals_festivals_cat_header_txt), DataConstants.carnivals_festivals_header_txt, "Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Actual and expected text not matched. "+e.getClass().getName());
		}
	}

/*	
	*//**
	 * Verify the elements inside the Carnivals & Festivals tab.
	 *//*
	public static void verifyCarnivalsFestivalsCategoryList() {

		AndroidElement element = null;
		try {
			Reusables.waitThread(4);
			int element_count_value = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(DataConstants.carnivals_festivals_header_txt).size(); i++){
				if (i % element_count_value == 0 && i / element_count_value >= 1){
					System.out.println("Value Of i.."+i);
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(DataConstants.carnivals_festivals_header_txt).get(i)));
                Reusables.waitForAndroidElement(element);
                Logs.info("Carnivals & Festivals Entity Found.."+element.getAttribute("name").toString());
			}	
		}
		catch (NoSuchElementException e) {
			Logs.error(">>>>>> Carnivals & Festivals entity"+element.toString()+ e.getClass().getName());
		}
	}

	*//**
	 * This method is used to click on the random carnivals festival category.
	 * @return
	 *//*
	public static String clickOnRandomCarnivalsFestivalsCategory() {
		String random_name = "";
		try {
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(DataConstants.carnivals_festivals_header_txt).size());
			random_name = DatabaseConnection.getSubCategoryList(DataConstants.carnivals_festivals_header_txt).get(randomNumber);
			Reusables.clickUsingScrollToExactTxt(random_name);
		} catch (NoSuchElementException e) {
			Logs.error(">>>>>>>> Click on the random name"+random_name+ e.getClass().getName());
		}
		return random_name;

	}
*/
	
	/**
	 * This method is used to verify premium entity.
	 * @param mainCategoryName : Main category name, type String.
	 * @param subCategoryName : Sub category name, type String.
	 */
	public static void checkPremiumTermAsFreeTerm(String mainCategoryName, String subCategoryName){
		 String paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCategoryName);
		 System.out.println("Paid Term Name..."+paidTerm);
		 Reusables.waitThread(1);
		 Reusables.clickCommand(By.name(paidTerm));
		 /* Wait for moment for enable the add...........*/
		 Reusables.waitThread(3);
		 Reusables.hideIndustrialization();
		 Reusables.verifyEqualMessage(paidTerm, EntityDetailPage.getTermName(), "Paid Term now seems as free term");
		 }
	
}
