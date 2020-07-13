package Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	static WebDriver dr;

	public static void captureScreenshot(WebDriver dr, String fileName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)dr;
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("C:\\Users\\Windows\\Documents\\GITProjects\\InterviewPreperation\\Screenshots\\" + fileName + ".png"));
		}
		catch (Exception e)
		{
			System.out.println("Exception While Taking Screenshot" + e.getMessage());
		}
	}

}
