package cucmber.Options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber"},
        features={"src/test/java/restFramework/features"},
        glue = {"restFramework.stepDefinitions"},
        monochrome = true,
//        tags = {""},
        dryRun = false)
public class TestRunnerRestA {

}
