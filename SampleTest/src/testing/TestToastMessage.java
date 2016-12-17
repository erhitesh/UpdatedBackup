package testing;

import java.io.File;
import java.io.IOException;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class TestToastMessage {
	
	public static void testToastUsingImage(){
		File file = new File("/Users/hiteshbhardwaj/Desktop/Screenshot.jpg");
		//get the Tesseract direct interace
		Tesseract instance = new Tesseract();
		//instance.setLanguage("");
		instance.setDatapath("/usr/local/share/tessdata");
        String result = "";
		try {
			result = instance.doOCR(file);
			System.out.println(result);
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.contains("Add Recipes in EduBank for a quick"));
		System.out.println("=============================");
		System.out.println(result.contains("Exchange"));
	}
	
	public static void main(String args[]) throws IOException, TesseractException{
	
		testToastUsingImage();
	}

}
