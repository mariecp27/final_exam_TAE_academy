package org.finalExam.tests.stepsDefinitions.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExam.pageObjects.pages.HomePage;
import org.finalExam.pageObjects.pages.WatchPage;
import org.finalExam.reporting.Reporter;
import org.finalExam.utils.data.WebData;
import org.testng.Assert;

public class WebStepDefinitions {

    private HomePage homePage;
    private WatchPage watchPage;
    private static String email;

    @Given("I am in the ESPN website home page")
    public void iAmInTheESPNWebsiteHomePage() {
        homePage = new HomePage(WebHooks.getDriver());
        homePage.closeBanner();
    }

    @Given("I am in the Log In modal")
    public void iAmInTheLogInModal() {
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

    @And("Enter all information for signing up")
    public void enterAllInformationForSigningUp() {
        email = homePage.setEmail();
        homePage.typeOnFirstNameInput(WebData.returnData("user"));
        homePage.typeOnLastNameInput(WebData.returnData("user"));
        homePage.typeOnEmailInputForSignUp(email);
        homePage.typeOnPasswordInputForSignUp(WebData.returnData("password"));
        homePage.mouseOverSignUpForSignUpButtonIframe();
        homePage.clickOnSignUpForSignUpButtonIframe();
        homePage.goOutFromIframe();
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        homePage.waitForLogin();
        homePage.mouseOverUserIcon();
        Reporter.info("Verifying the account was properly created");
        Assert.assertEquals(homePage.getWelcomeText(), WebData.returnData("welcomeText"), "Account was not created");
        homePage.clickOnLogoutLinkInHomePage();
        homePage.waitForLogout();
    }

    @Given("I am logged")
    public void iAmLogged() {
        homePage.generalLoginProcedure(WebData.returnData("emailForLoggingIn"), WebData.returnData("password"));
    }

    @When("I go to the Watch page")
    public void iGoToTheWatchPage() {
        watchPage = homePage.goToWatchPage();
    }

    @Then("The page elements should be properly displayed")
    public void thePageElementsShouldBeProperlyDisplayed() {
        Reporter.info("Verifying all cards in the second carousel have a title");
        Assert.assertTrue(watchPage.checkAllCardsTitle(), "Not all cards in the second carousel have a title");
        Reporter.info("Verifying all cards in the second carousel have a description");
        Assert.assertTrue(watchPage.checkAllCardsDescription(), "Not all cards in the second carousel have a description");
        watchPage.clickCard();
        Reporter.info("Verifying Close button is visible");
        Assert.assertTrue(watchPage.closeButtonModalIsDisplayed(), "Close button is not visible");
        watchPage.clickOnCloseButtonModal();
    }

    @And("I should be able to return to the Home page")
    public void iShouldBeAbleToReturnToTheHomePage() {
        watchPage.returnToHomePage();
        Reporter.info("Verifying it has been returned to the Home page");
        Assert.assertTrue(homePage.userIconIsDisplayed(), "It has not been returned to the Home page");
    }

    @When("I move the mouse over the User Icon")
    public void iMoveTheMouseOverTheUserIcon() {
        homePage.mouseOverUserIcon();
    }

    @Then("The welcome text is displayed along with my name")
    public void theWelcomeTextIsDisplayedAlongWithMyName() {
        Reporter.info("Verifying the welcome text was properly displayed");
        Assert.assertEquals(homePage.getWelcomeText(), WebData.returnData("welcomeText"), "The welcome text was not properly displayed");
    }

    @When("I log out")
    public void iLogOut() {
        homePage.mouseOverUserIcon();
        homePage.clickOnLogoutLinkInHomePage();
        homePage.waitForLogout();
    }

    @Then("The welcome text is displayed without my name")
    public void theWelcomeTextIsDisplayedAlongWithoutMyName() {
        homePage.mouseOverUserIcon();
        Reporter.info("Verifying the welcome text was properly displayed");
        Assert.assertEquals(homePage.getWelcomeText(), "Welcome!", "The welcome text was not properly displayed");
    }
}
