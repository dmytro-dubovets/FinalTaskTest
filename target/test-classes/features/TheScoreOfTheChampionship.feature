Feature: As a user I want to check football score on the Team page
  so that can help make sure the football scores are correct

  @finalTask
  Scenario Outline: The team scores should be displayed correctly
    Given User opens website
    When User clicks on Sport page
    Then User clicks on Football page
    And User clicks on scores and fixtures
    Then User type in the search the name of <championship>
    And Get scores on the Team page <first score>, <second score>, <first team>, <second team>, <month and year>
    Then Assert that <first score> and <second score> are equals scores on the Team page

    Examples:
      | championship          | first score | second score | first team   | second team       | month and year |
      | Scottish Championship | 5           | 1            | Dunfermline  | Partick Thistle   | 2019 November  |
      | National League       | 2           | 0            | Notts County | Barnet            | 2020 July      |
      | Europa League         | 0           | 5            | LASK         | Manchester United | 2020 March     |
      | Premier League        | 0           | 2            | Burnley      | Crystal Palace    | 2019 November  |
      | England Football Team | 0           | 4            | Kosovo       | England           | 2019 November  |