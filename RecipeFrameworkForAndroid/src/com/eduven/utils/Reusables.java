package com.eduven.utils;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eduven.modules.EntityDetailPageUpperPart;
import com.eduven.modules.SplashScreen;
import com.eduven.modules.TasteBud;
import com.eduven.reports.Logs;


public class Reusables {
  
	
	/*AndroidDriver instance*/
	 static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	 
	/**
	 * This method is used to hide the industrialization.
	 */
	public static void hideIndustrialization(){
		Reusables.waitThread(2);
		try{
			if (isElementPresent(SplashScreen.industrialization) == true){
				clickUsingElement(getElement(SplashScreen.industrialization));
			}
			else if (isElementPresent(SplashScreen.industrialization) == false){
			}
			}
		catch(NoSuchElementException e){
			Logs.error("Industrialization advertising still visible. ");
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
			Logs.info("Elemement not found exception.");
		}
	}
	
	
	/**
	 * this method id used for wait for particular AndroidElement.
	 * @param element AndroidELement
	 */
	public static void waitForAndroidElement(AndroidElement element){
		int timeOutInSeconds = 60;
		try{
			//Logs.info("***************Wait for a element to be visible.**********************");
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
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
	public static boolean isElementPresent(AndroidElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	

	/**
	 * This method is used to get the alert message from alert popup.
	 * @return : return alert message.
	 */
	public static String getAlertMessage(By by){
		
		return Reusables.getText(by).trim().toString();
	}
	
	/**
	 * This method is used to Accept alert popup.
	 */
	public static void acceptAlert(By by){
		try{
			waitThread(1);
			Reusables.clickCommand(by);
			waitThread(2);
		}
		catch(NoSuchElementException e){
			Logs.error("Alert Not Accepted.");
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
	 * This method is used to back one step .
	 */
	public static void oneStepBack(){
		waitThread(1);
		driver.navigate().back();
		waitThread(1);
	}
	
	/**
	 * This method is used to forward one step.
	 */
	public static void oneStepForward(){
		driver.navigate().forward();
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
			Logs.error("Tap does no perform on given coordinates..."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to verify element count present.
	 * @param by : Locator type
	 */
	public static void verifyElementCountExistance(By by){
		int elementCount = Reusables.getElementsList(by).size();
		if (elementCount >= 1){
			//System.out.println("Condition True.>");
			Assert.assertTrue(elementCount >= 1, "Error Message!! Element count Less than one");
		}
		else{
			//System.out.println("Condition False.>");
			Assert.assertFalse(elementCount < 1, "Error Message!! Element count Greater than one");
		}
	}
	

	/**
	 * This method is used to get the text value of element
	 * @param by : locator type
	 * @return : String value
	 */
	public static String getText(By by){
		
		return getElement(by).getAttribute("name").trim().toString();
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

	
	public static ArrayList<String> getCategoryList(String list, String string_separator){
		
     ArrayList<String> cat=new ArrayList<String>(Arrays.asList(list.split(string_separator)));

		return cat;
	}
	
	/**
	 * For Custom swipe Up.
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
	 * For Custom swipe Down.
	 */
	public static void swipeDown(){
		Dimension size = driver.manage().window().getSize();		
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*0.3);
		int endx = width/2;
		int endy = (int) (height*0.7);
		driver.swipe(startx, starty, endx, endy, 1000);
	}
	
	/**
	 * This method is used to swipe using custom values.
	 */
	public static void customSwipe(float start_y, float end_y){
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height= size.getHeight();
		int startx = width/2;
		int starty = (int) (height*start_y);
		int endx = width/2;
		int endy = (int) (height*end_y);
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
		Point point = getElement(by).getLocation();
		Dimension size = getElement(by).getSize();
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
	 * This method is used to perform swipe operation.
	 * @param fromelement : from 
	 * @param toelement : to
	 */
	public static void dragAndDrop(By fromelement, By toelement){
		waitThread(1);
		TouchAction action = new TouchAction(driver);
		action.longPress(Reusables.getElement(fromelement)).moveTo(Reusables.getElement(toelement)).release().perform();
	}
	

	/**
	 * This method is used to launch the app.
	 */
	public static void launchApp(){
			Logs.info(">>>>>>>>>App is start loading......");
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
		try{Thread.sleep(time*1000);
		}
		catch(InterruptedException e){
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
		Logs.info(">>>>>>>> Entered the text message >>>>>> "+txt_msg);
		Reusables.oneStepBack();
	}

	/**
	 * This method is used to hide keyword popup.
	 * @param key
	 */
	public static void hideKeyboard(String key){
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
			Logs.error("Keyboard is still opening. ");
		}
	}
	
	/**
	 * This method is used to return the IOSElement
	 * @param by Locator type
	 * @return return element
	 */
	public static AndroidElement getElement(By by){
		waitThread(1);
		return driver.findElement(by);
		
	}
	
	/**
	 * This method is used to return the IOSElement list
	 * @param by Locator type
	 * @return return element
	 */
	public static List<AndroidElement> getElementsList(By by){
		//waitForElement(by);
		waitThread(1);
		return driver.findElements(by);
		
	}
	
	/**
	 * This method is used to verify premium entity
	 * @param typeOfDietName: String type
	 * @param categoryName :
	 * @param recipeType :
	 */
	public static void checkPremiumRecipe(String typeOfDietName, String categoryName, String recipeType) {
		String premiumRecipeName = "";
		if (recipeType.equalsIgnoreCase("taste buds")){
			premiumRecipeName = DatabaseConnection.getTasteBudLockTerm(typeOfDietName, categoryName);
		}
		else if (recipeType.equalsIgnoreCase("courses")){
			premiumRecipeName = DatabaseConnection.getCourseLockTerm(typeOfDietName, categoryName);
		}
		else if (recipeType.equalsIgnoreCase("all recipe")){
			premiumRecipeName = DatabaseConnection.getRecipeLockTerm(typeOfDietName);
		}
		TasteBud.findTermNameViaSearch(premiumRecipeName);
		List<AndroidElement> searchRecipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
		for (AndroidElement element : searchRecipeList){
			if (element.getAttribute("name").equalsIgnoreCase(premiumRecipeName)){
				element.click();
				break;
			}
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
	   List<AndroidElement> searchRecipeList;
	   if (recipeType.equalsIgnoreCase("taste buds")){
		   freeRecipeName = DatabaseConnection.getTasteBudUnLockTerm(typeOfDietName, categoryName);
	   }
	   else if (recipeType.equalsIgnoreCase("courses")){
		   freeRecipeName = DatabaseConnection.getCourseUnLockTerm(typeOfDietName, categoryName);
	   }
	   else if (recipeType.equalsIgnoreCase("all")){
		   freeRecipeName = DatabaseConnection.getRecipeUnLockTerm(typeOfDietName);
		   System.out.println("freeRecipeName "+freeRecipeName);
	   }
	   TasteBud.findTermNameViaSearch(freeRecipeName);
	   searchRecipeList = Reusables.getElementsList(TasteBud.tasteBudRecipeListTxtview);
	   for (AndroidElement element : searchRecipeList){
		   if (element.getAttribute("name").equalsIgnoreCase(freeRecipeName)){
			   element.click();
			   break;
		   }
	   }
	   /* Wait for moment for allow media content  */
	   SplashScreen.allowMediaFilesAndContacts();
	   /* Allow alcoholic beverage */
	   SplashScreen.acceptAlcoholicBeverage();
	   /* Select Unit System Measure Ingredients */
	   SplashScreen.selectUnitSystemMeasureIngredients();
	   waitThread(3);
	   if (Reusables.isElementPresent(EntityDetailPageUpperPart.recipeHeaderTxt) == true){
		   Reusables.verifyEqualMessage(EntityDetailPageUpperPart.recipeName(), freeRecipeName, "Error Message!Actual and Expected Recipe name not matched.");
	   }
	   
	   return freeRecipeName;
	 }
   
   /**
    * This method is used to navigate to Free entity page.
    */
   public static String navigate_to_free_entity_detail_page(){
	   String termName = "";
/*	   By sub_entity_name = By.id(DeviceRelatedInformation.getPackageName()+":id/tV_SubTitle");
	   //List<String> list_data = getCategoryList(SearchEntity.get_name_from_category(getElement(sub_entity_name).getAttribute("name").trim().toString()), "#");
	    
		List<String> free_entity = getCategoryList(list_data.get(0), "~");
		//System.out.println("free_entity for detail page..."+free_entity.get(0));
		for (int i = 0; i < free_entity.size(); i++){
			waitThread(2);
			termName = free_entity.get(i).trim().toString();
			//click_using_scroll_to_exact_txt(free_entity.get(i).trim().toString());
			 Wait for moment for allow media content  
			SplashScreen.allowMediaFilesToAccess();
			 Select Unit System Measure Ingredients 
			SplashScreen.selectUnitSystemMeasureIngredients();
			 Wait for moment for enable the add...........
			waitThread(3);
			//hide_industrialization();
			if (isElementPresent(EntityDetailPage.editEdubankBtn) == true) {
				EntityDetailPage.detailPageVerificationForFreeEntity(free_entity.get(i));
			}
			else {
				Logs.error(">>>>>>>>>>>>>>>>> Free Entity"+free_entity.get(i)+" not found");
			}
		}
		*/
		return termName;
   }
   
  /**
   *  This method is used to return random entity name.
   * @param category : Category name, type String.
   * @return : Category sub entity name.
   */
  public static String random_category_entity_name(String category){
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
	 * This method is used to perform click operation.
	 * @param by : type of By class
	 */
	 public static void clickCommand(By by){
		 try{
			 getElement(by).click();
			 }
		 catch(NoSuchElementException e){
			 Logs.error("Click operation not perform on... "+e.getClass().getName());
	 }
	 }
	 
	 /**
	  * This method is used to perform click operation using android element.
	  * @param element : Type AndroidElement
	  */
	 public static void clickUsingElement(AndroidElement element){
		 waitForAndroidElement(element);
		 element.click();
		 waitThread(1);
	 }
   
	 /**
	  * This method is used to perform click operation on index basis.
	  * @param element : Type  AndroidElement
	  * @param index : Type int.
	  */
	 public static void clickUsingElementList(List<AndroidElement> element, int index){
		 element.get(index).click();
		 waitThread(1);
	 }
	 
   /**
    * This method is used to count the total number of element visible
    * @param by : Locator type 
    * @return : return total number element found, type int.
    */
   public static int elementCount(By by){
	   
	   return getElementsList(by).size();
   }
   
   /**
    * This method is used to click and hold on any element.
    */
   public static void clickAndHoldOperation(AndroidElement element){
	   TouchAction action = new TouchAction(driver);
	   action.longPress(element, 1000).perform().release();
   }
   
   /**
    * This method is used to get app screen size.
    */
   public static Dimension getAppScreenSize(){
	   return driver.findElement(By.className("android.view.View")).getSize();
	  }
  
   
   public void swipedown(By fromElement, By toElement){
	   Point fromPoint = driver.findElement(fromElement).getLocation();
	   Point toPoint = driver.findElement(toElement).getLocation();
		Dimension fromSize = driver.findElement(fromElement).getSize();
		Dimension toSize = driver.findElement(toElement).getSize();

		System.out.println(fromPoint.getX() + ".." + fromPoint.getY()
				+ "................." + toPoint.getX() + ".." + toPoint.getY());

		int startx = fromPoint.getX() + (fromSize.getWidth() / 2);
		int starty = fromPoint.getY() + (fromSize.getHeight() / 2);
		int endx = fromPoint.getX() + (toSize.getWidth() / 2);
		int endy = fromPoint.getY() + (toSize.getHeight() / 2);
		driver.swipe(startx, starty, endx, endy, 1000);
   }
   
   /**
    * This method is used to generate random text.
    * @param wordlenght : random word Length, Type int.
    * @return : return random text value.
    */
   public static String randomTextGen(int wordlenght){
		Random ran = new Random();
		char [] chars = "acbdefghijklmnopqrstuvwxyd".toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < wordlenght; i++){
			char charValue = chars[ran.nextInt(chars.length)];
			sb.append(charValue);
		}
		return sb.toString();
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
				/*Reusables.waitForElement(connection_error_message);
				Reusables.verifyEqualMessage(Reusables.getText(Reusables.getElement(connection_error_message)), DataConstants.connectivity_related_message, "Error Message!! Connectivity related issue not coming.");
				Reusables.clickCommand(accept_alert_popup);
				Reusables.waitThread(1);*/
			}catch(NoSuchElementException e){
				Logs.error("Connectivity related issue not coming. "+e.getClass().getName());
			}
		}
		
		
		/**
		 * Verify the Category list on category list page.
		 */
		public static void verifyCategoryList() {
			/*AndroidElement element = null;
			String categoryName = "";
			try {
				Reusables.waitThread(4);
				for (int i = 0; i < DatabaseConnection.getMainCategories().size(); i++) {
					categoryName = DatabaseConnection.getMainCategories().get(i);
					if (Reusables.isElementPresent(By.name(categoryName)) == false) {
						Reusables.swipeUp();
						waitThread(1);
					}
					element = Reusables.getElement(By.name(categoryName));
					Reusables.waitForAndroidElement(element);
					Logs.info("Category Name. "+ element.getAttribute("name").toString() + " Found.");
					}
			}
			catch (NoSuchElementException e) {
				Logs.error("Category " + element.getAttribute("name")+ " not found. " + e.getClass().getName());
				}*/
			}

		/**
		 * This method is used to verify element enable or not.
		 * @param element: Type AndroidElement
		 * @param error: Type String, Error Message
		 */
		public static void verifyElementEnable(AndroidElement element, String error_message) {
			boolean element_status = element.isEnabled();
			try {
				Assert.assertTrue(element_status, error_message);
			} catch (NoSuchElementException e) {
			}
		}

		/**
		 * This method is used to verify element enable or not.
		 * @param element : Type AndroidElement
		 * @param error : Type String, Error Message
		 */
		public static void verifyElementDisable(AndroidElement element, String error_message) {
			boolean element_status = element.isEnabled();
			try {
				Assert.assertFalse(element_status, error_message);
			} catch (NoSuchElementException e) {
			}
		}

		/**
		 * This method is used to verify text present.
		 * @param element : AndroidElement
		 * @param Message : String type
		 */
		public static void verifyElementPresent(AndroidElement element, String Message) {
			boolean status = element.isDisplayed();
			try {
				Assert.assertTrue(status, Message);
			} catch (NoSuchElementException e) {
			}
		}

		/**
		 * This method is used to verify text not present.
		 * @param element : AndroidElement
		 * @param Message : String type
		 */
		public static void verifyElementNotPresent(AndroidElement element,String Message) {
			// System.out.println("Element Status.>"+element.isDisplayed());
			try {
				Assert.assertFalse(Reusables.isElementPresent(element), Message);
			} catch (NoSuchElementException e) {
			}
		}

		/**
		 * This method is used to verify the text that are same;
		 * @param actual_txt : String type
		 * @param expected_txt : String type
		 * @param error_msg : String type
		 */
		public static void verifyEqualMessage(String actual_txt, String expected_txt, String error_msg) {
			String actual_txt_msg = actual_txt.toLowerCase();
			String expected_txt_msg = expected_txt.toLowerCase();
			try {
				Assert.assertEquals(actual_txt_msg, expected_txt_msg, error_msg);
				}catch (NoSuchElementException e) {	
				}
		}

		/**
		 * This method is used to verify text which are not same;
		 * @param actual_txt : String type
		 * @param expected_txt : String type
		 * @param error_msg : String type
		 */
		public static void verifyNotEqualMessage(String actual_txt, String expected_txt, String error_msg) {
			String actual_txt_msg = actual_txt.toLowerCase();
			String expected_txt_msg = expected_txt.toLowerCase();
			try {
				Assert.assertNotEquals(actual_txt_msg, expected_txt_msg, error_msg);
			} catch (NoSuchElementException e) {
			}
		}
		
		/**
		 * This method is used to verify toast message.
		 * @param imageFilepath : Screenshot file location.
		 * @param textMessage : for matching text in image file.
		 * @return
		 */
		public static String verifyToastMessageUsingImage(String imageFilepath, String textMessage){
			String toastMessage = "";
			File file = new File(imageFilepath);
			/* get the Tesseract direct instance */
			Tesseract instance = new Tesseract();
			instance.setDatapath("/usr/local/share/tessdata");
			//instance.setLanguage("");
			if (file.canRead() == true){
				try {
					toastMessage = instance.doOCR(file);
					System.out.println("Toast Message.."+toastMessage);
					Assert.assertTrue(toastMessage.contains(textMessage), "Error Mesage!!Toast Message not matched with expected one.");
					ScreenShot.deleteScreenShotImage(imageFilepath);
					}
				catch (TesseractException e) {
					//e.printStackTrace();
					}
				}
			return toastMessage;
		}
		
		
		/**
		 *  This method is used to perform swipe up operation using start and end element.
		 * @param fromElement : From where
		 * @param toElement : from to.
		 */
		public static void swipeUp(AndroidElement fromElement, AndroidElement toElement){
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
		}
		
		
		/**
		 * This method is used to get the app name.
		 * @return : String as app name.
		 */
		public static String getHeaderName(){
			String appName = "";
			try{
				Reusables.waitForElement(SplashScreen.appHeaderTxtView);
				appName = Reusables.getText(SplashScreen.appHeaderTxtView);
			}catch(NoSuchElementException e){
				Logs.error("App Name not found. "+e.getClass().getName());
			}
			
			return appName;
		}
		
		/**
		 * This method is used to get the app subHeader name.
		 * @return : String as app sub header text.
		 */
		public static String getSubHeaderName(){
			String appName = "";
			try{
				Reusables.waitForElement(SplashScreen.appSubHeaderTxtView);
				appName = Reusables.getText(SplashScreen.appSubHeaderTxtView);
			}catch(NoSuchElementException e){
				Logs.error("App Sub Header Name not found. "+e.getClass().getName());
			}
			
			return appName;
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
		 * This method is used to verify either page loaded or not.
		 * @param pageHeaderTxt : String for verify either page text matched or not.
		 */
		public static void verifyPageLoaded(String pageHeaderTxt){
			try{
				Reusables.waitForElement(SplashScreen.appSubHeaderTxtView);
				Reusables.verifyElementTextPresent(SplashScreen.appSubHeaderTxtView, pageHeaderTxt);
			}catch(NoSuchElementException e){
				Logs.error("Page not loaded. "+e.getClass().getName());
			}
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
}