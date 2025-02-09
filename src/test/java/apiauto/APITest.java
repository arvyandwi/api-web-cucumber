package apiauto;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"apiauto"},
        features = {"src/test/resources/api"},
        plugin = {"pretty","html:reports/test-report-cucumber-api.html","json:reports/test-report-cucumber-api.json"}
)
public class APITest {
}
