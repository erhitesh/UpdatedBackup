package com.eduven.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.eduven.constants.DataConstants;


public class DriverInstance {
	
	static AndroidDriver<AndroidElement> driver;
		
	/**
	 * This method is used to set the capabilities for Android driver.
	 * @return cap: Desired capabilities.
	 */
	public static DesiredCapabilities getDesiredCapabilities(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, Capabilities.AutomationName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, Capabilities.PlatformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, Capabilities.PlatformVersion);
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, Capabilities.AppiumVersion);
		cap.setCapability(MobileCapabilityType.APP, Capabilities.AppLocation);
		/*cap.setCapability(MobileCapabilityType.FULL_RESET, "false");
		cap.setCapability(MobileCapabilityType.NO_RESET, "true");*/
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Capabilities.DeviceName);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Capabilities.AppPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Capabilities.AppActivity);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2000);
		
		return cap;
	}

	/**
	 * This method is used to set the capability for Android driver and return the instance of Android driver. 
	 * @return AndroidDriver instance;
	 */
	public static AndroidDriver<AndroidElement> getAndroidDriver(){
		if(driver == null){
			try {
				driver = new AndroidDriver<AndroidElement>(new URL(Capabilities.Url), getDesiredCapabilities());
				driver.manage().timeouts().implicitlyWait(DataConstants.implicitWaitTime, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	
}
