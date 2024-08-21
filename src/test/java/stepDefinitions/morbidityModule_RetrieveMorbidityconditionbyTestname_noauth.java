package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.EndPoints;
import utils.RestUtils;

public class morbidityModule_RetrieveMorbidityconditionbyTestname_noauth extends RestUtils{

	
	
	RestUtils com = new RestUtils();
	Response response;
	@Given("dietician create GET request")
	public void dietician_create_get_request() throws IOException {
		
		com.requestSpecification();
		
	}
	
	@When("dietician send GET http request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() {
		
		RequestSpecification morbidity = given().log().all().spec(com.reqSpec);
		response = morbidity.when().get(EndPoints.MORBIDITY_CONDITION_BY_TESTNAME).then().log().all().extract().response();
		
    }
	
	@Then("dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(Object int1) {
		Assert.assertEquals(response.statusCode(), int1);
		
		
		
	}


}
