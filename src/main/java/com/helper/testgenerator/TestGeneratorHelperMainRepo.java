package com.helper.testgenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.helper.testgenerator.*"
}, excludeFilters = {
        @ComponentScan.Filter(type=FilterType.REGEX, pattern="com.demo.automationtestdevelopertargetrepo.*")
})
public class TestGeneratorHelperMainRepo {

    public static void main(String[] args) {
        SpringApplication.run(TestGeneratorHelperMainRepo.class);
    }
}
