package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign {
	public Campaign(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@alt='Create Campaign...']")
	private WebElement createCampaignLookup;

	public WebElement getCreateCampaignLookup() {
		return createCampaignLookup;
	}

}
