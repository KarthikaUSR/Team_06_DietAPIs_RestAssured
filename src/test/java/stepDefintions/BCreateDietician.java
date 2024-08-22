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

public class BCreateDietician extends Util1 {

    Response Resp;
    Response response;
    @Given("set admin bearer token in request header")
    public void set_admin_bearer_token_in_request_header() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("userEmail"), getGlobalValue("password"));
        requestSpecification();  // Ensure reqSpec is initialized
        reqSpec.header("Authorization", "Bearer " + getGlobalValue("adminToken"));
//        BearerTokenFetcher.fetchBearerToken(getGlobalValue("userEmail"),getGlobalValue("password"));
//        requestSpecification();
//        String adminToken = getToken();
//        System.out.println(adminToken);
//        reqSpec.header("Authorization", "Bearer " + getToken());

    }

    @Given("admin creates {string} request")
    public void admin_creates_request(String Key) throws IOException, ParseException {
////        responseSpecification(201);
//         requestBody = JsonUtils.getJsonDataForKey(Key);
//        System.out.println(requestBody);
////        reqSpec.body(requestBody.toJSONString());
//        setup_dietCreation();
        System.out.println("Sending http request with "+Key+" Endpoint");
        setup_dietCreation();
//        response = dietCreation(Key);
//        System.out.println(response);
//        Util1.setDietId(response.path("id"));

    }
    @When("admin send post {string} http request with endpoint")
    public void admin_send_post_http_request_with_endpoint(String Key) throws IOException, ParseException {
        response = dietCreation(Key).then().log().all().extract().response();
        dietId = response.body().jsonPath().getString("id");
        System.out.println("DieticianID : " + dietId);
        setDietId(dietId);
        if (response == null) {
            throw new RuntimeException("Failed to receive a response from the server.");
        }
    }

    @Then("admin recieves {int} created")
    public void admin_recieves_created(Integer int1) {
//        if (response == null) {
//            throw new RuntimeException("Failed to receive a response from the server.");
//        }
        assertEquals(int1.intValue(), response.getStatusCode());

    }



    @Given("admin creates post reqeust with valid data")
    public void admin_creates_post_reqeust_with_valid_data() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("dietEmail"), getGlobalValue("dietPassword"));
        requestSpecification();  // Ensure reqSpec is initialized
        reqSpec.header("Authorization", "Bearer " + getGlobalValue("dietToken"));
    }
    @When("admin send post http request with endpoint")
    public void admin_send_post_http_request_with_endpoint() {
        response = reqSpec
                .when()
                .post(EndPoints.CREATE_DIETICIAN);
    }
    @Then("admin recives {int} forbidden")
    public void admin_recives_forbidden(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }

    @Given("admin creates post request with patient token")
    public void admin_creates_post_request_with_patient_token() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("patEmail"), getGlobalValue("patPassword"));
        requestSpecification();  // Ensure reqSpec is initialized
        reqSpec.header("Authorization", "Bearer " + getGlobalValue("patToken"));
    }
    @Then("admin recives {int} forbidden for patient token")
    public void admin_recives_forbidden_for_patient_token(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }



}
