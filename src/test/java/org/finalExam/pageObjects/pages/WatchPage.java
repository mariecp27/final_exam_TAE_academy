package org.finalExam.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class WatchPage extends BasePage {

    @FindBy (css = "section.Carousel")
    private List<WebElement> carousels;

    @FindBy (css = "div.Carousel__Wrapper--canScrollRight ul.Carousel__Inner li:nth-child(2) > a")
    private WebElement secondCardInCarousel;

    @FindBy (css = "section.lightbox__contentBox")
    private WebElement providerModal;

    @FindBy (css = ".lightbox__closebtn")
    private WebElement closeButtonModal;

    public WatchPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCadsInSecondCarousel() {
        return carousels.get(1).findElements(By.cssSelector("ul.Carousel__Inner li"));
    }

    public boolean checkAllCardsTitle() {
        List<Boolean> isTitle = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCadsInSecondCarousel().stream().forEach(element -> {
            isTitle.add(!element.findElement(By.cssSelector("h2.WatchTile__Title")).getText().equals(""));
        });
        return !isTitle.contains(false);
    }

    public boolean checkAllCardsDescription() {
        List<Boolean> isDescription = new ArrayList<>();
        waitForPresenceOfElements("ul.Carousel__Inner li");
        getCadsInSecondCarousel().stream().forEach(element -> {
            isDescription.add(!element.findElement(By.cssSelector(".WatchTile__Meta")).getText().equals(""));
        });
        return !isDescription.contains(false);
    }

    public void clickCard() {
        super.waitForVisibility(this.secondCardInCarousel);
        super.clickElement(this.secondCardInCarousel);
    }

    public boolean closeButtonModalIsDisplayed() {
        super.waitForVisibility(this.providerModal);
        super.waitForVisibility(this.closeButtonModal);
        return this.closeButtonModal.isDisplayed();
    }

    public void clickOnCloseButtonModal() {
        super.mouseOver(this.closeButtonModal);
        super.clickElement(this.closeButtonModal);
    }

    public HomePage returnToHomePage() {
        super.getDriver().navigate().back();
        return new HomePage(getDriver());
    }
}
