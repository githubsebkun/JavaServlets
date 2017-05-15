package Selenium_Ex;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TNG_pms_login {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  //testing without login and password
	    driver.findElement(By.xpath(".//*[@id='loginForm1']/input[3]")).click();
		System.out.println("Succesfully Tested Login attempt without any entry");
		Thread.sleep(3000);
	   //testing with correct email but without password	
		driver.findElement(By.cssSelector("#loginForm1 > #email")).clear();
	    driver.findElement(By.cssSelector("#loginForm1 > #email")).sendKeys("sindhusunny@hotmail.com");
	    driver.findElement(By.xpath(".//*[@id='loginForm1']/input[3]")).click();
	    System.out.println("Succesfully Tested Login attempt without any entry");
	    Thread.sleep(3000);
	    //testing with a wrong email
	    driver.findElement(By.cssSelector("#loginForm1 > #email")).clear();
	    driver.findElement(By.cssSelector("#loginForm1 > #email")).sendKeys("sunnykochuchira@gmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("abc123de");
	    driver.findElement(By.cssSelector("input.btn.btn-login")).click();
	    Thread.sleep(3000);
	    //testing with proper email and password
	    driver.findElement(By.cssSelector("#loginForm1 > #email")).clear();
	    driver.findElement(By.cssSelector("#loginForm1 > #email")).sendKeys("sindhusunny@hotmail.com");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("abc123def");
	    driver.findElement(By.cssSelector("input.btn.btn-login")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.id("logoutIcon")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver",  "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://pms.heart4needy.com/login.action");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
