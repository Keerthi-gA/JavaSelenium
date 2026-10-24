package com.automation.framework.stepdefinitions;

//import static org.junit.jupiter.api.Assertions.assertTrue;
import com.automation.framework.pages.LoginPage;
import com.automation.framework.reports.ExtentTestManager;
import com.automation.framework.utilities.ConfigReader;
import com.automation.framework.utilities.DriverFactory;

import io.cucumber.java.en.*;

public class LoginSteps {

    LoginPage loginPage;


    @Given("User launches application")
public void launchApplication() {

    ExtentTestManager.getTest()
            .info("Launching application");

    DriverFactory.getDriver()
            .get(ConfigReader.getProperty("baseUrl"));

    loginPage =
            new LoginPage(DriverFactory.getDriver());
}

    @When("User enters username {string}")
    public void enterUsername(String username) {

        ExtentTestManager.getTest()
            .info("Entering username : " + username);
            loginPage.enterUsername(username);
    }

    @And("User enters password {string}")
    public void enterPassword(String password) {
        ExtentTestManager.getTest()
            .info("Entering password");
        loginPage.enterPassword(password);
    }

    @And("User clicks login button")
    public void clickLoginButton() {   
        ExtentTestManager.getTest()
            .info("Clicking Login Button");
        loginPage.clickLogin();
    }

    @Then("User should be navigated to products page")
public void verifyLoginSuccess() {

    ExtentTestManager.getTest()
            .info("Verifying successful login");

    String currentUrl =
            DriverFactory.getDriver().getCurrentUrl();

    if (!currentUrl.contains("inventory")) {

        throw new AssertionError(
                "Login Failed");
        }
    }
}