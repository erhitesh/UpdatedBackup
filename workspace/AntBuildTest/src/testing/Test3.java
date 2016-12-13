package testing;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Test3 {
	@Test(priority=1)
	public void test1() throws InterruptedException{
		System.out.println("Test1");
		Thread.sleep(5000);
	}
	@Test(priority=11)
	public void test2(){
		System.out.println("Test2");
	}

	@Test(priority=111)
	public void test3(){
		System.out.println("Test3");
	}
	@Test(priority=1111)
	public void test4(){
		System.out.println("Test4");
	}

	@AfterMethod
	public void aftertest(){
		System.out.println("After test");
	}


	@AfterClass
	public void afterclass(){
		System.out.println("after class");
	}
}
