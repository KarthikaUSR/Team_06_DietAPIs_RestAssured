package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/magizh/Documents/Numpy_Hackathons/Team_06_DietAPIs_RestAssured/src/test/resources/Feature_Files/GetAllDieticians.feature", glue = {"stepDefinitions"})
public class TestRunner {

}
