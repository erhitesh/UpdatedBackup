package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;

public class EduBank {
	
	
	/* Object Identification */
	public static By edubankHeaderTxt = By.name("EduBank");
	public static By edubankBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/favorites");
	public static By addToFavorite = By.id(DeviceRelatedInformation.getPackageName()+":id/add_to_favorites");
	public static By edubankAlertMessage = By.id("android:id/message");
	public static By submitEdubankAlertPopup = By.id("android:id/button1");
	public static By addToEdubankPopupHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/addtofavoritetitle");
	public static By addBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/add");
	public static By createNewCategoryTxtbox  = By.id(DeviceRelatedInformation.getPackageName()+":id/favoritecat");
	public static By categoryCountInEdubankPopup = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By savedInEdubankPopupHeaderTxt = By.name("Saved in EduBank!");
	public static By submitSavedInEdubankPopup = By.id("android:id/button2");
	public static By addedCategoryInEdubank = By.id(DeviceRelatedInformation.getPackageName()+":id/_label");
	public static By addedCategoryInEdubankForTab = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By addCategorySubCategoryInEdubank = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By categoryNameOnAlert = By.id("android:id/alertTitle");
	public static By deleteRenameCategory = By.id("android:id/title");
	public static By renameCategoryPopupHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/title");
	public static By txtBoxOnRenameCategoryPopup = By.id(DeviceRelatedInformation.getPackageName()+":id/catname");
	public static By submitRenamePopup = By.id(DeviceRelatedInformation.getPackageName()+":id/submit");
	
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static void clickOnEduBank(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(edubankBtn));
			Reusables.clickUsingElement(Reusables.getElement(edubankBtn));
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank button not found... "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify edubank header txt not found..
	 */
	public static void verifyEduBankHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(edubankHeaderTxt), "Error Message!! EduBank header txt not found...");
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank Header txt not found."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on verify EduBank popup message.
	 */
	public static void verifyEduBankPopUpMessage(String expected_popup_message_txt){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(edubankAlertMessage), expected_popup_message_txt, "Error Message!! EduBank popup message not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(" EduBank popup message not matched... "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Ok button on edubank message popup.
	 */
	public static void submitEduBankAlertPopUp(){
		try{
			Reusables.waitForElement(submitEdubankAlertPopup);
			Reusables.clickUsingElement(Reusables.getElement(submitEdubankAlertPopup));
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank Ok button not found... "+e.getClass().getName());
		}
	}
	
	// Add To Favorite Related data 
	
	/**
	 * This method is used to click on the Favorite button.
	 */
	public static void clickOnAddToFavorite(){
		try{
			Reusables.waitForElement(addToFavorite);
			Reusables.clickUsingElement(Reusables.getElement(addToFavorite));
		}
		catch(NoSuchElementException e){
			Logs.error("Favorite button not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify add to edubank popup not displayed.
	 */
	public static void verifyAddToEduBankPopUpDisplayed(){
		try{
			Reusables.waitForElement(addToEdubankPopupHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(addToEdubankPopupHeaderTxt), "Error Message!! Add to Edubank popup not displayed...");
		}
		catch(NoSuchElementException e){
			Logs.error(" Add to Edubank popup not displayed "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Done button.
	 */
	public static void clickOnDoneButton(){
		try{
			Reusables.waitForElement(addBtn);
			Reusables.clickUsingElement(Reusables.getElement(addBtn));
		}
		catch(NoSuchElementException e){
			Logs.error(" Done button not found... "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to add entity name.
	 */
	public static String addTerm(String termName){
		String entityName = termName;
		try{
			Reusables.waitForElement(createNewCategoryTxtbox);
			Reusables.enterMessageInTextBox(createNewCategoryTxtbox, entityName);
		}
		catch(NoSuchElementException e){
			Logs.error("Popup box not found."+e.getClass().getName());
		}
		
		return entityName;
	}
	
	
	/**
	 * This method is used to verify saved in edubank popup box displayed or not.
	 */
	public static void verifySavedInEduBankHeaderTxt(){
		try{
			Reusables.waitForElement(savedInEdubankPopupHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getElement(savedInEdubankPopupHeaderTxt), "Error Message!! Saved in EduBank! Header txt not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(" Saved In edubank popup box not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to submit saved in edubank popup box.
	 */
	public static void submitSavedInEduBankPopUp(){
		try{
			Reusables.waitForElement(submitSavedInEdubankPopup);
			Reusables.clickCommand(submitSavedInEdubankPopup);
			}
		catch(NoSuchElementException e){
			Logs.error(" Saved In edubank popup box still visible. "+e.getClass().getName());
			}
		}
	
	// Edubank 
	/**
	 * This method is used to verify entity name and sub entity name in EduBank.
	 * @param mainEntityName : category name.
	 * @param subEntityName : category sub entity name.
	 */
	public static void verifyAddedCategoryAndSubCategoryNameInEduBank(String addedTermName, String subTermName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if(size.equals(new Dimension(800, 1172))){
				List<AndroidElement> entity_list = Reusables.getElementsList(addedCategoryInEdubankForTab);
				for (AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(addedTermName)){
						Reusables.verifyElementPresent(element, "Error Message!! Added Category Name not found..");
						Reusables.verifyEqualMessage(entity_list.get(1).getText(), subTermName, "Error Message!! Added Category Name not found..");
					}
					else if (element.getAttribute("name").equalsIgnoreCase(subTermName)) {
						Reusables.verifyElementPresent(element, "Error Message!! Added Category Name not found..");
						Reusables.verifyEqualMessage(element.getText(), subTermName, "Error Message!! Added Term Name not found..");
						}
					}
				}
			else{
				List<AndroidElement> entity_list = Reusables.getElementsList(addedCategoryInEdubank);
				for(AndroidElement element: entity_list){
					//System.out.println("Find added term in edubank.."+element.getText().trim());
					if (element.getText().trim().equalsIgnoreCase(addedTermName)){
						Reusables.verifyElementPresent(element, "Error Message!! Added Category Name not found...");
						element.click();
						Reusables.waitThread(2);
						Reusables.verifyEqualMessage(Reusables.getElement(addCategorySubCategoryInEdubank).getText().trim(), subTermName, "Error Message!! Sub Category name not found.");
						//element.click();
						break;
						}	
					}
				}
			}
		catch(NoSuchElementException e){
			Logs.error("Added Entity Name not matched with eduank entity name. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify entity name on alert pop up.
	 */
	public static void clickAndHold(String mainCategoryName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(800, 1172))){
				List<AndroidElement> entity_list = Reusables.getElementsList(addedCategoryInEdubankForTab);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(mainCategoryName)){
						Reusables.verifyElementPresent(element, "Error Message!! Entity Name found...");
						Reusables.clickAndHoldOperation(element);
						Reusables.verifyEqualMessage(Reusables.getText(categoryNameOnAlert), mainCategoryName, "Error Message!! Entity name notwww");
						break;
					}
				}
			}
			else {
				List<AndroidElement> entity_list = Reusables.getElementsList(addedCategoryInEdubank);
				for(AndroidElement element: entity_list){
					if (element.getText().trim().equalsIgnoreCase(mainCategoryName)){//element.getAttribute("name").equalsIgnoreCase(mainEntityName)
						Reusables.verifyElementPresent(element, "Error Message!! Category Name not found...");
						Reusables.clickAndHoldOperation(element);
						Reusables.verifyEqualMessage(Reusables.getText(categoryNameOnAlert), mainCategoryName, "Error Message!! Entity name notwww");
						break;
					}
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" Alert popup not displayed..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the click and verify corresponding page loaded or not.
	 */
	public static void clickOnRenameAndDeleteButton(String typeOfButton){
		try{
			List<AndroidElement> buttonCount = Reusables.getElementsList(deleteRenameCategory);
			for (AndroidElement element : buttonCount){
				if (element.getText().trim().equalsIgnoreCase(typeOfButton)){//getAttribute("name").equalsIgnoreCase(typeOfButton)
					element.click();
					break;
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(" Rename/Delete Button still visible.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to rename the entity name.
	 */
	public static void renameName(String textForRenameEntity){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(renameCategoryPopupHeaderTxt), DataConstants.eduabnkRenameDeleteAlertPopupHeaderTxt, "Error Message!! Rename header txt not matched..");
			Reusables.enterMessageInTextBox(txtBoxOnRenameCategoryPopup, textForRenameEntity);
			Reusables.clickCommand(submitRenamePopup);
		}
		catch(NoSuchElementException e){
			Logs.error(" Rename Entity Name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to verify rename entity name.
	 */
	public static void verifyRenameCategoryName(String renameEntityName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(800, 1172))){
				Reusables.verifyElementPresent(Reusables.getElement(edubankHeaderTxt), "Error Message!! EduBank header txt not found..");
				List<AndroidElement> categoryList = Reusables.getElementsList(addedCategoryInEdubankForTab);
				for(AndroidElement element: categoryList){
					if (element.getAttribute("name").equalsIgnoreCase(renameEntityName)){//element.getAttribute("name").equalsIgnoreCase(renameEntityName)
						break;
					}
				}
			}
			else{
				Reusables.verifyElementPresent(Reusables.getElement(edubankHeaderTxt), "Error Message!! EduBank header txt not found..");
				List<AndroidElement> categoryList = Reusables.getElementsList(addedCategoryInEdubank);
				for(AndroidElement element: categoryList){
					if (element.getText().trim().equalsIgnoreCase(renameEntityName)){//element.getAttribute("name").equalsIgnoreCase(renameEntityName)
						break;
					}
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Rename Category not found .."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify delete entity name.
	 */
	public static void verifyDeleteCategoryName(String deleteEntityName){
		try{
			/*if (Reusables.getText(edubank_header_txt).equalsIgnoreCase("edubank")){
				List<AndroidElement entity_list = Reusables.get_elements_list(added_entity_in_edubank);
				for(AndroidElement element: entity_list){
					if (!element.getAttribute("name").equalsIgnoreCase(deleteEntityName)){
						break;
					}
				}
			}*/
			if (Reusables.isElementPresent(edubankBtn) == true){
				Reusables.verifyElementPresent(Reusables.getElement(edubankBtn), "Error Message!! Edubank button not found.");
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Category Name still visible.....  "+e.getClass().getName());
		}
	}
	
	
	// Add Entity From given list 
	
	/**
	 * This method is used to return the element list.
	 * @param indexValue :Type int.
	 * @return : String value.
	 */
	public static String getTermListValuesBasedOnIndex(int indexValue){
		
		return Reusables.getTextFromList(categoryCountInEdubankPopup, indexValue);
	
	}
	
	/**
	 * This method is used to select random entity name from given entity.
	 */
	public static String selectRandomTermFromGivenList(){
		String entityValue = "";
		try{
			int randomNumber = Reusables.randomNumber(Reusables.getElementsList(categoryCountInEdubankPopup).size());
			List<AndroidElement> categoryList = Reusables.getElementsList(categoryCountInEdubankPopup);
			entityValue = categoryList.get(randomNumber).getAttribute("name").toString().trim();
			Reusables.clickUsingElement(categoryList.get(randomNumber));
		}
		catch(NoSuchElementException e){
			Logs.error("Category name still visible... "+e.getClass().getName());
		}
		
		return entityValue;
	}
	
	/**
	 * This method is used to delete entity.
	 */
	public static void deletePredefineGivenTerm(String mainCategoryName, String subCategoryName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(800, 1172))){
				List<AndroidElement> categoryList = Reusables.getElementsList(addedCategoryInEdubankForTab);
				for (AndroidElement element: categoryList){
					if(element.getAttribute("name").equalsIgnoreCase(subCategoryName)){
						Reusables.clickAndHoldOperation(Reusables.getElementsList(addedCategoryInEdubankForTab).get(1));
						Reusables.verifyElementPresent(Reusables.getElement(categoryNameOnAlert), "Error Message!! Entity name not matched on alert popup.");
						Reusables.clickUsingElement(Reusables.getElement(deleteRenameCategory));
						break;
					}
				}
			}
			else{
				List<AndroidElement> categoryList = Reusables.getElementsList(addedCategoryInEdubank);
				for(AndroidElement element: categoryList){
					if (element.getAttribute("name").equalsIgnoreCase(mainCategoryName)){
						Reusables.verifyElementPresent(element, "Error Message!!Category Name not found...");
						element.click();
						Reusables.waitThread(2);
						if (Reusables.getElement(addCategorySubCategoryInEdubank).getText().trim().equalsIgnoreCase(subCategoryName)){
							Reusables.clickAndHoldOperation(Reusables.getElement(addCategorySubCategoryInEdubank));
							Reusables.verifyElementPresent(Reusables.getElement(categoryNameOnAlert), "Error Message!! Entity name not matched on alert popup.");
							Reusables.clickUsingElement(Reusables.getElement(deleteRenameCategory));
							break;
						}
					}
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Unable to delete Predefine term. "+e.getClass().getName());
		}
	}
}
