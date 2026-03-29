package circleK;

import static io.restassured.RestAssured.given;

import circleK.bases.TestConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rest.ApiRestMethod;
import tuKlasy.ApiResponse;

public class FirstTests extends TestConfig {
  ApiRestMethod apiRestMethod = new ApiRestMethod();

  @BeforeClass
  public void setUp() {
    System.out.println("We use spotless, allure, and....");
    //      ApiResponse apiResponse1 = new ApiResponse();
    //      apiResponse1.setId(1);

    //    Assert.assertEquals(apiResponse.getBody(),"cos innego");
    // code that will be invoked when this test is instantiated
  }

  @Test(groups = {"fast"})
  public void aFastTest() {
    System.out.println("Fast test");
    ApiResponse apiResponse1 = new ApiResponse();
    apiResponse1 = apiRestMethod.getMethod(1);
    System.out.println(apiResponse1.getBody());

    ApiResponse apiResponse =
        given()
            .when()
            .get("https://jsonplaceholder.typicode.com/posts/" + 1)
            .then()
            .statusCode(200)
            .extract()
            .response()
            .as(ApiResponse.class);
    System.out.println(apiResponse.getTitle());

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
