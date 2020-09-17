package runner;

import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
        plugin = {"pretty","html:target/HTMLReports"},
        monochrome = true,
        features = "src/test/resources/features",
        glue = {"Steps"})

public class CucumberTestRunner {
}
