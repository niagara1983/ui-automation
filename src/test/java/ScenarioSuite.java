import courgette.api.CourgetteOptions;
import courgette.api.CourgetteRunLevel;
import courgette.api.junit.Courgette;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        threads = 2,
        runLevel = CourgetteRunLevel.SCENARIO,
//        rerunFailedScenarios = true,
        showTestOutput = true,
        cucumberOptions = @CucumberOptions(
                features = "src/cucumber/resources/features",
                glue = "src/cucumber/resources/steps",
                tags = {"@regression"},
                plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html"},
                strict = true
        ))
public class ScenarioSuite {
}