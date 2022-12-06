package org.finalExam.tests.stepsDefinitions.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExam.pageObjects.screens.*;
import org.finalExam.reporting.Reporter;
import org.testng.Assert;

public class MobileStepsDefinition {

    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    private MapScreen mapScreen;
    private MenuScreen menuScreen;
    private PrivacyAndLegalScreen privacyAndLegalScreen;
    private AddPlansScreen addPlansScreen;

    /**
     * Allows to navigate to the app 'Dashboard' view.
     */
    @Given("I am in the Dashboard view")
    public void iAmInTheDashboardView() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoardScreen = tutorialScreen.shareLocationPermissions();
    }

    /**
     * Allows to navigate to the app 'Map' view.
     */
    @Given("I am in the Map view")
    public void iAmInTheMapView() {
        Reporter.info("Entering in the Map view");
        mapScreen = dashBoardScreen.goToMapScreen();
    }

    /**
     * Verifies if the followings elements in the 'Map' view are displayed:
     * <ul>
     *     <li>List button</li>
     *     <li>Category button</li>
     *     <li>Filter button</li>
     * </ul>
     */
    @Then("The Map view and its elements should be displayed")
    public void theMapViewAndItsElementsShouldBeDisplayed() {
        Reporter.info("Verifying Map view elements:");
        Reporter.info("Verifying List button is visible");
        Assert.assertTrue(mapScreen.showListIsDisplayed(), "List button is not visible");
        Reporter.info("Verifying Category button is visible");
        Assert.assertTrue(mapScreen.categoryIsDisplayed(), "Category button is not visible");
        Reporter.info("Verifying Filter button is visible");
        Assert.assertTrue(mapScreen.filterIsDisplayed(), "Filter button is not visible");
    }

    /**
     * Allows clicking in the 'Category List' element for displaying all available categories.
     */
    @When("I tap on the Category List button")
    public void iTapOnTheCategoryListButton() {
        mapScreen.clickOnCategoryList();
    }

    /**
     * Verifies if the 'Category list' was properly displayed.
     */
    @Then("Different categories, including Hotels option, should be displayed")
    public void differentCategoriesIncludingHotelsOptionShouldBeDisplayed() {
        Reporter.info("Verifying Category List elements:");
        Reporter.info("Category List title is visible");
        Assert.assertEquals(mapScreen.getCategoryListTitle(), "Select Category", "Category List title is not visible");
        Reporter.info("Listed categories are correct");
        Assert.assertTrue(mapScreen.checkCategories(), "Listed categories are not correct");
        Reporter.info("Hotels' option is visible");
        Assert.assertTrue(mapScreen.hotelsOptionIsDisplayed(), "Hotels' option is not visible");
    }

    /**
     * Allows to navigate to the app 'Menu' view.
     */
    @Given("I am in the Menu view")
    public void iAmInTheMenuView() {
        Reporter.info("Entering in the Menu view");
        menuScreen = dashBoardScreen.goToMenuScreen();
    }

    /**
     * Verifies if the followings elements in the 'Menu' view are displayed:
     * <ul>
     *     <li>Banner</li>
     *     <li>Options at the end of the 'Menu' view</li>
     * </ul>
     */
    @Then("The Menu view and its elements should be displayed")
    public void theMenuViewAndItsElementsShouldBeDisplayed() {
        Reporter.info("Verifying Menu view elements:");
        Reporter.info("Menu view banner is visible");
        Assert.assertTrue(menuScreen.bannerIsDisplayed(), "Menu view banner is visible");
        menuScreen.scrollToTheScreenEnd();
        Reporter.info("Menu options are properly listed");
        Assert.assertTrue(menuScreen.checkMenuOptions(), "Menu options are not properly listed");
    }

    /**
     * Allows to scroll to the 'Privacy And Legal' option and click it for displaying its menu.
     */
    @When("I select the Privacy & Legal option")
    public void iSelectThePrivacyLegalOption() {
        menuScreen.scrollToTheScreenEnd();
        Reporter.info("Displaying Privacy & Legal options");
        privacyAndLegalScreen = menuScreen.clickOnPrivacyAndLegalOption();
    }

    /**
     * Verifies if all options in 'Privacy & Legal' were properly displayed.
     */
    @Then("The Privacy & Legal options should be displayed")
    public void thePrivacyLegalOptionsShouldBeDisplayed() {
        Reporter.info("Verifying Privacy & Legal menu elements");
        Assert.assertTrue(privacyAndLegalScreen.checkPrivacyAndLegalOptions(), "Privacy & Legal options are not properly listed");
    }

    /**
     * Allows to navigate to the app 'Add Plans' view.
     */
    @When("I select the Add Plans option")
    public void iSelectTheAddPlansOption() {
        Reporter.info("Entering in the Add Plans view");
        addPlansScreen = dashBoardScreen.goToAddPlansScreen();
    }

    /**
     * Verifies if the 'Check Dining Availability' option was properly displayed.
     */
    @Then("The Check Dining Availability option should be displayed")
    public void theCheckDiningAvailabilityOptionShouldBeDisplayed() {
        Reporter.info("Check Dining Availability option is visible");
        Assert.assertTrue(addPlansScreen.checkDiningAvailabilityDisplayed(), "Check Dining Availability option is not visible");
    }
}
