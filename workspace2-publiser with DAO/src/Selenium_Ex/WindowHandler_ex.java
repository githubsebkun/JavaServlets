package Selenium_Ex;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WindowHandler_ex {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://www.bankofireland.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Set<String> windows = driver.getWindowHandles();
		//driver.getWindowHandles().iterator();
		System.out.println(driver.getWindowHandles().size());
		driver.findElement(By.xpath(".//*[@id='login']")).click();
		System.out.println(driver.getWindowHandles().size());
		Iterator<String> it = driver.getWindowHandles().iterator();
		String firstwindow=it.next();
		String secondwindow=it.next();
		
		driver.switchTo().window(secondwindow);
		driver.findElement(By.id("form:userId")).sendKeys("36");
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(firstwindow);
		Thread.sleep(3000);
		driver.close();
		driver.quit();
		
		
		
		
	}

}
