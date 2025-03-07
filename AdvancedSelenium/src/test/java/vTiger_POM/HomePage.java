package vTiger_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement userIcon;

	@FindBy(linkText = "Sign Out")
	private WebElement signOut;


	@FindBy(linkText = "Products")
	private WebElement productsLink;


	@FindBy(linkText = "More")
	private WebElement more;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;

	}
	public WebElement getMore() {
		return more;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public WebElement getSignOut() {
		return signOut;
	}

}
