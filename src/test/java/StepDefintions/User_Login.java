package StepDefintions;

import EndPoints.URL;
import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class User_Login extends BaseClass {

    Response response;
    static GlobalDatas globalDatas=new GlobalDatas();

    @Given("User creates Post request with request body")
    public void user_creates_post_request_with_request_body() throws IOException {
        addBasicAuth(getPropertyFileValue("userEmail"), getPropertyFileValue("password"));
    }
    @When("User send {string} HTTP request with endpoint")
    public void user_send_http_request_with_endpoint(String reqType) {
        response = addReqType(reqType, URL.USERLOGIN);
        int statusCode = getStatusCode(response);
        globalDatas.setStatusCode(statusCode);
    }

    @Then("User recieves statusCode {int} created with response body")
    public void user_recieves_status_code_created_with_response_body(Integer int1) {
        assertEquals(response.getStatusCode(), 200);
    }

}
