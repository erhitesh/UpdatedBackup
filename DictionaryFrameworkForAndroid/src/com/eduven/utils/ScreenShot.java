package com.eduven.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenShot {
	  static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	  
	/**
	 * This method is used to take screenshot of the failed test case.
	 * @param name: name of the screenshot
	 * @throws IOException 
	 */
	public static void takescreenShotCapture(String testcaseName){
		
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/DictionaryFrameworkForAndroid/ScreenCaptures/";
		String sample_date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-aa").format(new Date());
		File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src_file, new File(screenshot_lacation+testcaseName+sample_date+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		}
	
	
	/**
	 * This method is used to take screenshot of the failed test case.
	 * @param name: name of the screenshot
	 * @throws IOException 
	 */
	public static String takescreenShotCaptureForToast(){
		String fileName = "";
		String sample_date = "";
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/DictionaryFrameworkForAndroid/ScreenCaptures/";
		sample_date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-aa").format(new Date());
		File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src_file, new File(screenshot_lacation+sample_date+".PNG"));
			fileName = screenshot_lacation+sample_date+".PNG";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
		
		/*File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Tesseract tesser = new Tesseract();
			try {
				System.out.println("Check"+tesser.doOCR(ImageIO.read(src_file)));
				System.out.println("Check"+tesser.doOCR(ImageIO.read(src_file)).contains("Stock Exchange"));
			} catch (TesseractException e) {
			}
		} catch (IOException e) {
		}*/
		}
	}
