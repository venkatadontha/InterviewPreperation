package Selenium.InterviewPreperation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utilities.ScreenshotUtility;

public class TakeScreenshot_UtilityTest {
	
	static WebDriver dr;
	
	@Test
	public static void ScreenshotHandlingOnError() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		
		dr.get("http://automationpractice.com/index.php");
		dr.findElement(By.xpath("//a[@class='login']")).click();
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("rajakishore.test01@yopmail.com");
		dr.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Test@12345");
		dr.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		Thread.sleep(1500);
		dr.findElement(By.xpath("//a[@class='logoutqqq']")).click();
		Thread.sleep(2500);
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			ScreenshotUtility.captureScreenshot(dr,result.getName());
		}
		dr.quit();	
	}
}
