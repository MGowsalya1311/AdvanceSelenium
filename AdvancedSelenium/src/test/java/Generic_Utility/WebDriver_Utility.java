package Generic_Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class WebDriver_Utility {
	/**
	 * This method is used to maximize the window and implicit wait
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
	 
	driver.manage().window().maximize();
	Reporter.log("Browser got Maximized",true);
	}
	/**
	 * This method is used to Implicit wait
	 * @param driver
	 */
	public void impWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}

public static String takeScreenShotEx(WebDriver driver, String screenShotName) throws Throwable {
	TakesScreenshot takesSceenShot = (TakesScreenshot) driver;
	File src = takesSceenShot.getScreenshotAs(OutputType.FILE);
	File dst = new File("./ScreenShots/" + screenShotName +".png");
	FileUtils.copyFile(src, dst);
	return dst.getAbsolutePath();
}
}
