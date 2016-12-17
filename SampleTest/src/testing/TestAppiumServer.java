package testing;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


public class TestAppiumServer {

	DesiredCapabilities cap;
	@Test
	public void testSafari() throws InterruptedException{
		IOSDriver<IOSElement> driver = null;
		try {
			DeviceRelatedInformation db = new DeviceRelatedInformation();
			cap = db.intialized();
			driver = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			System.out.println("done");
			driver.findElement(By.id("DiscoverBtn")).click();
			Thread.sleep(2000);
			IOSElement element = driver.findElement(By.xpath("//*[@name='Flyer.jpg']"));
			driver.tap(1, element, 1000);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		
		
	}
			
	
}
