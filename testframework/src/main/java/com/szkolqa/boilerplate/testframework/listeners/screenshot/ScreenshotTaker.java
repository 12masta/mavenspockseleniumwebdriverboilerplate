package com.szkolqa.boilerplate.testframework.listeners.screenshot;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.LocalTime;

public class ScreenshotTaker {

    private static Logger logger = LoggerFactory.getLogger(ScreenshotTaker.class);
    private LocalTime timestamp = LocalTime.now();
    private WebDriver driver;

    public ScreenshotTaker(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenshot(String className, String method) {
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotTakingDriver = (TakesScreenshot) this.driver;
            try {
                File localScreenshots = new File(new File("target"), "screenshots");
                if (!localScreenshots.exists() || !localScreenshots.isDirectory()) {
                    localScreenshots.mkdirs();
                }
                File screenshot = new File(localScreenshots, className + "_" + method + "_" + timestamp.toString() + ".png");
                screenshot(screenshotTakingDriver);
                FileUtils.moveFile(screenshotTakingDriver.getScreenshotAs(OutputType.FILE), screenshot);
                logger.info("Screenshot for class={} method={} saved in: {}", className, method, screenshot.getAbsolutePath());
            } catch (Exception e1) {
                logger.error("Unable to take screenshot", e1);
            }
        } else {
            logger.info("Driver '{}' can't take screenshots so skipping it.", driver.getClass());
        }
    }

    @Attachment
    @Step("Make screen shot of results page")
    private byte[] screenshot(TakesScreenshot screenshotTakingDriver) {
        return screenshotTakingDriver.getScreenshotAs(OutputType.BYTES);
    }
}
