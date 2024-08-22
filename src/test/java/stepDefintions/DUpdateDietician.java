package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.RestUtils;
import Utils.Util1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class DUpdateDietician extends Util1 {
    Response response;
    String dietId;
    @Given("set admin token in header")
    public void set_admin_token_in_header() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
        requestSpecification();
//        setTokenInHeaderRequestSpec();
    }

    @Given("admin creates {string} request with valid mandatory, optional fields")
    public void admin_creates_request_with_valid_mandatory_optional_fields(String Key) throws IOException {
        System.out.println("Sending http request with "+Key+" Endpoint");
        dietId = Util1.getDietId();
        setup_dietCreation();

    }
    @When("admin send http request {string} with endpoint")
    public void admin_send_http_request_with_endpoint(String Key) throws IOException, ParseException {
        response = updateDietician(Key).then().log().all().extract().response();
        if (response == null) {
            throw new RuntimeException("Failed to receive a response from the server.");
        }
    }
    @Then("admin recieves {int} ok with updated response body")
    public void admin_recieves_ok_with_updated_response_body(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }

    @Given("admin creates put reqeust with dietician token")
    public void admin_creates_put_reqeust_with_dietician_token() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("dietEmail"),getGlobalValue("dietPassword"));
        requestSpecification();
    }
    @When("admin send put http request with endpoint and diet token")
    public void admin_send_put_http_request_with_endpoint_and_diet_token() {
        response = reqSpec
                .when()
                .post(EndPoints.UPDATE_DIETICIAN_BY_ID);

//        response = reqSpec.when()
//                .put(EndPoints.UPDATE_DIETICIAN_BY_ID)
//                .then()
//                .log().all()
////                .spec(responseSpecification())
//                .extract().response();
//
    }

    @Given("admin creates put request with valid data and patient bearer token")
    public void admin_creates_put_request_with_valid_data_and_patient_bearer_token() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("patEmail"),getGlobalValue("patPassword"));
        requestSpecification();
    }
    @When("admin send put http request with endpoint and patient token")
    public void admin_send_put_http_request_with_endpoint_and_patient_token() {
        response = reqSpec
                .when()
                .post(EndPoints.UPDATE_DIETICIAN_BY_ID);
    }
    @Given("admin creates put request with valid data and invalid content type")
    public void admin_creates_put_request_with_valid_data_and_invalid_content_type() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("userEmail"),getGlobalValue("Password"));
        requestSpecification();
    }
    @When("admin send put request with invalid content type")
    public void admin_send_put_request_with_invalid_content_type() {
        response = reqSpec
                .when()
                .post(EndPoints.UPDATE_DIETICIAN_BY_ID);
    }
    @Then("admin recieves {int} unsuported media type")
    public void admin_recieves_unsuported_media_type(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }

//    @When("admin send put request with endpoint")
//    public void admin_send_put_request_with_endpoint() throws IOException {
//        response = reqSpec.when()
//                .put(EndPoints.UPDATE_DIETICIAN_BY_ID)
//                .then()
//                .log().all()
////                .spec(responseSpecification())
//                .extract().response();
//    }



}
