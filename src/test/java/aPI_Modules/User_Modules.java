package aPI_Modules;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import pojo.UserLoginPojo;
import utils.EndPoints;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.hamcrest.Matcher;
import org.json.JSONObject;
import org.junit.Assert;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class User_Modules {
	
	public static RequestSpecification reqSpec;
	public static ResponseSpecification response;

	UserLoginPojo userobj =new UserLoginPojo() ;
	private static User_Modules user_Modules = null;
	//Response response;
	private User_Modules()
    {
    }
	public static synchronized User_Modules getInstance()
    {
        if (user_Modules == null)
        	user_Modules = new User_Modules();
        return user_Modules;
    }
	
	
	public void Admin_token(String tok)
	{
	 userobj.setAdminBearerToken(tok);
	}
	
	public void Diet_token(String tok)
	{
	 userobj.setDietecianBearerToken(tok);
	}
	
	public void Patient_token(String tok)
	{
	 userobj.setPatientBearerToken(tok);
	}
	

	
	public RequestSpecification setup_Logout(String role) {
		  String Bearertoken="";
		
		  if(role.equalsIgnoreCase("Admin"))
		  {
			  Bearertoken=userobj.getAdminBearerToken();
				  }
		  else if(role.equalsIgnoreCase("Dietician"))
		  {
			  Bearertoken=userobj.getDietecianBearerToken();
				  }
		  if(role.equalsIgnoreCase("Patient"))
				  {
					  Bearertoken=userobj.getPatientBearerToken();
						  }
		  else
				  {
					  System.out.println("Invalid Role");
						  }
			
			reqSpec=RestAssured.given().baseUri(EndPoints.BASEURL)
					   .contentType(ContentType.JSON)
					   .header("Authorization", "Bearer " + Bearertoken);
					  
			return 	reqSpec;
			  
		}

	
	public Response logout_sendrequest(String role) throws IOException
	{
		Response response=null;
	    System.out.println("logging as:" +role);
		 response = setup_Logout(role)
				.basePath(EndPoints.USERLOGOUT)
				
				.when()
				.get();
		response.prettyPrint();
		return response;
			
	}
	public Response logoutinvalid_sendrequest(String role) throws IOException
	{
		Response response=null;
	    System.out.println("logging as:" +role);
	 response =setup_Logout(role)
				.basePath(EndPoints.USERLOGOUT)
				.when()
				.post();
		response.prettyPrint();
		return response;
			
	}

}
