package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Feature_Files/GetAllPatientInfo.feature"},

glue= {"stepDefintions"},
plugin = {"pretty"}
)

public class TestRunner {
     
    
    }




