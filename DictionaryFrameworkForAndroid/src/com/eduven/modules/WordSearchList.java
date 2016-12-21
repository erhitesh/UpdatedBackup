package com.eduven.modules;

import io.appium.java_client.android.AndroidElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.Reusables;

public class WordSearchList {
	
	
	/* Object Identification */
	public static By searchTxtBox = By.id(DeviceRelatedInformation.getPackageName()+":id/searchterm");
	public static By contributeBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/contributeButton");
	public static By elementCount = By.id(DeviceRelatedInformation.getPackageName()+":id/arrow_mean");
	public static By termCount = By.id(DeviceRelatedInformation.getPackageName()+":id/text_value");
	public static By indexLayout = By.id(DeviceRelatedInformation.getPackageName()+":id/side_index");
	public static By indexList = By.id(DeviceRelatedInformation.getPackageName()+":id/side_list_item");
	public static By descriptionLblTxt = By.id(DeviceRelatedInformation.getPackageName()+":id/text_label");
	public static By addToFavouriteBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/add_to_favorites");
	
	
	/**
	 * This method id used to verify wordSearch list page header text.
	 */
	public static void verifyWordSearchPageLoaded(String categoryName){
		try{
			Reusables.waitForElement(By.name(categoryName));
			Reusables.verifyElementPresent(Reusables.getElement(By.name(categoryName)), "Error Message!!Word Search Page not loaded.");
		}
		catch(NoSuchElementException e){
			Logs.error("Word Search Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used to enter text into the search box.
	 * @param searchWord : enter text, Type String
	 */
	public static void EnterText(String searchWord){
		try{
			Reusables.waitForElement(searchTxtBox);
			Reusables.enterMessageInTextBox(searchTxtBox, searchWord);
			}
		catch(NoSuchElementException e){
			Logs.error("Search Box not present.."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify search word found.
	 */
	public static void verifyRightSearch(){
		try{
			Reusables.waitThread(3);
			Reusables.verifyElementPresent(Reusables.getElement(elementCount), "Error Message!! Search word count not found...");
		}
		catch(NoSuchElementException e){
			Logs.error("Search word not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify that search word not found.
	 */
	public static void verifyWrongSearch(){
		try{
			Reusables.waitForElement(contributeBtn);
			Reusables.verifyElementPresent(Reusables.getElement(contributeBtn), "Error Message!! Contribute button not found..");
		}
		catch(NoSuchElementException e){
			Logs.error("Search term found. "+e.getClass().getName());
		}
	}
	
	/**
	 *  This method is used to verify index list present.
	 */
	public static void verifyIndexList(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(indexLayout), "Error Message!! Index list not visible.");
		}
		catch(NoSuchElementException e){
			Logs.error("Index List not present..."+e.getClass().getName());
		}
	}

	/**
	 * This method is used to return the random value.
	 */
	public static String indexRandomValue(){
		String randomValue = "";
		try{
			List<AndroidElement> element_list = Reusables.getElementsList(indexList);
			//int list_size = Reusables.elementCount(index_list_size);
			int random_number = Reusables.randomNumber(element_list.size()-1);
			//System.out.println("Random Number.."+random_number);
			randomValue = element_list.get(random_number).getAttribute("name").trim().toString();
			//System.out.println("Random value.."+randomValue);
			}
		catch(NoSuchElementException e){
			Logs.error("Value not found,,, "+e.getClass().getName());
			}
		
		return randomValue;
	}
	
	/**
	 * This method is used to click on random index list.
	 * @param indexValue : Type int.
	 * @return total count value of selected index.
	 */
	public static int clickOnIndexListElements(String indexValue){
		int selected_index_count = 0;
		List<AndroidElement> list = Reusables.getElementsList(By.name(indexValue));
		selected_index_count = list.size();
		try{
			if (selected_index_count == 2){
				list.get(1).click();
				//Reusables.clickUsingElement(Reusables.getElementsList((By.name(indexValue))).get(1));
				}
			else if (selected_index_count < 2) {
				list.get(0).click();
				//Reusables.clickUsingElement(Reusables.getElementsList((By.name(indexValue))).get(0));
				}
			selected_index_count = Reusables.getElementsList(By.name(indexValue)).size();
			}
		catch(NoSuchElementException e){
			Logs.error("Index value not found... "+e.getClass().getName());
			}
		//System.out.println("selected_index_count..>"+selected_index_count);
		return selected_index_count;
	}
	
	/**
	 * This method is used to verify index selected value.
	 */
	public static void verifySelectedIndexValue(String indexValue, int indexNumberOccurance){
		By selected_index_count = By.name(indexValue);
		try{
			Reusables.verifyEqualMessage(String.valueOf(Reusables.elementCount(selected_index_count)), String.valueOf(indexNumberOccurance), "Error Message!!Selected index value not matched with expected ones.");
		}
		catch(NoSuchElementException e){
			Logs.error("Selected Index Value not matched with Expected ones. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on entity name on word search list page.
	 */
	public static String navigateToTermDetailPage(String categoryName){
		String dbTermName = "";
		List<AndroidElement> indexListSize;
		List<AndroidElement> termList;
		try{
			dbTermName = DatabaseConnection.getUnLockTerm(categoryName);
			System.out.println("Term Name..."+dbTermName);
			indexListSize = Reusables.getElementsList(indexList);
			for (int i = 0; i < indexListSize.size(); i++){
				if (indexListSize.get(i).getText().trim().equalsIgnoreCase(dbTermName.charAt(0)+"".trim())){
					indexListSize.get(i).click();
					break;
				}
			}
			termList = Reusables.getElementsList(termCount);
			while (!Reusables.isElementPresent(By.name(dbTermName))){
				Reusables.waitThread(2);
				Reusables.swipeUp(termList.get(termList.size()-1), termList.get(2));
				Reusables.waitThread(1);
			}
			Reusables.clickCommand(By.name(dbTermName));	
				/*while (!termList.get(i).getText().trim().equalsIgnoreCase(dbTermName)){
					Reusables.swipeUp(termList.get(termList.size()-1), termList.get(0));
					Reusables.waitThread(1);
					break;
				}*/
			
			/*int elementSize = Reusables.elementCount(termCount);
			for (int i = 0; i < elementSize; i++){
				categorySubEntityName = Reusables.getTextFromList(termCount, i);
				Reusables.clickUsingElementList(Reusables.getElementsList(termCount), i);
				Reusables.waitThread(1);
				if (Reusables.isElementPresent(descriptionLblTxt) == true){
					Reusables.waitThread(1);
					break;
				}
				else if (Reusables.isElementPresent(descriptionLblTxt) == false){
				}
				else if (Reusables.isElementPresent(TermDetailPage.unlockNowBtn) == true) {
					Reusables.stepBack();
					Reusables.waitForElement(TermDetailPage.contributeLaterBtn);
					Reusables.clickUsingElement(Reusables.getElement(TermDetailPage.contributeLaterBtn));
					 Hide Interstitial 
					Reusables.hideInterstetial();
				}
			}*/
		}catch(NoSuchElementException e){
			Logs.error("Not navigate to Term page.. "+e.getClass().getName());
		}
		
		return dbTermName.trim();
	}
	
	/**
	 * This method is used to verify term detail page loaded.
	 */
	public static void verifyTermDetailPageLoaded(){
		try{
			Reusables.waitForElement(addToFavouriteBtn);
			Reusables.verifyElementPresent(Reusables.getElement(TermDetailPage.termName), "Error Message!!Term Detail Page not loaded.");
		}
		catch(NoSuchElementException e){
			Logs.error("Term Detail Page not loaded. "+e.getClass().getName());
		}
	}
	
    /**
     * This method is used to click on term name on word search list page.
     */
    public static String navigateToTermDetailPageForAudio(String categoryName){
        String termName = "";
        List<AndroidElement> termListElement;
        try{
        	termName = DatabaseConnection.getTermWithLargerTxt(categoryName);
        	termListElement = Reusables.getElementsList(termCount);
        	for (AndroidElement ele : termListElement){
        		if (ele.getText().trim().equalsIgnoreCase(termName)){
        			ele.click();
        			break;
        		}
        	}
            Reusables.waitThread(2);
            Reusables.hideInterstetial();
            TermDetailPage.verifyTermNameOnTermDetailPage(termName);
            Reusables.waitThread(2);
        }catch(NoSuchElementException e){
            Logs.error("Term Detail Page not found.. "+e.getClass().getName());
        }
        
        return termName;
        
    }
}
