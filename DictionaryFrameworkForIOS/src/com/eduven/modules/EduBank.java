package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class EduBank {
	

	/* Object Identification */
	public static By editEduBankBtn = By.id("Autoplay_button");
	public static By editEduBankHeaderTxt = By.id("Add_to_edubank_header");
	public static By editEdubankCategoryList = By.id("Category_name");
	public static By createCategoryInEdubank = By.id("Search_text");
	
	public static By gotoEdubankAlertBtn = By.xpath("//*[@name='Go To EduBank'][1]");
	public static By edubankHeaderTxt = By.id("EduBank_header");
	public static By deleteBtnForCategory = By.id("Delete");
	public static By termList = By.id("Term_name");
	public static By categoryCountInEdubank = By.id("Category_count");
	public static By deleteAddedTermBtn = By.id("Delete_term_button");
	public static By deleteTermAlertConfirmBtn = By.xpath("//UIAButton[@name='Yes']");
	public static By renameCategory = By.id("edit selected");
	public static By renameCategoryTxtBox = By.xpath("//UIATextField");

	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Remove All add terms from edubank  >>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to delete the term from edubank.
	 */
	public static void deleteTermFromEdubank(){
		/*List<IOSElement> deleteBtnList;
		try{
			deleteBtnList = Reusables.getIOSElementsList(deleteAddedTermBtn);
			for (int k = 0; k < deleteBtnList.size(); k++){
				System.out.println("Inside Delete "+deleteBtnList.size());
				deleteBtnList.get(0).click();
				Reusables.waitThread(1);
				if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.deleteTermConfirmationMessage)){
					Reusables.acceptAlert();//Reusables.clickCommand(deleteTermAlertConfirmBtn);
					if (DeviceRelatedInformation.deviceType().equalsIgnoreCase("iPad")){
						System.out.println("Ipad Devices,");
					}
					else {
						Reusables.oneStepBack();
					}
				}
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Term still visible. "+e.getClass().getName());
		}*/
		
		List<IOSElement> termlist;
		try{
			termlist = Reusables.getIOSElementsList(termList);
			System.out.println("Term List size.. "+termlist.size());
			for (int j = 0; j < termlist.size(); j++){
				Reusables.clickCommand(deleteAddedTermBtn);
				Reusables.waitThread(1);
				if (Reusables.getAlertMessage().equalsIgnoreCase(DataConstants.deleteTermConfirmationMessage)){
					Reusables.acceptAlert();//Reusables.clickCommand(deleteTermAlertConfirmBtn);
					if (DeviceRelatedInformation.deviceType().equalsIgnoreCase("iPad")){
						//System.out.println("Ipad Devices,");
					}
					else {
						System.out.println("Else part");
						Reusables.oneStepBack();
					}
				}
				Reusables.waitThread(1);	
			}
		}catch(NoSuchElementException e){
			Logs.error("Term still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to delete all term added into the edubank.
	 */
	public static void removeAllTermFromEdubank(){
		List<IOSElement> termlist;
		List<IOSElement> categoryList;
		try{
			categoryList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (int i = 0; i < categoryList.size(); i++){
				System.out.println("value of I. "+i+" Category Value.."+categoryList.get(i).getText()+"..Size.."+categoryList.size());
				Reusables.waitThread(3);
				categoryList.get(i).click();
				Reusables.waitThread(2);
				/*termlist = Reusables.getIOSElementsList(termList);
				System.out.println("Term List size.. "+termlist.size());
				for (int j = 0; j < termlist.size(); j++){
					deleteTermFromEdubank();
				}*/
				deleteTermFromEdubank();
			}
		}catch(NoSuchElementException e){
			Logs.error("Term still found. "+e.getClass().getName());
		}
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Edit EduBank Page..>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to click on the edit eduBank button.
	 */
	public static void clickOnEditEdubankButton(){
		try{
			Reusables.waitForIOSElement(editEduBankBtn);
			Reusables.clickCommand(editEduBankBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Edit EduBank Button still visible.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the edit EduBank page.
	 */
	public static void navigateToEditEdubankPage(){
		try{
			clickOnEditEdubankButton();
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the Edit Edubank Button. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify edit eduBank page loaded or not.
	 */
	public static void verifyEditEdubankPageLoaded(){
		try{
			Reusables.waitForIOSElement(editEduBankHeaderTxt);
			Reusables.clickCommand(editEduBankHeaderTxt);
		}
		catch(NoSuchElementException e){
			Logs.error("Edit EduBank page is not loaded.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the go to eduBank button on alert.
	 */
	public static void gotoEduBankByAlert(){
		try{
			Reusables.waitForIOSElement(gotoEdubankAlertBtn);
			Reusables.clickCommand(gotoEdubankAlertBtn);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>.. Go To EduBank Button Not found.. "+e.getClass().getName());
		}
	}
	
	
	
	/**
	 * This Method is used to find out add entity in eduBank category.
	 */
	public static String addTermToEduBankCategory(){
		String eduBankCategoryName = "";
		IOSElement eduBankCategoryNameElement = null;
		try{
			int randomEduBankCategoryNumber = Reusables.randomNumber(Reusables.getIOSElementsList(editEdubankCategoryList).size());
			eduBankCategoryNameElement = Reusables.getIOSElementsList(editEdubankCategoryList).get(randomEduBankCategoryNumber);
			eduBankCategoryName = eduBankCategoryNameElement.getText();
			//System.out.println(eduBankCategoryName);
			Reusables.clickUsingIOSElement(eduBankCategoryNameElement);
			Reusables.acceptAlert();
            if (Reusables.isElementPresent(gotoEdubankAlertBtn)){
            	Reusables.waitThread(2);
    			EduBank.gotoEduBankByAlert();
            }else{
            	navigateToEduBank();
            }
		}
		catch(NoSuchElementException e){
			Logs.error("Term not added in edubank.. "+e.getClass().getName());
		}
		
		return eduBankCategoryName;
	}

	
	/**
	 * This method is used to send text in alert text box.
	 */
	public static void sendTextInAlertTxtBox(String txtString){
		try{
			Reusables.alertInstance();
			IOSElement alertTxtBox = Reusables.getIOSElement(renameCategoryTxtBox);
			alertTxtBox.click();
			alertTxtBox.clear();
			alertTxtBox.sendKeys(txtString);
		}
		catch(NoSuchElementException e){
			Logs.error("Alert text box not found.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to navigate to the edubank page from footer edubank button.
	 */
	public static void navigateToEduBank(){
		try{
			Reusables.clickCommand(Footer.eduBankBtn);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the footer edubank button. "+e.getClass().getName());
		}
	}
	

	
	/**
	 * This Method is used to add category from given list.
	 */
	public static String addDuplicateTermFromGivenCategoryList(String categoryName){
		String duplicateCatgoryName = "";
		List<IOSElement> catList;
		try{
			catList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (IOSElement ele : catList){
				if (ele.getText().trim().equalsIgnoreCase(categoryName)){
					ele.click();
					duplicateCatgoryName = ele.getText();
					Reusables.verifyTextContains(Reusables.alertInstance().getText(), DataConstants.categoryAlreadyExists);
					Reusables.waitThread(2);
					Reusables.acceptAlert();
					break;
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error("term not added in edubank.. "+e.getClass().getName());
		}
		
		return duplicateCatgoryName;
	}

	
    /**
     * This method is used to verify eduBank page loaded or not.
     */
	public static void verifyEduBankPageLoaded(){
		try{
			Reusables.waitForIOSElement(edubankHeaderTxt);
			Reusables.verifyElementPresent(Reusables.getIOSElement(edubankHeaderTxt), "Error Message!! EduBank Page is not loaded..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> EduBank Page not loaded. "+e.getClass().getName());
		}
	}
	
	
    /**
     * This method is used to verify entity added in eduBank.
     */
	public static void verifyAddedTermInEduBank(String eduBankCategoryName){
		List<IOSElement> catList;
		List<IOSElement> termlist;
		try{
			catList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (IOSElement ele : catList){
				if (ele.getText().trim().equalsIgnoreCase(eduBankCategoryName)){
					ele.click();
					Reusables.waitThread(1);
					termlist = Reusables.getIOSElementsList(termList);
					if (termlist.size() > 0){
						Reusables.verifyElementPresent(termlist.get(0), "Error Message!Term not added inside the category.");
						break;
					}
				}
			}
			//Reusables.verifyElementPresent(Reusables.getIOSElement(By.name(eduBankCategoryName)), "Error Message!! Added Category Name not found in EduBank.");
		}
		catch(NoSuchElementException e){
			Logs.error("Added Category Name not found in EduBank. "+e.getClass().getName());
		}
	}
	
	
	/**
     * This method is used to Delete Duplicate Added Term from eduBank.
     */
	public static void deleteDuplicateAddedTermFromEduBank(String duplicateCategoryName){
		try{
			Reusables.clickCommand(By.name(duplicateCategoryName));
			deleteTermFromEdubank();
			Reusables.waitThread(2);
			Reusables.acceptAlert();
		}
		catch(NoSuchElementException e){
			Logs.error("Duplicate "+duplicateCategoryName+" term still exists in the EduBank Page. "+e.getClass().getName());
		}
	}
	
	
	/**
     * This method is used to Delete Added Entity from eduBank.
     */
	public static void deleteAddedTermFromEduBank(String eduBankCategoryName){
		List<IOSElement> catList;
		try{
			catList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (IOSElement ele : catList){
				if (ele.getText().trim().equalsIgnoreCase(eduBankCategoryName)){
					ele.click();
					Reusables.waitThread(1);
				}
			}
			//Reusables.clickCommand(By.name(eduBankCategoryName));
			deleteTermFromEdubank();
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank Page not loaded"+e.getClass().getName());
		}
	}
	
	
	public static void deleteAddedTermForGivenCategoryList(String eduBankCategoryName, String duplicateCategoryName){
		try{
			if (duplicateCategoryName.equalsIgnoreCase(eduBankCategoryName)){
			}
			else{
				deleteAddedTermFromEduBank(duplicateCategoryName);
				//deleteDuplicateAddedTermFromEduBank(duplicateCategoryName);
			}
			deleteAddedTermFromEduBank(eduBankCategoryName);
		}catch(NoSuchElementException e){
			Logs.error("Unable to delete added entity.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This Method is used to create entity in eduBank category.
	 */
	public static String createCategoryInEduBank(String createCatName){
		String createdCategoryName = createCatName;
		List<IOSElement> catList;
		try{
			Reusables.waitThread(2);
			Reusables.enterMessageInTextBox(createCategoryInEdubank, createdCategoryName, "done");
			catList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (int i = 0; i < catList.size(); i++){
				if (catList.get(i).getText().equalsIgnoreCase(createdCategoryName)){
					catList.get(i).click();
					Reusables.waitThread(1);
					Reusables.acceptAlert();
					Reusables.waitThread(2);
					break;
				}
			}
			if (Reusables.isElementPresent(gotoEdubankAlertBtn)){
            	Reusables.waitThread(2);
    			EduBank.gotoEduBankByAlert();
            }else{
            	navigateToEduBank();
            }
			
		}
		catch(NoSuchElementException e){
			Logs.error("Term not added in edubank.. "+e.getClass().getName());
		}
		
		return createdCategoryName;
	}

	
    /**
     * This method is used to verify create category added in eduBank.
     */
	public static void verifyCreatedCategoryAddedInEduBank(String createdCategoryName){
		List<IOSElement> catList;
		try{
			catList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (int i = 0; i < catList.size(); i++){
				if (catList.get(i).getText().trim().equalsIgnoreCase(createdCategoryName)){
					Assert.assertFalse(!catList.get(i).getText().trim().equalsIgnoreCase(createdCategoryName), "Error Message!Created category not found.");
					break;
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Added Category Name not found in EduBank. "+e.getClass().getName());
		}
	}
	
	
    /**
     * This method is used to rename added category in eduBank.
     */
	public static String renameCategoryInEduBank(){
		String renameString = Reusables.randomTextGenerator(10);//DataConstants.renameTermNameForEdubank;
		try{
			Reusables.clickCommand(renameCategory);
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.alertInstance().getText(), DataConstants.renameAlertMessage, "Error Message!!Alert Message not found..");
			Reusables.acceptAlert();
			Reusables.verifyEqualMessage(Reusables.alertInstance().getText(), DataConstants.errorRenameCategoryMsg, "Error Message!! Error popup is not coming.");
			Reusables.waitThread(2);
			Reusables.acceptAlert();
			Reusables.clickCommand(renameCategory);
			Reusables.waitThread(2);
			//Reusables.alertInstance();
			EduBank.sendTextInAlertTxtBox(renameString);
			Reusables.acceptAlert();
		}
		catch(NoSuchElementException e){
			Logs.error("Added Category Name not found in EduBank. "+e.getClass().getName());
		}
		
		return renameString;
	}
	
	/**
	 * This method is used to verify rename category in eduBank.
	 */
	public static void verifyRenameCategoryName(String renameCategoryName){
		List<IOSElement> renameCatList;
		try{
			renameCatList = Reusables.getIOSElementsList(editEdubankCategoryList);
			for (IOSElement ele : renameCatList){
				if (ele.getText().trim().equalsIgnoreCase(renameCategoryName)){
					Assert.assertFalse(!ele.getText().trim().equalsIgnoreCase(renameCategoryName), "Error Message!Rename category not found in edubank category.");
					break;
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Rename Category not found in EduBank. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to handle the alert pop up.
	 */
	public static void handlingAlertPopup(){
		try{
			if (DeviceRelatedInformation.deviceType().equalsIgnoreCase("iPad")){
				Reusables.waitForIOSElement(deleteBtnForCategory);
			}
			else{
				if (Reusables.alertInstance() != null){
					Reusables.dismissAlert();
					Reusables.waitThread(2);
				}
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Alert handle not visible.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to delete created category from eduBank.
	 */
	public static void deleteCreatedCategoryFromEduBank(String deleteCategory){
		try{
			By xpathValue = By.xpath("//*[@value='"+deleteCategory+"']");
			Reusables.dragAndDrop(renameCategory, xpathValue);
			handlingAlertPopup();
			Reusables.clickCommand(deleteBtnForCategory);
			Reusables.waitThread(2);
			Reusables.acceptAlert();
		}catch(NoSuchElementException e){
			Logs.error("Created Category Still Exists.. "+e.getClass().getName());
		}
	}
}