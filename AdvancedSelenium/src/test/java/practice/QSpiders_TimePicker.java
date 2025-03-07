package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QSpiders_TimePicker {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/timePick/timeClock?sublist=1");
	
		driver.findElement(By.xpath("//input[@aria-label='Choose time, selected time is 12:00 AM']\r\n"
				+ "	")).click();
		
		driver.findElement(By.xpath("//div[@aria-label='Select minutes. Selected time is 4:00 AM']")).click();
		driver.findElement(By.xpath("//button[@type='button' and text()='OK']")).click();
	}

}
