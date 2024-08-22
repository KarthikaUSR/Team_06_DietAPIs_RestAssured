package stepDefintions;

import java.io.IOException;
import java.util.Map;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PatientInfo;
import utils.BearerTokenFetcher;


public class PatientCreation {

	
	Patient_Modules patient_mod =Patient_Modules.getInstance() ;
	Response Resp;
	PatientInfo patientinfo=new PatientInfo();
	
	@Given("^Dietician creates (.+) request into the form-data key and value fields$")
	public void Dietician_creates_request_into_the_form_data_key_and_value_fields(String key) {
		System.out.println("Sending http request with "+key+" Endpoint");
		patient_mod.setup_PatientCreation();
	   
	}

	@When("^Dietician send http patient creation request with endpoint (.+)$")
	public void dietician_send_post_http_patient_creation_request_with_endpoint(String key) throws IOException {
		Resp=patient_mod.PatientCreation(key);
	   
	}

	@Then("^Dietician recieves (.+) with response body for patient$")
	public void dietician_recieves_created_and_with_response_body_and_auto_created_patient_id(String status) {
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
	
	}
	@Then("Validate the response body")
	public void Validate_the_response_body() {
		int Statuscode=Resp.statusCode();
		if(Statuscode==201)
		{
		String Email=Resp.body().jsonPath().getString("Email");
		String PatientID=Resp.body().jsonPath().getString("patientId");
		String FileID=Resp.body().jsonPath().getMap("FileMorbidity").keySet().toString();
		System.out.println("Email : "+Email);
		System.out.println("PatientID : "+PatientID);
		System.out.println("FileID : "+FileID);
		}
		
		
	}
	

	@Given("^(.+) creates request by entering valid data into the form-data$")
	public void creates_request_by_entering_valid_data_into_the_form_datat(String S) {
		
		
		System.out.println("Login Role:" +S);
		
		patient_mod.setup_PatientCreation();
	  
	}

	@When("^(.+) send http requests with endpoint for patient creation$")
	public void send_http_requests_with_endpoint_for_patient_creation(String key) throws IOException {
		
		System.out.println("Request Sending With " +key+" Token");
		Resp=patient_mod.PatientCreation(key);
	}
		
	@Then("^(.+) recieves (.+) Forbidden for patient creation$")
	public void patient_recieves_Forbidden_for_patient_creation(String S,int int1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);
		    
		}


	

	

}
