package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {

	public Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//img[@title='Create Organization...']")
		private WebElement createOrgLookUp;
	public WebElement getCreateOrgLookUp() {
		return createOrgLookUp;
	}
	
	
}
