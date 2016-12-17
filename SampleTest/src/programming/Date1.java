package programming;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.sql.Date;
import java.util.Date;


public class Date1 {
	
	 public static String addDays(Date date, int days){
		 String t = "";
		 Calendar cal = Calendar.getInstance();
	     cal.setTime(date);
	     cal.add(Calendar.DATE, days); //minus number would decrement the days
	     Date date1 = cal.getTime();
	     t = new SimpleDateFormat("EEE d MMM").format(date1);
	     
	     return t;
	    }

	public static void main(String args[]) throws ParseException {
		/*Date date = new Date();
		String simple = new SimpleDateFormat("d MMM").format(date);
		*/

		//System.out.println(addDays(new Date(), -1));
		
/*		String s1 = "10";
		long lq = 10l;
		System.out.println(Integer.parseInt(s1));
		System.out.println(Integer.valueOf(s1));
		System.out.println(lq);
		
		int i = 10;
		System.out.println(String.valueOf(i) instanceof String);
		System.out.println(Integer.toString(i));
		
		*/
		System.out.println("Enter Array number.");
		int arr11[] = new int[args.length];
		for (int j = 0; j < args.length; j++){
			arr11[j] = Integer.parseInt(args[j]);
		}
		for (int k = 0; k < arr11.length; k++){
			System.out.println(arr11[k]);
		}
		
		System.out.println("Travelers check [Food Veg-english]".replaceAll("''", "'"));
		
		SingletonClass single = SingletonClass.getInstance();
		single.testSingle();
		
	}
}
