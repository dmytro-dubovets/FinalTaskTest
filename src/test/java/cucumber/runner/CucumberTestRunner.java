package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty", "html:target/HTMLReports/index.html"},
        monochrome = true,
        tags = "@finalTask",
        glue = "cucumber",
        features = "src/test/resources/features"
        )

public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}
