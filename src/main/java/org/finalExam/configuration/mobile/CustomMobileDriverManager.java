package org.finalExam.configuration.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Class for the Mobile Driver.
 */
public class CustomMobileDriverManager {
    private final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method.
     */
    public CustomMobileDriverManager(AndroidDriver<AndroidElement> driver) {
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
