Feature: As a user I want to verify that team scores display correctly
  Scenario: The team scores should be displayed correctly
    Given the user opens website bbc.com
    When the user clicks on News page
    Then wait for close pop up
