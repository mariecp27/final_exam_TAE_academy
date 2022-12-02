package org.finalExam.pageObjects.pages;

import org.finalExam.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;

/**
 * Base class for all web page objects.
 */
public class BasePage extends WebOperations {

    /**
     * Constructor method.
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }
}