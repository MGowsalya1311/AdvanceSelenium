package vTiger;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utility.Excel_Utility;
import Generic_Utility.Java_Utility;
import vTiger_POM.Campaign;
import vTiger_POM.CampaignValidation;
import vTiger_POM.CreatingNewCampaign;
import vTiger_POM.HomePage;
//@Listeners(Generic_Utility.ListenersImp.class)
@Listeners(Generic_Utility.ExtendReport.class)
public class ToCreateCampaign extends VTigerBaseClass{
	//@Listeners(vTiger.ListenersImp.class)

	@Test
	public void toCreateCampaign() throws Throwable {
		
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.linkText("More"))).perform();
		
		HomePage hp = new HomePage(driver);
		hp.getCampaignsLink().click();
		
		Campaign camp = new Campaign(driver);
		camp.getCreateCampaignLookup().click();
		//driver.findElement(By.linkText("Campaigns")).click();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		/*
		 * FileInputStream fs = new
		 * FileInputStream("src/test/resources/vTigerCampaign.xlsx");
		 * 
		 * Workbook wb = WorkbookFactory.create(fs);
		 * 
		 * String camp_name = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		 * 
		 */		
		
		Java_Utility ju = new Java_Utility();
		int ranNum= ju.getRandomValue();
		
		Excel_Utility eu = new Excel_Utility();
		String camp_name =eu.getExcelData()+ranNum;
		
		CreatingNewCampaign newCamp = new CreatingNewCampaign(driver);
		newCamp.getCampaignName().sendKeys(camp_name);
		newCamp.getSaveBtn().click();
		//driver.findElement(By.name("campaignname")).sendKeys(camp_name);
		//driver.findElement(By.name("button")).click();
		
		CampaignValidation cv = new CampaignValidation(driver);
		String c_name =	cv.getCampName().getText();
		
		
		
	//	Assert.fail("im failing the TestScript");
		
		Assert.assertEquals(c_name, camp_name);
		System.out.println("campName is created");
	
		//String c_name = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
		//SoftAssert sa = new SoftAssert();
		//sa.assertEquals(c_name, camp_name);
	//	Reporter.log("Campaign is created successfully",true);
		
	//	sa.assertAll();
	
	}
	}
