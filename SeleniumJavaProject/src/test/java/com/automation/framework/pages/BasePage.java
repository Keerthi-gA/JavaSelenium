package com.automation.framework.pages;

import org.openqa.selenium.WebDriver;

import com.automation.framework.utilities.WaitUtils;

public class BasePage {

    protected WebDriver driver;
    protected WaitUtils waitUtils;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        waitUtils = new WaitUtils(driver);
    }
}