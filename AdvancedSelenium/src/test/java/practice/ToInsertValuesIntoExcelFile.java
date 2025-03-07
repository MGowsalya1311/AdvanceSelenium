package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToInsertValuesIntoExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step1: Create an object of FileInputStream
		FileInputStream fis = new FileInputStream("./src/test/resources/Excel1.xlsx");

		//Step2: Create object of Workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: navigate into excel sheet
		Sheet sheet = wb.getSheet("Sheet1");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		for(int i=0;i<allLinks.size();i++) {
			Row row =sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
			
			
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Excel1.xlsx");
		wb.write(fos);
		wb.close();
		
		for(int i=0;i<allLinks.size();i++) {
			Row row = sheet.getRow(i);
			Cell cell = row.getCell(0);
			System.out.println(cell.getStringCellValue());
				
		}

	}

}
