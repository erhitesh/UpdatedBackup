package com.eduven.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import atu.testrecorder.ATUTestRecorder;

import com.eduven.constants.DataConstants;


public class DriverInstance {
	
	
	/* Global Variable Declaration */
	static IOSDriver<IOSElement> driver;
	static ATUTestRecorder recorder;
	
	/**
	 * This method is used to set the capabilities for ios driver.
	 * @return cap: Desired capabilities.
	 */
	public static DesiredCapabilities getDesiredCapabilities(){
		File appLoc = new File(Capabilities.appLocation);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, Capabilities.automationName);
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, Capabilities.appiumVersion);
		cap.setCapability(MobileCapabilityType.PLATFORM, Capabilities.platformName);
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
		if (driver == null){
			try {
				driver = new IOSDriver<IOSElement>(new URL(Capabilities.url), getDesiredCapabilities());
				driver.manage().timeouts().implicitlyWait(DataConstants.implicitWaitTime, TimeUnit.SECONDS);
//				recorder = new ATUTestRecorder("/Users/hiteshbhardwaj/Desktop/Automation/recording", "test", false);
//				recorder.start();
			}
			catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		return driver;
		
		}
	
	
	
/*	private static Process process;
	private static String appiumServerStart = "/usr/local/bin/node /usr/local/bin/appium --address 127.0.0.1 --port 4723 --no-reset --udid "+DeviceRelatedInformation.getUDID()+" --command-timeout 300 --backend-retries 3";
	

	public static void startAppiumServer() throws IOException, InterruptedException {
	    Runtime runtime = Runtime.getRuntime();
	    process = runtime.exec(appiumServerStart);
	    Thread.sleep(5000);
	    if (process != null) {
	        System.out.println("Appium server started.");
	    }
	}

	public static void stopAppiumServer() throws IOException {
	    if (process != null) {
	        process.destroy();
	    }
	    System.out.println("Appium server stop");
	}*/

	
	
/*	

	//Appium server 
	String nodeLoc = "/usr/local/bin/node";//"/Applications/Appium.app/Contents/Resources/node/bin/node";
	String appiumLoc = "/usr/local/bin/appium";//"/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js";

	
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
					BufferedReader br = new BufferedReader(new InputStreamReader(is));
					StringBuffer buffer = new StringBuffer();
					String line = null;
					while ((line = br.readLine()) != null) {
						buffer.append(line);
					}
					message = buffer.toString();
				} catch (IOException e) {
					e.printStackTrace();
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
				BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
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
				System.out.println("Output: " + output.message + "\nError: "+ error.message);
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
		String[] command = { "/usr/bin/killall", "-9", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void intialize() {
		RuntimeExec appiumObj = new RuntimeExec();
		//stopServer();
		appiumObj.startAppium(nodeLoc+" "+appiumLoc+" --address 127.0.0.1 --port 4723 --no-reset --app "+Capabilities.appLocation+" -U "+ Capabilities.udid + " --command-timeout 300 --backend-retries 3");
	}


	
	
	public static void main(String args[]){
		stopServer();
	}

	*/
	}
