package vTiger;

import java.io.FileInputStream;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utility.Java_Utility;
import vTiger_POM.CreatingNewOrganization;
import vTiger_POM.HomePage;
import vTiger_POM.Organization;
import vTiger_POM.OrganizationValidation;

public class ToCreateOrganization extends VTigerBaseClass {

	@Test
	public void toCreateOrganization() throws Throwable {
		
		
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();;
		
		
		//driver.findElement(By.linkText("Organizations")).click();
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		Organization org = new Organization(driver);
		org.getCreateOrgLookUp().click();
		
		FileInputStream fs = new FileInputStream("src/test/resources/vTigerOrganization.xlsx");

		Workbook wb = WorkbookFactory.create(fs);

		//Random random = new Random();
		//int i = random.nextInt(100);
		
		Java_Utility ju = new Java_Utility();
		int i = ju.getRandomValue();
		String org_name = wb.getSheet("Sheet1").getRow(0).getCell(0).toString()+i;
		String org_phone = wb.getSheet("Sheet1").getRow(1).getCell(0).toString();
		String org_email = wb.getSheet("Sheet1").getRow(2).getCell(0).toString();

		/*
		 * driver.findElement(By.name("accountname")).sendKeys(org_name);
		 * driver.findElement(By.id("phone")).sendKeys(org_phone);
		 * driver.findElement(By.id("email1")).sendKeys(org_email);
		 * driver.findElement(By.name("button")).click();
		 */
		CreatingNewOrganization newOrg = new CreatingNewOrganization(driver);
		newOrg.getAccountName().sendKeys(org_name);
		newOrg.getPhoneNo().sendKeys(org_phone);
		newOrg.getEmail().sendKeys(org_email);
		newOrg.getSaveBtn().click();

		//String actualData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
	
	
		OrganizationValidation ov =  new OrganizationValidation(driver);
		String actualData =ov.getOrgName().getText();
		// To verify whether the organization is created in Organization Information page
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualData, org_name);
		Reporter.log("Organization is created successfully",true);
		
		sa.assertAll();
	
	

	}

}
