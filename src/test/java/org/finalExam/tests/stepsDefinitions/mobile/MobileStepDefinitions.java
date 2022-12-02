package org.finalExam.tests.stepsDefinitions.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExam.pageObjects.screens.DashBoardScreen;
import org.finalExam.pageObjects.screens.MapScreen;
import org.finalExam.pageObjects.screens.TutorialScreen;
import org.finalExam.reporting.Reporter;
import org.testng.Assert;

public class MobileStepDefinitions {

    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    private MapScreen mapScreen;

    @Given("I am in the Dashboard view")
    public void iAmInTheDashboardView() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoardScreen = tutorialScreen.shareLocationPermissions();
    }

    @Given("I am in the Map view")
    public void iAmInTheMapView() {
        Reporter.info("Entering in the Map view");
        mapScreen = dashBoardScreen.goToMapScreen();
    }

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

    @When("I tap on the Category List button")
    public void iTapOnTheCategoryListButton() {
        mapScreen.clickOnCategoryList();
    }

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
}
