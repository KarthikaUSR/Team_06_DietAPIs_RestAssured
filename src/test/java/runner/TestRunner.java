package runner;


	import org.junit.runner.RunWith;

	import io.cucumber.junit.Cucumber;
	import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(features="src/test/resources/Feature_Files/userModuleLogin.feature",glue= {"stepDefinitions"})
	public class TestRunner {

	}

	