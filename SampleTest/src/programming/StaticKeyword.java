package programming;

public class StaticKeyword {
	
	static String name = "";

	public static String test(String opt){
		//name = "";
		if (opt.equals("t1")){
			name = "Hitesh";
		}
		else if (opt.equals("t2")){
			name = "Bhardwaj";
		}
		else if (opt.equals("t3")){
			name = "Sharma";
		}
		
		return name;
	}
	
	public static void testIndexing(){
		String app_name = "Speak Haitian creole";
		System.out.println("Indexing.."+app_name.substring(6));
	}
	
	public static void testStatic(String optValue){
		test(optValue);
	}
	
	public static void main(String args[]){
		System.out.println(test("t1"));
		System.out.println(test("t2"));
	}
}
