package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class AutoPlay {
	
	
	/* Object Identification */
	public static By autoPlayBtn = By.id("icon autoplay");
	public static By playBtn = By.id("playAudio");
	public static By shuffleBtn = By.id("ShufleON");
	public static By repeatOffBtn = By.id("repeatOff");
	public static By decreaseRepeatBtn = By.id("decreaseArrow");
	public static By increaseRepeatBtn = By.id("increaseArrow");
	public static By repeatNumberTxt = By.id("RepeatNumber");
	public static By increaseTimeBtn = By.id("IncreaseTime");
	public static By delayNumberTxt = By.id("DelayNumber");
	public static By decreaseTimeBtn = By.id("DecreaseTime");
	public static By stopAudioBtn = By.id("stopAudio");
	
	
	/**
	 * This method is used to click on the auto play button.
	 */
	public static void clickOnAutoPlayBtn(){
		try{
			Reusables.waitForElement(autoPlayBtn);
			Reusables.clickCommand(autoPlayBtn);
		}catch(NoSuchElementException e){
			Logs.error("Auto Play Button not clickable. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to return the instance the play button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement playBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(playBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Play. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the stop button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement stopBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(stopAudioBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the stop audio button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the shuffle button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement shuffleBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(shuffleBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Shuffle Button. "+e.getClass().getName());
		}
		
		return element;
	}

	
	/**
	 * This method is used to return the instance the Repeat Off button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement repeatOffBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(repeatOffBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Repeat Off Button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the Decrease repeat button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement decreaseRepeatBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(decreaseRepeatBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Decrease repeat Button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the Increase repeat button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement increaseRepeatBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(increaseRepeatBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Increase repeat Button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the Repeat number text.
	 * @return : return the IOSElement.
	 */
	public static IOSElement repeatNumberTxtInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(repeatNumberTxt);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Repeat number txt. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the increase time button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement increaseTimeBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(increaseTimeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Increase time Button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the Decrease time button.
	 * @return : return the IOSElement.
	 */
	public static IOSElement DecreaseTimeBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(decreaseTimeBtn);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Decrease Time Button. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to return the instance the Delay number text.
	 * @return : return the IOSElement.
	 */
	public static IOSElement delayNumberBtnInstance(){
		IOSElement element = null;
		try{
			element = Reusables.getElement(delayNumberTxt);
		}catch(NoSuchElementException e){
			Logs.error("Unable to get the instance the Delay Number text. "+e.getClass().getName());
		}
		
		return element;
	}
	
	/**
	 * This method is used to click on the play button.
	 */
	public static void clickOnPlayButton(){
		try{
			playBtnInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Unable to click on play button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify element present or not.
	 */
	public static void verifyButtonPresent(){
		try{
			Reusables.verifyElementPresent(playBtnInstance(), "Error Message!! Play button not display.");
			Reusables.verifyElementPresent(shuffleBtnInstance(), "Error Message!! Shuffle button not display.");
			Reusables.verifyElementPresent(repeatOffBtnInstance(), "Error Message!! Repeat Off button not display.");
			Reusables.verifyElementPresent(decreaseRepeatBtnInstance(), "Error Message!! Decrease Repeat button not display.");
			Reusables.verifyElementPresent(increaseRepeatBtnInstance(), "Error Message!! Increase Repeat button not display.");
			Reusables.verifyElementPresent(DecreaseTimeBtnInstance(), "Error Message!! Decrease Time button not display.");
			Reusables.verifyElementPresent(increaseTimeBtnInstance(), "Error Message!! Inrease Time button not display.");
		}catch(NoSuchElementException e){
			Logs.error("Buttons are not display. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify button after play audio.
	 */
	public static void verifyButtonAfterStartPlayButton(){
		try{
			Reusables.verifyElementDisable(shuffleBtnInstance(), "Error Message!!Shuffle button still Enable.");
			Reusables.verifyElementDisable(repeatOffBtnInstance(), "Error Message!! Repeat Off button still Enable.");
			Reusables.verifyElementDisable(decreaseRepeatBtnInstance(), "Error Message!! Decrease Repeat button still Enable.");
			Reusables.verifyElementDisable(increaseRepeatBtnInstance(), "Error Message!! Increase Repeat button still Enable.");
			Reusables.verifyElementDisable(DecreaseTimeBtnInstance(), "Error Message!! Decrease Time button still Enable.");
			Reusables.verifyElementDisable(increaseTimeBtnInstance(), "Error Message!! Increase Time button still Enable.");
		}catch(NoSuchElementException e){
			Logs.error("Button still enable. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get first term name.
	 * @return : 
	 */
	public static String getFirstTermName(){
		String termName = "";
		try{
			Reusables.waitThread(2);
			List<IOSElement> element = Reusables.getElementsList(TermList.termNameTxt);
			termName = element.get(0).getText();
			System.out.println("Term Name..>"+termName);
		}catch(NoSuchElementException e){
			Logs.error("Term Name not found. "+e.getClass().getName());
		}
		
		return termName;
	}
	
	/* This method is used to verify first term name after starting auto play.
	 * @param expected_term_name : for matching actual term name with expected one.
	 */
	public static void verifyTermNameAfterAutoPlay(/*String expected_term_name*/){
		List<IOSElement> list;
		try{
			Reusables.waitThread(2);
			list = Reusables.getElementsList(TermList.termNameTxt);
			System.out.println(list.get(0).isEnabled());
			System.out.println(list.get(0).isDisplayed());
			Reusables.verifyElementNotPresent(list.get(0), "Error Message!! Turbo play does not work.");
		}catch(NoSuchElementException e){
			Logs.error("Term Name still matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to select delay time from delay time list.
	 * @param delay_time : for delay auto play.
	 */
	public static void selectDelayTime(int delay_time){
		try{
			Reusables.waitThread(2);
			IOSElement delay_time_list = Reusables.getElement(increaseTimeBtn);
			for (int i = 0; i < delay_time; i++){
				delay_time_list.click();
			}
		}catch(NoSuchElementException e){
			Logs.error("Unable to select delay time. "+e.getClass().getName());
		}
	}
}
