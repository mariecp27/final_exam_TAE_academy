package org.finalExam.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which contains all 'Watch' page elements and methods.
 */
public class WatchPage extends BasePage {

    @FindBy (css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCardInCarousel;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement providerModal;

    @FindBy (css = ".lightbox__closebtn")
    private WebElement closeButtonModal;

    /**
     * Constructor method, extended from {@link org.finalExam.pageObjects.pages.BasePage}
     * @param driver WebDriver
     */
    public WatchPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Allows to get all cards in the second carousel of the 'Watch' page.
     * @return List of WebElements
     */
    public List<WebElement> getCadsInSecondCarousel() {
        return carousels.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }

    /**
     * Verifies if all cards in the second carousel of the 'Watch' page have a title.
     * @return true if all cards in the second carousel of the 'Watch' page have a title, otherwise false
     */
    public boolean checkAllCardsTitle() {
        List<Boolean> isTitle = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCadsInSecondCarousel().stream().forEach(element -> {
            isTitle.add(!element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return !isTitle.contains(false);
    }

    /**
     * Verifies if all cards in the second carousel of the 'Watch' page have a description.
     * @return true if all cards in the second carousel of the 'Watch' page have a description, otherwise false
     */
    public boolean checkAllCardsDescription() {
        List<Boolean> isDescription = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCadsInSecondCarousel().stream().forEach(element -> {
            isDescription.add(!element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return !isDescription.contains(false);
    }

    /**
     * Allows to click on the second card in the first carousel of the 'Watch' page.
     */
    public void clickCard() {
        super.waitForVisibility(this.secondCardInCarousel);
        super.clickElement(this.secondCardInCarousel);
    }

    /**
     * Verifies if the Close button of the modal displayed by clicking a card is visible.
     * @return true if the Close button is displayed, otherwise false
     */
    public boolean closeButtonModalIsDisplayed() {
        super.waitForVisibility(this.providerModal);
        super.waitForVisibility(this.closeButtonModal);
        return this.closeButtonModal.isDisplayed();
    }

    /**
     * Allows to click on the Close button of the modal displayed by clicking a card.
     */
    public void clickOnCloseButtonModal() {
        super.mouseOver(this.closeButtonModal);
        super.clickElement(this.closeButtonModal);
    }

    /**
     * Allows to return to a previous page, 'Home' page in this case.
     * @return {@link org.finalExam.pageObjects.pages.HomePage}
     */
    public HomePage returnToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
