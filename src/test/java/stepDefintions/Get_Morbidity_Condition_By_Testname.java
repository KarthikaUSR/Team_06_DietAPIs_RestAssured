package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import utils.BearerTokenFetcher;

public class Get_Morbidity_Condition_By_Testname {
	BearerTokenFetcher tok = new BearerTokenFetcher();

	String A_token;
	Patient_Modules patient_mod = Patient_Modules.getInstance();
	Response Resp;
//	@Given("Set Admin Token")
//	public void Set_Admin_Token(DataTable dataTable) throws JsonProcessingException {
//		List<Map<String, String>> credentials = dataTable.asMaps();
//		String Admin__username = credentials.get(0).get("A_Email");
//		String Admin__password = credentials.get(0).get("A_Password");
//		String Admin_role = credentials.get(0).get("Role");
//		A_token = tok.Token(Admin_role, Admin__username, Admin__password);
//		System.out.println(A_token);
//		patient_mod.tokengen(A_token);
//	}
	@Given("^(.+) create Get request y$")
	public void create_Get_request(String S) {

		System.out.println("Login Role:" + S);

		patient_mod.setup_GetAllPatients();

	}

//	@When("^(.+) send Get http request with endpoint $")
//	public void send_Get_http_request_with_endpoint(String key) throws IOException{
//
//		System.out.println("Request Sending With " + key + " Token");
//		Resp = patient_mod.Get_Morbidity_Condition_By_Testname();
//		Resp = patient_mod.Get_Morbidity_Condition_By_Testname_InvalidMethod();
//		Resp = patient_mod.Get_Morbidity_Condition_By_Testname_Invalid_Endpoint();
//		Resp=patient_mod.Get_Morbidity_Condition_By_Testname_Invalid_Morbidity_ConditionName();
//		
//	}
	@Then("^(.+) recieves (.+) ok with details$")
	public void patient_recieves_ok_with_details(String S, int int1) {
		System.out.println("Access Rights for " + S + " ok with details");
		Assert.assertEquals(Resp.statusCode(), int1);
	}

	@Then("^(.+) recieves (.+) 405 method not allowed$")
	public void patient_recieves_405_method_not_allowed(String S, int int1) {
		System.out.println("Access Rights for " + S + " 405 method not allowed");
		Assert.assertEquals(Resp.statusCode(), int1);
	}

//	@Then("^(.+) recieves (.+) 404  not found$")
//	public void patient_recieves_404_not_found(String S, int int1) {
//		System.out.println("Access Rights for " + S + " 404  not found");
//		//Assert.assertEquals(Resp.statusCode(), int1);
//
//	}
//	@Then("^(.+) recieves (.+) Forbidden$")
//	public void patient_recieves_forbidden(String S, int int1) {
//		System.out.println("Access Rights for " + S + " is Forbidden");
//		Assert.assertEquals(Resp.statusCode(), int1);
//
//	}
	@Given("Patient create GET request")
	public void patient_create_get_request() {
		patient_mod.setup_GetAllPatients();
	}

//	@When("Patient send GET http request with endpoint")
//	public void patient_send_get_http_request_with_endpoint() throws IOException {
//		Resp= patient_mod.Get_Morbidity_Condition_By_Testname();
//	}

	@Then("^(.+) recieves (.+) 401 unauthorized$")
	public void recieves_401_unauthorized(String S, int int1) {
		System.out.println("Access Rights for " + S + " 401 unauthorized");
		Assert.assertEquals(Resp.statusCode(), int1);
	}

	

}
