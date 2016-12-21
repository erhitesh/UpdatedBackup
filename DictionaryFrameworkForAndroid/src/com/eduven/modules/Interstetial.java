package com.eduven.modules;

import java.util.List;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class Interstetial {
	
	
	/* Object Identification */
	public static By interstetial = By.xpath("//*[@content-desc='Interstitial close button']");
	public static By searchTermTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	
	
	/**
	 * This method is used to verify either interstetial button present or not.
	 * @param status : for checking condition inside method.
	 */
	public static void verifyInterstetialBtn(boolean status){
		Reusables.waitThread(5);
		List<AndroidElement> list;
		try {
			Reusables.waitThread(2);
			list = Reusables.getElementsList(interstetial);
			System.out.println("Interstetial instance Count..>"+list.size());
			if (status == true && list.size() > 0) {
				Assert.assertTrue(list.size() >= 1,"Error Message!! Element not exists.");
				Reusables.stepBack();
				Reusables.waitThread(1);
			} 
			else if (status == false && list.size() < 0) {
				Assert.assertFalse(list.size() < 0, "Error Message!! Element exists.");
				Reusables.stepBack();
			}
		}catch(NoSuchElementException e){
			Logs.error(e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify interstetial for games.
	 * @param game_type
	 */
	public static void interstetialForPayQuiz(String game_type){
		/*Quiz.navigateToGamesPage();
		for (int i = 0; i < 3; i++){
			Quiz.selectGames(game_type);
			Quiz.startGame();
			if (i < 2){
				Reusables.waitForElement(Quiz.skipBtn);
				Reusables.stepBack();
			}
		}*/
	}
	
	
	/**
	 * This method is used for verify interstetial for Term Detail Page. 
	 */
	public static void interstetialForTermDetailPage(){
		String randomCategoryName = "";
		String termName = "";
		HomePage.verifyAppName();
		Categories.navigateToCategoryPage();
		Categories.verifyCategoryPageLoaded();
		randomCategoryName = Categories.clickOnRandomCategory();
		WordSearchList.verifyWordSearchPageLoaded(randomCategoryName);
		for (int i = 0; i < 3; i++){
			termName = WordSearchList.navigateToTermDetailPage(randomCategoryName);
			Reusables.verifyEqualMessage(TermDetailPage.getTermName(), termName, "Error Message!! Term Name are not matched.");
			Reusables.stepBack();
			}
	}
	
	/**
	 * This method is used for verify interstetial for Search. 
	 */
	public static void interstetialForSearch(){
		String search_term = "";
		HomePage.navigateToSearchBoxPage();
		for (int i = 0; i < 3; i++){
			List<String> categoryList = DatabaseConnection.getMainCategories();
			search_term = DatabaseConnection.getUnLockTerm(categoryList.get(Reusables.randomNumber(categoryList.size()-1)));
			Reusables.enterMessageInTextBox(HomePage.searchtxtbox, search_term);
			Reusables.clickCommand(searchTermTxt);
			Reusables.waitThread(2);
			if (i < 2){
				Reusables.stepBack();
			}
		}
	}


	/**
	 * This method is used for verify interstetial for InApp Purchase. 
	 */
	public static void interstetialForInApp(){
		for (int i = 0; i < 2; i++){
			InAppPurchase.navigateToInAppPurchasePage();
			Reusables.stepBack();
			Reusables.waitForElement(TermDetailPage.contributeLaterBtn);
			Reusables.clickUsingElement(Reusables.getElement(TermDetailPage.contributeLaterBtn));
			Reusables.waitThread(2);
		}
	}
	
	/**
	 * This method is used for verify interstetial for Category Page. 
	 */
	public static void interstetialForCategory(){
		HomePage.verifyAppName();
		for (int i = 0; i < 3; i++){
			Categories.navigateToCategoryPage();
			Categories.verifyCategoryPageLoaded();
			Reusables.stepBack();
		}
	}
}
