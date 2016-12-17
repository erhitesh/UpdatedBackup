package testing;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class SafariLauncherWeb {
	 WebDriver driver = null;
	@Test
	public void test_safari(){
		System.setProperty("webdriver.safari.driver", "/Users/hiteshbhardwaj/Desktop/Automation/softwares/SafariDriver.safariextz");
		 
		try {
			DesiredCapabilities cap = DesiredCapabilities.safari();
			driver = new SafariDriver(cap);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.cardstore.com");
		try{
			Thread.sleep(2000);
		}
		catch(Exception e){
			
		}
		
		WebElement userName = driver.findElement(By.linkText("Cart"));
		userName.click();
		
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("register for a free account"))));
	}

}
