package com.szkolqa.boilerplate.driver.listeners;

import com.szkolqa.boilerplate.driver.ScreenshotManager;
import org.openqa.selenium.WebDriver;
import org.spockframework.runtime.AbstractRunListener;
import org.spockframework.runtime.model.ErrorInfo;

public class ScreenshotOnFailureListener extends AbstractRunListener {
    //TODO: take care about proper set
    public WebDriver driver;

    public void error(ErrorInfo error) {
        ScreenshotManager screenshot = new ScreenshotManager(driver);
        String className = error.getMethod().getParent().getFilename();
        String methodName = error.getMethod().getName();

        if (className != null && methodName != null && driver != null) {
            screenshot.takeScreenshot(className, methodName);
        }
    }
}
