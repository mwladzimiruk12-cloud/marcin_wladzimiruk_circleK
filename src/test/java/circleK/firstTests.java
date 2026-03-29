package circleK;

import circleK.bases.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tuKlasy.apiResponse;

public class firstTests extends TestConfig {

      @Autowired
  apiResponse apiResponse;
  @BeforeClass
  public void setUp() {
      System.out.println("We use spotless, allure, and....");
//      apiResponse.setBody("Body123");
//    Assert.assertEquals(apiResponse.getBody(),"cos innego");
    // code that will be invoked when this test is instantiated
  }

  @Test(groups = {"fast"})
  public void aFastTest() {
    System.out.println("Fast test");
    //        apiResponse apiResponse= new apiResponse.setBody("XDF");
  }

  @Test(groups = {"slow"})
  public void aSlowTest() {
    System.out.println("Slow test");
  }

  @AfterClass
  public void tearDown() {
    System.out.println("DZIALA");
    System.out.println("DZIALA");
  }

//  poczytaj o autowired

}
