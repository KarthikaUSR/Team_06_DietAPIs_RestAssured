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
		
		com.requestSpecification();

	}

	@When("Dietician send GET http request with endpoint")
	public void dietician_send_get_http_request_with_endpoint() throws IOException {
		
		Resp=patient_mod.getallpatient_get(D_token);
	}

	@Then("Dietician recieves {int} ok with response body")
	public void dietician_recieves_ok_with_response_body(Object int1) {
		
		
		Assert.assertEquals(Resp.statusCode(), int1);
	  
	}



	
	
}
