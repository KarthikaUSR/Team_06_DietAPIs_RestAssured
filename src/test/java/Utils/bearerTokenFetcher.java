package Utils;
import org.json.JSONObject;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import EndPoints.URL;
import Payloads.userloginpojo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class bearerTokenFetcher {
	
	public static String fetchBearerToken(String username,String password) throws JsonProcessingException  {
		 userloginpojo userobj = new userloginpojo();
		 userobj.setUserLoginEmail(username);
		 userobj.setPassword(password);
		 ObjectMapper objectMapper = new ObjectMapper();
		 String jsonbody = objectMapper.writeValueAsString(userobj);
		//System.out.println(jsonbody);	
		 Response response = RestAssured.given().baseUri(URL.BaseURL)
	    		    .basePath(URL.LoginEndpoint)
	    		    .contentType(ContentType.JSON)
	        		.body(jsonbody)
	                .when()
	                .post()
	                .then().log().all()
	        .extract().response();
	    Assert.assertEquals(200, response.statusCode());
	    String token=response.body().jsonPath().getString("token");
	    System.out.println("BearerToken : "+token);
	    //userobj.setAdminBearerToken(token);
	    return token;
	    }

}
