package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class SplashScreen {


	/*  Locator identification */
	public static By skipBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/textview_skip");
	public static By allowMediaContent = By.id("com.android.packageinstaller:id/permission_allow_button");
	public static By remineLaterBtn = By.id("android:id/button2");
	public static By alertMessageTxtView = By.id("android:id/message");
	public static By alcoholicBeverageBtn = By.id("android:id/button1");
	public static By unitSystemMeasureIngredient = By.id("android:id/button1");
	public static By cookWithAlert = By.id("android:id/button1");
	public static By evMenuBtn = By.xpath("//*[@content-desc='More options']");
	public static By addsView = By.id(DeviceRelatedInformation.getPackageName()+":id/adView");
	public static By userIdTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By checkBox = By.id(DeviceRelatedInformation.getPackageName()+":id/radioBtn");
	public static By continueBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/continue_btn");

	public static By industrialization = By.className("android.widget.ImageButton");
	public static By appHeaderTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_Title");
	public static By appSubHeaderTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	public static By sortByAlphabetsBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/sort_alphabet");
	public static By sortByPopularityBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/sort_popular");
	public static By getPremiumVersionTxt = By.id("android:id/title_template");
	
	
	/**
	 * This method is used to allow media files.
	 */
	public static boolean allowMediaFilesAndContacts(){
		boolean status = false;
		try{
			if (DeviceRelatedInformation.getDeviceVersion().equalsIgnoreCase("Marsmallow") || DeviceRelatedInformation.getDeviceVersion().equalsIgnoreCase("Nougat") ){
				if (Reusables.isElementPresent(allowMediaContent) == true){
					status = true;
					Reusables.clickUsingElement(Reusables.getElement(allowMediaContent));
					Reusables.waitThread(1);
				}
			}
			else if (Reusables.isElementPresent(evMenuBtn) == true){
				Reusables.verifyElementEnable(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found..");
			}
		}catch(NoSuchElementException e){
			//Logs.error(">>>>>>>>>> Allow Media Content pop up not found.. "+e.getClass().getName());
		}
		
		return status;
	}
	
	
	/**
	 * This method is used to remind me later..
	 */
	public static boolean remindLaterRecipeImage(){
		boolean status = false;
		try{
			if (Reusables.getText(alertMessageTxtView).contains(DataConstants.downloadRecipeImagesMessage) == true){
				status = true;
				Reusables.clickUsingElement(Reusables.getElement(remineLaterBtn));
			}
			else if (Reusables.isElementPresent(alertMessageTxtView) == true){
			}
			else if (Reusables.isElementPresent(evMenuBtn) == true){
            	Reusables.verifyElementEnable(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found..");
			}
		}catch(NoSuchElementException e){
			//Logs.error(">>>>>>>>>> Remind Me Later Pop Up not found "+e.getClass().getName());
		}
		
		return status;
	}
	
	/**
	 * This method is used to accept alcoholic beverage .
	 */
	public static void acceptAlcoholicBeverage(){
		try{
			if (Reusables.getText(alertMessageTxtView).contains(DataConstants.alcoholicTxt) == true){
				Reusables.clickUsingElement(Reusables.getElement(alcoholicBeverageBtn));
			}
			else if (Reusables.isElementPresent(alertMessageTxtView) == true){
			}
			else if (Reusables.isElementPresent(evMenuBtn) == true){
            	Reusables.verifyElementEnable(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found..");
			}
		}catch(NoSuchElementException e){
			//Logs.error("Alcoholic Beverage alert popup not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to accept alert in cook with category.
	 */
	public static void acceptCookWithAlert(){
		try{
			if (Reusables.isElementPresent(cookWithAlert) == true){
				Reusables.clickUsingElement(Reusables.getElement(cookWithAlert));
				if (Reusables.isElementPresent(cookWithAlert) == true)
			    	Reusables.clickUsingElement(Reusables.getElement(cookWithAlert));
			}
            else if (Reusables.isElementPresent(evMenuBtn) == true){
            	//System.out.println(Reusables.getElement(evMenu_btn).isDisplayed());
            	Reusables.verifyElementEnable(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found..");
			}
		}catch(NoSuchElementException e){
			//Logs.error(">>>>>>>>>>> Alert Pop up not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Select Unit System to measure Ingredients .
	 */
	public static String selectUnitSystemMeasureIngredients(){
		String selectedUnitType = "";
		try{
			//Reusables.waitForAndroidElement(Reusables.getElement(unitSystemMeasureIngredient));
			if (Reusables.getText(alertMessageTxtView).equalsIgnoreCase(DataConstants.select_unit_message) == true){
				selectedUnitType = Reusables.getText(unitSystemMeasureIngredient);
				Reusables.clickUsingElement(Reusables.getElement(unitSystemMeasureIngredient));
			}
			else if (Reusables.isElementPresent(alertMessageTxtView) == true){
			}
			else if (Reusables.isElementPresent(evMenuBtn) == true){
            	Reusables.verifyElementEnable(Reusables.getElement(evMenuBtn), "Error Message!! EvMenu Button not found..");
			}
		}catch(NoSuchElementException e){
			//Logs.warn("Select unit pop not visible. "+e.getClass().getName());
		}
		
		return selectedUnitType;
	}
	
	/**
	 * This method is used to verify adds view present or not.
	 */
	public static void verifyAddsView(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(addsView));
			Reusables.verifyElementEnable(Reusables.getElement(addsView), "Error Message!!Adds View Not present..");
		}catch(NoSuchElementException e){
			Logs.error("Adds View Not present.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify either user id pop up visible or not.
	 */
	public static void verifyUserIdPopUp(){
		try{
			if (Reusables.isElementPresent(userIdTxtView) == true){
				Reusables.clickCommand(checkBox);
				Reusables.waitThread(1);
				continueBtn();
			}
		}catch(NoSuchElementException e){
			Logs.error("User id poup not appear. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the continue button.
	 */
	public static void continueBtn(){
		try{
			Reusables.waitForElement(continueBtn);
			Reusables.clickCommand(continueBtn);
		}catch(NoSuchElementException e){
			Logs.error("Continue button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to perform alphabetic sorting.
	 */
	public static void forAlphabeticSorting(){
		try{
			if (DataConstants.appName.equalsIgnoreCase("seafood recipes") ||DataConstants.appName.equalsIgnoreCase("meat lovers") || DataConstants.appName.equalsIgnoreCase("vegetarian")){
				Reusables.waitForElement(sortByAlphabetsBtn);
				if (Reusables.isElementPresent(sortByAlphabetsBtn)){
					Reusables.clickCommand(sortByAlphabetsBtn);
					Reusables.waitThread(1);
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Alphabetic Sorting button not found. "+e.getClass().getName());
		}
	}
}
