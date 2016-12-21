package com.eduven.utils;

import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.eduven.constants.DataConstants;
import com.eduven.modules.Categories;
import com.eduven.modules.TermDetailPage;
import com.eduven.modules.WordSearchList;
import com.eduven.report.Logs;


public class Reusables {


	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();

	/* Locator value */
	public static By interstetialBtn = By.xpath("//*[@content-desc='Interstitial close button']");
	public static By acceptAlertPopup = By.id("android:id/button1");
	public static By connectionErrorMessage = By.id("android:id/message");
	public static By webviewConnectionErrorMessage = By.xpath("//android.view.View[starts-with(@content-desc,'You')]");


	/**
	 * This method is used to hide the industrialization.
	 */
	public static void hideInterstetial() {
		Reusables.waitThread(2);
		try {
			if (Reusables.isElementPresent(interstetialBtn)) {
				clickCommand(interstetialBtn);
				Reusables.waitThread(1);
			}
			else if (!Reusables.isElementPresent(interstetialBtn)) {
			}
		}
		catch (NoSuchElementException e) {
			Logs.error("Interstetial advertising still visible....... "+ e.getClass().getName());
		}
	}

	/**
	 * This method id used for wait for particular element.
	 * @param by element locator value
	 */
	public static void waitForElement(By by) {
		int timeOutInSeconds = 60;
		try {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch (NoSuchElementException e) {
			Logs.error("Elemement not found. " + e.getClass().getName());
		}
	}

	/**
	 * This method id used for wait for particular element to be invisible.
	 * @param by element locator value
	 */
	public static void waitForElementInvisible(By by) {
		int timeOutInSeconds = 60;
		try {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.invisibilityOfElementLocated(by));
		} catch (NoSuchElementException e) {
			Logs.error("Elemement found. " + e.getClass().getName());
		}
	}

	/**
	 * This method id used for wait for particular AndroidElement.
	 * @param element : AndroidELement
	 */
	public static void waitForAndroidElement(AndroidElement element) {
		int timeOutInSeconds = 60;
		try {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
		} catch (NoSuchElementException e) {
			Logs.error("Elemement not found. " + e.getClass().getName());
		}
	}

	/**
	 * This method is used to wait for an alert to be visible.
	 */
	public static void waitForAlert() {
		int timeOutInSeconds = 60;
		try {
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.alertIsPresent());
		}
		catch (NoSuchElementException e) {
		}
	}

	/**
	 * this method is used to wait for a time explicitly.
	 * @param timeOutInSeconds : type int(seconds)
	 */
	public static void waitThread(int timeOutInSeconds) {
		try {
			Thread.sleep(timeOutInSeconds * 1000);
		} catch (InterruptedException e) {
			Logs.info("Wait for the " + timeOutInSeconds + " Seconds");
		}
	}

	/**
	 * This method is used to verify element present or not.
	 * @param by : Locator type.
	 * @return : Return boolean value either true or false.
	 */
	public static boolean isElementPresent(By by) {
		try {
			getElement(by);
			return true;
		} catch (NoSuchElementException e) {
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
	 * This method is used to back one step .
	 */
	public static void stepBack() {
		waitThread(2);
		driver.navigate().back();
	}

	/**
	 * This method is used to forward one step.
	 */
	public static void stepForward() {
		driver.navigate().forward();
	}

	/**
	 * This method is used to switch to web view.
	 * @param webview : type integer
	 */
	public static void switchToWebView(int webview) {
		waitThread(3);
		List<String> context_handles = new ArrayList<String>(driver.getContextHandles());
		driver.context(context_handles.get(webview));
		waitThread(3);

	}

	/**
	 * This method is used to perform tap operation
	 * @param by : locator type
	 */
	public static void tapOnElementUsingLocator(By by) {
		AndroidElement element = driver.findElement(by);
		driver.tap(1, element, 1000);
	}

	/**
	 * This method is used to perform tap operation
	 * @param fingers: how many finger, type int
	 * @param x: X axis point
	 * @param y: Y axis point
	 */
	public static void tapOnElementUsingCoordinates(int fingers, int x, int y) {
		try {
			Reusables.waitThread(1);
			driver.tap(fingers, x, y, 1000);
			Reusables.waitThread(1);
		} catch (NoSuchElementException e) {
			Logs.error("Tap does no perform on the given coordinates... "+ e.getClass().getName());
		}
	}

	/**
	 * This method is used to perform click operation.
	 * @param by : Locator type
	 */
	public static void clickCommand(By by) {
		try {
			Reusables.waitThread(1);
			AndroidElement element = driver.findElement(by);
			element.click();
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * This method is used to perform click operation using element.
	 * @param element: AndroidElement.
	 */
	public static void clickUsingElement(AndroidElement element) {
		waitForAndroidElement(element);
		element.click();
	}

	/**
	 * This method is used to perform click operation using locator String.
	 * @param entity_name: Perform click operation on entity.
	 */
	public static void clickUsingString(String termName) {
		getElement(By.name(termName)).click();
	}

	/**
	 * This method is used to get the text value of element
	 * @param by: locator type
	 * @return : String value
	 */
	public static String getText(By by) {
		return driver.findElement(by).getAttribute("name").trim().toString();
	}

	/**
	 * This method is used to get the text value of element.
	 * @param element: AndroidElement as locator value.
	 * @return : String value, as text.
	 */
	public static String getText(AndroidElement element) {
		return element.getText().toString().trim();
	}

	/**
	 * This method is used to generate random number.
	 * @param number: type int
	 * @return: return the generated random number.
	 */
	public static int randomNumber(int number) {
		int randomNumber = 0;
		try {
			Random ran = new Random();
			randomNumber = ran.nextInt(number);
		} catch (NoSuchElementException e) {
		}

		return randomNumber;
	}

	/**
	 * This method is used to generate random number from the given string.
	 * @param wordlenght : word length, type int.
	 * @return : String as generated text.
	 */
	public static String randomTextGenerator(int wordlenght){
		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		String str = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char [] chars = str.toCharArray();
		for (int i = 0; i < wordlenght; i++){
			sb.append(chars[ran.nextInt(chars.length)]);
		}
		//System.out.println("Random text Generator for tickel symbol. "+sb.toString());
		return sb.toString().toLowerCase();
	}

	/**
	 * This method is used to generate random special character from the given string.
	 * @param wordlenght : word length, type int.
	 * @return : String as generated text.
	 */
	public static String randomSpecialTextGenerator(int wordlenght){
		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		String str = "0123456789......#$%@&*(0)!,.,;;;";
		char [] chars = str.toCharArray();
		for (int i = 0; i < wordlenght; i++){
			sb.append(chars[ran.nextInt(chars.length)]);
		}

		return sb.toString().toLowerCase();
	}

	/**
	 * This method is used to generate the random number.
	 * @param intCount number length
	 * @return
	 */
	public static String randomNumberGenerator(int intCount){
		String number = "";
		try{
			number = RandomStringUtils.randomNumeric(intCount);
			//System.out.println("Random Number.."+number);
		}
		catch(NoSuchElementException e){
		}

		return number;
	}

	public static ArrayList<String> getCategoryList(String list,String stringSeparator) {
		return new ArrayList<String>(Arrays.asList(list.split(stringSeparator))); 
	}

	/**
	 * This method is used to perform swipe up from one element to another one.
	 * @param fromElement : AndroidElement type start swiping from
	 * @param toElement : AndroidElement type end swiping.
	 */
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
	}

	/**
	 * For swipe Up.
	 */
	public static void swipeUp() {
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int startx = width / 2;
		int starty = (int) (height * 0.6);
		int endx = width / 2;
		int endy = (int) (height * 0.2);
		driver.swipe(startx, starty, endx, endy, 1000);
	}

	/**
	 * For Custom swipe Up.
	 */
	public static void customSwipeUp(float startY, float endY) {
		Dimension size = driver.manage().window().getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int startx = width / 2;
		int starty = (int) (height * startY);
		int endx = width / 2;
		int endy = (int) (height * endY);
		driver.swipe(startx, starty, endx, endy, 1000);
	}

	/**
	 * For Custom swipe Down.
	 */
	public static void swipeDown() {
		Dimension size = driver.manage().window().getSize();// findElement(By.className("android.view.View")).getSize();
		int width = size.getWidth();
		int height = size.getHeight();
		int startx = width / 2;
		int starty = (int) (height * 0.3);
		int endx = width / 2;
		int endy = (int) (height * 0.6);
		driver.swipe(startx, starty, endx, endy, 1000);
	}

	// ********************************************************************

	/**
	 * This method is used to launch the app.
	 */
	public static void launchApp() {
		Logs.info("App is Launching... ");
		driver.launchApp();
	}

	/**
	 * This method is used to close the Appium current instance.
	 */
	public static void terminatesAppInstance() {
		driver.resetApp();
	}

	/**
	 * This method is used to run APP in background for the specified time.
	 * @param time: type int
	 */
	public static void runAppInBackground(int time) {
		driver.runAppInBackground(time);
		try {
			waitThread(time);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to enter text message in the text box
	 * @param by: locator type
	 * @param txt: String message text
	 */
	public static void enterMessageInTextBox(By by, String txtMsg) {
		AndroidElement element = getElement(by);
		element.click();
		element.clear();
		element.sendKeys(txtMsg);
		Logs.info(">>>>>>>>>>>Entered text message. "+ txtMsg);
		Reusables.stepBack();
	}

	/**
	 * This method is used to hide the keyboard appup.
	 * @param key : String type for hide the keyboard.
	 */
	public static void hideKeyboard(String key) {
		try {
			waitThread(1);
			if (key.equalsIgnoreCase("done")) {
				driver.hideKeyboard();
			} else if (key.equalsIgnoreCase("return")) {
				driver.hideKeyboard();
			} else if (key.equalsIgnoreCase("no key")) {
				driver.hideKeyboard();
			}
		} catch (NoSuchElementException e) {
			Logs.error(">>>>>>>>>>>>>Keyboard is still opening>>>>>>>. ");
		}
	}

	/**
	 * This method is used to return the AndroidElement.
	 * @param by: Locator type.
	 * @return return element.
	 */
	public static AndroidElement getElement(By by) {
		waitThread(1);
		return driver.findElement(by);
	}

	/**
	 * This method is used to return the AndroidElement list.
	 * @param by: Locator type.
	 * @return return element.
	 */
	public static List<AndroidElement> getElementsList(By by) {
		// waitForElement(by);
		return driver.findElements(by);

	}


	/**
	 * This method is used to return random entity name.
	 * @param category : Category name, type String.
	 * @return : Category sub entity name.
	 */
	public static String random_category_entity_name(String category) {
		String name = "";
		try {
			ArrayList<String> list_size = getCategoryList(category, "~");
			name = list_size.get(randomNumber(list_size.size()));
		} catch (NoSuchElementException e) {
			Logs.error("*******************Does not return any entity name from given category.....");
		}

		return name;
	}

	/**
	 * This method is used to perform scroll to exact text.
	 * @param name : Type String
	 */
	public static void scrollToExactTxt(String name) {
		waitThread(1);
		driver.scrollToExact(name.toString());
	}

	/**
	 * This method is used to perform scroll to exact text and perform click operation on the text value.
	 * @param name : name of the entity to be click
	 */
	public static void clickUsingSrollToExactTxt(String name) {
		driver.scrollToExact(name).click();
	}

	/**
	 * This method is used to click and hold on any element.
	 */
	public static void clickAndHoldOperation(AndroidElement element) {
		TouchAction action = new TouchAction(driver);
		action.longPress(element, 1000).perform().release();
	}

	/**
	 * This method is used to get app screen size.
	 */
	public static Dimension getAppScreenSize() {

		return driver.findElement(By.className("android.view.View")).getSize();

	}

	/**
	 * Verify the Category list on category list page.
	 */
	public static void verifyCategoryList() {
		AndroidElement element = null;
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
		}
	}

	/**
	 * This method is used to verify element enable or not.
	 * @param element: Type AndroidElement
	 * @param error: Type String, Error Message
	 */
	public static void verifyElementEnable(AndroidElement element, String errorMessage) {
		boolean elementStatus = element.isEnabled();
		try {
			Assert.assertTrue(elementStatus, errorMessage);
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * This method is used to verify element enable or not.
	 * @param element : Type AndroidElement
	 * @param error : Type String, Error Message
	 */
	public static void verifyElementDisable(AndroidElement element, String errorMessage) {
		boolean elementStatus = element.isEnabled();
		try {
			Assert.assertFalse(elementStatus, errorMessage);
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * This method is used to verify text present.
	 * @param element : AndroidElement
	 * @param errorMessage : String type
	 */
	public static void verifyElementPresent(AndroidElement element, String errorMessage) {
		boolean status = element.isDisplayed();
		try {
			Assert.assertTrue(status, errorMessage);
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * This method is used to verify text not present.
	 * @param element : AndroidElement
	 * @param Message : String type
	 */
	public static void verifyElementNotPresent(AndroidElement element, String errorMessage) {
		try {
			Assert.assertFalse(Reusables.isElementPresent(element), errorMessage);
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * This method is used to verify the text that are same;
	 * @param actual_txt : String type
	 * @param expected_txt : String type
	 * @param error_msg : String type
	 */
	public static void verifyEqualMessage(String actualMessageTxt, String expectedMessage, String errorMessage) {
		String actual_txt_msg = actualMessageTxt.toLowerCase();
		String expected_txt_msg = expectedMessage.toLowerCase();
		try {
			Assert.assertEquals(actual_txt_msg, expected_txt_msg, errorMessage);
		}catch (NoSuchElementException e) {	
		}
	}

	/**
	 * This method is used to verify text which are not same;
	 * @param actual_txt : String type
	 * @param expected_txt : String type
	 * @param error_msg : String type
	 */
	public static void verifyNotEqualMessage(String actualMessageTxt, String expectedMessage, String errorMessage) {
		String actual_txt_msg = actualMessageTxt.toLowerCase();
		String expected_txt_msg = expectedMessage.toLowerCase();
		try {
			Assert.assertNotEquals(actual_txt_msg, expected_txt_msg, errorMessage);
		} catch (NoSuchElementException e) {
		}
	}

	/**
	 * This method is used to verify element count present.
	 * @param by : Locator type
	 * @param status : for checking condition inside method.
	 */
	public static void verifyElementCountExistance(By by, boolean status) {
		int elementCount = 0;
		try {
			elementCount = Reusables.getElementsList(by).size();
			if (status == true && elementCount > 0) {
				Assert.assertTrue(elementCount >= 1,"Error Message!! Element not exists.");
			} else if (status == false && elementCount < 0) {
				Assert.assertFalse(elementCount < 0,"Error Message!! Element exists.");
			}
		} catch (NoSuchElementException e) {

		}
	}


	/**
	 * This method is used to count the total number of element visible.
	 * @param by : Locator type.
	 * @return : return int, total number element found.
	 */
	public static int elementCount(By by) {

		return driver.findElements(by).size();
	}

	/**
	 * This method is used to get the text value of list element.
	 * @param by : locator type
	 * @param indexValue : type integer, which value you want from list.
	 * @return : type String, text value from list element.
	 */
	public static String getTextFromList(By by, int indexValue) {

		return driver.findElements(by).get(indexValue).getText().trim().toString();
	}

	/**
	 * This method is used to perform click operation on index basis.
	 * @param element : Type IOSElement
	 * @param index : Type int.
	 */
	public static void clickUsingElementList(List<AndroidElement> element,int index) {
		element.get(index).click();
		waitThread(1);
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	/**
	 * This method is used to navigate to premium term page and verify premium entity
	 * @param mainCategoryName : String type for selecting main category.
	 * @param subCategoryName : For choose the subCategory inside mainCategory.
	 */
	public static String checkPremiumTerm(String mainCategoryName) {
		String paidTerm = "";
		String randomCategoryName = "";
		paidTerm = DatabaseConnection.getLockTerm(mainCategoryName);
		System.out.println("Paid Term Name..." + paidTerm);
		while (paidTerm.length() == 0) {
			Reusables.stepBack();
			randomCategoryName = Categories.clickOnRandomCategory();
			paidTerm = DatabaseConnection.getLockTerm(randomCategoryName);
		}
		List<AndroidElement> indexListSize = Reusables.getElementsList(WordSearchList.indexList);
		for (int i = 0; i < indexListSize.size(); i++){
			if (indexListSize.get(i).getText().trim().equalsIgnoreCase(paidTerm.charAt(0)+"".trim())){
				indexListSize.get(i).click();
				break;
			}
		}
		List<AndroidElement> termList = Reusables.getElementsList(WordSearchList.termCount);
		while (!Reusables.isElementPresent(By.name(paidTerm))) {
			Reusables.waitThread(2);
			Reusables.swipeUp(termList.get(termList.size()-1), termList.get(2));
			Reusables.waitThread(1);
		}
		Reusables.clickCommand(By.name(paidTerm));
		Reusables.waitThread(2);
		Reusables.hideInterstetial();
		if (isElementPresent(TermDetailPage.unlockNowBtn) == true) {
			TermDetailPage.verifyUnlockButtonExistance();
			Reusables.stepBack();
			TermDetailPage.submitContributeLaterPopupMessage(mainCategoryName);
			/* Wait for moment for enable the add........... */
			waitThread(4);
			hideInterstetial();
		} else {
			Logs.error("Paid Term Name..> " + paidTerm + "Not Found.");
		}

		return paidTerm;
	}

	/**
	 * This method is used to navigate to free term page and verify free entity element.
	 * @param categoryName : String type for selecting main category.
	 */
	public static String checkFreeTerm(String categoryName) {
		String freeTerm = DatabaseConnection.getUnLockTerm(categoryName);
		System.out.println("Free Term Name..." + freeTerm);
		waitThread(2);
		List<AndroidElement> indexListSize = Reusables.getElementsList(WordSearchList.indexList);
		for (int i = 0; i < indexListSize.size(); i++){
			if (indexListSize.get(i).getText().trim().equalsIgnoreCase(freeTerm.charAt(0)+"".trim())){
				indexListSize.get(i).click();
				break;
			}
		}
		List<AndroidElement> termList = Reusables.getElementsList(WordSearchList.termCount);
		while (!Reusables.isElementPresent(By.name(freeTerm))) {
			Reusables.waitThread(2);
			Reusables.swipeUp(termList.get(termList.size()-1), termList.get(2));
			Reusables.waitThread(1);
		}
		Reusables.clickUsingString(freeTerm);
		/* Wait for moment for enable the add........... */
		waitThread(3);
		hideInterstetial();
		if (isElementPresent(TermDetailPage.favouriteIcon)) {
			TermDetailPage.checkFavIcon();
			/*stepBack();
			waitThread(3);
			hideInterstetial();*/
		} else {
			Logs.error("Free Term Name..> " + freeTerm + "Not Found.");
		}

		return freeTerm;
	}

	/**
	 * This method is used to navigate to the free entity detail page.
	 * @param mainCategoryName : String type for selecting main category.
	 * @param subCategoryName : For choose the subCategory inside mainCategory.
	 * @return termName as selected term for further verification.
	 */
	public static String navigateToFreeTermDetailPage(String mainCategoryName, String subCategoryName) {
		String freeTerm = DatabaseConnection.getUnLockTerm(mainCategoryName).trim();
		System.out.println("Free Entity for Detail Page..." + freeTerm);
		waitThread(2);
		List<AndroidElement> indexListSize = Reusables.getElementsList(WordSearchList.indexList);
		for (int i = 0; i < indexListSize.size(); i++){
			if (indexListSize.get(i).getText().trim().equalsIgnoreCase(freeTerm.charAt(0)+"".trim())){
				indexListSize.get(i).click();
				break;
			}
		}
		List<AndroidElement> termList = Reusables.getElementsList(WordSearchList.termCount);
		while (!Reusables.isElementPresent(By.name(freeTerm))) {
			Reusables.waitThread(2);
			Reusables.swipeUp(termList.get(termList.size()-1), termList.get(1));
			Reusables.waitThread(1);
		}
		/* Wait for moment for enable the add........... */
		waitThread(3);
		hideInterstetial();
		if (isElementPresent(TermDetailPage.favouriteIcon) == true) {
			TermDetailPage.checkFavIcon();
		} else {
			Logs.error("Free Term Name.. " + freeTerm + " not found. ");
		}

		return freeTerm;
	}

	/**
	 * This method is used to navigate to the paid entity detail page.
	 * @param mainCategoryName : String type for selecting main category.
	 * @param subCategoryName : For choose the subCategory inside mainCategory.
	 * @return termName as selected term for further verification.
	 */
	public static String navigateToPremiumTermDetailPage(String mainCategoryName) {
		String paidTerm = "";
		paidTerm = DatabaseConnection.getLockTerm(mainCategoryName);
		while (paidTerm.length() == 0) {
			Reusables.stepBack();
			paidTerm = DatabaseConnection.getLockTerm(mainCategoryName);
		}
		System.out.println("Paid Term Name..." + paidTerm);
		waitThread(1);
		List<AndroidElement> indexListSize = Reusables.getElementsList(WordSearchList.indexList);
		for (int i = 0; i < indexListSize.size(); i++){
			if (indexListSize.get(i).getText().trim().equalsIgnoreCase(paidTerm.charAt(0)+"".trim())){
				indexListSize.get(i).click();
				break;
			}
		}
		List<AndroidElement> termList = Reusables.getElementsList(WordSearchList.termCount);
		while (!Reusables.isElementPresent(By.name(paidTerm))) {
			Reusables.waitThread(2);
			Reusables.swipeUp(termList.get(termList.size()-1), termList.get(1));
			Reusables.waitThread(1);
		}
		if (isElementPresent(TermDetailPage.unlockNowBtn) == true) {
			/* Wait for moment for enable the add */
			waitThread(4);
			hideInterstetial();
		} else {
			Logs.error("Paid Entity Detail page not open. > " + paidTerm+ " Not Found. ");
		}
		return paidTerm;
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
	 * This method is used to get element status either true or false as boolean value.
	 * @param by : AndroidElement type for identified element.
	 * @return : return boolean as element status.
	 */
	public static boolean checkElementVisibilityStatus(By by){
		boolean elementVisivilityStatus = false;
		try{
			elementVisivilityStatus = Reusables.getElement(by).isDisplayed();

		}catch(NoSuchElementException e){
			//Logs.error("Element not found. "+e.getClass().getName());
		}

		return elementVisivilityStatus;
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
			Reusables.waitForElement(connectionErrorMessage);
			Reusables.verifyEqualMessage(Reusables.getText(Reusables.getElement(connectionErrorMessage)), DataConstants.connectivityRelatedMessage, "Error Message!! Connectivity related issue not coming.");
			Reusables.clickCommand(acceptAlertPopup);
			Reusables.waitThread(1);
		}catch(NoSuchElementException e){
			Logs.error("Connectivity related issue not coming. "+e.getClass().getName());
		}
	}


	/**
	 * This method is used to verify connection relates problem.
	 */
	public static void verifyConnectionErrorForWebView(){
		try{
			Reusables.waitForElement(webviewConnectionErrorMessage);
			Reusables.waitThread(1);
		}catch(NoSuchElementException e){
			Logs.error("Connectivity related issue not coming. "+e.getClass().getName());
		}
	}

	/**
	 * This method is used to verify toast message.
	 * @param imageFile
	 * @return
	 */
	public static String verifyToastMessageUsingImage(String imageFile){
		String toastMessage = "";
		File file = new File(imageFile);
		//get the Tesseract direct interace
		Tesseract instance = new Tesseract();
		instance.setDatapath("/usr/local/share/tessdata");
		//instance.setLanguage("");
		if (file.canRead() == true){
			try {
				toastMessage = instance.doOCR(file);
			} catch (TesseractException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Toast Message..."+toastMessage);
		return toastMessage;
	}

	public static File verifyToastMessageUsingBuffer(AndroidElement element){
		File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// create an instance of buffered image from captured screenshot
		BufferedImage img = null;
		try {
			img = ImageIO.read(src_file);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// get the width and height of the WebElement using getSize()
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		// create a rectangle using width and height
		Rectangle rect = new Rectangle(width, height);

		// get the location of WebElement in a Point.
		// this will provide X & Y co-ordinates of the WebElement
		Point p = element.getLocation();

		// create image  for element using its location and size.
		// this will give image data specific to the WebElement
		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), rect.width,rect.height);

		// write back the image data for element in File object
		try {
			ImageIO.write(dest, "png", src_file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return the File object containing image data
		return src_file;
	}
}