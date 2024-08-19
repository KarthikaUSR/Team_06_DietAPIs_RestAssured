package stepDefintions;

import Utils.EndPoints;
import Utils.RestUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class UserLogin extends RestUtils {

    Response response;


    @Given("user creates post request with request body")
    public void user_creates_post_request_with_request_body() throws IOException {
//        fetchBearerToken();
        /**
         String userEmail = getGlobalValue("userEmail");
         String password = getGlobalValue("password");
         /*
         String requestBody = "{\n" +
         "  \"password\": \"" + password + "\",\n" +
         "  \"userLoginEmail\": \""+ userEmail +"\"\n" +
         "}";


         UserLogin_Pojo userLoginPojo = UserLogin_Pojo.builder()
         .userLoginEmail(userEmail)
         .password(password)
         .build();

         //convert the POJO to JSON, Jackson Bind
         Gson gson = new Gson();
         String requestBody = gson.toJson(userLoginPojo);

         reqSpec = given()
         .spec(requestSpecification())
         .body(requestBody)
         .log().all();
         //        addBasicAuth(getGlobalValue("userEmail"),getGlobalValue("password"));
         resSpec = responseSpecification();
         */
    }
    @When("user send {string} http request with endpoint")
    public void user_send_http_request_with_endpoint(String reqType) {
        response = reqSpec.when()
                .post(EndPoints.USERLOGIN)
                .then()
                .log().all()
                .spec(resSpec)
                .extract().response();
//        String adminToken = response.jsonPath().getString("token");
        // Deserialize response to UserLoginResponse_Pojo
        // UserLoginResponse_Pojo userLoginResponse = response.as(UserLoginResponse_Pojo.class);

    }
    @Then("user receives statuscode {int} created with response body")
    public void user_receives_statuscode_created_with_response_body(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.getStatusCode());
    }
}
