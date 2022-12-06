package org.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class which contains all 'Map' screen elements and methods.
 */
public class MapScreen extends BaseScreen {

    @AndroidFindBy(id = "categoryTitle")
    private AndroidElement categoryListButton;

    @AndroidFindBy(id = "filterTitle")
    private AndroidElement filterButton;

    @AndroidFindBy(id = "toggleTitle")
    private AndroidElement showListButton;

    @AndroidFindBy (id = "categorySelectHeader")
    private AndroidElement categoryTitle;

    @AndroidFindBy (id = "facilityTypeTitle")
    private List<AndroidElement> categoryList;

    /**
     * Constructor method, extended from {@link org.finalExam.pageObjects.screens.BaseScreen}
     * @param driver AndroidDriver
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Verifies if the 'Category List' element is displayed.
     * @return true if the 'Category List' element is displayed in screen, otherwise false
     */
    public boolean categoryIsDisplayed() {
        return super.isElementAvailable(this.categoryListButton);
    }

    /**
     * Verifies if the 'Filter Button' element is displayed.
     * @return true if 'Filter Button' element is displayed in screen, otherwise false
     */
    public boolean filterIsDisplayed() {
        return super.isElementAvailable(this.filterButton);
    }

    /**
     * Verifies if the 'Show List Button' element is displayed.
     * @return true if 'Show List Button' element is displayed in screen, otherwise false
     */
    public boolean showListIsDisplayed() {
        return super.isElementAvailable(this.showListButton);
    }

    /**
     * Allows clicking in the 'Category List' element for displaying all available categories.
     */
    public void clickOnCategoryList() {
        super.click(this.categoryListButton);
    }

    /**
     * Allows to get the title of the category list
     * @return String
     */
    public String getCategoryListTitle() {
        super.isElementAvailable(this.categoryTitle);
        return this.categoryTitle.getText();
    }

    /**
     * Verifies if all the listed categories are the expected ones (defined inside de method).
     * @return true if all the listed categories are the expected ones, otherwise false
     */
    public boolean checkCategories() {
        List<String> expectedCategories = new ArrayList<>();
        List<Boolean> isCorrect = new ArrayList<>();
        Collections.addAll(expectedCategories,
                "Attractions",
                "Characters",
                "Dining",
                "Entertainment",
                "Restrooms",
                "Events and Tours",
                "PhotoPass", "Guest Services",
                "Shops",
                "Hotels",
                "Spa and Recreation"
        );
        super.waitForVisibilityOfAll(this.categoryList);
        for (int i = 0; i < this.categoryList.size() ; i++) {
            isCorrect.add(this.categoryList.get(i).getText().equals(expectedCategories.get(i)));
        }
        return !isCorrect.contains(false);
    }

    /**
     * Verifies if 'Hotels' option is displayed.
     * @return true if 'Hotels' option is displayed in the screen and belongs to the listed categories, otherwise false.
     */
    public boolean hotelsOptionIsDisplayed() {
        List<Boolean> isHotelsOption = new ArrayList<>();
        super.waitForVisibilityOfAll(this.categoryList);
        this.categoryList.stream().forEach(element -> {
            isHotelsOption.add(element.getText().equals("Hotels"));
        });
        return isHotelsOption.contains(true);
    }
}
