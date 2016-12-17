package programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
	
	
	public static List<String> getPatternListValue(String strText, String regexPattern){
		List<String> list = new ArrayList<String>();
		ArrayList<String> strData = new ArrayList<String>(Arrays.asList(strText.split(",")));
		System.out.println(strData);
		/* Create Pattern Object */
		Pattern pattern = Pattern.compile(regexPattern);
		/* Create a Matcher object */
		for (int i = 0; i < strData.size(); i++){
			Matcher matcher = pattern.matcher(strData.get(i));
			if (matcher.find()){
				list.add(matcher.group(0).replaceAll("phonetic=", ""));//.replaceFirst("\\|+[^|]+\\.[a-zA-Z]{2,4}", ""));//"\\|+[^|]+\\.[a-zA-Z]{2,4}", ""
			}
		}
		
		
		return list;
	}

	 public static void main( String args[] ){

	      // String to be scanned to find the pattern.
	      /*String line = "7.0|oz|Unblanched Almonds|Unblanched Almonds.jpg,200.0|ml|Spanish Olive Oil|Virgin Olive Oil.jpg,3.0|pcs|Garlic Cloves|new_sliced garlic lengthwise.jpg1.0|tsp|Sherry Vinegar|Sherry Vinegar.jpg,2.0|tsp|Salt|salt1.jpg,8.0|pcs|Ice Cubes To Serve|ice cubes.jpg,110.0|gm|Black Grapes To Serve|black grapes.jpg,1.0|pc|Apple To Serve|Apple.jpg,";
	      String pattern = "([^|])+\\|+[^|]+\\.[a-zA-Z]{2,4}";
	      System.out.println(getPatternListValue(line, pattern));*/
	      
	      
	      String str = "meaning=Black|phonetic=black|audio=black_en.mp3";//,meaning=Black|phonetic=blue|audio=black_en.mp3, meaning=Black|phonetic=black|audio=black_en.mp3";
	      String pattern = "phonetic=([a-zA-Z])+";
	      System.out.println(getPatternListValue(str, pattern));
	   }
	
}
