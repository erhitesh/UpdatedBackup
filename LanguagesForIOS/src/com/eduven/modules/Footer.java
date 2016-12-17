package com.eduven.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class Footer {
	
	
	/* Object Identification */
	public static By quickListBtn = By.id("quick list");
	public static By eduBankBtn = By.id("edubank");
	public static By purchaseBtn = By.id("be pro");
	public static By gamesBtn = By.id("games barButton");
	public static By langaugeSelectionBtn = By.id("switch lingo");
	
	
	/**
	 * This method is used to verify either Quick List button present or not.
	 */
	public static void verifyQuickListBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(quickListBtn), "Error Message!! Quick List Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Quick List Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either EduBank Button present or not.
	 */
	public static void verifyEduBankBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(eduBankBtn), "Error Message!! EduBank Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("EduBank Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either Purchase Button present or not.
	 */
	public static void verifyPurchaseBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(purchaseBtn), "Error Message!! Purchase Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Purchase Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either Games Button present or not.
	 */
	public static void verifyGamesBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(gamesBtn), "Error Message!! Games Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Games Button Not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify either Switch Language Button present or not.
	 */
	public static void verifySwitchLanguageBtn(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(langaugeSelectionBtn), "Error Message!!Switch Language Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Switch Language Button Not found. "+e.getClass().getName());
		}
	}
}
