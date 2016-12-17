package programming;

public class TestFunctionality {
	
	public static void testObj(Object obj){
		System.out.println("Object");
	}
	
	public static void testObj(String str){
		System.out.println("String");
	}
	
	/*public static void testObj(StringBuffer str){
		System.out.println("String Buffer");
	}*/
	
	public static void main(String args[]) {
		testObj(null);
	}

}
