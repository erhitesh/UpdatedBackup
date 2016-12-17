package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Interstetial {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By interstetial = By.xpath("//*[@content-desc='Interstitial close button']");
	
	
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
			//System.out.println("Element Count..>" + list.size());
			if (status == true && list.size() > 0) {
				Assert.assertTrue(list.size() >= 1,"Error Message!! Element not exists.");
				Reusables.stepBack();
				Reusables.waitThread(1);
			} 
			else if (status == false && list.size() < 0) {
				Assert.assertFalse(list.size() < 0,"Error Message!! Element exists.");
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
		Games.navigateToGamesPage();
		for (int i = 0; i < 3; i++){
			Games.selectGames(game_type);
			Games.startGame();
			if (i < 2){
				Reusables.waitForElement(Games.skipBtn);
				Reusables.stepBack();
			}
		}
	}
	
	
	/**
	 * This method is used for verify interstetial for word list. 
	 */
	public static void interstetialForWordList(){
		String randomCategoryName = "";
		for (int i = 0; i < 3; i++){
			randomCategoryName = Categories.clickOnRandomCategory();
			SplashScreen.allowMediaFileAccessPopup();
			TermList.verifyTermListHeaderTxt(randomCategoryName);
			Reusables.waitForElement(Search.searchBtn);
			Reusables.waitThread(2);
			Reusables.stepBack();
		}
	}
	
	/**
	 * This method is used for verify interstetial for search. 
	 */
	public static void interstetialForSearch(){
		List<String> list;
		Search.NavigateToSearchPage();
		Search.verifySearchHeaderTxt();
		list = Search.searchWord("unlock");
		for (int i = 0; i < 3; i++){
			Search.selectSearchWord(list.get(1));
			if (i < 2){
				Reusables.waitThread(2);
				Reusables.stepBack();
			}
		}
	}

	/**
	 * This method is used for verify interstetial for Quick List. 
	 */
	public static void interstetialForQuickList(){
		for (int i = 0; i < 2; i++){
			QuickList.navigateToQuickListPage();
			Reusables.waitThread(2);
			Reusables.stepBack();
		}
	}
	
	/**
	 * This method is used for verify interstetial for Quick List. 
	 */
	public static void interstetialForInApp(){
		for (int i = 0; i < 2; i++){
			EntityDetailPage.navigateToPurchasePage();
			Reusables.waitThread(2);
			Reusables.stepBack();
		}
	}
}
