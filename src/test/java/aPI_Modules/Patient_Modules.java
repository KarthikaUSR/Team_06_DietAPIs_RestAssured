package aPI_Modules;

import java.io.IOException;
import org.junit.Assert;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.PatientInfo;
import pojo.UserLoginPojo;
import utils.EndPoints;

public class Patient_Modules {

	public static RequestSpecification reqSpec;
	public static Response response;
	PatientInfo patientinfo = new PatientInfo();
	UserLoginPojo userobj = new UserLoginPojo();
	private static Patient_Modules patient_Modules = null;

	// Response response;
	private Patient_Modules() {

	}

	public static synchronized Patient_Modules getInstance() {
		if (patient_Modules == null)
			patient_Modules = new Patient_Modules();

		return patient_Modules;
	}

	public void tokengen(String tok) {
		userobj.setBearerToken(tok);

	}

	public RequestSpecification setup_GetAllPatients() {
		String Bearertoken = userobj.getBearerToken();

		reqSpec = RestAssured.given().baseUri(EndPoints.BASEURL).contentType(ContentType.JSON).header("Authorization",
				"Bearer " + Bearertoken);

		return reqSpec;

	}

	// send Delete by ID request:

	public Response deletepatient_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.DELETE_PATIENT_BY_ID).when().delete();
		response.prettyPrint();
		// Validation of Delete by ID response
		Assert.assertEquals(response.statusCode(), 200);
		return response;

	}

	public Response deletepatient_InvalidMethod_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.DELETE_PATIENT_BY_ID).when().post();
		response.prettyPrint();
		// Validation of response
		Assert.assertEquals(response.statusCode(), 405);
		return response;

	}

	public Response deletepatient_InvalidEndPoint_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.DELETE_PATIENT_INVALIDENDPOINT_BY_ID).when().delete();
		response.prettyPrint();
		// Validation of response
		Assert.assertEquals(response.statusCode(), 404);
		return response;

	}

	public Response deletepatient_InvalidId_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.DELETE_PATIENT_BY_INVALID_ID).when().delete();
		response.prettyPrint();
		// Validation of response
		Assert.assertEquals(response.statusCode(), 404);
		return response;

	}

	// send Get by ID request:
	public Response getPatient_ById_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_BY_FILEID).when().get();
		response.prettyPrint();
		// Validation of Delete by ID response
		Assert.assertEquals(response.statusCode(), 200);
		return response;

	}

	public Response getpatient_ByID_InvalidMethod_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_BY_FILEID).when().post();
		response.prettyPrint();
		// Validation of response
		Assert.assertEquals(response.statusCode(), 405);
		return response;

	}

	public Response getpatient_ById_InvalidId_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_BY_INVALID_FILEID).when().get();
		response.prettyPrint();
		// Validation of response
		Assert.assertEquals(response.statusCode(), 404);
		return response;

	}

	public Response getpatient_ById_InvalidEndPoint_sendrequest() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_BY_INVALIDENDPOINT_BY_FILEID).when().get();
		response.prettyPrint();
		// Validation of response
		Assert.assertEquals(response.statusCode(), 404);
		return response;

	}
//Get Patients Morbidity Details
	public Response Get_Patients_Morbidity_Details() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS).when().get();
		response.prettyPrint();
		// Validation of Delete by ID response
		Assert.assertEquals(response.statusCode(), 200);
		return response;

	}
	
	public Response Get_Patients_Morbidity_Details_InvalidMethod() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS).when().post();
		response.prettyPrint();
		// Validation of Delete by ID response
		Assert.assertEquals(response.statusCode(), 405);
		return response;

	}
	public Response Get_Patients_Morbidity_Details_InvalidPatirntId() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS_INVALIDPATIENTID).when().post();
		response.prettyPrint();
		// Validation of Delete by ID response
		Assert.assertEquals(response.statusCode(), 404);
		return response;

	}
	public Response Get_Patients_Morbidity_Details_InvalidEndpoint() throws IOException {

		response = setup_GetAllPatients().basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS_INVALIDENDPOINT).when().post();
		response.prettyPrint();
		// Validation of Delete by ID response
		Assert.assertEquals(response.statusCode(), 404);
		return response;

	}
	

}
