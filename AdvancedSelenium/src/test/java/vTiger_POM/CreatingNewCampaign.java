package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewCampaign {

	public CreatingNewCampaign(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "campaignname")
	private WebElement campaignName;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	
	public WebElement getCampaignName() {
		return campaignName;
	}


	public WebElement getSaveBtn() {
		return saveBtn;
	}


}
