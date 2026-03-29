package rest;

import static io.restassured.RestAssured.given;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import tuKlasy.ApiResponse;
import tuKlasy.PostResponse;

@Log4j
@RequiredArgsConstructor
public class ApiRestMethod {
  private static final String URL = "https://jsonplaceholder.typicode.com/posts/";

  public ApiResponse getMethod(Integer id, Integer statusCode) {
    return given()
        .when()
        .get(URL + id)
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(ApiResponse.class);
  }

  public PostResponse postMethod(ApiResponse apiResponse, Integer statusCode) {
    return given()
        .with()
        .body(apiResponse)
        .when()
        .post(URL)
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(PostResponse.class);
  }
}
