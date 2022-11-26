Feature: ESPN procedure review
  In order to verify several features in the ESPN website
  As a ESPN website user
  I want to log in successfully and navigate to other pages

  Background:
    Given I am in the ESPN website home page

  Scenario: Verify the Log in modal elements
    Given I am in the Log In modal
    Then The Log In modal and its elements should be displayed

  Scenario: Verify Sign Up modal elements
    Given I am in the Log In modal
    When I click on the Sing Up button
    Then All the elements for the Sign Up procedure should be displayed

  Scenario: Create an account
    Given I am in the Log In modal
    When I click on the Sing Up button
    And Enter all information for signing up
    Then I should be logged in

  Scenario: Navigate to Watch page
    Given I am logged
    When I go to the Watch page
    Then The page elements should be properly displayed
    And I should be able to return to the Home page

  Scenario: Verify Welcome texts when logged
    Given I am logged
    When I move the mouse over the User Icon
    Then The welcome text is displayed along with my name

  Scenario: Verify Welcome texts when logged out
    Given I am logged
    When I log out
    Then The welcome text is displayed along without my name
