package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.RestUtils;
import Utils.Util1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class GetAllDieticians extends Util1 {

    Response response;

    @Given("admin bearer token is set in header")
    public void admin_bearer_token_is_set_in_header() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("userEmail"), getGlobalValue("password"));
        requestSpecification();  // Ensure reqSpec is initialized
        reqSpec.header("Authorization", "Bearer " + getGlobalValue("adminToken"));
    }
    @Given("admin create get request")
    public void admin_create_get_request() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().get(EndPoints.GET_ALL_DIETICIANS)
                .then().log().all().extract().response();


    }
    @When("admin send {string} http request with {string}")
    public void admin_send_http_request_with(String string, String string2) throws IOException {

//            response = reqSpec.when().get(EndPoints.GET_ALL_DIETICIANS)
//                .then().log().all().extract().response();
    }
    @Then("admin recieves {int} ok with response body")
    public void admin_recieves_ok_with_response_body(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }
    @Then("admin recives {int} ok with resonse body")
    public void admin_recives_ok_with_resonse_body(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }

    //SCENARIO

    @Given("admin create put method")
    public void admin_create_put_method() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().put(EndPoints.GET_ALL_DIETICIANS)
                .then().log().all().extract().response();
    }
    @When("admin send put method")
    public void admin_Send_Put_Method() {
//        response = reqSpec
//                .when()
//                .put(EndPoints.GET_ALL_DIETICIANS);
    }
    @Then("admin recieves {int} method not allowed")
    public void admin_recieves_method_not_allowed(Integer int1) {
//        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());
    }

    //SCENARIO 3
//@Given("admin create get request")
//public void admin_create_get_request() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
    @When("admin send {string} http request with invalid {string}")
    public void admin_send_http_request_with_invalid(String string, String string2) {
//        response = reqSpec
//                .when()
//                .get(EndPoints.INVALIDENDPOINT)
//                .then().log().all().extract().response();
    }
    @Then("admin recieves {int} not found")
    public void admin_recieves_not_found(Integer int1) {
        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());
    }

    @When("admin send http request with invalid endpoint")
    public void admin_send_http_request_with_invalid_endpoint() {

    }
    @Given("admin create get request with invalid endpoint")
    public void admin_create_get_request_with_invalid_endpoint() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().get(EndPoints.INVALIDENDPOINT)
                .then().log().all().extract().response();
    }
    @Then("admin got {int} not found")
    public void admin_got_not_found(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }

}
