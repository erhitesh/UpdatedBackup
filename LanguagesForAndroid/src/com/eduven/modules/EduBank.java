package com.eduven.modules;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;


public class EduBank {
	
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object Identification */
	public static By eduBankBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/iv_favourite");
	public static By eduBankHeaderTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	public static By addFavBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_rating");
	public static By termNameTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_word");
	
	
	/**
	 * This method is used to get EduBank button instance.
	 * @return : AndroidElement.
	 */
	public static AndroidElement getEduBankBtnInstance(){
		
		return Reusables.getElementsList(eduBankBtn).get(0);
	}
	
	
	/**
	 * This method is used to navigate to the EduBank page.
	 */
	public static void navigateToEduBankPage(){
		try{
			Reusables.waitThread(2);
			Reusables.waitForAndroidElement(getEduBankBtnInstance());
			getEduBankBtnInstance().click();
		}catch(NoSuchElementException e){
			Logs.error("Not Navigate to the right page..> EduBank Page "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify EduBank Header text.
	 * @return : boolean value for EduBank header
	 */
	public static boolean verifyEduBankHeaderTxt(){
		boolean status = false;
		try{
			if (Reusables.isElementPresent(eduBankHeaderTxt) == true){
				Reusables.verifyElementPresent(Reusables.getElement(eduBankHeaderTxt), "Error Message!! EduBank Header text not found.");
				status = true;
			}
			else if (Reusables.isElementPresent(eduBankHeaderTxt) == false){
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Neither Alert nor EduBank header text are found. "+e.getClass().getName());
		}
		
		return status;
	}
	
	
	/**
	 * This method is used to add term into EduBank.
	 * @param index : integer type for adding term in EduBank.
	 */
	public static void addTermInEduBank(int index){
		try{
			Reusables.waitThread(1);
			Reusables.clickUsingElement(Reusables.getElementsList(addFavBtn).get(index));
		}catch(NoSuchElementException e){
			Logs.error("AddFavorite Button not found. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to get the added term in EduBank.
	 * @param term_name : String value for getting specified value for the element.
	 * @return : Return String name as Term Name.
	 */
	public static String getAddedTermInEduBank(String term_name){
		String termName = "";
		try{
			termName = Reusables.getText(Reusables.getElement(By.xpath("//*[@value='"+term_name+"']")));
		}catch(NoSuchElementException e){
			Logs.error("Not Find Any term name in EduBank. "+e.getClass().getName());
		}
		
		return termName;
	}
	
	
	/**
	 * This method is used to verify added term in EduBank.
	 * @param expectedTermName : String value for comparison.
	 */
	public static void verifyTermInEduBank(String expectedTermName){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[@text='"+expectedTermName+"']")), "Error Message!! Term Name not found.");
		}catch(NoSuchElementException e){
			Logs.error("Added Term not found in edubank. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify remove term from EduBank.
	 * @param expectedTermName : String value for comparison.
	 */
	public static void verifyTermInEduBankAfterRemove(String expectedTermName){
		try{
			List<AndroidElement> list = Reusables.getElementsList(By.xpath("//*[@value='"+expectedTermName+"']"));
			Reusables.waitThread(3);
			if (list.size() > 0){
				Assert.fail("Remove term still exists.");
			}
			else if (list.size() < 0){
				Assert.assertTrue(list.size() < 0, "Remove term still exists");
			}
		}catch(NoSuchElementException e){
			Logs.error("Added Term found in edubank. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to remove added term name from EduBank.
	 * @param index : integer value for remove the the term name from EduBank.
	 */
	public static void removeSpecificTermFromEduBank(int index){
		try{
			Reusables.waitThread(2);
			List<AndroidElement> favoriteBtns = Reusables.getElementsList(addFavBtn);
			favoriteBtns.get(index).click();
			Reusables.waitThread(2);
		}catch(NoSuchElementException e){
			Logs.error("Add Favorite Button is still visible. "+e.getClass().getName());
		}
	}
	
	
	
	/**
	 * This method is used to remove all added term name from EduBank.
	 */
	public static void removeAllTermFromEduBank(){
		try{
			List<AndroidElement> favoriteBtns = Reusables.getElementsList(addFavBtn);
			for (int i = 0; i < favoriteBtns.size(); i++){
				favoriteBtns.get(i).click();
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Add Favorite Button is still visible. "+e.getClass().getName());
		}
	}
}
