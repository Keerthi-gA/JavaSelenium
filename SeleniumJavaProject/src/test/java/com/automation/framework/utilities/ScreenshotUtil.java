package com.automation.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automation.framework.utilities.DriverFactory;

public class ScreenshotUtil {

    public static String captureScreenshot() {

        File source =
                ((TakesScreenshot)
                        DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.FILE);

        String path =
                "screenshots/" +
                LocalDateTime.now()
                        .toString()
                        .replace(":", "-")
                        + ".png";

        try {

            Files.copy(source.toPath(),
                       new File(path).toPath(),
                       StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e) {

            e.printStackTrace();
        }

        return path;
    }
}