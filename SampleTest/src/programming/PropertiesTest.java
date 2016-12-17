package programming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {

	
	public static void main(String a[]){
        
        //InputStream is = null;
		FileInputStream is = null;
        Properties prop = null;
        prop = new Properties();
        try {
			 is = new FileInputStream(new File("/Users/hiteshbhardwaj/Desktop/Automation/workspace/SampleTest/src/programming/test.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	prop.load(is);
			//prop.load(new FileInputStream(new File("/Users/hiteshbhardwaj/Desktop/Automation/workspace/SampleTest/src/programming/test.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("db.host: "+prop.getProperty("db.host"));
        System.out.println("db.user: "+prop.getProperty("db.user"));
        System.out.println("db.password: "+prop.getProperty("db.password"));
        
    }
	
}