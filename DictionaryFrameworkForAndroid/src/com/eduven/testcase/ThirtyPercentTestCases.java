package com.eduven.testcase;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.eduven.constants.DataConstants;
import com.eduven.modules.HomePage;
import com.eduven.modules.ThirtyPercent;
import com.eduven.utils.ScreenShot;


public class ThirtyPercentTestCases {

	
	/* Global variable declaration */
	String stock_exchange_value = "";
	
	
	@Test(priority=10)
	public void verify_home_page_header_text_test(){
		HomePage.verifyAppName();
	}
	
	@Test(priority=20)
	public void stock_exchange_page_test(){
		ThirtyPercent.navigateToStockWatchPage();
		ThirtyPercent.selectStockExchange();
		ThirtyPercent.getStockExchangeData(); 
		String file = ScreenShot.takescreenShotCaptureForToast();
		 // test toast message using ocr
		ThirtyPercent.verifyToastMessageForStockExchnage(file, DataConstants.toastMessageForStockExchange);
		stock_exchange_value = ThirtyPercent.selectStockExchangeValue();
		ThirtyPercent.verifySelectExchangeValue(stock_exchange_value);
		ThirtyPercent.enterTickelSymbol();
		ThirtyPercent.getStockExchangeData();
		ThirtyPercent.verifyResultForStockExchange();
	}
	
	@Test(priority=30)
	public void currency_cconverter_test(){
		ThirtyPercent.selectCurrencyConverter();
		ThirtyPercent.enterDataForCurrencyConverterFields();
		ThirtyPercent.clickOnConvert();
		ThirtyPercent.verifyCurrencyConverterResult();
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result){
		if (ITestResult.FAILURE == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SKIP == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
		else if (ITestResult.SUCCESS_PERCENTAGE_FAILURE == result.getStatus()){
			ScreenShot.takescreenShotCapture(result.getMethod().getMethodName());
		}
	}
	
	@AfterClass
	public void closeApp(){
		//Reusables.terminatesAppInstance();
	}
}
