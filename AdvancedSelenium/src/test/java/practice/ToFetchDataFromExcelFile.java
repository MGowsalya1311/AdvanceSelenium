package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToFetchDataFromExcelFile {
	
	public static void main(String[] args) throws  IOException {
		//Step1: Create an object of FileInputStream
				FileInputStream fis = new FileInputStream("./src/test/resources/ExcelData.xlsx");

				//Step2: Create object of Workbook
				Workbook wb = WorkbookFactory.create(fis);
				
				
				//Step3: call methods
				//String text = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
				
				//step 3: navigate into excel sheet
				Sheet sheet = wb.getSheet("Sheet1");
				
				//step 4: navigate into row
				Row row = sheet.getRow(0);
				
				//step 5: navigate to cell
				Cell cell = row.getCell(0);
				
				String text = cell.getStringCellValue();
				System.out.println(text);
				
				String URL = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
				String USERNAME = wb.getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
				String PASSWORD = wb.getSheet("Sheet1").getRow(3).getCell(0).getStringCellValue();
				
				WebDriver driver = new ChromeDriver();
				driver.get(URL);
				driver.findElement(By.id("user-name")).sendKeys(USERNAME);
				driver.findElement(By.id("password")).sendKeys(PASSWORD);
				driver.findElement(By.id("login-button")).click();

	}

}
