package programming;

public class StringMatching {

	public static void main(String args[]) {
		//System.out.println("سوداء".equals("سوداء"));
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		String s3 = "Hello";
		String s4 = "Hello";
		
		System.out.println(s1.equals(s2)); // For content comparision
		System.out.println(s1.equals(s3));
		System.out.println(s1 == s2);
		System.out.println(s3 == s4); // for address checking.
		
		
		System.out.println(" BY NEW KEYWORD WE CAN NOT CREATE INSTANCE OF ENUM.".toLowerCase());
		
		
		System.out.println("Filter".contains("Filter"));
		
		
		String str = "To accept";
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i) == ' '){
				i++;
			}
			System.out.println("value"+i+ " "+str.charAt(i));
		}
	}
}
