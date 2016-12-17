package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class HomePage {
	
	
	/* Locator Identification */
	public static By swipe = By.id(DeviceRelatedInformation.getPackageName()+":id/horiList");
	public static By appNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_Title");//By.name("SMART Indian Recipes");
	public static By home_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Home");
	public static By search_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/search");
	public static By searchPageHeader = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Search");
	
	public static By evMenu_btn = By.xpath("//*[@content-desc='More options']");  
	public static By evMenu_element_btn = By.name("Tips");
	
	public static By course_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/courses2");
	public static By course_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Courses");
	
	public static By taste_bud_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/taste_bud");
	public static By taste_bud_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Taste Buds");
	
	public static By tips_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/tips");
	public static By tips_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	public static By cooking_type_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/action");
	public static By cooking_type_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Cooking Type");
	
	public static By cook_with_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/icon_coins2");
	public static By cook_with_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Cook with");
	
	public static By allrecipes_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/icon_all_recipes");
	public static By allrecipes_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Recipes");
	public static By eduBankBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/icon_favourites2");
	public static By nextArrow = By.id(DeviceRelatedInformation.getPackageName()+":id/next");
	
	
	/**
	 * This method is used to navigate to the home page.
	 */
	public static void navigateToHomePage(){
		try{
			Reusables.stepBackTillElementNotFound(home_page_header_txt, DataConstants.homePageHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Home Page not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify App name on home page
	 */
	public static void verifyAppName(){
		try{
			Reusables.waitThread(10);
			if (DataConstants.appName.equalsIgnoreCase("Seafood Recipes") || DataConstants.appName.equalsIgnoreCase("meat lovers")){
				Reusables.waitForElement(nextArrow);
				while (Reusables.isElementPresent(nextArrow)){
					Reusables.clickCommand(nextArrow);
				}
			}
			Reusables.waitForElement(appNameTxt);
			Reusables.verifyEqualMessage(Reusables.getText(appNameTxt), DataConstants.appName, "Error Message!! Actual and Expected text not matched.");
		}catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>> Actual and Expected text not matched. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Home Page Header Text.
	 */
	public static void verifyHomePageHeaderTxt(){
		try{
			Reusables.waitForElement(home_page_header_txt);
			Reusables.verifyEqualMessage(Reusables.getText(home_page_header_txt), DataConstants.homePageHeaderTxt, "Error Message!!Home Page Header text not found.");
		}catch(NoSuchElementException r){
			Logs.error("Home Page Header text not found.. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Search button on home page.
	 */
	public static void verifySearchButton(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(search_btn), "Error Message!! Search Button not found.. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to Click on Search button on home page.
	 */
	public static void clickOnSearchButton(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(search_btn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search Page not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Search page header text on Search page.
	 */
	public static void verifySearchPageHeaderText(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(searchPageHeader), "Error Message!! Search Page Header not found");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Search Page Header not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EvMenu button on home page.
	 */
	public static void verifyEvMenuButton(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(evMenu_btn), "Error Message!! EvMenu button not found.. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on EvMenu button on home page.
	 */
	public static void clickOnEvMenuButton(){
		try{
			Reusables.clickUsingElement(Reusables.getElement(evMenu_btn));
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu button not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify EvMenu page element.
	 */
	public static void verifyEvMenuElement(){
		try{
			Reusables.verifyElementEnable(Reusables.getElement(evMenu_element_btn), "Error Message!! EvMenu element not found.. ");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> EvMenu element not found.. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Recipes Terms >>>>>>>>>>>>>>>>>>>>>>>>
	
	/**
	 * This method is used to return the instance of course button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement courseInstance(){
		
		return Reusables.getElement(course_btn);
	}
	
	/**
	 * This method is used to return the instance of TasteBud button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement tasteBudInstance(){
		
		return Reusables.getElement(taste_bud_btn);
	}
	
	/**
	 * This method is used to return the instance of AllRecipes button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement allRecipesInstance(){
		
		return Reusables.getElement(allrecipes_btn);
	}
	
	/**
	 * This method is used to return the instance of CookWith button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement cookWithInstance(){
		
		return Reusables.getElement(cook_with_btn);
	}
	
	/**
	 * This method is used to return the instance of Tips button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement tipsInstance(){
		
		return Reusables.getElement(tips_btn);
	}
	
	/**
	 * This method is used to return the instance of Cooking Type button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement cookingTypeInstance(){
		
		return Reusables.getElement(cooking_type_btn);
	}
	
	/**
	 * This method is used to return the instance of EduBank button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement eduBankInstance(){
		
		return Reusables.getElement(eduBankBtn);
	}
	
	/**
	 * This method is used to click on the course button.
	 */
	public static void clickOnCourese(){
		try{
			while (Reusables.isElementPresent(course_btn) == false){
				Reusables.HorizontalLeftSwipe(swipe);
			}
			Reusables.waitForAndroidElement(Reusables.getElement(course_btn));
			courseInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
			Reusables.verifyEqualMessage(Reusables.getText(course_header), DataConstants.course_header_value, "Error Message!! Course Page not loaded.");
			Reusables.oneStepBack();
		}catch(NoSuchElementException e){
			Logs.error("Courese Button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the TasteBud button.
	 */
	public static void clickOnTasteBud(){
		try{
			while (Reusables.isElementPresent(taste_bud_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForElement(taste_bud_btn);
			tasteBudInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
			Reusables.verifyEqualMessage(Reusables.getText(taste_bud_header), DataConstants.taste_bud_header_value, "Error Message!! Taste Bud Page not loaded.");
			Reusables.oneStepBack();
		}catch(NoSuchElementException e){
			Logs.error("TasteBud button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Tips button.
	 */
	public static void clickOnTips(){
		try{
			while (Reusables.isElementPresent(tips_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForAndroidElement(Reusables.getElement(tips_btn));
			tipsInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			Reusables.verifyEqualMessage(Reusables.getText(tips_header), DataConstants.tip_page_header_txt, "Error Message!! Tips Page header text not found.");
			Reusables.oneStepBack();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Tips Page header text not found."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Cooking Type button.
	 */
	public static void clickOnCookingType(){
		try{
			while (Reusables.isElementPresent(cooking_type_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForAndroidElement(Reusables.getElement(cooking_type_btn));
			cookingTypeInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
			Reusables.verifyEqualMessage(Reusables.getText(cooking_type_header), DataConstants.cooking_type_header_value, "Error Message!! Cooking Type Page not loaded.");
			Reusables.oneStepBack();
		}catch(NoSuchElementException e){
			Logs.error("Cooking Type button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the CookWith button.
	 */
	public static void clickOnCookWith(){
		try{
			while (Reusables.isElementPresent(cook_with_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForElement(cook_with_btn);
			cookWithInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.acceptCookWithAlert();
			Reusables.verifyEqualMessage(Reusables.getText(cook_with_header), DataConstants.cook_with_header_value, "Error Message!! Cook With Page not loaded.");
			Reusables.waitThread(2);
			Reusables.oneStepBack();
		}catch(NoSuchElementException e){
			Logs.error("CookWith button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the AllRecipes button.
	 */
	public static void clickOnAllRecipes(){
		try{
			while (Reusables.isElementPresent(allrecipes_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForAndroidElement(Reusables.getElement(allrecipes_btn));
			allRecipesInstance().click();
			SplashScreen.remindLaterRecipeImage();
		    SplashScreen.acceptAlcoholicBeverage();
		    Reusables.verifyEqualMessage(Reusables.getText(allrecipes_header), DataConstants.all_recipes_header_value, "Error Message!! All Recipes Page not loaded.");
		    Reusables.oneStepBack();
		}catch(NoSuchElementException e){
			Logs.error("AllRecipes button not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static void clickOnEduBank(){
		try{
			while (Reusables.isElementPresent(eduBankBtn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForElement(eduBankBtn);
			eduBankInstance().click();
			EduBank.verifyEduBankHeaderText();
		}catch(NoSuchElementException e){
			Logs.error("EduBank button not found.. "+e.getClass().getName());
		}
	}
}
