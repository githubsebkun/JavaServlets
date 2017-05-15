package Selenium_Ex;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown_Ex2 {

	public static void main(String[] args) throws Exception {
		/*boolean result;
		
			        try {
		
			            result = firstPageContainsQAANet();
		
			        } catch(Exception e) {
		
			            e.printStackTrace();
		
			            result = false;
		
			        } finally {
		
			            driver.close();
		
			        }
		
			 
	
			        System.out.println("Test " + (result? "passed." : "failed."));
		
			        if (!result) {
		
			            System.exit(1);
		
			        }*/
		System.setProperty("webdriver.ie.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://mortgage.aib.ie/");
		driver.manage().window().maximize();
		Select sel=new Select(driver.findElement(By.id("mortgage-calculator_applicants")));
		sel.selectByVisibleText("2");
		Select sel2=new Select(driver.findElement(By.id("mortgage-calculator_app1_maritalstatus")));
		sel2.selectByIndex(5);
		
		Thread.sleep(3000);
		List<WebElement> list = sel.getOptions();
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
		}
		
		List<WebElement> list2 = sel2.getOptions();
		for(int i=0;i<list2.size();i++)
		{
			System.out.println(i+"  "+list2.get(i).getText());
			
		}
		sel2.selectByValue("W");
		Thread.sleep(2000);
		sel2.selectByVisibleText("Cohabitant");
		//sel.sele
		driver.close();
		driver.quit();
		
	}

}
