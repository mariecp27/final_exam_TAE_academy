package org.finalExam.pageObjects.pages;

import org.finalExam.configuration.WebOperations;
import org.openqa.selenium.WebDriver;

/**
 * Base class for all page objects.
 */
public class BasePage extends WebOperations {

    /**
     * Constructor method.
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }
}
