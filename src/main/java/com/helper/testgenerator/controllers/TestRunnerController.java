package com.helper.testgenerator.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/main/v1/")
public class TestRunnerController {

    @GetMapping("/")
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<>(
                "{\"status\": \"OK\"}",
                HttpStatus.OK
        );
    }

}
