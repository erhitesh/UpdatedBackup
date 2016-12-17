package com.eduven.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.eduven.constants.DataConstants;


public class DriverInstance {
	
		static IOSDriver<IOSElement> driver;
	
	/**
	 * This method is used to set the capabilities for IOS driver.
	 * @return cap: Desired capabilities.
	 */
	public static DesiredCapabilities getDesiredCapabilities(){
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, Capabilities.automationName);
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, Capabilities.appiumVersion);
		cap.setCapability(MobileCapabilityType.PLATFORM, Capabilities.platformName);
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, Capabilities.platformVersion);
		cap.setCapability(MobileCapabilityType.APP, Capabilities.appLocation);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Capabilities.deviceName);
		cap.setCapability(MobileCapabilityType.UDID, Capabilities.udid);
		
		return cap;
	}

	/**
	 * This method is used to set the capability for IOS driver and return the instance of IOS driver. 
	 * @return : IOSDriver instance;
	 */
	public static IOSDriver<IOSElement> getIosDriver(){
		
		if(driver == null){
			try {
				/*DeviceRelatedInformation.stopServer();
				DeviceRelatedInformation.startAppium();*/
				driver = new IOSDriver<IOSElement>(new URL(Capabilities.url), getDesiredCapabilities());
				driver.manage().timeouts().implicitlyWait(DataConstants.implicitWaitTime, TimeUnit.SECONDS);
			
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
	
	
}
