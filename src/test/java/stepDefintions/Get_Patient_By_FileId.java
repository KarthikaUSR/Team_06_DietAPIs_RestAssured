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
	@Given("Set Dietician token")
	public void Set_Dietician_token(DataTable dataTable) throws JsonProcessingException {
		List<Map<String, String>> credentials = dataTable.asMaps();
		String Diet_username = credentials.get(0).get("D_Email");
		String Diet_password = credentials.get(0).get("D_Password");
		String Diet_role = credentials.get(0).get("Role");
		D_token = tok.Token(Diet_role, Diet_username, Diet_password);
		System.out.println(D_token);
		patient_mod.tokengen(D_token);

	}
	@Given("Dietician create Get request")
	public void dietician_create_get_request() throws IOException {

		patient_mod.setup_GetAllPatients();

	}
	@When("Dietician send GET http request with given endpoint")
	public void Dietician_send_GET_http_request_with_given_endpoint() throws IOException {

		Resp = patient_mod.getPatient_ById_sendrequest();

	}
	@Then("The dietitian receives a response body with a status code of 200")
	public void The_dietitian_receives_a_response_body_with_a_status_code_of_200() throws IOException {
		System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 200);

	}
	
	
	@When("Dietician send Get http request with invalid method")
	public void Dietician_send_Get_http_request_with_invalid_method() throws IOException {

		Resp = patient_mod.getpatient_ByID_InvalidMethod_sendrequest();

	}
	@Then("The Dietician receives a response body 405 method not allowed")
	public void The_Dietician_receives_a_response_body_405_method_not_allowed() throws IOException {
		System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 405);

}
	@When("Dietician send Get http request with invalid fileid")
	public void Dietician_send_Get_http_request_with_invalid_fileid() throws IOException {

		Resp = patient_mod.getpatient_ById_InvalidId_sendrequest();

	}

	@Then("The Dietician receives a response body 404 not found")
	public void The_Dietician_receives_a_response_body_404_not_found() throws IOException {
		System.out.println(Resp.statusCode());
		Assert.assertEquals(Resp.statusCode(), 404);

	}
	@When("Dietician send get http request with invalid endpoint")
	public void dietician_send_get_http_request_with_invalid_endpoint() throws IOException {
		Resp = patient_mod.getpatient_ById_InvalidEndPoint_sendrequest();

	}
	@Given("^(.+) create Get requests$")
	public void create_Get_requests(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}

	@When("^(.+) send Get http requests with endpoint$")
	public void send_get_http_request_with_endpoint(String key) throws IOException {

		System.out.println("Request Sending With " + key + " Token");
		Resp = patient_mod.getPatient_ById_sendrequest();

	}

//	@Then("^(.+) recieves (.+) Forbidden$")
//	public void patient_recieves_forbidden(String S, int int1) {
//		System.out.println("Access Rights for " + S + " is Forbidden");
//		Assert.assertEquals(Resp.statusCode(), int1);
//
//	}

}
