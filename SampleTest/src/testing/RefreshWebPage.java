package testing;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RefreshWebPage {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp(){
		try {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.firefox());
			driver.manage().window().maximize();
			driver.get("https://www.google.com/");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Test
	public void test1(){
		driver.findElement(By.tagName("html")).sendKeys(Keys.F5);
	}
	
	@Test
	public void test2(){
		driver.navigate().refresh();
	}
	@Test
	public void test3(){
		driver.navigate().to(driver.getCurrentUrl());
	}
	@Test
	public void test4(){
		driver.get(driver.getCurrentUrl());
	}
	@Test
	public void test5(){
		driver.findElement(By.tagName("html")).sendKeys("\uE035");
	}

}
