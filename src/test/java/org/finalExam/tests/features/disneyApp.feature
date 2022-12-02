@mobileAutomation
Feature: Disney app performance review
  In order to verify several features in the Disney app
  As a Disney app user
  I want to navigate to several sections in the application

  Background:
    Given I am in the Dashboard view

  Scenario: Verify Map view
    Given I am in the Map view
    Then The Map view and its elements should be displayed

  Scenario: Verify Category List
    Given I am in the Map view
    When I tap on the Category List button
    Then Different categories, including Hotels option, should be displayed