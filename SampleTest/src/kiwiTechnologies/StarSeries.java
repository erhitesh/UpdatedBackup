package kiwiTechnologies;

public class StarSeries {
	
	public static void main(String args[]) {
		int n3=1;
		for (int i=1; i<=5; i++){
			for (int j = 1; j <=i;j++){
				System.out.print(n3);
				n3++;
			}
			System.out.println();
		}
		/*for (int i = 0; i <= 5; i++){
			for (int j = i; j > 0; j--){
				System.out.print(i);
			}
			System.out.println();
		}*/
		
		/*for (int i = 5; i > 0; i--){
			for (int j = 1	; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}*/
	}

}
