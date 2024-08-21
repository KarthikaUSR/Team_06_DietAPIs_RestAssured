package StepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Utils.BearerTokenFetcher;
import Utils.RestUtils;
import Utils.JsonUtils;
import Utils.EndPoints;
import static Utils.JsonUtils.getJsonDataForKey;
import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import static org.junit.Assert.assertEquals;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class GetDieticianById extends RestUtils {
	 Response response;
	 
	@Given("Admin create GET request")
	public void admin_create_get_request() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken"))
	                .spec(requestSpecification())
	                .log().all();
		
	}

	@When("Admin send GET http request with endpoint")
	public void admin_send_get_http_request_with_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
		response = RestUtils.reqSpec.when()
                .get(EndPoints.GET_DIETICIAN_BY_ID)
                .then()
                .log().all()
                .extract().response();
	}

	@Then("Admin recieves {int} ok with details of the dietician ID")
	public void admin_recieves_ok_with_details_of_the_dietician_id(Integer expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
		 assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
		 System.out.println("expectedStatusCode : "+ expectedStatusCode);
			System.out.println("respStatusCode : "+ response.getStatusCode());
	}


}
