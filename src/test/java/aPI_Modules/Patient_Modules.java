package aPI_Modules;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.PatientInfo;
import pojo.UserLoginPojo;
import utils.EndPoints;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
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
	//Response response;
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
//Getallpatient setup
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
	
	
	
		
	//Patient creation setup
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
		
		if(Key.equalsIgnoreCase("PateintCreationValidAdditional"))
		{
			
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.post();			
		     response.prettyPrint();
		}
		else if(Key.equalsIgnoreCase("PateintCreationInValidMandatory"))
		{
			  System.out.println("body:"+jsonbody);
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.post();			
		     response.prettyPrint();
		}
		else if(Key.equalsIgnoreCase("PateintCreationInValidAdditional"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.post();			
		     response.prettyPrint();
		}
		
		else if(Key.equalsIgnoreCase("PateintCreationValidDataInvalidMethod"))
		{
			 response =setup_PatientCreation()
					.basePath(EndPoints.PATIENTCREATION)
					.multiPart("file", file,"application/pdf")
					.multiPart("patientInfo", jsonbody,"application/json")		
					.when()
					.put();			
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
	
	
	//Patient updation setup
	public RequestSpecification setup_PatientUpdate() {
		
		String Bearertoken=userobj.getBearerToken();
		System.out.println("patientid: "+patientinfo.getPatientID());
		//String Bearertoken="eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBUElQSDJfMUBnbWFpbC5jb20iLCJpYXQiOjE3MjQxMDY3MTEsImV4cCI6MTcyNDEzNTUxMX0.PxNeHz9dXUKmRztOC_gzoKt8wbTevQLaAyUZtrf0C-WIXAovaBVqvqVAf6FG31K035a-iNS1415a7Y552H4SHw";

		reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
				   
				   .contentType(ContentType.MULTIPART)
				   .header("Authorization", "Bearer " + Bearertoken);
		
				   
		return 	reqSpec;
		   
	}
	public RequestSpecification setup_PatientUpdate_invalidcontenttype() {

		String Bearertoken=userobj.getBearerToken();

		reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
				 .basePath(EndPoints.PATIENTUPDATION)
				    
				   .header("Authorization", "Bearer " + Bearertoken);
				   
		return 	reqSpec;
		   
	}
	//patient Updation
	
		public Response PatientUpdation(String Key)throws IOException
		{	
			Response response=null;
			File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData/HyperThyroid_Report_final.pdf");
			
	        File json1 = new File(System.getProperty("user.dir") + "/src/test/resources/testData/PatientUpdateData_CHECK.json");

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> userData = mapper.readValue(  
						json1, new TypeReference<Map<String, Object>>() {  
	            });
		
			JSONObject jsonObj = new JSONObject(userData); 
			String jsonbody=jsonObj.get(Key).toString();
			
			if(Key.equalsIgnoreCase("PateintUpdateValidAdditional"))
			{
				
				 response =setup_PatientCreation()
						.basePath(EndPoints.PATIENTUPDATION)
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PateintUpdateInValidMandatory"))
			{
				  System.out.println("body:"+jsonbody);
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION)
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PateintUpdateInValidPatientID"))
			{
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION+"34556")
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PateintUpdateWithNoFile"))
			{
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION)
						//.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			
			else if(Key.equalsIgnoreCase("PateintUpdateValidDataInvalidMethod"))
			{
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION)
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.post();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PateintUpdateValidDataInvalidEndpoints"))
			{
				 response =setup_PatientCreation()
						.basePath(EndPoints.INVALID)
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PateintUpdationInValidContentType"))
			{
				 response =setup_PatientCreation_invalidcontenttype()
						 //.basePath(EndPoints.PATIENTUPDATION+patientinfo.getPatientID())
						.contentType(ContentType.JSON)
						//.multiPart("file", file,"application/pdf")
						//.contentType(ContentType.HTML).body(jsonbody)
						//.body(file)
						.body(jsonbody)
						//.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PateintUpdateValid")||Key.equalsIgnoreCase("PateintUpdateValidMandatory"))
			{System.out.println("PatientID="+patientinfo.getPatientID());
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION)
						
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")
						
						.when()
						.put();			
			     response.prettyPrint();
			}
			
			else if(Key.equalsIgnoreCase("Admin"))
			{
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION)
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")				
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("Patient"))
			{
				 response =setup_PatientCreation()
						 .basePath(EndPoints.PATIENTUPDATION)
		
						.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")
						
						.when()
						.put();			
			     response.prettyPrint();
			}
			else {
				System.out.println("Invalid Entry");
				
			}
			return response;
			
		}
		
//Add new reports setup
		public RequestSpecification setup_AddNewReports() {
			
			String Bearertoken=userobj.getBearerToken();
			

			reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
					.basePath(EndPoints.PATIENTADDNEWREPORTS)
					   .contentType(ContentType.MULTIPART)
					   .header("Authorization", "Bearer " + Bearertoken);
			
					   
			return 	reqSpec;
			   
		}
		public RequestSpecification setup_AddNewReports_invalidcontenttype() {

			String Bearertoken=userobj.getBearerToken();

			reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
					 .basePath(EndPoints.PATIENTADDNEWREPORTS)
					    
					   .header("Authorization", "Bearer " + Bearertoken);
					   
			return 	reqSpec;
			   
		}
	 
	
		//Add new reports 
		public Response AddNewReports(String Key)throws IOException
		{	
			Response response=null;
			File file = new File(System.getProperty("user.dir") + "/src/test/resources/testData/DiabeticandHemogramTest_Thyrocare_lab.pdf");
			File fileNew = new File(System.getProperty("user.dir") + "/src/test/resources/testData/HyperThyroid_Report_final.pdf");

	        File json1 = new File(System.getProperty("user.dir") + "/src/test/resources/testData/AddNewReports_CHECK.json");

			ObjectMapper mapper = new ObjectMapper();
			Map<String, Object> userData = mapper.readValue(  
						json1, new TypeReference<Map<String, Object>>() {  
	            });
		
			JSONObject jsonObj = new JSONObject(userData); 
			String jsonbody=jsonObj.get(Key).toString();
			String Vitals=jsonObj.get("Vitals").toString();
			
			if(Key.equalsIgnoreCase("WithVitalsforPatientWithValidData"))
			{
				
				 response =setup_AddNewReports()
						.basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")	
						.multiPart("Vitals", Vitals,"application/json")
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("WithoutVitalsforPatientWithValidData"))
			{
				 response =setup_AddNewReports()
							.basePath(EndPoints.PATIENTADDNEWREPORTS)
							.multiPart("file", fileNew,"application/pdf")
							.multiPart("patientInfo", jsonbody,"application/json")	
							
							.when()
							.put();			
				     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("AddOnlyNewVitalsWithoutReportsForPatientWithReport"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						//.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")
						.multiPart("Vitals", Vitals,"application/json")
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("AddOnlyNewVitalsWithoutReportsForPatientWithoutReport"))
			{//add new endpoint for patient id who dont have reports
				response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTSNOREPORTS)
						//.multiPart("file", file,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")
						.multiPart("Vitals", Vitals,"application/json")
						.when()
						.put();			
			     response.prettyPrint();
			}
			
			else if(Key.equalsIgnoreCase("PatientOnlyWithValidMandatoryDetails"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			
			else if(Key.equalsIgnoreCase("PatientOnlyWithValidAdditionalDetails"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			
			else if(Key.equalsIgnoreCase("PatientWithInvalidData"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PatientWithValidDataInvalidPatientId"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTSINVALIDPATIENTID)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PatientWithInvalidData"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PatientWithValidDataInvalidMethod"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.post();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PatientWithValidDataInvalidEndPoints"))
			{
				 response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS+EndPoints.INVALID)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			     response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("PatientWithValidDataInvalidContentType"))
			{
				 response =setup_AddNewReports_invalidcontenttype()
							.contentType(ContentType.JSON)
						 //.basePath(EndPoints.PATIENTADDNEWREPORTS)
						//.multiPart("file", fileNew,"application/pdf")
						//.multiPart("patientInfo", jsonbody,"application/json")
						.body(jsonbody)
						.when()
						.put();			
			     response.prettyPrint();
			}
			
			
			
			else if(Key.equalsIgnoreCase("Admin"))
			{
				response =setup_AddNewReports()
				 .basePath(EndPoints.PATIENTADDNEWREPORTS)
				.multiPart("file", fileNew,"application/pdf")
				.multiPart("patientInfo", jsonbody,"application/json")		
				.when()
				.put();			
	             response.prettyPrint();
			}
			else if(Key.equalsIgnoreCase("Patient"))
			{
				response =setup_AddNewReports()
						 .basePath(EndPoints.PATIENTADDNEWREPORTS)
						.multiPart("file", fileNew,"application/pdf")
						.multiPart("patientInfo", jsonbody,"application/json")		
						.when()
						.put();			
			             response.prettyPrint();
			}
			else {
				System.out.println("Invalid Entry");
				
			}
			return response;
			
		}
///NoAuth setup
		
 public RequestSpecification setup_Noauth() {
			
			reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL);
					   
			return 	reqSpec;
 }
///NoAuth setup
 
 
     public Response PatientEndPoints_NoAuth(String Key)throws IOException
     {
    	 Response response=null;
    	 
    	 if(Key.equalsIgnoreCase("CreatePatient"))
 		{
 			 response =setup_Noauth()
 					.basePath(EndPoints.PATIENTCREATION)		
 					.when()
 					.post();			
 		     response.prettyPrint();
 		}
 		else if(Key.equalsIgnoreCase("UpdatePatient"))
 		{
 			  
 			 response =setup_PatientCreation()
 					.basePath(EndPoints.PATIENTUPDATION)
 					.when()
 					.put();			
 		     response.prettyPrint();
 		}
 		else if(Key.equalsIgnoreCase("AddNewReports"))
 		{
 			  
 			 response =setup_PatientCreation()
 					.basePath(EndPoints.PATIENTADDNEWREPORTS)
 					.when()
 					.put();			
 		     response.prettyPrint();
 		}
 		else if(Key.equalsIgnoreCase("RetriveAllPatient"))
 		{
 			  
 			 response =setup_PatientCreation()
 					.basePath(EndPoints.GET_ALL_PATIENTS)
 					.when()
 					.get();			
 		     response.prettyPrint();
 		}
 		else if(Key.equalsIgnoreCase("RetrivePatientMorbidity"))
 		{
 			  
 			 response =setup_PatientCreation()
 					.basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS)
 					.when()
 					.get();			
 		     response.prettyPrint();
 		}
 		else if(Key.equalsIgnoreCase("RetrivePatientByFileId"))
 		{
 			  
 			 response =setup_PatientCreation()
 					.basePath(EndPoints.GET_PATIENT_BY_FILEID)
 					.when()
 					.get();			
 		     response.prettyPrint();
 		}
 		else if(Key.equalsIgnoreCase("DeletePatientByFileId"))
 		{
 			  
 			 response =setup_PatientCreation()
 					.basePath(EndPoints.DELETE_PATIENT_BY_ID)
 					.when()
 					.get();			
 		     response.prettyPrint();
 		}
 		else
 		{
 			System.out.println("Invalid EndPoints");
 		}
    	 
    	 
    	 return response;
    	 
     }
     /*
      * ****** bhavana code ?*/
     
     
     public Response deletepatient_sendrequest(String Key) throws IOException {
    	 Response response=null;
 	    if(Key.equalsIgnoreCase("Valid"))
 	      {
 		       response =setup_GetAllPatients()
 		    		  .basePath(EndPoints.DELETE_PATIENT_BY_ID)
 		    		  .when()
 		    		  .delete();
 				         		
 	      }
 	    else if(Key.equalsIgnoreCase("InvalidID"))
	      {
		       response =setup_GetAllPatients()
		    		   .basePath(EndPoints.DELETE_PATIENT_BY_INVALID_ID)
		    		   .when()
		    		   .delete();
				         		
	      }
 	        
 	    else if(Key.equalsIgnoreCase("InvalidMethod"))
 	      {
 	    	response =setup_GetAllPatients()
 	    			.basePath(EndPoints.DELETE_PATIENT_BY_ID)
 	    			.when()
 	    			.post();
 			
 	      }
 	    else if(Key.equalsIgnoreCase("InvalidEndpoint"))
 	      {
 	    	response =setup_GetAllPatients()
 	    			.basePath(EndPoints.DELETE_PATIENT_INVALIDENDPOINT_BY_ID)
 	    			.when()
 	    			.delete();	
 	      }
 	    else if(Key.equalsIgnoreCase("Admin")||Key.equalsIgnoreCase("Patient"))
 	      {
 	    	response =setup_GetAllPatients()
 			         .basePath(EndPoints.DELETE_PATIENT_BY_ID)
 			         .when()
 			         .delete();	
 			
 	      }
 	    else
 	    {
 	    	System.out.println("Invalid Key");
 	    }
 			
 	response.prettyPrint();
 	
 	return response;
 	

 	}
     public Response getpatientbyFileId_sendrequest(String Key) throws IOException {
    	 Response response=null;
 	    if(Key.equalsIgnoreCase("ValidFileID"))
 	      {
 		       response =setup_GetAllPatients()
 		    		  .basePath(EndPoints.GET_PATIENT_BY_FILEID)
 		    		  .when()
 		    		  .get();
 				         		
 	      }
 	    else if(Key.equalsIgnoreCase("InvalidFileID"))
	      {
		       response =setup_GetAllPatients()
		    		   .basePath(EndPoints.GET_PATIENT_BY_INVALID_FILEID)
		    		   .when()
		    		   .get();
	      }
 	        
 	    else if(Key.equalsIgnoreCase("InvalidMethod"))
 	      {
 	    	response =setup_GetAllPatients()
 	    			.basePath(EndPoints.GET_PATIENT_BY_FILEID)
 	    			.when()
 	    			.post();
 			
 	      }
 	    else if(Key.equalsIgnoreCase("InvalidEndpoint"))
 	      {
 	    	response =setup_GetAllPatients()
 	    			.basePath(EndPoints.GET_PATIENT_BY_INVALIDENDPOINT_BY_FILEID)
 	    			.when()
 	    			.get();
 	      }
 	    else if(Key.equalsIgnoreCase("Admin")||Key.equalsIgnoreCase("Patient"))
 	      {
 	    	response =setup_GetAllPatients()
 			         .basePath(EndPoints.GET_PATIENT_BY_FILEID)
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
     public Response getpatientmorbidity_sendrequest(String Key) throws IOException {
    	 Response response=null;
 	    if(Key.equalsIgnoreCase("ValidFileID"))
 	      {
 		       response =setup_GetAllPatients()
 		    		  .basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS)
 		    		  .when()
 		    		  .get();
 				         		
 	      }
 	    else if(Key.equalsIgnoreCase("InvalidFileID"))
	      {
		       response =setup_GetAllPatients()
		    		   .basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS_INVALIDFILEID)
		    		   .when()
		    		   .get();
	      }
 	        
 	    else if(Key.equalsIgnoreCase("InvalidMethod"))
 	      {
 	    	response =setup_GetAllPatients()
 	    			.basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS)
 	    			.when()
 	    			.post();
 			
 	      }
 	    else if(Key.equalsIgnoreCase("InvalidEndpoint"))
 	      {
 	    	response =setup_GetAllPatients()
 	    			.basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS_INVALIDENDPOINT)
 	    			.when()
 	    			.get();
 	      }
 	    else if(Key.equalsIgnoreCase("Admin")||Key.equalsIgnoreCase("Patient"))
 	      {
 	    	response =setup_GetAllPatients()
 			         .basePath(EndPoints.GET_PATIENT_MORBIDITY_DETAILS)
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
	
   
 
 
 
 
}


