package com.eduven.utils;

public interface Capabilities {
	
	public static String AutomationName="Appium";
	public static String PlatformName="Android";
	public static String BrwoserName = "browser";
	public static String PlatformVersion="6.0.1";
	public static String AppiumVersion="1.4.13";
	public static String AppLocation="/Users/hiteshbhardwaj/Desktop/Automation/app/LanguagesForAndroid/Danish/app-danish-debug.apk";
	public static String Url="http://127.0.0.1:4723/wd/hub";
	public static String DeviceName = DeviceRelatedInformation.getDeviceName();
	public static String AppPackage = DeviceRelatedInformation.getPackageName();
	public static String AppActivity = DeviceRelatedInformation.getActivityName();
	public static String deviceVersion = DeviceRelatedInformation.getDeviceVersionName();
	
}
