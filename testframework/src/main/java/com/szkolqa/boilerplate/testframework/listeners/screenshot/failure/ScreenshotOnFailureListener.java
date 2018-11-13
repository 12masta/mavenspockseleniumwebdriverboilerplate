package com.szkolqa.boilerplate.testframework.listeners.screenshot.failure;

import com.szkolqa.boilerplate.testframework.listeners.screenshot.ScreenshotTaker;
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
        ScreenshotTaker screenshot = new ScreenshotTaker(driver);
        String className = error.getMethod().getParent().getFilename();
        String methodName = error.getMethod().getName();

        if (className != null && methodName != null && driver != null) {
            screenshot.takeScreenshot(className, methodName);
        }
    }
}
