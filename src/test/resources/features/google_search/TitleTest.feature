Feature: Check title test task

  Scenario Outline: Open link on search results page and verify that title contains searched word
    Given user navigate to <url>
    When user type <search_query> into search input
    Then user click on first search <search_result_number>
    And user verify that title contains <search_query>
    Examples:
      | url                     | search_query | search_result_number |
      | https://www.google.com/ | automation   | 1                    |
      | https://www.google.com/ | selenium     | 3                    |
