package com.example.demo.AdminPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class BasePage {

    @Autowired
    public  DriverConfig driverConfig;
    @Autowired
    public WebDriver driver;

    @PostConstruct
    public void initLoginPage(){
        PageFactory.initElements(driver, this);
    }


    @FindBy(how = How.NAME, using = "username")
    private WebElement username;

    @FindBy(how = How.NAME, using = "password")
    private WebElement password;

    @FindBy(how = How.XPATH, using = "//button[.='Login']")
    private WebElement loginButton;

}
