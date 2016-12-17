package com.eduven.modules;

import java.util.List;

import io.appium.java_client.ios.IOSElement;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class TermDetailPage {

	
	/* Object Identification */  
	public static By termDetailPageHeaderTxt = By.id("Term_details_page_header");
	public static By category_name = By.id("Category Term Header");
	public static By termName = By.id("Term_name");
	public static By definitionLbltxt = By.xpath("//UIAStaticText[@name='Description']");//By.id("Description_header");
	public static By definitionMessageTxt = By.xpath("//UIATableCell[@name='Header_Value'][1]");//By.id("Description_text");
	public static By headerList = By.id("Header_Value");
	public static By editEdubankBtn = By.id("Add_to_edubank_button");
	public static By prevBtn = By.id("Previous_button");
	public static By nextBtn = By.id("Next_button");
	public static By playBtn = By.id("Play_button");
	public static By stopPlayBtn = By.id("Pause_button");
	public static By autoPlayBtn = By.id("Autoplay_button");
	public static By pauseAutoPlayBtn = By.id("Autoplay_stop_button");

	
	
	/**
	 * This method is used to get the Term name.
	 * @return : Title Name, type String
	 */
	public static String getTermName(){
		String termname = "";
		try{
			Reusables.waitThread(1);
			termname = Reusables.getText(termName).trim();
		}
		catch(NoSuchElementException e){
			Logs.error("Term Name not found.. "+e.getClass().getName());
		}
		return termname;
	}
	
	
    /**
     * This method is used to verify entity detail page loaded.
     */
    public static void verifyTermDetailPageLoaded(String expectedTermName){
        try{
        	Reusables.verifyEqualMessage(TermDetailPage.getTermName(), expectedTermName, "Error Message!!Select Term Name not found on term detail page.");
        }
        catch(NoSuchElementException e){
            Logs.error("Term Detail Page not loaded... "+e.getClass().getName());
        }
    }
	
	
	/**
	 * This method is used to get the entity Description.
	 * @return : Description, type String
	 */
	public static String getTermDescription(){
		String termDescription = "";
		try{
			termDescription = Reusables.getText(definitionMessageTxt);
		}
		catch(NoSuchElementException e){
			Logs.error("Term Description not found.. "+e.getClass().getName());
		}
		
		return termDescription;
	}
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Free Term Related >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> 
	/**
	 * This method is used to verify selected Term name on Term detail page.
	 */
	public static void verifyTermNameOnDetailPage(String termName){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(getTermName(), termName, "Error Message!!Term Name not matched...");
		}
		catch(NoSuchElementException e){
			Logs.error("Term Name not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to check the eduBank icon present or not
	 */
	public static void verifyEditEdubankButton(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(editEdubankBtn), "Error Message! Favourite icon not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Favourite icon not present "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the eduBank
	 */
	public static void clickOnEditEdubankButton(){
		try{
			Reusables.waitForIOSElement(editEdubankBtn);
			Reusables.clickCommand(editEdubankBtn);
		}
		catch(NoSuchElementException e){
			Logs.error("Edit EduBank page is not loaded.. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify free Term detail for favorite logo.
	 */
	public static void verificationForFreeTerm(String expectedTermName){
		verifyTermNameOnDetailPage(expectedTermName);
		checkDescriptionHeaderLbl();
		verifyEditEdubankButton();
	}
	
	/**
	 * This method is used to check description lbl.
	 */
	public static void checkDescriptionHeaderLbl(){
		try{
			Reusables.verifyElementPresent(Reusables.getIOSElement(definitionLbltxt), "Error Messgae! Description Header text not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Description Header not present. "+e.getClass().getName());
		}
	}
	
	
	// Audio control related
	/**
	 * This method is used to return the instance of Previous Button.
	 */
	public static IOSElement previousButtonInstance(){
		
		return Reusables.getIOSElement(prevBtn);
	}
	
	
	/**
	 * This method is used to return the instance of Next Button.
	 */
	public static IOSElement nextButtonInstance(){
		
		return Reusables.getIOSElement(nextBtn);
	}
	
	
	/**
	 * This method is used to return the instance of Speak Button.
	 */
	public static IOSElement speakButtonInstance(){
		
		return Reusables.getIOSElement(playBtn);
	}
	
	
	/**
	 * This method is used to return the instance of Stop Button.
	 */
	public static IOSElement stopButtonInstance(){
		
		return Reusables.getIOSElement(stopPlayBtn);
	}
	
	
	/**
	 * This method is used to return the instance of AutoPlay Button.
	 */
	public static IOSElement autoPlayButtonInstance(){
		
		return Reusables.getIOSElement(autoPlayBtn);
	}
	
	/**
	 * This method is used to return the instance of AutoPlay pause Button.
	 */
	public static IOSElement autoPlayPauseButtonInstance(){
		
		return Reusables.getIOSElement(pauseAutoPlayBtn);
	}
	
	/**
	 * This method is used to click on the Previous Button.
	 */
	public static void clickOnPreviousButton(){
		try{
			Reusables.clickUsingIOSElement(previousButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Previous Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Next Button.
	 */
	public static void clickOnNextButton(){
		try{
			Reusables.clickUsingIOSElement(nextButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("Next Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Play Button.
	 */
	public static void clickOnPlayButton(){
		try{
			Reusables.waitForIOSElement(speakButtonInstance());
			Reusables.clickUsingIOSElement(speakButtonInstance());
			//System.out.println(Reusables.getIOSElement(stop_play_btn).isEnabled());
		}
		catch(NoSuchElementException e){
			Logs.error("Speak Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Play Button to stop reading description..
	 */
	public static void clickOnStopPlayButton(){
		try{
			//System.out.println(Reusables.getIOSElement(stop_play_btn).isEnabled());
			Reusables.waitForIOSElement(Reusables.getIOSElement(stopPlayBtn));
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(stopPlayBtn));
		}
		catch(NoSuchElementException e){
			Logs.error("Stop Play Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Auto Play Button
	 */
	public static void clickOnAutoPlayButton(){
		try{
			Reusables.waitForIOSElement(autoPlayButtonInstance());
			Reusables.clickUsingIOSElement(autoPlayButtonInstance());
		}
		catch(NoSuchElementException e){
			Logs.error("AutoPlay Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the Auto Play Button
	 */
	public static void clickOnAutoPlayPauseButton(){
		try{
			Reusables.waitForIOSElement(Reusables.getIOSElement(pauseAutoPlayBtn));
			Reusables.clickUsingIOSElement(Reusables.getIOSElement(pauseAutoPlayBtn));
		}
		catch(NoSuchElementException e){
			Logs.error("AutoPlay Button not clickable... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify element Disable.
	 */
	public static void verifyElementBeforePlayBtnClick(){
		Reusables.verifyElementEnable(nextButtonInstance(), "Error Message!! Next Button still Disable.");
		Reusables.verifyElementEnable(previousButtonInstance(), "Error Message!! Previous Button still Disable.");
		Reusables.verifyElementEnable(autoPlayButtonInstance(), "Error Message!! AutoPlay Button still Disable.");
	}
	
	
	/**
	 * This method is used to verify element Disable.
	 */
	public static void verifyElementAfterPlayBtnClick(){
		Reusables.verifyElementDisable(previousButtonInstance(), "Error Message!! Next Button still Enable.");
		Reusables.verifyElementDisable(nextButtonInstance(), "Error Message!! Previous Button still Enable.");
		Reusables.verifyElementDisable(autoPlayButtonInstance(), "Error Message!! AutoPlay Button still Enable.");
	}
	

	/**
	 * This method is used to verify element enable before starting the auto play.
	 */
	public static void verifyElementBeforeAutoPlayStart(){
		Reusables.verifyElementEnable(nextButtonInstance(), "Error Message!! Next Button still Disable.");
		Reusables.verifyElementEnable(previousButtonInstance(), "Error Message!! Previous Button still Disable.");
		Reusables.verifyElementEnable(speakButtonInstance(), "Error Message!! Speak Button still Disable.");
		Reusables.verifyElementEnable(autoPlayButtonInstance(), "Error Message!! Speak Button still Disable.");
	}


	/**
	 * This method is used to verify element which are Disable by starting the auto play.
	 */
	public static void verifyElementAfterAutoPlayStart(){
		Reusables.verifyElementDisable(nextButtonInstance(), "Error Message!! Next Button still Enable.");
		Reusables.verifyElementDisable(previousButtonInstance(), "Error Message!! Previous Button still Enable.");
		Reusables.verifyElementDisable(stopButtonInstance(), "Error Message!!Stop play button still Enable.");
	}
	
	
	/**
	 * This method is used to submit the contribute later popup message.
	 */
	public static void submitContributeLaterPopupMessage(String termName){
		try{
			//Reusables.clickCommand("");
			Reusables.verifyElementPresent(Reusables.getIOSElement(By.id(termName)), "Error Message!! Entity Name not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Contribute Later btn still visible..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify element on the term detail page.
	 * @param categoryName : String type category name.
	 * @param termName : String type term inside category name.
	 */
	public static void verifyElementOnTermDetailPage(String categoryName, String termName){
		List<String> elementListValuesFromDB;
		List<IOSElement> elementFromApps;
		String headerName = "";
		/*try{
			list = DatabaseConnection.termDetailPageHeadingValue(categoryName, termName);
			for (int i = 0; i < list.size()-1; i++){
				elementValue = list.get(i);
				if (Reusables.isElementPresent(By.xpath("//UIATableCell[@value='"+elementValue+"']"))==false){
					Reusables.waitThread(5);
					System.out.println("Start Performing swiping");
					Reusables.customSwipeUp();
					System.out.println("Swiping performed");
					Reusables.waitThread(1);
				}
				System.out.println("Display status..."+Reusables.getIOSElement(By.xpath("//UIATableCell[@value='"+elementValue+"']")).isDisplayed());
				Reusables.verifyElementPresent(Reusables.getIOSElement(By.xpath("//UIATableCell[@value='"+elementValue+"']")), "Error Message!Element not found.");
				Logs.info("Term Elements are found. "+elementValue);
			}
		}catch(NoSuchElementException e){
			Logs.error("Element not found... "+elementValue+" "+e.getClass().getName());
		}*/
		try{
			elementListValuesFromDB = DatabaseConnection.termDetailPageHeadingValue(categoryName, termName);
			elementFromApps = Reusables.getIOSElementsList(headerList);
			for (int i = 0; i < elementListValuesFromDB.size()-1; i++){
				headerName = elementFromApps.get(i).getText().trim().toString();
				Reusables.verifyNotEqualMessage(elementListValuesFromDB.get(i), headerName, "Error Message!!Actual & Expected header value not matched.");
				Logs.info("Header Term value are matched.."+headerName);
			}
		}catch(NoSuchElementException e){
			Logs.error("Header value "+headerName+" not found. "+e.getClass().getName());
		}
	}
}
