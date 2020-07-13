package Selenium.InterviewPreperation;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TakeScreenshot {
	
	static WebDriver dr;
	
	@Test
	public static void ScreenshotHandling() throws IOException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.manage().window().maximize();
		
		dr.get("http://automationpractice.com/index.php");
		takeScreenshot("Home Page");
		dr.findElement(By.xpath("//a[@class='login']")).click();
		takeScreenshot("LoginRegisterPage");
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("rajakishore.test01@yopmail.com");
		dr.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Test@12345");
		dr.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		Thread.sleep(1500);
		takeScreenshot("LoggedInPage");
		dr.findElement(By.xpath("//a[@class='logout']")).click();
		Thread.sleep(2500);
		takeScreenshot("LoggedOutPage");
		dr.quit();	
	}
	
	
	public static void takeScreenshot(String fileName) throws IOException
	{
		File file = ((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Screenshots\\" + fileName + ".png"));
	}

}
