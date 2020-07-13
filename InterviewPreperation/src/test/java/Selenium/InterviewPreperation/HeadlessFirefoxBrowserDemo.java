package Selenium.InterviewPreperation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class HeadlessFirefoxBrowserDemo {

	public static WebDriver dr = null;

	@Test
	public static void DriverInitialization() throws InterruptedException 
	{
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		firefoxBinary.addCommandLineOptions("--headless");
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Drivers\\geckodriver.exe");
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setBinary(firefoxBinary);
		FirefoxDriver dr = new FirefoxDriver(firefoxOptions);
		dr.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		dr.manage().window().maximize();

		dr.get("http://automationpractice.com/index.php");
		dr.findElement(By.xpath("//a[@class='login']")).click();
		dr.findElement(By.xpath("//input[@id='email']")).sendKeys("rajakishore.test01@yopmail.com");
		dr.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Test@12345");
		dr.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		Thread.sleep(2500);
		dr.findElement(By.xpath("//a[@class='logout']")).click();
		Thread.sleep(2500);

		dr.quit();
	}
}
