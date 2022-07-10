package com.helper.testgenerator.controllers;

import com.helper.testgenerator.dao.TestRunnerTemplateDAO;
import com.helper.testgenerator.template.CucumberTestRunnerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main/v1/")
public class TestRunnerController {

    @Autowired
    public CucumberTestRunnerTemplate cucumberTestRunnerTemplate;

    @GetMapping("/")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>(
                "{\"status\": \"OK\"}",
                HttpStatus.OK
        );
    }

    @GetMapping("/getTestRunnerTemplate")
    public ResponseEntity<TestRunnerTemplateDAO> getTemplateCode(@RequestParam("feature-file-path") String featureFilePath) {
        return new ResponseEntity<>(
                TestRunnerTemplateDAO.builder()
                        .data(cucumberTestRunnerTemplate.generateTestRunnerFileCode(featureFilePath))
                        .relativeFilePath("src/test/resources/parallel/runners/TempTestRunnerIT.java")
                        .build(),
                HttpStatus.OK
        );
    }

}
