package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Flipkart {
	public Flipkart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(name="q"),@FindBy(css ="[class='Pke_EE']")})
	private WebElement searchBar;
	
	
	@FindBys({@FindBy(css = "[type='submit']"),@FindBy(xpath = "//button[@aria-label='Search for Products, Brands and More']")})
	private WebElement searchIcon;
	
	public void enterValue(String name)
	{
		searchBar.sendKeys(name);
		searchIcon.click();
	}
	
	
}
 

