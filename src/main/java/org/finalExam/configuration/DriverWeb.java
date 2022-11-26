package org.finalExam.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverWeb {
    private WebDriver driver;

    public DriverWeb() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}
