package support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/features"}, tags = {"@aboutYou"}, glue = {"stepDefinitions","support"})

public class TestRunner {
}
