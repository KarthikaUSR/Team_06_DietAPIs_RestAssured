package stepDefinitions;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequest;
import pojo.LoginResponse;
import utils.EndPoints;

import static io.restassured.RestAssured.given;

public class userLoginwithoutfeaturefile {
	
		public static void main(String[] args) {
		
		
		
		 RequestSpecification req= new RequestSpecBuilder().setBaseUri("https://dietician-july-api-hackathon-80f2590665cc.herokuapp.com/dietician")
				                   .setContentType(ContentType.JSON)
				                   .build();
		 
		
		LoginRequest loginrequest  = new LoginRequest();
		loginrequest.setPassword("test");
		loginrequest.setUserLoginEmail("Team6.admin@gmail.com");
		
	RequestSpecification reqLogin	= given().log().all()
		                             .spec(req).body(loginrequest);
	LoginResponse loginResponse = reqLogin.when().post(EndPoints.USERLOGIN).then().log().all().extract().response().as(LoginResponse.class);
	System.out.println(loginResponse.getToken());
		
		

}
}