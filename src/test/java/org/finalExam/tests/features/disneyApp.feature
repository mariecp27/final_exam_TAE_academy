@mobileAutomation
Feature: Disney app performance review
  In order to verify several features in the Disney app
  As a Disney app user
  I want to navigate to several sections in the application

  Background:
    Given I am in the Dashboard view

  @mobileAutomation @verifyMapView @mapView @disney
  Scenario: Verify Map view
    Given I am in the Map view
    Then The Map view and its elements should be displayed

  @mobileAutomation @verifyCategoryList @mapView @disney
  Scenario: Verify Category List
    Given I am in the Map view
    When I tap on the Category List button
    Then Different categories, including Hotels option, should be displayed

  @mobileAutomation @verifyMenuView @menuView @disney
  Scenario: Verify Menu view
    Given I am in the Menu view
    Then The Menu view and its elements should be displayed

  @mobileAutomation @verifyPrivacyView @privacyView @disney
  Scenario: Verify Privacy & Legal view
    Given I am in the Menu view
    When I select the Privacy & Legal option
    Then The Privacy & Legal options should be displayed

  @mobileAutomation @verifyAddPlansView @addPlansView @disney
  Scenario: Verify Add Plans view
    When I select the Add Plans option
    Then The Check Dining Availability option should be displayed