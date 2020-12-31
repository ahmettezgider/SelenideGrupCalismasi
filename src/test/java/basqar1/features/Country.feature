Feature: Country functionality

  Scenario: Login to basqar
    Given user logged in to basqar
    When  user navigate to countries page
    Then  countries page should be visible

    Given user click to AddButton on country page

    When user create a country as follows
      | Country-002 | Code-001 |

    Then creation should be successful


