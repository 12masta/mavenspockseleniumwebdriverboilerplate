package com.szkolqa.boilerplate.testframework.listeners.screenshot.failure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spockframework.runtime.IRunListener;
import spock.lang.Specification;

import java.util.Optional;

public class ScreenshotListenerFinder {
    private static Logger logger = LoggerFactory.getLogger(ScreenshotListenerFinder.class);

    public static ScreenshotOnFailureListener getListener(Specification specification) {
        Optional<IRunListener> optionalScreenshotListener = specification.getSpecificationContext()
                .getCurrentSpec()
                .getListeners()
                .stream()
                .filter(x -> x instanceof ScreenshotOnFailureListener)
                .findFirst();
        if(optionalScreenshotListener.isPresent()){
            return (ScreenshotOnFailureListener) optionalScreenshotListener.get();
        }
        logger.warn("ScreenshotOnFailureListener is not active");
        return null;
    }
}
