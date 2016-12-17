package com.eduven.utils;

import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.HideKeyboardStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eduven.modules.SplashScreen;
import com.eduven.report.Logs;


public class Reusables {
  
	/* IosDriver Instance */
	public static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	/**
	 * This method is used to handle the adds.
	 */
	public static void hideInterstetial(){
		try{
			Reusables.waitThread(4);
			if (isElementPresent(SplashScreen.interstetial) == true){
				clickCommand(SplashScreen.interstetial);
			}
			else if (isElementPresent(SplashScreen.interstetial) == false){
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Industrialization advertising still visible. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to wait for an element till complete the DOM loading.
	 * @param timeout : wait for time amount.
	 */
	public static void implicitlyWait(int timeOut){
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
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
			//Logs.error(">>>>>>>>> Wait for a element to be visible. "+e.getClass().getName());
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
			Logs.error("Wait for a element to be visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to wait for an alert to be visible.
	 */
	public static void waitForAlert(){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>> Wait for alert element to be visible. "+e.getClass().getName());
			}
		}
	
	/**
	 * This method is used to wait for a moment explicitly.
	 * @param timeOutInSeconds : wait amount time, type integer.
	 */
	public static void waitThread(int timeOutInSeconds){
		try {
			Thread.sleep(timeOutInSeconds*1000);
			} 
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
	 * This method is used to verify element present or not
	 * @param element : for 
	 */
	public static boolean isElementPresent(IOSElement element){
		try{
			element.isDisplayed();
			return true;
			}
		catch(NoSuchElementException e){
			return false;
			}
		}
	
	
	/**
	 * This method is used to verify element enable or not
	 * @param element : for 
	 */
	public static boolean isElementEnable(By by){
		try{
			getElement(by).isEnabled();
			return true;
			}
		catch(NoSuchElementException e){
			return false;
			}
		}
	
	/**
	 * This method is used to verify element enable or not
	 * @param element : for 
	 */
	public static boolean isElementEnable(IOSElement element){
		try{
			element.isEnabled();
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
		//waitThread(2);
		waitForAlert();
		alert = driver.switchTo().alert();
		waitThread(2);
		
		return alert;
	}
	
	/**
	 * This method is used to get alert message.
	 * @return : String as alert text.
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
	 * This method is used to dismiss alert pop up.
	 */
	public static void dismissAlert(){
		try{
			alertInstance().dismiss();
			waitThread(1);
			}
		catch(NoSuchElementException e){
			Logs.error(">>>>> Alert Accepted. "+e.getClass().getName());
			}
		}
	
	
	/**
	 * This method is used to wait for alert popup.
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
	 * This method is used to perform one step back from current position.
	 */
	public static void stepBack(){
		waitThread(2);
		driver.navigate().back();
	}
	
	
	/**
	 * This method is used to perform one step forward from current position.
	 */
	public static void stepForward(){
		waitThread(1);
		driver.navigate().forward();
	}
	
	
	/**
	 * This method is used to switch from APP view to WebView.
	 * @param webview
	 */
	public static void switchToWebView(int webview){
		waitThread(6);
		List<String> context_handles = new ArrayList<String>(driver.getContextHandles());
		driver.context(context_handles.get(webview));
		waitThread(3);
	}
    
	
	/**
	 * This method is used to perform tap operation
	 * @param by : locator value
	 */
	public static void tapOnElementUsingLocator(By by){
		IOSElement element = getElement(by);
		Reusables.waitThread(2);
		driver.tap(1, element, 1000);
	}
	
	
	/**
	 * This method is used to perform tap operation
	 * @param fingers : how many finger, type int
	 * @param x : X axis point
	 * @param y : Y axis point
	 */
	public static void tapOnElementUsingCoordinate(int fingers, int x, int y){
		try{
			driver.tap(fingers, x, y, 1000);
			}
		catch(NoSuchElementException e){
			Logs.error("Tap does no perform on given coordinates..."+e.getClass().getName());
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
		 clickCommand(By.name(nameValue));
	 }
	 
	 /**
	  * This method is used to click on the element using IosElement.
	  * @param element : IosElement.
	  */
	 public static void clickUsingElement(IOSElement element){
		 Reusables.waitThread(2);
		 element.click();
	 }
	 
	 
	 /**
	  * This method is used to wait and click on the element.
	  * @param by : Locator type, for performing click and wait action.
	  */
	 public static void waitAndClick(By by){
		 int timeOutInSeconds = 60;
		 try{
			 Reusables.waitThread(timeOutInSeconds);
			 List<IOSElement> list = getElementsList(by);
			 if (list.size() >= 1){
				 list.get(0).click();
			 }
			 else { 
				 Logs.error("Click Operation not perform on this element.");
			 }
			 }
		 catch(NoSuchElementException e){
			 Logs.error("Wait for a element and perform click operation on this element. "+e.getClass().getName());
			 }
		 }
	 
	 /**
	  * This method is used to verify element count present.
	  * @param by : Locator type
	  * @param status : for checking condition inside method.
	  */
	 public static void verifyElementCountExistance(By by, boolean status){
		 int elementCount = 0;
		 try{
			 elementCount = Reusables.getElementsList(by).size();
			 //System.out.println("Element Count..>"+elementCount);
			 if (status == true && elementCount > 0){
				 Assert.assertTrue(elementCount >= 1, "Error Message!! Element not exists.");
			 }
			 else if (status == false && elementCount < 0){
				 Assert.assertFalse(elementCount < 0, "Error Message!! Element exists.");
			 }
		 }catch(NoSuchElementException e){
			 
		 }
		 }
	 
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
			Logs.error(e.getClass().getName());
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
			Logs.error(e.getClass().getName());
		}
		}
	 
	/**
	 * This method is used to verify text present.
	 * @param element : IOSElement
	 * @param Message : String type
	 */
	public static boolean verifyElementPresent(IOSElement element, String Message){
		boolean status = element.isDisplayed();
		try{
			Assert.assertTrue(status, Message);
			status = true;
		}catch(NoSuchElementException e){
		}
		
		return status;
	}
	
	
	/**
	 * This method is used to verify text not present.
	 * @param element : IOSElement
	 * @param Message : String type
	 */
	public static void verifyElementNotPresent(IOSElement element, String Message){
		boolean status = false;
		try{
			status = element.isDisplayed();
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
			Logs.error(e.getClass().getName());
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
			Logs.error(e.getClass().getName());
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
	 * This method is used to get the text value of element.
	 * @param element : IOSElement as locator value.
	 * @return : String value, as text.
	 */
	public static String getText(IOSElement element){
		return element.getText().toString().trim();
	}
	
	
	/**
	 * This method is used to generate random number.
	 * @param number : int type.
	 * @return : 
	 */
	public static int randomNumber(int number){
		Random ran = new Random();
		
		return ran.nextInt(number);
	}
	

	public static void scrollToExact(String name){
		waitThread(1);
		driver.scrollToExact(name);
	}
	
	/**
	 * This method is used to click using scroll to exact text.
	 * @param name : Type String, on which element you want to click.
	 */
	public static void clickUsingScrollToExactText(String name){
		waitThread(1);
		driver.scrollToExact(name).click();
	}
	
	public static ArrayList<String> getCategoryList(String list, String string_separator){
		
     ArrayList<String> cat=new ArrayList<String>(Arrays.asList(list.split(string_separator)));

		return cat;
	}
	
	/**
	 * For Custom swipe Up.
	 */
	public static void customSwipeUp(){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();	
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height);
		int endx = width/2;
		int endy = (int) (height*0.7);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	
	/**
	 * For Custom swipe Up.
	 */
	public static void swipeUp(){
		Dimension size = driver.manage().window().getSize();//findElement(By.className("UIAWindow")).getSize();	
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*0.8);
		int endx = width/2;
		int endy = (int) (height*0.2);
		driver.swipe(startx, starty, endx, endy, 3000);
		waitThread(3);
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
		//System.out.println(height);
		driver.swipe(startx, starty, endx, endy, 1000);
	}

	/**
	 * This method is used to Swipe Left.
	 */
	public static void swipeLeft(){
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = (int) (width*0.7);
		int starty = (int) (height/2);
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
		int starty = (int) (height/2);
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
	
	/**
	 * This method is used to draw line.
	 */
	public static void drawLine(){
		try{
			Reusables.waitThread(2);
			TouchAction action = new TouchAction(driver);
			action.press(100, 300).moveTo(100, 600).perform();
		}catch(NoSuchElementException e){
			Logs.error(""+e.getClass().getName());
		}
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
		/*try {
			DriverInstance.recorder.stop();
		} catch (ATUTestRecorderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
	 * This method is used to perform click operation on delete key in IOS Keyboard.
	 */
	public static void performClickOnDeleteKey(){
		try{
			Reusables.waitThread(2);
			Reusables.clickCommand(SplashScreen.deleteKey);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on delete key. "+e.getClass().getName());
		}
		}
	
	
	/**
	 * This method is used to enter text message in the text box
	 * @param by locator type
	 * @param txt String message text
	 */
	public static void enterMessageInTextBox(By by, String txt_msg){
		IOSElement element = getElement(by);
		element.click();
		element.sendKeys(txt_msg);
		Reusables.waitThread(1);
		hideKeyboard("no key");
		Logs.info(">>>>>>>>>>> Entered text is. "+txt_msg);
	}
	
	/**
	 * This method is used to enter character in the text box using keyboard.
	 * @param keyName : Key Name, type String
	 */
	public static void enterTextUsingKeyBoard(String keyName, By by){
		try{
			//IOSElement element;
			getElement(by).click();
			getElement(by).sendKeys(keyName);
			performClickOnDeleteKey();
			hideKeyboard("no key");
			/*for (int i = 0; i < keyName.length(); i++){
				if (keyName.charAt(i) == ' '){
					Reusables.clickCommand(SplashScreen.spaceKey);
					Reusables.waitThread(1);
				}
				element = getElement(By.xpath("//*[@name='"+keyName.charAt(i)+"']"));
				element.click();
				//System.out.println("Enter charater term are."+keyName.charAt(i));
			}*/
		}catch(NoSuchElementException e){
			Logs.error("Key Name Not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to used to hide keyboard.
	 * @param key : Type String
	 */
	public static void hideKeyboard(String key){
		try{
			waitThread(1);
			if (DeviceRelatedInformation.deviceType().contains("iphone")){
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
			else if (DeviceRelatedInformation.deviceType().equalsIgnoreCase("ipad")){
				Reusables.clickCommand(SplashScreen.hideKeyboardBtn);//By.id("Hide keyboard");
				Reusables.waitThread(2);
				/*driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "HIDE_KEYBOARD");
				driver.hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE, "true");*/
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
	 * This method is used to return the IOSElement
	 * @param element : IOSElement.
	 * @return return element
	 */
	public static IOSElement getElement(IOSElement element){
		
		return element;
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
    * This method is used to generate random category.
    * @param by : Locator type.
    * @return : Return String as category.
    */
   public static String randomSubCategoryClick(By by){
	    int size = driver.findElements(by).size();
	    System.out.println("Size..."+size);
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
	   By add_contribute_cell = By.name("Add");
	   IOSElement element = Reusables.getElement(add_contribute_cell);
	   try{
		   while (!element.isDisplayed()){
			   swipeUp();
			   }
		   Reusables.verifyElementPresent(element, "Error Message!! Contribute Entity Name not found.");
		   }
	   catch(NoSuchElementException e){
		   Logs.error("Error Message! Contribute entity not found in this category. "+e.getClass().getName());
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
    */
   public static void networkConnectionStatus(){
	   Reusables.waitThread(3);
	   Reusables.customSwipeUp();
	   Reusables.customSwipeUp();
	   Reusables.clickCommand(By.name("Wi-Fi"));
	   Reusables.waitThread(2);
	   Reusables.clickUsingElement(Reusables.getElement(SplashScreen.hideUIAWindowForWifi));
	   tapOnElementUsingCoordinate(1, 130, 144);
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
    *  This method is used to set network value.
    * @param airplaneMode : boolean type
    * @param wifi : boolean type
    * @param data : boolean type
    */
   public static void networkConnectionTest(){
	   driver.runAppInBackground(10);
	   Reusables.waitThread(1);
	   while (Reusables.isElementPresent(By.name("Wi-Fi")) == false){
		   Reusables.customSwipeUp();
		   Reusables.clickCommand(By.name("Wi-Fi"));
	   }   
	   Reusables.waitThread(2);
	   Reusables.tapOnElementUsingCoordinate(1, 130, 144);
   }
   
   
	/**
	 * This method is used to verify connection relates problem.
	 */
	public static void verifyConnectionRelatedError(By by){
		try{
			Reusables.waitThread(2);
			Reusables.verifyElementEnable(Reusables.getElement(by), "Error Message!!Connectivity related issue not coming.");
		}catch(NoSuchElementException e){
			Logs.error("Connectivity related issue not coming. "+e.getClass().getName());
		}
	}
	
	 /**
	  * This method is used to verify either actual text contains expected character.
	  * @param by : locator type.
	  * @param expectedText : for checking character found in actual text.
	  */
	 public static void verifyElementTextPresent(By by, String expectedText){
		 String actualText = "";
		 String expectedCharacter = expectedText;
		 try{
			 actualText = Reusables.getText(by);
			 Assert.assertTrue(actualText.contains(expectedCharacter), "Error Message!! Expected Character not found in actual text");
		 }catch(NoSuchElementException e){
		 }
	 }
	 
		/**
		 * This method is used to verify either page loaded or not.
		 * @param pageHeaderTxt : String for verify either page text matched or not.
		 */
		public static void verifyPageLoaded(By by, String pageHeaderTxt){
			try{
				Reusables.waitForElement(by);
				Reusables.verifyElementTextPresent(by, pageHeaderTxt);
			}catch(NoSuchElementException e){
				Logs.error("Page not loaded. "+e.getClass().getName());
			}
		}
}