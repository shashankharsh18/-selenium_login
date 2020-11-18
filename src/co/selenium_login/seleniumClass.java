package co.selenium_login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class seleniumClass {

	public static void main(String[] args) {
		String driverPath = "C:/Users/Admin/Documents/Selenium_files/chrome_driver";
		System.setProperty("webdriver.chrome.driver", driverPath+"/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://clinics-dev.eha.im/web/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("login")).sendKeys("devadmin");
		driver.findElement(By.id("password")).sendKeys("~Z6829Sbb_\":yCAu");
		Select drpCountry = new Select(driver.findElement(By.id("branch_id")));
		drpCountry.selectByVisibleText("Kano - Lamido Crescent");
		driver.findElement(By.className("btn-block")).click();
		driver.get("http://clinics-dev.eha.im/");
		driver.findElement(By.xpath("//*[@id=\"top_menu\"]/li[5]/a/b/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"o_logout\"]")).click();
	//	driver.findElement(By.id("o_logout")).click();
		String at = driver.getTitle();
		String et = "EHA Clinics | Homepage";
	//	driver.close();
		if(at.equalsIgnoreCase(et))
		{
			System.out.println("Test Successful");
		}
		else
		{
			System.out.println("Test Fail");
		}
		}

}