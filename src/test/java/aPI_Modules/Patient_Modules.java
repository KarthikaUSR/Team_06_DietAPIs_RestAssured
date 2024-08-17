package aPI_Modules;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.EndPoints;
import utils.RestUtils;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;

import org.junit.Assert;

public class Patient_Modules {
	
	public Response getallpatient_get(String D_token) throws IOException
	{
		
		Response response = RestAssured.given().baseUri(EndPoints.BASEURL)
				.basePath(EndPoints.GET_ALL_PATIENTS)
				.contentType(ContentType.JSON)
				.header("Authorization", "Bearer " + D_token)
				.when()
				.get();
		//response.prettyPrint();
		//Assert.assertEquals(response.statusCode(), 200);
		return response;
			
	
	}
	/*public static void main(String[] args) throws IOException
    { 
		

		Patient_Modules obj=new Patient_Modules();
		//System.out.println("Diet"+obj.tokens.getDieticianBearerToken());
		obj.getallpatient_get();
    }*/

}
