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
	String addedCategoryName = "";
	String typeOfOperationForRename = "rename";
	String typeOfOperationForDelete = "delete";
	String textForRenameCategory = DataConstants.renameTermNameForEdubank;
	String stringWithSpecialCharacter = "";
	
	
	@Test(priority=0)
	public void navigateToTermDetailPageTest(){
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		randomCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(randomCategoryName);
		termName = WordSearchList.navigateToTermDetailPage(randomCategoryName);
		WordSearchList.verifyTermDetailPageLoaded();
	}
 
	@Test(priority=10)
	public void verifyEmptyTermInEduBankTest(){
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduBankEmptyPopUpMsg);
		EduBank.submitEduBankAlertPopUp();
	}
	
	@Test(priority=20)
	public void createBlankCategoryInEdubankTest(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForBlankTerm);
		EduBank.submitEduBankAlertPopUp();
	}
	
	@Test(priority=30)
	public void verifyNewlyAddedCategoryInEdubankTest(){
		addedCategoryName = EduBank.addTerm(DataConstants.termNameForEdubank);
		EduBank.clickOnDoneButton();
		EduBank.verifySavedInEduBankHeaderTxt();
		EduBank.submitSavedInEduBankPopUp();
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyAddedCategoryAndSubCategoryNameInEduBank(addedCategoryName, termName);
		Reusables.stepBack();
	}
	
	@Test(priority=32)
	public void verifyDuplicateCategoryInEdubankTest(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		addedCategoryName = EduBank.addTerm(DataConstants.termNameForEdubank);
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForDuplicateTerm);
		EduBank.submitEduBankAlertPopUp();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		Reusables.stepBack();
	}

	@Test(priority=50)
	public void modifiedAlreadyAddedCategryInEdubankTest(){
		EduBank.clickOnEduBank();
		EduBank.clickAndHold(addedCategoryName);
		EduBank.clickOnRenameAndDeleteButton(typeOfOperationForRename);
		EduBank.renameName(addedCategoryName);
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForRenameTerm);
		EduBank.submitEduBankAlertPopUp();
		EduBank.renameName(textForRenameCategory);
	}
	
	@Test(priority=60)
	public void verifyRenameCategoryInEdubankTest(){
		EduBank.verifyRenameCategoryName(textForRenameCategory);
	}
	
	@Test(priority=70)
	public void deleteCategoryFromEdubankTest(){
		EduBank.clickAndHold(textForRenameCategory);
		EduBank.clickOnRenameAndDeleteButton(typeOfOperationForDelete);
		EduBank.verifyDeleteCategoryName(textForRenameCategory);
	}
	
	@Test(priority=80)
	public void createDuplicateCategoryInEdubankTest(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForBlankTerm);
		EduBank.submitEduBankAlertPopUp();
		String categoryName = EduBank.getTermListValuesBasedOnIndex(indexValue);
		EduBank.addTerm(categoryName);
		EduBank.clickOnDoneButton();
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForDuplicateTerm);
		EduBank.submitEduBankAlertPopUp();
	}
	
	@Test(priority=90)
	public void addCategoryFromGivenListTest(){
		addedCategoryName = EduBank.selectRandomTermFromGivenList();
		System.out.println("Category Name."+addedCategoryName);
		EduBank.verifySavedInEduBankHeaderTxt();
		EduBank.submitSavedInEduBankPopUp();
	}
	
	@Test(priority=100)
	public void verifyAddedCategoryTest(){
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyAddedCategoryAndSubCategoryNameInEduBank(addedCategoryName, termName);
		Reusables.stepBack();
	}
	
	@Test(priority=110)
	public void deleteAndVerifyCategoryFromEdubankTest(){
		EduBank.clickOnEduBank();
		EduBank.deletePredefineGivenTerm(addedCategoryName, termName);
	}
	
	
	@Test(priority=115)
	public void createAndVerifyCategoryInEdubankForSpecialCharacterTest(){
		EduBank.clickOnAddToFavorite();
		EduBank.verifyAddToEduBankPopUpDisplayed();
		stringWithSpecialCharacter = Reusables.randomSpecialTextGenerator(6);
		addedCategoryName = EduBank.addTerm(stringWithSpecialCharacter);
		EduBank.clickOnDoneButton();
		EduBank.verifySavedInEduBankHeaderTxt();
		EduBank.submitSavedInEduBankPopUp();
		EduBank.clickOnEduBank();
		EduBank.verifyEduBankHeaderTxt();
		EduBank.verifyAddedCategoryAndSubCategoryNameInEduBank(addedCategoryName, termName);
		Reusables.stepBack();
	}
	
	@Test(priority=117)
	public void renameTermNameForSpecialCharacterTest(){
		EduBank.clickOnEduBank();
		EduBank.clickAndHold(addedCategoryName);
		EduBank.clickOnRenameAndDeleteButton(typeOfOperationForRename);
		EduBank.renameName(addedCategoryName);
		EduBank.verifyEduBankPopUpMessage(DataConstants.eduaBankPopupMsgForRenameTerm);
		EduBank.submitEduBankAlertPopUp();
		EduBank.renameName(textForRenameCategory);
	}
	
	@Test(priority=118)
	public void verifyRenameTermNameForSpecialCharacterTest(){
		EduBank.verifyRenameCategoryName(textForRenameCategory);
	}
	
	
	@Test(priority=120)
	public void verifyAdsBannerTest(){
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
	 public void closeApp(){
		 Reusables.terminatesAppInstance();
	 }
}
