Feature: As a trainer I want to see your successful project so that improve your own skills

  @finalTask
  Scenario: Check the article
    Given User opens website
    When User clicks on news
    And Get expected text of the article
    Then User assert with actual article

  @finalTask
  Scenario: Check secondary article titles
    Given User opens website
    When User clicks on news
    And Get the list of actual secondary article titles
    Then Assert the expected and actual secondary article titles

  @finalTask
  Scenario: Check the category link of the first headline article
    Given User opens website
    When User clicks on news
    And Get expected text of the chosen tab
    Then Type chosen text in the search field and press enter
    And Get text of the expected headline the first article
    Then Assert that headline of the first article contains text of the chosen tab

  @finalTask
  Scenario: Verifies that user can not submit a question in the form
    Given User opens website
    When User clicks on news
    And User clicks on Coronavirus tab
    Then User clicks on Your Coronavirus Stories
    And User clicks on How to share with BBC news
    When User clicks on Submit button
    And Get the errors
    Then User assert that errors are displayed
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page

  @finalTask
  Scenario: Verifies that user can not submit with one checked required checkbox I am over 16 years old
    Given User opens website
    When User clicks on news
    And User clicks on Coronavirus tab
    Then User clicks on Your Coronavirus Stories
    And User clicks on How to share with BBC news
    Then User check required checkbox I am over 16 years old
    When User clicks on Submit button
    And Get the errors
    Then User assert that errors are displayed
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page

  @finalTask
  Scenario: Verifies that user can not submit with all checked required checkboxes and with not empty name
    Given User opens website
    When User clicks on news
    And User clicks on Coronavirus tab
    Then User clicks on Your Coronavirus Stories
    And User clicks on How to share with BBC news
    Then User fill some "name" in the field Name
    And User checks all required checkboxes
    When User clicks on Submit button
    And Get the errors
    Then User assert that errors are displayed
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page

  @finalTask
  Scenario: Verifies that user can not submit with all required checkboxes and empty Name field but not empty Story field
    Given User opens website
    When User clicks on news
    And User clicks on Coronavirus tab
    Then User clicks on Your Coronavirus Stories
    And User clicks on How to share with BBC news
    Then User enter some "story" in the Story field
    And User checks all required checkboxes
    When User clicks on Submit button
    And Get the errors
    Then User assert that errors are displayed
    And Get the title of actual page
    Then User assert the actual and expected titles of the displayed page

  @finalTask
  Scenario Outline: The team scores should be displayed correctly
    Given User opens website
    When User clicks on Sport page
    Then User clicks on Football page
    And User clicks on scores and fixtures
    Then User type in the search the name of <championship>
    And Check that scores is displayed correctly with typing: <first score>, <second score>, <first team>, <second team>, <month and year>

    Examples:
      | championship          | first score | second score | first team   | second team       | month and year |
      | Scottish Championship | 5           | 1            | Dunfermline  | Partick Thistle   | 2019 November  |
      | National League       | 2           | 0            | Notts County | Barnet            | 2020 July      |
      | Europa League         | 0           | 5            | LASK         | Manchester United | 2020 March     |
      | Premier League        | 0           | 2            | Burnley      | Crystal Palace    | 2019 November  |
      | England Football Team | 0           | 4            | Kosovo       | England           | 2019 November  |
