package Selenium_Ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Frame_ex2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.ebs.ie/interest-rates-and-calculators/calculators-mortgage.html");
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='k2Container']/div[2]/div[1]/table/tbody/tr[4]/td[2]/a/img")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("blockrandom");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='mortgages']/form[1]/table/tbody/tr[2]/td[2]/input")).click();
		
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//driver.findElement(By.id("mod-finder-searchword481")).click();
		driver.findElement(By.id("mod-finder-searchword481")).clear();
		driver.findElement(By.id("mod-finder-searchword481")).sendKeys("sebkun");
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	
	}

}
