package org.finalExam.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which contains all 'Privacy & Legal' screen elements and methods.
 */
public class PrivacyAndLegalScreen extends BaseScreen {

    @AndroidFindBy (id = "txt_element")
    private List<AndroidElement> privacyAndLegalOptions;

    /**
     * Constructor method, extended from {@link org.finalExam.pageObjects.screens.BaseScreen}
     * @param driver AndroidDriver
     */
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * Allows to verify if a given option belongs to the listed options in the 'Privacy & Legal' screen.
     * @return true if the given option is displayed in screen, otherwise false.
     */
    public boolean checkPrivacyAndLegalOptions(String option) {
        List<Boolean> isOption = new ArrayList<>();
        waitForVisibilityOfAll(privacyAndLegalOptions);
        privacyAndLegalOptions.stream().forEach(element -> {
            isOption.add(element.getText().equals(option));
        });
        return isOption.contains(true);
    }

    /**
     * @return true if 'Privacy Policy' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean privacyPolicyOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Privacy Policy");
    }

    /**
     * @return true if 'Terms of Use' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean termsOfUseOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Terms of Use");
    }

    /**
     * @return true if 'Supplemental Terms and Conditions' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean supplementalTermsAndConditionsOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Supplemental Terms and Conditions");
    }

    /**
     * @return true if 'Legal Notices' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean legalNoticesOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Legal Notices");
    }

    /**
     * @return true if 'Property Rules' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean propertyRulesOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Property Rules");
    }

    /**
     * @return true if 'Electronic Communications Disclosure' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean electronicCommunicationsDisclosureOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Electronic Communications Disclosure");
    }

    /**
     * @return true if 'Your California Privacy Rights' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean yourCaliforniaPrivacyRightsOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Your California Privacy Rights");
    }

    /**
     * @return true if 'Do Not Sell My Personal Information' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean doNotSellMyPersonalInformationOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("Do Not Sell My Personal Information");
    }

    /**
     * @return true if 'In-App Maps Subject to Google Terms and Conditions' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean inAppMapsSubjectToGoogleTermsAndConditionsOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("In-App Maps Subject to Google Terms and Conditions");
    }

    /**
     * @return true if 'In-App Maps Subject to Google Privacy Policy' option is displayed in the screen and belongs to the 'Privacy & Legal' menu, otherwise false.
     */
    public boolean inAppMapsSubjectToGooglePrivacyPolicyOptionIsDisplayed() {
        return checkPrivacyAndLegalOptions("In-App Maps Subject to Google Privacy Policy");
    }
}
