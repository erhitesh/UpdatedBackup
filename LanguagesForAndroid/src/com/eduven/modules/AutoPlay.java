package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class AutoPlay {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By autoPlayBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/tbtn_play");
	public static By shuffleBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_shuffle");
	public static By repeatOffBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_repeat");
	public static By repeatNumberTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/spinner_times");
	public static By delayNumberTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/spinner_timer");
	public static By delay_number_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_text");
	public static By stopAudioBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/tbtn_play");
	public static By term_name = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_word");
	public static By acceptAlert = By.id("android:id/button1");
	
	
	/**
	 * This method is used to click on the auto play button.
	 */
	public static void clickOnAutoPlayBtn(){
		try{
			Reusables.waitForElement(autoPlayBtn);
			Reusables.clickCommand(autoPlayBtn);
			while (Reusables.isElementPresent(acceptAlert)){
				Reusables.clickCommand(acceptAlert);
				Reusables.waitThread(30);
				Reusables.clickCommand(autoPlayBtn);
				}
		}catch(NoSuchElementException e){
			Logs.error("Auto Play Button not clickable. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to return the instance the stop button.
	 * @return : return the AndroidElement.
	 */
	public static AndroidElement stopBtnInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(stopAudioBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the stop audio button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the shuffle button.
	 * @return : return the AndroidElement.
	 */
	public static AndroidElement shuffleBtnInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(shuffleBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Shuffle Button. "+e.getClass().getName());
		}
		
		return element;
	}

	
	/**
	 * This method is used to return the instance the Repeat Off button.
	 * @return : return the AndroidElement.
	 */
	public static AndroidElement repeatOffBtnInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(repeatOffBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Repeat Off Button. "+e.getClass().getName());
		}
		
		return element;
	}
	

	/**
	 * This method is used to return the instance the Repeat number text.
	 * @return : return the AndroidElement.
	 */
	public static AndroidElement repeatNumberTxtInstance(){
		AndroidElement element = null;
		try{
			element = Reusables.getElement(repeatNumberTxt);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Repeat number txt. "+e.getClass().getName());
		}
		
		return element;
	}
	
	
	/**
	 * This method is used to return the instance the Delay number text.
	 * @return : return the AndroidElement.
	 */
	public static AndroidElement delayNumberInstance(){
		
		return Reusables.getElement(delayNumberTxt);
	}
	
	
	/**
	 * This method is used to verify element present or not.
	 */
	public static void verifyButtonPresent(){
		try{
			shuffleBtnInstance().isDisplayed();
			repeatOffBtnInstance().isDisplayed();
			repeatNumberTxtInstance().isDisplayed();
			delayNumberInstance().isDisplayed();
		}catch(NoSuchElementException e){
			Logs.error("Buttons not visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify button after play audio.
	 */
	public static void verifyElementStatusAfterStartPlayButton(){
		try{
			Reusables.verifyElementDisable(shuffleBtnInstance(), "Error Message!! Shuffle button is enable.");
			Reusables.verifyElementDisable(repeatOffBtnInstance(), "Error Message!! Repeat button id enable.");
			Reusables.verifyElementDisable(repeatNumberTxtInstance(), "Error Message!! Repeat times button is enable.");
			Reusables.verifyElementDisable(delayNumberInstance(), "Error Message!! Delay time button is enable.");
		}catch(NoSuchElementException e){
			Logs.error("Button still enable. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the delay time text.
	 */
	public static void clickOnDelayTime(){
		Reusables.tapOnElementUsingLocator(delayNumberInstance());
	}
	
	
	/**
	 * This method is used to select delay time from delay time list.
	 * @param delay_time : for delay auto play.
	 */
	public static void selectDelayTime(int delay_time){
		List<AndroidElement> delayTimeList;
		try{
			delayTimeList = Reusables.getElementsList(delay_number_btn);
			for (AndroidElement element : delayTimeList){
				if (element.getText().equalsIgnoreCase(""+delay_time)){
					element.click();
					Reusables.waitThread(2);
					break;
				}
			}
		}catch(NoSuchElementException e){
			Logs.error("Unable to select delay time. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get term name.
	 * @return : String as first term name.
	 */
	public static String getTermName(){
		String firstTermName = "";
		List<AndroidElement> termNameList;
		try{
			termNameList = Reusables.getElementsList(term_name);
			firstTermName = termNameList.get(0).getText();
			//System.out.println("Term Name "+firstTermName);
		}catch(NoSuchElementException e){
			Logs.error("Unable to fetch term name. "+e.getClass().getName());
		}
		
		return firstTermName;
	}
	
	/**
	 * This method is used to verify first term name after starting auto play.
	 * @param expected_term_name : for matching actual term name with expected one.
	 */
	public static void verifyTermNameAfterAutoPlay(String expected_term_name){
		try{
			Reusables.waitThread(20);
			Reusables.verifyNotEqualMessage(getTermName(), expected_term_name, "Error Messsage!!Term Name still matched.");
		}catch(NoSuchElementException e){
			Logs.error("Term Name still matched. "+e.getClass().getName());
		}
	}
}
