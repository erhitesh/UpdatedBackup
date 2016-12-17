package testing;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.theories.DataPoints;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class EmulatorGridTesting {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	@Parameters({"portNumber", "deviceName", "version"})
	public void setUp(String portNumber, String deviceName, String version){
		File app_location = new File("/Users/hiteshbhardwaj/Desktop/Automation/app/LanguagesForAndroid/esperanto/esperanto.apk");
		DesiredCapabilities cap  = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, version);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.eduven.ld.lang.esperanto");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.eduven.ld.lang.activity.SplashActivity");
		cap.setCapability(MobileCapabilityType.APP, app_location.getAbsolutePath());
		
		if (portNumber.equals("4724")){
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:"+portNumber+"/wd/hub"), cap);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
		
		else if (portNumber.equals("4723")){
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			try {
				driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:"+portNumber+"/wd/hub"), cap);
				driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@DataProvider()
	public Object[][] dataForDeviceConfiguration(){
		Object[][] obj = {{"port", "4723"},{"port", "4725"},{"port", "4728"}};
		
		return obj;
	}
	
	@Test(priority=0)
	public void navigaet_to_category_test1(){
		waitForElement(By.id("com.eduven.ld.lang.esperanto:id/tv_name"));
		driver.findElements(By.id("com.eduven.ld.lang.esperanto:id/tv_name")).get(0).click();
	}
	
	public void waitForElement(By by){
		int timeOutInSeconds = 60;
		try{
			new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
		}
		catch(NoSuchElementException e){
		}
	}
	

	@Test(priority=2)
	public void test3(){
	String appName = driver.findElement(By.id("com.eduven.ld.lang.esperanto:id/title_text")).getText();
	System.out.println("App Name.. "+appName);
	}
	
	
}
