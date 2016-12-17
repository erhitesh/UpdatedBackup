package testing;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class TestSimulatorForApp {
	
	static IOSDriver<IOSElement> driver;
	
	public static DesiredCapabilities getDesiredCapabilities(){
		DeviceRelatedInformation d = new DeviceRelatedInformation();
		d.intialized();
		DesiredCapabilities cap  = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.4.13");
		//cap.setCapability(MobileCapabilityType.UDID, "2d3e5f58ce14c287297ab008c3a731ad30bf715f");
		File app_location = new File("/Users/hiteshbhardwaj/Desktop/Automation/Payload/CountryGuideFramework.app");
		cap.setCapability(MobileCapabilityType.APP, app_location.getAbsolutePath());

		return cap;
		
	}

	@Test
	public void testSafari(){
		try{
			driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), getDesiredCapabilities());
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Nearby50"))));
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}

}
