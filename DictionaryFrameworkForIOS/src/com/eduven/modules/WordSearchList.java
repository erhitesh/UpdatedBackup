package com.eduven.modules;

import io.appium.java_client.ios.IOSElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DatabaseConnection;
import com.eduven.utils.Reusables;


public class WordSearchList {
	

    /* Object Identification */
    public static By searchTxtBox = By.id("Search_bar");
    public static By termHeaderTxt = By.id("Terms_Header");
    public static By termList = By.id("Term_name");
    public static By indexList = By.id("");
    public static By indexListSize = By.id("");
    public static By termDetailHeaderTxt = By.id("Term_details_page_header");

    
    /**
     * This method id used to verify wordSearch list page header text.
     */
    public static void verifyWordSearchListPageLoaded(String expectedCategoryName){
        try{
        	Reusables.waitForIOSElement(termHeaderTxt);
        	Reusables.verifyElementTextPresent(termHeaderTxt, expectedCategoryName);
        }
        catch(NoSuchElementException e){
            Logs.error("Not navigate to the right page. "+e.getClass().getName());
        }
    }
    
    /**
     * This method id used to enter text into the search box.
     * @param search_word : enter text, Type String
     */
    public static void EnterText(String searchWord){
        try{
            Reusables.enterMessageInTextBox(searchTxtBox, searchWord, true, "no key");
           }
        catch(NoSuchElementException e){
            Logs.error("Search Box not present. "+e.getClass().getName());
        }
    }
    
    /**
     * This method is used to verify search word found.
     */
    public static void verifyRightSearch(String expectedSearchText){
    	List<IOSElement> termlist;
        try{
        	termlist = Reusables.getIOSElementsList(termList);
        	System.out.println(termlist.get(0).getText().trim());
        	for (int i = 0; i < termlist.size(); i++){
        		if (termlist.get(i).getText().trim().equalsIgnoreCase(expectedSearchText)){
        			Logs.info("Search word found. ");
        			break;
        		}
        	}
        	/*int countValue = Reusables.getIOSElementsList(By.name(expectedSearchText)).size();
        	//System.out.println("Count Value... "+countValue);
        	if (countValue == 2){
        		//System.out.println(Reusables.getIOSElementsList(By.name(expectedSearchText)).get(0).getText());
        		Reusables.verifyEqualMessage(Reusables.getIOSElementsList(By.name(expectedSearchText)).get(0).getText(), expectedSearchText, "Error Message!! Search word not found...");
        	}*/
        }
        catch(NoSuchElementException e){
            Logs.error("Search word not found.."+e.getClass().getName());
        }
    }
    
    /**
     * This method is used to verify that search word not found.
     */
    public static void verifyWrongSearch(String expectedSearchText){
    	List<IOSElement> termlist;
        try{
        	termlist = Reusables.getIOSElementsList(termList);
        	for (IOSElement element : termlist){
        		if (element.getText().trim().equalsIgnoreCase(expectedSearchText)){
        			Assert.assertFalse(element.getText().equalsIgnoreCase(expectedSearchText), "Error Message!Wrong search word found.");
        		}
        	}
        	/*boolean status = Reusables.getIOSElement(By.name(expectedSearchText)).isDisplayed();
        	if (status == true){
        		Logs.error("Element found...");
        		}
        	else{
        		Logs.warn("Done");
        	}*/
        }
        catch(NoSuchElementException e){
            Logs.error("Wrong text found. "+e.getClass().getName());
        }
    }
    
    /**
     *  This method is used to verify index list present.
     */
    public static void verifyIndexList(){
        try{
        	Reusables.waitForIOSElement(indexList);
            Reusables.verifyElementPresent(Reusables.getIOSElement(indexList), "Error Message!! Index list not visible.");
        }
        catch(NoSuchElementException e){
            Logs.error("Index List not present.. "+e.getClass().getName());
        }
    }
    
    /**
     * This method is used to return the random value.
     */
    public static String indexRandomValue(){
        String randomValue = "";
        try{
            List<IOSElement> element_list = Reusables.getIOSElementsList(indexListSize);
            int list_size = Reusables.elementCount(indexListSize);
            int random_number = Reusables.randomNumber(list_size);
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
        try{
            if (selected_index_count == 2){
            	Reusables.clickUsingIOSElement(Reusables.getIOSElementsList((By.name(indexValue))).get(1));
            }
            else if (selected_index_count < 2) {
            	Reusables.clickUsingIOSElement(Reusables.getIOSElementsList((By.name(indexValue))).get(0));
            }
        }
        catch(NoSuchElementException e){
            Logs.error("Index value not found... "+e.getClass().getName());
        }
        
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
            Logs.error("Selected Index not found. "+e.getClass().getName());
        }
    }
    
    /**
     * This method is used to verify term name list on term page.
     * @param categoryName : String type.
     */
    public static void verifyTermNameList(String categoryName){
    	String termName = "";
    	List<IOSElement> termNameList;
    	List<String> dbTermNameList;
    	try{
    		dbTermNameList = DatabaseConnection.getTermList(categoryName);
    		termNameList = Reusables.getIOSElementsList(termList);
    		for (int i = 0; i < termNameList.size(); i++){
    			termName = termNameList.get(i).getText().trim();
    			Reusables.verifyEqualMessage(dbTermNameList.get(i).trim(), termName, "Error Messsage!Actual & Expected Term Name not matched.");
    		}
    	}catch(NoSuchElementException e){
    		Logs.error("Term Name "+termName+" found. "+e.getClass().getName());
    	}
    }
    
    
    /**
     * 
     * @param categoryName
     * @return
     */
    public static String clickOnLockTerm(String categoryName){
    	String lockTermName = "";
    	List<IOSElement> termlist;
    	try{
    		termlist = Reusables.getIOSElementsList(termList);
    		lockTermName = DatabaseConnection.getLockTerm(categoryName);
    		for (IOSElement ele : termlist){
    			if (ele.getText().trim().equalsIgnoreCase(lockTermName)){
    				ele.click();
    				Reusables.waitThread(2);
    			}
    		}
    	}catch(NoSuchElementException e){
    		Logs.error("Lock term not found. "+e.getClass().getName());
    	}
    	
    	return lockTermName;
    }
    

    /**
     * This method is used to click on entity name on word search list page.
     */
    public static String navigateToTermDetailPage(String categoryName){
        String termName = "";
        List<IOSElement> termListElement;
        try{
        	termName = DatabaseConnection.getUnLockTerm(categoryName);
        	termListElement = Reusables.getIOSElementsList(termList);
        	for (IOSElement ele : termListElement){
        		if (ele.getText().trim().equalsIgnoreCase(termName)){
        			ele.click();
        			break;
        		}
        	}
            Reusables.waitThread(2);
            Reusables.hideInterstitial();
            TermDetailPage.verifyTermDetailPageLoaded(termName);
            Reusables.waitThread(2);
        }catch(NoSuchElementException e){
            Logs.error("Term Detail Page not found.. "+e.getClass().getName());
        }
        
        return termName;
        
    }
    
    /**
     * This method is used to click on entity name on word search list page.
     */
    public static String navigateToTermDetailPageForAudio(String categoryName){
        String termName = "";
        List<IOSElement> termListElement;
        try{
        	termName = DatabaseConnection.getTermWithLargerTxt(categoryName);
        	termListElement = Reusables.getIOSElementsList(termList);
        	for (IOSElement ele : termListElement){
        		if (ele.getText().trim().equalsIgnoreCase(termName)){
        			ele.click();
        			break;
        		}
        	}
            Reusables.waitThread(2);
            Reusables.hideInterstitial();
            TermDetailPage.verifyTermDetailPageLoaded(termName);
            Reusables.waitThread(2);
        }catch(NoSuchElementException e){
            Logs.error("Term Detail Page not found.. "+e.getClass().getName());
        }
        
        return termName;
        
    }
}
