package rest;

import static io.restassured.RestAssured.given;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import tuKlasy.ApiResponse;

@Log4j
@RequiredArgsConstructor
public class ApiRestMethod {
  private static final String URL="https://jsonplaceholder.typicode.com/posts/";

  public ApiResponse getMethod(Integer id) {
    return given()
        .when()
        .get(URL + id)
        .then()
        .statusCode(200)
        .extract()
        .response()
        .as(ApiResponse.class);
  }
}
