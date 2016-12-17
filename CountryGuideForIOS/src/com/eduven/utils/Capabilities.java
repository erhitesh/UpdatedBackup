package com.eduven.utils;

public interface Capabilities {
	
	public static String automationName = "Appium";
	public static String platformName = "IOS";
	public static String platformVersion = "9.2";
	public static String appiumVersion = "1.4.13";
	public static String appLocation = "/Users/hiteshbhardwaj/Desktop/Automation/app/DictionaryFrameworkIos/LD SOCCER.ipa";
	public static String url = "http://127.0.0.1:4723/wd/hub";
	public static String deviceName = DeviceRelatedInformation.getDeviceName();
	public static String udid = DeviceRelatedInformation.getUDID();
	
}
