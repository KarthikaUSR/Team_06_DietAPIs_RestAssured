package stepDefintions;

import Utils.EndPoints;
import Utils.JsonUtils;
import Utils.RestUtils;
import Utils.Util1;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SetNoAuth extends Util1 {

    Response response;
    //CREATE
    @Given("admin creates post request with valid data")
    public void admin_creates_post_request_with_valid_data() throws IOException {
        requestSpecification().body("{\n" +
                "  \"ContactNumber\": \"1120001136\",\n" +
                "  \"DateOfBirth\": \"2015-07-26T18:14:08.570Z\",\n" +
                "  \"Education\": \"MA\",\n" +
                "  \"Email\": \"last@email.com\",\n" +
                "  \"Firstname\": \"lastDiet\",\n" +
                "  \"HospitalCity\": \"last\",\n" +
                "  \"HospitalName\": \"kplast\",\n" +
                "  \"HospitalPincode\": \"123456\",\n" +
                "  \"HospitalStreet\": \"paseo\",\n" +
                "  \"Lastname\": \"booni\"\n" +
                "}");
    }
    @Then("admin recieves {int} unauthorized")
    public void admin_recieves_unauthorized(Integer int1) {
        assertEquals(int1.intValue(), response.getStatusCode());
    }



    //PUT
    @Given("admin create put request with valid data")
    public void admin_create_put_request_with_valid_data() throws IOException {
//        requestBody = JsonUtils.getJsonDataForKey(Key);
//        System.out.println(requestBody);
//        reqSpec.body(requestBody.toJSONString());
        requestSpecification().body("{\n" +
                "  \"ContactNumber\": \"1120001135\",\n" +
                "  \"DateOfBirth\": \"2010-07-26T18:14:08.570Z\",\n" +
                "  \"Education\": \"MA\",\n" +
                "  \"Email\": \"last@email.com\",\n" +
                "  \"Firstname\": \"lastDiet\",\n" +
                "  \"HospitalCity\": \"last\",\n" +
                "  \"HospitalName\": \"kplast\",\n" +
                "  \"HospitalPincode\": \"123456\",\n" +
                "  \"HospitalStreet\": \"paseo\",\n" +
                "  \"Lastname\": \"booni\"\n" +
                "}");
    }
    @When("admin send put http request with endpoint")
    public void admin_send_put_http_request_with_endpoint() {
        response = reqSpec.when()
                .put(EndPoints.UPDATE_DIETICIAN_BY_ID)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
//    @Then("admin recieves {int} unauthorized")
//    public void admin_recieves_unauthorized(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    //DELETE
    @Given("admin create delete reqeust")
    public void admin_create_delete_reqeust() throws IOException {
        requestSpecification();
    }
    @When("admin send delete reqeust with endpoint")
    public void admin_send_delete_reqeust_with_endpoint() {
        response = reqSpec.when()
                .delete(EndPoints.DELETE_DIETICIAN_BY_ID)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }
//    @Then("admin recieves {int} unauthorized")
//    public void admin_recieves_unauthorized(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


    //GET
    @When("admin send get http request with endpoint")
    public void admin_send_get_http_request_with_endpoint() throws IOException {
        requestSpecification();
    }

    @When("admin send get http request with endpont")
    public void admin_send_get_http_request_with_endpont() {
        // Write code here that turns the phrase above into concrete actions
        response = reqSpec.when()
                .get(EndPoints.GET_DIETICIAN_BY_ID)
                .then()
                .log().all()
//                .spec(resSpec)
                .extract().response();
    }

    }
