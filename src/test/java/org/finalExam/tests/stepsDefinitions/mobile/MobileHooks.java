package org.finalExam.tests.stepsDefinitions.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.finalExam.configuration.mobile.CustomMobileDriverManager;
import org.finalExam.utils.capabilities.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for Mobile automation hooks.
 */
public class MobileHooks {

    private static CustomMobileDriverManager driver;

    /**
     * Before hook for initializing the driver.
     */
    @Before
    public void environmentSetUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ConfigCapabilities.deviceSetUp(capabilities);
        ConfigCapabilities.applicationSetUp(capabilities);
        try {
            driver = new CustomMobileDriverManager(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * After hook for closing the app.
     */
    @After
    public void tearDown() {
        driver.getDriver().quit();
    }

    /**
     * Allow to get the current driver instance.
     * @return Current AndroidDriver instance
     */
    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }
}
