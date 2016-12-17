package com.eduven.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.openqa.selenium.remote.DesiredCapabilities;


public class DriverInstance {
	
	
	/* Global variable declaration */
	static String nodeLoc = "/usr/local/bin/node";//"/Applications/Appium.app/Contents/Resources/node/bin/node";
	static String appiumJSLoc = "/usr/local/bin/appium";//"/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js";
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
	
	public static void stopServer() {
		String[] command = { "/usr/bin/killall", "-KILL", "node" };
		try {
			Runtime.getRuntime().exec(command);
			System.out.println("Appium server stopped.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void startAppium(){
		/*try {
			Runtime.getRuntime().exec(nodeLoc+" "+appiumJSLoc+"--address 127.0.0.1 --port 4723 --no-reset --udid "+Capabilities.udid+" --app "+Capabilities.appLocation+"--command-timeout 300 --backend-retries 3");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	/*	List<String> addArgu = new ArrayList<String>();
		addArgu.add(nodeLoc);
		addArgu.add(appiumJSLoc);
		addArgu.add("--address");
		addArgu.add("127.0.0.1");
		addArgu.add("--port");
		addArgu.add("4723");
		addArgu.add("--no-reset");
		addArgu.add("--app");
		addArgu.add(Capabilities.appLocation);
		try {
			ProcessBuilder process = new ProcessBuilder(addArgu);
			process.start();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

		
/*		CommandLine command = new CommandLine(nodeLoc);
		command.addArgument("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js");
		command.addArgument("--address");
		command.addArgument("127.0.0.1");
		command.addArgument("--port");
		command.addArgument("4723");
		command.addArgument("--no-reset");
		command.addArguments("--app");
		command.addArgument(Capabilities.appLocation);
		command.addArgument("--udid");
		command.addArgument(DeviceRelatedInformation.getUDID());
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		CommandLine command = new CommandLine(nodeLoc);
		command.addArgument(appiumJSLoc, false);
		command.addArgument("--address", false);
		command.addArgument("127.0.0.1");
		command.addArgument("--port", false);
		command.addArgument("4723");
		command.addArgument("--full-reset", false);
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(command, resultHandler);
			Thread.sleep(5000);
			System.out.println("Appium server started.");
		} catch (ExecuteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

	/**
	 * This method is used to set the capability for IOS driver and return the instance of IOS driver. 
	 * @return : IOSDriver instance;
	 */
	public static IOSDriver<IOSElement> getIosDriver(){
		/*stopServer();
		startAppium();*/
		if(driver == null){
			try {
				driver = new IOSDriver<IOSElement>(new URL(Capabilities.url), getDesiredCapabilities());
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		return driver;
	}
	
	
	private static AppiumServiceBuilder service;
	
	public static void startapp(){
		service = new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/bin/node")).withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"));
		service.build().start();
		System.out.println("Appium server started.");
	}
	
	public static void stopapp(){
		try {
			service.build().stop();
		} catch (AppiumServerHasNotBeenStartedLocallyException e) {
			System.out.println("Appium Server is already stopped.");
		}
	}
	
	public static void main(String args[]) {
		//stopServer();
		//startapp();
	}
}
