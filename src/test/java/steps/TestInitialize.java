package steps;

import cucumber.api.java.Before;
import io.restassured.RestAssured;
import utilities.RestAssuredExtension;

public class TestInitialize {

    @Before
    public void TestSetup(){
        RestAssuredExtension restAssuredExtension = new RestAssuredExtension();

    }

}
