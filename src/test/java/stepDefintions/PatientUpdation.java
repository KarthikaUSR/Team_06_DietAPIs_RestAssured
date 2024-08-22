package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.PatientInfo;

public class PatientUpdation {
	
	PatientInfo patientinfo=new PatientInfo();
	Patient_Modules patient_mod =Patient_Modules.getInstance() ;
	Response Resp;

@Given("^Dietician creates (.+) request to update patient details$")
public void dietician_creates_pateint_update_valid_request_to_update_patient_details(String key) {
	System.out.println("Sending http request with "+key+" Endpoint");
	patient_mod.setup_PatientUpdate();
    
}

@When("^Dietician send http patient updation request with endpoints (.+)$")
public void dietician_send_http_patient_updation_request_with_endpoints_pateint_update_valid(String key) throws IOException {
    
	Resp=patient_mod.PatientUpdation(key);
}

@Then("^Dietician recieves (.+) with response body after patient updation$")
public void dietician_recieves_with_response_body_after_patient_updation(String status) {
	System.out.println("Status_code:" +Resp.statusCode());
	int statuscode=Integer.parseInt(status);
	Assert.assertEquals(Resp.statusCode(), statuscode);
    
}

@Then("Validate the response body after the patient updation")
public void validate_the_response_body_after_the_patient_updation() {
	int Statuscode=Resp.statusCode();
	if(Statuscode==200)
	{
	String Email=Resp.body().jsonPath().getString("Email");
	//String FileID=Resp.body().jsonPath().getMap("FileMorbidity").keySet().toString();
	//patientinfo.setPatientFileID(FileID);
	patientinfo.setEmail(Email);
	//patientinfo.setPatientID(PatientID);
	}
	
	
    
}





}