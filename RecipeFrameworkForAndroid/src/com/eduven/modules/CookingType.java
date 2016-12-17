package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;

public class CookingType {
	
	
	/* Object Identification */
	public static By cooking_type_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/action");
	public static By cooking_type_header = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");//By.name("Cooking Type");
	public static By cooking_type_list_count = By.id(DeviceRelatedInformation.getPackageName()+":id/course_name");
	public static By cooking_type_recipe_list = By.id(DeviceRelatedInformation.getPackageName()+":id/recipe_name");
	
	/**
	 * This method is used to return the instance of Cooking Type button.
	 * @return " type AndroidElement
	 */
	public static AndroidElement cookingTypeInstance(){
		
		return Reusables.getElement(cooking_type_btn);
	}
	
	/**
	 * This method is used to click on the Cooking Type button.
	 */
	public static void clickOnCookingTypeButton(){
		try{
			while (Reusables.isElementPresent(cooking_type_btn) == false){
				Reusables.swipeUp();
			}
			Reusables.waitForAndroidElement(Reusables.getElement(cooking_type_btn));
			cookingTypeInstance().click();
			SplashScreen.allowMediaFilesAndContacts();
			SplashScreen.remindLaterRecipeImage();
		}catch(NoSuchElementException r){
			Logs.error(">>>>>>>>>>> Cooking Type Page not loaded.. "+r.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Cooking Type Page Load or not.
	 */
	public static void verifyCookingTypePageLoaded(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.getText(cooking_type_header), DataConstants.cooking_type_header_value, "Error Message!! Cooking Type Page not loaded.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Cooking Type Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Cooking Type List.
	 */
	public static void verifyCookigTypeList(){
		String previousTermName = "";
		String nextTermName = "";
		int i;
		try{
			int cookingTypeCount = Reusables.getElementsList(cooking_type_list_count).size();
			for (i = 0; i <= cookingTypeCount; i++){
				previousTermName = Reusables.getTextFromList(cooking_type_list_count, 0);
				//System.out.println("Previous Term Name"+previousTermName);
				if (i % cookingTypeCount == 0 && i / cookingTypeCount >= 1){
					System.out.println("Inside Loop"+i);
					Reusables.waitThread(2);
					Reusables.swipeUp();
					i = 0;
					nextTermName = Reusables.getTextFromList(cooking_type_list_count, 0);
					//System.out.println("Next Term Name"+nextTermName);
					if (previousTermName.equalsIgnoreCase(nextTermName))
						break;
				}
				AndroidElement cookingTypeName = Reusables.getElementsList(cooking_type_list_count).get(i);
				Reusables.waitForAndroidElement(cookingTypeName);
				Reusables.verifyElementEnable(cookingTypeName, "Error Message!!"+cookingTypeName.getText()+" Not found..");
				Logs.info(">>>>>>>>>>>>Cooking Type Name..> "+cookingTypeName.getText()+"<<<<...Found.");
			}
			
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Cooking Type List Name not Found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the random Cooking Type name
	 * @return : Course Name, Type String
	 */
	public static String clickOnRandomCookingTypeTerm(){
		String cookingTypeName = "";
		try{
			cookingTypeName = Reusables.getElementsList(cooking_type_list_count).get(Reusables.randomNumber(Reusables.getElementsList(cooking_type_list_count).size())).getText();
			System.out.println("Cooking type Name..>"+cookingTypeName+"..ad");
			Reusables.waitForAndroidElement(Reusables.getElement(By.name(cookingTypeName)));
			//Reusables.click_using_scroll_to_exact_txt(cookingTypeName);
			if (Reusables.isElementPresent(SplashScreen.alcoholicBeverageBtn) == true){
				SplashScreen.acceptAlcoholicBeverage();
			}
		}catch(NoSuchElementException e){
			Logs.error(">>>>>> Random Course Name not clickable "+e.getClass().getName());
		}
		
		return cookingTypeName;
	}

	/**
	 * This method is used to verify cooking type terms header found or not.
	 */
	public static void verifyCookingTypeTermPageLoaded(String expectedCookingTypeTerm){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(cooking_type_header), expectedCookingTypeTerm, "Error Message!! Select Cooking Type and expected Cooking type not macthed..");
			//Reusables.verify_element_present(Reusables.get_element(By.name(expectedCookingTypeTerm)), "Error Message!! Cooking Type Terms Not Found.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Select Cooking Type and expected Cooking type not macthed... "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to click on the random recipe name in cooking type page.
	 * @return
	 */
	public static String clickRandomCookingTypeRecipeName(){
		String cookingTypeRecipeName = "";
		try{
			List<AndroidElement> recipeList = Reusables.getElementsList(cooking_type_recipe_list);
			int random_number = Reusables.randomNumber(recipeList.size());
			System.out.println("Random Number..>"+random_number);
			cookingTypeRecipeName = recipeList.get(random_number).getText();
			System.out.println("Cooking Type Recipe Name.."+cookingTypeRecipeName+"..");
			Reusables.clickUsingElement(recipeList.get(random_number));
			/* Wait for moment for allow media content  */
			SplashScreen.allowMediaFilesAndContacts();
			/* Select Unit System Measure Ingredients */
			SplashScreen.selectUnitSystemMeasureIngredients();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Cooking Type Recipe Name Not found.. "+e.getClass().getName());
		}
		
		return cookingTypeRecipeName;
	}
	
	/**
	 * This method is used to verify selected recipe name found.
	 * @param expectedRecipeName: For Matching right navigation, Type String.
	 */
	public static void verifySelectRecipeName(String expectedRecipeName){
		try{
			//Reusables.verify_txt_message(Reusables.getText(by), expectedRecipeName, "Error Messsage!! Selected Recipe Name not found on recipe detail page.");
			Reusables.verifyElementEnable(Reusables.getElement(By.name(expectedRecipeName)), "Error Message!!"+expectedRecipeName+"..>Not Found.");
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Selected Recipe Name not found.. "+e.getClass().getName());
		}
	}
}
