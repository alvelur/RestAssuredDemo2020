package utilities;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class RestAssuredExtension {

    public static RequestSpecification Request;

    public RestAssuredExtension(){
        //Arrange
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("http://localhost:3000");
        requestSpecBuilder.setContentType(ContentType.JSON);
        RequestSpecification requestSpec = requestSpecBuilder.build();
        Request = RestAssured.given().spec(requestSpec);

    }

    public static void GetOpsWithPathParameter(String url, Map<String, String> pathParams) throws URISyntaxException {
        //Act
        Request.pathParams(pathParams);
        Request.get(new URI(url));
    }
    public static ResponseOptions<Response> GetOps(String url)  {
        //AcT
        try {
            return Request.get(new URI(url));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ResponseOptions<Response> PostOpsWithBodyAndPathParams(String url, Map<String, String> pathParams, Map<String, String> body) throws URISyntaxException {

       Request.pathParams(pathParams);
       Request.body(body);

            return Request.post(url);

    }


}
