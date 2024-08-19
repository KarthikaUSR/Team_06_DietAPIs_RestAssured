package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class GetAllDieticians extends RestUtils {

    Response response;

    @Given("admin bearer token is set in header")
    public void admin_bearer_token_is_set_in_header() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .spec(requestSpecification())
                .log().all();
    }
    @Given("admin create get request")
    public void admin_create_get_request() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .spec(requestSpecification())
                .log().all();
    }
    @When("admin send {string} http request with {string}")
    public void admin_send_http_request_with(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        response = reqSpec.when()
                .get(EndPoints.GET_ALL_DIETICIANS)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
    @Then("admin recieves {int} ok with response body")
    public void admin_recieves_ok_with_response_body(Integer expectedStatusCode) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }


    //SCENARIO 2
    @Given("admin create {string} request")
    public void admin_create_request(String string) throws IOException {
        // Write code here that turns the phrase above into concrete actions
        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .spec(requestSpecification())
                .log().all();
    }
    @When("admin send put method")
    public void admin_Send_Put_Method() {
        response = reqSpec.when()
                .put(EndPoints.GET_ALL_DIETICIANS)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
    @Then("admin recieves {int} method not allowed")
    public void admin_recieves_method_not_allowed(Integer expectedStatusCode) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }

    //SCENARIO 3
//@Given("admin create get request")
//public void admin_create_get_request() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
    @When("admin send {string} http request with invalid {string}")
    public void admin_send_http_request_with_invalid(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        response = reqSpec.when()
                .get("/dietic")
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
    @Then("admin recieves {int} not found")
    public void admin_recieves_not_found(Integer expectedStatusCode) {
        // Write code here that turns the phrase above into concrete actions
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }



}
