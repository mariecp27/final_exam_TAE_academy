package org.finalExam.configuration.mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Class for defining all common operations in mobile application.
 */
public abstract class MobileOperations {

    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;
    private final long waitDuration = 10L;

    /**
     * Constructor method.
     * Allows to:
     * <ul>
     *     <li>Receive the AndroidDriver</li>
     *     <li>Define general wait duration</li>
     *     <li>Initialize web elements</li>
     * </ul>
     */
    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    /**
     * Allows to get the WebDriver.
     * @return WebDriver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    /**
     * Swipe vertical for scrolling down in the screen.
     */
    public void swipeVertical() {
        Dimension windowSize = this.getDriver().manage().window().getSize();
        int x = windowSize.getWidth () / 2;
        int y = windowSize.getHeight () / 2;
        int edgeBorder = 10;
        TouchAction action = new TouchAction(this.getDriver());
        action.press(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(x, edgeBorder))
                .release()
                .perform();
    }

    /**
     * Wrapper for click event.
     * @param element AndroidElement
     */
    public void click(AndroidElement element) {
        waitForVisibility(element);
        element.click();
    }

    /**
     * Verifies if an AndroidElement is visible after certain period of time (10 seconds).
     * @param element AndroidElement
     * @return true if a given AndroidElement is visible after certain period of time (10 seconds), otherwise false.
     */
    public boolean isElementAvailable(AndroidElement element) {
        try {
            waitForVisibility(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Verifies if an AndroidElement is visible after a custom period of time (in seconds).
     * @param element AndroidElement
     * @param timeout int
     * @return true if a given AndroidElement is visible after a custom period of time (in seconds), otherwise false.
     */
    public boolean isElementAvailable(AndroidElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            waitForVisibility(element, wait);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Waits for an element to be visible during a certain period of time (10 seconds).
     * @param element AndroidElement
     */
    public void waitForVisibility(AndroidElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be visible during a custom period of time (in seconds).
     * @param element AndroidElement
     * @param wait WebDriverWait
     */
    public void waitForVisibility(AndroidElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for list of elements to be visible during a certain period of time (10 seconds).
     * @param elements List<AndroidElement>
     */
    public void waitForVisibilityOfAll(List<AndroidElement> elements) {
        elements.stream().forEach(element -> {
            waitForVisibility(element);
        });
    }
}
