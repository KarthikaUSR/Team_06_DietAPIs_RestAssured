package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.io.IOException;

import static Utils.RestUtils.getGlobalValue;
import static org.junit.Assert.assertEquals;

public class UserLogout extends RestUtils {

    @Given("user creates get request")
    public void user_creates_get_request() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
//        reqSpec=requestSpecification();
        if (reqSpec == null) {
            throw new IllegalStateException("Request Specification is not initialized");
        }
    }



    @When("user send http request with endpoint")
    public void user_send_http_request_with_endpoint() throws IOException {

            response = reqSpec.when()
                    .get(EndPoints.USERLOGOUT)
                    .then()
                    .log().all()
//                    .spec(responseSpecification())
                    .extract().response();

    }
    @Then("user recives {int} created with logout successful message")
    public void user_recives_created_with_logout_successful_message(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }
}
