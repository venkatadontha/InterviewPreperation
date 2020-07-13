package Selenium.InterviewPreperation;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class SeleniumCommands {
	
	static WebDriver driver;
	
	@BeforeTest
	public static void DriverInitialization() 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
    }

	@Test
    public static void main() throws IOException, InterruptedException 
    {
       	
        // 1. Open a URL
        driver.get("https://the-internet.herokuapp.com/login");

        // 2. Get Current URL as Text
        String url = driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals(url, "https://the-internet.herokuapp.com/login");


        // 3. Get the Title
        String title = driver.getTitle();
        System.out.println(title);


        // 4. Get Window Handle
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.findElement(By.cssSelector("#content > div > a")).click();
        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);
        
        Thread.sleep(25000);

        //5. Get Window Handles
        Set<String> handles= driver.getWindowHandles();
        List<String> list = new ArrayList<String>(handles);

        driver.switchTo().window(list.get(1));
        String title2 = driver.getTitle();
        System.out.println(title2);
        driver.switchTo().window(list.get(0));


        //6. DropDown Handling
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select selectByValue = new Select(driver.findElement(By.id("dropdown")));
        selectByValue.selectByVisibleText("Option 1");

        //7.Select a element
        //8. Input text in input box.
        //9. Submit the form
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        System.out.println(driver.getCurrentUrl()); // https://the-internet.herokuapp.com/secure


        //10. Switch to IFrame.
        //27. Clear Input box
        //28. Click an element
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        int width = driver.findElement(By.id("tinymce")).getSize().width;
        System.out.println(width);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Hello Pramod");
        
        
        // Take Screenshot
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File("./b.png");
        FileUtils.copyFile(SrcFile, DestFile);

        //

        // Expected Condition
        driver.get("https://the-internet.herokuapp.com/iframe");

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tinymce")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("tinymce")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));
        
    }
	
	@AfterTest
	public static void DriverShutdown() 
	{
		driver.quit();
    }
}