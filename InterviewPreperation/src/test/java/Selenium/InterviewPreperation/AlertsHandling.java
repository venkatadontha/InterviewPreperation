package Selenium.InterviewPreperation;


//The WebPage used to test the alerts is: https://the-internet.herokuapp.com/javascript_alerts
//In this WebPage all the different types of Alerts are handled.

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertsHandling {

	static WebDriver dr;
	
	@BeforeTest
	public static void DriverInitialization() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Drivers\\chromedriver.exe");
		dr = new ChromeDriver();
		dr.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		dr.manage().window().maximize();
    }
	
	@Test (priority=1)
	public static void Alert1() throws IOException, InterruptedException
	{
		dr.get("https://the-internet.herokuapp.com/javascript_alerts");
        dr.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert alert = dr.switchTo().alert();
        alert.accept();
        String result = dr.findElement(By.cssSelector("#result")).getText();
        System.out.println(result);
        Assert.assertEquals("You successfuly clicked an alert",result);
	}
	
	@Test (priority=2)
	public static void Alert2() throws IOException, InterruptedException
	{
		dr.get("https://the-internet.herokuapp.com/javascript_alerts");
		dr.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
	    Alert alert2 = dr.switchTo().alert();
	    alert2.dismiss();
	    String result2 = dr.findElement(By.cssSelector("#result")).getText();
	    System.out.println(result2);
	    Assert.assertEquals("You clicked: Cancel",result2);
	}
	
	@Test(priority=3)
	public static void Alert3() throws IOException, InterruptedException
	{
		dr.get("https://the-internet.herokuapp.com/javascript_alerts");
		dr.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
        Alert alert3 = dr.switchTo().alert();
        alert3.accept();
        String result3 = dr.findElement(By.cssSelector("#result")).getText();
        System.out.println(result3);
        Assert.assertEquals("You clicked: Ok",result3);
        
        dr.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        dr.switchTo().alert().sendKeys("Hello Venkata Dontha");
        dr.switchTo().alert().accept();
        String result4 = dr.findElement(By.cssSelector("#result")).getText();
        System.out.println(result4);
        Assert.assertEquals("You entered: Hello Venkata Dontha",result4);
	}
	
	@AfterTest
	public static void DriverShutdown() 
	{
		dr.quit();
    }
	
}
