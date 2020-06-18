package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import utilities.RestAssuredExtension;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StepsDefinitions {

    private static ResponseOptions<Response> response;
    private StepFunctions stepFunctions = new StepFunctions();
    private BDDStyledMethod bddStyledMethod = new BDDStyledMethod();

    @Given("^I perfom GET operation for \"([^\"]*)\"$")
    public void iPerfomGETOperationFor(String url) {
        response = RestAssuredExtension.GetOps(url);
    }

    @Then("^I should see the author name as \"([^\"]*)\"$")
    public void iShouldSeeTheAuthorNameAs(String authorName)  {
        assertThat(response.getBody().jsonPath().get("author"),hasItem(authorName));
    }


    @Given("^I perfom POST  operation for \"([^\"]*)\" with body$")
    public void iPerfomPOSTOperationForWithBody(String url,DataTable table) throws Throwable {
        var data = table.raw();
       HashMap<String, String> body = new HashMap<>();
       body.put("name",data.get(1).get(0));

       HashMap<String,String> pathParams = new HashMap<>();
       pathParams.put("profileNo",data.get(1).get(1));

       response = RestAssuredExtension.PostOpsWithBodyAndPathParams(url,pathParams,body);

    }

    @Then("^I should see the body has name as \"([^\"]*)\"$")
    public void iShouldSeeTheBodyHasNameAs(String arg0) throws Throwable {
//        assertThat(response.getBody().jsonPath().get("name"),equalTo(arg0));
    }

    @Given("^I perfom POST operations for \"([^\"]*)\"$")
    public void iPerfomPOSTOperationsFor(String postAddress) {
        stepFunctions.performPostOperation(postAddress);
    }

    @When("^I perform a GET operation for \"([^\"]*)\"$")
    public void iPerformAGETOperationFor(String getAddress)   {
        stepFunctions.performGetOperation(getAddress);
    }

    @And("^I perform a PUT operation for \"([^\"]*)\"$")
    public void iPerformAPUTOperationFor(String putAddress)  {
       stepFunctions.performPutOperation(putAddress);
    }

    @Then("^I perform a DELETE operation for \"([^\"]*)\"$")
    public void iPerformADELETEOperationFor(String deleteAddress)   {
       stepFunctions.performDeleteOperation(deleteAddress);
    }

    @Given("^I perfom Post operation$")
    public void iPerfomPostOperation() {
        BDDStyledMethod.performPostWithBodyParamether();
    }

    @When("^I perform Get operation$")
    public void iPerformGetOperation() {
        BDDStyledMethod.performPathParameter();
    }

    @Then("^I should see authors name looking for the \"([^\"]*)\" id$")
    public void iShouldSeeAuthorsNameLookingForTheId(String id) throws Throwable {
       BDDStyledMethod.simpleGETPost(id);
    }

    @Then("^I perform Delete operation$")
    public void iPerformDeleteOperation() {
        BDDStyledMethod.performDelete();
    }
}
