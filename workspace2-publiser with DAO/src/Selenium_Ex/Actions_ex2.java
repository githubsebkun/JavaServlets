package Selenium_Ex;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions_ex2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("http://www.americangolf.co.uk/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
		Actions action= new Actions(driver);
		WebElement menuitem = driver.findElement(By.xpath(".//*[@id='navigation']/nav/ul/li[3]/a"));
		action.moveToElement(menuitem).build().perform();
		Thread.sleep(3000);
		WebElement submenuitem=driver.findElement(By.xpath(".//*[@id='ACCS_1']/div[1]/ul[2]/li/ul/li[2]/ul/li/a"));
		action.moveToElement(submenuitem).click().build().perform();
		Thread.sleep(4000);
		WebElement slider=driver.findElement(By.xpath(".//*[@id='secondary']/div[1]/div[2]/div[1]/div[1]/span[1]"));
		action.dragAndDropBy(slider, 20, 0).build().perform();
		Thread.sleep(3000);
		
		WebElement searchbx=driver.findElement(By.xpath(".//*[@id='q']"));
		searchbx.clear();
		action.keyDown(Keys.SHIFT).sendKeys("m..").keyUp(Keys.SHIFT).build().perform();
		Thread.sleep(3000);
		//driver.close();
		//driver.quit();
	}

}
