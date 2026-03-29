package rest;

import static io.restassured.RestAssured.given;

import com.diffplug.spotless.maven.json.Json;
import lombok.extern.log4j.Log4j;
import model.ApiGetResponse;
import model.PostPutResponse;
import org.springframework.stereotype.Component;

@Log4j
@Component
public class ApiRestMethod {
  private final ApiRestAssuredConfig apiRestAssuredConfig = new ApiRestAssuredConfig();

  public ApiGetResponse getMethod(Integer id, Integer statusCode) {
    return given()
        .config(apiRestAssuredConfig.getRestAssuredConfig())
        .when()
        .get(id.toString())
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(ApiGetResponse.class);
  }

  public PostPutResponse postMethod(ApiGetResponse apiResponse, Integer statusCode) {
    return given()
        .config(apiRestAssuredConfig.getRestAssuredConfig())
        .with()
        .body(apiResponse)
        .when()
        .post()
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(PostPutResponse.class);
  }

  public PostPutResponse putMethod(ApiGetResponse apiResponse, Integer id, Integer statusCode) {
    return given()
        .config(apiRestAssuredConfig.getRestAssuredConfig())
        .with()
        .body(apiResponse)
        .when()
        .put(id.toString())
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(PostPutResponse.class);
  }

  public Json deleteMethod(Integer id, Integer statusCode) {
    return given()
        .config(apiRestAssuredConfig.getRestAssuredConfig())
        .when()
        .delete(id.toString())
        .then()
        .statusCode(statusCode)
        .extract()
        .response()
        .as(Json.class);
  }
}
