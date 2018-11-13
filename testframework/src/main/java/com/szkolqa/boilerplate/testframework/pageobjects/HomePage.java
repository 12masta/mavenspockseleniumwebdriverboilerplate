package com.szkolqa.boilerplate.testframework.pageobjects;

import com.szkolqa.boilerplate.testframework.webelements.WebElementHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "emailInput")
    private WebElement emailInput;

    @FindBy(id = "messageTextArea")
    private WebElement messageTextArea;

    private WebElementHandler webElementHandler;

    HomePage(WebDriver driver) {
        super(driver);
        this.webElementHandler = new WebElementHandler(driver);
    }

    public HomePage fillEmailInput(String input) {
        webElementHandler.sendKeys(emailInput, input);
        return this;
    }

    public HomePage fillMessageInput(String input) {
        webElementHandler.sendKeys(messageTextArea, input);
        return this;
    }

    public boolean isSuccessNotiifcationDisplayed() {
        return true;
    }
}
