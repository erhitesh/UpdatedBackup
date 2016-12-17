package com.eduven.testcase;

import java.util.List;

import org.testng.annotations.Test;

import com.eduven.modules.AutoPlay;
import com.eduven.modules.EduBank;
import com.eduven.modules.EntityDetailPage;
import com.eduven.modules.LanguageCategoryPage;
import com.eduven.modules.ScreenCapture;
import com.eduven.modules.SwitchLingo;
import com.eduven.utils.Reusables;


public class ScreenCaptureTestCases {
	
	
	/* Global Variable Declaration */
	List<String> languageNameList;
	String languageName = "english";
	String purchase_option = "allfunctionality";
	int screen_shot_value1 = 0;
	int screen_shot_value = 1;
	int valueForSwitchLingo1 = 0;
	int valueForSwitchLingo2 = 1;
	int valueForSwitchLingo3 = 2;
	int valueForSwitchLingo4 = 3;
	int valueForSwitchLingo5 = 4;
	int indexValueForFirstCategory = 0;
	int indexValueForSpecificCategory = 6;
	int indexValueForSpecificTerm = 3;
	
	@Test(priority=0)
	public void createDirectoriesTest(){
		languageNameList = LanguageCategoryPage.languageNameListValue();
		ScreenCapture.createFolders(languageNameList);
		ScreenCapture.takesScreenShotCapture(screen_shot_value1, languageName);
		languageName = LanguageCategoryPage.langugeSelection();
	}
	
	@Test(priority=10)
	public void inAppPurchaseTest(){
		EntityDetailPage.navigateToPurchasePage();
		EntityDetailPage.signInStore(purchase_option);
		EntityDetailPage.alreadyConfirmPurchaseAlertPopup();
		EntityDetailPage.thankYouAlertPopup();
		EntityDetailPage.congratulationAlertPopup();
	}
	
/*	@Test(priority=15)
	public void addTermsInEduBankTest(){
		ScreenCapture.clickOnRandomCategory();
		EduBank.addTermInEduBank(0);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(1);
		Reusables.stepBack();
		ScreenCapture.clickOnCategory(indexValueForFirstCategory);
		EduBank.addTermInEduBank(0);
		Reusables.waitThread(2);
		EduBank.addTermInEduBank(1);
		Reusables.stepBack();
	}*/
	
	@Test(priority=20)
	public void screenShotCaptureForCategoryPage(){
		
		// for loop
		for (int i = 0; i < languageNameList.size()-1; i++){
			
			//Add term in EduBank. 
			ScreenCapture.clickOnRandomCategory();
			EduBank.addTermInEduBank(0);
			Reusables.waitThread(2);
			EduBank.addTermInEduBank(1);
			Reusables.stepBack();
			ScreenCapture.clickOnCategory(indexValueForFirstCategory);
			EduBank.addTermInEduBank(0);
			Reusables.waitThread(2);
			EduBank.addTermInEduBank(1);
			Reusables.stepBack();
			// For Category page.
			screen_shot_value = 1;
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			Reusables.swipeUp();
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			Reusables.swipeDown();
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			ScreenCapture.clickOnCategory(indexValueForFirstCategory);
			// Turbo play
			Reusables.waitThread(5);
			AutoPlay.clickOnAutoPlayBtn();
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			AutoPlay.clickOnPlayButton();
			Reusables.waitThread(2);
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			Reusables.waitThread(2);
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			Reusables.stepBack();
			// Add Another term in EduBank
			Reusables.swipeUp();
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			Reusables.swipeDown();
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			ScreenCapture.clickOnCategory(indexValueForSpecificCategory);
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			ScreenCapture.clickOnTermNameAndEdubank(indexValueForSpecificTerm);
			EduBank.navigateToEduBankPage();
			ScreenCapture.takesScreenShotCapture(screen_shot_value, languageName);
			screen_shot_value++;
			//Delete terms from edubank.
			ScreenCapture.removeAllTermFromEduBank();
			Reusables.waitThread(2);
			Reusables.stepBack();
			//Switch Lingo
			SwitchLingo.navigateToSwitchLanguagePage();
			languageName = ScreenCapture.switchLingo(i);
		}
	}
}
