package aPI_Modules;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.PatientInfo;
import pojo.UserLoginPojo;
import utils.EndPoints;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;
import org.junit.Assert;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;



public class Patient_Modules {
	
	public static RequestSpecification reqSpec;
	public static ResponseSpecification response;
	PatientInfo patientinfo=new PatientInfo();
	UserLoginPojo userobj =new UserLoginPojo() ;
	private static Patient_Modules patient_Modules = null;
	private Patient_Modules()
    {
        
    }
	public static synchronized Patient_Modules getInstance()
    {
        if (patient_Modules == null)
        	patient_Modules = new Patient_Modules();
 
        return patient_Modules;
    }
	
	public void tokengen(String tok)
	{
	 userobj.setBearerToken(tok);

	}

	public RequestSpecification setup_GetAllPatients() {
		String Bearertoken=userobj.getBearerToken();

		reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
				   .contentType(ContentType.JSON)
				   .header("Authorization", "Bearer " + Bearertoken);
				   
		return 	reqSpec;
		   
	}
	//get all patients
	public Response GetAllPatients_sendrequest(String Key) throws IOException
	{
		Response response=null;
	    if(Key.equalsIgnoreCase("Valid"))
	      {
		       response =setup_GetAllPatients()
				         .basePath(EndPoints.GET_ALL_PATIENTS)
				         .when()
				         .get();		
	      }
	        
	    else if(Key.equalsIgnoreCase("InvalidMethod"))
	      {
	    	response =setup_GetAllPatients()
					.basePath(EndPoints.GET_ALL_PATIENTS)
					.when()
					.put();
			
	      }
	    else if(Key.equalsIgnoreCase("InvalidEndpoint"))
	      {
	    	response =setup_GetAllPatients()
					.basePath(EndPoints.INVALID)
					.when()
					.get();		
	      }
	    else if(Key.equalsIgnoreCase("Admin")||Key.equalsIgnoreCase("Patient"))
	      {
	    	response =setup_GetAllPatients()
			         .basePath(EndPoints.GET_ALL_PATIENTS)
			         .when()
			         .get();	
			
	      }
	    else
	    {
	    	System.out.println("Invalid Key");
	    }
			
	response.prettyPrint();
	
	return response;
	}
	
	
	public Response getpatientmorbidity_sendrequest(String D_token) throws IOException
	{
	
		Response response =setup_GetAllPatients()
				.basePath(EndPoints.PATIENTSMORBIDITYDETAILS+patientinfo.getPatientID())
				
				.when()
				.get();
		response.prettyPrint();
	
		return response;
			
	
	}
		
	
	public RequestSpecification setup_PatientCreation() {
		
		String Bearertoken=userobj.getBearerToken();
		//String Bearertoken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBUElQSDJfMUBnbWFpbC5jb20iLCJpYXQiOjE3MjQxMDY3MTEsImV4cCI6MTcyNDEzNTUxMX0.PxNeHz9dXUKmRztOC_gzoKt8wbTevQLaAyUZtrf0C-WIXAovaBVqvqVAf6FG31K035a-iNS1415a7Y552H4SHw";
		
		reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
				   .contentType(ContentType.MULTIPART)
				   .header("Authorization", "Bearer " + Bearertoken);
				   
		return 	reqSpec;
		   
	}
	public RequestSpecification setup_PatientCreation_invalidcontenttype() {

		String Bearertoken=userobj.getBearerToken();

		reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
				    
				   .header("Authorization", "Bearer " + Bearertoken);
				   
		return 	reqSpec;
		   
	}
	
//patient creation
	
	public Response PatientCreation(String Key)throws IOException
	{	
		Response response=null;
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData/HyperThyroid_Report_final.pdf");
		
        File json1 = new File(System.getProperty("user.dir") + "/src/test/resources/testData/PatientCreationData_CHECK.json");

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> userData = mapper.readValue(  
					json1, new TypeReference<Map<String, Object>>() {  
            });
	
		JSONObject jsonObj = new JSONObject(userData); 
		String jsonbody=jsonObj.get(Key).toString();
		if(Key.equalsIgnoreCase("PateintCreationValidDataInvalidMethod"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.get();			
		     response.prettyPrint();
		}
		else if(Key.equalsIgnoreCase("PateintCreationValidDataInvalidEndpoints"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.INVALID)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.post();			
		     response.prettyPrint();
		}
		else if(Key.equalsIgnoreCase("PateintCreationInValidContentType"))
		{
			 response =setup_PatientCreation_invalidcontenttype()
					.basePath(EndPoints.PATIENTCREATION)
					.contentType(ContentType.JSON)
					//.multiPart("file", file,"application/pdf")
					//.contentType(ContentType.HTML).body(jsonbody)
					//.body(file)
					.body(jsonbody)
					//.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.post();			
		     response.prettyPrint();
		}
		else if(Key.equalsIgnoreCase("PateintCreationValid")||Key.equalsIgnoreCase("PateintCreationValidMandatory"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")
					
					.when()
					.post();			
		     response.prettyPrint();
		}
		
		else if(Key.equalsIgnoreCase("Admin"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")				
					.when()
					.post();			
		     response.prettyPrint();
		}
		else if(Key.equalsIgnoreCase("Patient"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
	
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")
					
					.when()
					.post();			
		     response.prettyPrint();
		}
		else {
			System.out.println("Invalid Entry");
			
		}
		return response;
		
	}
	
	
	
	

}


