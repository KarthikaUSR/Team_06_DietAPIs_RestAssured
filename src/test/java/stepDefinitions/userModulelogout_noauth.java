package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import pojo.LogoutRequest;

import utils.EndPoints;
import utils.RestUtils;

public class userModulelogout_noauth extends RestUtils {

	RestUtils com = new RestUtils();
	Response response;
	LogoutRequest logoutrequest = new LogoutRequest();

	@Given("User creates GET request for admin")
	public void user_creates_get_request_for_admin() throws IOException {

		com.requestSpecification();
	}

	@When("User send GET HTTP request with endpoint for admin")
	public void user_send_get_http_request_with_endpoint_for_admin() {
		RequestSpecification reqLogout = given().log().all().spec(com.reqSpec).body(logoutrequest);

		response = reqLogout.when()

				.get(EndPoints.USERLOGIN).then().log().all().extract().response();

	}

	@Then("admin recieves {int} unauthorized")
	public void admin_recieves_unauthorized(Object int1) {

		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("User creates GET request for dietician")
	public void user_creates_get_request_for_dietician() throws IOException {
		com.requestSpecification();

	}

	@When("User send GET HTTP request with endpoint for dietician")
	public void user_send_get_http_request_with_endpoint_for_dietician() {
		RequestSpecification reqLogout = given().log().all().spec(com.reqSpec).body(logoutrequest);
		response = reqLogout.when().get(EndPoints.USERLOGOUT).then().log().all().extract().response();

	}

	@Then("dietecian recieves {int} unauthorized")
	public void dietecian_recieves_unauthorized(Object int1) {

		Assert.assertEquals(response.statusCode(), int1);
	}

	@Given("User creates GET request for patient")
	public void user_creates_get_request_for_patient() throws IOException {
		com.requestSpecification();

	}

	@When("User send GET HTTP request with endpoint for patient")
	public void user_send_get_http_request_with_endpoint_for_patient() {
		RequestSpecification reqLogout = given().log().all().spec(com.reqSpec).body(logoutrequest);

		response = reqLogout.when().get(EndPoints.PATIENTLOGIN).then().log().all().extract().response();
	}

	@Then("patient recieves {int} unauthorized")
	public void patient_recieves_unauthorized(Object int1) {

		Assert.assertEquals(response.statusCode(), int1);
	}
}
