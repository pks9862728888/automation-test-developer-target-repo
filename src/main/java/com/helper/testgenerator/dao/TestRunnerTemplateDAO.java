package com.helper.testgenerator.dao;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TestRunnerTemplateDAO implements Serializable {

    private String data;
    private String relativeFilePath;

}
