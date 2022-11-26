Feature: ESPN procedure review
  In order to verify several features in the ESPN website
  As a ESPN website user
  I want to log in successfully and navigate to other pages

  Background:
    Given I am in the ESPN website home page

  Scenario: Verify the Log in modal elements
    When I select the Log In option
    Then The Log In modal and its elements should be displayed

    Scenario: Create an account
      When I select the Log In option
      And I click on the Sing Up button
      Then All the elements for the Sign Up procedure should be displayed