package org.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Class which contains all 'DashBoard' screen elements and methods.
 */
public class DashBoardScreen extends BaseScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;

    @AndroidFindBy(id = "android:id/button2")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"Map, Tab, 2of5\")")
    private AndroidElement mapButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"More Options, Tab, 5of5\")")
    private AndroidElement menuButton;

    @AndroidFindBy(id = "tab_animated_icon")
    private AndroidElement addPlansButton;

    /**
     * Constructor method, extended from {@link org.finalExam.pageObjects.screens.BaseScreen}
     * @param driver AndroidDriver
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Allows closing possible alerts in the 'DashBoard' screen and selecting a certain option from those listed in the bottom bar.
     * @param option AndroidElement
     * @author Hans.Marquez
     */
    public void navigateToOption(AndroidElement option) {
        if (this.isElementAvailable(dismissWelcome, 25)){
            click(dismissWelcome);
        }
        if (this.isElementAvailable(dismissPreferenceUpdateButton, 25)){
            click(dismissPreferenceUpdateButton);
        }
        click(option);
    }

    /**
     * Navigate to 'Map' screen from 'DashBoard'.
     * @return {@link org.finalExam.pageObjects.screens.MapScreen}
     */
    public MapScreen goToMapScreen() {
        navigateToOption(mapButton);
        return new MapScreen(getDriver());
    }

    /**
     * Navigate to 'Menu' screen from 'DashBoard'.
     * @return {@link org.finalExam.pageObjects.screens.MenuScreen}
     */
    public MenuScreen goToMenuScreen() {
        navigateToOption(menuButton);
        return new MenuScreen(getDriver());
    }

    /**
     * Navigate to 'Add Plans' screen from 'DashBoard'.
     * @return {@link org.finalExam.pageObjects.screens.AddPlansScreen}
     */
    public AddPlansScreen goToAddPlansScreen() {
        navigateToOption(addPlansButton);
        return new AddPlansScreen(getDriver());
    }
}
