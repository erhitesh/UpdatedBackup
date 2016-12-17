package com.eduven.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.eduven.constants.DataConstants;
import com.eduven.reports.Logs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class DriverInstance {
	
	
	static AndroidDriver<AndroidElement> driver;
		
	/**
	 * This method is used to set the capabilities for Android driver.
	 * @return cap: Desired capabilities.
	 */
	public static DesiredCapabilities getDesiredCapabilities(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, Capabilities.Automation_Name);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Capabilities.Platform_Name);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, Capabilities.Platform_Version);
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, Capabilities.Appium_Version);
		cap.setCapability(MobileCapabilityType.APP, Capabilities.App_Location);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Capabilities.Device_Name);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Capabilities.App_Package);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Capabilities.App_Activity);
	
		return cap;
	}

	/**
	 * This method is used to set the capability for Android driver and return the instance of Android driver. 
	 * @return AndroidDriver instance;
	 */
	public static AndroidDriver<AndroidElement> getAndroidDriver(){
		if (driver == null){
			try {
				driver = new AndroidDriver<AndroidElement>(new URL(Capabilities.Url), getDesiredCapabilities());
				Logs.info("Android Driver Instantiating...");
				driver.manage().timeouts().implicitlyWait(DataConstants.implicitWaitTime, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
				}
		}
		return driver;
	}
}
