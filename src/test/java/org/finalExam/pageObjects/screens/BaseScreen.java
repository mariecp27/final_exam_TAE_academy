package org.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.finalExam.configuration.mobile.MobileOperations;

/**
 * Base class for all mobile page objects.
 */
public abstract class BaseScreen extends MobileOperations {

    /**
     * Constructor method.
     * @param driver AndroidDriver
     */
    public BaseScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
}
