package programming;

 class Test{
	 void show(){
		 System.out.println("Show Test");
	 }
	
}
 
 class TestOver extends Test{
	 void show(){
		 System.out.println("Show TestOver");
	 }
 }

public class MethodOverriding extends TestOver{

	void show(){
		System.out.println("Show Methodoverriding...");
	}
	
	public static void main(String args[]){
		new MethodOverriding().show();
	}
}
