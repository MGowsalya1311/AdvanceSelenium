package Generic_Utility;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData() throws Throwable {
	
		
		FileInputStream fs = new FileInputStream("src/test/resources/vTigerCampaign.xlsx");

		Workbook wb = WorkbookFactory.create(fs);

		String camp_name = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();

		
		
		
		return camp_name;
		
	}
}
