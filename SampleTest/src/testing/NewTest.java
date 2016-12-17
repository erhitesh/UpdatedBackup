package testing;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
	/*@Parameters("testing")
	@Test
	public void testParameters(String testing){
		System.out.println(testing);
		System.out.println("adl;");
	}*/
	
	@Test(alwaysRun = true , expectedExceptions = ArithmeticException.class)
	public void testTe(){
		System.out.println("testTe");
		int n = 10/0;
		System.out.println(n);
	}
  @Test(groups = {"test1"})
  public void tst() {
	  //Assert.assertEquals(false, true);
	  System.out.println("test1");
  }
  
  
  @Test(groups = {"test2"})
  public void tst0() {
	  //Assert.assertEquals(false, true);
	  System.out.println("test2");
  }
  
  @Test(dependsOnGroups={"test1"})
  public void tst1() {
	  System.out.println("test3");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("after method");
  }
  
  @Test
  public void test(){
	  System.out.println("Hello Test");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite");
  }
  
  
  @BeforeGroups
  public void beforeGroup(){
	  System.out.println("before group");
  }
  
  @AfterGroups
  public void afterGroup(){
	  System.out.println("after group");
  }

}
