package Generic_Utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import vTiger.VTigerBaseClass;

public class ListenersImp implements ITestListener {

	public void onTestFailure(ITestResult result) {
		
	TakesScreenshot ts = (TakesScreenshot) VTigerBaseClass.sdriver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File temp = new File("./FailedScripts.png");
	
	try {
		FileUtils.copyFile(src, temp);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	

}
