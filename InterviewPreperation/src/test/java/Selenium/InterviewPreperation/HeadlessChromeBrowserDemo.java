package Selenium.InterviewPreperation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HeadlessChromeBrowserDemo {
	
	public static WebDriver dr = null;
	
	@BeforeTest
    public static void DriverInitialization() 
    {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		dr = new ChromeDriver(options);
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.manage().window().maximize();
    }
	
	@Test
	public static void LoginTest() throws InterruptedException
	{
		dr.get("http://automationpractice.com/index.php");
		dr.findElement(By.xpath("//a[@class='login']")).click();
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("rajakishore.test01@yopmail.com");
		dr.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Test@12345");
		dr.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		Thread.sleep(2500);
		dr.findElement(By.xpath("//a[@class='logout']")).click();
		Thread.sleep(2500);
	}
	
	@AfterTest
	public static void DriverShutdown() 
	{
		dr.quit();
	}
}
