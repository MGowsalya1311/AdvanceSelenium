package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class File_Utility {

	public String getCommonData(String key) throws Throwable {
	//To Read Data from Property File
	//Step1: Create an object of FileInputStream
	//	FileInputStream fis = new FileInputStream("./src/test/resources/vTiger.properties");
		FileInputStream fis = new FileInputStream(IPathConstant.filepath);

	//Step2: Create an object of Respective Input file type(Properties file)
	Properties prop = new Properties();

	//Step3: call methods
	
	prop.load(fis);

	String value = prop.getProperty(key);
	return value;
}
}
