package org.finalExam.tests.stepsDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExam.configuration.DriverWeb;
import org.finalExam.pageObjects.pages.HomePage;
import org.finalExam.reporting.Reporter;
import org.testng.Assert;

import static java.lang.String.format;

public class espnWebStepdefs {

    private static DriverWeb driver;
    private HomePage homePage;
    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private final String USER = "Test";
    private static String email;
    private final String PASSWORD = "testpassword2022";
    private final String USER_WELCOME = "Welcome" + USER + "!";


    @Before
    public void scenarioSetUp() {
        driver = new DriverWeb();
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
    }

    @After
    public void tearDown() {
        driver.getDriver().quit();
    }

    @Given("I am in the ESPN website home page")
    public void iAmInTheESPNWebsiteHomePage() {
        Reporter.info(format("Navigating to %s", URL));
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());
        homePage.closeBanner();
    }

    @When("I select the Log In option")
    public void iSelectTheLogInOption() {
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginLinkInHomePage();
        homePage.switchToIframe();
    }

    @Then("The Log In modal and its elements should be displayed")
    public void theLoginModalAndItsElementsShouldBeDisplayed() {
        Reporter.info("Verifying the login modal is visible");
        Assert.assertTrue(homePage.modalIsDisplayed(), "Log in modal is not visible");

        Reporter.info("Verifying the ESPN logo is visible");
        Assert.assertTrue(homePage.espnLogoIsDisplayed(), "ESPN logo is not visible");

        Reporter.info("Verifying the Log In button is visible");
        Assert.assertTrue(homePage.loginButtonIsDisplayed(), "Log In button is not visible");

        Reporter.info("Verifying the Sign Up button is visible");
        Assert.assertTrue(homePage.signUpButtonIsDisplayed(), "Sign Up button is not visible");
    }

    @When("I click on the Sing Up button")
    public void iClickOnTheSingUpButton() {
        homePage.clickOnSignUpButtonIframe();
    }

    @Then("All the elements for the Sign Up procedure should be displayed")
    public void allTheElementsForTheSignUpProcedureShouldBeDisplayed() {
        Reporter.info("Verifying the Sign Up title is visible");
        Assert.assertTrue(homePage.signUPTitleIsDisplayed(), "Sign Up title is not visible");

        Reporter.info("Verifying the First Name input is visible");
        Assert.assertTrue(homePage.firstNameInputIsDisplayed(), "First Name input is not visible");

        Reporter.info("Verifying the Last Name input is visible");
        Assert.assertTrue(homePage.lastNameInputIsDisplayed(), "Last Name input is not visible");

        Reporter.info("Verifying the Email input is visible");
        Assert.assertTrue(homePage.emailInputForSignUpIsDisplayed(), "Email input is not visible");

        Reporter.info("Verifying the Password input is visible");
        Assert.assertTrue(homePage.passwordInputForSignUpIsDisplayed(), "Password input is not visible");

        Reporter.info("Verifying the Sign Up button is visible");
        Assert.assertTrue(homePage.signUpButtonForSignUpIsDisplayed(), "Sign Up button is not visible");

        Reporter.info("Verifying the Close button is visible");
        Assert.assertTrue(homePage.closeIframeButtonIsDisplayed(), "Close button is not visible");
    }
}
