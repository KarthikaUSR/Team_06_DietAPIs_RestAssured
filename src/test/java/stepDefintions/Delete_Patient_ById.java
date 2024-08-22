package stepDefintions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import aPI_Modules.Patient_Modules;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PatientInfo;
import utils.BearerTokenFetcher;

public class Delete_Patient_ById {
BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	PatientInfo patientinfo=new PatientInfo();
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;


	@Given("^Dietician create (.+) request for Delete patient$")
	public void dietician_create_delete_request(String key) throws IOException {
		System.out.println("Sending http request with "+key+" Endpoint");
		patient_mod.setup_GetAllPatients();

	}

	@When("^Dietician send http Delete request with endpoint (.+)$")
	public void dietician_send_delete_http_get_all_patient_request_with_endpoint(String key) throws IOException {
		
		Resp=patient_mod.deletepatient_sendrequest(key);
	}

	@Then("^Dietician recieves (.+) with response body for Delete Patient$")
	public void dietician_recieves_code_with_response_body_for_delete_patient(String status) {
		
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
  
	}


	@Given("^(.+) create Delete requests$")
	public void patient_create_delete_request(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}

	@When("^(.+) send Delete http requests with endpoint$")
	public void patient_send_delete_http_request_with_endpoint(String key) throws IOException {

		System.out.println("Request Sending With " + key + " Token");
		Resp = patient_mod.deletepatient_sendrequest(key);

	}
	@Then("^(.+) recieves (.+) Forbidden for delete patient$")
	public void patient_recieves_forbidden_for_get_all_patient(String S,int int1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);
	    
	}



}

