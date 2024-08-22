package stepDefintions;

import Utils.BearerTokenFetcher;
import Utils.EndPoints;
import Utils.JsonUtils;
import Utils.RestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;


import static Utils.JsonUtils.getJsonDataForKey;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.junit.Assert.assertEquals;

public class CreateDietician extends RestUtils {
/*
    public String dietId;
//    JSONObject requestBody;
    JSONObject jsonbody;
    Response Resp;
    Response response;
    //SET 1
    @Given("set admin bearer token in request header")
    public void set_admin_bearer_token_in_request_header() throws IOException {
        BearerTokenFetcher.fetchBearerToken(getGlobalValue("adminEmail"), getGlobalValue("password"));
        requestSpecification();  // Ensure reqSpec is initialized
        reqSpec.header("Authorization", "Bearer " + getGlobalValue("adminToken"));


    }
    @Given("admin creates {string} request")
    public void admin_creates_request(String Key) throws IOException, ParseException {
////        responseSpecification(201);
//         requestBody = JsonUtils.getJsonDataForKey(Key);
//        System.out.println(requestBody);
////        reqSpec.body(requestBody.toJSONString());
//        setup_dietCreation();
        Resp = dietCreation(Key);

    }
    @When("admin send post http request with endpoint")
    public void admin_send_post_http_request_with_endpoint() throws IOException, ParseException {
//        if (reqSpec == null) {
//            throw new IllegalStateException("Request Specification is not initialized. Ensure that the requestSpecification() method is called before making the request.");
//        }
//
//        response  = reqSpec.when().post("/dietician")
//                .then().log().all().extract().response();

//        Resp = dietCreation(Key);

        response = when()
                .post()
                .then().log().all().extract().response();
//        dietId = response.body().jsonPath().getString("id");
//        System.out.println("DieticianID : " + dietId);
//        setDietId(dietId);

    }

    @Then("admin recieves {int} created")
    public void admin_recieves_created(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
//        dietId = response.body().jsonPath().getString("id");
//        System.out.println("DieticianID : " + dietId);
////        RestUtils util = new RestUtils();
////        util.setDietId(dietId);
        setDietId(dietId);
//        responseSpecification(int1);
//        response.then().spec(resSpec);
    }

//SET 2
//@Given("admin creates {string} request")
//public void admin_creates_request(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//    @When("admin send post http request with endpoint")
//    public void admin_send_post_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("admin recieves {int} created")
//    public void admin_recieves_created(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


//SET 3
//@Given("admin creates {string} request")
//public void admin_creates_request(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//    @When("admin send post http request with endpoint")
//    public void admin_send_post_http_request_with_endpoint() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("admin recieves {int} created")
//    public void admin_recieves_created(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
*/

}
