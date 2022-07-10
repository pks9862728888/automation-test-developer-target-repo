package steps;

import com.demo.automationtestdevelopertargetrepo.components.ScenarioContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"features"},
        glue = {"steps", "configurations"},
        monochrome = true
)
public class BaseTestRunner {

    @Autowired
    protected ScenarioContext scenarioContext;
}
