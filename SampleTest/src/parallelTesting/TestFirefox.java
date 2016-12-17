package parallelTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestFirefox {
	WebDriver driver;
	
	@BeforeMethod
	/*@Parameters({"browser"})*/
	public void setUp(/*String browser*/){
		/*if (browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
		}*/
		System.setProperty("webdriver.gecko.driver", "/Users/hiteshbhardwaj/Downloads/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void testF(){
		driver.get("http://www.google.co.in");
	}

}
