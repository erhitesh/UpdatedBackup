package testing;

import java.util.Random;

public class RandomNumber {

	public static int random_number(int number){
		Random ran = new Random();
		
		return ran.nextInt(number);
		
	}
	
	public static void main(String args[]){
		System.out.println(random_number(2));
	}
}
