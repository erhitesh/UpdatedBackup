package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonnaciSeries {	
	
	/* Global Variable Declaration */
	static int n1=0, n2=1, n3 =0;
	
	public static void fibonaciWithRecusion(int count){
		if (count > 0){
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
			fibonaciWithRecusion(count-1);
		}
	}
	public static void fibonaciWithoutRecusion(int count){
		for (int i = 2; i < count; i++){
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
			System.out.print(" "+n3);
		}
	}
	
	public static int fibb(int num){
		if (num <=1){
			return num;
		}
		else{
			return fibb(num-1)+fibb(num-2);
		}
	}
	public static void main(String args[]) {
		/*int number = 0;
		try {
			System.out.println("Enter number for fibonacci Series....");
			number = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print(n1+" "+n2);
		fibonaciWithRecusion(number-2);
		//fibonaciWithoutRecusion(number);*/	
		int n = 5;
		for (int i = 0; i < n; i++){
			System.out.print(fibb(i)+" ");
		}
		}
}
