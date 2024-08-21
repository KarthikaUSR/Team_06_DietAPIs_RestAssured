package StepDefintions;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;

import Utils.BearerTokenFetcher;
import Utils.RestUtils;
import Utils.JsonUtils;
import Utils.EndPoints;
import static Utils.JsonUtils.getJsonDataForKey;

import io.cucumber.core.internal.com.fasterxml.jackson.core.type.TypeReference;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matcher;

public class CreateDietician extends RestUtils {

	@Given("set admin bearer token in request header")
	public void set_admin_bearer_token_in_request_header() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"),getGlobalValue("password"));
		requestSpecification();
	}

//	@Given("admin creates DietCreationValid request")
//	public void admin_creates_diet_creation_valid_request 
	@Given("admin creates {string} request")
	public void admin_creates_request(String Key) {
	    // Write code here that turns the phrase above into concrete actions
//		String requestBody = JsonUtils.getRequestBody(Key);
//		System.out.println(requestBody);
		// Retrieve a specific value from the JSON based on the key
//		Object value = getJsonDataForKey(Key);
//		System.out.println(value);
//		response = reqSpec.body(value) .when() .post(EndPoints.CREATE_DIETICIAN) .then() .log().all() .extract().response();
//		response.prettyPrint();
		
		 File json1 = new File(System.getProperty("user.dir") + "/src/test/resources/testData/PatientCreationData_CHECK.json");

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> userData = mapper.readValue(  
						json1, new TypeReference<Map<String, Object>>() {  
	            });
		
			JSONObject jsonObj = new JSONObject(userData); 
			String jsonbody=jsonObj.get(Key).toString();
	}

	@When("admin send post http request with endpoint")
	public void admin_send_post_http_request_with_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
		if (reqSpec == null) { 
			throw new IllegalStateException("Request Specification (reqSpec) is not initialized. Ensure that requestSpecification() is called and properly sets reqSpec."); 
			} 
		response = reqSpec.when() .post(EndPoints.CREATE_DIETICIAN) .then() .log().all() .extract().response();
		response.prettyPrint();
		
	
	}

	@Then("admin recieves {int} created")
	public void admin_recieves_created(Integer expectedStatusCode) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
		System.out.println("expectedStatusCode : "+ expectedStatusCode);
		System.out.println("respStatusCode : "+ response.getStatusCode());

	}

//	@Given("admin creates DietCreationValidMandatory request")
//	public void admin_creates_diet_creation_valid_mandatory_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("admin creates DietCreationValidAdditional request")
//	public void admin_creates_diet_creation_valid_additional_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("admin creates DietCreationInValidMandatory request")
//	public void admin_creates_diet_creation_in_valid_mandatory_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("admin creates DietCreationInValidAdditional request")
//	public void admin_creates_diet_creation_in_valid_additional_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("admin creates DietCreationValidDataInvalidMethod request")
//	public void admin_creates_diet_creation_valid_data_invalid_method_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("admin creates DietCreationValidDataInvalidEndpoints request")
//	public void admin_creates_diet_creation_valid_data_invalid_endpoints_request() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
}
