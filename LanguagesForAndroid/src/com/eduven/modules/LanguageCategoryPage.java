package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;



public class LanguageCategoryPage {
	
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	
	/* Global Declaration */
	static String languageSelectionValue;
	
	/* Object Identification */
	public static By languageCount = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By selectBaseLanguageTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_title");//By.xpath("//android.widget.TextView[@text='Select Language']");
	public static By categoryHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tab_title");
	public static By alert_dismissBtn = By.id("android:id/button1");
	public static By alert_continueBtn = By.id("android:id/button3");
	
 
	/**
	 *  This method is used to select random language from given list.
	 * @return : String, as selected name.
	 */
	public static String langugeSelection(){
		try{
			if (Reusables.isElementPresent(selectBaseLanguageTxt) == true){
				List<AndroidElement> languageList = Reusables.getElementsList(languageCount);
				for (int i = 0; i < languageList.size(); i++){
					if (languageList.get(i).getText().equals("English")){
						languageSelectionValue = languageList.get(i).getText().toLowerCase();
						Reusables.clickUsingElement(languageList.get(i));
						Reusables.waitThread(30);
						break;
						}
					}
				}
			else if (Reusables.isElementPresent(SwitchLingo.switchLingoHeaderTxt) == true){
				int number = Reusables.randomNumber(Reusables.getElementsList(languageCount).size());
				List<AndroidElement> languageList = Reusables.getElementsList(languageCount);
				languageSelectionValue = DatabaseConnection.getLanguageNameCorresSwitchLingo(languageList.get(number).getText()).toLowerCase();
				System.out.println("Langugae Name for switch lingo..> "+languageSelectionValue);
				Reusables.clickUsingElement(languageList.get(number));
			}
			else if (Reusables.isElementPresent(selectBaseLanguageTxt) == false){
				Reusables.waitForAndroidElement(Reusables.getElement(categoryHeaderTxt));
				}
		}
		catch(NoSuchElementException e){
			Logs.error("Unable to change the base language. "+e.getClass().getName());
		}
		
		return languageSelectionValue;
		
	}
	
	/**
	 * This method is used to handle download image popup.
	 */
	public static void handleDownloadImagePopoup(){
		try{
			Reusables.waitThread(2);
			if (Reusables.isElementPresent(alert_dismissBtn) == true){
				Reusables.clickCommand(alert_dismissBtn);
				Reusables.waitThread(2);
				if (Reusables.isElementPresent(alert_continueBtn) == true){
					Reusables.clickCommand(alert_continueBtn);
				}
			}
			else if (Reusables.isElementPresent(alert_dismissBtn) == false){
			}
		}catch(NoSuchElementException e){
			Logs.error("Download images and laern easily! popup not found. "+e.getClass().getName());
		}
	}
	
}
