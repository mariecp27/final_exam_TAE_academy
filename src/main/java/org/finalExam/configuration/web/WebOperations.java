package org.finalExam.configuration.web;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Class for defining all common operations in web application.
 */
public abstract class WebOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final long waitDuration = 15L;

    /**
     * Constructor method.
     * Allows to:
     * <ul>
     *     <li>Receive the Web Driver</li>
     *     <li>Define general wait duration</li>
     *     <li>Initialize web elements</li>
     * </ul>
     * @param driver WebDriver
     */
    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
        initElements(driver, this);
    }

    /**
     * Allows to get the Web Driver.
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Wrapper for click event.
     * @param element WebElement
     */
    public void clickElement(WebElement element) {
        this.waitForVisibility(element);
        this.waitForClickable(element);
        element.click();
    }

    /**
     * Allows to wait for an element to be clickable before perform the action.
     * @param element WebElement
     */
    public void waitForClickable(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Wrapper for sendKeys event.
     * @param element WebElement
     * @param text String
     */
    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    /**
     * Allows to wait for an element to be visible.
     * @param element WebElement
     */
    public void waitForVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Allows to move the mouse over a given element.
     * @param element WebElement
     */
    public void mouseOver(WebElement element) {
        this.waitForVisibility(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }

    /**
     * Allows to wait for an element to be present on the DOM of the page.
     * @param locator String
     */
    public void waitForPresenceOfElement(String locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    /**
     * Allows to wait for an element to be present on the DOM of the page during a custom period of time (in seconds).
     * @param locator String
     * @param timeout long
     */
    public void waitForPresenceOfElement(String locator, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    /**
     * Allows to wait for a list of element to be present on the DOM of the page.
     * @param locator String
     */
    public void waitForPresenceOfElements(String locator) {
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
    }

    /**
     * Allows to wait for an element attribute to change to a given value.
     * @param element WebElement
     * @param attribute String
     * @param value String
     */
    public void waitForAttributeChange(WebElement element, String attribute, String value) {
        this.wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }
}
