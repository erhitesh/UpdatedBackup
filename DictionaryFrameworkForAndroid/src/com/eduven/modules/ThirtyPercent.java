package com.eduven.modules;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import com.eduven.report.Logs;
import com.eduven.utils.DeviceRelatedInformation;
import com.eduven.utils.DriverInstance;
import com.eduven.utils.Reusables;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class ThirtyPercent {
	
	/* Android Driver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Object indentification */
	public static By stock_watch_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/feature2_box");
	public static By loan_calculator_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/feature1_box");
	public static By stock_watch_header_txtView = By.name("Stock Watch");
	public static By stock_exchange_txtView = By.name("Stock Exchange");
	public static By select_exchange_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/company_name");
	public static By enter_tickel_symbol_txtView = By.id(DeviceRelatedInformation.getPackageName()+":id/ticker_name");
	public static By select_stock_title = By.id(DeviceRelatedInformation.getPackageName()+":id/contritexttitle"); 
	public static By select_title = By.xpath("//android.widget.TextView");
	public static By stock_get_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/getstockdata");
	public static By unit_label = By.id(DeviceRelatedInformation.getPackageName()+":id/label");
	public static By value_label = By.id(DeviceRelatedInformation.getPackageName()+":id/label1");
	public static By currency_converter_txt = By.name("Currency Converter");
	public static By currency_amount_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/amount");
	public static By base_currency = By.id(DeviceRelatedInformation.getPackageName()+":id/currency1");
	public static By select_random_value_from_dropDown = By.id("android:id/text1");
	public static By target_currency = By.id(DeviceRelatedInformation.getPackageName()+":id/currency2");
	public static By convert_currency_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/convert");
	public static By currency_convert_result_txt = By.id(DeviceRelatedInformation.getPackageName()+":id/result");
	
	
	// Quick Guide
	public static By quick_quide_txtview = By.id(DeviceRelatedInformation.getPackageName()+":id/feature1_box");
	public static By quick_guide_header_txt = By.name("Quick Guide");
	public static By previous_btn= By.id(DeviceRelatedInformation.getPackageName()+":id/btn_prev");
	public static By next_btn = By.id(DeviceRelatedInformation.getPackageName()+":id/btn_next");
	public static By page_view_number = By.id("android:id/text1");
	
	/**
	 * This method is used to navigate to the stock watch page.
	 */
	public static void navigateToStockWatchPage(){
		try{
			Reusables.waitForElement(stock_watch_txtView);
			Reusables.clickCommand(stock_watch_txtView);
			Reusables.verifyElementPresent(Reusables.getElement(stock_watch_header_txtView), "Error Message!! Stock Exchange Page not found.");
		}catch(NoSuchElementException e){
			Logs.error("Stock Exchange Page not found."+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the Stock Exchange text view.
	 */
	public static void selectStockExchange(){
		try{
			Reusables.waitForElement(stock_exchange_txtView);
			Reusables.clickCommand(stock_exchange_txtView);
		}catch(NoSuchElementException e){
			Logs.error("Select Stock Exchange text view not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to select stock exchange value from Stock Exchange popup.
	 */
	public static String selectStockExchangeValue(){
		String selectedValue = "";
		int randomValue = 0;
		try{
			Reusables.waitForElement(select_exchange_txtView);
			Reusables.clickCommand(select_exchange_txtView);
			Reusables.waitForElement(select_stock_title);
			List<AndroidElement> list = Reusables.getElementsList(select_title);
			randomValue = Reusables.randomNumber(list.size()-1);
			selectedValue = list.get(randomValue).getText();
			list.get(randomValue).click();
		}catch(NoSuchElementException e){
			Logs.error("Selected Stock Exchange Value not found. "+e.getClass().getName());
		}
		
		return selectedValue;
	}
	
	
	/**
	 * This method is used to get String from select stock exchange text view.
	 * @return : Type String, select stock exchange text view value.
	 */
	public static String selectedStockExchangeValue(){
		String selectedStockExchangeValue = "";
		try{
			Reusables.waitForElement(select_exchange_txtView);
			selectedStockExchangeValue = Reusables.getText(select_exchange_txtView);
		}catch(NoSuchElementException e){
			Logs.error("Get value from select exchange textview. "+e.getClass().getName());
		}
		
		return selectedStockExchangeValue;
	}
	
	/**
	 * This method is used to verify select stock exchange value is visible in the text box.
	 * @param expectedValue : type String for comparision.
	 */
	public static void verifySelectExchangeValue(String expectedValue){
		try{
			Reusables.waitForElement(select_exchange_txtView);
			Reusables.verifyEqualMessage(selectedStockExchangeValue(), expectedValue, "Error Message!!Actual & Expected Text not match.");
			}
		catch(NoSuchElementException e){
			Logs.error("Actual & Expected Text not match. "+e.getClass().getName());
			}
		}
	
	
	
	/**
	 * This method is used to enter the tickel text into the tickel textbox.
	 */
	public static void enterTickelSymbol(){
		try{
			Reusables.waitForElement(enter_tickel_symbol_txtView);
			Reusables.enterMessageInTextBox(enter_tickel_symbol_txtView, Reusables.randomTextGenerator(2));
		}catch(NoSuchElementException e){
			Logs.error("Tickel Symbol value not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the get button for getting information related selected stock
	 * exchange and tickel value.
	 */
	public static void getStockExchangeData(){
		try{
			Reusables.waitForElement(stock_get_btn);
			Reusables.clickCommand(stock_get_btn);
		}catch(NoSuchElementException e){
			Logs.error("Get Button not clickable. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify toast message.
	 * @param imageFile
	 */
	public static void verifyToastMessageForStockExchnage(String imageFile, String verifyTextMessage){
		try{
			Assert.assertTrue(Reusables.verifyToastMessageUsingImage(imageFile).contains(verifyTextMessage), "Error Message!!Text not found.");
		}
		catch(NoSuchElementException e){
			Logs.error("Text not found. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to verify Stock Exchange Result.
	 */
	public static void verifyResultForStockExchange(){
		try{
			Reusables.verifyElementPresent(Reusables.getElement(unit_label), "Error Message!!Based on the exchange and tickel symbol value data not found.");
		}catch(NoSuchElementException e){
			Logs.error("Result not found. "+e.getClass().getName());
		}
	}
	

	/**
	 * This method is used to click on the currency converter.
	 */
	public static void selectCurrencyConverter(){
		try{
			Reusables.waitForElement(currency_converter_txt);
			Reusables.clickCommand(currency_converter_txt);
			Reusables.waitForElement(currency_amount_txt);
		}catch(NoSuchElementException e){
			Logs.error("Click operation not perform on the currency converter text view. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the base currency.
	 */
	public static void clickOnBaseCurrency(){
		try{
			Reusables.waitForElement(base_currency);
			Reusables.clickCommand(base_currency);
		}catch(NoSuchElementException e){
			Logs.error("Base Currency not clickable. "+e.getClass().getName());
		}
	}
	
	/**
	 * This method is used to click on the target currency.
	 */
	public static void clickOnTargetCurrency(){
		try{
			Reusables.waitForElement(target_currency);
			Reusables.clickCommand(target_currency);
		}catch(NoSuchElementException e){
			Logs.error("Target Currency not clickable. "+e.getClass().getName());
		}
	}
	
	public static void enterDataForCurrencyConverterFields(){
		int randomNumber;
		try{
			Reusables.waitForElement(currency_amount_txt);
			Reusables.enterMessageInTextBox(currency_amount_txt, Reusables.randomNumberGenerator(5));
			clickOnBaseCurrency();
			List<AndroidElement> baseList = Reusables.getElementsList(select_random_value_from_dropDown);
			randomNumber = Reusables.randomNumber(baseList.size()-1);
			//System.out.println("Random Number.."+randomNumber);
			baseList.get(randomNumber).click();
			Reusables.waitThread(2);
			clickOnTargetCurrency();
			List<AndroidElement> targetList = Reusables.getElementsList(select_random_value_from_dropDown);
			randomNumber = Reusables.randomNumber(targetList.size()-1);
			targetList.get(randomNumber).click();
			Reusables.waitThread(2);
			
		}catch(NoSuchElementException e){
			Logs.error("Enable to enter text data into the textview. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to click on the currency converter button.
	 */
	public static void clickOnConvert(){
		try{
			Reusables.waitForElement(convert_currency_btn);
			Reusables.clickCommand(convert_currency_btn);
		}catch(NoSuchElementException e){
			Logs.error("Currency converter button not found. "+e.getClass().getName());
		}
	}
	
	
	/**
	 * This method is used to get the currency conveter result.
	 */
	public static String getCurrencyConverterReuslt(){
		String result = "";
		try{
			Reusables.waitForElement(currency_convert_result_txt);
			result = Reusables.getText(currency_convert_result_txt);
		}catch(NoSuchElementException e){
			Logs.error("Currency converter button not found. "+e.getClass().getName());
		}
		
		return result;
	}
	
	
	/**
	 * This method is used to verify currency result.
	 */
	public static void verifyCurrencyConverterResult(){
		if (Reusables.isElementPresent(currency_convert_result_txt) == true){
			Reusables.verifyElementTextPresent(currency_convert_result_txt, "Result");
		}
		else if (Reusables.isElementPresent(currency_convert_result_txt) == false){
			Assert.fail("Result not found based on the given data.");
		}
	}
	
}
