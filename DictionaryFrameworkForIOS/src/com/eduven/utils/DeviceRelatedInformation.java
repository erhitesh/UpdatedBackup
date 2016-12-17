package com.eduven.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.Dimension;


public class DeviceRelatedInformation{

	
	/**
	 * This method is used to return the device udid.
	 * @return : String as udid of length 40 hex character.
	 */
	public static String getUDID(){
		
		String UDID="Could not find device!!";
		String command = "system_profiler SPUSBDataType";
		Runtime rt = Runtime.getRuntime();
		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains("Serial Number: ")){
					String temp= s.split("Serial Number: ")[1];
					if(temp.length()==40){
						UDID=temp;
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return UDID;
	}
	
    /**
     * This method is used to return the device name.
     * @return : String as device name.
     */
	public static String getDeviceName(){
		
		String DeviceName="Could not find device!!";
		String command = "xcrun instruments -s";
		String UDID= getUDID();
		Runtime rt = Runtime.getRuntime();
		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while((s = stdInput.readLine()) != null){
				if(s.contains(UDID)){
					String temp= s.split(" \\[")[0];
					DeviceName=temp;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return DeviceName;
	}
	
	/**
	 * This method is used to return the device type either iphone or ipad.
	 * @return : String as device name(type either iphone or ipad)
	 */
	public static String deviceType(){
		
		String deviceTypeName = "";
		Dimension dimension = Reusables.driver.manage().window().getSize();
		if (dimension.getHeight() == 480){
			deviceTypeName = "iPhone 4s";
			/*System.out.println("Device is an iPhone 4S or below");*/
		}
		else if (dimension.getHeight() == 568){
			deviceTypeName = "iPhone 5/c/s";
			/*System.out.println("Device is an iPhone 5c or 5s");*/
		}
		else if (dimension.getHeight() == 667){
			deviceTypeName = "iPhone 6/6S";
			/*System.out.println("Device is an iPhone 6 or 6s");*/
		}
		else if (dimension.getHeight() == 736){
			deviceTypeName = "iPhone 6 Plus/6s Plus";
			/*System.out.println("Device is an iPhone 6 Plus/6s Plus.");*/
		}
		else if (dimension.getHeight() == 1024 || dimension.getHeight() > 1024){
			deviceTypeName = "iPad";
			/*System.out.println("Device is an iPad or equivalent");*/
		}
		//System.out.println("Device is an iPhone/iPad. "+deviceTypeName);
		return deviceTypeName;
	}
	


	public static void main(String args[]){
		System.out.println("Device Name..."+getDeviceName());
		System.out.println("Device Udid..."+getUDID());
		//System.out.println("Device Type..."+deviceType());
	}
	
}