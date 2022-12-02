package org.finalExam.tests.stepsDefinitions.web;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.finalExam.configuration.web.CustomWebDriverManager;
import org.finalExam.utils.data.WebData;
import org.openqa.selenium.WebDriver;

/**
 * Class for Web automation hooks.
 */
public class WebHooks {

    private static CustomWebDriverManager driver;

    /**
     * Before hook for initializing the driver and goring to the 'Home' page.
     */
    @Before
    public void setUp() {
        driver = new CustomWebDriverManager();
        driver.getDriver().get(WebData.returnData("url"));
        driver.getDriver().manage().window().maximize();
    }

    /**
     * After hook for closing the browser.
     */
    @After
    public void tearDown() {
        driver.getDriver().quit();
    }

    /**
     * Allow to get the current driver instance.
     * @return Current WebDriver instance
     */
    public static WebDriver getDriver() {
        return driver.getDriver();
    }
}
