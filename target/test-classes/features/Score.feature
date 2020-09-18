Feature: As a user I want to see the team scores so that can be verified that team scores display correctly

  Scenario Outline: The team scores should be displayed correctly
    Given User opens website bbc.com
    When User clicks on Sport page
    And Wait for close pop up
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




