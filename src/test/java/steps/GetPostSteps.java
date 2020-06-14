package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetPostSteps {
    private static ResponseOptions<Response> response;

    @Given("^I perfom GET operation for \"([^\"]*)\"$")
    public void iPerfomGETOperationFor(String url) throws Throwable {
        response = RestAssuredExtension.GetOps(url);
    }

    @And("^I perfrom GET for the post number \"([^\"]*)\"$")
    public void iPerfromGETForThePostNumber(String postNumber) throws Throwable {
        BDDStyledMethod.SimpleGETPost(postNumber);

    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String arg0) throws Throwable {
        assertThat(response.getBody().jsonPath().get("author"),hasItem(arg0));
    }

    @Then("^I should see authors name$")
    public void iShouldSeeAuthorsName() {
        BDDStyledMethod.ContainsCollection();
    }

    @Then("^I should see verifY GET parameter$")
    public void iShouldSeeVerifYGETParameter() {
        BDDStyledMethod.PerformQueryParameter();
    }

    @Given("^I perfom POST operation for \"([^\"]*)\"$")
    public void iPerfomPOSTOperationFor(String arg0) throws Throwable {
       BDDStyledMethod.PerformPostWithBodyParamether();
    }

    @Given("^I perfom POST  operation for \"([^\"]*)\" with body$")
    public void iPerfomPOSTOperationForWithBody(String url, DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        var data = table.raw();
        //set body
        HashMap<String, String> body = new HashMap<>();
        body.put("name",data.get(1).get(0));
        //Path params
        HashMap<String,String> pathParams = new HashMap<>();
        pathParams.put("profileNo",data.get(1).get(1));

        //Perfomrm Post operation
        response = RestAssuredExtension.PostOpsWithBodyAndPathParams(url,pathParams,body);

    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        assertThat(response.getBody().jsonPath().get("name"),equalTo(arg0));
    }
}
