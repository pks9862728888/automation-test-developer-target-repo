package steps;

import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;

import java.nio.file.Paths;

@Slf4j
public class InputDataInitializer extends BaseTestRunner {

    @Given("^Test meta-data folder=(.*) and test-resources folder=(.*) where baseFolder=/src/test/resources/$")
    public void loadInputFromMetaDataFile(String testMetaDir, String testResourcesDir) {
        log.debug("Initializing test folder location...");
        scenarioContext.setTestMetaDataFilePath(Paths.get("src/test/resources", testMetaDir));
        scenarioContext.setTestResourcesFilePath(Paths.get("src/test/resources", testResourcesDir));
    }
}
