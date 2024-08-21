package utils;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;



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
	   
		 public RequestSpecification InvalidContentTyperequestSpecification() throws IOException {

			   RestAssured. reset();
		       reqSpec = new RequestSpecBuilder().setBaseUri(EndPoints.BASEURL)
		               .setContentType(ContentType.TEXT)
		               .build();
		       return reqSpec;
		}
		 
		 
		 public static void setTokenInHeaderRequestSpec() throws IOException {

		        if (reqSpec == null) {
		            reqSpec = new RequestSpecBuilder()
		                    .setBaseUri(getGlobalValue("baseURL"))
		                    .setContentType(ContentType.JSON)
		                    .addHeader("Authorization", "Bearer " + getGlobalValue("adminToken"))
		                    .build();
		        }
		    }

		  public static String getGlobalValue(String key) throws IOException {
		        Properties prop = new Properties();
		        FileInputStream fis = new FileInputStream("/Users/rupesh_k2438/eclipse-workspace/RestAssured_Framework/target/config.properties");
		        prop.load(fis);
		        return prop.getProperty(key);

		    }
		  public void addHeader(String key,String value){
		        reqSpec= given().header(key,value);

		    }

}
