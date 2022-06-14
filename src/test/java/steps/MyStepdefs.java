package steps;

import Runners.Runner;
import com.example.demo.AdminPages.DriverConfig;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class MyStepdefs extends Runner {

    @Autowired
    public  DriverConfig driverConfig;

    @Autowired
    public WebDriver driver;

    @Value("${url}")
    private String url;
    @Given("^Admin user logins with valid crendentials$")
    public void adminUserLoginWithValidCredentials() throws InterruptedException {
        driverConfig.getChromeDriver();
        Thread.sleep(5000);
        driver.get(url);


    }
}
