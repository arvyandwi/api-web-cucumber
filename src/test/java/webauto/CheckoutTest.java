package webauto;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"webauto"},
        features = {"src/test/resources/web/checkout.feature"},
        plugin = {"pretty","html:reports/test-report-cucumber-web.html","json:reports/test-report-cucumber-web.json"}
)
public class CheckoutTest {
}
