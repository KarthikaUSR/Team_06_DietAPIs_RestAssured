package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import aPI_Modules.User_Modules;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.BearerTokenFetcher;

public class userModulelogout {
	
BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	String A_token;
	String P_token;
	User_Modules user_mod=User_Modules.getInstance() ;
	Response Resp;
	
	
	@Given("Set bearer token in header")
	public void set_bearer_token_in_header(DataTable dataTable) throws JsonProcessingException, com.fasterxml.jackson.core.JsonProcessingException {
		List<Map<String,String>> credentials=dataTable.asMaps();
		String Admin_username=credentials.get(0).get("Email");
		String Admin_password=credentials.get(0).get("Password");
		String Admin_role=credentials.get(0).get("Role");
		String Diet_username=credentials.get(1).get("Email");
		String Diet_password=credentials.get(1).get("Password");
		String Diet_role=credentials.get(1).get("Role");
		String Patient_username=credentials.get(2).get("Email");
		String Patient_password=credentials.get(2).get("Password");
		String Patient_role=credentials.get(2).get("Role");
		A_token=tok.Token(Admin_role,Admin_username, Admin_password);
		D_token=tok.Token(Diet_role,Diet_username, Diet_password);
		P_token=tok.Token(Patient_role,Patient_username, Patient_password);
		user_mod.Admin_token(A_token);
		user_mod.Diet_token(D_token);
		user_mod.Patient_token(P_token);
		//patient_mod.token=D_token;
	
	}
	
	@Given("^(.+) Setup the valid logout endpoint$")
	public void admin_setup_the_valid_logout_endpoint(String S) {
		
		user_mod.setup_Logout(S);
	 
	 
	}
	@Given("^(.+)  Setup the invalid logout endpoint$")
	public void admin_setup_the_invalid_logout_endpoint(String S) {
		
		user_mod.setup_Logout(S);
		
	 
	}
	@When("^(.+) send request by entering valid data$")
	public void admin_send_request_by_entering_valid_data(String S) throws IOException {
	  user_mod.logout_sendrequest(S);
	}
	@When("^(.+) send request by entering invalid data$")
	public void admin_send_request_by_entering_invalid_data(String S) throws IOException {
		user_mod.logoutinvalid_sendrequest(S);
	}
	@Then("^(.+) recieves (.+) for valid$")
	public void admin_recieves_for_valid(String S,int int1) {
		System.out.println("Access Rights for " +S+" is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);
	
	}
	@Then("^(.+) recieves (.+) Forbidden for invalid$")
	public void admin_recieves_forbidden_for_invalid(String S,int int1) {
	 
		System.out.println("Access Rights for " +S+" is Forbidden");
		Assert.assertEquals(Resp.statusCode(), int1);
	}
	

}