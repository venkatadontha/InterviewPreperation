package Selenium.InterviewPreperation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MouseOver {
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
	public static void Mouseover() throws IOException, InterruptedException
	{
        dr.get("https://www.mercurytravels.co.in/");

        Actions actions = new Actions(dr);
        WebElement element = dr.findElement(By.partialLinkText("Foreign Exchan"));
        actions.moveToElement(element).build().perform();
       
        try 
        {
        	Thread.sleep(5000);
        	dr.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[@class='black2'][contains(text(),'FAQ')]")).click();
        	System.out.println(dr.getCurrentUrl());
        }
        catch(Exception e)
        {      
        	System.out.println(dr.getCurrentUrl());
        }
    }
    
    @AfterTest
	public static void DriverShutdown() 
	{
		dr.quit();
    }
}
