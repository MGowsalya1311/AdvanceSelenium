package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationValidation {
	public OrganizationValidation(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[@id='dtlview_Organization Name']")
	private WebElement orgName;

	public WebElement getOrgName() {
		return orgName;
	}

}
