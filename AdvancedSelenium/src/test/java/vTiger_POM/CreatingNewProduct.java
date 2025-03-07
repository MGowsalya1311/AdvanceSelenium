package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewProduct {

	public CreatingNewProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "productname")
	private WebElement productName;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
}
