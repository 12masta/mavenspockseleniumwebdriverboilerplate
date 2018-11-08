package com.szkolqa.boilerplate.driver.listeners;

import org.spockframework.runtime.extension.IGlobalExtension;
import org.spockframework.runtime.model.SpecInfo;

public class ScreenshotOnFailureExtension implements IGlobalExtension {
    @Override
    public void start() {
    }

    @Override
    public void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new ScreenshotOnFailureListener());
    }

    @Override
    public void stop() {
    }
}
