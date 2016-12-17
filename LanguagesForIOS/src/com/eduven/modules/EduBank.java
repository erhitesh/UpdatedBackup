package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.Reusables;


public class EduBank {
	
	
	/* Object Identification */
	public static By eduBankBtn = By.xpath("//UIAButton[@name='edubank'][1]");
	public static By eduBankHeaderTxt = By.name("EduBankHeader");
	public static By edubankDoneBtn = By.name("Done");
	public static By addFavBtn = By.id("AddFavourite");
	
	
	/**
	 * This method is used to get EduBank button instance.
	 * @return : IOSElement.
	 */
	public static IOSElement getEduBankBtnInstance(){
		
		return Reusables.getElementsList(eduBankBtn).get(0);
	}
	
	
	/**
	 * This method is used to navigate to the EduBank page.
	 */
	public static void navigateToEduBankPage(){
		try{
			Reusables.waitThread(3);
			Reusables.tapOnElementUsingLocator(eduBankBtn);
			/*Reusables.waitForIosElement(getEduBankBtnInstance());
			getEduBankBtnInstance().click();*/
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
			Reusables.waitThread(3);
			if (Reusables.isElementPresent(eduBankHeaderTxt) == true){
				Reusables.verifyElementPresent(Reusables.getElement(eduBankHeaderTxt), "Error Message!! EduBank Header text not found.");
				status = true;
			}
			else if (Reusables.isElementPresent(eduBankHeaderTxt) == false){
				Reusables.acceptAlert();
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Neither Alert nor EduBank header text are found. "+e.getClass().getName());
		}
		
		return status;
	}
	
	
	/**
	 * This method is used to submit the EduBank page.
	 */
	public static void submitEduBankPage(){
		try{
			Reusables.waitAndClick(edubankDoneBtn);
		}catch(NoSuchElementException e){
			Logs.error("Done Button not found in EduBank page. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to add term into EduBank.
	 * @param index : integer type for adding term in EduBank.
	 */
	public static void addTermInEduBank(int index){
		try{
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
			Reusables.waitThread(2);
			Reusables.verifyElementPresent(Reusables.getElement(By.xpath("//*[@value='"+expectedTermName+"']")), "Error Message!! Term Name not found.");
		}catch(NoSuchElementException e){
			Logs.error("Added Term not found in edubank. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify remove term from EduBank.
	 * @param expectedTermName : String value for comparison.
	 */
	public static void verifyTermInEduBankAfterRemove(String expectedTermName){
		List<IOSElement> list;
		try{
			/*list = Reusables.getElementsList(By.xpath("//*[@value='"+expectedTermName+"']"));
			Reusables.waitThread(3);
			if (list.size() > 0){
				Assert.fail("Remove term still exists.");
			}
			else if (list.size() < 0){
				Assert.assertTrue(list.size() < 0, "Remove term still exists");
			}*/
			list = Reusables.getElementsList(TermList.termNameTxt);
			for (int i = 0; i < list.size(); i++){
				if (list.get(i).getText().equalsIgnoreCase(expectedTermName)){
					Assert.fail("Error Message!Removed term still present in the edubank.");
				}
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
			List<IOSElement> favoriteBtns = Reusables.getElementsList(addFavBtn);
			favoriteBtns.get(favoriteBtns.size()-1).click();
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
			List<IOSElement> favoriteBtns = Reusables.getElementsList(addFavBtn);
			for (int i = 0; i < favoriteBtns.size(); i++){
				favoriteBtns.get(i).click();
				Reusables.waitThread(1);
			}
		}catch(NoSuchElementException e){
			Logs.error("Add Favorite Button is still visible. "+e.getClass().getName());
		}
	}
}
