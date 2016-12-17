package programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class FactorialPro {
	
	
	public static int factorialWithRecusion(int number){
		if (number == 0)
			return 1;
		else
			return (number*factorialWithRecusion(number-1));
	}
	
	public static int withoutRecursion(int number){
		int fact = 1;
		for (int i = 1; i <=number; i++){
			fact = fact*i;
		}
		
		return fact;
	}
	
	public static void main(String args[]) {
		int number = 0;
		try {
			System.out.println("Enter number for factorial Series....");
			number = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (Exception e){
			
		}
		System.out.println(withoutRecursion(number));
		
		/*FactorialPro pro = new FactorialPro();
		System.out.println(pro);*/
	}

}
