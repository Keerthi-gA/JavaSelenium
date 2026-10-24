package com.automation.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameLocator =
            By.id("user-name");

    private final By passwordLocator =
            By.id("password");

    private final By loginButton =
            By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {

        waitUtils.waitForElementVisible(usernameLocator)
             .sendKeys(username);
    }

    public void enterPassword(String password) {

        waitUtils.waitForElementVisible(passwordLocator)
             .sendKeys(password);
    }

    public void clickLogin() {

        waitUtils.waitForElementClickable(loginButton)
              .click();
    }
}
