package testing;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabTest {
	
	  public static final String USERNAME = "qa_sauce_lab";
	  public static final String ACCESS_KEY = "bcee1cb1-e090-48fb-9984-91eb86ce330b";
	  public static final String url = "http://"+USERNAME+":"+ACCESS_KEY+"@ondemand.saucelabs.com:80/wd/hub";
	 
	  public static void main(String[] args) throws Exception {
	 
		  DesiredCapabilities caps = DesiredCapabilities.firefox();
		  caps.setCapability("platform", "OS X 10.11");
		  caps.setCapability("version", "17.0");
		  caps.setCapability("name", "bhardwaj_test");
	  /*  DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("appiumVersion", "1.4.16");
		caps.setCapability("deviceName","Android Emulator");
		caps.setCapability("deviceType","phone");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "");
		caps.setCapability("platformVersion","5.1");
		caps.setCapability("platformName","Android");
		caps.setCapability("app","sauce-storage:my_apk.apk");*/
	 
	    WebDriver driver = new RemoteWebDriver(new URL(url), caps);
	    driver.get("http://www.google.com");
	    System.out.println(driver.getTitle());
	    
	    }
}
