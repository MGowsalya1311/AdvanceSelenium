package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductValidation {

	public ProductValidation(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Product Name']")
	private WebElement prodName;

	public WebElement getProdName() {
		return prodName;
	}
}
