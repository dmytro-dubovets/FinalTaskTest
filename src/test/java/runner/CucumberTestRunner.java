package runner;

import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        plugin = {"pretty","html:target/HTMLReports"},
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"StepsTest"})

public class CucumberTestRunner {
}
