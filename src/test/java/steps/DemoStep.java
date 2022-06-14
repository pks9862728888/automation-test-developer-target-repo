package steps;

import io.cucumber.java.en.Given;

public class DemoStep extends BaseTestRunner {

    @Given("^Admin user logins with valid credentials$")
    public void adminUserLoginWithValidCredentials() {
        System.out.println("Login works");
    }
}
