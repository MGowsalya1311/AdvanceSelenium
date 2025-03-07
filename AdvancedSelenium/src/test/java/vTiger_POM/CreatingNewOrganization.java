package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganization {

	public CreatingNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "accountname")
	private WebElement accountName;
	
	@FindBy(id = "phone")
	private WebElement phoneNo;
	
	@FindBy(id = "email1")
	private WebElement email;
	
	
	@FindBy(name = "button")
	private WebElement saveBtn;


	public WebElement getAccountName() {
		return accountName;
	}


	public WebElement getPhoneNo() {
		return phoneNo;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	
}
