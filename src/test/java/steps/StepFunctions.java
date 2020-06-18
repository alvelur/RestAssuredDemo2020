package steps;

import DataSource.DataSource;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import pojo.PostEndavan;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class StepFunctions {


    private String baseUrl = "http://localhost:3000/";
    private RequestSpecification requestSpecification;
    private Response response;
    private ValidatableResponse validatableResponse;
    private int id;
    DataSource dataSource = new DataSource();
    private PostEndavan postEndavan;


    /**
     * This method has a String as input parameter, which means the address to which it will make the http request
     * And the method calls a json object and then sends it as a post request to the endpoint
     * then verify that the object was successfully accepted
     */
    public void performPostOperation(String postAddress){

        Gson gson = new Gson();
        String postJsonObject = gson.toJson(dataSource.setPostEndavan());
        String postUrl = baseUrl + postAddress;

        requestSpecification =   given().
                contentType(ContentType.JSON).
                with().body(postJsonObject);

        response = requestSpecification.when().post(postUrl);
        validatableResponse = response.then().assertThat().statusCode(201);
        getPostEndavan(response);

    }

    public void getPostEndavan(Response response){

        if (postEndavan == null) {
            PostEndavan postEndavan = dataSource.getPostEndavan(response);
            id = postEndavan.getId();
        }
    }

    /**
     * This method has a String as input parameter, which means the address to which it will make the http request
     * And the method makes a get request to the endpoint
     */
    public void performGetOperation(String getAddress) {

        String getUrl = baseUrl + getAddress + id;

        requestSpecification =
                given().
                        contentType(ContentType.JSON);
        response = requestSpecification.when().get(getUrl);

    }

    /**
     * This method has two input parameters, an int which means the expected status from the endpoint and a String which
     *  is an expected Item that the body response should contains
     *  Then asserts than the expected and the actual status code are equal
     *  Also it verifies that the body contains the item param
     */
    public void validateStatusCodeAndNameBodyItem(int expectedStatusCode, String item){

        validatableResponse = response.
                then()
                .assertThat()
                .statusCode(expectedStatusCode)
                .body("name",hasItem(item));

    }


    public void  performDeleteOperation(String deleteAddress){

        String deleteUrl = baseUrl + deleteAddress + id;
        requestSpecification =
                given().
                        contentType(ContentType.JSON);

        response = requestSpecification.when().delete(deleteUrl);
        validatableResponse= response.
                then()
                .assertThat()
                .statusCode(200);
    }

    /**
     * This method has a String as input parameter, which means the address to which it will make the http request
     *  And the method makes a PUT request to the endpoint
     */

    public void performPutOperation(String putAddress){

        Gson gson = new Gson();
        String putJsonObject = gson.toJson(dataSource.setPUTEndavan());

        String putUrl = baseUrl + putAddress+ id;
        requestSpecification =
                given().
                        contentType(ContentType.JSON);

        response = requestSpecification. with().body(putJsonObject).put(putUrl);
        validatableResponse= response.
                then()
                .assertThat()
                .statusCode(200);
    }




}
