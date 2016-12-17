package com.eduven.modules;

import java.util.List;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.Reusables;

public class SplashScreen {

	
	/*  Locator identification */
	public static By rateTheAppPopup = By.xpath("//*[@name='Rate Indian Recipes' and @value='0']");
	public static By remindMeLaterBtn = By.xpath("//*[@name='Remind me later' and @value='0']");
	public static By noThanksBtn = By.xpath("//*[@name='No, thanks' and @value='0']");
	public static By unitMeasure = By.xpath("//UIACollectionCell");
	public static By unitSelectionBtn = By.name("meter:kg");
	public static By legalDrinkingBtn = By.name("Yes");
	public static By hideKeyboardBtn = By.id("Hide keyboard");
	public static By laterBtn = By.xpath("//UIACollectionCell[1]"); //By.xpath("//UIAButton[starts-with(@name,'Later')]");
	public static By interstitialCloseBtn = By.id("Close Advertisement");
	public static By backBtn = By.xpath("//UIANavigationBar[1]/UIAButton[1]");
	public static By appHeaderTxtView = By.id("Header");
	public static By spaceKey = By.id("space");
	public static By shiftKey = By.id("shift");
	public static By deleteKey = By.id("delete");
	public static By hideiTuneStorePage = By.xpath("//UIAButton[contains(@name,'Back to')]");
	public static By sortBtn = By.id("");
	public static By sortByAlphabetsBtn = By.id("");
	public static By sortByPopularityBtn = By.id("");
	public static By getPremiumVersionTxt = By.id("");
	
	/**
	 * This method is used to hide the pop up on startup of the app.
	 * @return IOSElement : instance
	 */
	public static IOSElement noThanksBtnInstance(){
		
		return Reusables.getIOSElement(noThanksBtn);
	}
	
	/**
	 * This method is used to hide the rate this app.
	 */
	public static void hideAppRatePopUp(){
		try{
			if (Reusables.isElementPresent(noThanksBtn)){
				noThanksBtnInstance().click();
			}
			else if (Reusables.isElementPresent(HomePage.appNameTxt)){
			}
		}
		catch(NoSuchElementException e){
			Logs.warn("Rate "+DataConstants.appName+" Up Still Visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Select Unit System to measure Ingredients .
	 */
	public static String selectUnitSystemMeasureIngredients(){
		List<IOSElement> list;
		String selectedUnitType = "";
		try{
			if (Reusables.isElementPresent(unitMeasure) == true){
				if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.selectUnitMessageTxt) == true){
					list = Reusables.getIOSElementsList(unitMeasure);
					selectedUnitType = list.get(0).getAttribute("name").trim().toString();
					list.get(0).click();
				}
			}/*else if (Reusables.isElementPresent(HomePage.evMenuBtn) == true){
				Reusables.waitForIOSElement(HomePage.evMenuBtn);
			}*/
		}catch(NoSuchElementException e){
		}
		
		return selectedUnitType;
	}
	
	
	/**
	 * This method is used to accept alcoholic beverage .
	 */
	public static void acceptAlcoholicBeverage(){
		try{
			if (Reusables.isElementPresent(legalDrinkingBtn) == true){
				if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.alcoholicMessageTxt)){
					Reusables.waitThread(1);
					Reusables.acceptAlert();
					Reusables.waitThread(1);
				}
			}
			/*else if (Reusables.isElementPresent(HomePage.evMenuBtn)){
				Reusables.waitForIOSElement(HomePage.evMenuBtn);
			}*/
		}catch(NoSuchElementException e){
		}
		}
	
	/**
	 * This method is used to dismiss the more recipe alert popup.
	 */
	public static void dismissMoreRecipeAlertPopUp(){
		try{
			if (Reusables.isElementPresent(laterBtn)==true){
				if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.moreRecipeMessageTxt)==true){
					Reusables.clickCommand(laterBtn);
					Reusables.waitThread(1);
				}
			}
			/*else if (Reusables.isElementPresent(HomePage.evMenuBtn)){
				Reusables.waitForIOSElement(HomePage.evMenuBtn);
			}*/
		}catch(NoSuchElementException e){
		}
	}
	
	/**
	 * This method is used to perform alphabetic sorting.
	 */
	public static void forAlphabeticSorting(){
		try{
			if (DataConstants.appName.equalsIgnoreCase("seafood recipes") || DataConstants.appName.equalsIgnoreCase("meat lovers") || DataConstants.appName.equalsIgnoreCase("vegetarian") || DataConstants.appName.equalsIgnoreCase("vegan")){
				Reusables.waitForIOSElement(sortBtn);
				Reusables.clickCommand(sortBtn);
				if (Reusables.isElementPresent(sortByAlphabetsBtn)){
					Reusables.clickCommand(sortByAlphabetsBtn);
					Reusables.waitThread(2);
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Alphabetic Sorting button not found. "+e.getClass().getName());
		}
	}
}
