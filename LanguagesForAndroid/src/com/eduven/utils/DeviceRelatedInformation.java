package com.eduven.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DeviceRelatedInformation{
	

	/* AndroidDriver instance */
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
	/* Global variable Declaration */
	static String deviceVersion_command = "/Users/hiteshbhardwaj/Desktop/android-sdk-macosx/platform-tools/adb shell getprop | grep build.version.release";
	static String device_command = "/Users/hiteshbhardwaj/Desktop/android-sdk-macosx/platform-tools/adb devices";
	static String package_command = "/Users/hiteshbhardwaj/Desktop/android-sdk-macosx/build-tools/23.0.2/aapt dump badging "+Capabilities.AppLocation;
	
    /*  Get Device Name */
	public static String getDeviceName(){
		String DeviceName="Could not find device!!";
		Runtime rt = Runtime.getRuntime();
		
		StringBuffer buffer = new StringBuffer();
		try {
			Process proc = rt.exec(device_command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			
			while((s = stdInput.readLine()) != null){
				buffer.append(s);	
				DeviceName = buffer.toString().replaceAll("List of devices attached", "").replaceAll("device", "").trim();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return DeviceName;
	}
	
	
	
	/* Get Package Name */
	public static String getPackageName(){
		String PackageName="Could not find package name!!";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(package_command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if (s.contains("package: name")){
					Pattern pattern = Pattern.compile("'(.*?)'");
					Matcher matcher = pattern.matcher(s);
					if (matcher.find()){
						PackageName = matcher.group(1);
						//System.out.println(matcher.group(1));
					}
				}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return PackageName;
	}

	/* Get Activity Name*/
	public static String getActivityName(){
		String ActivityName="Could not find activity!!";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(package_command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if (s.contains("launchable-activity: name")){
					Pattern pattern = Pattern.compile("'(.*?)'");
					Matcher matcher = pattern.matcher(s);
					if (matcher.find()){
						ActivityName = matcher.group(1);
					}
				}
			}	
		}catch (IOException e) {
			e.printStackTrace();
		}

		return ActivityName;
	}
	
	/* Get Android Device Name. */
	public static String getDeviceVersionName(){
		String deviceVersion="Could not find version!!";
		Runtime rt = Runtime.getRuntime();
		try {
			Process proc = rt.exec(deviceVersion_command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s = stdInput.readLine();
			deviceVersion = s.replaceFirst("[ro.build.version.release]:[6.0.1]", "");
			if (deviceVersion.contains("7")){
				return "Nougat";
			}
			else if (deviceVersion.contains("6")){
				return "Marsmallow";
			}
			else if (deviceVersion.contains("5")){
				return "Lollipop";
			}
			else if (deviceVersion.contains("4.4")){
				return "Kitkat";
			}
			else if (deviceVersion.contains("4.1") || deviceVersion.contains("4.2") || deviceVersion.contains("4.3")){
				return "Jelly Bean";
			}
		}catch (IOException e) {
			e.printStackTrace();
			}
		return deviceVersion;
	}
	
	public static void main(String args[]){
		System.out.println(getPackageName());
	}
}