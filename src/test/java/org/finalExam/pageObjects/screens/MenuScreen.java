package org.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class which contains all 'Menu' screen elements and methods.
 */
public class MenuScreen extends BaseScreen {

    @AndroidFindBy (id = "avatarImage")
    private AndroidElement menuBanner;

    @AndroidFindBy (id = "content")
    private List<AndroidElement> menuOptions;

    @AndroidFindBy (uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").text(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalOption;

    /**
     * Constructor method, extended from {@link org.finalExam.pageObjects.screens.BaseScreen}
     * @param driver AndroidDriver
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Allows to verify that the 'Menu' screen was actually accessed.
     * @return true if the 'Banner' element is displayed in screen, otherwise false
     */
    public boolean bannerIsDisplayed() {
        return isElementAvailable(menuBanner);
    }

    /**
     * Allows to scroll to the end of the 'Menu' screen.
     * It stops either, when the 'Privacy And Legal' option is displayed, or if a maximum amount of swipes (5) was reached
     */
    public void scrollToTheScreenEnd() {
        int swipes = 0;
        int maxSwipesAmount = 5;
        while (!isPrivacyAndLegalOptionDisplayed() && swipes < maxSwipesAmount) {
            swipeVertical();
            swipes++;
        }
    }

    /**
     * Verifies if 'Privacy And Legal' option is displayed.
     * @return true if 'Privacy And Legal' option is displayed in screen, otherwise false
     */
    public boolean isPrivacyAndLegalOptionDisplayed() {
        return isElementAvailable(privacyAndLegalOption, 5);
    }

    /**
     * Verifies if all the options at the end of the 'Menu' screen are the expected ones (defined inside de method).
     * @return true if all the listed options at the end of the 'Menu' screen are the expected ones, otherwise false.
     */
    public boolean checkMenuOptions() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> isCorrect = new ArrayList<>();
        Collections.addAll(expectedOptions,
                "My Profile",
                "Property Rules",
                "Cast Compliment",
                "Link to Account",
                "Car Locator",
                "Help",
                "Privacy & Legal"
        );
        waitForVisibilityOfAll(menuOptions);
        for (int i = 0; i < menuOptions.size() ; i++) {
            isCorrect.add(menuOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !isCorrect.contains(false);
    }

    /**
     * Allows clicking in the 'Privacy And Legal' option for displaying all available categories.
     * @return {@link org.finalExam.pageObjects.screens.PrivacyAndLegalScreen}
     */
    public PrivacyAndLegalScreen clickOnPrivacyAndLegalOption() {
        super.click(privacyAndLegalOption);
        return new PrivacyAndLegalScreen(getDriver());
    }
}
