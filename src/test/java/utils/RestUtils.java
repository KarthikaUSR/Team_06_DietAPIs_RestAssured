package utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;


import aPI_Modules.Patient_Modules;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.UserLoginPojo;

public class RestUtils {
	
	
	public static RequestSpecification reqSpec;
	public static ResponseSpecification response;
	
	
	/*public String Token(String role,String username,String password) throws JsonProcessingException
	{   
		//userloginpojo userobj = new userloginpojo();
		
		String token="";
		
		if(role.equalsIgnoreCase("Admin"))
		{
		    String UserName=propertyFile.getProperty("adminUserName");
		    String Password=propertyFile.getProperty("adminPassword");
		    token=bearerTokenFetcher.fetchBearerToken(UserName,Password);
		    //userobj.setAdminBearerToken(Token);
			
		}
		else if(role.equalsIgnoreCase("Dietician"))
		{
			token=bearerTokenFetcher.fetchBearerToken(username,password);
			//userobj.setDieticianBearerToken(Token);
			//System.out.println("D_token:" + userobj.getDieticianBearerToken());
		}
		else if(role.equalsIgnoreCase("Patient"))
		{
			token=bearerTokenFetcher.fetchBearerToken(username,password);
			//userobj.setPatientBearerToken(Token);
		}
		else
		{
			System.out.println("Enter valid role");
		}
		
		return token;
	
 	
	}*/
	 public RequestSpecification requestSpecification() throws IOException {

		   RestAssured. reset();
	       reqSpec = new RequestSpecBuilder().setBaseUri(EndPoints.BASEURL)
	               .setContentType(ContentType.JSON)
	               .build();
	       return reqSpec;
	}
	  
	   public ResponseSpecification responseSpecification() {
	   response = new ResponseSpecBuilder().build();
	   return response;
	 }
	   
	 
	
	/*public void Dieticianlogin()
	{
		
		Response response = given().header("Content-Type", "application/json")
				 
				.header("Authorization", "Bearer " + url.adminBearerToken)
				.body("{\n" + " \"userLoginEmail\": " +username+",\n" + " \"password\":"+ password + "\n}")
					 
				.when().post(Dieticianlogin_endpoint);
				 
				Assert.assertEquals(response.statusCode(), 200);			
				 
				//Assert.assertEquals(response.body().jsonPath().getString("message"), "Data retrieved successfully");
				 
				response.prettyPrint();
				Dieticiantoken=response.body().jsonPath().getString("token");
				System.out.println("D_Token:"+Dieticiantoken);
		
	
	}*/
	
 
  

	     

	/*public Response AdminLogin()
	{
		map.put("userLoginEmail", propertyFile.getProperty("adminUserName"));
		map.put("password", propertyFile.getProperty("adminPassword"));
		RestAssured.baseURI=url.BaseURL;
		RestAssured.basePath=url.LoginEndpoint;	    		                              
	    RestAssured.reset();
		Response httpresponse = RestAssured.given()
	    		   .contentType(propertyFile.getProperty("content.type"))
                   .body(map)
		           .when()
		           .post();
		   //String role=httpresponse.getBody().jsonPath().getString("roles");
		   //String Email=httpresponse.getBody().jsonPath().getString("loginUserEmail");
		String Token=httpresponse.getBody().jsonPath().getString("roles");
	       return	httpresponse;                              
								
	
	}*/
	   

}
