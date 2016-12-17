package com.eduven.modules;

import java.util.List;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class CarnivalsFestivals {

	// IosDriver instance
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();

	// Locator Identity
	public static By categoryHeaderTxt = By.name("CategoryHeader");
	public static By carnivals_festivals_cat = By.name(DataConstants.carnivals_festivals_header_txt);
	public static By for_element_count = By.xpath("//UIACollectionCell");
	public static By subcategoryTerms = By.name("TermName");

	/**
	 * This method is used to click on the Carnivals & Festivals icon.
	 */
	public static void clickOnCarnivalsFestivals() {
		try {
			while (Reusables.isElementPresent(carnivals_festivals_cat) == false){
				Reusables.swipeUp();
			}
			Reusables.clickCommand(carnivals_festivals_cat);
			if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.carnivals_festivals_header_txt) == true){
			}
			else if (Reusables.getElement(categoryHeaderTxt).getText().equals(DataConstants.carnivals_festivals_header_txt) == false){
				HomePage.navigateToHomePage();
				Reusables.customSwipeUp(0.7f, 0.5f);
				Reusables.clickCommand(carnivals_festivals_cat);
			}
		} catch (NoSuchElementException e) {
			Logs.error("Click opt not perform on  the Carnivals & Festivals. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify Header text.
	 */
	public static void verifyCarnivalsFestivalsHeaderTxt() {
		try {
			Reusables.verifyEqualMessage(Reusables.getElement(categoryHeaderTxt).getText(), DataConstants.carnivals_festivals_header_txt,"Error Message! text message does not match.");
		} catch (NoSuchElementException e) {
			Logs.error("Carnivals & Festivals header text not matched. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify premium entity.
	 * @param mainCategoryName : Main category name, type String.
	 * @param subCategoryName : Sub category name, type String.
	 */
	public static void checkPremiumTermAsFreeTerm(String mainCategoryName, String subCategoryName){
		String paidTerm = "";
		String subCat = subCategoryName;
		paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCategoryName);
		 while (paidTerm.length() == 0){
			 Reusables.stepBack();
			 subCat = Reusables.clickOnRandomSubCategory(mainCategoryName);
			 paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCat);
		 }
		 System.out.println("Paid Term Name as free term name..."+paidTerm);
		 Reusables.waitThread(1);
		 List<IOSElement> listData = Reusables.getElementsList(subcategoryTerms);
		 for (int i = 0; i < listData.size(); i++){
			 if (listData.get(i).getText().equals(paidTerm) == true){
				 listData.get(i).click();
				 break;
			 }
		 }
		 /* Wait for moment for enable the add...........*/
		 Reusables.waitThread(3);
		 Reusables.hideIndustrialization();
		 Reusables.verifyEqualMessage(paidTerm, EntityDetailPage.getEntityName(), "Paid Term now seems as free term");
		 }
	
	
}
