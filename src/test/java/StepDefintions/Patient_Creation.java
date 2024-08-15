package StepDefintions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Patient_Creation {

    @Given("Dietician creates POST request by entering valid data into the form-data key and value fields.")
    public void dietician_creates_post_request_by_entering_valid_data_into_the_form_data_key_and_value_fields() {
        System.out.println("post creation");
    }
    @When("Dietician send POST http request with endpoint")
    public void dietician_send_post_http_request_with_endpoint() {
        System.out.println("post creation");
    }
    @Then("Dietician recieves {int} unauthorized")
    public void dietician_recieves_unauthorized(Integer int1) {
        System.out.println("post creation");
    }

}
