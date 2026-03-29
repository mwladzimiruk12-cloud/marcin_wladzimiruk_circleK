package rest;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
public class RestAssuredSettings {
  public static void setupConfig() {
    RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/";
  }
}
