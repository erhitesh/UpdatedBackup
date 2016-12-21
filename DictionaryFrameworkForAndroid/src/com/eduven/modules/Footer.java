package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;


public class Footer {
	
	
	/* Object Identification */
	public static By featureBoxImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/feature1");
	public static By contributeImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/contribute");//:id/feature2");
	public static By buyImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/unlock");
	public static By eduBankImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/favorites");
	public static By quizImageView = By.id(DeviceRelatedInformation.getPackageName()+":id/quiz");
	
	/**
	 * This method is used to return the instance of Feature box.
	 */
	public static AndroidElement featureBox(){
		
		return Reusables.getElement(featureBoxImageView);
	}
	
	/**
	 * This method is used to return the instance of Contribute.
	 */
	public static AndroidElement contribute(){
		
		return Reusables.getElement(contributeImageView);
	}
	
	/**
	 * This method is used to return the instance of Lock.
	 */
	public static AndroidElement buy(){
		
		return Reusables.getElement(buyImageView);
	}
	
	/**
	 * This method is used to return the instance of eduBank.
	 */
	public static AndroidElement eduBank(){
		
		return Reusables.getElement(eduBankImageView);
	}
	
	/**
	 * This method is used to return the instance of Quiz.
	 */
	public static AndroidElement quiz(){
		
		return Reusables.getElement(quizImageView);
	}
	
	/**
	 * This method is used to click on the eduBank Icon.
	 */
	public static void clickOnEduBank(){
		try{
			Reusables.clickUsingElement(eduBank());
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank Icon Not present. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify Feature Box present.
	 */
	public static void verifyFeatureBox(){
		try{
			Reusables.verifyElementPresent(featureBox(), "Error Message!! Feature Box Icon not Visible..");
		}
		catch(NoSuchElementException e){
			Logs.error("Feature Box Element not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Contribute present.
	 */
	public static void verifyContribute(){
		try{
			Reusables.verifyElementPresent(contribute(), "Error Message!!Contribute Icon not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Icon not present. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Lock present.
	 */
	public static void verifyLock(){
		try{
			Reusables.waitForElement(buyImageView);
			Reusables.verifyElementPresent(buy(), "Error Message!!Lock Icon not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error("Lock Icon not present... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EduBank present.
	 */
	public static void verifyEduBank(){
		try{
			Reusables.verifyElementPresent(eduBank(), "Error Message!!EduBank Icon not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error("EduBank Icon not present... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Quiz present.
	 */
	public static void verifyQuiz(){
		try{
			Reusables.verifyElementPresent(quiz(), "Error Message!!Quiz Icon not Present..");
		}
		catch(NoSuchElementException e){
			Logs.error("Quiz Icon not present... "+e.getClass().getName());
		}
	}
}
