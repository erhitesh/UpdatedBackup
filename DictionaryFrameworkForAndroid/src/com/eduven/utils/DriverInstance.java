package com.eduven.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.eduven.constants.DataConstants;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


public class DriverInstance {
	
		static AndroidDriver<AndroidElement> driver;
		public static final String USERNAME = "qa_sauce_lab";
		  public static final String ACCESS_KEY = "bcee1cb1-e090-48fb-9984-91eb86ce330b";
		  public static final String url = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
		 
		
	
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
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Capabilities.DeviceName);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Capabilities.AppPackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Capabilities.AppActivity);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 2000);
		
		// for sauce lab
		/* DesiredCapabilities cap = new DesiredCapabilities();
		    cap.setCapability("appiumVersion", "1.4.16");
			cap.setCapability("deviceName","Android Emulator");
			cap.setCapability("deviceType","phone");
			cap.setCapability("deviceOrientation", "portrait");
			cap.setCapability("browserName", "");
			cap.setCapability("platformVersion","5.1");
			cap.setCapability("platformName","Android");
			cap.setCapability("app","sauce-storage:my_apk.apk");
			cap.setCapability("name", "bhardwaj_test");*/
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
