package rest;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.apache.http.params.CoreConnectionPNames;
import org.springframework.stereotype.Component;

@Component
public class ApiRestAssuredConfig {

  public RestAssuredConfig getRestAssuredConfig() {
    return RestAssured.config()
        .httpClient(
            HttpClientConfig.httpClientConfig()
                .setParam(CoreConnectionPNames.CONNECTION_TIMEOUT, 10000)
                .setParam(CoreConnectionPNames.SO_TIMEOUT, 10000));
  }
}
