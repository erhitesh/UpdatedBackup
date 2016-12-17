package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class Footer {
	

	/* Object Identification */
	public static By optionalBtn = By.id("Footer_other_button");
	public static By contributeBtn = By.id("Footer_contribute_button");
	public static By inAppBtn = By.id("Footer_unlock_button");
	public static By eduBankBtn = By.id("Footer_edubank_button");
	public static By quizBtn = By.id("Footer_quiz_button");
	
	
	/**
	 * This method is used to return the instance of Contribute.
	 */
	public static IOSElement contribute(){
		
		return Reusables.getIOSElement(contributeBtn);
	}
	
	/**
	 * This method is used to return the instance of Lock.
	 */
	public static IOSElement inAppBtn(){
		
		return Reusables.getIOSElement(inAppBtn);
	}
	
	/**
	 * This method is used to return the instance of eduBank.
	 */
	public static IOSElement eduBankInstance(){
		
		return Reusables.getIOSElement(eduBankBtn);
	}
	
	/**
	 * This method is used to return the instance of Quiz.
	 */
	public static IOSElement quizInstance(){
		
		return Reusables.getIOSElement(quizBtn);
	}
	
	/**
	 * This method is used to click on the eduBank Icon.
	 */
	public static void clickOnEduBank(){
		try{
			Reusables.clickUsingIOSElement(eduBankInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>>> EduBank Icon Not present...."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Contribute present.
	 */
	public static void verifyContribute(){
		try{
			Reusables.verifyElementPresent(contribute(), "Error Message!!Contribute button not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Contribute Element not present..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Lock present.
	 */
	public static void verifyInApp(){
		try{
			Reusables.verifyElementPresent(inAppBtn(), "Error Message!!InApp Purchase button not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Lock Element not present..."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the inApp purchase button.
	 * 
	 */
	public static void clickOnInAppPurchase(){
		try{
			Reusables.waitForIOSElement(inAppBtn);
			Reusables.clickUsingIOSElement(inAppBtn());
		}catch(NoSuchElementException e){
			Logs.error("Unable to click on the inApp purchase button. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EduBank present.
	 */
	public static void verifyEduBank(){
		try{
			Reusables.verifyElementPresent(eduBankInstance(), "Error Message!!EduBank button not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> EduBank Element not present..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Quiz present.
	 */
	public static void verifyQuiz(){
		try{
			Reusables.verifyElementPresent(quizInstance(), "Error Message!!Quiz button not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>>>>>>> Quiz Element not present..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the quiz button.
	 */
	public static void clickOnQuiz(){
		try{
			Reusables.clickUsingIOSElement(quizInstance());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>> Quiz Page not loaded.. "+e.getClass().getName());
		}
	}
	
	public static void navigateToQuiz(){
		try{
			clickOnQuiz();
		}catch(NoSuchElementException e){
			Logs.error("Click Operation not perform on the Quiz button. "+e.getClass().getName());
		}
	}
}
