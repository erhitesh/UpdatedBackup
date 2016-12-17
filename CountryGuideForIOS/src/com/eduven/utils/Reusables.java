package com.eduven.utils;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.HideKeyboardStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eduven.modules.EntityDetailPage;
import com.eduven.report.Logs;


public class Reusables {
  
	/* IosDriver Instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/* Object Identification */
	public static By industrialization = By.name("Close button");
	public static By cancel_button = By.name("cancel button");
	public static By for_element_count = By.xpath("//UIACollectionCell");
	public static By city_header_txt = By.name("CategoryHeader");
	public static By contributeCancelBtn = By.name("Cancel");
	public static By subCategoryTxt = By.name("SubCategoryTermName");
	public static By subCategoryHeaderTxt = By.name("SubCategoryHeader");
	public static By subcategoryTerms = By.name("TermName");
	
	
	/**
	 * This method is used to handle the adds.
	 */
	public static void hideIndustrialization(){
		try{
			/*if (isElementPresent(industrialization) == true){
				clickCommand(industrialization);
			}
			else if (isElementPresent(industrialization) == false){
				//System.out.println("Adds not visible.");
			}*/
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>Industrialization advertising still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method id used for wait for particular element.
	 * @param by element locator value
	 */
	public static void waitForElement(By by){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Wait for a element to be visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method id used for wait for particular IOSElement.
	 * @param element IOSELement
	 */
	public static void waitForIosElement(IOSElement element){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Wait for a element to be visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to wait for an alert to be visible.
	 */
	public static boolean waitForAlert(){
		int timeOutInSeconds = 60;
		boolean status = false;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
			status = true;
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Wait for alert element to be visible. "+e.getClass().getName());
		}
		
		return status;
	}
	
	/**
	 * this method is used to wait for a time explicitly.
	 */
	public static void waitThread(int timeOutInSeconds){
		try {
			Thread.sleep(timeOutInSeconds*1000);} 
		catch (InterruptedException e) {
		}
	}
	
	/**
	 * This method is used to verify element present or not
	 */
	public static boolean isElementPresent(By by){
		try{
			getElement(by);
			return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	/**
	 * This method is used to return the alert instance.
	 */
	public static Alert alertInstance(){
		Alert alert = null;
		waitForAlert();
		alert = driver.switchTo().alert();
		waitThread(2);
		
		return alert;
	}
	
	/**
	 * This method is used to get alert message.
	 * @return
	 */
	public static String getAlertMessage(){
		return alertInstance().getText();
	}
	
	/**
	 * This method is used to accept alert pop up.
	 */
	public static void acceptAlert(){
		try{
			alertInstance().accept();
			waitThread(1);
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>> Alert Not Accepted. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to wait for the alert pop up for visible.
	 */
	public static void waitForAlertPopup(){
		int timeOutInSeconds = 60;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to back one step.
	 */
	public static void stepBack(){
		waitThread(1);
		driver.navigate().back();
	}
	
	
	/**
	 * This method is used to forward one step.
	 */
	public static void stepForward(){
		driver.navigate().forward();
	}
	
	/**
	 * This method is used to switch to webview.
	 * @param webview : Integer type 
	 */
	public static void switchToWebView(int webview){
		waitThread(6);
		List<String> context_handles = new ArrayList<String>(driver.getContextHandles());
		driver.context(context_handles.get(webview));
		waitThread(3);
	}
    
	/**
	 * This method is used to perform tap operation
	 * @param by locator value
	 */
	public static void tap_on_element_using_locator(By by){
		IOSElement element = driver.findElement(by);
		driver.tap(1, element, 1000);
	}
	
	
	/**
	 * This method is used to perform tap operation
	 * @param fingers : how many finger, type int
	 * @param x : X axis point
	 * @param y : Y axis point
	 */
	public static void tap_on_element_using_coordinates(int fingers, int x, int y){
		try{
			driver.tap(fingers, x, y, 1000);
		}catch(NoSuchElementException e){
			Logs.error(">>>>>>> Tap does no perform on given coordinates..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the element using locator.
	 * @param by : locator type.
	 */
	 public static void clickCommand(By by){
		 try{
			 waitThread(2);
			 getElement(by).click();
			 }
		 catch(NoSuchElementException e){
			 
		 }
		 }
	 
	 /**
	  * This method is used to click on the element using String.
	  * @param name : String
	  */
	 public static void clickUsingString(String nameValue){
		 waitThread(1);
		 clickCommand(By.name(nameValue));
	 }
	 
	 /**
	  * This method is used to click on the element using IOSElement.
	  * @param element : IosElement.
	  */
	 public static void click_using_element(IOSElement element){
		 waitForIosElement(element);
		 element.click();
	 }
	 
	 /**
	  * This method is used to verify element count present.
	  * @param by : Locator type
	  */
	 public static void verifyElementCountExistance(By by){
		 int elementCount = Reusables.getElementsList(by).size();
		 if (elementCount >= 1){
			 System.out.println("Condition True.>");
			 Assert.assertTrue(elementCount >= 1, "Error Message!! Element count Less than one");
			 }
		 else{
			 System.out.println("Condition False.>");
			 Assert.assertFalse(elementCount < 1, "Error Message!! Element count Greater than one");
			 }
		 }

	 
	/**
	 * This method is used to get the text value of element
	 * @param by : locator type
	 * @return String value
	 */
	public static String getText(By by){
		return driver.findElement(by).getAttribute("name").toString().trim();
	}
	
	
	/**
	 * This method is used to get the text value of element
	 * @param by : locator type
	 * @return String value
	 */
	public static String getTextWithoutName(By by){
		return getElement(by).getText().toString().trim();
	}
	
	
	/**
	 * This method is used to get random number.
	 * @param number : int type parameter
	 * @return : int
	 */
	public static int randomNumber(int number){
		Random ran = new Random();
		
		return ran.nextInt(number);
	}
	

	/**
	 * For Custom swipe Up.
	 */
	public static void customSwipeUp(){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();	
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (height);
		int endx = width/2;
		int endy = (int) (height*0.4);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	
	/**
	 * For Custom swipe Up.
	 */
	public static void swipeUp(){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*0.8);
		int endx = width/2;
		int endy = (int) (height*0.2);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 * For Custom swipe Down.
	 */
	public static void swipeDown(){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*0.3);
		int endx = width/2;
		int endy = (int) (height*1.0);
		System.out.println(height);
		driver.swipe(startx, starty, endx, endy, 1000);
	}

	/**
	 * This method is used to Swipe Left.
	 */
	public static void swipeLeft(){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();//manage().window().getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = (int) (width*0.7);
		int starty = height/2;
		int endx = (int) (width*0.2);
		int endy = starty;
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	
	/**
	 * This method is used to swipe Right.
	 */
	public static void swipeRight(){
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = (int) (width*0.2);
		int starty = height/2;
		int endx = (int) (width*0.8);
		int endy = starty;
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 * This method is used to swipe left.
	 */
	public static void HorizontalLeftSwipe(By by){
		Point point = driver.findElement(by).getLocation();
		Dimension size = driver.findElement(by).getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int startx = width-20;
		int starty = point.getY() + height/2;
		int endx = startx/4;
		int endy = starty;
		//System.out.println("Startx..>"+startx+" Starty..>"+starty+" endx..>"+endx+" endy..>"+endy);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 * This method is used to Swipe Right.
	 */
	public static void HorizontalRightSwipe(By by){
		Point point = driver.findElement(by).getLocation();
		Dimension size = driver.findElement(by).getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int startx = width/4;
		int starty = point.getY() + height/2;
		int endx = width-40;
		int endy = starty;
		//System.out.println("Startx..>"+startx+" Starty..>"+starty+" endx..>"+endx+" endy..>"+endy);
		
		driver.swipe(startx, starty, endx, endy, 1000);
	}

	
	//********************************************************************

	/**
	 * This method is used to launch the app.
	 */
	public static void launchApp(){
		Reusables.waitThread(1);
		driver.launchApp();
	}
	
	/**
	 * This method is used to close the Appium current instance.
	 */
	public static void terminatesAppInstance(){
		driver.resetApp();
	}
	
	
	/**
	 * This method is used to run app in background for the specified time. 
	 * @param time : type int
	 */
	public static void runAppInBackground(int time){
		
		driver.runAppInBackground(time);
		Reusables.waitThread(time);
	}
	
	
	/**
	 * This method is used to enter text message in the text box
	 * @param by locator type
	 * @param txt String message text
	 */
	public static void enterMessageInTextBox(By by, String txt_msg){
		waitForElement(by);
		IOSElement element = getElement(by);
		element.click();
		element.sendKeys(txt_msg);
		Logs.info(">>>>>>>>>>> Enter the text message. "+txt_msg);
	}
	
	/**
	 * This method is used to used to hide keyboard.
	 * @param key : Type String
	 */
	public static void hideKeyboard(String key){
		try{
			waitThread(1);
			if (key.equalsIgnoreCase("done")){
				driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Done");
			}
			else if (key.equalsIgnoreCase("return")){
				driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "Return");
			}
			else if (key.equalsIgnoreCase("no key")){
				driver.hideKeyboard();
			}
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>> Keyboard is still opening.");
		}
	}
	
	/**
	 * This method is used to return the IOSElement
	 * @param by Locator type
	 * @return return element
	 */
	public static IOSElement getElement(By by){
		
		return driver.findElement(by);
	}
	
	
	/**
	 * This method is used to return the IOSElement list
	 * @param by Locator type
	 * @return return element
	 */
	public static List<IOSElement> getElementsList(By by){
		
		return driver.findElements(by);	
	}
	
	/**
	 * This method is used to verify premium entity.
	 * @param mainCategoryName : Main category name, type String.
	 * @param subCategoryName : Sub category name, type String.
	 */
	public static void checkPremiumEntity(String mainCategoryName, String subCategoryName){
		String paidTerm = "";
		String subCat = subCategoryName;
		paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCategoryName);
		while (paidTerm.length() == 0){
			Reusables.stepBack();
			subCat = clickOnRandomSubCategory(mainCategoryName);
			paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCat);
		}
		//System.out.println("Paid Term Name..."+paidTerm);
		waitThread(1);
		List<IOSElement> listData = getElementsList(subcategoryTerms);
		for (int i = 0; i < listData.size(); i++){
			if (listData.get(i).getText().equals(paidTerm) == true){
				listData.get(i).click();
				break;
			}
		}
		/* Wait for moment for enable the add...........*/
		waitThread(3);
		hideIndustrialization();
		if (getElement(cancel_button).isDisplayed()){
			EntityDetailPage.detailPageVerificationForPaidEntity();
			clickCommand(cancel_button);
			/* Wait for moment for enable the add...........*/
			waitThread(4);
			hideIndustrialization();
			}
		else {
			Logs.error(">>>>>>>>>>>>Paid Entity.. "+paidTerm+" not found. ");
			}
		}
	
	
	/**
	 * This method is used to verify free entity.
	 * @param mainCategoryName : Main category name, type String.
	 * @param subCategoryName : Sub category name, type String.
	 */
   public static void checkFreeEntity(String mainCategoryName, String subCategoryName ){
	   String freeTerm = DatabaseConnection.getUnlockTerms(mainCategoryName, subCategoryName);
	   //System.out.println("Free Term Name..."+freeTerm);
	   waitThread(1);
	   List<IOSElement> listData = getElementsList(subcategoryTerms);
		for (int i = 0; i < listData.size(); i++){
			if (listData.get(i).getText().equals(freeTerm) == true){
				listData.get(i).click();
				break;
			}
		}
	   /* Wait for moment for enable the add...........*/
	   waitThread(3);
	   hideIndustrialization();
	   if (isElementPresent(EntityDetailPage.favourite_icon) == true) {
		   EntityDetailPage.checkFavIcon();
		   stepBack();
		   }else {
			   Logs.error(">>>>>>>>>>>>>>>Free Entity. "+freeTerm + "Not Found.");
			}
		}
   
  
   /**
	 * This method is used to navigate to free entity page.
	 * @param mainCategoryName : Main category name, type String.
	 * @param subCategoryName : Sub category name, type String.
	 */
   public static String navigateToFreeEntityDetailPage(String mainCategoryName, String subCategoryName){
	   String freeTerm = DatabaseConnection.getUnlockTerms(mainCategoryName, subCategoryName);
       //System.out.println("Free Term Name..."+freeTerm);
	   List<IOSElement> listData = getElementsList(subcategoryTerms);
		for (int i = 0; i < listData.size(); i++){
			if (listData.get(i).getText().equals(freeTerm) == true){
				listData.get(i).click();
				break;
			}
		}
	   /* Wait for moment for enable the add...........*/
	   waitThread(3);
	   hideIndustrialization();
	   if (isElementPresent(EntityDetailPage.favourite_icon) == true) {
		   EntityDetailPage.checkFavIcon();
		   }else {
			   Logs.error(">>>>>>>>>>>>>>>Free Entity. "+freeTerm+" Not Found. ");
			}
	   
	   return freeTerm;
	   }
   
   
   /**
	 * This method is used to navigate to premium entity page.
	 * @param mainCategoryName : Main category name, type String.
	 * @param subCategoryName : Sub category name, type String.
	 */
   public static void navigateToPremiumEntityDetailPage(String mainCategoryName, String subCategoryName){
		String paidTerm = "";
		String subCat = subCategoryName;
		paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCategoryName);
		while (paidTerm.length() == 0){
			Reusables.stepBack();
			subCat = clickOnRandomSubCategory(mainCategoryName);
			paidTerm = DatabaseConnection.getLockTerms(mainCategoryName, subCat);
		}
		System.out.println("Paid Term Name..."+paidTerm);
		waitThread(1);
		List<IOSElement> listData = getElementsList(subcategoryTerms);
		for (int i = 0; i < listData.size(); i++){
			if (listData.get(i).getText().equals(paidTerm) == true){
				listData.get(i).click();
				break;
			}
		}
		/* Wait for moment for enable the add...........*/
		waitThread(3);
		hideIndustrialization();
		if (getElement(cancel_button).isDisplayed()){
			EntityDetailPage.detailPageVerificationForPaidEntity();
			/* Wait for moment for enable the add...........*/
			waitThread(4);
			hideIndustrialization();
			}
		else {
			Logs.error(">>>>>>>>>>>>Paid Entity.. "+paidTerm+" not found. ");
			}
		}
   
   /**
    * This method is used to generate random category.
    * @param by : Locator type.
    * @return : Return String as category.
    */
   public static String randomSubCategoryClick(By by){
	    int size = driver.findElements(by).size();
		int random_number = randomNumber(size);
		if(random_number == 0 || random_number == size -1){
			random_number = random_number + 1;
		}
		String xpath = "//UIACollectionCell["+random_number+"]";
		String random_name = driver.findElement(By.xpath(xpath)).getAttribute("name");
		while(! getElement(By.name(random_name)).isDisplayed()){
			if(size/2 > random_number){
				swipeDown();
				}
			else if (size/2 < random_number) {
					swipeUp();
			}
		}
		clickCommand(By.name(random_name));
	
		return random_name;
  }
   
   
   
   /**
    * This method is used to verify contribute entity either visible or not.
    */
   public static void verifyContributeEntity(){
	   try{
		   List<IOSElement> list = Reusables.getElementsList(for_element_count);
		   list.get(list.size()-1).click();
		   Reusables.waitForElement(contributeCancelBtn);
		   Reusables.clickCommand(contributeCancelBtn);
	   }
	   catch(NoSuchElementException e){
		   Logs.error("Contribute term not found. "+e.getClass().getName());
	   }
	   
	   }
   
   /**
    * This method is used to perform pinch opt.
    */
   public static void performPinch(By by){
	   try{
		  TouchAction action1 = new TouchAction(driver);
		  TouchAction action2 = new TouchAction(driver);
		 
		  action1.press(400, 800).moveTo(400, 900);
		  
		  action2.press(400, 1100).moveTo(400, 900);
		  
		  MultiTouchAction action = new MultiTouchAction(driver);
		  action.add(action1).add(action2);
		  
	   }catch(NoSuchElementException e){
		   Logs.error("Error Message!! Pinch operation not perform. "+e.getClass().getName());
	   }
   }
   
   /**
    *  This method is used to set network value.
    * @param airplaneMode : boolean type
    * @param wifi : boolean type
    * @param data : boolean type
    */
   public static void networkConnectionTest(){
	   Reusables.waitThread(3);
	   Reusables.customSwipeUp();
	   Reusables.clickCommand(By.name("Wi-Fi"));
	   Reusables.waitThread(2);
	   tap_on_element_using_coordinates(1, 130, 144);
   }
   
   /**
    * This method is used to checked paid term after network connection off.
    * expectedAlertMessage type : String
    */
   public static void verifyPaidTermOptAfterNetworkOff(String expectedAlertMessage){
	   try{
		   waitThread(2);
		   verifyEqualMessage(getAlertMessage(), expectedAlertMessage, "Error Message!! Alert Message not matched withe expected ones.");
		   acceptAlert();
		   }
	   catch(NoSuchElementException e){
		   Logs.error("Network Status message not shown. "+e.getClass().getName());
		   }
	   }
   
   
   /**
    * This method is used to generate random category.
    * @param by : Locator type.
    * @return : Return String as category.
    */
   public static String clickOnRandomSubCategory(String mainCategoryName){
	   String random_name = "";
		try{
			int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(mainCategoryName).size());
			random_name = DatabaseConnection.getSubCategoryList(mainCategoryName).get(randomNumber);
			//System.out.println("Random Name.."+random_name);
			Reusables.waitThread(2);
			List<IOSElement> listData = Reusables.getElementsList(subCategoryTxt);
			for (int i = 0; i < listData.size(); i++){
				//System.out.println("Status.."+listData.get(i).getText().equalsIgnoreCase(random_name));
				if (listData.get(i).getText().equalsIgnoreCase(random_name) == true){
					Reusables.waitThread(2);
					listData.get(i).click();
					break;
				}
			}
			}
		catch(NoSuchElementException e){
			Logs.error(mainCategoryName+" Category not found. "+random_name+ e.getClass().getName());
			}
		
	    return random_name;
	    }
   
   
	/**
	 * Verify the sub elements inside Main Category.
	 * @param mainCategory : String type for verification for sub category list.
	 */
	public static void verifySubCategoryList(String mainCategoryName) {
		IOSElement element;
		try{
			int elementCount = getElementsList(for_element_count).size();
			for (int i = 0; i < elementCount; i++) {
				element = getElement(By.name(DatabaseConnection.getSubCategoryList(mainCategoryName).get(i)));
				if (!element.isDisplayed()) {
					Reusables.waitThread(1);
					Reusables.swipeUp();
				}
				Reusables.waitForIosElement(element);
				Logs.info(mainCategoryName+"..> sub category..> "+element.getText()+" found. ");
				}
			}catch(NoSuchElementException e){
				Logs.error(mainCategoryName+" Sub Category not found. "+e.getClass().getName());
			}
		}
	
	
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	 /**
	  *This method is used to verify element enable or not.
	  *@param element : Type AndroidElement
	  *@param error : Type String, Error Message
	  */
	public static void verifyElementEnable(IOSElement element, String error_message){
		boolean element_status = element.isEnabled();
		try{
			Assert.assertTrue(element_status, error_message);
		}catch(NoSuchElementException e){
		}
		}
	
	 /**
	  *This method is used to verify element enable or not.
	  *@param element : Type AndroidElement
	  *@param error : Type String, Error Message
	  */
	public static void verifyElementDisable(IOSElement element, String error_message){
		boolean element_status = element.isEnabled();
		try{
			Assert.assertFalse(element_status, error_message);
		}catch(NoSuchElementException e){
		}
		}
	 
	/**
	 * This method is used to verify text present.
	 * @param element : IOSElement
	 * @param Message : String type
	 */
	public static void verifyElementPresent(IOSElement element, String Message){
		boolean status = element.isDisplayed();
		try{
			Assert.assertTrue(status, Message);
		}catch(NoSuchElementException e){

		}
	}
	
	
	/**
	 * This method is used to verify text not present.
	 * @param element : IOSElement
	 * @param Message : String type
	 */
	public static void verifyElementNotPresent(IOSElement element, String Message){
		boolean status = element.isDisplayed();
		try{
			Assert.assertFalse(status, Message);
		}catch(NoSuchElementException e){
		}
	}
	
	
	/**
	 * This method is used to verify the text that are same;
	 * @param actual_txt : String type
	 * @param expected_txt : String type
	 * @param error_msg : String type
	 */
	public static void verifyEqualMessage(String actual_txt, String expected_txt, String error_msg){
		String actual_txt_msg = actual_txt.toLowerCase();
		String expected_txt_msg = expected_txt.toLowerCase();
		try{
			Assert.assertEquals(actual_txt_msg, expected_txt_msg, error_msg);
		}catch(NoSuchElementException e){
		}
	}
	
	/**
	 * This method is used to verify text which are not same;
	 * @param actual_txt : String type
	 * @param expected_txt : String type
	 * @param error_msg : String type
	 */
	public static void verifyNotEqualMessage(String actual_txt, String expected_txt, String error_msg){
		String actual_txt_msg = actual_txt.toLowerCase();
		String expected_txt_msg = expected_txt.toLowerCase();
		try{
			Assert.assertNotEquals(actual_txt_msg, expected_txt_msg, error_msg);
		}catch(NoSuchElementException e){
		}
	}
	
	/**
	 * This method is used to click on city name inside term name.
	 */
	public static void clickOnCityNameInSideTermName(String cityName){
		try{
			waitThread(2);
			//System.out.println(Reusables.getElement(By.name(cityName)).isDisplayed());
			while (Reusables.getElement(By.xpath("//*[@name='"+cityName+"']")).isDisplayed() == false){
				waitThread(1);
				customSwipeUp(0.7f, 0.5f);
			}
			click_using_element(Reusables.getElement(By.xpath("//*[@name='"+cityName+"']")));
			waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error("City Name not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to get city header name.
	 * @return : String as city name.
	 */
	public static String getCityHeaderName(){
		String city_header_name= "";
		try{
			Reusables.waitForElement(city_header_txt);
			city_header_name = Reusables.getTextWithoutName(city_header_txt);
			//System.out.println("City Header text.."+city_header_name);
		}catch(NoSuchElementException e){
			Logs.error("City Header Name not found. "+e.getClass().getName());
		}
		
		return city_header_name;
	}
	
	/**
	 * This method is used to verify city header text.
	 * @param expectedName : for verification
	 */
	public static void verifyCityHeaderName(String expectedName){
		try{
			Reusables.verifyEqualMessage(getCityHeaderName(), expectedName, "Error Message!! Actual and Expected text not matched.");
		}catch(NoSuchElementException e){
			Logs.error("Actual and Expected text not matched. "+e.getClass().getName());
		}
	}
	
	/**
	 * For Custom swipe Up.
	 */
	public static void customSwipeUp(float startY, float endY){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		//System.out.println("Height.."+height+"StartY"+startY+"EndY"+endY);
		int startx = width/2;
		int starty = (int) (height*startY);
		int endx = width/2;
		int endy = (int) (height*endY);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 * This method is used to verify element present or not.
	 * @param text : For verify actual text contains sub text.
	 * @param by : Locator type for main text.
	 */
	public static void verifyContainsText(By by, String text){
		IOSElement element = Reusables.getElement(by);
		if (element.getText().contains(text) == true){
			Reusables.verifyElementPresent(element, "Error Message!! Element not present.");
		}
	}
	
	/**
	 * This method is used to draw line.
	 * @param by : locator type.
	 */
	public static void drawLine(By by){
		try{
			Reusables.waitThread(2);
			List<IOSElement> list = getElementsList(by);
			TouchAction action = new TouchAction(driver);
			Reusables.waitThread(3);
			action.longPress(list.get(0)).moveTo(list.get(1)).moveTo(list.get(2)).release().perform();
		}catch(NoSuchElementException e){
			Logs.error("Unable to draw the line for map. "+e.getClass().getName());
		}
	}
}