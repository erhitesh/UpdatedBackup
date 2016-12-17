package programming;

public class TryCatchTest {

	public static void main(String args[]){
		try{
			//int numer = 122;
			//int sum = numer / 0;
		}
		catch(ArithmeticException e){
			System.out.println("test");
			e.printStackTrace();
		}
	}
}
