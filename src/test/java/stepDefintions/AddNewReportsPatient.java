package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PatientInfo;

public class AddNewReportsPatient {
	
	PatientInfo patientinfo=new PatientInfo();
	Patient_Modules patient_mod =Patient_Modules.getInstance() ;
	Response Resp;
	
	@Given("^Dietician creates (.+) request to add new reports$")
	public void Dietician_creates_request_to_add_new_reports(String key) {
		System.out.println("Sending http request with "+key+" Endpoint");
		patient_mod.setup_AddNewReports();
	    
	}
	@When("^Dietician send http request to add new reports with endpoints (.+)$")
	public void dietician_send_http_patient_updation_request_with_endpoints_pateint_update_valid(String key) throws IOException {
	    
		Resp=patient_mod.AddNewReports(key);
	}

	@Then("^Dietician recieves (.+) with response body for adding new reports$")
	public void dietician_recieves_with_response_body_after_patient_updation(String status) {
		System.out.println("Status_code:" +Resp.statusCode());
		int statuscode=Integer.parseInt(status);
		Assert.assertEquals(Resp.statusCode(), statuscode);
	    
	}

	
	

    

}



