package com.szkolqa.boilerplate.driver.listeners.screenshot;

import org.openqa.selenium.WebDriver;
import org.spockframework.runtime.AbstractRunListener;
import org.spockframework.runtime.IRunListener;
import org.spockframework.runtime.model.ErrorInfo;

public class ScreenshotOnFailureListener extends AbstractRunListener implements IRunListener {
    private WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void error(ErrorInfo error) {
        ScreenshotManager screenshot = new ScreenshotManager(driver);
        String className = error.getMethod().getParent().getFilename();
        String methodName = error.getMethod().getName();

        if (className != null && methodName != null && driver != null) {
            screenshot.takeScreenshot(className, methodName);
        }
    }
}
