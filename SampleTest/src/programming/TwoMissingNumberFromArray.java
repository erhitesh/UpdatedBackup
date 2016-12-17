package programming;

public class TwoMissingNumberFromArray {
	
	public static int[] missingNumbers(int arr[], int range){
		int sn, sa = 0;
		int pn = 1, pa = 1;
		
		/* Number sum */
		sn = (range*(range+1)/2);
		
		/* Array sum */
		for (int i = 0; i < arr.length; i++){
			sa+= arr[i];
		}
		
		int s = sn - sa;
		
		/* product of number */
		for (int  j = 1; j <=range; j++){
			pn*= j;
		}
		
		/* array product */
		for (int k = 0; k < arr.length; k++){
			pa*= arr[k];
		}
		
		int p = pn / pa;
		
		int diff = (int) Math.sqrt(s*s-4*p);
		int a = (s+diff)/2;
		int b = s-a;
		int result[] = {b, a};
		
		
		return result;
	}
	
	public static void main(String args[]) {
		int aa[] = {1, 2, 5};
		int range = 5;
		int res[];
		res = missingNumbers(aa, range);
		System.out.println("first value.."+res[0]+" Seconds value..."+res[1]);
	}

}
