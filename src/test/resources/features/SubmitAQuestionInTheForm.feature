Feature: As a user I want to check that can't submit a question in the form with negative scenarios
  so that can help make sure the validation is correct

  Background:
    Given User opens website
    When User clicks on news tab
    And User clicks on Coronavirus tab
    Then User clicks on Your Coronavirus Stories
    And User clicks on How to share with BBC news

  @finalTask
  Scenario: Verifies that user can not submit a question in the form
    When User clicks on Submit button
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page
    And Get the error messages
    Then User assert that error messages are displayed

  @finalTask
  Scenario: Verifies that user can not submit with one checked required checkbox I am over 16 years old
    Then User check required checkbox I am over 16 years old
    When User clicks on Submit button
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page
    And Get the error messages
    Then User assert that error messages are displayed

  @finalTask
  Scenario Outline: Verifies that user can`t submit with all checked required checkboxes and with not empty story or name
    Then User fill some <story> or <name> in the fields
    And User checks all required checkboxes
    When User clicks on Submit button
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page
    And Get the error messages
    Then User assert that error messages are displayed
    Examples:
      | story           | name           |
      | type some story |                |
      |                 | type some name |