package com.eduven.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;


public class ScreenShot {
	
	/* IOSDriver Instance */
	  static IOSDriver<IOSElement> driver = DriverInstance.getIosDriver();
	  
	/**
	 * This method is used to take screenshot of the failed test case.
	 * @param name: name of the screenshot
	 * @throws IOException 
	 */
	public static void takesScreenShotCapture(String testcaseName){
		
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/RecipeFrameworkForIos/ScreenCaptures/";
		String sample_date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-aa").format(new Date());
		File src_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src_file, new File(screenshot_lacation+testcaseName+sample_date+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
