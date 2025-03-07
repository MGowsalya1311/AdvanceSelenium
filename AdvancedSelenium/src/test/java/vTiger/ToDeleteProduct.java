package vTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class ToDeleteProduct extends VTigerBaseClass{
	@Test
	public void toDeleteProduct() {
		String prod_name = "Books";
		driver.findElement(By.linkText("Products")).click();
		Select select = new Select(driver.findElement(By.id("bas_searchfield")));
		select.selectByValue("productname");
		driver.findElement(By.name("search_text")).sendKeys(prod_name,Keys.ENTER);
		
		WebElement checkbox = driver.findElement(By.xpath("//a[contains(text(),'Books913') and @ title='Products']/../..//input[@name='selected_id']"));
		
		Select s = new Select(checkbox);
		s.getFirstSelectedOption();
		
		
	}

}
