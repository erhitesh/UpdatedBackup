package programming;

public class StringPro {
	
	public static String reverseStr(String str){
		String reverse = "";
		for (int i = str.length()-1; i>= 0;i--){
			reverse+= str.charAt(i);
		}
		return reverse;
	}
	
	public static String reverseUsingRecursion(String str){
		String reverse = "";
		if (str.length() == 1){
			return str;
		}
		else{
			reverse+= str.charAt(str.length()-1)+reverseUsingRecursion(str.substring(0, str.length()-1));
		}
		return reverse;
	}
	
	public static void main(String args[]){
		System.out.println(reverseUsingRecursion("HITESH"));
	}

}
