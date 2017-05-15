package Selenium_Ex;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Sheet;
import jxl.Workbook;

public class DataDriven_ex2 {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\sindh\\Desktop\\Training\\AllDriversNew\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.kbc.ie/Our-Products/Mortgages/First-Time-Buyers");
		Thread.sleep(3000);
		FileInputStream fis = new FileInputStream("C:\\Users\\sindh\\Desktop\\Training\\data.xls");
		Workbook wb= Workbook.getWorkbook(fis);
		Sheet sh=wb.getSheet(0);
		for(int i=1;i<sh.getRows();i++)
		{
			if(sh.getCell(0, i).getContents().equalsIgnoreCase("No"))
			{
				driver.findElement(By.xpath(".//*[@id='appform']/div[1]/div[1]/div/div[2]/div[2]/div/label")).click();
				
			}
			else
			{
				driver.findElement(By.xpath(".//*[@id='appform']/div[1]/div[1]/div/div[2]/div[1]/div/label")).click();;
			}
				new Select(driver.findElement(By.xpath(".//*[@id='first_applicant_title']"))).selectByVisibleText(sh.getCell(1, i).getContents());
				driver.findElement(By.id("first_applicant_first_name")).sendKeys(sh.getCell(2, i).getContents());
				
				Thread.sleep(3000);
			driver.navigate().refresh();

			
		}
		
		//Workbook wb = Workbook.getWorkbook(fis);
		driver.close();
		driver.quit();
	}

}
