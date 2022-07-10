package com.helper.testgenerator.template;

import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class CucumberTestRunnerTemplate {

    private final String template = "package parallel.runners;\n" +
            "\n" +
            "import com.demo.automationtestdevelopertargetrepo.components.ScenarioContext;\n" +
            "import io.cucumber.junit.Cucumber;\n" +
            "import io.cucumber.junit.CucumberOptions;\n" +
            "import org.junit.runner.RunWith;\n" +
            "import org.springframework.beans.factory.annotation.Autowired;\n" +
            "\n" +
            "@RunWith(Cucumber.class)\n" +
            "@CucumberOptions(\n" +
            "        features = {\"${FULL_FEATURE_FILE_PATH}\"},\n" +
            "        glue = {\"steps\", \"configurations\"},\n" +
            "        monochrome = true\n" +
            ")\n" +
            "public class TempTestRunnerIT {\n" +
            "\n" +
            "    @Autowired\n" +
            "    protected ScenarioContext scenarioContext;\n" +
            "}";

    public String generateTestRunnerFileCode(@NonNull String featureFilePath) {
        return template.replace("${FULL_FEATURE_FILE_PATH}", featureFilePath);
    }
}
