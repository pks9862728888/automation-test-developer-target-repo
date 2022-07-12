package com.helper.testgenerator.controllers;

import com.demo.automationtestdevelopertargetrepo.enums.fields.TradeEventEnum;
import com.demo.automationtestdevelopertargetrepo.models.testdatainputmodels.TradeEvent;
import com.helper.testgenerator.dao.TestRunnerTemplateDAO;
import com.helper.testgenerator.enums.EnumClassNameRegister;
import com.helper.testgenerator.exceptions.EnumNotFoundException;
import com.helper.testgenerator.template.CucumberTestRunnerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;

@RestController
@RequestMapping("/api/v1/main")
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
        return new ResponseEntity<>(
                TestRunnerTemplateDAO.builder()
                        .data(cucumberTestRunnerTemplate.generateTestRunnerFileCode(featureFilePath))
                        .relativeFilePath("src/test/resources/parallel/runners/TempTestRunnerIT.java")
                        .build(),
                HttpStatus.OK
        );
    }

    @GetMapping("/getEnumValues")
    public ResponseEntity<Map<String, Set<String>>> getEnumValues() throws EnumNotFoundException {
        Map<String, Set<String>> map = new HashMap<>();
        for (EnumClassNameRegister register: EnumClassNameRegister.values()) {
            Set<String> enumFields = new HashSet<>();
            for (Field field: register.getEnumClazz().getDeclaredFields()) {
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
    public ResponseEntity<Map<String, Set<String>>> getTradeEventsGroupedBySourceSystem() {
        Map<String, Set<String>> map = new HashMap<>();
        for (TradeEventEnum eventEnum: TradeEventEnum.values()) {
            eventEnum.getSourceSystems()
                    .forEach(ss -> {
                        if (map.containsKey(ss.name())) {
                            map.get(ss.name()).add(eventEnum.name());
                        } else {
                            HashSet<String> hs = new HashSet<>();
                            hs.add(eventEnum.name());
                            map.put(ss.name(), hs);
                        }
                    });
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
