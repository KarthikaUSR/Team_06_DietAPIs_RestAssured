package stepDefintions;

import java.io.IOException;

import org.junit.Assert;

import aPI_Modules.Patient_Modules;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import utils.BearerTokenFetcher;

public class Get_Patients_Morbidity_Details {
	
BearerTokenFetcher tok=new BearerTokenFetcher();
	
	String D_token;
	Patient_Modules patient_mod=Patient_Modules.getInstance() ;
	Response Resp;
		
		@Given("Dietician create GET request for patient ID")
		public void dietician_create_get_request_for_patient_id() throws IOException {
			 patient_mod.setup_GetAllPatients();
		    
		}
		@When("The Dietician send GET http request with given endpoint")
			public void The_Dietician_send_GET_http_request_with_given_endpoint() throws IOException{
			Resp = patient_mod.Get_Patients_Morbidity_Details();
		}
		

		@Then("Dietician should receives {int} ok with details of the patient id")
		public void dietician_should_receives_ok_with_details_of_the_patient_id(Integer int1) {
			System.out.println(Resp.statusCode());
			Assert.assertEquals(Resp.statusCode(), 200);
		}
		@Given("Dietician create POST request")
		public void dietician_create_post_request() {
			patient_mod.setup_GetAllPatients();
		    
		}

		@When("Dietician send POST http request with given endpoint")
		public void dietician_send_post_http_request_with_given_endpoint() throws IOException {
			Resp = patient_mod.Get_Patients_Morbidity_Details_InvalidMethod();
		}
//		@Then("Dietician should receives 405 method not allowed")
//		public void Dietician_should_receives_405_method_not_allowed(Integer int1) {
//			System.out.println(Resp.statusCode());
//			Assert.assertEquals(Resp.statusCode(), 405);
//		}
		@When("Dietician send GET http request with Invalid patient ID")
		public void dietician_send_get_http_request_with_invalid_patient_id() throws IOException {
			Resp = patient_mod.Get_Patients_Morbidity_Details_InvalidPatirntId();
		}
		
		@When("Dietician send GET http request with invalid endpoint")
		public void dietician_send_get_http_request_with_invalid_endpoint() throws IOException {
			Resp = patient_mod.Get_Patients_Morbidity_Details_InvalidEndpoint();
		}

}

