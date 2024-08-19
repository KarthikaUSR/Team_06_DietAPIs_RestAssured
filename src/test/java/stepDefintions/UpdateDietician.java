package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class UpdateDietician extends RestUtils {

    @Given("set admin token in header")
    public void set_admin_token_in_header() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
        requestSpecification();
//        setTokenInHeaderRequestSpec();
    }

    @Given("admin creates put request with mandatory and additional details")
    public void admin_creates_put_request_with_mandatory_and_additional_details() throws IOException {

        reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
                .spec(requestSpecification())
                .body("{\n" +
                        "  \"ContactNumber\": \"1144331122\",\n" +
                        "  \"DateOfBirth\": \"2009-07-26T18:14:08.570Z\",\n" +
                        "  \"Education\": \"MA\",\n" +
                        "  \"Email\": \"test@email.com\",\n" +
                        "  \"Firstname\": \"rajl\",\n" +
                        "  \"HospitalCity\": \"fremont\",\n" +
                        "  \"HospitalName\": \"kp\",\n" +
                        "  \"HospitalPincode\": \"123456\",\n" +
                        "  \"HospitalStreet\": \"paseo\",\n" +
                        "  \"Lastname\": \"booni\"\n" +
                        "\n" +
                        "}")
                .log().all();

    }

    @When("admin send put request with endpoint")
    public void admin_send_put_request_with_endpoint() throws IOException {
        response = reqSpec.when()
                .put(EndPoints.UPDATE_DIETICIAN_BY_ID)
                .then()
                .log().all()
//                .spec(responseSpecification())
                .extract().response();
    }
    @Then("admin recieves {int} ok with updated response body")
    public void admin_recieves_ok_with_updated_response_body(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }


}
