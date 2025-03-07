package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProKabadi {

	static String name = "Bengaluru Bulls";
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://www.prokabaddi.com/standings");
		
		List<WebElement> teamNames = driver.findElements(By.xpath("//p[text()='Team']/../../../..//div[@class='table-data team']"));
		
		List<WebElement> matchesWon = driver.findElements(By.xpath("//p[text()='W']/../../../..//div[@class='table-data matches-won']"));
	
	
		List<WebElement> matchesLost = driver.findElements(By.xpath("//p[text()='L']/../../../..//div[@class='table-data matches-lost']"));
		for(int i=0;i<teamNames.size();i++) {
			WebElement ele = teamNames.get(i);
			if(ele.getText().equals(name)) {
			System.out.println("Team Name:"+ele.getText());
			WebElement e = matchesWon.get(i);
			System.out.println("Matches Won:"+e.getText());
			e=matchesLost.get(i);
			System.out.println("Matches Lost:"+e.getText());
			
			}
		}
	
	}

}
