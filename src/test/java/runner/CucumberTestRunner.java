package runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = "pretty",
        features = "src/test/resources/features")


public class CucumberTestRunner {
}
