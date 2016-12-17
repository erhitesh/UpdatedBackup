package com.eduven.modules;

import org.openqa.selenium.NoSuchElementException;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;
import com.eduven.utils.Reusables;

public class HomePageForSeafood {
	
	
	/**
	 * This method is used to verify App name on home page
	 */
	public static void verifyAppName(){
		try{
			Reusables.waitForElement(HomePage.nextArrow);
			while (Reusables.isElementPresent(HomePage.nextArrow)){
				Reusables.clickCommand(HomePage.nextArrow);
				Reusables.waitThread(1);
			}
			Reusables.waitForElement(HomePage.appNameTxt);
			Reusables.verifyEqualMessage(Reusables.getText(HomePage.appNameTxt), DataConstants.appName, "Error Message!! Actual and Expected text not matched.");
		}catch(NoSuchElementException r){
			Logs.error("Actual and Expected text not matched. "+r.getClass().getName());
		}
	}
}
