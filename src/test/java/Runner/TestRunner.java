package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.Test;

@Test
@RunWith(Cucumber.class)

@CucumberOptions(features = { "features" }, glue = {"StepDefinition"},plugin = { "html:target/cucumber-html-report","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html","pretty:target/cucumber-pretty.txt"})

public class TestRunner {





}
