package com.eduven.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DeviceRelatedInformation{
	
	static String device_command = "/Users/hiteshbhardwaj/Desktop/android-sdk-macosx/platform-tools/adb devices";
	static String package_command = "/Users/hiteshbhardwaj/Desktop/android-sdk-macosx/build-tools/23.0.2/aapt dump badging "+Capabilities.AppLocation;
	
	static AndroidDriver<AndroidElement> driver = DriverInstance.getAndroidDriver();
	
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
			
			//System.out.println("Device Name is : "+DeviceName);

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
	
	public static void main(String args[]){
		System.out.println("Device Name..>"+getDeviceName());
		System.out.println("Package Name..>"+getPackageName());
		System.out.println("Activity Name..>"+getActivityName());
	}
}