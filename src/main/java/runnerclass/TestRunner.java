package runnerclass;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions
(
	features = {"src/test/resources/accounts.feature"}
	,glue = {"stepdefinitions"}
	,tags = {"@pgma"}
)
public class TestRunner
{
	
}
