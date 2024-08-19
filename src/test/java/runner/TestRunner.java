package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/magizh/Documents/Numpy_Hackathons/Team_06_DietAPIs_RestAssured/src/test/resources/Feature_Files/UpdateDietician.feature", glue = {"stepDefintions"},
//        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json", "junit:target/cucumber.xml"}
plugin = {"pretty", "html:target/cucumber.html","json:target/cucumber.json"}
)
public class TestRunner {

}
