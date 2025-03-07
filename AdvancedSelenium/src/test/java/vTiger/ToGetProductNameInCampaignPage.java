package vTiger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ToGetProductNameInCampaignPage extends VTigerBaseClass{

	@Test
	public void toGetProductNameInCampaignPage() throws Throwable {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("More"))).perform();
		driver.findElement(By.linkText("Campaigns")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		FileInputStream fs = new FileInputStream("src/test/resources/vTigerCampaign.xlsx");

		Workbook wb = WorkbookFactory.create(fs);

		String camp_name = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		driver.findElement(By.name("campaignname")).sendKeys(camp_name);
	
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		String parent_id = driver.getWindowHandle();
		Set<String> child_sessId = driver.getWindowHandles();
	
		child_sessId.remove(parent_id);
		for(String id: child_sessId) {
			driver.switchTo().window(id);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@id='1']")).click();
		}
		driver.switchTo().window(parent_id);
		Thread.sleep(5000);
		
		driver.findElement(By.name("button")).click();
	
	
	}
}
