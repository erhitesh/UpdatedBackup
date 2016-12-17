package testing;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
  @Test(dataProvider = "dptest")
  public void test(Integer n, String s) {
	  System.out.println("Integer.."+n+" String..>"+s);
  }

  
  @Test(dataProvider="dptest")
  public void test1(String s){
	  System.out.println("String..>"+s);
  }
  
  @Test(dataProvider = "dp", dataProviderClass= DAta.class)
  public void f(Integer n, String s) {
	  //System.out.println("Integer.."+n+" String..>"+s);
  }
  
  
  
  /*@DataProvider()
  public Object[][] dptest() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }*/
  
  @DataProvider()
  public Object[][] dptest(Method m) {
	  
	  if (m.getName().equalsIgnoreCase("test")){
		  return new Object[][]{
				  {1, "Hitesh"},
				  {2, "Bhardwaj"},
				  {3, "media"}
		  };
	  }
	  
	  else{
		  return new Object[][]{
				  {"HItesh"},
				  {"Test"}
		  };
	  }
}
}