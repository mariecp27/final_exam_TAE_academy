package org.finalExam.pageObjects.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class which contains all 'Home' page elements and methods.
 */
public class HomePage extends BasePage {

    @FindBy (css = ".promo-banner-container iframe")
    private WebElement iframeBanner;

    @FindBy (css = "section.PromoBanner")
    private WebElement banner;

    @FindBy (css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    @FindBy (id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy (id = "sideLogin-left-rail")
    private WebElement loginBox;

    @FindBy (css = "li.user > div.global-user:last-child")
    private WebElement userOptionsContainer;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginLinkInHomePage;

    @FindBy (css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement logOutLinkInHomePage;

    @FindBy (id = "oneid-iframe")
    private WebElement iframe;

    @FindBy (css = "div.view-starry-night > div:first-child")
    private WebElement loginModalIframe;

    @FindBy (id = "logo")
    private WebElement espnLogoIframe;

    @FindBy (id = "InputLoginValue")
    private WebElement emailInputIframe;

    @FindBy (id = "InputPassword")
    private WebElement passwordInputIframe;

    @FindBy (css = "h2#Title span")
    private WebElement signUpTitleIframe;

    @FindBy (id = "InputFirstName")
    private WebElement firstNameInputIframe;

    @FindBy (id = "InputLastName")
    private WebElement lastNameInputIframe;

    @FindBy (id = "InputEmail")
    private WebElement emailForSignUpInputIframe;

    @FindBy (id = "password-new")
    private WebElement passwordForSignUpInputIframe;

    @FindBy (id = "BtnSubmit")
    private WebElement loginButtonIframe;

    @FindBy (id = "BtnCreateAccount")
    private WebElement signUpButtonIframe;

    @FindBy (id = "BtnSubmit")
    private WebElement signUpButtonForSignUpIframe;

    @FindBy (id = "close")
    private WebElement closeIframeButton;

    @FindBy (css = "li.pillar.watch > a")
    private WebElement watchLink;

    @FindBy (css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeText;

    /**
     * Constructor method, extended from {@link org.finalExam.pageObjects.pages.BasePage}
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Allows to verify if the promo banner in the 'Home' page is displayed.
     * @return true if the promo banner is displayed, otherwise false
     */
    public boolean verifyBannerIframe() {
        boolean isBanner = true;
        try {
            super.waitForPresenceOfElement(".promo-banner-container iframe", 5);
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    /**
     * Allows to close the promo banner in the 'Home' page if it is displayed.
     */
    public void closeBanner() {
        if (this.verifyBannerIframe()) {
            super.getDriver().switchTo().frame(this.iframeBanner);
            super.waitForVisibility(this.banner);
            super.clickElement(this.bannerCloseButton);
            this.goOutFromIframe();
        }
    }

    /**
     * Allows to wait for the page to reload once a user has logged in.
     */
    public void waitForLogin() {
        super.waitForPresenceOfElement("#sideLogin-left-rail");
        super.waitForAttributeChange(loginBox, "style", "display: none;");
    }

    /**
     * Allows to wait for the page to reload once a user has logged out.
     */
    public void waitForLogout() {
        super.waitForPresenceOfElement("#sideLogin-left-rail");
        super.waitForAttributeChange(loginBox, "style", "display: block;");
    }

    /**
     * Allows to verify if the User icon is displayed.
     * @return true if the User icon is displayed, otherwise false
     */
    public boolean userIconIsDisplayed() {
        super.waitForVisibility(this.userIcon);
        return this.userIcon.isDisplayed();
    }

    /**
     * Performs a mouse over action on the User icon.
     */
    public void mouseOverUserIcon() {
        super.mouseOver(this.userIcon);
        super.waitForVisibility(this.userOptionsContainer);
    }

    /**
     * Allows to click on the Login option.
     */
    public void clickOnLoginLinkInHomePage() {
        super.clickElement(this.loginLinkInHomePage);
    }

    /**
     * Allows to click on the Logout option.
     */
    public void clickOnLogoutLinkInHomePage() {
        super.clickElement(this.logOutLinkInHomePage);
    }

    /**
     * Allows to change the test context to the Login/Sign Up iframe.
     */
    public void switchToIframe() {
        super.getDriver().switchTo().frame(this.iframe);
    }

    /**
     * Allows to change the test context to the 'Home' page.
     */
    public void goOutFromIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    /**
     * Verifies if the Login modal is displayed.
     * @return true if the Login modal is displayed, otherwise false
     */
    public boolean modalIsDisplayed() {
        super.waitForVisibility(this.loginModalIframe);
        return this.loginModalIframe.isDisplayed();
    }

    /**
     * Verifies if the ESPN logo in the Login modal is displayed.
     * @return true if the ESPN Logo in the Login modal is displayed, otherwise false
     */
    public boolean espnLogoIsDisplayed() {
        super.waitForVisibility(this.espnLogoIframe);
        return this.espnLogoIframe.isDisplayed();
    }

    /**
     * Verifies if the Login button in the Login modal is displayed.
     * @return true if the Login button in the Login modal is displayed, otherwise false
     */
    public boolean loginButtonIsDisplayed() {
        super.waitForVisibility(this.loginButtonIframe);
        return this.loginButtonIframe.isDisplayed();
    }

    /**
     * Verifies if the Sign-Up button in the Login modal is displayed.
     * @return true if the Sign-Up button in the Login modal is displayed, otherwise false
     */
    public boolean signUpButtonIsDisplayed() {
        super.waitForVisibility(this.signUpButtonIframe);
        return this.signUpButtonIframe.isDisplayed();
    }

    /**
     * Allows to write a given String in the Email input located in the Login modal.
     * @param text String
     */
    public void typeOnEmailInput(String text) {
        super.waitForVisibility(this.emailInputIframe);
        super.typeOnInput(this.emailInputIframe, text);
    }

    /**
     * Allows to write a given String in the Password input located in the Login modal.
     * @param text String
     */
    public void typeOnPasswordInput(String text) {
        super.waitForVisibility(this.passwordInputIframe);
        super.typeOnInput(this.passwordInputIframe, text);
    }

    /**
     * Verifies if the Title in the Sign-Up modal is displayed.
     * @return true if the Title in the Sign-Up modal is displayed, otherwise false
     */
    public boolean signUPTitleIsDisplayed() {
        super.waitForVisibility(this.signUpTitleIframe);
        return this.signUpTitleIframe.isDisplayed();
    }

    /**
     * Verifies if the First Name input in the Sign-Up modal is displayed.
     * @return true if the First Name input in the Sign-Up modal is displayed, otherwise false
     */
    public boolean firstNameInputIsDisplayed() {
        super.waitForVisibility(this.firstNameInputIframe);
        return this.firstNameInputIframe.isDisplayed();
    }

    /**
     * Verifies if the Last Name input in the Sign-Up modal is displayed.
     * @return true if the Last Name input in the Sign-Up modal is displayed, otherwise false
     */
    public boolean lastNameInputIsDisplayed() {
        super.waitForVisibility(this.lastNameInputIframe);
        return this.lastNameInputIframe.isDisplayed();
    }

    /**
     * Verifies if the Email input in the Sign-Up modal is displayed.
     * @return true if the Email input in the Sign-Up modal is displayed, otherwise false
     */
    public boolean emailInputForSignUpIsDisplayed() {
        super.waitForVisibility(this.emailForSignUpInputIframe);
        return this.emailForSignUpInputIframe.isDisplayed();
    }

    /**
     * Verifies if the Password input in the Sign-Up modal is displayed.
     * @return true if the Password input in the Sign-Up modal is displayed, otherwise false
     */
    public boolean passwordInputForSignUpIsDisplayed() {
        super.waitForVisibility(this.passwordForSignUpInputIframe);
        return this.passwordForSignUpInputIframe.isDisplayed();
    }

    /**
     * Verifies if the Sign-Up button in the Sign-Up modal is displayed.
     * @return true if the Sign-Up button in the Sign-Up modal is displayed, otherwise false
     */
    public boolean signUpButtonForSignUpIsDisplayed() {
        super.waitForVisibility(this.signUpButtonForSignUpIframe);
        return this.signUpButtonForSignUpIframe.isDisplayed();
    }

    /**
     * Verifies if the Close button in the Sign-Up modal is displayed.
     * @return true if the Close button in the Sign-Up modal is displayed, otherwise false
     */
    public boolean closeIframeButtonIsDisplayed() {
        super.waitForVisibility(this.closeIframeButton);
        return this.closeIframeButton.isDisplayed();
    }

    /**
     * Allows to write a given String in the First Name input located in the Sign-Up modal.
     * @param text String
     */
    public void typeOnFirstNameInput(String text) {
        super.waitForVisibility(this.firstNameInputIframe);
        super.typeOnInput(this.firstNameInputIframe, text);
    }

    /**
     * Allows to write a given String in the Last Name input located in the Sign-Up modal.
     * @param text String
     */
    public void typeOnLastNameInput(String text) {
        super.waitForVisibility(this.lastNameInputIframe);
        super.typeOnInput(this.lastNameInputIframe, text);
    }

    /**
     * Allows to write a given String in the Email input located in the Sign-Up modal.
     * @param text String
     */
    public void typeOnEmailInputForSignUp(String text) {
        super.waitForVisibility(this.emailForSignUpInputIframe);
        super.typeOnInput(this.emailForSignUpInputIframe, text);
    }

    /**
     * Allows to write a given String in the Password input located in the Sign-Up modal.
     * @param text String
     */
    public void typeOnPasswordInputForSignUp(String text) {
        super.waitForVisibility(this.passwordForSignUpInputIframe);
        super.typeOnInput(this.passwordForSignUpInputIframe, text);
    }

    /**
     * Allows to click on the Login button located in the Login modal.
     */
    public void clickOnLoginButtonIframe() {
        super.clickElement(this.loginButtonIframe);
    }

    /**
     * Allows to click on the Sign-Up button located in the Login modal.
     */
    public void clickOnSignUpButtonIframe() {
        super.clickElement(this.signUpButtonIframe);
    }

    /**
     * Allows to click on the Sign-Up button located in the Sign-Up modal.
     */
    public void clickOnSignUpForSignUpButtonIframe() {
        super.clickElement(this.signUpButtonForSignUpIframe);
    }

    /**
     * Allows to move the mouse over the Sign-Up button located in the Sign-Up modal.
     */
    public void mouseOverSignUpForSignUpButtonIframe() {
        super.mouseOver(this.signUpButtonForSignUpIframe);
    }

    /**
     * Allows to click on the Watch link in the 'Home' page for navigating to the 'Watch' page.
     * @return {@link org.finalExam.pageObjects.pages.WatchPage}
     */
    public WatchPage goToWatchPage() {
        super.clickElement(this.watchLink);
        return new WatchPage(super.getDriver());
    }

    /**
     * Gets the Welcome text, which os displayed while performing a mouse over action on the User icon.
     * @return String
     */
    public String getWelcomeText() {
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }

    /**
     * Allow to generate a random email for the Sign-Up procedure.
     * @return String
     */
    public String setEmail() {
        int randomValue = (int)(Math.random() * 1000);
        return  "test.new.email.espn" + randomValue + "@gmail.com";
    }

    /**
     * Performs all needed steps for logging in.
     * @param email String
     * @param password String
     */
    public void generalLoginProcedure(String email, String password) {
        this.mouseOverUserIcon();
        this.clickOnLoginLinkInHomePage();
        this.switchToIframe();
        this.typeOnEmailInput(email);
        this.typeOnPasswordInput(password);
        this.clickOnLoginButtonIframe();
        this.goOutFromIframe();
        this.waitForLogin();
    }
}
