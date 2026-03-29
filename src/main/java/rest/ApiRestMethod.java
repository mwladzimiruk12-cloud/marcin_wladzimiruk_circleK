package rest;

import static io.restassured.RestAssured.given;

import com.diffplug.spotless.maven.json.Json;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import tuKlasy.ApiGetResponse;
import tuKlasy.PostPutResponse;

@Log4j
@RequiredArgsConstructor
public class ApiRestMethod {
  private static final String URL = "https://jsonplaceholder.typicode.com/posts/";

  public ApiGetResponse getMethod(Integer id, Integer statusCode) {
    return given()
        .when()
        .get(URL + id)
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(ApiGetResponse.class);
  }

  public PostPutResponse postMethod(ApiGetResponse apiResponse, Integer statusCode) {
    return given()
        .with()
        .body(apiResponse)
        .when()
        .post(URL)
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(PostPutResponse.class);
  }

  public PostPutResponse putMethod(ApiGetResponse apiResponse, Integer id, Integer statusCode) {
    return given()
        .with()
        .body(apiResponse)
        .when()
        .put(URL + id)
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(PostPutResponse.class);
  }

  public Json deleteMethod(Integer id, Integer statusCode) {
    return given()
        .when()
        .delete(URL + id)
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(Json.class);
  }
}
