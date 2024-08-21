package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features={
"/Users/rupesh_k2438/eclipse-workspace/RestAssured_Framework/src/test/java/features/UserModuleLogoutNegativeScenarios.feature"},

glue= {"stepDefinitions"},
plugin = {"pretty"}
)

public class TestRunner {
     
    
    }