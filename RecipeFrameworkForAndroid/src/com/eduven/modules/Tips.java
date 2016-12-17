package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class Tips {

	
	/* Object Identification */
	public static By tipsBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/tips");
	public static By tipsHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	public static By tipsDescriptionTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/text_description");
	public static By premiumTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/go_premium");
	
	
	/**
	 * This method is used to Click on Tips button on home page.
	 */
	public static void clickOnTipsButton(){
		try{
			while (Reusables.isElementPresent(tipsBtn) == false){
				Reusables.swipeUp();
				Reusables.waitThread(1);
			}
			Reusables.waitForAndroidElement(Reusables.getElement(tipsBtn));
			Reusables.clickUsingElement(Reusables.getElement(tipsBtn));
			SplashScreen.allowMediaFilesAndContacts();
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Tips Page not Loaded.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to navigate to the tips page.
	 */
	public static void navigateToTipsPage(){
		clickOnTipsButton();
	}
	
	/**
	 * This method is used to verify Tips page header text.
	 */
	public static void verifyTipsPageHeaderText(){
		try{
			Reusables.waitForElement(tipsHeaderTxt);
			Reusables.verifyPageLoaded(DataConstants.tip_page_header_txt);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Tips Page header text not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify tips related description text.
	 */
	public static void verifyTipsRelatedDescription(String tipsName){
		List<String> list = new ArrayList<String>();
		By tipDescriptionHeader = By.xpath("//android.widget.TextView[@text='"+tipsName+"']");
		boolean premiumStatus = false;
		String lastElement = "";
		String secondLastElement = "";
		List<AndroidElement> eleList;
		int i = 0;
		List<String> tipsList;
		try{
			tipsList = DatabaseConnection.tipsDescription(tipsName, premiumStatus);
			if (Reusables.isElementPresent(premiumTxtView) == true){
				premiumStatus = true;
			}
			else {
				premiumStatus = false;
			}
			while (Reusables.isElementPresent(tipDescriptionHeader) == false){
				Reusables.swipeLeft();
				Reusables.waitThread(1);
			}
			Reusables.waitForElement(tipDescriptionHeader);
			Reusables.clickCommand(tipDescriptionHeader);
			eleList = Reusables.getElementsList(tipsDescriptionTxt);
			lastElement = eleList.get(eleList.size()-1).getText();//getAttribute("name").trim();
			for (i = 0; i < eleList.size(); i++){
				System.out.println("Value of I..."+i+"...>"+eleList.get(i).getText().trim());//Attribute("name").trim());
				list.add(eleList.get(i).getAttribute("name").trim());
				if (i == eleList.size()-1){
					System.out.println("App Data before swipe "+list);
					Reusables.swipeUp(eleList.get(eleList.size()-1), eleList.get(0));
					Reusables.waitThread(2);
					i = -1;
					secondLastElement = eleList.get(eleList.size()-1).getText().trim();//getAttribute("name").trim();
					if (lastElement.equalsIgnoreCase(secondLastElement)==true){
						break;
					}
					else if (lastElement.equalsIgnoreCase(secondLastElement)==false){
						lastElement = eleList.get(eleList.size()-1).getAttribute("name").trim();
					}
				}
			}
			//System.out.println("DB Data"+tipsList+"\n"+"app data"+list);
			for (int j = 0; j < tipsList.size(); j++){
				Reusables.verifyEqualMessage(tipsList.get(j).trim(), list.get(j).trim(), "Error Message!Actual and expected text not matched.");
			}
		}catch(NoSuchElementException e){
			Logs.error("Tips Description text is null. "+e.getClass().getName());
		}
	}
	
	public static void verifyTipsDescritpion(){
		List<String> tipCat = DatabaseConnection.tipsCategory();
		for (String str : tipCat){
			verifyTipsRelatedDescription(str);
			Reusables.waitThread(2);
		}
	}
}
