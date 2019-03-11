Feature: Find specific url on given number of search result pages

  Scenario Outline: Verify that there is expected domain on search results pages
    Given user navigate to <url>
    When user type <search_query> into search input
    Then user search <expected_domain> until pagination page number <page_number>
    Examples:
      | url                     | search_query | expected_domain                    | page_number |
      | https://www.google.com/ | automation   | https://www.testautomationday.com/ | 5           |

