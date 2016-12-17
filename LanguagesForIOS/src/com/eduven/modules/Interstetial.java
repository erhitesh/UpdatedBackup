package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class Interstetial {
	
	
	/* Object Identification */
	public static By interstetial = By.xpath("//UIAButton[@name='Close Advertisement']");
	
	
	/**
	 * This method is used to verify either interstetial button present or not.
	 * @param status : for checking condition inside method.
	 */
	public static void verifyInterstetialBtn(boolean status){
		Reusables.waitThread(5);
		List<IOSElement> list;
		try {
			list = Reusables.getElementsList(interstetial);
			//System.out.println("Interstetial Size..>" + list.size());
			if (status == true && list.size() > 0) {
				Assert.assertTrue(list.size() >= 1,"Error Message!! Element not exists.");
				list.get(0).click();
			} 
			else if (status == false && list.size() < 0) {
				Assert.assertFalse(list.size() < 0,"Error Message!! Element exists.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Interstetial"+e.getClass().getName());
		}
	}

	
	/**
	 * This method is used to verify interstetial for games.
	 * @param game_type
	 */
	public static void interstetialForPayQuiz(String game_type){
		Games.navigateToGamesPage();
		Games.selectGames();
		Reusables.waitThread(2);
	}
	
	
	/**
	 * This method is used for verify interstetial for Quick List. 
	 */
	public static void interstetialForInApp(){
		EntityDetailPage.navigateToPurchasePage();
		EntityDetailPage.selectPurchaseOption("adfree");
		Reusables.stepBack();
		EntityDetailPage.clickOnCancelButton();
		Reusables.waitThread(2);
	}
	
}
