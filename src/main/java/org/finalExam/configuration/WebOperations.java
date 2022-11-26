package org.finalExam.configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class WebOperations {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebOperations(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        initElements(driver, this);
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void clickElement(WebElement element) {
        this.waitForVisibility(element);
        this.waitForClickable(element);
        element.click();
    }

    public void waitForClickable(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void typeOnInput(WebElement element, String text) {
        this.waitForVisibility(element);
        element.sendKeys(text);
    }

    public void waitForVisibility(WebElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForInvisibility(WebElement element) {
        this.wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void mouseOver(WebElement element) {
        this.waitForVisibility(element);
        new Actions(getDriver()).moveToElement(element).perform();
    }

    public void waitForPresenceOfElement(String locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(locator)));
    }

    public void waitForPresenceOfElements(String locator) {
        this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(locator)));
    }

    public void waitForAttributeChange(WebElement element, String attribute, String value) {
        this.wait.until(ExpectedConditions.attributeToBe(element, attribute, value));
    }
}
