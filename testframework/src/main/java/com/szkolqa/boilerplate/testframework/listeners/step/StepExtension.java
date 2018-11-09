package com.szkolqa.boilerplate.testframework.listeners.step;

import org.spockframework.runtime.extension.IGlobalExtension;
import org.spockframework.runtime.model.SpecInfo;

public class StepExtension implements IGlobalExtension {
    @Override
    public void start() {
    }

    @Override
    public void visitSpec(SpecInfo specInfo) {
        specInfo.addListener(new StepListener());
    }

    @Override
    public void stop() {
    }
}
