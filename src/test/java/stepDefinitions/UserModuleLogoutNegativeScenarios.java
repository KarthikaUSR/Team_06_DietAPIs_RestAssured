package stepDefinitions;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import utils.BearerTokenFetcher_Shobana;
import utils.EndPoints;
import utils.RestUtils;
import pojo.UserLoginPojo;
import pojo.dieticianLogin;

public class UserModuleLogoutNegativeScenarios extends RestUtils {

	RestUtils com = new RestUtils();
	Response response;
	BearerTokenFetcher_Shobana tok = new BearerTokenFetcher_Shobana();
	String D_token;

	@Given("Set bearer token in header")
	public void set_bearer_token_in_header() throws JsonProcessingException, IOException {

		BearerTokenFetcher_Shobana.fetchBearerToken(getGlobalValue("dietEmail"), getGlobalValue("dietPassword"));
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();
	}

	@Given("User creates GET request")
	public void user_creates_get_request() throws IOException {
		/*
		 * String baseUrl =
		 * "https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician/logoutdietician";
		 * 
		 * 
		 * response = RestAssured.get(baseUrl);
		 * 
		 * 
		 * System.out.println("Response: " + response.asString());
		 */
		// com.requestSpecification();

		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();

		System.out.println("adminToken" + getGlobalValue("adminToken"));

	}

	@When("User send GET HTTP request with endpoint")
	public void user_send_get_http_request_with_endpoint() {

		RequestSpecification reqLogout = given().log().all();
		response = reqLogout.when().get(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("User recieves {int} created with Logout successful message")
	public void user_recieves_created_with_logout_successful_message(Integer expectedStatusCode) {
		assertEquals(expectedStatusCode.intValue(), response.statusCode());
	}

	@Given("admin creates POST request")
	public void user_creates_post_request() throws IOException {
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();

	}

	@When("admin send POST HTTP request with endpoint")
	public void user_send_post_http_request_with_endpoint1() {

		RequestSpecification reqLogout = given().log().all();
		response = reqLogout.when().post(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("admin recieves {int} method not allowed")
	public void admin_recieves_method_not_allowed(Integer expectedStatusCode) {

		assertEquals(expectedStatusCode.intValue(), response.statusCode());

	}

	@Given("dietician creates GET request")
	public void dietician_creates_get_request() throws IOException {
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();

	}

	@When("dietician send GET HTTP request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() {
		RequestSpecification reqLogout = given().log().all();
		response = reqLogout.when().get(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("dietician recieves {int} created with Logout successful message")
	public void dietician_recieves_created_with_Logout_successful_message(Integer expectedStatusCode) {

		assertEquals(expectedStatusCode.intValue(), response.statusCode());

	}

	@Given("dietician creates POST request")
	public void dietician_creates_post_request() throws IOException {
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();

	}

	@When("dietician send POST HTTP request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() {
		RequestSpecification reqLogout = given().log().all();
		response = reqLogout.when().post(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("dietician recieves {int} method not allowed")
	public void dietician_recieves_method_not_allowed(Integer expectedStatusCode) {
		assertEquals(expectedStatusCode.intValue(), response.statusCode());

	}

	@Given("patient creates GET request")
	public void patient_creates_get_request() throws IOException {
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();

	}

	@When("patient send GET HTTP request with endpoint")
	public void patient_send_get_http_request_with_endpoint() {
		RequestSpecification reqLogout = given().log().all();
		response = reqLogout.when().get(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("patient recieves {int} created with Logout successful message")
	public void patient_recieves_created_with_Logout_successful_message(Integer expectedStatusCode) {

		assertEquals(expectedStatusCode.intValue(), response.statusCode());

	}

	@Given("patient creates POST request")
	public void patient_creates_post_request() throws IOException {
		reqSpec = given().header("Authorization", "Bearer " + getGlobalValue("adminToken")).spec(requestSpecification())
				.log().all();

	}

	@When("patient send POST HTTP request with endpoint")
	public void patient_send_post_http_request_with_endpoint() {
		RequestSpecification reqLogout = given().log().all();
		response = reqLogout.when().post(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("patient recieves {int} method not allowed")
	public void patient_recieves_method_not_allowed(Integer expectedStatusCode) {
		assertEquals(expectedStatusCode.intValue(), response.statusCode());

	}
}
