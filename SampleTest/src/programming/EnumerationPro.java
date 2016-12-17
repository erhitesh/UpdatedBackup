package programming;


/* Enum declaration  can be inside or outside the class because it llike acts as class.*/
 enum Company{
	flipkart, ebay, paytm
 };// use can ; or not

public class EnumerationPro {

	/* Enum declaration  can be inside or outside the class because it llike acts as class.
	 enum Company{
		flipkart, ebay, paytm
	}; // use can ; or not
*/	
	public static void main(String args[]){
		System.out.println("First Value..>"+Company.flipkart);
		for (Company name : Company.values()){
			System.out.println("Company Names..."+name);
		}
	}
}
