package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger_POM.Flipkart;

public class ToLearnFindBy_FindBys {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com");
		driver.manage().window().maximize();

		Flipkart page = new Flipkart(driver);
		page.enterValue("Pencil");
			
			
	}

}
