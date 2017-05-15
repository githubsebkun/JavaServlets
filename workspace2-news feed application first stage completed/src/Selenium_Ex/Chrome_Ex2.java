package Selenium_Ex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_Ex2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",  "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://syromalabar.ie");

	}

}
