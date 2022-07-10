package com.demo.automationtestdevelopertargetrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type=FilterType.REGEX, pattern="helper.testgenerator.*")
})
public class DemoApplication   {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
