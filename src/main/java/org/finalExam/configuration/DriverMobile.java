package org.finalExam.configuration;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Class for the Mobile Driver.
 */
public class DriverMobile {
    private final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method.
     */
    public DriverMobile(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    /**
     * Allows to get the Web Driver.
     * @return WebDriver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
