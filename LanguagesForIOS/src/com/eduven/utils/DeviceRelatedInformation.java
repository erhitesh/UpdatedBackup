package com.eduven.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.openqa.selenium.Dimension;

public class DeviceRelatedInformation {
	
	String nodeLoc = "/Applications/Appium.app/Contents/Resources/node/bin/node";
	String appiumLoc = "/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js";

	public void intialize() {
		RuntimeExec appiumObj = new RuntimeExec();
		stopServer();
		appiumObj.startAppium("/Applications/Appium.app/Contents/Resources/node/bin/node /Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js --address 127.0.0.1 --port 4723 --full-reset --udid "+ Capabilities.udid+ " --command-timeout 300 --backend-retries 3");
	}

	@SuppressWarnings("unused")
	private class RuntimeExec {
		public StreamWrapper getStreamWrapper(InputStream is, String type) {
			return new StreamWrapper(is, type);
		}

		private class StreamWrapper extends Thread {
			InputStream is = null;
			String type = null;
			String message = null;

			StreamWrapper(InputStream is, String type) {
				this.is = is;
				this.type = type;
			}

			public void run() {
				try {
					BufferedReader br = new BufferedReader(
							new InputStreamReader(is));
					StringBuffer buffer = new StringBuffer();
					String line = null;
					while ((line = br.readLine()) != null) {
						buffer.append(line);
					}
					message = buffer.toString();
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}

		// this is where the action is
		public void startAppium(String comand) {
			Runtime rt = Runtime.getRuntime();
			RuntimeExec rte = new RuntimeExec();
			StreamWrapper error, output;
			try {
				Process proc = rt.exec(comand);
				error = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
				output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
				// int exitVal = 0;
				BufferedReader stdInput = new BufferedReader(
						new InputStreamReader(proc.getInputStream()));
				String s;
				while ((s = stdInput.readLine()) != null) {
					System.out.println(s);
					if (s.contains("Appium REST http")) {
						System.out.println("Started Appium Server");
						break;
					}
				}
				error.start();
				output.start();
				error.join(3000);
				output.join(3000);
				// exitVal = proc.waitFor();
				System.out.println("Output: " + output.message + "\nError: "
						+ error.message);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void stopAppium(String comand) {
			Runtime rt = Runtime.getRuntime();
			RuntimeExec rte = new RuntimeExec();
			StreamWrapper error, output;

			try {
				Process proc = rt.exec(comand);
				error = rte.getStreamWrapper(proc.getErrorStream(), "ERROR");
				output = rte.getStreamWrapper(proc.getInputStream(), "OUTPUT");
				error.start();
				output.start();
				error.join(3000);
				output.join(3000);
				if (error.message.equals("") && output.message.equals(""))
					System.out.println("Closing Appium Server if already launched");
				else if (error.message.contains("No matching processes belonging to you were found")) {
					// Display nothing as no instances of Appium Server were
					// found running
				} else {
					System.out.println("Unable to Close Appium Server");
					System.out.println("Output: " + output.message+ "\nError: " + error.message);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Get UDID of Device */
	public static String getUDID() {
		String UDID = "Could not find device!!";
		String command = "system_profiler SPUSBDataType";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while ((s = stdInput.readLine()) != null) {
				if (s.contains("Serial Number: ")) {
					String temp = s.split("Serial Number: ")[1];
					if (temp.length() == 40) {
						UDID = temp;
						break;
					}
				}
			}
			/* System.out.println("UDID for device is : "+UDID); */

		} catch (IOException e) {
			e.printStackTrace();
		}

		return UDID;
	}

	/* Get Device Name */
	public static String getDeviceName() {
		String UDID = getUDID();
		String DeviceName = "Could not find device!!";
		String command = "xcrun instruments -s";
		Runtime rt = Runtime.getRuntime();

		try {
			Process proc = rt.exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			String s;
			while ((s = stdInput.readLine()) != null) {
				if (s.contains(UDID)) {
					String temp = s.split(" \\[")[0];
					DeviceName = temp;
				}
			}
			/* System.out.println("Device Name is : "+DeviceName); */

		} catch (IOException e) {
			e.printStackTrace();
		}

		return DeviceName;
	}
	
	
	/**
	 * This method is used to get device type either iphone or ipad.
	 * @return : String as device name(type either iphone or ipad)
	 */
	public static String deviceType(){
		String deviceTypeName = "";
		Dimension dimension = Reusables.driver.manage().window().getSize();
		if (dimension.getHeight()==480){
			deviceTypeName = "iPhone 4s";
			//System.out.println("Device is an iPhone 4S or below");
		}
		else if (dimension.getHeight()==568){
			deviceTypeName = "iPhone 5/c/s";
			//System.out.println("Device is an iPhone 5c or 5s");
		}
		else if (dimension.getHeight()==667){
			deviceTypeName = "iPhone 6/6S";
			//System.out.println("Device is an iPhone 6 or 6s");
		}
		else if (dimension.getHeight()==736){
			deviceTypeName = "iPhone 6 Plus/6s Plus";
			//System.out.println("Device is an iPhone 4S or below");
		}
		else if (dimension.getHeight()==1024 || dimension.getHeight() > 1024){
			deviceTypeName = "iPad";
			//System.out.println("Device is an iPad or equivalent");
		}
		return deviceTypeName;
	}

	public static void main(String args[]) {
		System.out.println(getUDID());
		System.out.println(getDeviceName());
		System.out.println(deviceType());
	}
}