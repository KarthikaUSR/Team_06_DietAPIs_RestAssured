package stepDefintions;

import Utils.EndPoints;
import Utils.Util1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GetDieticianByID extends Util1 {

    Response response;
    @Given("admin creates get request by dietician id")
    public void admin_creates_get_request_by_dietician_id() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().get(EndPoints.GET_DIETICIAN_BY_ID)
                .then().log().all().extract().response();
    }
    @Then("admin recives {int} ok")
    public void admin_recives_ok(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }


    //with invalid endpoint
    @Given("admin create get request with invalid enpoint")
    public void admin_create_get_request_with_invalid_enpoint() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().get(EndPoints.INVALIDENDPOINT)
                .then().log().all().extract().response();
    }
    @Then("admin recives {int} not found")
    public void admin_recives_not_found(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }

    //invalid id
    @Given("admin create get request with invalid id")
    public void admin_create_get_request_with_invalid_id() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().get(EndPoints.INVALIDId)
                .then().log().all().extract().response();
    }

    @Given("admin create post request with invalid method")
    public void admin_create_post_request_with_invalid_method() throws IOException {
        response = RestAssured.given().baseUri(getGlobalValue("baseURL"))
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .when().post(EndPoints.GET_DIETICIAN_BY_ID)
                .then().log().all().extract().response();
    }
    @When("admin send post http invalid method")
    public void admin_send_post_http_invalid_method() {
        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
    }
//    @Then("admin recives {int} not found")
//    public void admin_recives_not_found(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
@Then("admin recived {int} method not allowed")
public void admin_recived_method_not_allowed(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(int1.intValue(), response.getStatusCode());
}
}
