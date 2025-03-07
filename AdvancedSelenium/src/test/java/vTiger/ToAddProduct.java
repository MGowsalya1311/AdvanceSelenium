package vTiger;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_Utility.Java_Utility;
import vTiger_POM.CreatingNewProduct;
import vTiger_POM.HomePage;
import vTiger_POM.ProductValidation;
import vTiger_POM.Products;

public class ToAddProduct extends VTigerBaseClass{

	@Test(retryAnalyzer = Generic_Utility.RetryAnalyserImp.class)
	public void toaddProduct() {
		/*
		 * Random rand = new Random(); int i = rand.nextInt(500);
		 */	
		Java_Utility ju = new Java_Utility();
		int i = ju.getRandomValue();
		String pname = "Books"+i;
		//	driver.findElement(By.linkText("Products")).click();
		//	driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//  driver.findElement(By.name("productname")).sendKeys(pname);
		//	driver.findElement(By.name("button")).click();

		HomePage hp = new HomePage(driver);
		hp.getProductsLink().click();

		Products prod = new Products(driver);
		prod.getCreateProductIcon().click();
		
	//	Assert.fail("im failing the TestScript");
			
		CreatingNewProduct createProd = new CreatingNewProduct(driver);
		createProd.getProductName().sendKeys(pname);
		createProd.getSaveBtn().click();

		ProductValidation pv = new ProductValidation(driver);
		String prod_name =pv.getProdName().getText();

		//String prod_name = driver.findElement(By.xpath("//span[@id='dtlview_Product Name']")).getText();

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(pname, prod_name);
		Reporter.log("Product Added Successfully",true);
		sa.assertAll();
		 
		
	

	}
}
