package com.eduven.utils;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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

import com.eduven.constants.DataConstants;
import com.eduven.report.Logs;


public class Reusables {
  
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator value */
	public static By for_element_count = By.id(DeviceRelatedInformation.getPackageName()+":id/tv_name");
	public static By interstetialBtn = By.xpath("//*[@content-desc='Interstitial close button']");
	public static By contributeImageView = By.name("Add");
	public static By connection_error_message = By.id("android:id/message");
	public static By accept_alert_popup = By.id("android:id/button1");
	public static By notificationId = By.id("android:id/title");
	public static By appSubHeaderTxtView = By.id(DeviceRelatedInformation.getPackageName()+":id/subtitle_text");
	
	
	/**
	 * This method is used to hide the industrialization.
	 */
	public static void hideIndustrialization(){
		try{
			if (isElementPresent(interstetialBtn) == true){
				clickCommand(interstetialBtn);
			}	
			else if (isElementPresent(interstetialBtn) == false){
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Industrialization advertising still visible....... "+e.getClass().getName());
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
	 * this method id used for wait for particular element.
	 * @param by element locator value
	 */
	public static void waitForElement(By by){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(NoSuchElementException e){
			Logs.error("Elemement not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * this method id used for wait for particular element to be invisible.
	 * @param by element locator value
	 */
	public static void waitForElementInvisible(By by){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
		}
		catch(NoSuchElementException e){
			Logs.error("Elemement found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * this method id used for wait for particular AndroidElement.
	 * @param element AndroidELement
	 */
	public static void waitForAndroidElement(AndroidElement element){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
		}catch(NoSuchElementException e){
			Logs.error("Elemement not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to wait for an alert to be visible.
	 * 
	 */
	public static void waitForAlert(){
		int timeOutInSeconds = 60;
		try{
			//Logs.info("******************Wait for Alert to be Visible.*********************");
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
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
			Logs.info("Wait for the "+timeOutInSeconds+" Seconds");
		}
	}
	
	/**
	 * This method is used to verify element present or not.
	 * @param by : Locator type.
	 * @return : Return boolean value either true or false.
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
	 * This method is used to verify element present or not.
	 * @param element : AndroidElement.
	 * @return : Return boolean value either true or false.
	 */
	public static boolean isElementPresent(AndroidElement element){
		try{
			element.isDisplayed();
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
	 * This method is used to get the alert message.
	 * @return : return alert message.
	 */
	public static String getAlertMessage(){
		
		return alertInstance().getText();
	}
	
	/**
	 * Accept alert
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
	 * This method is used to wait for alert to be visible. 
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
	 * This method is used to back one step .
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
	 * This method is used to switch to web view.
	 * @param webview : type integer
	 */
	public static void switchToWebView(int webview){
		waitThread(3);
		List<String> context_handles = new ArrayList<String>(driver.getContextHandles());
		driver.context(context_handles.get(webview));
		waitThread(3);
		
	}
    
	/**
	 * This method is used to perform tap operation.
	 * @param by : locator type.
	 */
	public static void tapOnElementUsingLocator(By by){
		AndroidElement element = driver.findElement(by);
		driver.tap(1, element, 1000);
	}
	
	/**
	 * This method is used to perform tap operation.
	 * @param element : AndroidElement type
	 */
	public static void tapOnElementUsingLocator(AndroidElement element){
		driver.tap(1, element, 1000);
	}
	
	/**
	 * This method is used to perform tap operation
	 * @param fingers : how many finger, type int
	 * @param x : X axis point
	 * @param y : Y axis point
	 */
	public static void tapOnElementUsingCoordinates(int fingers, int x, int y){
		try{
			driver.tap(fingers, x, y, 1000);
		}
		catch(NoSuchElementException e){
			Logs.error(">>>>>>>> Tap does no perform on given coordinates..."+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to perform click operation.
	 * @param by : type of By class
	 */
	 public static void clickCommand(By by){
		 try{
			 Reusables.waitThread(1);
			 AndroidElement element  = driver.findElement(by);
			 element.click();
			 }
		 catch(NoSuchElementException e){
			 //Logs.error(">>>>>>>>> Click operation not perform on..."+e.getClass().getName());
			 }
		 }
	 
	 /**
	  * This method is used to perform click operation using element.
	  * @param element : AndroidElement.
	  */
	 public static void clickUsingElement(AndroidElement element){
		 waitForAndroidElement(element);
		 element.click();
	 }
	 
	 /**
	  * This method is used to perform click operation using locator String.
	  * @param entity_name : Perform click operation on entity.
	  */
	 public static void clickUsingString(String entity_name){
		 getElement(By.name(entity_name)).click();
	 }

	
	/**
	 * This method is used to get the text value of element
	 * @param by : locator type
	 * @return : String value
	 */
	public static String getText(By by) {
		return driver.findElement(by).getAttribute("name").trim().toString();
		}
	
	/**
	 * This method is used to get the text value of element.
	 * @param element : AndroidElement as locator value.
	 * @return : String value, as text.
	 */
	public static String getText(AndroidElement element){
		return element.getText().toString().trim();
	}

	
	/**
	 * This method is used to generate random number.
	 * @param number : type int
	 * @return: return the generated random number.
	 */
	public static int randomNumber(int number){
		int randomNumber = 0;
		try{
			Random ran = new Random();
			randomNumber = ran.nextInt(number);
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		return randomNumber;
	}

	
	public static ArrayList<String> getCategoryList(String list, String string_separator){
		
     ArrayList<String> cat=new ArrayList<String>(Arrays.asList(list.split(string_separator)));

		return cat;
	}
	
	/**
	 * For swipe Up.
	 */
	public static void swipeUp(){
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*0.6);
		int endx = width/2;
		int endy = (int) (height*0.2);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 * For Custom swipe Up.
	 */
	public static void customSwipeUp(float startY, float endY){
		Dimension size = driver.manage().window().getSize();
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
	 * For Custom swipe Down.
	 */
	public static void swipeDown(){
		Dimension size = driver.manage().window().getSize();//findElement(By.className("android.view.View")).getSize();		
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*0.3);
		int endx = width/2;
		int endy = (int) (height*0.6);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	//********************************************************************

	/**
	 * This method is used to launch the app.
	 */
	public static void launchApp(){
		Logs.info(DataConstants.appName+" is launching...");
		driver.launchApp();
	}
	
	/**
	 * This method is used to close the Appium current instance.
	 */
	public static void terminatesAppInstance(){
		driver.resetApp();
	}
	
	/**
	 * This method is used to run APP in background for the specified time. 
	 * @param time : type int
	 */
	public static void runAppInBackground(int time){
		driver.runAppInBackground(time);
		try{
			waitThread(time);
		}
		catch(NoSuchElementException e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * This method is used to enter text message in the text box
	 * @param by locator type
	 * @param txt String message text
	 */
	public static void enterMessageInTextBox(By by, String txt_msg){
		AndroidElement element = getElement(by);
		element.click();
		element.clear();
		element.sendKeys(txt_msg);
		Logs.info("Entered text message. "+txt_msg);
		Reusables.stepBack();
	}
	
	public static void hide_keyboard(String key){
		try{
			waitThread(1);
			if (key.equalsIgnoreCase("done")){
				driver.hideKeyboard();
			}
			else if (key.equalsIgnoreCase("return")){
				driver.hideKeyboard();
			}
			else if (key.equalsIgnoreCase("no key")){
				driver.hideKeyboard();
			}
		}
		catch(NoSuchElementException e){
			Logs.error("*************************Keyboard is still opening******************");
		}
	}
	
	/**
	 * This method is used to return the AndroidElement
	 * @param by Locator type
	 * @return return element
	 */
	public static AndroidElement getElement(By by){
		waitThread(1);
		return driver.findElement(by);
		
	}
	
	/**
	 * This method is used to return the AndroidElement list
	 * @param by Locator type
	 * @return return element
	 */
	public static List<AndroidElement> getElementsList(By by){
		//waitForElement(by);
		return driver.findElements(by);
		
	}
	

   /**
    * This method is used to verify contribute entity either visible or not.
    */
   public static void verifyContributeEntity(){
	   try{
		   scrollToExactUsingTxt("Add");
		   Reusables.verifyElementPresent(Reusables.getElement(contributeImageView), "Error Message!! Contribute Entity Not found.");
	   }
	   catch(NoSuchElementException e){
		   Logs.error("Error Message! Contribute entity not found in this category. "+e.getClass().getName());
		   }
   }
   
   
   public static String randomCategoryEntityName(String category){
	   String name = "";
	   try{
		   ArrayList<String> list_size = getCategoryList(category, "~");
		   name = list_size.get(randomNumber(list_size.size()));
	   }
	   catch(NoSuchElementException e){
		   Logs.error("*******************Does not return any entity name from given category.....");
	   }
	   
	   return name;
   }
   
   /**
	 * This method is used to perform scroll to exact text.
	 * @param name : Type String 
	 */
	public static void scrollToExactUsingTxt(String name){
		waitThread(1);
		driver.scrollToExact(name.toString());
	}
	
	   /**
	    * This method is used to perform scroll to exact text and perform click operation on the text value.
	    * @param name : name of the entity to be click
	    */
	   public static void clickUsingScrollToExactTxt(String name){
		   waitThread(1);
		   driver.scrollToExact(name).click();
	   }
   
   /**
    * This method is used to count the total number of element visible
    * @param by : Locator type 
    * @return : return int, total number element found.
    */
   public static int elementCount(By by){
	   
	   return driver.findElements(by).size();
   }
   
   /**
    * Check push notification.
    * @param notification_text : for checking the notification.
    */
   public static void checkPushNotifiaction(String notification_text){
	   driver.openNotifications();
	   Reusables.waitThread(1);
	   List<AndroidElement> notificationList = Reusables.getElementsList(notificationId);
	   for (AndroidElement element: notificationList){
		   if (element.getText().equalsIgnoreCase(notification_text) == true){
			   element.click();
		   }
		   else if (element.getText().equalsIgnoreCase(notification_text) == false){
		   }
	   }
   }
   
   
   
   public static void dragAndDrop(int number_of_times, By locator_value){
	   List<AndroidElement> element = getElementsList(locator_value);
	   //System.out.println("element counts..."+element.size());
	   TouchAction action = new TouchAction(driver);
	   for (int i = 0; i < number_of_times; i++){
		   action.moveTo(element.get(3)).moveTo(element.get(1)).release().perform();
	   }
	   action.tap(element.get(3)).release().perform();
	   
   }
   
   public static void swipeUp(AndroidElement fromElement, AndroidElement toElement) 
	{
		Point fromPoint = fromElement.getLocation();
		Point toPoint = toElement.getLocation();
		Dimension fromSize = fromElement.getSize();
		Dimension toSize = toElement.getSize();
		int startx = fromSize.width/2;
		int starty = fromPoint.getY() + (fromSize.getHeight() / 2);
		int endx = startx;
		int endy = toPoint.getY() + (toSize.getHeight()/2) ;
		//System.out.println(startx + ".." + starty + ".." + endx + ".." + endy);
		driver.swipe(startx, starty, endx, endy, 1000);
	   
/*		Point fromPoint=driver.findElement(fromElement).getLocation();
		Point toPoint=driver.findElement(toElement).getLocation();

		Dimension fromSize = driver.findElement(fromElement).getSize();
		Dimension toSize = driver.findElement(toElement).getSize();

		System.out.println(fromPoint.getX()+".."+fromPoint.getY()+"................."+toPoint.getX()+".."+toPoint.getY());

		int startx = fromPoint.getX()+(fromSize.getWidth()/2);
		int starty = fromPoint.getY()+(fromSize.getHeight()/2);
		int endx = fromPoint.getX()+(toSize.getWidth()/2);
		int endy = fromPoint.getY()+(toSize.getHeight()/2);
		System.out.println(startx+".."+starty+".."+endx+".."+endy);
		driver.swipe(startx, starty, endx, endy, 1000);*/
	}
   
   /**
    * Network Status
    * @param airplaneMode
    * @param wifi
    * @param data
    */
   public static void getNetConnectionStatus(boolean airplaneMode, boolean wifi, boolean data){
	   try{
		   Reusables.waitThread(10);
		   NetworkConnectionSetting connections = new NetworkConnectionSetting(airplaneMode, wifi, data);
		   driver.setNetworkConnection(connections);
		   //System.out.println(connections.wifiEnabled());
		   System.out.println("Network Connection Type..."+connections.value+" Type..."+driver.getNetworkConnection());
	   }catch(NoSuchElementException e){
		   Logs.error(">>>>>>>>>>>>> Selected Operation not performed... "+e.getClass().getName());
	   }
   }
   
	/**
	 * This method is used to verify connection relates problem.
	 */
	public static void verifyConnectionRelatedError(){
		try{
			Reusables.waitThread(2);
			Reusables.verifyEqualMessage(Reusables.getText(Reusables.getElement(connection_error_message)), DataConstants.connectivity_related_message, "Error Message!! Connectivity related issue not coming.");
			Reusables.clickCommand(accept_alert_popup);
		}catch(NoSuchElementException e){
			Logs.error("Connectivity related issue not coming. "+e.getClass().getName());
		}
	}
   
   /**
    * This method is used to checked paid term after network connection off.
    * @param by : Locator Type
    */
   public static void verifyPaidTermOptAfterNetworkOff(By by){
	   try{
		   waitThread(2);
		   Reusables.verifyElementPresent(Reusables.getElement(by), "Error Message!! Element not found.");
		   }
	   catch(NoSuchElementException e){
		   Logs.error("Network Status message not shown. "+e.getClass().getName());
		   }
	   }
   
	
	/**
	 * Verify the Category list on category list page.
	 * @param languageName : String type for selecting category list for different language.
	 */
	public static void verifyCategoryList(String languageName) {
		AndroidElement element = null;
		String categoryName = "";
		try{
			Reusables.waitThread(4);
			for (int i = 0; i < DatabaseConnection.getMainCategories(languageName).size(); i++){
				categoryName = DatabaseConnection.getMainCategories(languageName).get(i);
				if (Reusables.isElementPresent(By.name(categoryName)) == false){
					Reusables.swipeUp();
					waitThread(1);
				}
				element = Reusables.getElement(By.name(categoryName));
                Reusables.waitForAndroidElement(element);
                //Logs.info("Category Name. "+element.getAttribute("name").toString()+" Found.");
				}
		}
		catch(NoSuchElementException e){
			Logs.error("Category "+ element.getAttribute("name")+" not found. "+e.getClass().getName());
			}
	}
	
	

	
	/**
	 * This method is used to click on city name inside term name.
	 */
	public static void clickOnCityNameInSideTermName(String cityName){
		try{
			Reusables.waitThread(2);
			//System.out.println(Reusables.isElementPresent(By.name(cityName)));
			while (Reusables.isElementPresent(By.name(cityName)) == false){
				Reusables.waitThread(1);
				Reusables.customSwipeUp(0.7f, 0.5f);
			}
			Reusables.clickUsingString(cityName);
			Reusables.waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error("City Name not found. "+e.getClass().getName());
		}
	}
	
	
	// >>>>>>>>>>>>>>>>>>>>>>>> Update methods >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	 /**
	  *This method is used to verify element enable or not.
	  *@param element : Type AndroidElement
	  *@param error : Type String, Error Message
	  */
	public static void verifyElementEnable(AndroidElement element, String error_message){
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
	public static void verifyElementDisable(AndroidElement element, String error_message){
		boolean elementStatus = element.isEnabled();
		try{
			Assert.assertFalse(elementStatus, error_message);
		}catch(NoSuchElementException e){
			Logs.error(e.getClass().getName());
		}
		}
	 
	/**
	 * This method is used to verify text present.
	 * @param element : AndroidElement
	 * @param Message : String type
	 */
	public static void verifyElementPresent(AndroidElement element, String Message){
		boolean status = element.isDisplayed();
		try{
			Assert.assertTrue(status, Message);
		}catch(NoSuchElementException e){
		}
	}
	
	
	/**
	 * This method is used to verify text not present.
	 * @param element : AndroidElement
	 * @param Message : String type
	 */
	public static void verifyElementNotPresent(AndroidElement element, String Message){
		try{
			Assert.assertFalse(Reusables.isElementPresent(element), Message);
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
	  * This method is used to verify element count present.
	  * @param by : Locator type
	  * @param status : for checking condition inside method.
	  */
	 public static void verifyElementCountExistance(By by, boolean status){
		 int elementCount = 0;
		 try{
			 elementCount = Reusables.getElementsList(by).size();
			 //System.out.println("Element Count.."+elementCount);
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
	 
	 
	 public static List<String> getPatternListValue(String strText, String regexPattern){
			List<String> list = new ArrayList<String>();
			ArrayList<String> strData = new ArrayList<String>(Arrays.asList(strText.split(",")));
			/* Create Pattern Object */
			Pattern pattern = Pattern.compile(regexPattern);
			/* Create a Matcher object */
			for (int i = 0; i < strData.size(); i++){
				Matcher matcher = pattern.matcher(strData.get(i));
				if (matcher.find()){
					list.add(matcher.group(0));
				}
			}
			return list;
		}
	
	 
		/**
		 * This method is used to verify either page loaded or not.
		 * @param pageHeaderTxt : String for verify either page text matched or not.
		 */
		public static void verifyPageLoaded(String pageHeaderTxt){
			try{
				Reusables.waitForElement(appSubHeaderTxtView);
				Reusables.verifyElementTextPresent(appSubHeaderTxtView, pageHeaderTxt);
			}catch(NoSuchElementException e){
				Logs.error("Page not loaded. "+e.getClass().getName());
			}
		}
	
} 