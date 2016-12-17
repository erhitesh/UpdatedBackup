package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EduBank {
	
	
	/* Object Identification */
	public static By eduBank_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/icon_favourites2");
	public static By eduBankHeaderText = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By swipe = By.id(DeviceRelatedInformation.getPackageName()+":id/horiList");
	public static By home_page_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By course_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/courses2");
	public static By course_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	//Recipes list page
	public static By edubankOnRecipeListImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/favourite_full_image");
	public static By edubankOnRecipeDetailImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/favourites");
	public static By alertMessagePopupTxtView = By.id("android:id/message");
	public static By acceptAlertMessagePopupBtn = By.id("android:id/button1");
	
	
	
	/**
	 * This method is used to return the instance of EduBank button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement eduBankInstance(){
		
		return Reusables.getElement(eduBank_btn);
	}
	
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static void clickOnEduBank(){
		try{
			while (Reusables.isElementPresent(eduBank_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForElement(eduBank_btn);
			eduBankInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("EduBank button not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify edubank header text.
	 */
	public static void verifyEduBankHeaderText(){
		String imageFilePath = "";
		try{
			imageFilePath = ScreenShot.takescreenShotCaptureForToast();
			if (Reusables.isElementPresent(HomePage.eduBankBtn) == true){
				Reusables.verifyToastMessageUsingImage(imageFilePath, DataConstants.toastMessageForEduBank);
			}
			else if (Reusables.isElementPresent(Filter.filterBtn) == true){
				Reusables.verifyElementTextPresent(EduBank.eduBankHeaderText, DataConstants.eduBank_header_value);
			}
		}catch(NoSuchElementException e){
			Logs.error("Neither Edubank nor toast message appear. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to return the instance of course button.
	 * @return : type AndroidElement
	 */
	public static AndroidElement courseInstance(){
		
		return Reusables.getElement(course_btn);
	}
	
	/**
	 * This method is used to navigate to course page.
	 */
	public static void navigateToCoursePage(){
		try{
			while (Reusables.isElementPresent(course_btn) == false){
				Reusables.HorizontalRightSwipe(swipe);
			}
			Reusables.waitForAndroidElement(Reusables.getElement(course_btn));
			courseInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
		}catch(NoSuchElementException e){
			Logs.error("Courese Page not Loaded.. "+e.getClass().getName());
		}
	}
	
	
	//Edubank on recipe list page.
	/**
	 * This method is used to click on the edubank button on recipe list page.
	 * @param index : integer value for add the recipe in edubank.
	 */
	public static String addRecipeToEdubankFromRecipeList(int index){
		List<AndroidElement> eduBankList;
		List<AndroidElement> recipeList;
		String recipeName = "";
		try{
			Reusables.waitForElement(edubankOnRecipeListImageView);
			eduBankList = Reusables.getElementsList(edubankOnRecipeListImageView);
			recipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			recipeName = recipeList.get(index).getAttribute("name").trim();
			eduBankList.get(index).click();
		}catch(NoSuchElementException e){
			Logs.error("Edubank buttton not found on recipe list page. "+e.getClass().getName());
		}
		//System.out.println("Recipe Name at..> "+index +"index "+recipeName);
		return recipeName;
	}
	
	/**
	 * This method is used to click on the edubank button on recipe detail page.
	 */
	public static void addRecipeToEdubankFromRecipeDetailPage(){
		try{
			Reusables.waitForElement(edubankOnRecipeDetailImageView);
			Reusables.clickCommand(edubankOnRecipeDetailImageView);
		}catch(NoSuchElementException e){
			Logs.error("Edubank buttton not found on recipe detail page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify added recipe name in edubank.
	 * @param recipeName
	 */
	public static void verifyAddedRecipeNameInEdubank(String recipeName){
		try{
			Reusables.waitForElement(Filter.filterBtn);
			List<AndroidElement> list = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			for (AndroidElement element : list){
				if (element.getAttribute("name").trim().equalsIgnoreCase(recipeName)){
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Added Term not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to remove target recipe from EduBank.
	 * @param targetRecipeName : String type for removing recipe from edubank.
	 */
	public static void removeSpecificRecipeFromEduBank(String targetRecipeName){
		List<AndroidElement> eduBankList;
		List<AndroidElement> recipeList;
		try{
			//Reusables.waitForElement(edubankOnRecipeListImageView);
			eduBankList = Reusables.getElementsList(edubankOnRecipeListImageView);
			recipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
			for (int i = 0; i < recipeList.size(); i++){
				if (recipeList.get(i).getAttribute("name").trim().equalsIgnoreCase(targetRecipeName)){
					eduBankList.get(i).click();
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Added Recipe Name found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to remove added recipe from EduBank.
	 */
	public static void removeAllRecipeFromEduBank(){
		List<AndroidElement> eduBankList;
//		String imageFilePath = "";
		try{
			//Reusables.waitForElement(edubankOnRecipeListImageView);
			eduBankList = Reusables.getElementsList(edubankOnRecipeListImageView);
			while (eduBankList.size() > 0){
				eduBankList.get(0).click();
				if (Reusables.getTextFromList(alertMessagePopupTxtView, 0).equalsIgnoreCase(DataConstants.eduBankDeleteMessage)){
					Reusables.clickCommand(acceptAlertMessagePopupBtn);
					/*imageFilePath = ScreenShot.takescreenShotCaptureForToast();
					Reusables.waitThread(2);
					Reusables.verifyToastMessageUsingImage(imageFilePath, DataConstants.toastMessageForDeleteRecipeFromEdubank);*/
					}
			}
			HomePage.verifyHomePageHeaderTxt();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Added Recipe Name found.. "+e.getClass().getName());
		}
	}
	
}
