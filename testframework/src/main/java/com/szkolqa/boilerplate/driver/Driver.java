package com.szkolqa.boilerplate.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.util.concurrent.TimeUnit;

public class Driver {
    public WebDriver driver;

    public WebDriver initialize(String browser) {
        if (browser.equalsIgnoreCase("Chrome")) {
            return getChromeDriver();
        }
        if (browser.equalsIgnoreCase("InternetExplorer")) {
            return getInternetExplorerDriver();
        }
        if (browser.equalsIgnoreCase("Firefox")) {
            return getFirefoxDriver();
        } else {
            return getChromeDriver();
        }
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        return driver;
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        return driver;
    }

    private WebDriver getInternetExplorerDriver() {
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.ignoreZoomSettings();
        WebDriverManager.iedriver().setup();
        driver = new InternetExplorerDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        return driver;
    }
}
