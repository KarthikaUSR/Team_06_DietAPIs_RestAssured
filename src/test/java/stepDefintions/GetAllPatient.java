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


public class GetAllPatient {
	
	BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;
	
	

	@Given("Set Dietician token")
	public void Set_Dietician_token(DataTable dataTable) throws JsonProcessingException {
		List<Map<String,String>> credentials=dataTable.asMaps();
		String Diet_username=credentials.get(0).get("D_Email");
		String Diet_password=credentials.get(0).get("D_Password");
		String Diet_role=credentials.get(0).get("Role");
		D_token=tok.Token(Diet_role,Diet_username, Diet_password);
		patient_mod.tokengen(D_token);
		//patient_mod.token=D_token;
	
	}

	@Given("^Dietician create (.+) request$")
	public void dietician_create_get_request(String key) throws IOException {
		System.out.println("Sending http request with "+key+" Endpoint");
		patient_mod.setup_GetAllPatients();

	}

	@When("^Dietician send http get all patient request with endpoint (.+)$")
	public void dietician_send_get_http_get_all_patient_request_with_endpoint(String key) throws IOException {
		
		Resp=patient_mod.GetAllPatients_sendrequest(key);
	}

	@Then("^Dietician recieves (.+) with response body$")
	public void dietician_recieves_ok_with_response_body(String status) {
		
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
  
	}



	@Given("^(.+) Set Token with (.+) (.+)$")
	public void set_token_with_Email_Password(String S,String S1,String S2) throws JsonProcessingException {
		
		D_token=tok.Token(S,S1,S2);
		patient_mod.tokengen(D_token);
		
	
	}

	@Given("^(.+) create GET requests$")
	public void patient_create_get_request(String S) {
		
		
		System.out.println("Login Role:" +S);
		
		patient_mod.setup_GetAllPatients();
	  
	}

	@When("^(.+) send GET http requests with endpoint$")
	public void patient_send_get_http_request_with_endpoint(String key) throws IOException {
		
		System.out.println("Request Sending With " +key+" Token");
		Resp=patient_mod.GetAllPatients_sendrequest(key);


	}

	@Then("^(.+) recieves (.+) Forbidden$")
	public void patient_recieves_forbidden(String S,int int1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);
	    
	}


	
	
}

