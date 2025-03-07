package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QSpiders_DatePicker {

	public static void main(String args[]) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
	
		driver.findElement(By.xpath("//div[@class='react-datepicker-wrapper']")).click();
		
		
		//infinite for loop to find element
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='April 2025']/../..//div[text()='5']")).click();
				break;
			}
			catch(Exception e) {
				driver.findElement(By.xpath("//button[@aria-label='Next Month']")).click();
			}
		}
		
	}
}
