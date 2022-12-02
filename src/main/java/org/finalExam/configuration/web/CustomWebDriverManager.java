package org.finalExam.configuration.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Class for the Web Driver.
 */
public class CustomWebDriverManager {
    private WebDriver driver;

    /**
     * Constructor method.
     * Only Chrome browser is defined.
     */
    public CustomWebDriverManager() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    /**
     * Allows to get the Web Driver.
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return this.driver;
    }


}
