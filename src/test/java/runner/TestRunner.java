package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import java.time.Duration;

@CucumberOptions(features = "src/test/features",
        glue = "org.example.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
        dryRun = false,
        monochrome = true,
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();

    }

}


