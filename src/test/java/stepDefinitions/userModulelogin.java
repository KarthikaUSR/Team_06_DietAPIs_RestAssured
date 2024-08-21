package stepDefinitions;

import static io.restassured.RestAssured.given;

import static org.junit.Assert.assertEquals;

import java.io.IOException;



import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class userModulelogin extends RestUtils {

	RestUtils com = new RestUtils();
	LoginRequest loginrequest = new LoginRequest();
	dieticianLogin loginreq = new dieticianLogin();
	
	Response response;
	

	@Given("User creates Post request with request body")
	public void user_creates_post_request_with_request_body() throws IOException {

	     com.requestSpecification();

		//LoginRequest loginrequest = new LoginRequest();
		loginrequest.setPassword("test");
		loginrequest.setUserLoginEmail("Team6.admin@gmail.com");

	}
	@When("User send POST HTTP request with endpoint")
	public void user_send_post_http_request_with_endpoint() {

		RequestSpecification reqLogin = given().log().all().spec(com.reqSpec).body(loginrequest);
	/*	LoginResponse loginResponse = reqLogin.when().post(EndPoints.USERLOGIN).then().log().all().extract().response()
				.as(LoginResponse.class);*/
		
		response = reqLogin.when()
                .post(EndPoints.USERLOGIN)
                .then()
                .log().all()
                .extract().response();

	}
	
	
	@Then("User recieves statusCode {int} created with response body")
	public void user_recieves_status_code_created_with_response_body(Integer expectedStatusCode) {
		 assertEquals(expectedStatusCode.intValue(), response.statusCode());
	   
	}

	

	@Given("User creates Post request with invalid credential")
	public void user_creates_post_request_with_invalid_credential() throws IOException {
            com.requestSpecification();

		//LoginRequest loginrequest = new LoginRequest();
		loginrequest.setPassword("testt");
		loginrequest.setUserLoginEmail("Team6.adm@gmail.com");

	}

	@Then("User recieves {int} unauthorized")
	public void user_recieves_unauthorized(Integer expectedStatusCode) {
		 assertEquals(expectedStatusCode.intValue(), response.statusCode());
	}

	@Given("User creates GET request with request body")
	public void user_creates_get_request_with_request_body() throws IOException {
		com.requestSpecification();

		//LoginRequest loginrequest = new LoginRequest();
		loginrequest.setPassword("test");
		loginrequest.setUserLoginEmail("Team6.admin@gmail.com");

	

	}

	@When("User send GET HTTP request with endpointt")
	public void user_send_get_http_request_with_endpointt() {
		
		RequestSpecification reqLogin = given().log().all().spec(com.reqSpec).body(loginrequest);
		//	LoginResponse loginResponse = reqLogin.when().post(EndPoints.USERLOGIN).then().log().all().extract().response()
				//	.as(LoginResponse.class);
			
			response = reqLogin.when()
	                .get(EndPoints.USERLOGIN)
	                .then()
	                .log().all()
	                .extract().response();

	}

	@Then("User recieves {int} method not allowed")
	public void user_recieves_method_not_allowed(Integer expectedStatusCode) {
		 assertEquals(expectedStatusCode.intValue(), response.statusCode());
	}

	@When("User send POST HTTP request with invalid endpoint")
	public void user_send_post_http_request_with_invalid_endpoint() throws IOException {
		RequestSpecification reqLogin = given().log().all().spec(com.reqSpec).body(loginrequest);
		
			
			response = reqLogin.when()
	                .post(EndPoints.INVALID_USERLOGIN)
	                .then()
	                .log().all()
	                .extract().response();

	}

	@Given("User creates Post request with request body and invalid content type")
	public void user_creates_post_request_with_request_body_and_invalid_content_type() throws IOException {
		
		com.InvalidContentTyperequestSpecification();
		loginrequest.setPassword("test");
		loginrequest.setUserLoginEmail("Team6.admin@gmail.com");
		

	}

	@Then("User recieves {int} unsupported media type")
	public void user_recieves_unsupported_media_type(Integer expectedStatusCode) {
		 assertEquals(expectedStatusCode.intValue(), response.statusCode());
	}
	
	
	@Given("User creates Post request for dietecian with invalid credential")
	public void user_creates_post_request_for_dietecian_with_invalid_credential() throws IOException {
	   
		com.requestSpecification();
		loginrequest.setPassword("Hoor66");
		loginrequest.setUserLoginEmail("shobana@gmail.com");
	
		
		
	}	

}
