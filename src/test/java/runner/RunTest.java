package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features/GetIncidents.feature",

					glue = {"stepDefinitions","hooks"},
					monochrome = true)
	

public class RunTest extends AbstractTestNGCucumberTests {

}
