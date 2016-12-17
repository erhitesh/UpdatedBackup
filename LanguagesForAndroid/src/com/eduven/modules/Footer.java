package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class Footer {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By quickListBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_staples");
	public static By eduBankBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_favourite");
	public static By purchaseBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/ivMoreApps");
	public static By gamesBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_game");
	public static By langaugeSelectionBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_base_language");
	
	
	/**
	 * This method is used to get QuickList button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getQuickListBtnInstance(){
		
		return Reusables.getElementsList(quickListBtn).get(0);
	}
	
	/**
	 * This method is used to get EduBank button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getEduBankBtnInstance(){
		
		return Reusables.getElementsList(eduBankBtn).get(0);
	}
	
	/**
	 * This method is used to get Purchase button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getPurchaseBtnInstance(){
		
		return Reusables.getElementsList(purchaseBtn).get(0);
	}
	
	
	/**
	 * This method is used to get Games button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getGamesBtnInstance(){
		
		return Reusables.getElementsList(gamesBtn).get(0);
	}
	
	/**
	 * This method is used to get Switch Language button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getSwitchLanguageBtnInstance(){
		
		return Reusables.getElementsList(langaugeSelectionBtn).get(0);
	}
	
	
	/**
	 * This method is used to verify either Quick List button present or not.
	 */
	public static void verifyQuickListBtn(){
		try{
			Reusables.verifyElementPresent(getQuickListBtnInstance(), "Error Message!! Quick List Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Quick List Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either EduBank Button present or not.
	 */
	public static void verifyEduBankBtn(){
		try{
			Reusables.verifyElementPresent(getEduBankBtnInstance(), "Error Message!! EduBank Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("EduBank Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either Purchase Button present or not.
	 */
	public static void verifyPurchaseBtn(){
		try{
			Reusables.verifyElementPresent(getPurchaseBtnInstance(), "Error Message!! Purchase Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Purchase Button Not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify either Games Button present or not.
	 */
	public static void verifyGamesBtn(){
		try{
			Reusables.verifyElementPresent(getGamesBtnInstance(), "Error Message!! Games Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Games Button Not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify either Switch Language Button present or not.
	 */
	public static void verifySwitchLanguageBtn(){
		try{
			Reusables.verifyElementPresent(getSwitchLanguageBtnInstance(), "Error Message!!Switch Language Button not present.");
		}catch(NoSuchElementException e){
			Logs.error("Switch Language Button Not found. "+e.getClass().getName());
		}
	}
}
