package com.example.demo;

import com.example.demo.AdminPages.DriverConfig;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    public DriverConfig driverConfig;

    @Autowired
    public WebDriver driver;

    @Value("${url}")
    private String url;

    @Test
    void contextLoads() throws InterruptedException {

        driverConfig.getChromeDriver();
        Thread.sleep(5000);
        driver.get(url);

    }

}
