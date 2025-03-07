package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToGetColorNameInAmazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone16");

		driver.findElement(By.id("nav-search-submit-button")).click();

		List<WebElement> colors = driver.findElements(By.xpath("//a[@aria-label='Pink']"));
		for(WebElement ele : colors) {
			System.out.println(ele.getCssValue("color"));
		}
	}

}
