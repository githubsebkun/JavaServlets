package Selenium_Ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Alert_Ex2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.rediff.com/");
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("proceed")).click();
		Thread.sleep(3000);
		
		//System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.close();
		driver.quit();
		
	}

}
