package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestMyMic {

	public static void main(String[] args) throws InterruptedException {

		//Notification Popup
		ChromeOptions settings = new ChromeOptions();
	
		//to avoid popup and to accept micro phone permission
		settings.addArguments("--auto-accept-camera-and-microphone-capture");
		
		WebDriver driver = new ChromeDriver(settings);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mictests.com/");

		driver.findElement(By.id("mic-launcher")).click();


	}

}
