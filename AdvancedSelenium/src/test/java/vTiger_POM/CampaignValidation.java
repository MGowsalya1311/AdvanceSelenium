package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignValidation {
	public CampaignValidation(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement campName;

	public WebElement getCampName() {
		return campName;
	}

}
