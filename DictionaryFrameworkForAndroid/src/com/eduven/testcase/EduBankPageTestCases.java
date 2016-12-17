package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EduBank;
import com.eduven.modules.HomePage;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EduBankPageTestCases {
	
	
	/* Global Variable Declaration */
	int indexValue = 0;
	String randomCategoryName = "";
	String termName = "";
	String addedEntityName = "";
	String typeOfOperationForRename = "rename";
	String typeOfOperationForDelete = "delete";
	String textForRenameEntity = DataConstants.renameTermNameForEdubank;
	String string_with_special_character = "";
	
	
	@Test(priority=0)
	public void eduBank_page_navigate_to_entitydetail_page_test(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		randomCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(randomCategoryName);
		termName = WordSearchList.navigateToTermDetailPage();
		WordSearchList.verifyTermDetailPageLoaded();
	}
 
	@Test(priority=10)
	public void eduBank_page_verify_emptyEntity_in_eduBank_test(){
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduBankEmptyPopUpMsg);
		EduBank.submitEduBankPopUp();
	}
	
	@Test(priority=20)
	public void eduabnk_page_create_blank_entity_in_edubank_test(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForBlankTerm);
		EduBank.submitEduBankPopUp();
	}
	
	@Test(priority=30)
	public void eduabnk_page_create_and_verify_entity_in_edubank_test(){
		addedEntityName = EduBank.addTerm(DataConstants.termNameForEdubank);
		EduBank.clickOnDoneButton();
		EduBank.verifySavedInEduBankHeaderTxt();
		EduBank.submitSavedInEduBankPopUp();
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyAddedEntityAndSubEntityNameInEduBank(addedEntityName, termName);
		Reusables.stepBack();
	}
	
	@Test(priority=32)
	public void edubank_page_verify_create_duplicate_entity_in_edubank_test(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		addedEntityName = EduBank.addTerm(DataConstants.termNameForEdubank);
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForDuplicateTerm);
		EduBank.submitEduBankPopUp();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		Reusables.stepBack();
	}

	@Test(priority=50)
	public void edubank_page_rename_entityName_test(){
		EduBank.clickOnEduBank();
		EduBank.clickAndHold(addedEntityName);
		EduBank.clickOnRenameAndDeleteButton(typeOfOperationForRename);
		EduBank.renameName(addedEntityName);
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForRenameTerm);
		EduBank.submitEduBankPopUp();
		EduBank.renameName(textForRenameEntity);
	}
	
	@Test(priority=60)
	public void edubank_page_verify_rename_entity_name_test(){
		EduBank.verifyRenameEntityName(textForRenameEntity);
	}
	
	@Test(priority=70)
	public void edubank_page_delete_and_verify_entity_name_test(){
		EduBank.clickAndHold(textForRenameEntity);
		EduBank.clickOnRenameAndDeleteButton(typeOfOperationForDelete);
		EduBank.verifyDeleteEntityName(textForRenameEntity);
	}
	
	@Test(priority=80)
	public void edubank_page_create_duplicate_given_entity_test(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForBlankTerm);
		EduBank.submitEduBankPopUp();
		String entityNameFromList = EduBank.getTermList(indexValue);
		EduBank.addTerm(entityNameFromList);
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForDuplicateTerm);
		EduBank.submitEduBankPopUp();
	}
	
	@Test(priority=90)
	public void edubank_page_add_entity_from_given_list_test(){
		addedEntityName = EduBank.selectRandomTermFromGivenList();
		EduBank.verifySavedInEduBankHeaderTxt();
		EduBank.submitSavedInEduBankPopUp();
	}
	
	@Test(priority=100)
	public void edubank_page_verify_added_entity_test(){
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyAddedEntityAndSubEntityNameInEduBank(addedEntityName, termName);
	}
	
	@Test(priority=110)
	public void edubank_page_delete_and_verify_entity_from_edubank_test(){
		EduBank.deletePredefineGivenTerm(addedEntityName, termName);
	}
	
	
	@Test(priority=115)
	public void eduabnk_page_create_and_verify_entity_in_edubank_for_special_character_test(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		string_with_special_character = Reusables.randomSpecialTextGenerator(6);
		System.out.println("string_with_special_character..."+string_with_special_character);
		addedEntityName = EduBank.addTerm(string_with_special_character);
		EduBank.clickOnDoneButton();
		EduBank.verifySavedInEduBankHeaderTxt();
		EduBank.submitSavedInEduBankPopUp();
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyAddedEntityAndSubEntityNameInEduBank(addedEntityName, termName);
		Reusables.stepBack();
	}
	
	@Test(priority=117)
	public void edubank_page_rename_termName_for_special_character_test(){
		EduBank.clickOnEduBank();
		EduBank.clickAndHold(addedEntityName);
		EduBank.clickOnRenameAndDeleteButton(typeOfOperationForRename);
		EduBank.renameName(addedEntityName);
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForRenameTerm);
		EduBank.submitEduBankPopUp();
		EduBank.renameName(textForRenameEntity);
	}
	
	@Test(priority=118)
	public void edubank_page_verify_rename_term_name_for_special_character_test(){
		EduBank.verifyRenameEntityName(textForRenameEntity);
	}
	
	
	@Test(priority=120)
	public void verify_ads_banner_test(){
		HomePage.verifyAds();
	}
	
	 @AfterMethod 
	 public void tearDown(ITestResult result){
	 if (ITestResult.FAILURE == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SKIP == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
	 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
		 ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
	 }
   } 
	 
	 @AfterClass
	 public void close_app(){
		 Reusables.terminatesAppInstance();
	 }
}
