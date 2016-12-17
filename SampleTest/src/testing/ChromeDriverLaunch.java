package testing;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverLaunch {
	
	public static void main(String[] args) throws MalformedURLException {
		
		
		/* Setting for desired capabilities */
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.4.13");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "TA9330G5QE");
		capabilities.setCapability("disable-popup-blocking", false);
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.chrome");
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.calculator2");
		//capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.android.calculator2.Calculator");
		AndroidDriver<AndroidElement> driver =  new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://www.google.com");
		
		/*AndroidElement firstNumber = driver.findElement(By.name("7"));
		AndroidElement secondNumber = driver.findElement(By.name("4"));
		AndroidElement subButton = driver.findElement(By.name("+"));
		firstNumber.click();
		subButton.click();
		secondNumber.click();
		driver.findElement(By.name("=")).click();
		
		int result = Integer.parseInt(driver.findElement(By.id("com.android.calculator2:id/formula")).getText());
		
		if (11 == result){
			System.out.println("ok");
		}
		*/
	}
	
	
}
