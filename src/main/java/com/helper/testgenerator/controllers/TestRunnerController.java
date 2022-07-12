package com.helper.testgenerator.controllers;

import com.demo.automationtestdevelopertargetrepo.enums.fields.TradeEventEnum;
import com.helper.testgenerator.dao.TestRunnerTemplateDAO;
import com.helper.testgenerator.enums.EnumClassNameRegister;
import com.helper.testgenerator.exceptions.EnumNotFoundException;
import com.helper.testgenerator.template.CucumberTestRunnerTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/main")
@Slf4j
public class TestRunnerController extends GenericErrorController {

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
        log.debug("Requested test runner template...");
        return new ResponseEntity<>(
                TestRunnerTemplateDAO.builder()
                        .data(cucumberTestRunnerTemplate.generateTestRunnerFileCode(featureFilePath))
                        .relativeFilePath("src/test/resources/parallel/runners/TempTestRunnerIT.java")
                        .build(),
                HttpStatus.OK
        );
    }

    @GetMapping("/getEnumValues")
    public ResponseEntity<Map<String, List<String>>> getEnumValues() throws EnumNotFoundException {
        log.debug("Requested all trade enum values...");
        Map<String, List<String>> map = new HashMap<>();
        for (EnumClassNameRegister register : EnumClassNameRegister.values()) {
            List<String> enumFields = new ArrayList<>();
            for (Field field : register.getEnumClazz().getDeclaredFields()) {
                // Only add the enum fields
                if (field.getType().getSimpleName().equals(register.getEnumClazz().getSimpleName())) {
                    enumFields.add(field.getName());
                }
            }
            map.put(register.getEnumClazz().getSimpleName(), enumFields);
        }

        return new ResponseEntity<>(
                map,
                HttpStatus.OK
        );
    }

    @GetMapping("/getTradeEvents")
    public ResponseEntity<Map<String, List<String>>> getTradeEventsGroupedBySourceSystem() {
        log.debug("Requested all trade events...");
        Map<String, List<String>> map = new HashMap<>();
        for (TradeEventEnum eventEnum : TradeEventEnum.values()) {
            eventEnum.getSourceSystems()
                    .forEach(ss -> {
                        if (map.containsKey(ss.name())) {
                            map.get(ss.name()).add(eventEnum.name());
                        } else {
                            ArrayList<String> list = new ArrayList<>();
                            list.add(eventEnum.name());
                            map.put(ss.name(), list);
                        }
                    });
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
