package vTiger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Generic_Utility.File_Utility;
import Generic_Utility.WebDriver_Utility;
import vTiger_POM.HomePage;
import vTiger_POM.LoginPage;

public class VTigerBaseClass {
	public WebDriver driver;
	public static WebDriver sdriver;

	@Parameters("browser")
	@BeforeClass
	public void toLaunch(@Optional("chrome")String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(bname.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
		else if(bname.equalsIgnoreCase("FireFox")) {
			driver = new FirefoxDriver();
		}
		
		sdriver = driver;
		Reporter.log("Browser got launched",true);
		/*
		 * driver.manage().window().maximize();
		 * Reporter.log("Browser got Maximized",true);
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 */
		
		WebDriver_Utility wu = new WebDriver_Utility();
		wu.maximizeWindow(driver);
		wu.impWait(driver);
	}

	@BeforeMethod
	public void toLogin() throws Throwable {

		/*
		 * //To Read Data from Property File //Step1: Create an object of
		 * FileInputStream FileInputStream fis = new
		 * FileInputStream("./src/test/resources/vTiger.properties");
		 * 
		 * //Step2: Create an object of Respective Input file type(Properties file)
		 * Properties prop = new Properties();
		 * 
		 * //Step3: call methods prop.load(fis);
		 * 
		 * String url = prop.getProperty("url");
		 * 
		 * String USERNAME = prop.getProperty("username"); String PASSWORD =
		 * prop.getProperty("password");
		 */
		File_Utility fu = new File_Utility();

		String url = fu.getCommonData("url");
		String USERNAME = fu.getCommonData("username");
		String PASSWORD = fu.getCommonData("password");
		driver.get(url);
		
		/*
		 * driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 * driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 * driver.findElement(By.id("submitButton")).click();
		 */
		LoginPage lp = new LoginPage(driver);
		lp.getUsername().sendKeys(USERNAME);
		lp.getPassword().sendKeys(PASSWORD);
		lp.getLoginbtn().click();
		Reporter.log("Logged In Successfully",true);

	}

	@AfterMethod
	public void toLogout() {
		/*
		 * driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]"))
		 * .click(); driver.findElement(By.linkText("Sign Out")).click();
		 */
		HomePage hp = new HomePage(driver);
		hp.getUserIcon().click();
		hp.getSignOut().click();
		Reporter.log("Logged out Successfully",true);
	}

	@AfterClass
	public void toClose() {

		driver.quit();
		Reporter.log("Browser got Closed Successfully",true);
	}

}
