Feature: As a user I want to check text of the:
  main, secondary articles and link of the first headline article
  so that can help make sure the text is correct


  Background:
    Given User opens website
    When User clicks on news tab

  @finalTask
  Scenario: Check the text of main article
    And Get expected text of the main article
    Then User assert with actual article

  @finalTask
  Scenario: Check secondary article titles
    And Get the list of actual secondary article titles
    Then Assert the expected and actual secondary article titles

  @finalTask
  Scenario: Check the category link of the first headline article
    And Get expected text of the chosen tab
    Then Type chosen text in the search field and press enter
    And Get text of the expected headline the first article
    Then Assert that headline of the first article contains text of the chosen tab

