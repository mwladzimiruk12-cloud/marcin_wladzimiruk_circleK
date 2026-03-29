package circleK;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.testng.Assert.assertNull;

import circleK.bases.TestBase;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import model.ApiGetResponse;
import model.PostPutResponse;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rest.ApiRestMethod;

public class FirstTests extends TestBase {
  ApiRestMethod apiRestMethod = new ApiRestMethod();
  ApiGetResponse apiResponse;

  @BeforeClass
  public void setUp() {
    System.out.println("We use spotless, allure, and....");
  }

  @Test()
  @Description("This is simple test checking PUT method")
  public void checkPutMethod() {
    final Integer id = 5;

    Allure.step(
        "Check PUT method",
        () -> {
          System.out.println("Check put request.");
        });

    Allure.parameter("id", id); // Using allure.parameter is usefull to see this data on test report

    PostPutResponse postResponse =
        Allure.step(
            "Send request",
            () -> {
              return apiRestMethod.putMethod(
                  new ApiGetResponse(2, 2, "Title example", "Body example"), id, 200);
            });

    Allure.step(
        "Assert response",
        () -> {
          PostPutResponse expectedPostResponse = new PostPutResponse(id);
          assertThat(postResponse).usingRecursiveComparison().isEqualTo(expectedPostResponse);
        });
  }

  @Test()
  @Description("This is simple test checking GET method")
  public void checkGetMethodResponse200() {
    System.out.println(
        "Check 200 response. We use recursiveCompare to check all fields if its ok or not");
    apiResponse = apiRestMethod.getMethod(1, 200);
    ApiGetResponse expectedApiResponse =
        new ApiGetResponse(
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
  @Description("This is simple test checking GET method, response 404")
  public void checkGetMethodResponse404() {
    System.out.println("Change to allure step. Check request 404");
    apiResponse = apiRestMethod.getMethod(-98, 404);
    assertNull(apiResponse.getBody());
  }

  @Test()
  @Description("This is simple test checking POST method")
  public void checkPostMethod() {
    System.out.println(
        "Check post request.We use recursiveCompare to check all fields if its ok or not");
    PostPutResponse postResponse =
        apiRestMethod.postMethod(new ApiGetResponse(1, 1, "Title example", "Body example"), 201);
    PostPutResponse expectedPostResponse = new PostPutResponse(101);

    assertThat(postResponse).usingRecursiveComparison().isEqualTo(expectedPostResponse);
  }

  @Test()
  @Description("This is simple test checking DELETE method")
  public void checkDeleteMethod() {
    System.out.println(
        "Check delete request.We use recursiveCompare to check all fields if its ok or not");
    final Integer id = 5;
    apiRestMethod.deleteMethod(id, 200);
  }

  @AfterClass
  public void tearDown() {
    System.out.println("It is the end of this simple test");
  }
}
