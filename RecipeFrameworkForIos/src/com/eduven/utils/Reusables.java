package com.eduven.utils;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.HideKeyboardStrategy;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eduven.modules.Courses;
import com.eduven.modules.InAppPurchase;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TasteBud;
import com.eduven.report.Logs;


public class Reusables {
  
	
	/* IosDriver instance */
	static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	
	
	/**
	 * This method is used to hide the Interstitial.
	 */
	public static void hideInterstitial(){
		Reusables.waitThread(2);
		try{
			if (isElementPresent(SplashScreen.interstitialCloseBtn) == true){
				clickCommand(SplashScreen.interstitialCloseBtn);
			}else{
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Industrialization advertising still visible. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method id used for wait for particular element.
	 * @param by element locator value
	 */
	public static void waitForIOSElement(By by){
		int timeOutInSeconds = 30;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(NoSuchElementException e){
			Logs.info("Elemement not found Exception. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * this method id used for wait for particular IOSElement.
	 * @param element IOSElement
	 */
	public static void waitForIOSElement(IOSElement element){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to wait for an alert to be visible.
	 * 
	 */
	public static void waitForAlert(){
		int timeOutInSeconds = 30;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>> Alert Not Present,.."+e.getClass().getName());
		}
	}
	
	/**
	 * this method is used to wait for a time explicitly.
	 * @param timeOutInSeconds: type int(seconds)
	 */
	public static void waitThread(int timeOutInSeconds){
		try {
			Thread.sleep(timeOutInSeconds*1000);} 
		catch (InterruptedException e) {
			Logs.error(">>>>> Element not present... "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify element present or not.
	 * @param by : Locator type.
	 * @return : Return boolean value either true or false.
	 */
	public static boolean isElementPresent(By by){
		try{
			getIOSElement(by);
			return true;
		}
		catch(NoSuchElementException e){
			return false;
		}
	}
	
	public static boolean elementVisiblity(By by){
		boolean status = false;
		try{
			if (getIOSElement(by).isDisplayed()){
				status = true;
			}
			else {
				status = false;
			}
			System.out.println("Element Status.."+status);
		}catch(NoSuchElementException e){
		}
		
		return status;
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
	 * This method is used to get the alert message.
	 * @return : return alert message.
	 */
	public static String getAlertMessage(){
		
		return alertInstance().getText();
	}
	
	/**
	 * This method is used to Accept alert
	 */
	public static void acceptAlert(){
		try{
			alertInstance().accept();
			waitThread(1);
		}
		catch(NoSuchElementException e){
			Logs.error("Alert Not Accepted. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to Dismiss alert
	 */
	public static void dismissAlert(){
		try{
			alertInstance().dismiss();
			waitThread(1);
		}
		catch(NoSuchElementException e){
			Logs.error("Alert Accepted. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to wait for alert to be visible. 
	 */
	public static void waitForAlertPopup(){
		int timeOutInSeconds = 60;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		try{
			wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(NoSuchElementException e){
			Logs.info("Wait for a alert to be visible. ");
			e.printStackTrace();
		}
	}
	
	/**
	 * This method is used to enter message in alert box.
	 */
	public static void passMessageInAlert(String txt_message){
		try{
			Reusables.waitThread(2);
			alertInstance().sendKeys(txt_message);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>> Alert text box not found.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to forward one step.
	 */
	public static void oneStepForward(){
		waitThread(1);
		driver.navigate().forward();
		waitThread(1);
	}
	
	/**
	 * This method is used to switch to web view.
	 * @param webview : type int
	 */
	public static void switchToWebView(int webview){
		waitThread(3);
		List<String> context_handles = new ArrayList<String>(driver.getContextHandles());
		driver.context(context_handles.get(webview));
		waitThread(3);
	}
	
	/**
	 * This method is used to perform tap operation
	 * @param x : X axis point
	 * @param y : Y axis point
	 */
	public static void tapOnElementUsingCoordinates(int x, int y){
		try{
			TouchAction action = new TouchAction(driver);
			action.tap(x, y).release().perform();
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>>>>Tap does no perform on given coordinates..."+e.getClass().getName());
		}
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
	 * This method is used to perform tap operation
	 * @param by : locator value
	 */
	public static void tapOnIOSElement(By by){
		IOSElement element = getIOSElement(by);
		Reusables.waitThread(1);
		driver.tap(1, element, 1000);
		Reusables.waitThread(1);
	}
	

	/**
	 * This method is used to get the text value of element
	 * @param by : locator type
	 * @return : String value
	 */
	public static String getText(By by){
		
		return driver.findElement(by).getText().trim().toString();
	}
	
	/**
	 * This method is used to get the text value of list element
	 * @param by : locator type
	 * @param index_value : type integer, which value you want from list.
	 * @return : type String, text value from list element.
	 */
	public static String getTextFromList(By by, int index_value){
		
		return driver.findElements(by).get(index_value).getAttribute("name").trim().toString();
	}
	
	
	/**
	 * This method is used to generate random number.
	 * @param number : type int
	 * @return: return the generated random number.
	 */
	public static int randomNumber(int number){
		Random ran = new Random();
		
		return ran.nextInt(number);
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
		driver.swipe(startx, starty, endx, endy, 1000);

	}
	
	/**
	 * This method is used to swipe using custom values.
	 */
	public static void customSwipe(float start_y, float end_y){
		Dimension size = driver.findElement(By.className("UIAWindow")).getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*start_y);
		int endx = width/2;
		int endy = (int) (height*end_y);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	public static void uiAPickerWheel(By by, String textdata){
		IOSElement element = getIOSElement(by);
		/*element.swipe(SwipeElementDirection.UP, 1000);
		element.swipe(SwipeElementDirection.LEFT, 1000);*/
		//or
		element.sendKeys(textdata);
	}
	
	/**
	 * This method is used to swipe left and right.
	 */
	public static void SwipeLeftRight(float start_x, float end_x){
		Dimension size = driver.findElement(By.name("UIAWindow")).getSize();
		int width = size.getWidth();
		System.out.println("Windth"+width);
		int height = size.getHeight();
		int startx = (int)(width*start_x);
		int starty = height/2;
		int endx = (int)(width*end_x);
		int endy = height/2;
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 *  This method is used to perform swipe up operation using start and end element.
	 * @param fromElement : From where
	 * @param toElement : from to.
	 */
	public static void swipeUp(IOSElement fromElement, IOSElement toElement){
	    Point fromPoint = fromElement.getLocation();
		Point toPoint = toElement.getLocation();
		Dimension fromSize = fromElement.getSize();
		Dimension toSize = toElement.getSize();
		int startx = fromSize.width/2;
		int starty = fromPoint.getY() + (fromSize.getHeight() / 2);
		int endx = startx;
		int endy = toPoint.getY() + (toSize.getHeight()/2) ;
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 *  This method is used to perform swipe up operation using start and end element.
	 * @param fromElement : From where
	 * @param toElement : from to.
	 */
	public static void swipeDown(IOSElement fromElement, IOSElement toElement){
	    Point fromPoint = fromElement.getLocation();
		Point toPoint = toElement.getLocation();
		Dimension fromSize = fromElement.getSize();
		Dimension toSize = toElement.getSize();
		int startx = fromSize.width/2;
		int starty = fromPoint.getY() + (fromSize.getHeight() / 2);
		int endx = startx;
		int endy = toPoint.getY() + (toSize.getHeight()/2) ;
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	public static void swipeLeft(IOSElement fromElement, IOSElement toElement){
		Point fromPoint = fromElement.getLocation();
		Point toPoint = toElement.getLocation();
		Dimension fromSize = fromElement.getSize();
		Dimension toSize = toElement.getSize();
		int startx = fromPoint.getX() + (fromSize.getWidth() / 2);
		int starty = fromPoint.getY() + fromSize.getHeight() /2;   //point.getY() + height/2;
		int endx = toPoint.getX() + (toSize.getWidth() / 2); 
		int endy = starty;
		System.out.println("StartX"+startx+" Starty"+starty+"Endx"+endx+"Endy"+endy);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	
	/**
	 * This method is used to perform swipe operation.
	 * @param fromelement : from 
	 * @param toelement : to
	 */
	public static void dragAndDrop(By fromelement, By toelement){
		waitThread(1);
		TouchAction action = new TouchAction(driver);
		action.moveTo(Reusables.getIOSElement(fromelement)).moveTo(Reusables.getIOSElement(toelement)).release().perform();
	}
	
	//********************************************************************

	/**
	 * This method is used to launch the app.
	 */
	public static void appLaunch(){
		try{
			driver.launchApp();
		}
		catch(NoSuchElementException e){
			Logs.error("App is not launched.. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to resert ios app.
	 */
	public static void terminatesAppInstance(){
		//driver.resetApp();
	}
	
	/**
	 * This method is used to run app in background for the specified time. 
	 * @param time : type int
	 */
	public static void runAppInBackground(int timeInSeconds){
		try{
			driver.runAppInBackground(timeInSeconds);
			Thread.sleep(timeInSeconds*1000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	

	/**
	 * This method is used to enter character in the text box using keyboard.
	 * @param keyName : Key Name, type String
	 */
	public static void enterTextUsingKeyBoard(By by, String word){
		try{
			IOSElement element;
			System.out.println("Search Word"+word);
			getIOSElement(by).click();
			for (int i = 0; i < word.length(); i++){
				if (word.charAt(i) == ' '){
					Reusables.clickCommand(SplashScreen.spaceKey);
					Reusables.waitThread(1);
					Reusables.clickCommand(SplashScreen.shiftKey);
					Reusables.waitThread(1);
				}
				element = getIOSElement(By.id(""+word.charAt(i)));
				Reusables.clickUsingIOSElement(element);
				System.out.println("Enter charater term are."+word.charAt(i));
			}
		}catch(NoSuchElementException e){
			Logs.error("Key Name Not found. "+e.getClass().getName());
		}
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
	public static void enterMessageInTextBox(By by, String txtMsg, String keyName){ //evmenu, //tastebud
		IOSElement element = getIOSElement(by);
		element.click();
		element.sendKeys(txtMsg);
		hideKeyboard(keyName);
		/*click_using_element(Reusables.get_element(By.name("Done")));
		element.sendKeys(Keys.END); element.sendKeys(Keys.HOME)
		driver.tap(1, get_element(By.name("Done")), 1000);
		driver.execute("mobile: hideKeyboard", [{keyName: "Done"}])
		clickAndHoldOperation(Reusables.get_element(By.xpath("//UIAApplication[1]/UIAWindow[5]/UIAKeyboard[1]/UIAButton[4]")));*/
		waitThread(2);
		Logs.info("Entered the text message >>>>>> "+txtMsg);
	}
	
	/**
	 * This method is used to enter text message in the text box
	 * @param by locator type
	 * @param txt String message text
	 */
	public static void enterMessageInTextBox(By by, String txtMsg){ //filter
		IOSElement element = getIOSElement(by);
		element.click();
		element.sendKeys(txtMsg);
		waitThread(2);
		Logs.info("Entered the text message >>>>>> "+txtMsg);
	}
	
	
	/**
	 * This method is used to enter text message in the text box
	 * @param by locator type
	 * @param txt String message text
	 */
	public static void enterMessageInTextBox(By by, String txt_msg, boolean keyboardHideStatus, String keyName){
		Reusables.waitThread(2);
		IOSElement element = getIOSElement(by);
		element.click();
		element.sendKeys(txt_msg);
		if (keyboardHideStatus == true){
			performClickOnDeleteKey();
			Reusables.waitThread(2);
		}
		hideKeyboard(keyName);
		//element.setValue(txt_msg);
		Logs.info("Entered text message >>>>>> "+txt_msg);
	}
	
	
	/**
	 * This method is used to return the IOSElement
	 * @param by Locator type
	 * @return return element
	 */
	public static IOSElement getIOSElement(By by){
		waitThread(1);
		return driver.findElement(by);
		
	}
	
	/**
	 * This method is used to return the IOSElement list
	 * @param by Locator type
	 * @return return element
	 */
	public static List<IOSElement> getIOSElementsList(By by){
		waitThread(1);
		return driver.findElements(by);
		
	}
	
   
   /**
	 * This method is used to perform scroll to exact text.
	 * @param name : Type String 
	 */
	public static void scrollToExactTxt(String name){
		waitThread(1);
		driver.scrollToExact(name.toString());
	}
	
   /**
    * This method is used to perform scroll to exact text and perform click operation on the text value.
    * @param name : name of the entity to be click
    */
   public static void clickUsingScrollTExactTxt(String name){
	   
	   driver.scrollToExact(name).click();
   }
   
   /**
	 * This method is used to perform click operation.
	 * @param by : type of By class
	 */
	 public static void clickCommand(By by){
		 try{
			 getIOSElement(by).click();
		 }
		 catch(NoSuchElementException e){
			 Logs.error("Click operation not perform on. "+e.getClass().getName());
		 }
	 }
	 
	 /**
	  * This method is used to perform click operation using android element.
	  * @param element : Type IOSElement
	  */
	 public static void clickUsingIOSElement(IOSElement element){
		 element.click();
		 waitThread(1);
	 }
   
	 /**
	  * This method is used to perform click operation on index basis.
	  * @param element : Type  IOSElement
	  * @param index : Type int.
	  */
	 public static void clickUsingIOSElementList(List<IOSElement> element, int index){
		 waitThread(1);
		 element.get(index).click();
		 waitThread(1);
	 }
	 

   /**
    * This method is used to click and hold on any element.
    */
   public static void clickAndHoldOperation(IOSElement element){
	   TouchAction action = new TouchAction(driver);
	   action.longPress(element, 1000).release().perform();
   }
   
   
   /**
    * This method is used to get app screen size.
    */
   public static Dimension getAppScreenSize(){
	   
	   return driver.findElement(By.className("UIAWindow")).getSize();
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
				Reusables.clickCommand(SplashScreen.hideKeyboardBtn);
				Reusables.waitThread(2);
				/*driver.hideKeyboard(HideKeyboardStrategy.PRESS_KEY, "HIDE_KEYBOARD");
				driver.hideKeyboard(HideKeyboardStrategy.TAP_OUTSIDE, "true");*/
			}
		}
		catch(NoSuchElementException e){
			Logs.error("Keyboard is still opening. "+e.getClass().getName());
		}
	}
   
 
   /**
    * This method is used to perform bank navigation(One Step back...)
    */
   public static void oneStepBack(){
	   try{
		   driver.navigate().back();
		   waitThread(1);
		   }
	   catch(NoSuchElementException e){
		   Logs.error("Back button not clickable... "+e.getClass().getName());
	   }
   }
   
   /**
    * Network Status
    * @param airplaneMode
    * @param wifi
    * @param data
    */
   public static void getNetConnectionStatus(boolean airplaneMode, boolean wifi, boolean data){
	   try{
		   NetworkConnectionSetting connections = new NetworkConnectionSetting(airplaneMode, wifi, data);
		   if (airplaneMode){
			   connections.setAirplaneMode(airplaneMode);
		   }else if (wifi) {
			   connections.setWifi(wifi);
		   }else if (data){
			   connections.setData(data);
		   }
		   System.out.println("Network Connection Type..."+connections.value+" Name..>"+connections.wifiEnabled());
	   }catch(NoSuchElementException e){
		   Logs.error(">>>>>>>>>>>>> Not find any value... "+e.getClass().getName());
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
			Logs.error("Element still not enable. "+e.getClass().getName());
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
			Logs.error("Element still enable. "+e.getClass().getName());
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
	  * This method is used to verify either actual text contains expected character.
	  * @param by : locator type.
	  * @param expectedText : for checking character found in actual text.
	  */
	 public static void verifyElementTextPresent(By by, String expectedText){
		 String actualText = "";
		 String expectedCharacter = expectedText.toLowerCase();
		 try{
			 actualText = Reusables.getText(by).toLowerCase();
			 Assert.assertTrue(actualText.contains(expectedCharacter), "Error Message!! Expected Character not found in actual text");
		 }catch(NoSuchElementException e){
		 }
	 }
	 
	 /**
	  * This method is used to verify either actual text contains expected character.

	  * @param expectedText : for checking character found in actual text.
	  */
	 public static void verifyTextContains(String actualtext, String expectedText){
		 String actualText = actualtext.toLowerCase();
		 String expectedCharacter = expectedText.toLowerCase();
		 try{
			 Assert.assertTrue(actualText.contains(expectedCharacter), "Error Message!! Expected Character not found in actual text");
		 }catch(NoSuchElementException e){
		 }
	 }
	
	
	/**
	 * This method is used to verify either page loaded or not.
	 * @param pageHeaderTxt : String for verify either page text matched or not.
	 */
	public static void verifyPageLoaded(String pageHeaderTxt){
		try{
			Reusables.waitForIOSElement(SplashScreen.appHeaderTxtView);
			Reusables.verifyElementTextPresent(SplashScreen.appHeaderTxtView, pageHeaderTxt);
		}catch(NoSuchElementException e){
			Logs.error("Page not loaded. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to back one step .
	 */
	public static void stepBackTillElementNotFound(By by, String text){
		waitThread(1);
		while (Reusables.getText(by).equalsIgnoreCase(text) == false){
			oneStepBack();
			waitThread(1);
		}
	}
	
	
	/**
	 * This method is used to verify free entity.
	 * @param categoryName : String type.
	 * @param typeOfDietName : String type.
	 * @return : recipe name
	 */
   public static String checkFreeRecipe(String typeOfDietName, String categoryName, String recipeType){
	   String freeRecipeName = "";
	   List<IOSElement> recipeNameList;
	   if (recipeType.equalsIgnoreCase("taste bud")){
		   freeRecipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
	   }
	   else if (recipeType.equalsIgnoreCase("courses")){
		   freeRecipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
	   }
	   else if (recipeType.equalsIgnoreCase("all")){
		   freeRecipeName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
	   }
	   while (freeRecipeName.length()==0){
		  Reusables.oneStepBack();
		  if (recipeType.equalsIgnoreCase("taste bud")){
			  categoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietName);
			  freeRecipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
		   }
		   else if (recipeType.equalsIgnoreCase("courses")){
			   categoryName = Courses.clickOnRandomCourseCategoryList(typeOfDietName);
			   freeRecipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
		   }
		   else if (recipeType.equalsIgnoreCase("all recipe")){
			   freeRecipeName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
		   }
	   }
	   TasteBud.findTermNameViaSearch(freeRecipeName);
	   recipeNameList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
	   for (IOSElement element : recipeNameList){
		   if (element.getText().toString().equalsIgnoreCase(freeRecipeName)){
			   element.click();
			   Reusables.waitThread(1);
			   break;
		   }
	   }
	   /* Allow alcoholic beverage */
	   SplashScreen.acceptAlcoholicBeverage();
	   /* Select Unit System Measure Ingredients */
	   SplashScreen.selectUnitSystemMeasureIngredients();
	   /* Hide Interstitial */
	   Reusables.hideInterstitial();
	   /* Hide App Rate Alert Popup. */
	   SplashScreen.hideAppRatePopUp();
	   /* Dismiss more recipes alert popup */
	   SplashScreen.dismissMoreRecipeAlertPopUp();
	   Reusables.waitThread(2);
	   
	   return freeRecipeName;
   }
   
   
	/**
	 * This method is used to verify free entity.
	 * @param categoryName : String type.
	 * @param typeOfDietName : String type.
	 * @return : recipe name
	 */
  public static String checkPremiumRecipe(String typeOfDietName, String categoryName, String recipeType){
	   String premiumRecipeName = "";
	   List<IOSElement> recipeNameList;
	   if (recipeType.equalsIgnoreCase("taste bud")){
		   premiumRecipeName = DatabaseConnection.getTasteBudLockTerm(typeOfDietName, categoryName);
	   }
	   else if (recipeType.equalsIgnoreCase("courses")){
		   premiumRecipeName = DatabaseConnection.getCourseLockTerm(typeOfDietName, categoryName);
	   }
	   else if (recipeType.equalsIgnoreCase("all")){
		   premiumRecipeName = DatabaseConnection.getRecipeLockTerm(typeOfDietName);
	   }
	   while (premiumRecipeName.length()==0){
		   Reusables.oneStepBack();
		   if (recipeType.equalsIgnoreCase("taste bud")){
			   categoryName = TasteBud.clickOnRandomTasteBudCategoryList(typeOfDietName);
			   premiumRecipeName = DatabaseConnection.getTasteBudLockTerm(typeOfDietName, categoryName);
		   }
		   else if (recipeType.equalsIgnoreCase("courses")){
			   categoryName = Courses.clickOnRandomCourseCategoryList(typeOfDietName);
			   premiumRecipeName = DatabaseConnection.getCourseLockTerm(typeOfDietName, categoryName);
		   }
		   else if (recipeType.equalsIgnoreCase("all")){
			   premiumRecipeName = DatabaseConnection.getRecipeLockTerm(typeOfDietName);
		   }
		   }
	   TasteBud.findTermNameViaSearch(premiumRecipeName);
	   recipeNameList = Reusables.getIOSElementsList(TasteBud.recipeNameList);
	   //System.out.println("Recipe list"+recipeNameList);
	   for (int i = 0; i < recipeNameList.size(); i++){
		   if (recipeNameList.get(i).getText().equalsIgnoreCase(premiumRecipeName)){
			   recipeNameList.get(i).click();
			   Reusables.waitThread(2);
			   break;
		   }
	   }
	   Reusables.waitThread(2);
	   InAppPurchase.verificationForPaidRecipe();
	   
	   return premiumRecipeName;
  }
	
   
   public static List<String> getPatternListValue(String strText){
		List<String> list = new ArrayList<String>();
		ArrayList<String> strData = new ArrayList<String>(Arrays.asList(strText.split(",")));
		/* Create Pattern Object */
		Pattern pattern = Pattern.compile("([^|])+\\|+[^|]+\\.[a-zA-Z]{2,4}");
		/* Create a Matcher object */
		for (int i = 0; i < strData.size(); i++){
			Matcher matcher = pattern.matcher(strData.get(i));
			if (matcher.find()){
				list.add(matcher.group(0).replaceFirst("\\|+[^|]+\\.[a-zA-Z]{2,4}", ""));
			}
		}
		
		return list;
	}
   
	/**
	 * This method is used to verify element count present.
	 * @param by : Locator type
	 */
	public static void verifyElementCountExistance(By by){
		int elementCount = Reusables.getIOSElementsList(by).size();
		if (elementCount >= 1){
			Assert.assertTrue(elementCount >= 1, "Error Message!! Element count Less than one");
		}else{
			Assert.assertFalse(elementCount < 1, "Error Message!! Element count Greater than one");
		}
	}
	
	 public static String dayMonthDateCombination(Date date, int days){
		 String dateDayCom = "";
		 Calendar cal = Calendar.getInstance();
		 cal.setTime(date);
	     cal.add(Calendar.DATE, days); //minus number would decrement the days
	     Date date1 = cal.getTime();
	     dateDayCom = new SimpleDateFormat("EEE d MMM").format(date1);
	     
	     return dateDayCom;
	    }
	 
	 public static void main(String args[]){
		 //System.out.println(dayMonthDateCombination(new Date(), 1));
		 System.out.println(getPatternListValue("600.0|gm|Lamb|lamb.jpg,1.0|pc|Onion roughly chopped|Chopped Yellow Onions.jpg,1.0|pc|Carrot sliced|carrot thinly julienned.jpg,").get(0));
		}
}