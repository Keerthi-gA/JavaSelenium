package com.automation.framework.hooks;

import com.automation.framework.utilities.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import com.automation.framework.reports.ExtentManager;
import com.automation.framework.reports.ExtentTestManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {

    DriverFactory.initializeDriver();

    ExtentTest extentTest =
            ExtentManager
                    .getExtentReport()
                    .createTest(
                            scenario.getName());

    ExtentTestManager
            .setTest(extentTest);
}

    @After
public void tearDown(Scenario scenario) {

    try {

        if (scenario.isFailed()) {

            String path =
                    ScreenshotUtil.captureScreenshot();

            ExtentTestManager.getTest()
                    .fail("Scenario Failed")
                    .addScreenCaptureFromPath(path);
        } else {

            ExtentTestManager.getTest()
                    .pass("Scenario Passed");
        }

    } catch (Exception e) {

        e.printStackTrace();
    }

    DriverFactory.quitDriver();

    ExtentManager.getExtentReport()
            .flush();
}
}