package programming;

public class MainTest {
	
	public static void main(String args[]){
		System.out.println("Hello1");
		int d = 7;
		System.out.println(String.valueOf(new Integer(d)) instanceof String);
		System.out.println(String.valueOf(d) instanceof String);
		System.out.println(""+d instanceof String);
		System.out.println(Integer.toString(d) instanceof String);
		main();
	}
	
	 public static void main(){
		System.out.println("Hello");
	}
}
