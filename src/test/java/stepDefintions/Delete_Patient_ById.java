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

public class Delete_Patient_ById {
BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;

//	@Given("Set Dietician token")
//	public void Set_Dietician_token(DataTable dataTable) throws JsonProcessingException {
//		List<Map<String, String>> credentials = dataTable.asMaps();
//		String Diet_username = credentials.get(0).get("D_Email");
//		String Diet_password = credentials.get(0).get("D_Password");
//		String Diet_role = credentials.get(0).get("Role");
//		D_token = tok.Token(Diet_role, Diet_username, Diet_password);
//		System.out.println(D_token);
//		patient_mod.tokengen(D_token);
//
//	}

	@Given("Dietician create DELETE request")
	public void dietician_create_delete_request() throws IOException {

		patient_mod.setup_GetAllPatients();

	}

	@When("Dietician send DELETE http request with endpoint")
	public void dietician_send_delete_http_request_with_endpoint() throws IOException {

		Resp = patient_mod.deletepatient_sendrequest();

	}

	@Then("Dietician recieves 200 with response body")
	public void dietician_recieves_200_with_response_body() throws IOException {
		System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 200);

	}

	@When("Dietician send DELETE http request with invalid method")
	public void Dietician_send_DELETE_http_request_with_invalid_method() throws IOException {

		Resp = patient_mod.deletepatient_InvalidMethod_sendrequest();

	}

	@Then("Dietician should receives 405 method not allowed")
	public void dietician_should_receives_method_not_allowed() throws IOException {
		//System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 405);

	}

	@When("Dietician send DELETE http request with Invalid Id")
	public void Dietician_send_DELETE_http_request_with_Invalid_Id() throws IOException {

		Resp = patient_mod.deletepatient_InvalidId_sendrequest();

	}

	@Then("Dietician should receives 404 not found")
	public void dietician_should_receives_not_found() throws IOException {
		System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 404);

	}

	@When("Dietician send DELETE http request with invalid endpoint")
	public void dietician_send_delete_http_request_with_invalid_endpoint() throws IOException {
		Resp = patient_mod.deletepatient_InvalidEndPoint_sendrequest();

	}

	@Given("^(.+) Set Token with (.+) (.+)$")
	public void set_token_with_Email_Password(String S, String S1, String S2) throws JsonProcessingException {

		D_token = tok.Token(S, S1, S2);
		patient_mod.tokengen(D_token);

	}

	@Given("^(.+) create Delete requests$")
	public void patient_create_delete_request(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}

	@When("^(.+) send Delete http requests with endpoint$")
	public void patient_send_delete_http_request_with_endpoint(String key) throws IOException {

		System.out.println("Request Sending With " + key + " Token");
		Resp = patient_mod.deletepatient_sendrequest();

	}

//	@Then("^(.+) recieves (.+) Forbidden$")
//	public void patient_recieves_forbidden(String S, int int1) {
//		System.out.println("Access Rights for " + S + " is Forbidden");
//		Assert.assertEquals(Resp.statusCode(), int1);
//
//	}

}
