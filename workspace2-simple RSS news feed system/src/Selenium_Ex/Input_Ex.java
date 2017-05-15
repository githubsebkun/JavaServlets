package Selenium_Ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Input_Ex {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		//fill first name and last name
		
		driver.findElement(By.name("firstname")).clear();
		driver.findElement(By.name("firstname")).sendKeys("Sebastian");
		
		driver.findElement(By.name("lastname")).clear();
		driver.findElement(By.name("lastname")).sendKeys("Kunjappan");
		
		//going and filling radiobuttons
		List<WebElement> rbtns =  driver.findElements(By.name("sex"));
		for(int i=0;i<rbtns.size();i++)
		{
			System.out.println(rbtns.get(i).getAttribute("sex")+ " is ..."+rbtns.get(i).getAttribute("checked"));
		}
      driver.findElement(By.name("sex")).click();
      
      //locating experience radio button
      List<WebElement> rbtn2=driver.findElements(By.name("exp"));
      for(int i=0;i<rbtn2.size();i++)
      {
    	  System.out.println(rbtn2.get(i).getAttribute("exp")+"....is  "+rbtn2.get(i).getAttribute("checked"));
      }
       driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[2]/div[1]/div/div[5]/div/form/table/tbody/tr[4]/td[2]/span[5]/input")).click();
      
	}

}
