package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.EduBank;
import com.eduven.modules.TermDetailPage;
import com.eduven.modules.WordSearchList;
import com.eduven.utils.Reusables;
import com.eduven.utils.ScreenShot;


public class EduBankPageTestCases {
	
	
	/* Global Variable Declaration */
	String categoryName = "";
	String termName = "";
	String eduBankCategoryName = "";
	String createdCategoryName = "";
	String renameString = "";
	String duplicateCategoryName = "";
	
	
	@Test(priority=0)
	public void removeAllAddedTermInEdubankCategoryTest(){
		Categories.navigateToCategoryPage();
		/*EduBank.navigateToEduBank();
		EduBank.removeAllTermFromEdubank();
		System.out.println("Back");
		Reusables.oneStepBack();*/
	}
	
	@Test(priority=5)
	public void navigationToTermDetailPageTest(){
		//Categories.navigateToCategoryPage();
		categoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchListPageLoaded(categoryName);
		termName = WordSearchList.navigateToTermDetailPage(categoryName);
		termName = TermDetailPage.getTermName();
		TermDetailPage.verifyEditEdubankButton();
	}
	
	@Test(priority=10)
	public void navigationToEditEdubankPageTest(){
		EduBank.clickOnEditEdubankButton();
		EduBank.verifyEditEdubankPageLoaded();
	}
	
	@Test(priority=20)
	public void eduBankAddTermToEdubankCategoryTest(){
		eduBankCategoryName = EduBank.addTermToEduBankCategory();
		EduBank.verifyEduBankPageLoaded();
		EduBank.verifyAddedTermInEduBank(eduBankCategoryName);
		Reusables.oneStepBack();
	}
	
	@Test(priority=30)
	public void eduBankAddDuplicateCategoryToEdubankTest(){
		duplicateCategoryName = EduBank.addDuplicateTermFromGivenCategoryList(eduBankCategoryName);
		Reusables.oneStepBack();
		EduBank.navigateToEduBank();
	}
	
	@Test(priority=40)
	public void eduBankDeleteNewlyAddTermInEdubankCategoryTest(){
		EduBank.deleteAddedTermForGivenCategoryList(eduBankCategoryName, duplicateCategoryName);
		Reusables.oneStepBack();
	}
	
	@Test(priority=50)
	public void eduBankCreateNewCategoryInEdubankTest(){
		EduBank.clickOnEditEdubankButton();
		createdCategoryName = EduBank.createCategoryInEduBank(Reusables.randomTextGenerator(DataConstants.wordRange));//DataConstants.termNameForEdubank);
	}
	
	@Test(priority=60)
	public void eduBankVerifyNewlyCreatedCategoryInEdubankTest(){
		EduBank.verifyEduBankPageLoaded();
		EduBank.verifyCreatedCategoryAddedInEduBank(createdCategoryName);
	}
	
	@Test(priority=70)
	public void eduBankRenameAddedCategoryInEubankTest(){
		renameString =  EduBank.renameCategoryInEduBank();
	}
	
	@Test(priority=80)
	public void eduBankVerifyRenameCategoryInEdubankTest(){
		EduBank.verifyRenameCategoryName(renameString);
	}
	
	@Test(priority=90)
	public void eduBankDeleteRenameCategoryFromEdubankTest(){
		EduBank.deleteCreatedCategoryFromEduBank(renameString);
	}
	
	 @AfterMethod 
	 public void tearDown(ITestResult result){
		 if (ITestResult.FAILURE == result.getStatus()){
			 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 }
		 else if (ITestResult.SKIP == result.getStatus()){
			 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 }
		 else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			 ScreenShot.takesScreenShotCapture(result.getMethod().getMethodName());
		 }
		 
	}
	 @AfterClass
	 public void closeApp(){
		 Reusables.terminatesAppInstance();
	 }
}
