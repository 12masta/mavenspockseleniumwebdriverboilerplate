package com.szkolqa.boilerplate.testframework.webelements;

import com.szkolqa.boilerplate.testframework.wait.Wait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementHandler {
    private WebDriver driver;
    private Wait wait;

    public WebElementHandler(WebDriver driver){
        this.driver = driver;
        this.wait = new Wait(this.driver);
    }

    public WebElementHandler sendKeys(WebElement webElement, String input) {
        wait.elementToBeClickable(webElement);
        webElement.sendKeys(input);
        return this;
    }
}
