package circleK.bases;

import org.testng.annotations.BeforeSuite;
import rest.RestAssuredSettings;

public class TestBase {
  @BeforeSuite
  public void setUpSuite() {
    RestAssuredSettings.setupConfig();
  }
}
