package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PatientInfo;
import utils.BearerTokenFetcher;


public class PatientCreation {

	PatientInfo patientinfo=new PatientInfo();
	Patient_Modules patient_mod =Patient_Modules.getInstance() ;
	Response Resp;
	
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
		patientinfo.setPatientFileID(FileID);
		patientinfo.setEmail(Email);
		patientinfo.setPatientID(PatientID);
		}
		else if(Statuscode==400)
		{
			String ErrorMsg=Resp.body().jsonPath().getString("errorCode");
			System.out.println("ERROR MESSAGE" +ErrorMsg);
		}	
		else
		{
			String ErrorMsg=Resp.body().jsonPath().getString("error");
			System.out.println("ERROR MESSAGE" +ErrorMsg);
			
		}
		
	}
	

	@Given("^(.+) creates request by entering valid data into the form data$")
	public void creates_request_by_entering_valid_data_into_the_form_datat(String S) {
		
		
		System.out.println("Login Role:" +S);
		
		patient_mod.setup_PatientCreation();
	  
	}

	@When("^(.+) send http requests with endpoint for patient creation$")
	public void send_http_requests_with_endpoint_for_patient_creation(String key) throws IOException {
		
		System.out.println("Request Sending With " +key+" Token");
		Resp=patient_mod.GetAllPatients_sendrequest(key);


	}

	
	/*@Given("Dietician creates POST request by entering all valid data into the form-data key and value fields")
	public void dietician_creates_post_request_by_entering_all_valid_data_into_the_form_data_key_and_value_fields() {
		patient_mod.setup_PatientCreation();
	   
	}

	@When("Dietician send POST http request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() throws IOException {
		patient_mod.patientcreation();
	   
	}

	@Then("Dietician recieves {int} created and with response body and Auto created PatientID")
	public void dietician_recieves_created_and_with_response_body_and_auto_created_patient_id(int status) {
		Assert.assertEquals(Resp.statusCode(), status);
	}

	@Given("Dietician creates POST request only by valid mandatory details into the form-data key and value fields")
	public void dietician_creates_post_request_only_by_valid_mandatory_details_into_the_form_data_key_and_value_fields() {
		patient_mod.setup_PatientCreation();
	}
	
	@When("Dietician send POST http request with endpoint with valid mandatory details")
	public void dietician_send_post_http_request_with_endpoint_with_valid_mandatory_details() throws IOException {
		patient_mod.patientcreation_onlymandatory();
	   
	}

	@Given("Dietician creates POST request only by valid additional details into the form-data key and value fields")
	public void dietician_creates_post_request_only_by_valid_additional_details_into_the_form_data_key_and_value_fields() {
		patient_mod.setup_PatientCreation();
	}
	
	@When("Dietician send POST http request with endpoint with valid additional details")
	public void dietician_send_post_http_request_with_endpoint_with_valid_additional_details() throws IOException {
		patient_mod.patientcreation_onlyadditional();
	   
	}

	@Then("Dietician recieves {int} Bad request")
	public void dietician_recieves_bad_request(int status) {
		Assert.assertEquals(Resp.statusCode(), status);
	}

	@Given("Dietician creates POST request only by invalid mandatory details into the form-data key and value fields")
	public void dietician_creates_post_request_only_by_invalid_mandatory_details_into_the_form_data_key_and_value_fields() {
		patient_mod.setup_PatientCreation();
	}
	
	@When("Dietician send POST http request with endpoint with invalid mandatory details")
	public void dietician_send_post_http_request_with_endpoint_with_invalid_mandatory_details() throws IOException {
		patient_mod.patientcreation_onlyinvalidmandatory();
	   
	}
	//work
	@Given("Dietician creates POST request only by invalid additional details into the form-data key and value fields")
	public void dietician_creates_post_request_only_by_invalid_additional_details_into_the_form_data_key_and_value_fields() {
		patient_mod.setup_PatientCreation();

	}
	
	@When("Dietician send POST http request with endpoint with invalid additional details")
	public void dietician_send_post_http_request_with_endpoint_with_invalid_additional_details() throws IOException {
		patient_mod.patientcreation_onlyinvalidadditional();
	   
	}
	@Given("Dietician creates PUT request by entering valid data into the form-data key and value fields.")
	public void dietician_creates_put_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Dietician creates POST request by entering valid data into the form-data key and value fields.")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Dietician sent POST http request with invalid endpoint")
	public void dietician_sent_post_http_request_with_invalid_endpoint() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Dietician creates POST request by entering valid data into the form-data key and value fields and invalid content type")
	public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields_and_invalid_content_type() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Dietician recieves {int} unsupported media type")
	public void dietician_recieves_unsupported_media_type(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

*/


}
