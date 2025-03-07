package practice;

import java.io.File;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ToFetchDataFromPDF {

	public static void main(String[] args) throws Throwable {
		
		File file = new File("./src/test/resources/SQL ASSIGNMENT QUESTIONS WITH ANSWEWRS.pdf");
	
		PDDocument doc = PDDocument.load(file);
		int pages = doc.getNumberOfPages();
		System.out.println("Number of pages: "+pages);
		
		PDFTextStripper pdfData = new PDFTextStripper();
		//String readData = pdfData.getText(doc);
		//System.out.println(readData);
	
	
		pdfData.setStartPage(3);
		pdfData.setEndPage(5);
		String readData1 = pdfData.getText(doc);
		System.out.println(readData1);
	
	
	
	
	}

}
