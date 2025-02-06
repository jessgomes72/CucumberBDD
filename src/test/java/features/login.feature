Feature: Login Feature

  Background: User should be on demo site
    Given user should be on demo Guru site
    #And user navigates to Bank Project
    #new changes
    #second change
  Scenario: TC-101 User should be able to login with valid UserName and valid Password

    When user enters valid userName
    And user enters valid password
    And user click on login button
    Then user successfully logged in


  Scenario Outline: TC-102 User should not be able to login with any invalid UserName and/or Password
    When user enters <userName>
    And user enter <password>
    And user click on login button
    Then user fails to log in

    Examples:

      | userName      | password     |
      | "mngr598378"   | "gebUjurX"   |
      | "mng554366X"  | "YhUhYjA"    |
      | "mng554366X"  | "gebUjurX"   |


