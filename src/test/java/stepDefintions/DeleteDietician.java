package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeleteDietician extends RestUtils {

    //scenario 1 - success 200
    @Given("admin bearer token is set")
    public void admin_bearer_token_is_set() throws IOException {
//        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
//        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
//                .spec(requestSpecification())
//                .log().all();

        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
//        requestSpecification();
        setTokenInHeaderRequestSpec();
    }
    @Given("admin create delete request")
    public void admin_create_delete_request() throws IOException {
        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .spec(requestSpecification())
                .log().all();

//        setTokenInHeaderRequestSpec();
    }
    @When("admin send delete http request with endpoint")
    public void admin_send_delete_http_request_with_endpoint() {
        response = reqSpec.when()
                .delete(EndPoints.DELETE_DIETICIAN_BY_ID)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
    @Then("admin recieves {int} ok")
    public void admin_recieves_ok(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }


    //scenario 2 - 405 method not allowed
    @Given("admin create post request")
    public void admin_create_post_request() throws IOException {
        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .spec(requestSpecification())
                .log().all();

//        setTokenInHeaderRequestSpec();
    }
    @When("admin send post request with endpoint")
    public void admin_send_post_request_with_endpoint() {
        response = reqSpec.when()
                .post(EndPoints.DELETE_DIETICIAN_BY_ID)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
    @Then("admin recives {int} method not allowed")
    public void admin_recives_method_not_allowed(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }

    //scenario 3 - invalid id - 404 not found
//    @Given("admin create delete request")
//    public void admin_create_delete_request() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("admin send delete http request with endpoint")
//    public void admin_send_delete_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    @Then("admin recives {int} not found")
    public void admin_recives_not_found(Integer StatusCode) {
        assertEquals(StatusCode.intValue(), response.getStatusCode());
    }

    //scenario 4 - invalid endpoint - 404 not found
//    @Given("admin create delete request")
//    public void admin_create_delete_request() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    @When("admin send delete request with invalid endpoint")
    public void admin_send_delete_request_with_invalid_endpoint() {
        response = reqSpec.when()
                .delete("/dietn")
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
//    @Then("admin recives {int} not found")
//    public void admin_recives_not_found(Integer StatusCode) {
//        assertEquals(StatusCode.intValue(), response.getStatusCode());
//    }



}
