package testing;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TestIOSSimulator {
	
	static IOSDriver<IOSElement> driver;
	static AppiumDriverLocalService service;
	
	public static DesiredCapabilities getDesiredCapabilities(){
		DesiredCapabilities cap  = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.5.3");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		//cap.setCapability(MobileCapabilityType.UDID, "2d3e5f58ce14c287297ab008c3a731ad30bf715f");
		//File app_location = new File("/Users/hiteshbhardwaj/Desktop/Automation/app/ZynMobileIPA.ipa");
		//cap.setCapability(MobileCapabilityType.APP, app_location.getAbsolutePath());

		return cap;
		
	}

	@Test
	public void testSafari(){
		try{
			driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), getDesiredCapabilities());
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			driver.get("http://www.cardstore.com");
			Thread.sleep(10);
			WebElement userName = driver.findElement(By.linkText("Cart"));
			userName.click();
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("register for a free account"))));	
			System.out.println(driver.findElement(By.linkText("Start shopping >")).getText());
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static AppiumDriverLocalService startAppiumServer(){
		 service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
		.usingDriverExecutable(new File("/Applications/Appium.app/Contents/Resources/node/bin/node"))
		.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/node_modules/appium/bin/appium.js"))
		.withIPAddress("127.0.0.1").usingPort(4723));
		 
		 return service;
	}
	
	public static void startAppium(){
		AppiumDriverLocalService.buildDefaultService().start();
	}
}
