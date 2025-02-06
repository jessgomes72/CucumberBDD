Feature: New Customer

  Background: User should be on demo site
    Given user should be on demo Guru site
    And user log in with valid username and password


  Scenario: NC1 Verify Name Field (Name cannot be empty)

    When user does not enter a value in NAME Field
    And user press TAB and move to next Field
    Then An error message Customer name must not be blank must appear

  Scenario Outline: NC2 Verify Name Field (Name cannot be numeric)

    When user enters numeric <value> in NAME Field
    Then An error message Numbers are not allowed must appear

    Examples:

      | value |
      | "1234" |
      | "name123"|


  Scenario Outline: NC3 Verify Name Field (Name cannot have special characters)

    When user enters special <characters> in NAME Field
    Then An error message Special characters are not allowed must appear

    Examples:

      | characters |
      | "name!@#" |
      | "!@#" |


  Scenario: NC4 Verify Name Field (Name cannot have first characters as blank space)

    When user enters first character Blank Space in NAME Field
    Then An error message First characters cannot be space must appear beside Name field


  Scenario: NC5 Verify Address Field (Address can not be empty)
  //do I have to create new method again

    When user does not enter a value in ADDRESS Field
    And user press TAB and move to next Field
    Then An error message Address can not be empty must appear

  Scenario: NC6 Verify Address Field (Address cannot have first characters as blank space)

    When user enters first character Blank Space in ADDRESS Field
    Then An error message First characters cannot be space must appear beside Address field

  Scenario: NC8 Verify City Field (City cannot be empty)

    When user does not enter a value in CITY Field
    And user press TAB and move to next Field
    Then An error message City must not be blank must appear

  Scenario Outline: NC9 Verify City Field (cityNumbersNotAllowed;)

    When user enters numeric <value> in CITY Field
    Then An error message Numbers are not allowed must appear beside City field

    Examples:

      | value |
      | "1234" |
      | "city123"|


  Scenario Outline: NC10 Verify City Field (City cannot have special characters)

    When user enters special <characters> in CITY Field
    Then An error message Special characters are not allowed must appear for City Field

    Examples:

      | characters |
      | "City!@#" |
      | "!@#" |


  Scenario: NC11 Verify City Field (City cannot have first characters as blank space)

    When user enters first character Blank Space in CITY Field
    Then An error message First characters cannot be space must appear beside City field