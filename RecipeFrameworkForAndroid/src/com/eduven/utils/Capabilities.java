package com.eduven.utils;

public interface Capabilities {
	
	public static String Automation_Name="Appium";
	public static String Platform_Name="Android";
	public static String Platform_Version="5.1";
	public static String Appium_Version="1.4.13";
	public static String App_Location="/Users/hiteshbhardwaj/Desktop/Automation/app/RecipeFrameworkForAndroid/new/seafood/CCSeafood.apk";
	public static String Url="http://127.0.0.1:4723/wd/hub";
	public static String Device_Name = DeviceRelatedInformation.getDeviceName();
	public static String App_Package = DeviceRelatedInformation.getPackageName();
	public static String App_Activity =DeviceRelatedInformation.getActivityName();
}
