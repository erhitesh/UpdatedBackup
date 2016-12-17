package com.eduven.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class ScreenShot {
	
	
	/**
	 * This method is used to take screenshot of the failed test case.
	 * @param name: name of the screenshot
	 * @throws IOException 
	 */
	public static void takescreenShotCapture(String testcaseName){
		
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/RecipeFrameworkForAndroid/ScreenCaptures/";
		String sample_date = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss-aa").format(new Date());
		File src_file = ((TakesScreenshot) Reusables.driver).getScreenshotAs(OutputType.FILE);
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
		String screenshot_lacation = "/Users/hiteshbhardwaj/Desktop/Automation/workspace/RecipeFrameworkForAndroid/ScreenCaptures/";
		File src_file = ((TakesScreenshot) Reusables.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src_file, new File(screenshot_lacation+".PNG"));
			fileName = screenshot_lacation+".PNG";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	/**
	 * This method is used to delete the screenshot image used to verify toast message.
	 */
	public static void deleteScreenShotImage(String imageName){
		File file = new File(imageName);
		if (file.exists()){
			file.delete();
			//System.out.println("done");
		}
	}
}
