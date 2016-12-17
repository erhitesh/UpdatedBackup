package programming;

public class EnumWithConstructor {
	
	 enum TestSeason{
		 WINTER(2), SUMMER(3);
		 /*SUNDAY(1), MONDAY(3), TUESDAY(4)*/;
		 
		 private int value;
		 private TestSeason(int value){
			 this.value = value;
		 }
	};
	
	public static void main(String args[]) {
		for (TestSeason test: TestSeason.values()){
			System.out.println(test+" "+test.value);
		}
		
		//TestSeason s = new TestSeason();  //by new keyword we can not create instance of enum.
	}

}
