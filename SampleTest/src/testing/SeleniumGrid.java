package testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGrid {
	WebDriver driver;
	DesiredCapabilities cap;
	
	@BeforeMethod
	@Parameters("browser")
	public void configuration(String browser) throws MalformedURLException{
		if (browser.equalsIgnoreCase("firefox")){
			//cap.setPlatform(Platform.MAC);
			System.setProperty("webdriver.gecko.driver", "/Users/hiteshbhardwaj/Downloads/geckodriver");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		}
		else if (browser.equalsIgnoreCase("chrome")){
			//cap.setPlatform(Platform.MAC);
			System.setProperty("webdriver.chrome.driver", "/Users/hiteshbhardwaj/Downloads/chromedriver");
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
		}
		else if (browser.equalsIgnoreCase("safari")){
			//cap.setBrowserName("safari");
			//cap.setPlatform(Platform.MAC);
			//driver = new SafariDriver();
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.safari());
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void browserTest1(){
		driver.get("http://www.google.com");
		System.out.println("Title Name.."+driver.getTitle());
	}
	
	@Test
	public void browserTest2(){
		driver.get("http://www.flipkart.com");
		System.out.println("Title Name.."+driver.getTitle());
	}
	
	@Test
	public void browserTest3(){
		driver.get("http://www.myntra.com");
		System.out.println("Title Name.."+driver.getTitle());
	}
	

	@AfterMethod
	public void closeDriver(){
		if (driver!= null){
			driver.quit();
		}
	}
	
}
