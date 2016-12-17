package testing;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class LaunchSafariInDevice {
	
static IOSDriver<IOSElement> driver;
	
	public static DesiredCapabilities getDesiredCapabilities(){
		DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.5.3");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		cap.setCapability(MobileCapabilityType.UDID, "84974ee52e47314f4e50b296df4610e953edc63f");
		
		return cap;
	}

	@Test
	public void testSafari(){
		try{
			driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), getDesiredCapabilities());
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			
			driver.get("http://www.facebook.com/");
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
			System.out.println("Conntext Handles..?"+driver.getContextHandles());
			IOSElement userName = driver.findElement(By.id("email"));
			userName.click();
			userName.clear();
			userName.sendKeys("bhardwajhitesh2@gmail.com");
			
			IOSElement userPass = driver.findElement(By.id("pass"));
			userPass.click();
			userPass.clear();
			userPass.sendKeys("bhardwajhitesh");
			
			driver.findElementById("loginbutton").submit();
		}
		catch (Exception e) {
		e.printStackTrace();
	}
	
	}
	

}
