package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.BearerTokenFetcher;

public class PatientModuleNoAuth {
	
	
	
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;
	
	
	
	@Given("^User able to (.+) request$")
	public void user_create_get_request(String key) throws IOException {
		System.out.println("Sending http request for "+key+" Endpoint");
		patient_mod.setup_Noauth();

	}

	@When("^User send http get all patient request with endpoint (.+)$")
	public void user_send_get_http_get_all_patient_request_with_endpoint(String key) throws IOException {
		
		Resp=patient_mod.PatientEndPoints_NoAuth(key);
	}

	@Then("User recieves {string} with response body")
	public void user_recieves_ok_with_response_body(String status) {
		
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
  
	}


}




