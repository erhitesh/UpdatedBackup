package testing;

import org.testng.annotations.DataProvider;

public class DAta {
 

  @DataProvider
  public static Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
