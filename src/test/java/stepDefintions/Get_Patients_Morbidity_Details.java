package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.BearerTokenFetcher;

public class Get_Patients_Morbidity_Details {
	
   BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;
	
	@Given("^Dietician create (.+) request for retrieve patients morbidity details by patient ID$")
	public void dietician_create_retrieve_patients_morbidity_request(String key) throws IOException {
		System.out.println("Sending http request with "+key+" Endpoint");
		patient_mod.setup_GetAllPatients();

	}

	@When("^Dietician send http request for retrieve patients morbidity details by patient ID with endpoint (.+)$")
	public void dietician_send_retrieve_patients_morbidity_http_get_all_patient_request_with_endpoint(String key) throws IOException {
		
		Resp=patient_mod.getpatientmorbidity_sendrequest(key);
	}

	@Then("^Dietician recieves (.+) with response body for retrieve patients morbidity details by patient ID$")
	public void dietician_recieves_code_with_response_body_for_retrieve_patients_morbidity(String status) {
		
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
  
	}


	@Given("^(.+) create Get requests to retrieve Morbidity$")
	public void patient_create_retrieve_patients_morbidity_request(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}

	@When("^(.+) send Get http requests with endpoint for retrieve Morbidity$")
	public void patient_send_retrieve_patients_morbidity_http_request_with_endpoint(String key) throws IOException {

		System.out.println("Request Sending With " + key + " Token");
		Resp = patient_mod.getpatientmorbidity_sendrequest(key);

	}
	@Then("^(.+) recieves (.+) Forbidden for retrieve Morbidity$")
	public void patient_recieves_forbidden_for_retrieve_patients_morbidity(String S,String S1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		int statuscode=Integer.parseInt(S1);
		Assert.assertEquals(Resp.statusCode(), statuscode);
	    
	}




}

