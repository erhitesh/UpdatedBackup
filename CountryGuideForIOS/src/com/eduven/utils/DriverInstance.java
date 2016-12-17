package com.eduven.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverInstance {
	
		static IOSDriver<IOSElement> driver;
	
	/**
	 * This method is used to set the capabilities for ios driver.
	 * @return cap: Desired capabilities.
	 */
	public static DesiredCapabilities getDesiredCapabilities(){
		File appLoc = new File(Capabilities.appLocation);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, Capabilities.automationName);
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, Capabilities.appiumVersion);
		cap.setCapability(CapabilityType.PLATFORM, Capabilities.platformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, Capabilities.platformVersion);
		cap.setCapability(MobileCapabilityType.APP, appLoc.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Capabilities.deviceName);
		cap.setCapability(MobileCapabilityType.UDID, Capabilities.udid);
		
		return cap;
	}

	/**
	 * This method is used to set the capability for ios driver and return the instance of ios driver. 
	 * @return IOSDriver instance;
	 */
	public static IOSDriver<IOSElement> getIosDriver(){
		if(driver == null){
			try {
				driver = new IOSDriver<IOSElement>(new URL(Capabilities.url), getDesiredCapabilities());
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
