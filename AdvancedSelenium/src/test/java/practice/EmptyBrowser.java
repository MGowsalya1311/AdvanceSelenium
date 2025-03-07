package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmptyBrowser {

	public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.get("https://www.flipkart.com/");
	driver.findElement(By.name("q")).sendKeys("iphone");
	driver.findElement(By.xpath("//button[@type='submit']")).submit();
	
	 List<WebElement> productTitle = driver.findElements(By.xpath("//div[contains(text(),'Apple iPhone')]"));

	 for(WebElement ele : productTitle) {
		
	 System.out.println(ele.getText());
	 }
	}

}
