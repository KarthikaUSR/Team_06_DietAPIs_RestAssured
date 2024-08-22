package stepDefintions;

import Utils.EndPoints;
import Utils.Util1;
import com.google.gson.Gson;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.UserLoginPojo;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class AUserLogin extends Util1 {

    UserLoginPojo userLoginPojo = new UserLoginPojo();
    Response response;
//    String userEmail = getGlobalValue("userEmail");
//    String password = getGlobalValue("password");

    Gson gson = new Gson();
    String requestBody = gson.toJson(userLoginPojo);


    @Given("User creates Post request with request body")
    public void user_creates_post_request_with_request_body() throws IOException {
        userLogin();
    }
    @When("User send {string} HTTP request with endpoint")
    public void user_send_http_request_with_endpoint(String reqType) {
        response = reqSpec
                .when()
                .post(EndPoints.USERLOGIN);
    }

    @Then("User recieves statusCode {int} created with response body")
    public void user_recieves_status_code_created_with_response_body(Integer int1) {
        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());

        //Extract token
        token = response.body().jsonPath().getString("token");
        System.out.println("User Admin Token is : " + token);
        setToken(token);
    }



    @Given("User creates Post request with invalid credential")
    public void user_creates_post_request_with_invalid_credential() throws IOException {
        userLoginInvalidCredential();
    }
//    @When("User send POST HTTP request with endpoint")
//    public void user_send_post_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    @Then("User recieves statusCode {int} unauthorized")
    public void user_recieves_status_code_unauthorized(Integer int1) {
        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());
    }

    @Given("User creates GET request with request body")
    public void user_creates_get_request_with_request_body() throws IOException {
        userLogin();
    }
    @When("User send GET HTTP request with endpointt")
    public void user_send_get_http_request_with_endpointt() {
        response = reqSpec
                .when()
                .get(EndPoints.USERLOGIN);
    }
    @Then("User recieves statusCode {int} method not allowed")
    public void user_recieves_status_code_method_not_allowed(Integer int1) {
        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());
    }
    @When("User send POST HTTP request with invalid endpoint")
    public void user_send_post_http_request_with_invalid_endpoint() {
        response = reqSpec
                .when()
                .post(EndPoints.USERLOGOUT);
    }
//    @Then("User recieves statusCode {int} unauthorized")
//    public void user_recieves_status_code_unauthorized(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


//    @When("User send POST HTTP request with endpoint")
//    public void user_send_post_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    @Then("User recieves statusCode {int} unsupported media type")
    public void user_recieves_status_code_unsupported_media_type(Integer int1) {
        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());
    }
//    @When("User send POST HTTP request with endpoint")
//    public void user_send_post_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @Given("User creates Post request for dietecian with invalid credential")
    public void user_creates_post_request_for_dietecian_with_invalid_credential() throws IOException {
        userLoginInvalidCredential();
    }
//    @When("User send POST HTTP request with endpoint")
//    public void user_send_post_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
    @Then("User recieves {int} unauthorized")
    public void user_recieves_unauthorized(Integer int1) {
        response.then().spec(Util1.createResponseSpecification(int1));
        assertEquals(int1.intValue(), response.getStatusCode());
    }

//    @When("User send POST HTTP request with endpoint")
//    public void user_send_post_http_request_with_endpoint() throws IOException {
//        dieticianLogin();
//    }

    @Given("User creates Post request for dietician with invalid credential")
    public void user_creates_post_request_for_dietician_with_invalid_credential() throws IOException {
        userLoginInvalidCredential();
    }

    @When("User send POST HTTP request with endpoint")
    public void user_send_post_http_request_with_endpoint() {
        response = reqSpec
                .when()
                .post(EndPoints.USERLOGIN);
    }

    @Given("User creates Post request as patient valid credential")
    public void user_creates_post_request_as_patient_valid_credential() throws IOException {
        patientLogin();
    }

    @Given("User creates Post request as patient with invalid credential")
    public void user_creates_post_request_as_patient_with_invalid_credential() throws IOException {
        userLoginInvalidCredential();
    }

    @Given("User creates Post request with dietician valid credential")
    public void user_creates_post_request_with_dietician_valid_credential() throws IOException {
        dieticianLogin();
    }

    @When("User send POST HTTP request with dietician valid endpoint")
    public void user_send_post_http_request_with_dietician_valid_endpoint() {
        response = reqSpec
                .when()
                .post(EndPoints.USERLOGIN);
    }

    @When("User send POST HTTP request with patient valid credential")
    public void user_send_post_http_request_with_patient_valid_credential() {
        response = reqSpec
                .when()
                .post(EndPoints.USERLOGIN);
    }

    @Given("User creates Post request with request body and invalid content type")
    public void user_creates_post_request_with_request_body_and_invalid_content_type() throws IOException {
        userLoginInvalidContentType();
    }

//    @Then("User recieves {int} unauthorized")
//    public void user_recieves_unauthorized(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


    // ##### REFER THIS FOR FUTURE ########
//    @When("User send {string} HTTP request with endpoint")
//    public void user_send_http_request_with_endpoint(String reqType) {
//        response = addReqType(reqType);
//        if(reqType.equalsIgnoreCase("POST")){
//            response = reqSpec.when().get(EndPoints.USERLOGIN);
//        }else if (reqType.equalsIgnoreCase("GET")) {
//            response = reqSpec.when().get(EndPoints.USERLOGOUT);
//        }
//        response.then().log().all().extract();
//        response = reqSpec
//                .when()
//                .post(EndPoints.USERLOGIN);
//    }



}
