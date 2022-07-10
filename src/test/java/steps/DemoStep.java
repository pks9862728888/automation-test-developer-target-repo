package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DemoStep extends BaseTestRunner {

    @Given("^Inputs are loaded from meta-data file$")
    public void loadInputFromMetaDataFile() {
        log.debug("Inputs are loaded from meta-data file");
    }

    @And("^Trade is set to be published to (.*)$")
    public void setDestination(String destination) {
        log.debug("Trade is set to be published to: " + destination);
    }

    @When("^Trade inputs are processed / published$")
    public void publishInputs() {
        log.debug("Trade inputs are processed / published");
    }

    @Then("^Verify whether trade is reportable to jurisdiction (.*)$")
    public void checkReportability(String jurisdiction) {
        log.debug("Verify whether trade is reportable to jurisdiction: " + jurisdiction);
    }
}
