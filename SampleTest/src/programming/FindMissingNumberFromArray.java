package programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FindMissingNumberFromArray {
	
	public static int sumOfNNumbers(int numberRange){
		
		return (numberRange*(numberRange+1))/2;
		
	}
	
	public static int sumOfArray(int arr[]) {
		int arrSum = 0;
		for (int i = 0; i < arr.length; i++){
			arrSum += arr[i];
		}
		
		return arrSum;
	}
	
	public static int twoMissingNumberFromArray(int numberRange, int arr[]){
		return 1;
	}
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		System.out.println("Enter Array number.");
		//int bb[] = {1, 2 , 3};
		int arr11[] = new int[args.length];
		for (int i = 0; i < args.length; i++){
			arr11[i] = Integer.parseInt(args[i]);
		}
		for (int i = 0; i < arr11.length; i++){
			System.out.println(arr11[i]);
		}
		//System.out.println("Missing Number is..."+(sumOfNNumbers(5)-sumOfArray(arr)));
 	}

}
