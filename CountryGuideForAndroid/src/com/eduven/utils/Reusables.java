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
  
	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Locator value */
	public static By for_element_count = By.id(DeviceRelatedInformation.getPackageName()+":id/entity_name");
	public static By industrialization = By.name("android.widget.ImageButton");
	public static By contributeImageView = By.name("Add");
	public static By nearByBtn = By.id(DeviceRelatedInformation.getPackageName()+":id/nearby");
	public static By city_header_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	
	/**
	 * This method is used to hide the industrialization.
	 */
	public static void hideIndustrialization(){
		try{
			/*if (isElementPresent(industrialization) == true){
				click_opt(industrialization);
			}*/	
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
	 * This method is used to perform tap operation
	 * @param by : locator type
	 */
	public static void tapOnElementUsingLocator(By by){
		AndroidElement element = driver.findElement(by);
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
		int starty = (int) (height*0.7);
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
		int endy = (int) (height*1.0);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	//********************************************************************

	/**
	 * This method is used to launch the app.
	 */
	public static void launchApp(){
		Logs.info(">>>>>>>>>>>>>>>>>>>>>Now Launching the app >>>>>>>>>>>>>>>>>>>>>>>>>");
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
	public static void run_app_in_background(int time){
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
		Logs.info("*****************Enter the text message*************"+txt_msg);
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
	 * This method is used to navigate to premium term page and verify premium entity
	 * @param mainCategoryName : String type for selecting main category.
	 * @param subCategoryName : For choose the subCategory inside mainCategory.
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
		System.out.println("Paid Term Name..."+paidTerm);
		waitThread(1);
		clickUsingScrollToExactTxt(paidTerm);
		/* Wait for moment for enable the add...........*/
		waitThread(3);
		hideIndustrialization();
		if (isElementPresent(EntityDetailPage.buy_btn) == true){
			EntityDetailPage.verifyBuyButtonExistance();
			Reusables.stepBack();
			/* Wait for moment for enable the add...........*/
			waitThread(4);
			hideIndustrialization();
			}
		else {
			Logs.error(">>>>>Paid Term Name..> "+paidTerm + "Not Found.");
			}
		}
		
		
	/**
	 * This method is used to navigate to free term page and verify free entity element.
	 * @param mainCategoryName : String type for selecting main category.
	 * @param subCategoryName : For choose the subCategory inside mainCategory.
	 */
   public static void checkFreeEntity(String mainCategoryName, String subCategoryName){
	   String freeTerm = DatabaseConnection.getUnlockTerms(mainCategoryName, subCategoryName);
	   System.out.println("Free Term Name..."+freeTerm);
	   waitThread(2);
	   clickUsingScrollToExactTxt(freeTerm);
	   /* Wait for moment for enable the add...........*/
	   waitThread(3);
	   hideIndustrialization();
	   if (isElementPresent(EntityDetailPage.favourite_icon) == true) {
		   EntityDetailPage.checkFavIcon();
		   stepBack();
		   waitThread(3);
		   hideIndustrialization();
		}
		else {
			Logs.error(">>>>>Free Term Name..> "+freeTerm + "Not Found.");
			}
		}
   
   /**
    * This method is used to navigate to the free entity detail page.
	 * @param mainCategoryName : String type for selecting main category.
	 * @param subCategoryName : For choose the subCategory inside mainCategory.
	 * @return termName as selected term for further verification.
    */
   public static String navigateToFreeEntityDetailPage(String mainCategoryName, String subCategoryName){
	   String freeTerm = DatabaseConnection.getUnlockTerms(mainCategoryName, subCategoryName);
	   System.out.println("Free Entity for Detail Page..."+freeTerm);
	   waitThread(2);
	   clickUsingScrollToExactTxt(freeTerm.trim().toString());
	   /*Wait for moment for enable the add...........*/
	   waitThread(3);
	   hideIndustrialization();
	   if (isElementPresent(EntityDetailPage.favourite_icon) == true) {
		   EntityDetailPage.checkFavIcon();
		   }
		else {
			Logs.error("Free Term Name.. "+freeTerm+" not found. ");
		}
	   
	   return freeTerm;
   }

   /**
    * This method is used to navigate to the paid entity detail page.
	* @param mainCategoryName : String type for selecting main category.
	* @param subCategoryName : For choose the subCategory inside mainCategory.
	* @return termName as selected term for further verification.
    */
   public static String navigateToPremiumEntityDetailPage(String mainCategoryName, String subCategoryName){
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
		clickUsingScrollToExactTxt(paidTerm);
	   if (isElementPresent(EntityDetailPage.buy_btn) == true){
		   /* Wait for moment for enable the add */
		   waitThread(4);
		   hideIndustrialization();
		   }
	   else {
		   Logs.error("Paid Entity Detail page not open. > "+ paidTerm+" Not Found. ");
		   }
	   return paidTerm;
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
    */
   public static void checkPushNotifiaction(){
	   driver.openNotifications();
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
   
   public static void swipedown(By fromElement, By toElement) 
	{
		//driver.swipe(500, 900, 500, 200, 1000);
		Point fromPoint=driver.findElement(fromElement).getLocation();
		Point toPoint=driver.findElement(toElement).getLocation();

		Dimension fromSize = driver.findElement(fromElement).getSize();
		Dimension toSize = driver.findElement(toElement).getSize();

		System.out.println(fromPoint.getX()+".."+fromPoint.getY()+"................."+toPoint.getX()+".."+toPoint.getY());

		int startx = fromPoint.getX()+(fromSize.getWidth()/2);
		int starty = fromPoint.getY()+(fromSize.getHeight()/2);
		int endx = fromPoint.getX()+(toSize.getWidth()/2);
		int endy = fromPoint.getY()+(toSize.getHeight()/2);
		System.out.println(startx+".."+starty+".."+endx+".."+endy);
		driver.swipe(startx, starty, endx, endy, 1000);
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
		   System.out.println(connections.wifiEnabled());
		   System.out.println("Network Connection Type..."+connections.value+" Type..."+driver.getNetworkConnection());
	   }catch(NoSuchElementException e){
		   Logs.error(">>>>>>>>>>>>> Selected Operation not performed... "+e.getClass().getName());
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
    * This method is used to generate random category.
    * @param by : Locator type.
    * @return : Return String as category.
    */
	public static String clickOnRandomSubCategory(String mainCategoryName){
		 String random_name = "";
			try{
				int randomNumber = Reusables.randomNumber(DatabaseConnection.getSubCategoryList(mainCategoryName).size());
				random_name = DatabaseConnection.getSubCategoryList(mainCategoryName).get(randomNumber);
				Reusables.clickUsingScrollToExactTxt(random_name);
				}
			catch(NoSuchElementException e){
				Logs.error(mainCategoryName+" Category not found. "+random_name+ e.getClass().getName());
				}
			
		    return random_name;
	}
	
	
	/**
	 * Verify the elements inside the Art Aficionados tab.
	 * @param mainCategoryName : String type for verification for sub category list.
	 */
	public static void verifySubCategoryList(String mainCategoryName) {
		AndroidElement element = null;
		try{
			Reusables.waitThread(4);
			int elementCount = Reusables.elementCount(for_element_count);	
			for (int i = 0; i < DatabaseConnection.getSubCategoryList(mainCategoryName).size(); i++){
				if (i % elementCount == 0 && i / elementCount >= 1){
					Reusables.swipeUp();
					}
                element = driver.findElement(By.name(DatabaseConnection.getSubCategoryList(mainCategoryName).get(i)));
                /*while (isElementPresent(By.name(DatabaseConnection.getSubCategoryList(mainCategoryName).get(i))) == false){
                	swipeUp();
                }*/
                Reusables.waitForAndroidElement(element);
                //Logs.info("Sub Category Name. "+element.getAttribute("name").toString()+" Found.");
				}
		}
		catch(NoSuchElementException e){
			Logs.error("Sub Category "+element.toString()+" not found. "+e.getClass().getName());
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
	
	/**
	 * This method is used to get city header name.
	 * @return : String as city name.
	 */
	public static String getCityHeaderName(){
		String city_header_name= "";
		try{
			Reusables.waitForElement(city_header_txt);
			city_header_name = Reusables.getText(city_header_txt);
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
			Assert.assertFalse(element_status, error_message);
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
		boolean element_status = element.isEnabled();
		try{
			Assert.assertFalse(element_status, error_message);
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
	
	
} 