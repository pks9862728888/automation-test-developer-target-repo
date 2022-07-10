package com.demo.automationtestdevelopertargetrepo.components;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.nio.file.Path;

@Component
@Setter
@Getter
public class ScenarioContext {

    Path testMetaDataFilePath;
    Path testResourcesFilePath;

    public void cleanUp() {
        this.testMetaDataFilePath = null;
        this.testResourcesFilePath = null;
    }
}
