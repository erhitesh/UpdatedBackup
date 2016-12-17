package programming;

public class PrimeNumberSeries {
	
	public static void main(String args[]) {
		
		int n = 10;
		int p;
		for (int i = 2; i < n; i++){
			p = 0;
			for (int j = 2; j < i ; j++){
				if (i % j == 0){
					p = 1;
				}
			}
			if (p == 0){
				System.out.println("Value od i "+i);
			}
		}
	}

}
