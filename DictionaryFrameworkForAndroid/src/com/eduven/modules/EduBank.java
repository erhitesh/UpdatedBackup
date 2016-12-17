package com.eduven.modules;

import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

public class EduBank {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By edubank_header_txt = By.name("EduBank");
	public static By edubank_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/favorites");
	public static By add_to_favorite = By.id(DeviceRelatedInformation.getPackageName()+":id/add_to_favorites");
	public static By edubank_popup_message = By.id("android:id/message");
	public static By submit_edubank_popup = By.id("android:id/button1");
	
	
	public static By add_to_edubank_popup_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/addtofavoritetitle");
	public static By add_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/add");
	public static By create_new_category_txtbox  = By.id(DeviceRelatedInformation.getPackageName()+":id/favoritecat");
	public static By entity_count_in_edubank_popup = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By saved_in_edubank_popup_header_txt = By.name("Saved in EduBank!");
	public static By submit_saved_in_edubank_popup = By.id("android:id/button2");
	public static By added_entity_in_edubank = By.id(DeviceRelatedInformation.getPackageName()+":id/_label");
	public static By added_entity_in_edubank_for_tab = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By add_entity_sub_entity_in_edubank = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By entity_name_on_alert = By.id("android:id/alertTitle");
	public static By delete_rename_entity = By.id("android:id/title");
	public static By rename_entity_popup_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/title");
	public static By txt_box_on_rename_entity_popup = By.id(DeviceRelatedInformation.getPackageName()+":id/catname");
	public static By submit_rename_popup = By.id(DeviceRelatedInformation.getPackageName()+":id/submit");
	
	
	/**
	 * This method is used to click on the EduBank button.
	 */
	public static void clickOnEduBank(){
		try{
			Reusables.waitForAndroidElement(Reusables.getElement(edubank_btn));
			Reusables.clickUsingElement(Reusables.getElement(edubank_btn));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> EduBank button not found... "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify edubank header txt not found..
	 */
	public static void verifyEduBankHeaderTxt(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(edubank_header_txt), "Error Message!! EduBank header txt not found...");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> EduBank Header txt not found."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on verify EduBank popup message.
	 */
	public static void verifyEduBankPopUpMessage(String expected_popup_message_txt){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(edubank_popup_message), expected_popup_message_txt, "Error Message!! EduBank popup message not matched.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> EduBank popup message not matched... "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Ok button on edubank message popup.
	 */
	public static void submitEduBankPopUp(){
		try{
			Reusables.waitForElement(submit_edubank_popup);
			Reusables.clickUsingElement(Reusables.getElement(submit_edubank_popup));
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank Ok button not found... "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Add To Favorite Related data >>>>>>>>>>>>>>>>>>>>>>>
	
	/**
	 * This method is used to click on the Favorite button.
	 */
	public static void clickOnAddToFavorite(){
		try{
			Reusables.waitForElement(add_to_favorite);
			Reusables.clickUsingElement(Reusables.getElement(add_to_favorite));
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
			Reusables.waitForElement(add_to_edubank_popup_header_txt);
			Reusables.verifyElementPresent(Reusables.getElement(add_to_edubank_popup_header_txt), "Error Message!! Add to Edubank popup not displayed...");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>> Add to Edubank popup not displayed "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Done button.
	 */
	public static void clickOnDoneButton(){
		try{
			Reusables.waitForElement(add_btn);
			Reusables.clickUsingElement(Reusables.getElement(add_btn));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> Done button not found... "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to add entity name.
	 */
	public static String addTerm(String termName){
		String entityName = termName;
		try{
			Reusables.waitForElement(create_new_category_txtbox);
			Reusables.enterMessageInTextBox(create_new_category_txtbox, entityName);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Popup box not found."+e.getClass().getName());
		}
		
		return entityName;
	}
	
	
	/**
	 * This method is used to verify saved in edubank popup box displayed or not.
	 */
	public static void verifySavedInEduBankHeaderTxt(){
		try{
			Reusables.waitForElement(saved_in_edubank_popup_header_txt);
			Reusables.verifyElementPresent(Reusables.getElement(saved_in_edubank_popup_header_txt), "Error Message!! Saved in EduBank! Header txt not found.");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Saved In edubank popup box not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to submit saved in edubank popup box.
	 */
	public static void submitSavedInEduBankPopUp(){
		try{
			Reusables.waitForElement(submit_saved_in_edubank_popup);
			Reusables.clickUsingElement(Reusables.getElement(submit_saved_in_edubank_popup));
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Saved In edubank popup box still visible. "+e.getClass().getName());
			}
		}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Edubank >>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to verify entity name and sub entity name in EduBank.
	 * @param mainEntityName : category name.
	 * @param subEntityName : category sub entity name.
	 */
	public static void verifyAddedEntityAndSubEntityNameInEduBank(String addedTermName, String subTermName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if(size.equals(new Dimension(800, 1172))){
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank_for_tab);
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
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(addedTermName)){
						Reusables.verifyElementPresent(element, "Error Message!! Entity Name not found...");
						element.click();
						Reusables.waitThread(2);
						Reusables.verifyEqualMessage(Reusables.getText(add_entity_sub_entity_in_edubank), subTermName, "Error Message!! Sub entity name not found.");
						element.click();
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
	public static void clickAndHold(String mainEntityName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(800, 1172))){
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank_for_tab);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(mainEntityName)){
						Reusables.verifyElementPresent(element, "Error Message!! Entity Name found...");
						Reusables.clickAndHoldOperation(element);
						Reusables.verifyEqualMessage(Reusables.getText(entity_name_on_alert), mainEntityName, "Error Message!! Entity name notwww");
						break;
					}
				}
			}
			else {
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(mainEntityName)){
						Reusables.verifyElementPresent(element, "Error Message!! Entity Name found...");
						Reusables.clickAndHoldOperation(element);
						Reusables.verifyEqualMessage(Reusables.getText(entity_name_on_alert), mainEntityName, "Error Message!! Entity name notwww");
						break;
					}
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>> Alert popup not displayed..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the click and verify corresponding page loaded or not.
	 */
	public static void clickOnRenameAndDeleteButton(String typeOfButton){
		try{
			List<AndroidElement> buttonCount = Reusables.getElementsList(delete_rename_entity);
			for (AndroidElement element : buttonCount){
				if (element.getAttribute("name").equalsIgnoreCase(typeOfButton)){
					element.click();
					break;
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>> Rename/Delete Button still visible.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to rename the entity name.
	 */
	public static void renameName(String textForRenameEntity){
		try{
			Reusables.verifyEqualMessage(Reusables.getText(rename_entity_popup_header_txt), DataConstants.eduabnkRenameDeleteAlertPopupHeaderTxt, "Error Message!! Rename header txt not matched..");
			Reusables.enterMessageInTextBox(txt_box_on_rename_entity_popup, textForRenameEntity);
			Reusables.clickUsingElement(Reusables.getElement(submit_rename_popup));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>> Rename Entity Name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to verify rename entity name.
	 */
	public static void verifyRenameEntityName(String renameEntityName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(800, 1172))){
				Reusables.verifyElementPresent(Reusables.getElement(edubank_header_txt), "Error Message!! EduBank header txt not found..");
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank_for_tab);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(renameEntityName)){
						break;
					}
				}
			}
			else{
				Reusables.verifyElementPresent(Reusables.getElement(edubank_header_txt), "Error Message!! EduBank header txt not found..");
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(renameEntityName)){
						break;
					}
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>> Rename Entity not found .."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify delete entity name.
	 */
	public static void verifyDeleteEntityName(String deleteEntityName){
		try{
			/*if (Reusables.getText(edubank_header_txt).equalsIgnoreCase("edubank")){
				List<AndroidElement> entity_list = Reusables.get_elements_list(added_entity_in_edubank);
				for(AndroidElement element: entity_list){
					if (!element.getAttribute("name").equalsIgnoreCase(deleteEntityName)){
						break;
					}
				}
			}*/
			if (Reusables.isElementPresent(edubank_btn) == true){
				Reusables.verifyElementPresent(Reusables.getElement(edubank_btn), "Error Message!! Edubank button not found.");
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>> Entity Name still visible.....  "+e.getClass().getName());
		}
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Add Entity From given list >>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	/**
	 * This method is used to return the element list.
	 * @param indexValue :Type int.
	 * @return : String value.
	 */
	public static String getTermList(int indexValue){
		
		return Reusables.getTextFromList(entity_count_in_edubank_popup, indexValue);
	
	}
	
	/**
	 * This method is used to select random entity name from given entity.
	 */
	public static String selectRandomTermFromGivenList(){
		String entityValue = "";
		try{
			int randomNumber = Reusables.randomNumber(Reusables.getElementsList(entity_count_in_edubank_popup).size());
			List<AndroidElement> entityList = Reusables.getElementsList(entity_count_in_edubank_popup);
			entityValue = entityList.get(randomNumber).getAttribute("name").toString().trim();
			//System.out.println("AddedEntityValue"+entityValue);
			Reusables.clickUsingElement(entityList.get(randomNumber));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>>>> Entity name still visible...>>>>"+e.getClass().getName());
		}
		
		return entityValue;
	}
	
	/**
	 * This method is used to delete entity.
	 */
	public static void deletePredefineGivenTerm(String mainEntityName, String subEntityName){
		Dimension size = Reusables.getAppScreenSize();
		try{
			if (size.equals(new Dimension(800, 1172))){
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank_for_tab);
				for (AndroidElement element: entity_list){
					if(element.getAttribute("name").equalsIgnoreCase(subEntityName)){
						Reusables.clickAndHoldOperation(Reusables.getElementsList(added_entity_in_edubank_for_tab).get(1));
						Reusables.verifyElementPresent(Reusables.getElement(entity_name_on_alert), "Error Message!! Entity name not matched on alert popup.");
						Reusables.clickUsingElement(Reusables.getElement(delete_rename_entity));
						break;
					}
				}
			}
			else{
				List<AndroidElement> entity_list = Reusables.getElementsList(added_entity_in_edubank);
				for(AndroidElement element: entity_list){
					if (element.getAttribute("name").equalsIgnoreCase(mainEntityName)){
						Reusables.verifyElementPresent(element, "Error Message!! Entity Name not found...");
						element.click();
						if (Reusables.getText(add_entity_sub_entity_in_edubank).equalsIgnoreCase(subEntityName)){
							Reusables.clickAndHoldOperation(Reusables.getElement(add_entity_sub_entity_in_edubank));
							Reusables.verifyElementPresent(Reusables.getElement(entity_name_on_alert), "Error Message!! Entity name not matched on alert popup.");
							Reusables.clickUsingElement(Reusables.getElement(delete_rename_entity));
							break;
						}
					}
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>>Unable to delete Predefine term. "+e.getClass().getName());
		}
	}
/*	
	
	*//**
	 * This method is used to verify EduBank Header text.
	 *//*
	public static void verifyEduBankHeaderTxt1(){
		try{
			if (Reusables.isElementPresent(edubank_header_txt) == true){
				Reusables.verifyElementPresent(Reusables.getElement(edubank_header_txt), "Error Message!! EduBank Header text not found.");
			}
			else if (Reusables.isElementPresent(edubank_header_txt) == false){
				Reusables.waitThread(1);
				Reusables.verifyEqualMessage(Reusables.getText(edubank_popup_message), DataConstants.eduBank_empty_popup_msg, "Error Message!! EduBank popup message not matched.");
				Reusables.waitForElement(submit_edubank_popup);
				Reusables.clickCommand(submit_edubank_popup);
			}
		}catch(NoSuchElementException e){
			Logs.error("Neither Alert nor EduBank header text are found. "+e.getClass().getName());
		}
	}
	*/
}
