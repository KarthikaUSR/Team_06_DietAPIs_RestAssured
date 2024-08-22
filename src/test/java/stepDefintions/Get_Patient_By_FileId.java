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
import utils.BearerTokenFetcher;

public class Get_Patient_By_FileId {
BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;
	
	@Given("^Dietician create (.+) request for retrieve patients by field$")
	public void dietician_create_getpatient_request(String key) throws IOException {
		System.out.println("Sending http request with "+key+" Endpoint");
		patient_mod.setup_GetAllPatients();

	}

	@When("^Dietician send http request for retrieve patients by field with endpoint (.+)$")
	public void dietician_send_getpatient_http_get_all_patient_request_with_endpoint(String key) throws IOException {
		
		Resp=patient_mod.deletepatient_sendrequest(key);
	}

	@Then("^Dietician recieves (.+) with response body for retrieve patients by field$")
	public void dietician_recieves_code_with_response_body_for_getpatient(String status) {
		
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
  
	}


	@Given("^(.+) create Get requests to get patient by ID$")
	public void patient_create_delete_request(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}

	@When("^(.+) send Get http requests to get patient by ID with endpoint$")
	public void patient_send_delete_http_request_with_endpoint(String key) throws IOException {

		System.out.println("Request Sending With " + key + " Token");
		Resp = patient_mod.deletepatient_sendrequest(key);

	}
	@Then("^(.+) recieves (.+) Forbidden for getting patient by ID$")
	public void patient_recieves_forbidden_for_get_all_patient(String S,String S1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		int statuscode=Integer.parseInt(S1);
		Assert.assertEquals(Resp.statusCode(), statuscode);
	    
	}





}
