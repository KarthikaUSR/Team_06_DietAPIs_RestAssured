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

public class Get_all_Morbidities {
	BearerTokenFetcher tok = new BearerTokenFetcher();

	String A_token;
	Patient_Modules patient_mod = Patient_Modules.getInstance();
	Response Resp;

	@Given("Set Admin Token")
	public void Set_Admin_Token(DataTable dataTable) throws JsonProcessingException {
		List<Map<String, String>> credentials = dataTable.asMaps();
		String Admin__username = credentials.get(0).get("A_Email");
		String Admin__password = credentials.get(0).get("A_Password");
		String Admin_role = credentials.get(0).get("Role");
		A_token = tok.Token(Admin_role, Admin__username, Admin__password);
		System.out.println(A_token);
		patient_mod.tokengen(A_token);
	}
	@Given("Set no auth")
	public void setNoAuth() {
	    
	    A_token = "";  
	    System.out.println("No authentication token set.");
	    patient_mod.tokengen(A_token);
	}
	

	@Given("^(.+) create Get request$")
	public void create_Get_request(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}
	
	@When("^(.+) send Get http request with endpoint$")
	public void send_Get_http_request_with_endpoint(String key) throws IOException {

		System.out.println("Request Sending With " + key + " Token");
		Resp = patient_mod.Get_All_morbidities_sendrequest();

	}

	@Then("^(.+) recieves (.+) ok with details of the patient id$")
	public void patient_recieves_ok_with_details_of_the_patient_id(String S, int int1) {
		System.out.println("Access Rights for " + S + " ok with details of the patient id");
		Assert.assertEquals(Resp.statusCode(), int1);
	}

//	@Then("^(.+) recieves (.+) 405 method not allowed$")
//	public void patient_recieves_405_method_not_allowed(String S, int int1) {
//		System.out.println("Access Rights for " + S + " 405 method not allowed");
//		//Assert.assertEquals(Resp.statusCode(), int1);
//	}

	@Then("^(.+) recieves (.+) 404  not found$")
	public void patient_recieves_404_not_found(String S, int int1) {
		System.out.println("Access Rights for " + S + " 404  not found");
		Assert.assertEquals(Resp.statusCode(), int1);

	}

	@Given("Admin create GET request")
	public void admin_create_get_request() {
		patient_mod.setup_GetAllPatients();
	}

	

	

	@When("Admin send POST http request with endpoint")
	public void admin_send_post_http_request_with_endpoint() {
		patient_mod.setup_GetAllPatients();
	}

	@When("Dietician send POST http request with endpoint")
	public void dietician_send_post_http_request_with_endpoint() {
		Resp = patient_mod.Get_All_morbidities_InvalidMethod();
	}

	@When("Dietician send POST http request with invalid endpoint")
	public void dietician_send_post_http_request_with_invalid_endpoint() throws IOException {
		Resp = patient_mod.Get_All_morbidities_Invalid_Endpoint();
	}
	@Given("patient create get request") 
			public void patient_create_get_request() {
		patient_mod.setup_GetAllPatients();
	}

	@When("Patient send GET http request with endpoint")
	public void patient_send_get_http_request_with_endpoint() throws IOException {
		Resp= patient_mod.Get_All_morbidities_sendrequest();
	}
	@Then("^(.+) recieves (.+) Forbidden$")
	public void patient_recieves_forbidden(String S, int int1) {
		System.out.println("Access Rights for " + S + " is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);

	}
	@Given(" Dietician create GET request")
	public void dietician_create_get_request() {
	    
	}

//	@When(" Dietician send GET http request with endpoint")
//	public void dietician_send_get_http_request_with_endpoint() {
//	    
//	}

	@Then(" Dietician recieves {int} unauthorized")
	public void dietician_recieves_unauthorized(Integer int1) {
		System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 401);
	}

}