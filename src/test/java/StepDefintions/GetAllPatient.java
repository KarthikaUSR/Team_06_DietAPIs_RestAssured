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
import utils.RestUtils;

public class GetAllPatient {
	
	BearerTokenFetcher tok=new BearerTokenFetcher();
	RestUtils com=new RestUtils();
	String D_token;
	Patient_Modules patient_mod=new Patient_Modules();
	Response Resp;
	
	

	@Given("Set Dietician token")
	public void Set_Dietician_token(DataTable dataTable) throws JsonProcessingException {
		List<Map<String,String>> credentials=dataTable.asMaps();
		String Diet_username=credentials.get(0).get("D_Email");
		String Diet_password=credentials.get(0).get("D_Password");
		String Diet_role=credentials.get(0).get("Role");
		D_token=tok.Token(Diet_role,Diet_username, Diet_password);	
		System.out.println("token"+D_token);
	}

	@Given("Dietician create GET request")
	public void dietician_create_get_request() throws IOException {
		
		patient_mod.setup_Endpoints();

	}

	@When("Dietician send GET http request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() throws IOException {
		
		Resp=patient_mod.getpatient_sendrequest(D_token);
	}

	@Then("Dietician recieves {int} with response body")
	public void dietician_recieves_ok_with_response_body(int status) {
		
		System.out.println("Status_code:" +Resp.statusCode());
		
		Assert.assertEquals(Resp.statusCode(), status);
  
	}


	@Given("Dietician create PUT request")
	public void dietician_create_put_request() {
		patient_mod.setup_Endpoints();
	    
	}

	@When("Dietician send PUT http request with endpoint")
	public void dietician_send_put_http_request_with_endpoint() throws IOException {
		
		Resp=patient_mod.putpatient_sendrequest(D_token);
		System.out.println("Status_code:" +Resp.statusCode());
	   
	}

	@Then("Dietician recieves {int} method not allowed")
	public void dietician_recieves_method_not_allowed(int status) {
		
		Assert.assertEquals(Resp.statusCode(), status);
	
	
	}

	@When("Dietician send GET http request with invalid endpoint")
	public void dietician_send_get_http_request_with_invalid_endpoint() throws IOException {
		
		Resp=patient_mod.Invaid_sendrequest(D_token);
		System.out.println("Status_code:" +Resp.statusCode());
	
	}

	@Then("Dietician recieves {int} not found")
	public void dietician_recieves_not_found(int status) {
		
		Assert.assertEquals(Resp.statusCode(), status);

	}

	@Given("^(.+) Set Token with (.+) (.+)$")
	public void set_token_with_Email_Password(String S,String S1,String S2) throws JsonProcessingException {
		
		D_token=tok.Token(S,S1,S2);
		
	
	}

	@Given("^(.+) create GET requests$")
	public void patient_create_get_request(String S) {
		
		
		System.out.println("Login Role:" +S);
		
		patient_mod.setup_Endpoints();
	  
	}

	@When("^(.+) send GET http requests with endpoint$")
	public void patient_send_get_http_request_with_endpoint(String S) throws IOException {
		
		System.out.println("Request Sending With " +S+" Token");
		Resp=patient_mod.getpatient_sendrequest(D_token);

	}

	@Then("^(.+) recieves (.+) Forbidden$")
	public void patient_recieves_forbidden(String S,int int1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);
	    
	}


	
	
}
