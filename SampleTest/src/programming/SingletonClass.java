package programming;

public class SingletonClass {
	
	private static SingletonClass single = null;
	
	private SingletonClass(){
		
	}
	
	public static SingletonClass getInstance(){
		if (single == null){
			single = new SingletonClass();
		}
		return single;
	}
	
	public void testSingle(){
		System.out.println("Hello");
	}
	
	public static void main(String args[]) {
		SingletonClass sin =SingletonClass.getInstance();
		sin.testSingle();
	}
}
