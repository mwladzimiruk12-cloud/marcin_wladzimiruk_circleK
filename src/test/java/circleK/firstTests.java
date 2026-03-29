package circleK;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertNull;

import circleK.bases.TestConfig;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rest.ApiRestMethod;
import tuKlasy.ApiResponse;
import tuKlasy.PostResponse;

public class FirstTests extends TestConfig {
  ApiRestMethod apiRestMethod = new ApiRestMethod();
  ApiResponse apiResponse;

  @BeforeClass
  public void setUp() {
    System.out.println("We use spotless, allure, and....");
    //      ApiResponse apiResponse1 = new ApiResponse();
    //      apiResponse1.setId(1);

    //    Assert.assertEquals(apiResponse.getBody(),"cos innego");
    // code that will be invoked when this test is instantiated
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
  }

  @Test()
  public void checkResponse200() {
    System.out.println(
        "Check 200 response. We use recursiveCompare to check all fields if its ok or not");
    apiResponse = apiRestMethod.getMethod(1, 200);
    ApiResponse expectedApiResponse =
        new ApiResponse(
            1,
            1,
            "sunt aut facere repellat provident occaecati excepturi optio reprehenderit",
            "quia et suscipit\n"
                + "suscipit recusandae consequuntur expedita et cum\n"
                + "reprehenderit molestiae ut ut quas totam\n"
                + "nostrum rerum est autem sunt rem eveniet architecto");

    assertThat(apiResponse)
        .usingRecursiveComparison()
        .ignoringFields() // here we can define what fields we want to ignore in compare for example
        // if api return actual dateTime
        .isEqualTo(expectedApiResponse);
  }

  @Test()
  public void checkResponse404() {
    System.out.println("Change to allure step. Check request 404");
    ApiResponse apiResponse1 = new ApiResponse();
    apiResponse1 = apiRestMethod.getMethod(-98, 404);
    assertNull(apiResponse1.getBody());
  }

  @Test()
  public void checkPost() {
    System.out.println(
        "Check post request.We use recursiveCompare to check all fields if its ok or not");
    PostResponse postResponse =
        apiRestMethod.postMethod(new ApiResponse(1, 1, "Title example", "Body example"), 201);
    PostResponse expectedPostResponse = new PostResponse(101);

    assertThat(postResponse)
        .usingRecursiveComparison()
        .ignoringFields() // here we can define what fields we want to ignore in compare for example
        // if api return actual dateTime
        .isEqualTo(expectedPostResponse);
  }

  @Test()
  public void aSlowTest() {
    System.out.println("Slow test");
  }

  @AfterClass
  public void tearDown() {
    System.out.println("It is the end of this simple test");
  }
}
