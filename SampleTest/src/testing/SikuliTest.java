package testing;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class SikuliTest {

	
	static Screen scr = new Screen();
	public static void main(String args[]){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			scr.find("/Users/hiteshbhardwaj/Desktop/eclipse.png");
			scr.hover("/Users/hiteshbhardwaj/Desktop/eclipse.png");
			scr.highlight(2, "blue");
			scr.doubleClick("/Users/hiteshbhardwaj/Desktop/eclipse.png");	
		} catch (FindFailed e) {
			e.printStackTrace();
		}
	}
}
